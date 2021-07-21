package com.bibin.twitte.base.domain.entity

import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import com.bibin.twitte.twittemanager.presentation.entity.MyTwitte

fun List<MyTwitteEntity>.mapToMyTwittes(): List<MyTwitte> {
    val twitteList: MutableList<MyTwitte> = mutableListOf()

    this.map {
        twitteList.add(it.mapMyTwitteEntityToMyTwitte())
    }
    return twitteList
}

private fun MyTwitteEntity.mapMyTwitteEntityToMyTwitte(): MyTwitte {
    return MyTwitte(
        createdAt = this.createdAt ?: "",
        fullText = this.fullText ?: "",
        id = this.id ?: 0
    )
}