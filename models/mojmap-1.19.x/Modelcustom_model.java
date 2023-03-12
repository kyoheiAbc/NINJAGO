// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart body;

	public Modelcustom_model(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-16.0F, -30.0F, -5.0F, 32.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(40, 101)
						.addBox(-5.0F, -4.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.5F)).texOffs(40, 83)
						.addBox(-9.0F, -13.0F, -5.0F, 18.0F, 8.0F, 10.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(86, 91)
						.addBox(-5.0F, -2.5F, -2.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(80, 52)
						.addBox(-1.0F, -7.5F, -4.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -37.5F, -3.0F));

		PartDefinition arm0 = body.addOrReplaceChild("arm0",
				CubeListBuilder.create().texOffs(0, 83)
						.addBox(-3.0F, 3.0F, -5.0F, 10.0F, 25.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(60, 67)
						.addBox(-12.0F, -3.0F, -5.0F, 20.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-24.0F, -29.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1",
				CubeListBuilder.create().texOffs(80, 17)
						.addBox(-7.0F, 3.0F, -5.0F, 10.0F, 25.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 67)
						.addBox(-8.0F, -3.0F, -5.0F, 20.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(24.0F, -29.0F, 0.0F));

		PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(40, 27).addBox(-5.0F,
				-2.0F, -5.0F, 10.0F, 30.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 3.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 27).addBox(-5.0F,
				-2.0F, -5.0F, 10.0F, 30.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.body.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}