package com.bibin.twitte.twittemanager.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bibin.twitte.databinding.ListItemTwitterFeedBinding
import com.bibin.twitte.twittemanager.presentation.entity.MyTwitte


internal class TwitterFeedListAdapter(private var list: List<MyTwitte>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TwitterFeedItemViewHolder(
            ListItemTwitterFeedBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as TwitterFeedItemViewHolder
        viewHolder.bind(list[position])
    }

    class TwitterFeedItemViewHolder(private val binding: ListItemTwitterFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(twitterFeed: MyTwitte) {
            binding.myTwitte = twitterFeed

            binding.executePendingBindings()
        }
    }

    fun updateList(newList: List<MyTwitte>) {
        this.list = newList
        notifyDataSetChanged()
    }
}