
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ninjago.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ninjago.client.renderer.GarmadonRenderer;
import net.mcreator.ninjago.client.renderer.DragonRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NinjagoModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(NinjagoModEntities.GARMADON.get(), GarmadonRenderer::new);
		event.registerEntityRenderer(NinjagoModEntities.DRAGON.get(), DragonRenderer::new);
	}
}
