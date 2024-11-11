package com.groupdocs.examples.comparison.advanced_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.comparison.result.FileType;
import com.groupdocs.examples.comparison.TestsSetUp;
import com.groupdocs.examples.comparison.utils.FilesUtils;
import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileTypesTests extends TestsSetUp {

    @DataProvider(name = "files-pairs")
    public static Object[][] filePairs() {
        return new Object[][]{
                // Specify file type (3rd argument) when the file can not be loaded without it
                // Specify skip message (4th argument) to skip files comparing
                {"files-pairs/source.as", "files-pairs/target.as", "", ""},
                {"files-pairs/source.as3", "files-pairs/target.as3", "", ""},
                {"files-pairs/source.asm", "files-pairs/target.asm", "", ""},
                {"files-pairs/source.bash", "files-pairs/target.bash", "", ""},
                {"files-pairs/source.bashrc", "files-pairs/target.bashrc", "", ""},
                {"files-pairs/source.bat", "files-pairs/target.bat", "", ""},
                {"files-pairs/source.bmp", "files-pairs/target.bmp", "BMP", "File of this format doesn't support comparison. Perhaps you have specified an invalid file extension or the file is damaged."},
                {"files-pairs/source.bowerrc", "files-pairs/target.bowerrc", "", ""},
                {"files-pairs/source.c", "files-pairs/target.c", "", ""},
                {"files-pairs/source.cc", "files-pairs/target.cc", "", ""},
                {"files-pairs/source.cfg", "files-pairs/target.cfg", "", ""},
                {"files-pairs/source.cmake", "files-pairs/target.cmake", "", ""},
                {"files-pairs/source.cmd", "files-pairs/target.cmd", "", ""},
                {"files-pairs/source.conf", "files-pairs/target.conf", "", ""},
                {"files-pairs/source.cpp", "files-pairs/target.cpp", "", ""},
                {"files-pairs/source.cpy", "files-pairs/target.cpy", "", ""},
                {"files-pairs/source.csv", "files-pairs/target.csv", "", ""},
                {"files-pairs/source.ctp", "files-pairs/target.ctp", "", ""},
                {"files-pairs/source.cxx", "files-pairs/target.cxx", "", ""},
                {"files-pairs/source.dcm", "files-pairs/target.dcm", "DCM", "File of this format doesn't support comparison. Perhaps you have specified an invalid file extension or the file is damaged."},
                {"files-pairs/source.diff", "files-pairs/target.diff", "", ""},
                {"files-pairs/source.directory", "files-pairs/target.directory", "", ""},
                {"files-pairs/source.djvu", "files-pairs/target.djvu", "DJVU", ""},
                {"files-pairs/source.doc", "files-pairs/target.doc", "", ""},
                {"files-pairs/source.docx", "files-pairs/target.docx", "", ""},
                {"files-pairs/source.dsql", "files-pairs/target.dsql", "", ""},
                {"files-pairs/source.dwg", "files-pairs/target.dwg", "", ""},
                {"files-pairs/source.dxf", "files-pairs/target.dxf", "", ""},
                {"files-pairs/source.ebuild", "files-pairs/target.ebuild", "", ""},
                {"files-pairs/source.eml", "files-pairs/target.eml", "", ""},
                {"files-pairs/source.emlx", "files-pairs/target.emlx", "", ""},
                {"files-pairs/source.erb", "files-pairs/target.erb", "", ""},
                {"files-pairs/source.es6", "files-pairs/target.es6", "", ""},
                {"files-pairs/source.gemspec", "files-pairs/target.gemspec", "", ""},
                {"files-pairs/source.gradle", "files-pairs/target.gradle", "", ""},
                {"files-pairs/source.groovy", "files-pairs/target.groovy", "", ""},
                {"files-pairs/source.gvy", "files-pairs/target.gvy", "", ""},
                {"files-pairs/source.gyp", "files-pairs/target.gyp", "", ""},
                {"files-pairs/source.gypi", "files-pairs/target.gypi", "", ""},
                {"files-pairs/source.h", "files-pairs/target.h", "", ""},
                {"files-pairs/source.haml", "files-pairs/target.haml", "", ""},
                {"files-pairs/source.har", "files-pairs/target.har", "", ""},
                {"files-pairs/source.hh", "files-pairs/target.hh", "", ""},
                {"files-pairs/source.hpp", "files-pairs/target.hpp", "", ""},
                {"files-pairs/source.html", "files-pairs/target.html", "", ""},
                {"files-pairs/source.hxx", "files-pairs/target.hxx", "", ""},
                {"files-pairs/source.ipy", "files-pairs/target.ipy", "", ""},
                {"files-pairs/source.java", "files-pairs/target.java", "", ""},
                {"files-pairs/source.jpeg", "files-pairs/target.jpeg", "", ""},
                {"files-pairs/source.jpg", "files-pairs/target.jpg", "", ""},
                {"files-pairs/source.js", "files-pairs/target.js", "", ""},
                {"files-pairs/source.js.map", "files-pairs/target.js.map", "", ""},
                {"files-pairs/source.jscsrc", "files-pairs/target.jscsrc", "", ""},
                {"files-pairs/source.jshintrc", "files-pairs/target.jshintrc", "", ""},
                {"files-pairs/source.json", "files-pairs/target.json", "", ""},
                {"files-pairs/source.less", "files-pairs/target.less", "", ""},
                {"files-pairs/source.m", "files-pairs/target.m", "", ""},
                {"files-pairs/source.make", "files-pairs/target.make", "", ""},
                {"files-pairs/source.markdn", "files-pairs/target.markdn", "", ""},
                {"files-pairs/source.markdown", "files-pairs/target.markdown", "", ""},
                {"files-pairs/source.md", "files-pairs/target.md", "", ""},
                {"files-pairs/source.mdown", "files-pairs/target.mdown", "", ""},
                {"files-pairs/source.mdtext", "files-pairs/target.mdtext", "", ""},
                {"files-pairs/source.mdtxt", "files-pairs/target.mdtxt", "", ""},
                {"files-pairs/source.mdwn", "files-pairs/target.mdwn", "", ""},
                {"files-pairs/source.mhtml", "files-pairs/target.mhtml", "", ""},
                {"files-pairs/source.mjs", "files-pairs/target.mjs", "", ""},
                {"files-pairs/source.mk", "files-pairs/target.mk", "", ""},
                {"files-pairs/source.mkd", "files-pairs/target.mkd", "", ""},
                {"files-pairs/source.ml", "files-pairs/target.ml", "", ""},
                {"files-pairs/source.mli", "files-pairs/target.mli", "", ""},
                {"files-pairs/source.mm", "files-pairs/target.mm", "", ""},
                {"files-pairs/source.mobi", "files-pairs/target.mobi", "", ""},
                {"files-pairs/source.msg", "files-pairs/target.msg", "", ""},
                {"files-pairs/source.nqp", "files-pairs/target.nqp", "", ""},
                {"files-pairs/source.ods", "files-pairs/target.ods", "", ""},
                {"files-pairs/source.odt", "files-pairs/target.odt", "", ""},
                {"files-pairs/source.one", "files-pairs/target.one", "ONE", "com.groupdocs.comparison.common.exceptions.ComparisonException: java.lang.RuntimeException: java.lang.NullPointerException"},
                {"files-pairs/source.otp", "files-pairs/target.otp", "", ""},
                {"files-pairs/source.p6", "files-pairs/target.p6", "", ""},
                {"files-pairs/source.pac", "files-pairs/target.pac", "", ""},
                {"files-pairs/source.patch", "files-pairs/target.patch", "", ""},
                {"files-pairs/source.pdf", "files-pairs/target.pdf", "", ""},
                {"files-pairs/source.php", "files-pairs/target.php", "", ""},
                {"files-pairs/source.php4", "files-pairs/target.php4", "", ""},
                {"files-pairs/source.php5", "files-pairs/target.php5", "", ""},
                {"files-pairs/source.phtml", "files-pairs/target.phtml", "", ""},
                {"files-pairs/source.pl", "files-pairs/target.pl", "", ""},
                {"files-pairs/source.pl6", "files-pairs/target.pl6", "", ""},
                {"files-pairs/source.pm", "files-pairs/target.pm", "", ""},
                {"files-pairs/source.pm6", "files-pairs/target.pm6", "", ""},
                {"files-pairs/source.png", "files-pairs/target.png", "", ""},
                {"files-pairs/source.pod", "files-pairs/target.pod", "", ""},
                {"files-pairs/source.podspec", "files-pairs/target.podspec", "", ""},
                {"files-pairs/source.potm", "files-pairs/target.potm", "", ""},
                {"files-pairs/source.ppsm", "files-pairs/target.ppsm", "", ""},
                {"files-pairs/source.ppt", "files-pairs/target.ppt", "", ""},
                {"files-pairs/source.pptm", "files-pairs/target.pptm", "", ""},
                {"files-pairs/source.pptx", "files-pairs/target.pptx", "", ""},
                {"files-pairs/source.properties", "files-pairs/target.properties", "", ""},
                {"files-pairs/source.psgi", "files-pairs/target.psgi", "", ""},
                {"files-pairs/source.py", "files-pairs/target.py", "", ""},
                {"files-pairs/source.pyi", "files-pairs/target.pyi", "", ""},
                {"files-pairs/source.pyw", "files-pairs/target.pyw", "", ""},
                {"files-pairs/source.rake", "files-pairs/target.rake", "", ""},
                {"files-pairs/source.rb", "files-pairs/target.rb", "", ""},
                {"files-pairs/source.rbi", "files-pairs/target.rbi", "", ""},
                {"files-pairs/source.rej", "files-pairs/target.rej", "", ""},
                {"files-pairs/source.rjs", "files-pairs/target.rjs", "", ""},
                {"files-pairs/source.rpy", "files-pairs/target.rpy", "", ""},
                {"files-pairs/source.rst", "files-pairs/target.rst", "", ""},
                {"files-pairs/source.ru", "files-pairs/target.ru", "", ""},
                {"files-pairs/source.sass", "files-pairs/target.sass", "", ""},
                {"files-pairs/source.sbt", "files-pairs/target.sbt", "", ""},
                {"files-pairs/source.sc", "files-pairs/target.sc", "", ""},
                {"files-pairs/source.scala", "files-pairs/target.scala", "", ""},
                {"files-pairs/source.scss", "files-pairs/target.scss", "", ""},
                {"files-pairs/source.sh", "files-pairs/target.sh", "", ""},
                {"files-pairs/source.sql", "files-pairs/target.sql", "", ""},
                {"files-pairs/source.t", "files-pairs/target.t", "", ""},
                {"files-pairs/source.txt", "files-pairs/target.txt", "", ""},
                {"files-pairs/source.vim", "files-pairs/target.vim", "", ""},
                {"files-pairs/source.vsd", "files-pairs/target.vsd", "", ""},
                {"files-pairs/source.vsdx", "files-pairs/target.vsdx", "", "An error occurred while trying to create a document. Try to use setUseSourceMaster(true) with custom value for getUserMasterPath(...)."},
                {"files-pairs/source.vss", "files-pairs/target.vss", "", "An error occurred while trying to create a document. Try to use setUseSourceMaster(true) with custom value for getUserMasterPath(...)."},
                {"files-pairs/source.webmanifest", "files-pairs/target.webmanifest", "", ""},
                {"files-pairs/source.xls", "files-pairs/target.xls", "", ""},
                {"files-pairs/source.xlsx", "files-pairs/target.xlsx", "", ""},
                {"files-pairs/source.yaml", "files-pairs/target.yaml", "", ""},
                {"files-pairs/source.yml", "files-pairs/target.yml", "", ""},
        };
    }

    @Test(dataProvider = "files-pairs")
    public void compareFiles(String sourceFile, String targetFile, String fileTypeName, String skipMessage) {
        if (!skipMessage.isEmpty()) {
            throw new SkipException(String.format("'%s' skipped with message: %s", sourceFile, skipMessage));
        }

        final Path sourcePath = FilesUtils.makeFilesPath(sourceFile);
        final Path targetPath = FilesUtils.makeFilesPath(targetFile);
        final FileType fileType = fileTypeName.isEmpty() ? FileType.UNKNOWN : FileType.valueOf(fileTypeName);

        final String sourceFileNameWithoutExtension = sourcePath.getFileName().toString().replaceFirst("\\.\\w+$", "");
        final String targetFileNameWithoutExtension = targetPath.getFileName().toString().replaceFirst("\\.\\w+$", "");
        final Path outputPath = FilesUtils.makeOutputPath(
                String.format("compareFiles-%s-%s%s", sourceFileNameWithoutExtension, targetFileNameWithoutExtension, FilesUtils.obtainExtension(sourcePath)));

        try (final Comparer comparer = new Comparer(sourcePath, new LoadOptions(fileType))) {

            comparer.add(targetPath, new LoadOptions(fileType));

            final CompareOptions compareOptions = new CompareOptions.Builder()
                    .setGenerateSummaryPage(true)
                    .build();
            final SaveOptions saveOptions = new SaveOptions.Builder()
                    .build();

            System.out.printf("Comparing '%s' with '%s' saving to '%s'...%n", sourceFile, targetFile, outputPath);
            Path resultPath = comparer.compare(outputPath, saveOptions, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            Assertions.assertThat(resultPath).exists();
        }
    }
}