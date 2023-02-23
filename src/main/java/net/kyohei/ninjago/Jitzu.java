package net.kyohei.ninjago;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Jitzu {

    private int cnt;

    public Jitzu() {
        cnt = -1;
    }

    public void tick(Entity e) {
        if (cnt == -1) {
            return;
        }

        ServerLevel s = null;
        if (e.level instanceof ServerLevel) {
            s = (ServerLevel) e.level;
        }

        if (cnt >= 100) {
            if (cnt >= 150) {
                cnt = -1;
                return;
            }

            if (cnt == 100) {
                e.setDeltaMovement(new Vec3(-1 * (e.getLookAngle().x), 0.5, -1 * (e.getLookAngle().z)));
            }

            if (cnt >= 135) {
                if (s != null) {
                    double x = (e.getX() + e.getLookAngle().x * (cnt - 135));
                    double y = (e.getY() + e.getEyeHeight());
                    double z = (e.getZ() + e.getLookAngle().z * (cnt - 135));

                    s.sendParticles(
                            ParticleTypes.SONIC_BOOM, x, y, z,
                            1, 0, 0, 0, 0);

                    AABB bb = new AABB(x, y, z, 0, 0, 0);
                    bb = bb.inflate(0.25D);

                    for (Entity e_ : s.getEntitiesOfClass(Entity.class, bb)) {
                        if (e_ == e)
                            continue;
                        e_.setRemainingFireTicks(20);
                        e_.hurt(DamageSource.sonicBoom(e), 3);
                    }
                }
            }
        }

        else if (cnt >= 0) {
            if (cnt >= 30) {
                cnt = -1;
                return;
            }

            if (cnt == 0) {
                e.setDeltaMovement(new Vec3(1.5 * (e.getLookAngle().x), 0.3, 1.5 * (e.getLookAngle().z)));
            }

            if (s != null) {
                s.sendParticles(ParticleTypes.SWEEP_ATTACK, e.getX(), e.getY(), e.getZ(), 5, 0, 0.5, 0,
                        0);
            }
        }

        if (s != null) {
            cnt++;
        }
    }

    public void setCnt(int i) {
        cnt = i;
    }
}
