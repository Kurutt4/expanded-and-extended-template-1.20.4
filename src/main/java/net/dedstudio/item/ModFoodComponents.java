package net.dedstudio.item;

import net.minecraft.item.FoodComponent;


//VER FoodCompoonents para saber melhor sobre a construção de comida

public class ModFoodComponents {
    public static final FoodComponent SANDWICH = new FoodComponent.Builder().hunger(8)
            .saturationModifier(0.25f).build();

    public static final FoodComponent COCONUT = new FoodComponent.Builder().hunger(5)
            .saturationModifier(0.25f).build();
}
