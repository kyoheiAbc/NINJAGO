package net.kyohei.ninjago;

import org.apache.commons.codec.digest.PureJavaCrc32;

import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
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

    @SubscribeEvent
    public void inputEventKeyInputEvent(InputEvent.Key e) {
        LogUtils.getLogger().debug(((Integer) e.getKey()).toString());
        if (e.getKey() == 75) {
            jitzu.setCnt(200);
        } else if (e.getKey() == 32) {
            jitzu.setCnt(300);
        } else if (e.getKey() == 83) {
            jitzu.setCnt(400);
        }
    }
}
