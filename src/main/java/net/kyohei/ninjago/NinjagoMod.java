package net.kyohei.ninjago;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NinjagoMod {

    @SubscribeEvent
    public static void FMLCommonSetupEvent(FMLCommonSetupEvent e) {
        new PlayerAction();
    }
}