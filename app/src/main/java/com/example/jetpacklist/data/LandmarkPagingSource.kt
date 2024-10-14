package com.example.jetpacklist.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlin.math.max

class LandmarkPagingSource: PagingSource<Int, LandmarkData>() {
    private val STARTING_KEY = 0

    override fun getRefreshKey(state: PagingState<Int, LandmarkData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val landmarkPosition = state.closestPageToPosition(anchorPosition) ?: return null
        return ensureValidKey(key = landmarkPosition.data.size - (state.config.pageSize / 2))
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LandmarkData> {
        val startPosition = params.key ?: STARTING_KEY
        val range = startPosition.until(startPosition + params.loadSize)
        return LoadResult.Page(
            data = range.map {
                loadNumber ->
                LandmarkData(
                    id = loadNumber,
                    name = "Landmark name:$loadNumber",
                    description = loadNumber.toString(),
                    airport = loadNumber.toString()
                )
            },
            prevKey = when(startPosition) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last +1
        )
    }

    private fun ensureValidKey(key:Int) = max(STARTING_KEY,key)
}