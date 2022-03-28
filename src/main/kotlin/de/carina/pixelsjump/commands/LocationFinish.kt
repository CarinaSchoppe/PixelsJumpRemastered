/*
 * Copyright Notice for PixelsJumpRemastered
 * Copyright (c) at Carina Sophie Schoppe 2022
 * File created on 28.03.22, 15:25 by Carina The Latest changes made by Carina on 28.03.22, 15:25.
 *  All contents of "LocationFinish.kt" are protected by copyright. The copyright law, unless expressly indicated otherwise, is
 * at Carina Sophie Schoppe. All rights reserved
 * Any type of duplication, distribution, rental, sale, award,
 * Public accessibility or other use
 * requires the express written consent of Carina Sophie Schoppe.
 */

package de.carina.pixelsjump.commands

import de.carina.pixelsjump.PixelsJump
import de.carina.pixelsjump.util.ArenaHelper
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class LocationFinish(val sender: CommandSender, val command: Command, val args: Array<out String>) {

    fun execute() {
        if (!PixelsJump.utility.preCommandStuff(sender, command, args, 2, "finish", "pixelsjump.finish-arena"))
            return

        if (!ArenaHelper.arenaExists(args[1])) {
            sender.sendMessage(PixelsJump.utility.messageConverter("no-arena"))
            return
        }
        val arena = ArenaHelper.getArena(args[1])
        if (arena.locations[1] == null) {
            arena.single = true
            sender.sendMessage(PixelsJump.utility.messageConverter("arena-single").replace("%arena%", args[1]))
        }
        sender.sendMessage(PixelsJump.utility.messageConverter("arena-saved").replace("%arena%", args[1]))

        arena.saveArena()

    }
}