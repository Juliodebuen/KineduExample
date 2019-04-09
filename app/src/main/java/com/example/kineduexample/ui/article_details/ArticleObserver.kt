package com.example.kineduexample.ui.article_details

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.kineduexample.BR

class ArticleObserver(): BaseObservable() {

    var body: String
    @Bindable get() = body
    set(value) {
        body = value
        notifyPropertyChanged(BR.body)
    }

    var tTitle: String
    @Bindable get() = tTitle
    set(value) {
        tTitle = value
        notifyPropertyChanged(BR.tTitle)
    }
}