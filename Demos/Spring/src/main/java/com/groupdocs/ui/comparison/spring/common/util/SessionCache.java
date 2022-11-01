package com.groupdocs.ui.comparison.spring.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SessionCache {
    private static final Logger logger = LoggerFactory.getLogger(SessionCache.class);

    private final Path mCacheDirectory;
    private final String mSessionId;
    private final List<String> mCacheEntries = new ArrayList<>();

    public SessionCache(Path cacheDirectory, String sessionId) {
        if (Files.notExists(cacheDirectory)) {
            throw new IllegalArgumentException("Cache directory does not exist!");
        }
        mCacheDirectory = cacheDirectory;
        mSessionId = sessionId;

        logger.debug("Session cache was created for sessionId=" + mSessionId);
    }

    public Path createCacheEntry(String fileName) {
        Path sessionDirectory = mCacheDirectory.resolve(mSessionId);
        if (Files.notExists(sessionDirectory)) {
            try {
                Files.createDirectories(sessionDirectory);
            } catch (IOException e) {
                throw new IllegalStateException("Can't create session directory", e);
            }
        }
        Path entryPath = sessionDirectory.resolve(fileName).toAbsolutePath().normalize();
        mCacheEntries.add(fileName);
        return entryPath;
    }

    public boolean isCacheEntryExist(String fileName) {
        Path entryPath = mCacheDirectory.resolve(mSessionId).resolve(fileName).toAbsolutePath().normalize();
        return mCacheEntries.contains(fileName) && Files.exists(entryPath);
    }

    public Path getCacheEntry(String fileName) {
        return mCacheDirectory.resolve(mSessionId).resolve(fileName).toAbsolutePath().normalize();
    }

    public void deleteCacheEntry(String fileName) {
        Path sessionDirectory = mCacheDirectory.resolve(mSessionId);
        if (Files.notExists(sessionDirectory)) {
            return;
        }
        Path entryPath = sessionDirectory.resolve(fileName).toAbsolutePath().normalize();
        if (Files.exists(entryPath)) {
            try {
                Files.delete(entryPath);
                mCacheEntries.remove(fileName);
            } catch (IOException e) {
                throw new IllegalStateException("Can't delete cache entry", e);
            }
        }
    }

    public void clear() {
        // Delete session files
        mCacheEntries.forEach((entry) -> {
            try {
                Path entryPath = mCacheDirectory.resolve(mSessionId).resolve(entry).toAbsolutePath().normalize();
                Files.deleteIfExists(entryPath);
            } catch (IOException e) {
                logger.debug("Cache entry '" + entry + "' wasn't deleted");
            }
        });
        // Delete session directory
        if (!mCacheEntries.isEmpty()) {
            Path sessionPath = mCacheDirectory.resolve(mSessionId).toAbsolutePath().normalize();
            try {
                Files.deleteIfExists(sessionPath);
            } catch (IOException e) {
                logger.debug("Session directory '" + sessionPath + "' wasn't deleted");
            }
        }
        logger.debug("Session cache with sessionId=" + mSessionId + " was destroyed");
    }
}
