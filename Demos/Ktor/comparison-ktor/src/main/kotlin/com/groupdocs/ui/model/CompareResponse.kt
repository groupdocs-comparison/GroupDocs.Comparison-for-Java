package com.groupdocs.ui.model

data class CompareResponse(
    /**
     * List of change information
     */
    val changes: List<DocumentChange>,

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
    val extension: String? = null
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

data class DocumentChange(
    val id: Int,
    val type: Int,
    val comparisonAction: Int,
    val sourceText: String,
    val targetText: String,
    val text: String,
    val componentType: String,
    val box: ChangeBox,
    val authors: List<String>,
    val pageInfo: PageInfo,
    val styleChanges: List<StyleChange>,
)

data class ChangeBox(
    val y: Double,
    val x: Double,
    val height: Double,
    val width: Double
)

data class PageInfo(
    val height: Int,
    val width: Int,
    val pageNumber: Int
)

data class StyleChange(
    val oldValue: Any,
    val newValue: Any,
    val propertyName: String
)