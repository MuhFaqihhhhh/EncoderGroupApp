package com.Encoder.EncoderGroupApp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Encoder.EncoderGroupApp.ui.theme.EncoderGroupAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EncoderGroupAppTheme {
                // Test Toast langsung di onCreate
                Toast.makeText(this, "App Started", Toast.LENGTH_SHORT).show()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GroupScreen(
                        modifier = Modifier.padding(innerPadding),
                        onMemberClick = { memberName ->
                            Toast.makeText(this, "Hello, $memberName", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun GroupScreen(modifier: Modifier = Modifier, onMemberClick: (String) -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Nama Kelompok: ENCODER",
            style = MaterialTheme.typography.headlineLarge
        )
        val members = listOf(
            "Husni Abdillah",
            "Daffa Naufal Mumtaz Heryadi",
            "Jordan Vieno Simamora",
            "Cokorda GD. Satria Widnyana Putra",
            "Cut Nadya Putri Khairunnisa",
            "Yasir",
            "Hilfani Rayyanne Subagio",
            "Rahma Dhana",
            "Nabila Sayyidatul Aflah",
            "Rafif Muhammad Farras",
            "Muhammad Faqih"
        )
        members.forEach { member ->
            Text(
                text = member,
                modifier = Modifier
                    .clickable { onMemberClick(member) }
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroupScreenPreview() {
    EncoderGroupAppTheme {
        GroupScreen(onMemberClick = {})
    }
}
