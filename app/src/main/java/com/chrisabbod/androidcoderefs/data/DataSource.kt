package com.chrisabbod.androidcoderefs.data

/**
 * \`DataSource\` is a singleton object that provides a list of modules for the application.
 *
 * This object follows the Singleton design pattern, ensuring that only one instance of the
 * \`DataSource\` exists throughout the application's lifecycle. It is used to supply data
 * related to the modules available in the app.
 *
 */
object DataSource {
    val moduleList = listOf(
        ModuleData(
            "Cupcake",
            "Topics: Navigation, App Bar & Back Navigation, creating a Chooser, radio buttons, loops to create rows in UI",
        ),
        ModuleData(
            "Todo List",
            "Topics: TBD",
        ),
        ModuleData(
            "TBD",
            "Topics: TBD",
        ),
        ModuleData(
            "Hello Darling",
            "Topics: Dumpling sherma, Alex boosa, Lucas bumboola",
        )
    )
}

