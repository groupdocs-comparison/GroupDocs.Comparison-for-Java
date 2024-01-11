package com.groupdocs.ui.viewer.demosapitests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.ui.comparison.demosapitests.Constants;
import com.groupdocs.ui.comparison.demosapitests.common.Utils;
import com.groupdocs.ui.viewer.demosapitests.cases.Compare;
import com.groupdocs.ui.viewer.demosapitests.cases.CompareCase;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescription;
import com.groupdocs.ui.viewer.demosapitests.cases.LoadDocumentDescriptionCase;
import io.restassured.http.ContentType;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CompareApiTests {
    public static final int ERROR_MESSAGE_DATA_LENGTH = 128;
    public static final int ERROR_MESSAGE_DATA_LOOK_BACK = 16;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompareApiTests.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @DataProvider(name = "LoadDocumentDescription_DataProvider")
    public Object[][] testLoadDocumentDescription_DataProvider() throws IOException, URISyntaxException {
        final java.net.URL documentDescriptionResource = this.getClass().getResource("");
        assertThat(documentDescriptionResource).isNotNull();

        List<Object[]> caseList = new ArrayList<>();

        final Path documentDescriptionDirectory = Paths.get(documentDescriptionResource.toURI());

        for (Path filePath : Files.newDirectoryStream(documentDescriptionDirectory.resolve("loaddocumentdescriptioncases"), "*.json")) {
//            if (filePath.toString().contains("eml-"))
            caseList.add(new Object[]{filePath.toString()});
        }

        return caseList.toArray(new Object[0][]);
    }

    @Test(dataProvider = "LoadDocumentDescription_DataProvider")
    public void testLoadDocumentDescription(String caseFile) throws IOException {
        int pageNumber = 0;
        LoadDocumentDescription expectedObject = null;
        LoadDocumentDescription actualObject = null;
        final Path caseFilePath = Paths.get(caseFile);
        final LoadDocumentDescriptionCase caseObject = OBJECT_MAPPER.readValue(caseFilePath.toFile(), LoadDocumentDescriptionCase.class);
        try {
            final String sourceGuid = caseObject.getSourceGuid();
            final String sourcePassword = caseObject.getSourcePassword();
            expectedObject = caseObject.getExpectedObject();

            LOGGER.info("Case name: '{}', Document guid: '{}'", caseFilePath.getFileName().toString(), sourceGuid);

            actualObject = given()
                    .when()
                    .body(String.format("{ 'guid': '%s', 'password': '%s' }".replace('\'', '"'), sourceGuid, sourcePassword).replace("\"null\"", "null"))
                    .contentType(ContentType.JSON)
                    .post(Constants.URL_TEMPLATE, "loadDocumentDescription")
                    .then()
//                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .and().extract().body().as(LoadDocumentDescription.class);

            assertThat(actualObject).isNotNull();

            assertThat(actualObject.getGuid()).isEqualTo(expectedObject.getGuid());
            assertThat(actualObject.getPrintAllowed()).isEqualTo(expectedObject.getPrintAllowed());

            final List<LoadDocumentDescription.PageDescriptionEntity> expectedPages = expectedObject.getPages();
            final List<LoadDocumentDescription.PageDescriptionEntity> actualPages = actualObject.getPages();

            assertThat(expectedPages).isNotNull();
            assertThat(actualPages).isNotNull();

            assertThat(actualPages)
                    .as("Pages count")
                    .hasSameSizeAs(expectedPages);
            for (int n = 0; n < actualPages.size(); n++) {
                final LoadDocumentDescription.PageDescriptionEntity expectedPageDescriptionEntity = expectedPages.get(n);
                final LoadDocumentDescription.PageDescriptionEntity actualPageDescriptionEntity = actualPages.get(n);
                ;
                pageNumber = n;

                assertThat(actualPageDescriptionEntity.getAngle())
                        .as("Angle")
                        .isEqualTo(expectedPageDescriptionEntity.getAngle());
                assertThat(actualPageDescriptionEntity.getHeight())
                        .as("Height")
                        .isEqualTo(expectedPageDescriptionEntity.getHeight());
                assertThat(actualPageDescriptionEntity.getWidth())
                        .as("Width")
                        .isEqualTo(expectedPageDescriptionEntity.getWidth());
                assertThat(pageNumber)
                        .as("Number")
                        .isEqualTo(expectedPageDescriptionEntity.getNumber());

                assertThat(expectedPageDescriptionEntity.getData() == null && actualPageDescriptionEntity.getData() != null)
                        .as("Actual data must be null but was not")
                        .isFalse();
                assertThat(expectedPageDescriptionEntity.getData() != null && actualPageDescriptionEntity.getData() == null)
                        .as("Actual data must NOT be null but was")
                        .isFalse();

                if (expectedPageDescriptionEntity.getData() != null) {
                    final String expectedData = Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData());
                    final String actualData = Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData());

                    final float diff = Utils.differenceOfStrings(actualData, expectedData);
                    final int finalPageNumber = pageNumber;
                    assertThat(diff)
                            .withFailMessage(() -> {
                                        int startIndex = 0;
                                        while (startIndex < expectedData.length() && startIndex < actualData.length()
                                                && expectedData.charAt(startIndex) == actualData.charAt(startIndex)) {
                                            startIndex++;
                                        }
                                        return String.format("expected data of page %d to be \n'%s', \nbut was \n'%s'",
                                                finalPageNumber,
                                                expectedData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(expectedData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK)),
                                                actualData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(actualData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK))
                                        );
                                    }
                            )
                            .isLessThan(0.1f); // 10% difference is allowed, because of minor differences in base64 encoded images
                }
            }

        } catch (AssertionError e) {
            if (expectedObject != null && actualObject != null) {
                final String fileName = caseFilePath.getFileName().toString();
                final List<LoadDocumentDescription.PageDescriptionEntity> expectedPages = expectedObject.getPages();
                final List<LoadDocumentDescription.PageDescriptionEntity> actualPages = actualObject.getPages();
                for (int n = 0; n < Math.max(expectedPages.size(), actualPages.size()); n++) {
                    if (expectedPages.size() > n) {
                        final LoadDocumentDescription.PageDescriptionEntity expectedPageDescriptionEntity = expectedPages.get(n);
                        final Path expectedTempFile = Files.createTempFile(Paths.get("target"), "LoadDocumentDescription-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-expected-page-" + expectedPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(expectedTempFile.toFile(), Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Expected data for page {} was written:\t'{}'", n + 1, expectedTempFile);
                    }
                    if (actualPages.size() > n) {
                        final LoadDocumentDescription.PageDescriptionEntity actualPageDescriptionEntity = actualPages.get(n);
                        final Path actualTempFile = Files.createTempFile(Paths.get("target"), "LoadDocumentDescription-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-actual-page-" + actualPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(actualTempFile.toFile(), Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Actual data for page {} was written:\t'{}'", n + 1, actualTempFile);
                    }
                }
//                caseObject.getExpectedObject().getPages().clear();
//                caseObject.getExpectedObject().getPages().addAll(actualPages);
//                OBJECT_MAPPER.writeValue(new File("/home/liosha/workspace/java/groupdocs-comparison-java-examples/Demos/demos-api-tests/src/test/resources/com/groupdocs/ui/viewer/demosapitests/loaddocumentdescriptioncases/" + caseFilePath.getFileName()), caseObject);
            } else {
                System.out.println("Problematic page: " + pageNumber);
            }
            throw e;
        } finally {
            System.out.println();
        }
    }


    @DataProvider(name = "Compare_DataProvider")
    public Object[][] testCompare_DataProvider() throws IOException, URISyntaxException {
        final java.net.URL documentDescriptionResource = this.getClass().getResource("");
        assertThat(documentDescriptionResource).isNotNull();

        List<Object[]> caseList = new ArrayList<>();

        final Path documentDescriptionDirectory = Paths.get(documentDescriptionResource.toURI());

        for (Path filePath : Files.newDirectoryStream(documentDescriptionDirectory.resolve("compare"), "*.json")) {
//            if (filePath.toString().contains("bmp-"))
                caseList.add(new Object[]{filePath.toString()});
        }

        return caseList.toArray(new Object[0][]);
    }

    @Test(dataProvider = "Compare_DataProvider")
    public void testCompare(String caseFile) throws IOException {
        int pageNumber = 0;
        Compare expectedObject = null;
        Compare actualObject = null;
        final Path caseFilePath = Paths.get(caseFile);
        final CompareCase caseObject = OBJECT_MAPPER.readValue(caseFilePath.toFile(), CompareCase.class);
        try {
            final String sourceGuid = caseObject.getSourceGuid();
            final String targetGuid = caseObject.getTargetGuid();
            final String sourcePassword = caseObject.getSourcePassword();
            final String targetPassword = caseObject.getTargetPassword();
            expectedObject = caseObject.getExpectedObject();

            LOGGER.info("Case name: '{}', Document guid: '{}'", caseFilePath.getFileName().toString(), sourceGuid);

            actualObject = given()
                    .when()
                    .body(String.format("{ 'guids': [ { 'guid': '%s', 'password': '%s' }, { 'guid': '%s', 'password': '%s' } ] }"
                                    .replace('\'', '"'), sourceGuid, sourcePassword, targetGuid, targetPassword)
                            .replace("\"null\"", "null"))
                    .contentType(ContentType.JSON)
                    .post(Constants.URL_TEMPLATE, "compare")
                    .then()
//                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .and().extract().body().as(Compare.class);

            assertThat(actualObject).isNotNull();

            assertThat(actualObject.getGuid()).isEqualTo(expectedObject.getGuid());
            assertThat(actualObject.getExtension()).isEqualTo(expectedObject.getExtension());
            assertThat(actualObject.getExtension()).isEqualTo(expectedObject.getExtension());

            final List<Compare.Page> expectedPages = expectedObject.getPages();
            final List<Compare.Page> actualPages = actualObject.getPages();

            assertThat(expectedPages).isNotNull();
            assertThat(actualPages).isNotNull();

            assertThat(actualPages)
                    .as("Pages count")
                    .hasSameSizeAs(expectedPages);
            for (int n = 0; n < actualPages.size(); n++) {
                final Compare.Page expectedPageDescriptionEntity = expectedPages.get(n);
                final Compare.Page actualPageDescriptionEntity = actualPages.get(n);
                pageNumber = n;

                assertThat(actualPageDescriptionEntity.getAngle())
                        .as("Angle")
                        .isEqualTo(expectedPageDescriptionEntity.getAngle());
                assertThat(actualPageDescriptionEntity.getHeight())
                        .as("Height")
                        .isEqualTo(expectedPageDescriptionEntity.getHeight());
                assertThat(actualPageDescriptionEntity.getWidth())
                        .as("Width")
                        .isEqualTo(expectedPageDescriptionEntity.getWidth());
                assertThat(pageNumber)
                        .as("Number")
                        .isEqualTo(expectedPageDescriptionEntity.getNumber());

                assertThat(expectedPageDescriptionEntity.getData() == null && actualPageDescriptionEntity.getData() != null)
                        .as("Actual data must be null but was not")
                        .isFalse();
                assertThat(expectedPageDescriptionEntity.getData() != null && actualPageDescriptionEntity.getData() == null)
                        .as("Actual data must NOT be null but was")
                        .isFalse();

                if (expectedPageDescriptionEntity.getData() != null) {
                    final String expectedData = Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData());
                    final String actualData = Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData());

                    final float diff = Utils.differenceOfStrings(actualData, expectedData);
                    final int finalPageNumber = pageNumber;
                    assertThat(diff)
                            .withFailMessage(() -> {
                                        int startIndex = 0;
                                        while (startIndex < expectedData.length() && startIndex < actualData.length()
                                                && expectedData.charAt(startIndex) == actualData.charAt(startIndex)) {
                                            startIndex++;
                                        }
                                        return String.format("expected data of page %d to be \n'%s', \nbut was \n'%s'",
                                                finalPageNumber,
                                                expectedData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(expectedData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK)),
                                                actualData.substring(Math.max(0, startIndex - ERROR_MESSAGE_DATA_LOOK_BACK), Math.min(actualData.length(), ERROR_MESSAGE_DATA_LENGTH + startIndex - ERROR_MESSAGE_DATA_LOOK_BACK))
                                        );
                                    }
                            )
                            .isLessThan(0.1f); // 10% difference is allowed, because of minor differences in base64 encoded images
                }
            }


            final List<Compare.Change> expectedChanges = expectedObject.getChanges();
            final List<Compare.Change> actualChanges = actualObject.getChanges();

            assertThat(expectedChanges).isNotNull();
            assertThat(actualChanges).isNotNull();

            assertThat(actualChanges)
                    .as("Pages count")
                    .hasSameSizeAs(expectedChanges);
            for (int n = 0; n < actualChanges.size(); n++) {
                final Compare.Change expectedChange = expectedChanges.get(n);
                final Compare.Change actualChange = actualChanges.get(n);
                assertThat(actualChange.getComponentType())
                        .as("ComponentType")
                        .isEqualTo(expectedChange.getComponentType());
                assertThat(actualChange.getSourceText())
                        .as("SourceText")
                        .isEqualTo(expectedChange.getSourceText());
                assertThat(actualChange.getTargetText())
                        .as("TargetText")
                        .isEqualTo(expectedChange.getTargetText());
                assertThat(actualChange.getId())
                        .as("Id")
                        .isEqualTo(expectedChange.getId());
                assertThat(actualChange.getType())
                        .as("Type")
                        .isEqualTo(expectedChange.getType());
                assertThat(actualChange.getText())
                        .as("Text")
                        .isEqualTo(expectedChange.getText());

                final Compare.Box actualBox = actualChange.getBox();
                final Compare.Box expectedBox = expectedChange.getBox();
                assertThat(actualBox.getX())
                        .as("Box.X")
                        .isEqualTo(expectedBox.getX());
                assertThat(actualBox.getY())
                        .as("Box.Y")
                        .isEqualTo(expectedBox.getY());
                assertThat(actualBox.getWidth())
                        .as("Box.Width")
                        .isEqualTo(expectedBox.getWidth());
                assertThat(actualBox.getHeight())
                        .as("Box.Height")
                        .isEqualTo(expectedBox.getHeight());

                assertThat(actualChange.getStyleChanges())
                        .as("StyleChanges")
                        .isEqualTo(expectedChange.getStyleChanges());

                final Compare.PageInfo expectedPageInfo = expectedChange.getPageInfo();
                final Compare.PageInfo actualPageInfo = actualChange.getPageInfo();
                assertThat(actualPageInfo.getPageNumber())
                        .as("PageNumber")
                        .isEqualTo(expectedPageInfo.getPageNumber());
                assertThat(actualPageInfo.getWidth())
                        .as("Width")
                        .isEqualTo(expectedPageInfo.getWidth());
                assertThat(actualPageInfo.getHeight())
                        .as("Height")
                        .isEqualTo(expectedPageInfo.getHeight());

                final List<Object> expectedAuthors = expectedChange.getAuthors();
                final List<Object> actualAuthors = actualChange.getAuthors();

                assertThat(actualAuthors)
                        .as("Authors")
                        .isEqualTo(expectedAuthors);
            }

        } catch (AssertionError e) {
            if (expectedObject != null && actualObject != null) {
                final String fileName = caseFilePath.getFileName().toString();
                final List<Compare.Page> expectedPages = expectedObject.getPages();
                final List<Compare.Page> actualPages = actualObject.getPages();
                for (int n = 0; n < Math.max(expectedPages.size(), actualPages.size()); n++) {
                    if (expectedPages.size() > n) {
                        final Compare.Page expectedPageDescriptionEntity = expectedPages.get(n);
                        final Path expectedTempFile = Files.createTempFile(Paths.get("target"), "Compare-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-expected-page-" + expectedPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(expectedTempFile.toFile(), Utils.normalizeDataBeforeComparing(expectedPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Expected data for page {} was written:\t'{}'", n + 1, expectedTempFile);
                    }
                    if (actualPages.size() > n) {
                        final Compare.Page actualPageDescriptionEntity = actualPages.get(n);
                        final Path actualTempFile = Files.createTempFile(Paths.get("target"), "Compare-" + fileName.substring(0, fileName.lastIndexOf('.')) + "-actual-page-" + actualPageDescriptionEntity.getNumber() + "-", ".html");
                        FileUtils.write(actualTempFile.toFile(), Utils.normalizeDataBeforeComparing(actualPageDescriptionEntity.getData()), StandardCharsets.UTF_8);
                        LOGGER.info("Actual data for page {} was written:\t'{}'", n + 1, actualTempFile);
                    }
                }
//                caseObject.getExpectedObject().getPages().clear();
//                caseObject.getExpectedObject().getPages().addAll(actualPages);
//                OBJECT_MAPPER.writeValue(new File("/home/liosha/workspace/java/groupdocs-comparison-java-examples/Demos/demos-api-tests/src/test/resources/com/groupdocs/ui/viewer/demosapitests/compare/" + caseFilePath.getFileName()), caseObject);
            } else {
                System.out.println("Problematic page: " + pageNumber);
            }
            throw e;
        } finally {
            System.out.println();
        }
    }

//    @Test
//    public void testDownloadDocument() {
//        given()
//                .when()
//                .param("path", "GroupDocs_Demo.pdf")
//                .get(Constants.URL_TEMPLATE, "downloadDocument")
//                .then()
//                .log().all()
//                .assertThat()
//                .statusCode(200)
//                .and().header("Content-disposition", Matchers.equalTo("attachment; filename=GroupDocs_Demo.pdf"));
//    }
}
