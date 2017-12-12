package io.github.moaible.kotlinexample.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by moaible on 2017/12/13.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

}