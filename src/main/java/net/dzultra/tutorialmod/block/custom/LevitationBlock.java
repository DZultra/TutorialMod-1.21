package net.dzultra.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LevitationBlock extends Block {
    public LevitationBlock(Settings settings) {
        super(settings);
    }
    boolean active = false;

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!(world instanceof ServerWorld serverWorld)) return;
        if (entity instanceof LivingEntity livingEntity) {
            if (world.isReceivingRedstonePower(pos)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 2)); // Effect Level is calculated by "Amplifier + 1"
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
