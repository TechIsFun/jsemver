import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class SemVersionTest {

    @Test
    fun `SemVersion object can be created from a valid string`() {
        assertEquals(SemVersion(1, 0, 0), SemVersion.from("1.0.0"))
        assertEquals(SemVersion(4, 11, 1), SemVersion.from("4.11.1"))
    }

    @Test
    fun `SemVersion object cannot be created from an invalid string`() {
        assertThrows(Exception::class.java) { SemVersion.from("123") }
    }

    @Test
    fun `SemVersion objects can be compared`() {
        assertTrue(SemVersion(1, 0, 0) == SemVersion(1, 0, 0))
        assertTrue(SemVersion(1, 0, 0).compareTo(SemVersion(1, 0, 0)) == 0)

        assertTrue(SemVersion(1, 0, 1) > SemVersion(1, 0, 0))

        assertTrue(SemVersion(1, 0, 1).isGreaterOrEqual(SemVersion(1, 0, 0)))

        assertTrue(SemVersion(1, 0, 0).isGreaterOrEqual(SemVersion(1, 0, 0)))

        assertFalse(SemVersion(1, 0, 0).isGreaterOrEqual(SemVersion(2, 0, 0)))
        assertFalse(SemVersion(1, 0, 0).isGreaterOrEqual(SemVersion(1, 2, 0)))
        assertFalse(SemVersion(1, 0, 0).isGreaterOrEqual(SemVersion(1, 0, 2)))

        assertFalse(SemVersion.from("04.05.03").isGreaterOrEqual(SemVersion.from("04.11.1")))
    }
}