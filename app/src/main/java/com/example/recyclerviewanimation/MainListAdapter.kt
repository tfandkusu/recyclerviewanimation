package com.example.recyclerviewanimation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerViewのアダプター。itemsの更新でnotify*メソッドによるアニメーションを行える。
 */
class MainListAdapter : RecyclerView.Adapter<MainListViewHolder>() {

    /**
     * 表示するデータ
     */
    val items = ObservableArrayList<Store>()

    init {
        // 更新監視
        items.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<Store>>(){

            /**
             * 初回挿入フラグ
             */
            private var firstInsert = true

            override fun onChanged(sender: ObservableList<Store>?) {
                // 実装しない
            }
            override fun onItemRangeMoved(
                sender: ObservableList<Store>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                // 実装しない

            }

            override fun onItemRangeInserted(sender: ObservableList<Store>?, positionStart: Int, itemCount: Int) {
                // 初回挿入のみアニメーションを無効化する
                if(firstInsert) {
                    notifyDataSetChanged()
                    firstInsert = false
                }
                else {
                    notifyItemRangeInserted(positionStart, itemCount)
                }
            }

            override fun onItemRangeChanged(sender: ObservableList<Store>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart,itemCount)
            }


            override fun onItemRangeRemoved(sender: ObservableList<Store>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart,itemCount)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(vh: MainListViewHolder, position: Int) {
        vh.viewModel.chain.set(items[position].chain)
        vh.viewModel.place.set(items[position].place)
    }
}