data class SemVersion(
    val major: Int,
    val minor: Int,
    val patch: Int
): Comparable<SemVersion> {

    companion object {
        @Throws(Exception::class)
        fun from(version: String): SemVersion {
            val split = version.split(".").toTypedArray()
            return SemVersion(
                major = split[0].toInt(),
                minor = split[1].toInt(),
                patch = split[2].toInt(),
            )
        }
    }

    override fun compareTo(other: SemVersion): Int {
        if (major != other.major) {
            return major - other.major;
        }

        if (minor != other.minor) {
            return minor - other.minor;
        }

        if (patch != other.patch) {
            return patch - other.patch;
        }

        return 0
    }

    fun isGreaterOrEqual(other: SemVersion): Boolean {
        return this >= other
    }

    override fun toString(): String {
        return "$major.$minor.$patch"
    }


}