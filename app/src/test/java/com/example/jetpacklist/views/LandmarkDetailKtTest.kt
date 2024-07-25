package com.example.jetpacklist.views

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LandmarkDetailKtTest {

    @BeforeEach
    fun setUp() {
        System.setProperty("java.util.logging.config.file", "logging.properties")
    }

    @AfterEach
    fun tearDown() {
        System.clearProperty("java.util.logging.config.file")
    }

    @Test
    fun landmarkDetailView() {
    }
}