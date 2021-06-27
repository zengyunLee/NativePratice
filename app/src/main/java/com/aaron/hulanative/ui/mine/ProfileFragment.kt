package com.aaron.hulanative.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaron.hulanative.R
import com.aaron.hulanative.common.CommonRecyclerAdapter
import com.aaron.hulanative.common.CommonRecyclerHolder
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var mAdapter: CommonRecyclerAdapter<String?>
    private lateinit var rv : RecyclerView
    private var mStringList: List<String>? = null
    private val mToolBar: Toolbar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mStringList = ArrayList<String>()
        for (i in 0..99) {
            (mStringList as ArrayList<String>).add("测试：$i")
        }
        mAdapter = object : CommonRecyclerAdapter<String?>(
            this.context,
            mStringList,
            R.layout.layout_item
        ) {
            override fun convert(
                holder: CommonRecyclerHolder,
                item: String?,
                position: Int,
                isScrolling: Boolean
            ) {
                holder.setText(R.id.item_text, mStringList?.get(position))
            }
        }
        val fragment = inflater.inflate(R.layout.fragment_profile, container, false)
        rv = fragment.findViewById(R.id.recyclerView)
        rv.adapter = mAdapter
        rv.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        return fragment
    }
}