package com.shubhit.livescore

import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.shubhit.livescore.adapter.CricketAdapter
import com.shubhit.livescore.databinding.ActivityMainBinding
import com.shubhit.livescore.model.CurrentMatches
import com.shubhit.livescore.model.Data
import com.shubhit.livescore.viewmodel.CurrentMatchesViewModel
import com.shubhit.livescore.viewmodel.getViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: CurrentMatchesViewModel
    lateinit var adapter: CricketAdapter
    lateinit var cricketItemList:ArrayList<Data>
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView=binding.rv

        






        viewModel=getViewModel { CurrentMatchesViewModel() }


        val params=HashMap<String,String>()
        params.put("apikey","4d4e0b76-ce79-4371-be9b-5a35218420ed")

        viewModel.getCurrentMatches(params)

        viewModel.currentMatchResult.observe(this){

            adapter= CricketAdapter(it.data as ArrayList<Data>)
            recyclerView.adapter=adapter
        }

        viewModel.error.observe(this){
            Toast.makeText(this, "Error + ${it.exception}" , Toast.LENGTH_SHORT).show()
            println("Exception : ${it.exception}")
        }

    }
}