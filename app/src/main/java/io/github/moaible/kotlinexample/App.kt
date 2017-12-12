package io.github.moaible.kotlinexample

import android.app.Application
import com.facebook.stetho.Stetho
import io.github.moaible.kotlinexample.di.AppComponent
import io.github.moaible.kotlinexample.di.AppModule
import io.github.moaible.kotlinexample.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by moaible on 2017/12/13.
 */
class App: Application() {

    lateinit var injector: AppComponent

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Stetho.initializeWithDefaults(this)

        injector = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}