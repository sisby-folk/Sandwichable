package io.github.foundationgames.sandwichable.recipe.special;

import com.google.gson.JsonObject;
import io.github.fabricators_of_create.porting_lib.transfer.item.RecipeWrapper;
import io.github.foundationgames.sandwichable.items.BiomeVariantItem;
import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import io.github.foundationgames.sandwichable.recipe.SandwichableRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.tag.ModTags;

public class AncientGrainBreadSliceRecipe extends CuttingBoardRecipe {
    public AncientGrainBreadSliceRecipe(Identifier id) {
        super(id, "", Ingredient.EMPTY, Ingredient.fromTag(ModTags.KNIVES), DefaultedList.of(), "");
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return new ItemStack(ItemsRegistry.ANCIENT_GRAIN_BREAD_SLICE, 4);
    }

    @Override
    public ItemStack craft(RecipeWrapper inventory, DynamicRegistryManager registryManager) {
        var stack = getOutput(registryManager);
        BiomeVariantItem.copyBiome(inventory.getStack(0), stack);

        return stack;
    }

    @Override
    public boolean matches(RecipeWrapper inventory, World world) {
        return inventory.getStack(0).isOf(ItemsRegistry.ANCIENT_GRAIN_BREAD);
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SandwichableRecipes.ANCIENT_GRAIN_BREAD_SLICE;
    }

    public static class AncientGrainBreadSliceRecipeSerializer implements RecipeSerializer<AncientGrainBreadSliceRecipe> {
        @Override
        public AncientGrainBreadSliceRecipe read(Identifier id, JsonObject json) {
            return new AncientGrainBreadSliceRecipe(id);
        }

        @Override
        public AncientGrainBreadSliceRecipe read(Identifier id, PacketByteBuf buf) {
            return new AncientGrainBreadSliceRecipe(id);
        }

        @Override
        public void write(PacketByteBuf buf, AncientGrainBreadSliceRecipe recipe) {
        }
    }
}
