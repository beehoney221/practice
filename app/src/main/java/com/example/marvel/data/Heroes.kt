package com.example.marvel.data

import com.example.marvel.Hero
import com.example.marvel.MarvelScreen

object Heroes {
    val listHero = listOf(
        Hero(
            logo = "https://iili.io/dK7naEv.md.png",
            name = "Deadpool",
            description = "Please don’t make the super suit green...or animated!",
            screen = MarvelScreen.Deadpool
        ),
        Hero(
            logo = "https://iili.io/dK7obUl.md.png",
            name = "Iron Man",
            description = "I AM IRON MAN",
            screen = MarvelScreen.IronMan
        ),
        Hero(
            logo = "https://iili.io/dK7x3ib.md.png",
            name = "Spider Man",
            description = "In iron suit",
            screen = MarvelScreen.SpiderMan
        )
    )
}