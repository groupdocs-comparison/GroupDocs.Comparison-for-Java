package com.groupdocs.ui.common.util;

import com.google.common.collect.Ordering;
import com.groupdocs.ui.common.config.ServerConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.util.comparator.FileNameComparator;
import com.groupdocs.ui.common.util.comparator.FileTypeComparator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Map;

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
            case "doc":
            case "docx":
            case "xls":
            case "xlsx":
            case "ppt":
            case "pptx":
            case "pdf":
            case "png":
            case "txt":
            case "html":
            case "htm":
            case "jpg":
            case "jpeg":
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
