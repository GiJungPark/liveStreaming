package io.livestreaming.api.commerce.presentation.web.request

data class PaginationRequest(
    val page: Int = 1,
    val size: Int = 20,
)
