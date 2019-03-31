package com.example.recyclerviewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel

        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list.setHasFixedSize(true)
        val adapter = MainListAdapter()
        list.adapter = adapter

        // 初期データ投入
        val list = mutableListOf<Store>()
        for (i in 1..10) {
            val place = "赤坂" + i + "号店"
            list.add(Store("RNIマート", place))
        }
        adapter.items.addAll(list)
        // 追加データ投入
        handler.postDelayed({
            val list = mutableListOf<Store>()
            for (i in 1..3) {
                val place = "追加$i"
                list.add(Store("RNIマート", place))
            }
            adapter.items.addAll(5, list)
        }, 2000)
        // 削除する
        handler.postDelayed({
            adapter.items.removeAt(9)
            adapter.items.removeAt(9)
            adapter.items.removeAt(9)
        }, 4000)
        // 変更する
        handler.postDelayed({
            val list = mutableListOf<Store>()
            for (i in 1..3) {
                val place = "変更$i"
                list.add(Store("RNIマート", place))
            }
            for(i in 0..2)
                adapter.items[1 + i] = list[i]

        }, 6000)
    }
}
