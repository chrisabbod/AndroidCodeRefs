package com.chrisabbod.cupcake

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chrisabbod.cupcake.data.DataSource
import com.chrisabbod.cupcake.ui.theme.CupcakeTheme

/**
 * Composable that allows the user to select the desired cupcake quantity and expects
 * [onNextButtonClicked] lambda that expects the selected quantity and triggers the navigation to
 * next screen
 */
@Composable
fun StartOrderScreen(
    quantityOptions: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CupcakeHeadline()
        CupcakeBody(quantityOptions = quantityOptions)
    }
}

@Composable
fun CupcakeHeadline() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = null,
            modifier = Modifier.width(300.dp)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Text(
            text = stringResource(id = R.string.order_cupcakes),
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    }
}

@Composable
fun CupcakeBody(quantityOptions: List<Pair<Int, Int>>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        quantityOptions.forEach { item ->
            SelectQuantityButton(
                labelResourceId = item.first,
                onClick = { /*TODO*/ }
            )
        }
    }
}
/**
 * Customizable button composable that displays the [labelResourceId]
 * and triggers [onClick] lambda when this composable is clicked
 */
@Composable
fun SelectQuantityButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(id = labelResourceId))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StartOrderPreview() {
    CupcakeTheme {
        StartOrderScreen(
            quantityOptions = DataSource.quantityOptions,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}