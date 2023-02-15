package com.auto.deezomatic

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import api.deezer.DeezerApi
import api.deezer.objects.Permission
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val deezerApi = DeezerApi()
        val loginUrl: String = deezerApi.auth().getLoginUrl(
            581184,
            "https://callback.deezomatic.com",
            Permission.BASIC_ACCESS
        )

        val accessToken = deezerApi.auth().getAccessToken(581184, "1cc72bec361e51c5647b92a31ca6a007", "frf23d1a5d0542356554d2147b1a4a36").execute()

        deezerApi.setAccessToken(accessToken)
        val me = deezerApi.user().me.execute()
        val album = deezerApi.album().getById(72000342).execute()
        val a = album.artist

        assertEquals(4, 2 + 2)
    }
}