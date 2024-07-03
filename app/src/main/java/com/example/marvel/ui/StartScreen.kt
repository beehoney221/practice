package com.example.marvel.ui

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.marvel.Hero
import com.example.marvel.MarvelScreen
import com.example.marvel.R
import com.example.marvel.data.Heroes

@Composable
fun StartScreen(navController: NavHostController) {
    Surface(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(id = R.drawable.marvellogo),
                contentDescription = "Logo",
                modifier = Modifier.size(160.dp)
            )

            Text(
                text = "Choose your hero",
                fontSize = 30.sp,
                fontWeight = FontWeight(weight = 1000),
                color = Color.White,
                modifier = Modifier.padding(top = 0.dp, bottom = 5.dp)
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
            Spacer(modifier = Modifier.padding(start = 20.dp))
            HeroCard(
                heroId = hero.id,
                heroName = hero.name,
                onClick = {navController.navigate(hero.screen.name)}
            )
            Spacer(modifier = Modifier.padding(end = 20.dp))
        }
    }
}

@Composable
fun HeroCard(
    heroId: Int,
    heroName: String,
    onClick: () -> Unit
) {
    //val painter = rememberAsyncImagePainter(hero.usd)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxHeight(),
    ) {
        /**AsyncImage(
        model = hero.heroLogoModel,
        contentDescription = "ImageRequest example",
        modifier = Modifier.size(50.dp)
        )*/
        /**AsyncImage(
        model = hero.heroLogoModel,
        contentDescription = "ImageRequest example",
        modifier = Modifier.size(50.dp)
        )*/
        /**AsyncImage(
        model = hero.heroLogoModel,
        contentDescription = "ImageRequest example",
        modifier = Modifier.size(50.dp)
        )*/

        /**AsyncImage(
        model = hero.heroLogoModel,
        contentDescription = "ImageRequest example",
        modifier = Modifier.size(50.dp)
        )*/
        Image(
            painter = painterResource(id = heroId),
            contentDescription = "example using async image painter",
            alignment = TopCenter,
            modifier = Modifier.clip(RoundedCornerShape(16.dp)).clickable(onClick = onClick)
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
