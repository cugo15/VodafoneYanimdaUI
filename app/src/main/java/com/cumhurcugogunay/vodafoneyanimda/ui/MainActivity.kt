package com.cumhurcugogunay.vodafoneyanimda.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.cumhurcugogunay.vodafoneyanimda.R
import com.cumhurcugogunay.vodafoneyanimda.data.entity.Stories
import com.cumhurcugogunay.vodafoneyanimda.data.entity.Tarifelerim
import com.cumhurcugogunay.vodafoneyanimda.databinding.ActivityMainBinding
import com.cumhurcugogunay.vodafoneyanimda.ui.adapter.StoriesAdapter
import com.cumhurcugogunay.vodafoneyanimda.ui.adapter.ViewPageAdapter
import me.relex.circleindicator.CircleIndicator3

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStories.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        val adapter = StoriesAdapter(this@MainActivity,addStories())
            binding.rvStories.adapter = adapter
            binding.bottomNavigationView.itemIconTintList = null

        
        binding.viewPager2.adapter = ViewPageAdapter(this@MainActivity,addTarife())
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        indicator3.setViewPager(binding.viewPager2)


    }
    private fun addStories() :ArrayList<Stories>{
        val storyList = ArrayList<Stories>()
        val s1 = Stories(1,"Davet Et Kazan!","davetetkazan",true,true)
        val s2 = Stories(2,"Her Şey\nYanımda","herseyyanimda",true,true)
        val s3 = Stories(3,"Fiber İnternet","fiberinternet",true,true)
        val s4 = Stories(4,"Faturaya\nEk Cihazlar","tarifeyeekcihaz",true,false)
        val s5 = Stories(5,"Faturana\nYansıt Kazan","faturanayansitkazan",true,false)
        val s6 = Stories(6,"Seyahat Yanımda","seyahatyanimdaa",true,false)
        val s7 = Stories(7,"Hediye Çarkı","hediyecarki",false,false)
        val s8 = Stories(8,"3GB Anında\nHediye","gbavi",false,false)
        storyList.add(s1)
        storyList.add(s2)
        storyList.add(s3)
        storyList.add(s6)
        storyList.add(s4)
        storyList.add(s5)
        storyList.add(s7)
        storyList.add(s8)
        return storyList
    }
    private fun addTarife() :ArrayList<Tarifelerim>{
        val tarifeList = ArrayList<Tarifelerim>()
        val s1 = Tarifelerim(1,"Yurt İçi İnternet",14.0,20,"Son Tarih: 16 Ekim, 23:59",false)
        val s2 = Tarifelerim(2,"Sosyal Medya",10.0,20,"Son Tarih: 16 Ekim, 23:59",false)
        val s3 = Tarifelerim(3,"Red Pass İletişim",10.0,20,"Son Tarih: 16 Ekim, 23:59",true)

        tarifeList.add(s1)
        tarifeList.add(s2)
        tarifeList.add(s3)
        return tarifeList
    }
}