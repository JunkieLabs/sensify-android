package io.sensify.sensor.ui.labs.viewpager

import io.sensify.sensor.R

/**
 * Created by Manish Kumar on 27/07/22.
 */

data class KidsData(

    val title :String,
    val rating : Float,
    val desc :String,
    val imgUri:Int
)

/**
 * create Kids List
 * */

val kidsList = listOf(
    KidsData(
        "Sitting Pretty",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_1
    ),
    KidsData(
        "Love her Expression",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_2
    ),
    KidsData(
        "Childhood Superman",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_3
    ),
    KidsData(
        "Candle Night At Marina",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_4
    ),
    KidsData(
        "Girl with Beautiful smile",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_5
    ),
    KidsData(
        "Bath Time",
        4.0f,
        "All the Children in the word are cute and innocent for like this...",
        R.drawable.image_6
    )

)