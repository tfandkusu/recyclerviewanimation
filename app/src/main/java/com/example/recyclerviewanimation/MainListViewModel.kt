package com.example.recyclerviewanimation

import androidx.databinding.ObservableField

class MainListViewModel() {
    /**
     * チェーン名
     */
    val chain = ObservableField<String>()

    /**
     * 店舗名
     */
    val place = ObservableField<String>()
}