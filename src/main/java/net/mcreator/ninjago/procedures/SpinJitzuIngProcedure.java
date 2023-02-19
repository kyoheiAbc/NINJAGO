package net.mcreator.ninjago.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ninjago.init.NinjagoModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpinJitzuIngProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("spinCnt") > 0) {
			entity.getPersistentData().putDouble("spinCnt", (entity.getPersistentData().getDouble("spinCnt") + -1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (NinjagoModParticleTypes.SWEEP_ATTACK.get()), (entity.getX()), (entity.getY() + 0.3),
						(entity.getZ()), 15, 0, 0.3, 0, 0);
		}
	}
}
