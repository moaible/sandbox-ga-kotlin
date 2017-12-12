package io.github.moaible.kotlinexample.ui.main

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import io.github.moaible.kotlinexample.model.entity.User
import io.github.moaible.kotlinexample.ui.detail.DetailActivity
import javax.inject.Inject

/**
 * Created by moaible on 2017/12/13.
 */
class MainItemViewModel @Inject constructor(
        private val activity: Activity
): ViewModel() {
    val user: ObservableField<User> = ObservableField()

    fun onItemClick(view: View) {
        DetailActivity.start(activity, user.get().id)
    }
}