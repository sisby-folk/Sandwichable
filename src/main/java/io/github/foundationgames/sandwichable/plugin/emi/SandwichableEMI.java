package io.github.foundationgames.sandwichable.plugin.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiCraftingRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import io.github.foundationgames.sandwichable.blocks.BlocksRegistry;
import io.github.foundationgames.sandwichable.items.ItemsRegistry;
import io.github.foundationgames.sandwichable.recipe.SandwichableRecipes;
import io.github.foundationgames.sandwichable.recipe.special.ToastedAncientGrainBreadSliceRecipe;
import io.github.foundationgames.sandwichable.util.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

import java.util.List;

public class SandwichableEMI implements EmiPlugin {
	public static final EmiRecipeCategory TOASTING_CATEGORY = new EmiRecipeCategory(Util.id("toasting"), EmiStack.of(new ItemStack(BlocksRegistry.TOASTER).getItem()));

	@Override
	public void register(EmiRegistry registry) {
		registry.addCategory(TOASTING_CATEGORY);
		registry.addWorkstation(TOASTING_CATEGORY, EmiStack.of(new ItemStack(BlocksRegistry.TOASTER).getItem()));
		registry.getRecipeManager().listAllOfType(SandwichableRecipes.TOASTING_RECIPE).forEach((toastingRecipe -> {
			if (!(toastingRecipe instanceof ToastedAncientGrainBreadSliceRecipe)) {
				registry.addRecipe(new EmiToastingRecipe(toastingRecipe.getId(), toastingRecipe.getInput(), toastingRecipe.getOutput(null)));
			}
		}));
		registry.addRecipe(new EmiCraftingRecipe(List.of(EmiStack.of(ItemsRegistry.ANCIENT_GRAIN.getDefaultStack()), EmiStack.of(ItemsRegistry.ANCIENT_GRAIN.getDefaultStack()), EmiStack.of(ItemsRegistry.ANCIENT_GRAIN.getDefaultStack())), EmiStack.of(ItemsRegistry.ANCIENT_GRAIN_BREAD.getDefaultStack()), Util.id("crafting_special_ancientgrainbread"), true));
		registry.addRecipe(new EmiToastingRecipe(Util.id("toasting_special_toastedancientgrainbreadslice"), Ingredient.ofItems(ItemsRegistry.ANCIENT_GRAIN_BREAD_SLICE), ItemsRegistry.TOASTED_ANCIENT_GRAIN_BREAD_SLICE.getDefaultStack()));
	}
}
