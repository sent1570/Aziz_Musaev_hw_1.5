package com.example.myapplication1.presentation.presenter

import androidx.core.content.contentValuesOf
import com.example.myapplication1.domain.Card
import com.example.myapplication1.domain.Game

class EmojiGame {
    private val game = Game(listOf(
        "\uD83E\uDD2F","\uD83D\uDE02","\uD83D\uDE20","\uD83D\uDE0B","\uD83E\uDEE4","\uD83D\uDE11"
    )
    )

    fun getCards2() = game.getCards()

    fun onCardClick2(card: Card<String>){
        game.onCardClick(card)
    }
}