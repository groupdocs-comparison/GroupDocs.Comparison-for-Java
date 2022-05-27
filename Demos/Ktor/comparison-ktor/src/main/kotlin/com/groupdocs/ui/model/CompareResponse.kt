package com.groupdocs.ui.model

import com.groupdocs.comparison.result.ChangeInfo

data class CompareResponse(
    /**
     * List of change information
     */
    val changes: List<ChangeInfo>,

    /**
     * List of images of pages with marked changes
     */
    val pages: List<ComparePage>,

    /**
     * Unique key of results
     */
    val guid: String,

    /**
     * Extension of compared files, for saving total results
     */
    val extension: String = ""
)

/**
 * PageDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
data class ComparePage(
    val data: String? = null,
    val angle: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
    val number: Int = 0,
)