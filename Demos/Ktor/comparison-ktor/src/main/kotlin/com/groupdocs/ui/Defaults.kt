package com.groupdocs.ui


interface Defaults {
    interface Application {
        companion object {
            const val DEFAULT_LICENSE_PATH = "Licenses"
            const val DEFAULT_LICENSE_EXTENSION = ".lic"
        }
    }

    interface Comparison {
        enum class FilesProviderType {
            LOCAL, GOOGLE, DROPBOX
        }

        companion object {
            const val DEFAULT_PRELOAD_RESULT_PAGE_COUNT = 2
            const val DEFAULT_PREVIEW_PAGE_WIDTH = 768
            const val DEFAULT_PREVIEW_PAGE_RATIO = 1.3f
            val DEFAULT_FILES_PROVIDER_TYPE = FilesProviderType.LOCAL
            val DEFAULT_CACHE_DIRECTORY = System.getProperty("java.io.tmpdir")
            val DEFAULT_TEMP_DIRECTORY = System.getProperty("java.io.tmpdir")
        }
    }

    interface Local {
        companion object {
            const val DEFAULT_FILES_DIRECTORY = "DocumentSamples"
            const val DEFAULT_RESULT_DIRECTORY = "ResultFiles"
        }
    }

    interface Google {
        enum class AccessType {
            OFFLINE, ONLINE
        }

        companion object {
            const val DEFAULT_LOCAL_SERVER_RECEIVER_PORT = 8888
            val DEFAULT_ACCESS_TYPE = AccessType.OFFLINE
            const val DEFAULT_CREDENTIALS_PATH = "credentials.json"
        }
    }
}
