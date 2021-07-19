package com.aaron.hulanative.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.aaron.hulanative.R
import com.aaron.hulanative.common.CommonRecyclerAdapter
import com.aaron.hulanative.common.CommonRecyclerHolder
import com.aaron.hulanative.ui.mine.adapter.VPAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var mAdapter: CommonRecyclerAdapter<String?>
    private lateinit var tabBar: TabLayout
    private lateinit var viewPager: ViewPager2
    private var mStringList: List<String>? = null
    private val mToolBar: Toolbar? = null
    private val tabs = listOf("发布","清单","足迹")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = inflater.inflate(R.layout.fragment_profile, container, false)
        tabBar = fragment.findViewById(R.id.tab_bar)
        viewPager = fragment.findViewById(R.id.vp)
        viewPager.adapter = VPAdapter(activity as AppCompatActivity)
        TabLayoutMediator(tabBar,viewPager) {
                tab, position ->
            tab.text = tabs[position]
        }.attach()

        return fragment
    }
}