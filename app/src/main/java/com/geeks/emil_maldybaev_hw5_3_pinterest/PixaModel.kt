package com.geeks.emil_maldybaev_hw5_3_pinterest

data class PixaModel (
    val hits: List<ImageModel>
)

class ImageModel (
    val largeImageURL: String
)