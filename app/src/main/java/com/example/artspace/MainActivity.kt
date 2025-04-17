package com.example.artspace

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.nio.file.WatchEvent

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
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        ArtSpaceScreen(
            image = painterResource(R.drawable.img_1),
            title = stringResource(R.string.artwork_title_1),
            artist = stringResource(R.string.artwork_artist_1_year_1)
        )
        Spacer(modifier = Modifier.height(30.dp))

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
            contentDescription = null,
            modifier = modifier
                .padding(80.dp)
        )
        Column {
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
        Row {
            Button(
                onClick = {},
                Modifier.weight(0.5f)
                    .padding(start=80.dp)
            ) {
                Text(
                    text = "Previous",
                    modifier = Modifier

                )
            }
            Spacer(modifier = modifier.width(20.dp))
            Button(onClick = {},
                Modifier.weight(0.5f)
                    .padding(end = 80.dp)) {
                Text(
                    text = "Next",
                    modifier = Modifier
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}