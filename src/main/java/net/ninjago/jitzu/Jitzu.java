package net.ninjago.jitzu;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.mcreator.ninjago.NinjagoMod;
import net.mcreator.ninjago.init.NinjagoModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;

// @Override
// public void baseTick() {
// 	super.baseTick();
// 	Jitzu.spin(level, this);
// }

public class Jitzu {

	public static void spin(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;

		double spin = entity.getPersistentData().getDouble(("spin"));

		if (spin <= 0)
			return;

		entity.getPersistentData().putDouble("spin", spin - 1);

		if (world instanceof ServerLevel _level) {
			_level.sendParticles((SimpleParticleType) (NinjagoModParticleTypes.SWEEP_ATTACK.get()), (entity.getX()),
					(entity.getY() + 0.5),
					(entity.getZ()), 20, 0, 0.5, 0, 0);
		}
	}

	public static void spinGo(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(1.5 * (entity.getLookAngle().x), 0.1, 1.5 * (entity.getLookAngle().z)));
		entity.getPersistentData().putDouble("spin", 15);
	}

	public static void beam(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;

		double beam = entity.getPersistentData().getDouble(("beam"));

		if (beam <= 0)
			return;

		entity.getPersistentData().putDouble("beam", beam - 1);

		double x = (entity.getX() + entity.getLookAngle().x * (15 - beam));
		double y = (entity.getY() + entity.getEyeHeight());
		double z = (entity.getZ() + entity.getLookAngle().z * (15 - beam));

		world.addParticle(ParticleTypes.SONIC_BOOM, x, y, z, 0, 0, 0);

		AABB bb = new AABB(x, y, z, 0, 0, 0);

		for (Entity le : world.getEntitiesOfClass(Entity.class, bb.inflate(0.5D))) {
			if (le == entity)
				continue;
			le.setRemainingFireTicks(30);
			le.hurt(DamageSource.sonicBoom(entity), 10);
		}
	}

	public static void beamGo(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(-1.5 * (entity.getLookAngle().x), 0.5, -1.5 * (entity.getLookAngle().z)));
		NinjagoMod.queueServerWork(15, () -> {
			entity.getPersistentData().putDouble("beam", 20);
		});
	}

}
