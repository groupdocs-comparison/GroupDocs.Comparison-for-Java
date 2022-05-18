package com.groupdocs.ui.common;

public interface Defaults {
    interface Application {
        String DEFAULT_LICENSE_PATH = "Licenses";
        String DEFAULT_LICENSE_EXTENSION = ".lic";
    }

    interface Comparison {
        enum FilesProviderType {
            LOCAL, GOOGLE, DROPBOX
        }

        int DEFAULT_PRELOAD_RESULT_PAGE_COUNT = 2;
        int DEFAULT_PREVIEW_PAGE_WIDTH = 768;
        float DEFAULT_PREVIEW_PAGE_RATIO = 1.3F;
        FilesProviderType DEFAULT_FILES_PROVIDER_TYPE = FilesProviderType.LOCAL;
    }

    interface Local {

        String DEFAULT_FILES_DIRECTORY = "DocumentSamples";
        String DEFAULT_RESULT_DIRECTORY = "DocumentSamples/Temp";
        String DEFAULT_CACHE_DIRECTORY = System.getProperty("java.io.tmpdir");
        String DEFAULT_TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    }

    interface Google {

        enum AccessType {
            OFFLINE, ONLINE
        }

        int DEFAULT_LOCAL_SERVER_RECEIVER_PORT = 8888;
        AccessType DEFAULT_ACCESS_TYPE = AccessType.OFFLINE;
        String DEFAULT_CREDENTIALS_PATH = "credentials.json";
    }
}
