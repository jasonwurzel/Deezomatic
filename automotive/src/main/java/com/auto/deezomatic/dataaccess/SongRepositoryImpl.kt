package com.auto.deezomatic.dataaccess

import com.auto.deezomatic.domain.Playlist
import com.auto.deezomatic.domain.SongRepository

class SongRepositoryImpl(private val playlistFactory: PlaylistFactory) : SongRepository {
    override fun retrievePlaylist(): Playlist = playlistFactory.createPlaylist()
}
