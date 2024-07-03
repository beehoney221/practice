package com.example.marvel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel.Hero
import com.example.marvel.data.Heroes

val marvelLogo = "https://iili.io/JMnuvbp.png"

@Composable
fun StartScreen(navController: NavHostController) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(marvelLogo)
                    .crossfade(true)
                    .build(),
                contentDescription = "Marvel Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 220.dp, height = 120.dp).padding(top = 40.dp, bottom = 30.dp)
            )

            Text(
                text = "Choose your hero",
                fontSize = 35.sp,
                fontWeight = FontWeight(weight = 1000),
                color = Color.White,
                modifier = Modifier.padding(top = 15.dp, bottom = 10.dp)
            )

            ScrollableList(heroes = Heroes.listHero, navController = navController)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ScrollableList(
    heroes: List<Hero>,
    navController: NavHostController) {
    LazyRow(
        contentPadding = PaddingValues(all = 20.dp),
        modifier = Modifier.padding(start = 5.dp, end = 5.dp)){
        items(heroes) { hero ->
            Spacer(modifier = Modifier.padding(start = 15.dp))
            HeroCard(
                heroLogo = hero.logo,
                heroName = hero.name,
                onClick = {navController.navigate(hero.screen.name)}
            )
            Spacer(modifier = Modifier.padding(end = 20.dp))
        }
    }
}

@Composable
fun HeroCard(
    heroLogo: String,
    heroName: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(heroLogo)
                .crossfade(true)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)).clickable(onClick = onClick)
        )

        Text(
            text = heroName,
            fontSize = 35.sp,
            fontWeight = FontWeight(weight = 700),
            color = Color.White,
            modifier = Modifier
                .align(BottomStart)
                .padding(start = 20.dp, bottom = 30.dp)
        )
    }
}
