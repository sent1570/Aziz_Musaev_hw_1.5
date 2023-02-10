package com.example.myapplication1.presentation.view

import android.annotation.SuppressLint
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ItemNumberBinding
import com.example.myapplication1.domain.Card
import com.example.myapplication1.presentation.presenter.EmojiGame

class EmojiAdapter: RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {
    private val emojiGame = EmojiGame()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val ui = ItemNumberBinding.bind(itemView)
        @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
        fun onBind(card: Card<String>){
            if(card.isMatched) onUiUpdate(card,true)
            else onUiUpdate(card,card.isFacedUp)
            if(!card.isMatched)
                ui.itemFrame.setOnClickListener{
                    onUiUpdate(card,!card.isFacedUp)

                    emojiGame.onCardClick2(card)
                    android.os.Handler(Looper.getMainLooper()).postDelayed({
                        notifyDataSetChanged()
                    }, 0)
                }
        }
        private fun onUiUpdate(card: Card<String>, isFaced:Boolean){
            ui.itemTv.text = if(isFaced) card.content.toString()
            else ""
            ui.itemFrame.isPressed = isFaced
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_number,parent,false))

    }

    override fun getItemCount(): Int {
        return emojiGame.getCards2().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(emojiGame.getCards2()[position])
    }

}