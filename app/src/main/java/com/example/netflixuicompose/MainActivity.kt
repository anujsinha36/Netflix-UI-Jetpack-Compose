package com.example.netflixuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixuicompose.ui.theme.NetflixUIComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(modifier = Modifier
                .fillMaxSize().padding(top = 20.dp)
                .background(color = Color.Black) .verticalScroll(rememberScrollState())) {
                NetflixToolBar()
                NetflixContentChooser()
                NetflixFeaturedContent()
                NetflixMovies("Continue Watching")
                NetflixMovies("Watch It Again")
                NetflixMovies("New Releases")
                NetflixMovies("Recommended for you")

            }

        }
    }
    @Composable

    fun NetflixToolBar(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(start = 15.dp, top = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.netflix_icon),
                contentDescription = "netflix", modifier = Modifier.size(70.dp))
            Row(
                modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search", modifier = Modifier
                        .size(40.dp)
                        .padding(end = 5.dp))
                Image(painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "user", modifier = Modifier
                        .size(40.dp)
                        .padding(end = 5.dp))
            }

        }
    }

    @Composable

    fun NetflixContentChooser(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 15.dp,)
            , horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", fontSize = 15.sp, color = Color.LightGray)
            Text(text = "Movies", fontSize = 15.sp, color = Color.LightGray)
            Row(modifier = Modifier.padding(end = 5.dp)
                , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically)
            {
                Text(text = "Categories", fontSize = 15.sp, color = Color.LightGray)
                Image(painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "user")
            }
        }
    }

    @Composable
    fun NetflixFeaturedContent(){
        Column(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 30.dp)
                .fillMaxWidth()

        ) {
            Image(painter = painterResource(id = R.drawable.superstition_poster),
                contentDescription = "poster", modifier = Modifier
                    .size(400.dp)
                    .padding(horizontal = 50.dp))
            Row(
                modifier = Modifier
                    .padding(top = 60.dp, start = 45.dp, end = 45.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Crime",fontSize = 15.sp, color = Color.LightGray)
                Text(text = "Comedy",fontSize = 15.sp, color = Color.LightGray)
                Text(text = "Drama",fontSize = 15.sp, color = Color.LightGray)
                Text(text = "Horror",fontSize = 15.sp, color = Color.LightGray)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 55.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_add) , contentDescription = "add")
                    Text(text = "My List", color = Color.LightGray, fontSize = 12.sp)
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp))
                    {
                        Text(text = "Play", color = Color.Black)
                    }
                            Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_info),
                            contentDescription = "info"
                        )
                        Text(text = "Info", color = Color.LightGray, fontSize = 12.sp)
                    }
            }
        }
    }
    @Composable
    fun NetflixMovies(listOfMovies1 : String){
        //val listOfMovies = mutableListOf<NetflixUI>()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        ) {
            Text(text = listOfMovies1, color = Color.White, fontSize = 20.sp)
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                itemsIndexed(NetflixMovieList()){ index, item ->
                    Image(painter = painterResource(id = item.image), contentDescription = "",
                        modifier = Modifier.height(200.dp).width(150.dp)

                        )
                }
            }
        }
    }

fun NetflixMovieList() : List<NetflixUI>
    {
    val listOfMovies = mutableListOf<NetflixUI>()
    listOfMovies.add(NetflixUI(
        image = R.drawable.banquet_poster
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.superstition_poster
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster14
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster13
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster12
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster3
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster4
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster5
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster6
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster7
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster8
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster9
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster10
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster11
    ))
    listOfMovies.add(NetflixUI(
        image = R.drawable.poster15
    ))
        listOfMovies.shuffle()
   return listOfMovies
}
}

data class NetflixUI(
    val image : Int
)