package io.github.moaible.kotlinexample.ui.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * BindingAdapter
 * Javaではstaticメソッドで定義していたが、Kotlinでは拡張関数を使うのがスマートぽい
 *
 * Created by moaible on 2017/12/13.
 */
@BindingAdapter(value = "imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url != null) {
        Glide.with(this.context).load(url).into(this)
    }
}