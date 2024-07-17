package com.example.jetpacklist.enumClass

import com.example.jetpacklist.enum.getDefaultLanguage
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class getDefaultLanguageTest {
    @BeforeEach
    fun setUp() {
        System.setProperty("java.util.logging.config.file", "logging.properties")
    }

    @AfterEach
    fun tearDown() {
        System.clearProperty("java.util.logging.config.file")
    }

    @Test
    fun `getDefaultLanguage returns japanese file name`() {
        val language = "ja"
        val expected = "Landmarks_ja.json"
        val actual = getDefaultLanguage(language)
        assertEquals(expected, actual)
    }
}