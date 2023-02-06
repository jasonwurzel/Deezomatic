package com.auto.deezomatic.mediaplayback

import android.content.Context
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import com.auto.deezomatic.R
import com.auto.deezomatic.domain.Song
import com.google.android.exoplayer2.MediaItem

class MediaItemFactory(private val context: Context) {
    fun createBrowsableRootMediaItem(rootId: String): MediaMetadataCompat =
        MediaMetadataCompat.Builder().apply {
            id = rootId
            title = context.getString(R.string.browsable_tab_label)
            flag = MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
        }.build()

    fun createPlayableMediaItem(song: Song, playlistSize: Int, songNumber: Int): MediaMetadataCompat =
        MediaMetadataCompat.Builder().apply {
            id = song.id
            title = song.title
            mediaUri = song.mediaUri
            artist = song.artist
            albumArtUri = song.mediaArtUri
            numberOfTracks = playlistSize.toLong()
            trackNumber = songNumber.toLong()
            flag = MediaBrowserCompat.MediaItem.FLAG_PLAYABLE

            displayTitle = song.title
            displaySubtitle = song.subtitle
            displayDescription = song.description
            displayIconUri = song.mediaArtUri
        }.build()
}

fun MediaMetadataCompat.toExoMediaItem() = MediaItem.Builder()
    .setUri(mediaUri)
    .build()