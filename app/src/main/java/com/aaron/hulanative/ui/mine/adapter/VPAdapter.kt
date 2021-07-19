package com.aaron.hulanative.ui.mine.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aaron.hulanative.ui.mine.ChecklistFragment
import com.aaron.hulanative.ui.mine.HistroyFragment
import com.aaron.hulanative.ui.mine.PublishFragment

class VPAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> PublishFragment()
            1 -> ChecklistFragment.newInstance(1)
            else -> HistroyFragment()
        }
    }
}

