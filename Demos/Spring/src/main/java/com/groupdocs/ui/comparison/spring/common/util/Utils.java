package com.groupdocs.ui.comparison.spring.common.util;

import com.google.common.collect.Ordering;
import com.groupdocs.ui.comparison.spring.common.config.ServerConfiguration;
import com.groupdocs.ui.comparison.spring.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.comparison.spring.common.util.comparator.FileNameComparator;
import com.groupdocs.ui.comparison.spring.common.util.comparator.FileTypeComparator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

public class Utils {

    /**
     * Set local port from request to config
     */
    public static void setLocalPort(HttpServletRequest request, ServerConfiguration server) {
        if (server.getHttpPort() == null) {
            server.setHttpPort(request.getLocalPort());
        }
    }

    /**
     * Check support formats for comparing
     *
     * @param extension file extension
     * @return true - format is supported, false - format is not supported
     */
    public static boolean checkSupportedFiles(String extension) {
        switch (extension) {
            case "bmp":
            case "doc":
            case "docx":
            case "html":
            case "jpeg":
            case "jpg":
            case "ods":
            case "odt":
            case "pdf":
            case "png":
            case "ppt":
            case "pptx":
            case "txt":
            case "vsdx":
            case "vss":
            case "xls":
            case "xlsx":
                return true;
            default:
                return false;
        }
    }

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
        return extension == null ? null : extension.toLowerCase();
    }
}
