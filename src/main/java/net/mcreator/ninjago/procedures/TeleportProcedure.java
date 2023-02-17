package net.mcreator.ninjago.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ninjago.NinjagoMod;

public class TeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		NinjagoMod.queueServerWork(20, () -> {
		});
		{
			Entity _ent = entity;
			_ent.teleportTo(x, y, z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
		}
	}
}