package net.kyohei.ninjago;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerAction {

    Jitzu jitzu;

    public PlayerAction() {
        MinecraftForge.EVENT_BUS.register(this);
        jitzu = new Jitzu();
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            jitzu.tick(e.player);
        }
    }

    @SubscribeEvent
    public void playerInteractEventLeftClickEmpty(PlayerInteractEvent.LeftClickEmpty e) {
        jitzu.setCnt(0);
    }

    @SubscribeEvent
    public void playerInteractEventRightClickEmpty(PlayerInteractEvent.RightClickEmpty e) {
        jitzu.setCnt(100);
    }
}
