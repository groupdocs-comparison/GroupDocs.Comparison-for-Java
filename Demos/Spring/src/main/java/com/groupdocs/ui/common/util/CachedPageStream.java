package com.groupdocs.ui.common.util;

import com.groupdocs.comparison.common.delegates.Delegates;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CachedPageStream  implements Delegates.CreatePageStream {
    private static final Logger logger = LoggerFactory.getLogger(CachedPageStream.class);

    private final SessionCache mSessionCache;
    private final String mGuid;
    private final Map<Integer, Path> mCacheFiles;

    public CachedPageStream(SessionCache sessionCache, String guid) {
        if (sessionCache == null) {
            throw new IllegalArgumentException("Session cache is null!");
        }
        mSessionCache = sessionCache;
        mGuid = guid;
        mCacheFiles = new HashMap<>();
    }

    public boolean isCached() {
        if (mCacheFiles.isEmpty()) {
            for (int pageNumber = 1; pageNumber < Integer.MAX_VALUE; pageNumber++) {
                final String fileName = createFileName(mGuid, pageNumber);
                if (mSessionCache.isCacheEntryExist(fileName)) {
                    mCacheFiles.put(pageNumber - 1, mSessionCache.getCacheEntry(fileName));
                } else {
                    break;
                }
            }
        }

        final boolean isCached = !mCacheFiles.isEmpty();

        logger.debug("File with guid='" + mGuid + "' " + (isCached ? "is cached" : "is NOT cached"));
        return isCached;
    }

    @Override
    public OutputStream invoke(int pageNumber) {
        logger.debug("Creating cache file...");
        try {
            final String fileName = createFileName(mGuid, pageNumber);
            final Path cacheEntry = mSessionCache.createCacheEntry(fileName);
            mCacheFiles.put(pageNumber - 1 /* to pageIndex */, cacheEntry);
            return new FileOutputStream(cacheEntry.toFile());
        } catch (FileNotFoundException e) {
            throw new TotalGroupDocsException("Cache exception occurred", e);
        }
    }

    public int getPagesCount() {
        return mCacheFiles.size();
    }

    public InputStream createPageStream(int pageIndex) {
        if (!mCacheFiles.containsKey(pageIndex)) {
            throw new IllegalArgumentException("Incorrect page index");
        }
        logger.debug("Creating cached page stream...");
        try {
            return Files.newInputStream(mCacheFiles.get(pageIndex).toFile().toPath());
        } catch (Exception e) {
            throw new TotalGroupDocsException("Cache exception occurred", e);
        }
    }

    public Stream<PageStream> stream() {
        logger.debug("Iterating cached pages stream...");
        return mCacheFiles.entrySet().stream().map(entry -> {
            try {
                return new PageStream(entry.getKey(), Files.newInputStream(entry.getValue().toFile().toPath()));
            } catch (Exception e) {
                throw new TotalGroupDocsException("Cache exception occurred", e);
            }
        });

    }

    private static String createFileName(String guid, int pageNumber) {
        return "gd_" + guid.hashCode() + "_page_" + pageNumber + ".cache";
    }

    public static class PageStream {
        public final int pageIndex;
        public final InputStream pageStream;

        public PageStream(int pageIndex, InputStream pageStream) {
            this.pageIndex = pageIndex;
            this.pageStream = pageStream;
        }
    }
}
