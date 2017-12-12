package io.github.moaible.kotlinexample.ui.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import io.github.moaible.kotlinexample.App
import io.github.moaible.kotlinexample.di.ActivityComponent
import io.github.moaible.kotlinexample.di.ActivityModule
import java.util.ArrayList

/**
 * Created by moaible on 2017/12/13.
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {
    val injector: ActivityComponent
        get() {
            val app = applicationContext as App
            return app.injector.activityComponent(ActivityModule(this))
        }
}