package net.Admany.StalkersPursuit;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class CommandHandler {

    private static int jumpscareCooldown = 5; // Default 5 minutes cooldown

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("stalkerspursuit")
                .requires(source -> source.hasPermission(2)) // Requires OP
                .then(Commands.literal("jumpscare")
                        .then(Commands.argument("target", StringArgumentType.string())
                                .executes(context -> jumpscareTarget(context.getSource(), StringArgumentType.getString(context, "target"))))));
    }

    private static int jumpscareTarget(CommandSourceStack source, String target) {
        if (target.equalsIgnoreCase("everyone")) {
            // Get the list of all players on the server
            List<ServerPlayer> players = source.getServer().getPlayerList().getPlayers();
            for (ServerPlayer player : players) {
                JumpscareHandler.triggerJumpscare(player);
            }
            source.sendSuccess(Component.literal("Jumpscare triggered for everyone!"), true);
        } else {
            // Find the specific player by name
            ServerPlayer player = source.getServer().getPlayerList().getPlayerByName(target);
            if (player != null) {
                JumpscareHandler.triggerJumpscare(player);
                source.sendSuccess(Component.literal("Jumpscare triggered for " + target), true);
            } else {
                source.sendFailure(Component.literal("Player not found: " + target));
            }
        }
        return 1;
    }

    public static int getJumpscareCooldown() {
        return jumpscareCooldown;
    }
}
