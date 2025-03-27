package com.shivang.pwassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shivang.pwassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG= "MainActivity"
    private lateinit var adapter: MainPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()

    }

    private fun setUpViews() {

        viewPager= binding.pager
        tabLayout= binding.tabLayout
        adapter= MainPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter= adapter

        val list= listOf("DashBoard", "Pitara", "Maths", "Science", "English", "More")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = list[position]
        }.attach()

        binding.ivPw.setOnClickListener {
            startActivity(Intent(this, InteractiveLearning::class.java))
        }
    }
}