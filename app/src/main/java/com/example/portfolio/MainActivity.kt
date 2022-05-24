package com.example.portfolio

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                val status = remember {
                    mutableStateOf(false)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colors.background

                ) {
                    Card(
                        modifier = Modifier
                            .width(200.dp)
                            .height(390.dp)
                            .padding(12.dp),
                        shape = RoundedCornerShape(corner = CornerSize(15.dp))
                    ) {
                        Column(
                            modifier = Modifier.height(300.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CreateImageProfile()
                            createInfo()
                            Divider()
                            Button(onClick = {
                                status.value = !status.value
                            }) {
                                Text(text = "Portfolio")
                            }
                            if(status.value)
                                Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun createInfo(){
    Column(modifier = Modifier.padding(3.dp)) {
        Text(text = "Le Ngoc Hai", style = MaterialTheme.typography.h4,
             color = MaterialTheme.colors.primaryVariant)
        Text(text = "Android programing", modifier = Modifier.padding(3.dp))
        Text(text = "@lengochai", modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
fun CreateImageProfile(){
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile image",
        modifier = Modifier.size(135.dp),
        contentScale = ContentScale.Crop)
    }
}

@Composable
fun Portfolio(data: List<String>){
    LazyColumn{
        items(data) {
            item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                ) {
                    CreateImageProfile()
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "great project", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PortfolioTheme {
        Greeting("Android")
    }
}