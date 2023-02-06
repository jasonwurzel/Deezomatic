package com.auto.deezomatic.common

import android.app.Application
import com.auto.deezomatic.CommonDependencyModule
import com.auto.deezomatic.dataaccess.DataAccessDependencyModule
import com.auto.deezomatic.mediaplayback.PlaybackDependencyModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DependencyBootstrapper {
    fun bootstrap(application: Application) {
        startKoin {
            androidContext(application)
            modules(dependencyModules())
        }
    }

    private fun dependencyModules() = listOf(
        CommonDependencyModule.dependencies(),
        DataAccessDependencyModule.dependencies(),
        PlaybackDependencyModule.dependencies()
    )
}