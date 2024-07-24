package com.chrisabbod.androidcoderefs

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chrisabbod.androidcoderefs.data.DataSource
import com.chrisabbod.androidcoderefs.ui.components.ListItem
import com.chrisabbod.androidcoderefs.ui.theme.AndroidCodeRefsTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AndroidCodeRefsScreen() {
    Scaffold(
        topBar = { AndroidCodeRefsAppBar() }, // TODO: Make better theme including color matching for system bar
        content = { AndroidCodeRefsMainList() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidCodeRefsAppBar() {
    Column {
        TopAppBar(
            title = { Text(stringResource(id = R.string.app_name)) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Black
        )
    }
}

@Composable
fun AndroidCodeRefsMainList() {
    //TODO: Fix top of list being cut off behind app bar in landscape
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(DataSource.moduleList) { item ->
            val context = LocalContext.current

            ListItem(
                item = item,
                onClick = {
                    when(item.name){
                        "Cupcake" -> launchCupcakeModule(context)
                    }
                }
            )
        }
    }
}

fun launchCupcakeModule(context: Context) {
    val intent = Intent().setClassName("com.chrisabbod.cupcake", "com.chrisabbod.cupcake.CupcakeActivity")
    context.startActivity(intent)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AndroidCodeRefsScreenPreview() {
    AndroidCodeRefsTheme {
        AndroidCodeRefsScreen()
    }
}