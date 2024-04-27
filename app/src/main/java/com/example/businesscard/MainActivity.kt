package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidScreen(name = "Arjit Gautam", phoneNum = "+91 9770030060", email = "arjitgautamw2015@gmail.com")
                }
            }
        }
    }
}

@Composable
fun AndroidScreen(name: String, phoneNum: String, email: String, modifier: Modifier = Modifier.background(color = Color.Gray)){
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFD3F5D4))) {
        Upper(name = name )
        Lower(phoneNum = phoneNum, email = email )
    }
}

@Composable
fun Upper(name: String){
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(top = 250.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Developer Logo",
            Modifier
                .size(100.dp)
                .background(Color(0xFF004D40)),
        )
        Text(text = name, fontSize = 40.sp)
        Text(text = "Android Developer Extraordinaire", fontSize = 18.sp, color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Lower(phoneNum: String, email: String){
    Row(Modifier.fillMaxWidth().padding(top = 200.dp, end = 15.dp, start = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()){
            Icon(
                painter = painterResource(id = R.drawable.call_icon),
                contentDescription = null,
                tint = Color(0xFF2E7D32),
                modifier = Modifier.size(25.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.share_icon),
                contentDescription = null,
                tint = Color(0xFF2E7D32),
                modifier = Modifier.size(25.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.email_icon),
                contentDescription = null,
                tint = Color(0xFF2E7D32),
                modifier = Modifier.size(25.dp)
            )
        }
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 20.dp).fillMaxHeight()) {
            Text(text = phoneNum,
                fontSize = 18.sp,
                )
            Text(text = "@Android Dev",
                fontSize = 18.sp,
                )
            Text(text = email,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        AndroidScreen(name = "Arjit Gautam", phoneNum = "+91 9770030060", email = "arjitgautamw2015@gmail.com")
    }
}