package com.example.myapplication1.domain

class Game<content>( list: List<content>) {

    private val cards:ArrayList<Card<content>> = ArrayList()
    init{
        list.forEachIndexed { index, content ->
            cards.add(Card(id = index* index,content = content))
            cards.add(Card(id = index*index+2,content = content))
            cards.shuffle()
        }
    }
    fun getCards() = cards

    fun onCardClick(card: Card<content>){
        card.isFacedUp = !card.isFacedUp
        cards.forEach {
            if(card.id != it.id && card.content == it.content && it.isFacedUp){
                cards[cards.indexOf(card)].isMatched = true
                it.isMatched = true
            }
            if (card.id != it.id && card.content != it.content && it.isFacedUp&& !it.isMatched){
                it.isFacedUp = false
                cards[cards.indexOf(card)].isFacedUp = false
            }
        }
    }
}