package net.ninjago;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ninjago {

    public static String PL_SKIN = "ninjago:textures/entities/lloyd.png";

    public ninjago() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void FMLCommonSetupEvent(FMLCommonSetupEvent e) {
        new ninjago();
        new net.ninjago.playerMoel.event();
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Jitzu.spin(event.player.level, event.player);
            Jitzu.beam(event.player.level, event.player);
        }
    }
}
