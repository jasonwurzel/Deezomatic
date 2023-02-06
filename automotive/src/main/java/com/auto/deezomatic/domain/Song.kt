package com.auto.deezomatic.domain

data class Song(
    val id: String,
    val artist: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val mediaArtUri: String,
    val mediaUri: String
)
