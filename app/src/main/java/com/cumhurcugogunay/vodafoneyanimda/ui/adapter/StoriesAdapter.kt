package com.cumhurcugogunay.vodafoneyanimda.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cumhurcugogunay.vodafoneyanimda.data.entity.Stories
import com.cumhurcugogunay.vodafoneyanimda.databinding.StoriesRowBinding

class StoriesAdapter (var mContext: Context, var storiesList:List<Stories> )
    : RecyclerView.Adapter<StoriesAdapter.StoriesHolder>() {

    inner class StoriesHolder(var binding: StoriesRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesHolder {
        val binding = StoriesRowBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return StoriesHolder(binding)
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    override fun onBindViewHolder(holder: StoriesHolder, position: Int) {
        val story = storiesList[position]
        val t = holder.binding

        t.cardImg.setImageResource(mContext.resources.getIdentifier(story.img,"drawable",mContext.packageName))
        t.cardTxt.text = story.name
        changeStar(story.star,story.yellowStar,t)

    }

    fun changeStar(circle:Boolean,yellowStar:Boolean,t:StoriesRowBinding){
        if(circle && !yellowStar){
            t.starImg.setImageResource(mContext.resources.getIdentifier("whitestar", "drawable", mContext.packageName))
        }else if(!circle && !yellowStar){
            t.starImg.visibility = View.INVISIBLE
            t.circleImg.visibility = View.INVISIBLE

        }
    }
}