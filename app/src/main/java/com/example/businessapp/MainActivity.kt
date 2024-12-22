package com.example.businessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businessapp.ui.theme.BusinessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorResource(id = R.color.light_greeen)) // Change background color here
                            .padding(innerPadding)
                    ) {
                        Information(
                            name = "Jennifer Doe",
                            profession = "Android Developer Extraordinaire"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Information(
    name: String,
    profession: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(180.dp))
        // Display profile image
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(100.dp)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Display name
        Text(
            text = name,
            fontSize = 50.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Display profession
        Text(
            text = profession,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.dark_greeen)
        )
        Spacer(modifier = Modifier.height(200.dp))

        // Contact Information
        Column{
            ContactRow(icon  = painterResource(R.drawable.phone), text = "+11 (123) 444 555 666")
            Spacer(modifier = Modifier.height(16.dp))
            ContactRow(
                icon = painterResource(R.drawable.share),
                text = "@AndroidDev"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactRow(icon = painterResource(R.drawable.email__1_),
                text = "jendoe@android.com")
        }
    }
}

@Composable
fun ContactRow(
    icon: Any,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 80.dp, end = 60.dp)
    ) {
        Icon(
            painter = icon as androidx.compose.ui.graphics.painter.Painter,
            contentDescription = null,
            tint = colorResource(id = R.color.dark_greeen),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.light_greeen)) // Change background color her
        ) {
            Information(
                name = "Jennifer Doe",
                profession = "Android Developer Extraordinaire"
            )
        }
    }
}
