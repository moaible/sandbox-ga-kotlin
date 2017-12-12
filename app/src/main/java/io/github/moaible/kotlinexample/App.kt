package io.github.moaible.kotlinexample

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.android.gms.analytics.Tracker
import io.github.moaible.kotlinexample.di.AppComponent
import io.github.moaible.kotlinexample.di.AppModule
import io.github.moaible.kotlinexample.di.DaggerAppComponent
import timber.log.Timber
import com.google.android.gms.analytics.GoogleAnalytics



/**
 * Created by moaible on 2017/12/13.
 */
class App: Application() {

    lateinit var injector: AppComponent

    lateinit var tracker: Tracker

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Stetho.initializeWithDefaults(this)
        val analytics = GoogleAnalytics.getInstance(this)
        tracker = analytics.newTracker(R.xml.global_tracker)
        injector = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}
