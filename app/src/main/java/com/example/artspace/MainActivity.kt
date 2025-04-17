package com.example.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var nextClick by remember { mutableStateOf(1) }

    when (nextClick) {
        1 -> {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                ArtSpaceScreen(
                    image = painterResource(R.drawable.img_1),
                    title = stringResource(R.string.artwork_title_1),
                    artist = stringResource(R.string.artwork_artist_1_year_1)
                )
                Row {
                    Button(
                        onClick = {
                            nextClick = 3
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(start = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_previous),
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            nextClick = 2
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(end = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_next),
                            modifier = Modifier
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }

        2 -> {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                ArtSpaceScreen(
                    image = painterResource(R.drawable.img_2),
                    title = stringResource(R.string.artwork_title_2),
                    artist = stringResource(R.string.artwork_artist_2_year_2)
                )
                Row {
                    Button(
                        onClick = {
                            nextClick = 1
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(start = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_previous),
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            nextClick = 3
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(end = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_next),
                            modifier = Modifier
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }

        3 -> {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                ArtSpaceScreen(
                    image = painterResource(R.drawable.img_3),
                    title = stringResource(R.string.artwork_title_3),
                    artist = stringResource(R.string.artwork_artist_3_year_3)
                )
                Row {
                    Button(
                        onClick = {
                            nextClick = 2
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(start = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_previous),
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            nextClick = 1
                        },
                        Modifier
                            .weight(0.5f)
                            .padding(end = 80.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_text_next),
                            modifier = Modifier
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(image: Painter, title: String, artist: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()//Width
    ) {
        Image(
            painter = image,
            contentDescription = "1",
            modifier = modifier
                .padding(80.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = artist
            )
        }
        Spacer(modifier = modifier.height(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
