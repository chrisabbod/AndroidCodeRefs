package com.chrisabbod.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chrisabbod.cupcake.ui.theme.AndroidCodeRefsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeRefsTheme {
               CupcakeApp()
            }
        }
    }
}