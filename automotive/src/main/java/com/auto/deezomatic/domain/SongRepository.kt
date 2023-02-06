package com.auto.deezomatic.domain

interface SongRepository {
    fun retrievePlaylist() : Playlist
}
