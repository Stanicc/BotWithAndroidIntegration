package stanic.miris.rest

import io.ktor.application.*
import io.ktor.routing.*
import stanic.miris.Main
import stanic.miris.utils.reply

fun Application.startService() {
    routing {
        post("/say") {
            val text = call.request.queryParameters["text"] ?: return@post

            Main.INSTANCE.jda.getGuildById("757379359060525099")!!.getTextChannelById("757379359060525102")!!.reply(text)
        }
        post("/command") {
            val command = call.request.queryParameters["command"] ?: return@post
            val type = call.request.queryParameters["type"] ?: return@post

            if (type.toInt() == 1) {
                Main.INSTANCE.disabled.remove(command)
                Main.INSTANCE.jda.getGuildById("757379359060525099")!!.getTextChannelById("757379359060525102")!!.reply("✅ | Enabled the command !$command")
            } else {
                Main.INSTANCE.disabled.add(command)
                Main.INSTANCE.jda.getGuildById("757379359060525099")!!.getTextChannelById("757379359060525102")!!.reply("❗ | Disabled the command !$command")
            }
        }
    }
}