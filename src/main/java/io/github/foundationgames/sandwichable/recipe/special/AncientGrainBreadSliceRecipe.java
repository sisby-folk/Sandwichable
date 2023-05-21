package io.github.foundationgames.sandwichable.recipe.special;

import com.nhoryzon.mc.farmersdelight.registry.TagsRegistry;
import io.github.foundationgames.sandwichable.items.BiomeVariantItem;
import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import io.github.foundationgames.sandwichable.recipe.SandwichableRecipes;
import io.github.foundationgames.sandwichable.recipe.SpecialCuttingBoardRecipe;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AncientGrainBreadSliceRecipe extends SpecialCuttingBoardRecipe {
    public AncientGrainBreadSliceRecipe(Identifier id) {
        super(id, "", Ingredient.fromTag(TagsRegistry.KNIVES), "");
    }

    @Override
    public ItemStack getOutput() {
        return new ItemStack(ItemsRegistry.ANCIENT_GRAIN_BREAD_SLICE, 4);
    }

    @Override
    public ItemStack craft(Inventory inv) {
        var stack = getOutput();
        BiomeVariantItem.copyBiome(inv.getStack(0), stack);

        return stack;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        return inv.getStack(0).isOf(ItemsRegistry.ANCIENT_GRAIN_BREAD);
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SandwichableRecipes.ANCIENT_GRAIN_BREAD_SLICE;
    }
}
