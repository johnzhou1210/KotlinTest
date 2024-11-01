package com.example.kotlintest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(innerPadding: PaddingValues) {
    var counter by remember { mutableIntStateOf(0) }

    Column {
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .padding(innerPadding)
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {

            Text(
                text = "$counter",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 256.sp,
                modifier = Modifier.padding(16.dp),
                fontFamily = FontFamily.Monospace,
            )
        }

        Row(
            modifier = Modifier

                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ResetButton { counter = 0 }
        }

        Spacer(modifier = Modifier.height(220.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DecrementButton { counter -= 1 }
            Spacer(modifier = Modifier.width(32.dp))
            IncrementButton { counter += 1 }
        }

    }
}


@Composable
fun IncrementButton(onIncrement: () -> Unit) {
    Button(
        onClick = onIncrement,
        Modifier
            .width(150.dp)
            .height(50.dp)
    ) {
        Text("Increment", fontSize = 16.sp, fontFamily = FontFamily.Monospace)
    }
}

@Composable
fun DecrementButton(onDecrement: () -> Unit) {
    Button(
        onClick = onDecrement,
        Modifier
            .width(150.dp)
            .height(50.dp)
    ) {
        Text("Decrement", fontSize = 16.sp, fontFamily = FontFamily.Monospace)
    }
}

@Composable
fun ResetButton(onReset: () -> Unit) {
    Button(
        onClick = onReset,
        Modifier
            .width(100.dp)
            .height(40.dp)
    ) {
        Text("Reset", fontSize = 16.sp, fontFamily = FontFamily.Monospace)
    }
}
