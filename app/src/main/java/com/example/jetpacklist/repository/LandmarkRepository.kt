package com.example.jetpacklist.repository

import com.example.jetpacklist.data.LandmarkPagingSource
import androidx.paging.PagingSource

class LandmarkRepository {
    fun landmarkPagingSource() = LandmarkPagingSource()
}