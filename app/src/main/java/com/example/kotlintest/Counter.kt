package com.example.kotlintest

import android.content.Context
import android.os.Vibrator
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun Counter(innerPadding: PaddingValues) {
    var counter by remember { mutableIntStateOf(0) }
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (counterText, buttons) = createRefs()
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .constrainAs(counterText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)

                },
            contentAlignment = Alignment.Center
        ) {
            Spacer(modifier = Modifier.height(500.dp))
            Text(
                text = "$counter",
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 256.sp),
                modifier = Modifier,
                fontSize = if (counter.toString().length <= 2) 256.sp else if (counter.toString().length <= 3) 192.sp else 128.sp,

                fontFamily = FontFamily.Monospace,
                maxLines = 1,
            )
        }

        Column(modifier = Modifier.constrainAs(buttons) {
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.baseline)

        }) {
            Spacer(modifier = Modifier.height(480.dp))

            Row(
                modifier = Modifier

                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ResetButton {
                    counter = 0
                    vibrate(context)
                }
            }

            Spacer(modifier = Modifier.height(220.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DecrementButton {
                    counter -= 1
                    vibrate(context)
                }
                Spacer(modifier = Modifier.width(32.dp))
                IncrementButton {
                    counter += 1
                    vibrate(context)
                }
            }

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


fun vibrate(context: Context) {
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    vibrator.vibrate(50)
}
