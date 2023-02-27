package net.kyohei.ninjago;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.kyohei.ninjago.NinjagoMod;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class PlayerRenderLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public PlayerModel_ model;

    public PlayerRenderLayer(
            RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent) {

        super(renderLayerParent);
        model = new PlayerModel_(model.layerDefinition().bakeRoot());
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource p_116952_, int p_116953_, AbstractClientPlayer p_116954_,
            float p_116955_, float p_116956_, float p_116957_, float p_116958_, float p_116959_, float p_116960_) {

        this.getParentModel().copyPropertiesTo(this.model);

        VertexConsumer vertexConsumer = p_116952_.getBuffer(
                RenderType.entityCutoutNoCull(
                        new ResourceLocation(NinjagoMod.PL_SKIN)));

        this.model.renderToBuffer(
                poseStack,
                vertexConsumer,
                p_116953_,
                OverlayTexture.NO_OVERLAY,
                1,
                1,
                1,
                1.0F);
    }
}
