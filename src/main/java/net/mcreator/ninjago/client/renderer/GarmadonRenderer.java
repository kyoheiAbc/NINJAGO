
package net.mcreator.ninjago.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.mojang.blaze3d.vertex.PoseStack;

import net.mcreator.ninjago.entity.GarmadonEntity;

public class GarmadonRenderer extends HumanoidMobRenderer<GarmadonEntity, HumanoidModel<GarmadonEntity>> {
	public GarmadonRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(GarmadonEntity entity) {
		return new ResourceLocation("ninjago:textures/entities/garmadon.png");
	}

	@Override
	public void render(
			GarmadonEntity p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_,
			MultiBufferSource p_115459_,
			int p_115460_) {
		p_115458_.pushPose();
		p_115458_.translate(0, 0, 0);
		p_115458_.scale(1.5f, 1.5f, 1.5f);
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
		p_115458_.popPose();
	}
}
