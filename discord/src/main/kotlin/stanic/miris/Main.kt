package stanic.miris

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import stanic.miris.commands.testCommand
import stanic.miris.rest.startService

class Main {

    lateinit var jda: JDA
    val disabled = ArrayList<String>()

    companion object {
        lateinit var INSTANCE: Main

        @JvmStatic fun main(args: Array<String>) {
            INSTANCE = Main()

            JDABuilder.createDefault("TOKEN")
                .setActivity(Activity.playing("MiriS!"))
                .build()
                .awaitReady().runCatching {
                    INSTANCE.jda = this

                    testCommand()
                }

            embeddedServer(Netty, 4567) {
                startService()
            }.start(true)
        }
    }

}
