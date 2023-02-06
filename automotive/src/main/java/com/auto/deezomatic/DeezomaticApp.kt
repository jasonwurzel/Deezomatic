package com.auto.deezomatic

import android.app.Application
import com.auto.deezomatic.common.DependencyBootstrapper

class DeezomaticApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DependencyBootstrapper.bootstrap(this)
    }
}