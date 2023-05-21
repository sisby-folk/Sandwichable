package io.github.foundationgames.sandwichable.mixin;

import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemConvertible;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ChickenEntity.class)
public class ChickenEntityMixin {
    @ModifyArg(method = "<clinit>()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/Ingredient;ofItems([Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/recipe/Ingredient;"), index = 0)
    private static ItemConvertible[] sandwichable$addSeeds(ItemConvertible[] old) {
        ItemConvertible[] items = new ItemConvertible[old.length + 3];
        System.arraycopy(old, 0, items, 0, old.length);
        items[items.length - 1] = ItemsRegistry.LETTUCE_SEEDS;
        items[items.length - 2] = ItemsRegistry.CUCUMBER_SEEDS;
        items[items.length - 3] = ItemsRegistry.ANCIENT_GRAIN_SEEDS;
        return items;
    }
}
