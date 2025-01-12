package io.livestreaming.api.member.domain

class Image private constructor(
    val url: URL,
    val type: ImageType,
) {

    init {
        validateImage(url)
    }

    companion object {
        fun profileImageOf(url: String): Image {
            return Image(
                url = URL.of(url),
                type = ImageType.Profile
            )
        }

        fun thumbnailImageOf(url: String): Image {
            return Image(
                url = URL.of(url),
                type = ImageType.Thumbnail
            )
        }
    }

    fun isProfileImage(): Boolean {
        return type.isProfile()
    }

    fun isThumbnailImage(): Boolean {
        return type.isThumbnail()
    }


    private fun validateImage(value: URL) {
        require(value.isImageUrl()) { "이미지 파일이 아닙니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (url != other.url) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = url.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }

    override fun toString(): String {
        return "[Image] url: $url, type: ${type.name}"
    }

}