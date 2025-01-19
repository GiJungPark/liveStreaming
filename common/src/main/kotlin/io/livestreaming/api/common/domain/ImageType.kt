package io.livestreaming.api.common.domain

enum class ImageType {
    Profile {
        override fun isProfile(): Boolean {
            return true
        }

        override fun isThumbnail(): Boolean {
            return false
        }
    },

    Thumbnail {
        override fun isProfile(): Boolean {
            return false
        }

        override fun isThumbnail(): Boolean {
            return true
        }
    };

    abstract fun isProfile(): Boolean
    abstract fun isThumbnail(): Boolean
}