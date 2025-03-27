package com.shivang.pwassignment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 6

class MainPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle)  {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> return DashBoardFragment()
            1 -> return DashBoardFragment()
            2 -> return DashBoardFragment()
            3 -> return DashBoardFragment()
            4 -> return DashBoardFragment()
            5 -> return DashBoardFragment()
        }
        return DashBoardFragment()
    }
}