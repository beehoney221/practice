package com.example.marvel.data

import com.example.marvel.Hero
import com.example.marvel.MarvelScreen
import com.example.marvel.R

object Heroes {
    val listHero = listOf(
        Hero(
            id = R.drawable.deadpool,
            name = "Deadpool",
            description = "Please don’t make the super suit green...or animated!",
            screen = MarvelScreen.Deadpool
        ),
        Hero(
            id = R.drawable.ironman,
            name = "Iron Man",
            description = "I AM IRON MAN",
            screen = MarvelScreen.IronMan
        ),
        Hero(
            id = R.drawable.spiderman,
            name = "Spider Man",
            description = "In iron suit",
            screen = MarvelScreen.SpiderMan
        )
    )
}