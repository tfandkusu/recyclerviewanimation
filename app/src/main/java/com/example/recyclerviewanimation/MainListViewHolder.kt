package com.example.recyclerviewanimation

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.databinding.ListItemMainBinding

class MainListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val viewModel = MainListViewModel()

    init {
        val binding = DataBindingUtil.bind<ListItemMainBinding>(view)
        binding?.let {
            it.viewModel = viewModel
        }
    }
}