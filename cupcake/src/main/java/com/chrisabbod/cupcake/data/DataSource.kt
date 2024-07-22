package com.chrisabbod.cupcake.data

import android.content.Context
import androidx.annotation.StringRes
import com.chrisabbod.cupcake.R

object DataSource {
    val flavors = listOf(
        R.string.vanilla,
        R.string.chocolate,
        R.string.red_velvet,
        R.string.salted_caramel,
        R.string.coffee,
    )

    val quantityOptions = listOf(
        Pair(R.string.one_cupcake, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )

    fun mapIdToString(context: Context, idList: List<Int>) : List<String> {
        return idList.map { id ->
            context.resources.getString(id)
        }
    }
}