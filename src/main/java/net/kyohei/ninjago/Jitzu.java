package net.kyohei.ninjago;

import com.mojang.logging.LogUtils;
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
        // LogUtils.getLogger().debug(((Integer) cnt).toString());
        if (cnt == 300) {
            Entity v = e.getVehicle();
            if (v != null) {
                v.setDeltaMovement(new Vec3(0.5 * (e.getLookAngle().x), 0.3, 0.5 * (e.getLookAngle().z)));
                v.setYBodyRot(e.getYHeadRot());
                v.setYRot(e.getYHeadRot());
                v.setYHeadRot(e.getYHeadRot());
            }
        } else if (cnt == 400) {
            Entity v = e.getVehicle();
            if (v != null) {
                v.setDeltaMovement(new Vec3(0.5 * (e.getLookAngle().x), -0.3, 0.5 * (e.getLookAngle().z)));
                v.setYBodyRot(e.getYHeadRot());
                v.setYRot(e.getYHeadRot());
                v.setYHeadRot(e.getYHeadRot());
            }
        } else if (cnt >= 200) {
            if (cnt >= 203) {
                cnt = -1;
                return;
            }
            if (cnt == 201) {
                if (!e.isOnGround()) {
                    e.setDeltaMovement(0, -1000, 0);
                }
            }
        }

        else if (cnt >= 100) {
            if (cnt >= 140) {
                cnt = -1;
                return;
            }

            if (cnt == 100) {
                e.setDeltaMovement(new Vec3(-1 * (e.getLookAngle().x), 0.5, -1 * (e.getLookAngle().z)));
            }

            if (cnt >= 120) {
                if (e.level instanceof ServerLevel s) {
                    double x = (e.getX() + e.getLookAngle().x * (cnt - 120));
                    double y = (e.getY() + e.getEyeHeight());
                    double z = (e.getZ() + e.getLookAngle().z * (cnt - 120));

                    s.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 1, 0, 0, 0, 0);

                    AABB bb = new AABB(x, y, z, 0, 0, 0).inflate(0D);

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
            if (cnt >= 20) {
                cnt = -1;
                return;
            }

            if (cnt == 0) {
                e.setDeltaMovement(new Vec3(1.5 * (e.getLookAngle().x), 0.3, 1.5 * (e.getLookAngle().z)));
            }

            if (e.level instanceof ServerLevel s) {
                s.sendParticles(ParticleTypes.SWEEP_ATTACK, e.getX(), e.getY(), e.getZ(), 5, 0, 0.5, 0, 0);
            }
        }

        if (e.level instanceof ServerLevel s) {
            cnt++;
        }
    }

    public void setCnt(int i) {
        cnt = i;
    }
}
