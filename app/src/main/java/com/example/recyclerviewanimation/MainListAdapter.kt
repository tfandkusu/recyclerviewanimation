package com.example.recyclerviewanimation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainListAdapter : RecyclerView.Adapter<MainListViewHolder>() {

    private val list = mutableListOf<Store>()

    init {
        for(i in 1..10){
            val place = "赤坂" + i + "号店"
            list.add(Store("RNIマート",place))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(vh: MainListViewHolder, position: Int) {
        vh.viewModel.chain.set(list[position].chain)
        vh.viewModel.place.set(list[position].place)
    }
}