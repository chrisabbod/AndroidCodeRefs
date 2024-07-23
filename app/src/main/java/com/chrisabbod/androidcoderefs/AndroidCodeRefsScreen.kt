package com.chrisabbod.androidcoderefs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chrisabbod.androidcoderefs.data.DataSource
import com.chrisabbod.androidcoderefs.ui.components.ListItem

@Composable
fun AndroidCodeRefsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DataSource.moduleList.forEach { item ->
            ListItem(item)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AndroidCodeRefsScreenPreview() {
    AndroidCodeRefsScreen()
}