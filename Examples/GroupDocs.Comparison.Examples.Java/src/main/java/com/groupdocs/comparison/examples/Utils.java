package com.groupdocs.comparison.examples;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Utils {

    public static final String LICENSE_PATH;
    public static final String LICENSE_URL;
    public static final String SAMPLES_PATH;
    public static final String OUTPUT_PATH;

    static {
        final URL resource = Utils.class.getClassLoader().getResource(".");
        final URI uri;
        try {
            uri = Objects.requireNonNull(resource).toURI();
            final String path = uri.getPath().substring(1);
            final File baseFile = new File(path).getParentFile().getParentFile();
            SAMPLES_PATH = baseFile.getAbsolutePath() + "/resources/sample_files";
            LICENSE_PATH = baseFile.getAbsolutePath() + "/resources/GroupDocs.Viewer.Java.lic";
            OUTPUT_PATH = baseFile.getAbsolutePath() + "/output";
            LICENSE_URL = System.getenv("GROUPDOCS_LIC_PATH");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getOutputDirectoryPath(String fileName, String fileSuffix) throws IOException {
        File outputDirectory = new File(OUTPUT_PATH).getCanonicalFile();
        if (!outputDirectory.exists() && !outputDirectory.mkdirs()) {
            throw new IOException("Can't create output directory '" + outputDirectory.getAbsolutePath() + "'");
        }
        return outputDirectory.getAbsolutePath() + "/" + String.format(fileName, fileSuffix);
    }

    public static void deleteOutputDirectory() {
        deleteDirectory(new File(OUTPUT_PATH));
    }

    private static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (File child : Objects.requireNonNull(children)) {
                boolean success = deleteDirectory(child);
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
