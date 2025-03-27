package com.shivang.pwassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivang.pwassignment.databinding.ItemRecentLearningBinding

/*
created by  Shivang Yadav on 27-03-2025
gitHub: https://github.com/Iamshivang
project: pwAssignment
description:
*/


class RecentLearningAdapter(private val list: MutableList<RecentLearning>): RecyclerView.Adapter<RecentLearningAdapter.RecentLearningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentLearningViewHolder {
        return RecentLearningViewHolder(ItemRecentLearningBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: RecentLearningViewHolder, position: Int) {

        val item= list.get(position)
        holder.bindItem(item)

    }

    inner class RecentLearningViewHolder(private val binding: ItemRecentLearningBinding): RecyclerView.ViewHolder(binding.root){

        fun bindItem(model: RecentLearning){

            model.topic.let {
                binding.tvTopic.text= it
            }

            model.subject.let {
                binding.tvSubject.text= it
            }

            if (model.image == 1) {
                binding.ivIcon.setBackgroundResource(R.drawable.pdf) // Replace with your custom drawable
            } else {
                binding.ivIcon.setBackgroundResource(R.drawable.video_player) // Replace with your default drawable
            }

        }
    }
}