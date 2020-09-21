package stanic.miris.commands

import net.dv8tion.jda.api.JDA
import stanic.miris.Main
import stanic.miris.utils.command.command
import stanic.miris.utils.reply

fun JDA.testCommand() = command("test") {
    if (Main.INSTANCE.disabled.contains("test")) channel.reply(":x: | This command is disabled")
    else {
        channel.reply("Test success!")
    }
}