package io.github.moaible.kotlinexample.di

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import io.github.moaible.kotlinexample.di.scope.PerActivity

/**
 * Created by moaible on 2017/12/13.
 */
@Module
class ActivityModule(private val activity: FragmentActivity) {

    @PerActivity
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @PerActivity
    @Provides
    fun provideLifecycle(): Lifecycle {
        return activity.lifecycle
    }

}