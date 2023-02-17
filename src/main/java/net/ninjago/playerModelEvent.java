package net.ninjago;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class playerModelEvent {

    public playerModelEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        new playerModelEvent();
    }

    @SubscribeEvent
    public void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        event.getRenderer().getModel().setAllVisible(false);
        // event.getPoseStack().pushPose();
        // event.getPoseStack().scale(2.0f, 2.0f, 2.0f);
    }

    @SubscribeEvent
    public void onRenderPlayerPost(RenderPlayerEvent.Post event) {
        // event.getPoseStack().popPose();
    }

    @Mod.EventBusSubscriber
    private static class ForgeBusEvents {
        @SubscribeEvent
        public static void serverLoad(ServerStartingEvent event) {
        }

        @SubscribeEvent
        public static void clientLoad(FMLClientSetupEvent event) {
        }
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers e) {
        LivingEntityRenderer livingEntityRenderer;

        livingEntityRenderer = (LivingEntityRenderer) e.getSkin("default");
        livingEntityRenderer.addLayer(new playerModelRenderer(livingEntityRenderer));

        livingEntityRenderer = (LivingEntityRenderer) e.getSkin("slim");
        livingEntityRenderer.addLayer(new playerModelRenderer(livingEntityRenderer));
    }
}
