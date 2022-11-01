package com.groupdocs.ui.comparison.spring.common.resources;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public abstract class Resources {

    private static final ZoneId GMT = ZoneId.of("GMT");

    /**
     * Date formats with time zone as specified in the HTTP RFC.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-7.1.1.1">Section 7.1.1.1 of RFC 7231</a>
     */
    private static final DateTimeFormatter[] DATE_FORMATTERS = new DateTimeFormatter[]{
            DateTimeFormatter.RFC_1123_DATE_TIME,
            DateTimeFormatter.ofPattern("EEEE, dd-MMM-yy HH:mm:ss zz", Locale.US),
            DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy", Locale.US).withZone(GMT)
    };

    /**
     * Fill header HTTP response with file data
     */
    public void addFileDownloadHeaders(HttpServletResponse response, String fileName, Long fileLength) {
        Map<String, List<String>> fileDownloadHeaders = createFileDownloadHeaders(fileName, fileLength, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        for (Map.Entry<String, List<String>> entry : fileDownloadHeaders.entrySet()) {
            for (String value : entry.getValue()) {
                response.addHeader(entry.getKey(), value);
            }
        }
    }

    /**
     * Get headers for downloading files
     */
    private static Map<String, List<String>> createFileDownloadHeaders(String fileName, Long fileLength, String mediaType) {
        Map<String, List<String>> httpHeaders = new HashMap<>();
        httpHeaders.put("Content-disposition", Lists.newArrayList("attachment; filename=" + fileName));
        httpHeaders.put("Content-Type", Lists.newArrayList(mediaType));
        httpHeaders.put("Content-Description", Lists.newArrayList("File Transfer"));
        httpHeaders.put("Content-Transfer-Encoding", Lists.newArrayList("binary"));
        httpHeaders.put("Expires", Lists.newArrayList(formatDate(0)));
        httpHeaders.put("Cache-Control", Lists.newArrayList("must-revalidate"));
        httpHeaders.put("Pragma", Lists.newArrayList("public"));
        if (fileLength != null) {
            httpHeaders.put("Content-Length", Lists.newArrayList(Long.toString(fileLength)));
        }
        return httpHeaders;
    }

    private static String formatDate(long date) {
        Instant instant = Instant.ofEpochMilli(date);
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, GMT);
        return DATE_FORMATTERS[0].format(time);
    }

}