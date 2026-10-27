package aml.pvpBridge;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.logging.Logger;

public class PvpBridge implements ModInitializer {
    private static MinecraftServer server;
    public static final String MOD_ID = "pvpBridge";
    public static final Logger LOGGER = Logger.getLogger(MOD_ID);;

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> PvpBridge.server = server);
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> PvpBridge.server = null);

//        LOGGER.info("hello world");

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(Commands.literal("spawnagent").executes(context -> {
                // stuff
                context.getSource().sendSuccess(() -> Component.literal("Spawned a player (not yet)"), false);
                return 1;
            }));
        });
    }

    // Testing purposes...
    public void getPos(Player player) {
        Vec3 pos_vec = player.getClientPosition();
        double pos_x = pos_vec.x;
        double pos_y = pos_vec.y;
        double pos_z = pos_vec.z;
    }
}
