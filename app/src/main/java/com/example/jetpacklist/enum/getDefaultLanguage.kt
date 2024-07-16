package com.example.jetpacklist.enum

fun getDefaultLanguage(language:String): String {
    return when (language) {
        "ja" -> "Landmarks_ja.json"
        "ko" -> "Landmarks_ko.json"
        "zh" -> "Landmarks_zh_rCN.json"
        "es" -> "Landmarks_es_rES.json"
        else -> "Landmarks.json"
    }
}