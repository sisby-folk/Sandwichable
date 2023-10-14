package io.github.foundationgames.sandwichable.mixin;

import io.github.foundationgames.sandwichable.blocks.BlocksRegistry;
import io.github.foundationgames.sandwichable.util.Util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin extends Entity {
    public FishingBobberEntityMixin(EntityType<?> type, World world) {
        super(type, world);
        throw new AssertionError("accessed dummy constructor");
    }

    @ModifyArg(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/LootManager;getLootTable(Lnet/minecraft/util/Identifier;)Lnet/minecraft/loot/LootTable;"))
    public Identifier sandwichable$changeLootTable(Identifier original) {
        if(this.getWorld().getBlockState(this.getBlockPos()).isOf(BlocksRegistry.PICKLE_BRINE)) {
            return Util.id("gameplay/brine_fishing");
        }
        return original;
    }
}
