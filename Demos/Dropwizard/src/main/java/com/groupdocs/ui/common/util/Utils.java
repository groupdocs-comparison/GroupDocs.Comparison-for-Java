package com.groupdocs.ui.common.util;

import com.google.common.collect.Ordering;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.util.comparator.FileNameComparator;
import com.groupdocs.ui.common.util.comparator.FileTypeComparator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import static com.groupdocs.ui.common.exception.PasswordExceptions.INCORRECT_PASSWORD;
import static com.groupdocs.ui.common.exception.PasswordExceptions.PASSWORD_REQUIRED;

public class Utils {

    private static final List<String> SUPPORTED_FORMATS = Arrays.asList(
            "jpg",
            "docx",
            "doc",
            "xls",
            "xlsx",
            "ppt",
            "pptx",
            "pdf",
            "png",
            "txt",
            "htm",
            "html"
    );

    public static java.util.List<FileDescriptionEntity> orderByTypeAndName(List<FileDescriptionEntity> files) {
        return Ordering.from(FileTypeComparator.instance).compound(FileNameComparator.instance).sortedCopy(files);
    }

    /**
     * Read stream and convert to string
     */
    public static String getStringFromStream(InputStream inputStream) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStream);
        // encode ByteArray into String
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Parse extension of the file's name
     *
     * @param documentGuid path to file
     * @return extension of the file's name
     */
    public static String parseFileExtension(String documentGuid) {
        String extension = FilenameUtils.getExtension(documentGuid);
        return extension == null ? null : extension.toLowerCase(Locale.getDefault());
    }


    /**
     * Check support formats for comparing
     *
     * @param extension file extension
     * @return true - format is supported, false - format is not supported
     */
    public static boolean checkSupportedFiles(String extension) {
        return SUPPORTED_FORMATS.contains(extension);
    }
}
