package com.example.marvel

import com.example.marvel.ui.HeroScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel.data.Heroes
import com.example.marvel.ui.StartScreen

data class Hero(val logo: String, val name: String, val description: String, val screen: MarvelScreen)

enum class MarvelScreen {
    Start,
    Deadpool,
    IronMan,
    SpiderMan
}

@Composable
fun MarvelApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold ()
    {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MarvelScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = MarvelScreen.Start.name) {
                StartScreen(navController)
            }

            composable(route = MarvelScreen.Deadpool.name){
                HeroScreen(
                    hero = Heroes.listHero[0],
                    onClick = { navController.navigateUp() }
                )
            }

            composable(route = MarvelScreen.IronMan.name){
                HeroScreen(
                    hero = Heroes.listHero[1],
                    onClick = { navController.navigateUp() }
                )
            }

            composable(route = MarvelScreen.SpiderMan.name){
                HeroScreen(
                    Heroes.listHero[2],
                    onClick = { navController.navigateUp() }
                )
            }
        }
    }
}
