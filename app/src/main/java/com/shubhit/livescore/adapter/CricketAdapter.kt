package com.shubhit.livescore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhit.livescore.databinding.ScoreItemLayoutBinding
import com.shubhit.livescore.model.Data

class CricketAdapter(private val items:ArrayList<Data>) : RecyclerView.Adapter<CricketAdapter.CricketViewHolder>() {

    inner class CricketViewHolder(private val binding: ScoreItemLayoutBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(item:Data){
            if (item.teamInfo.size==2){
                binding.team1Name.text=item.teamInfo.get(0).shortname
                binding.team2Name.text=item.teamInfo.get(1).shortname


                Glide.with(binding.root.context)
                    .load(item.teamInfo.get(0).img)
                    .into(binding.team1Iv)

                Glide.with(binding.root.context)
                    .load(item.teamInfo.get(1).img)
                    .into(binding.team2Iv)

            }
            if (item.teamInfo.size==1){
                binding.team1Name.text=item.teamInfo.get(0).shortname
                binding.team2Name.text=item.teamInfo.get(0).shortname

                Glide.with(binding.root.context)
                    .load(item.teamInfo.get(0).img)
                    .into(binding.team1Iv)

                Glide.with(binding.root.context)
                    .load(item.teamInfo.get(0).img)
                    .into(binding.team2Iv)

            }





            binding.matchType.text=item.matchType?.uppercase()
            binding.matchVenue.text=item.venue
            binding.matchStatus.text=item.status


            if(item.score.size==1){
                binding.team1Score.text= "${item.score.get(0).r}" + "/${item.score.get(0).w}"
                binding.team1Over.text="${item.score.get(0).o}Overs"
            }
            if (item.score.size==2){

                binding.team1Score.text= "${item.score.get(0).r}" + "/${item.score.get(0).w}"
                binding.team1Over.text="${item.score.get(0).o}Overs"

                binding.team2Score.text= "${item.score.get(1).r}" + "/${item.score.get(1).w}"
                binding.team2Over.text="${item.score.get(1).o}Overs"
            }




        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketViewHolder {
        val binding=ScoreItemLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent,false)
        return CricketViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CricketViewHolder, position: Int) {

        holder.bind(items.get(position))

    }
}