package io.github.foundationgames.sandwichable.recipe;

import com.nhoryzon.mc.farmersdelight.recipe.CuttingBoardRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class SpecialCuttingBoardRecipe extends CuttingBoardRecipe {
	public SpecialCuttingBoardRecipe(Identifier id, String group, Ingredient tool, String soundEvent) {
		super(id, group, Ingredient.EMPTY, tool, DefaultedList.of(), soundEvent);
	}
}
