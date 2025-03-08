package com.skyblue.composeui_lazycolumns

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skyblue.composeui_lazycolumns.ui.theme.ComposeUILazyColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUILazyColumnsTheme {
                MyComposeLayout()
                RecyclerView2(dummydata())
            }
        }
    }

    @Composable
    fun UserCard(userDetail: String) {
        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp).fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(10.dp))
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(60.dp)
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .align(alignment = Alignment.CenterVertically)
                )

                Text(text = userDetail, modifier = Modifier.padding(10.dp, 20.dp))
            }
        }
    }



    @Composable
    fun RecyclerView2(userDetails: List<UserDataSource>) {
        LazyColumn {
            items(items = userDetails) {
                UserCard(it.userDetail)
            }
        }
    }

    data class UserDataSource(
        var userDetail: String
    )

    fun dummydata(): List<UserDataSource> {
        return listOf(
            UserDataSource("Success is born from the determination to keep going when it gets tough."),
            UserDataSource("Success is the sum of small efforts repeated day in and day out."),
            UserDataSource("Success is not the key to happiness; happiness is the key to success."),
            UserDataSource("Believe in yourself, because you are your greatest source of motivation."),
            UserDataSource("Success is the sum of small efforts repeated day in and day out."),
            UserDataSource("Believe in yourself and you'll be unstoppable."),
            UserDataSource("Believe in yourself and your potential; the journey to success begins with self-confidence."),
            UserDataSource("Your potential is endless; keep pushing, keep believing, and don't give up."),
            UserDataSource("Success begins with the first step, so dare to take it."),
            UserDataSource("Believe in yourself, and you can achieve anything."))
    }
}

@Preview
@Composable
fun MyComposeLayout() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
    Toast.makeText(context, "Toast", Toast.LENGTH_LONG).show()
}

