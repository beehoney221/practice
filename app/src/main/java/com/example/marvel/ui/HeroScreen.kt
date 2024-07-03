import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.marvel.Hero
import com.example.marvel.data.Heroes

@Composable
fun HeroScreen(
    hero: Hero,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.background(Color.Transparent)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.logo)
                .crossfade(true)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

//        Image(
//            painterResource(id = hero.id),
//            contentDescription = hero.name,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )

        IconButton(
            modifier = Modifier.padding(top = 5.dp, start = 5.dp),
            onClick = onClick
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Button Back",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }

        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, bottom = 80.dp, end = 30.dp)
        )
        {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ){
                Text(
                    text = hero.name,
                    fontSize = 40.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 15.dp)
                )

                Text(
                    text = hero.description,
                    fontSize = 29.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    lineHeight = 35.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun HeroScreenPreview(){
    HeroScreen(hero = Heroes.listHero[1], {})
}