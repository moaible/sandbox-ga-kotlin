package io.github.moaible.kotlinexample.di

import dagger.Subcomponent
import io.github.moaible.kotlinexample.di.scope.PerActivity
import io.github.moaible.kotlinexample.ui.detail.DetailActivity
import io.github.moaible.kotlinexample.ui.detail.DetailViewModel
import io.github.moaible.kotlinexample.ui.main.MainActivity
import io.github.moaible.kotlinexample.ui.main.MainItemViewModel
import io.github.moaible.kotlinexample.ui.main.MainViewModel

/**
 * Created by moaible on 2017/12/13.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun mainViewModel(): MainViewModel
    fun detailViewModel(): DetailViewModel

    fun mainItemViewModel(): MainItemViewModel
}