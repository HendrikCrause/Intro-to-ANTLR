package intro.to.antlr;

import lombok.Getter;


@Getter
public enum Type {
    INSTANT(CupSize.SHORT, Ingredient.INSTANT_COFFEE, Ingredient.HOT_WATER),
    ESPRESSO(CupSize.SHOT, Ingredient.ESSPRESSO),
    MACCHIATO(CupSize.SHOT, Ingredient.ESSPRESSO, Ingredient.FOAM),
    AMERICANO(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.HOT_WATER),
    LATTE(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.MILK, Ingredient.FOAM),
    CAPPUCCINO(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.FOAM, Ingredient.FOAM),
    MOCHA(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.CHOCOLATE, Ingredient.FOAM),
    IRISH(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.WHISKEY, Ingredient.HOT_WATER),
    BREVE(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.POURING_CREAM, Ingredient.FOAM),
    ICED(CupSize.TALL, Ingredient.ICE, Ingredient.ESSPRESSO, Ingredient.COLD_WATER, Ingredient.MILK),
    FLAT_WHITE(CupSize.SHORT, Ingredient.ESSPRESSO, Ingredient.MILK, Ingredient.STEAMED_MILK);

    private CupSize defaultCupSize;
    private Ingredient[] ingredients;
    
    Type(CupSize defaultCupSize, Ingredient... ingredients) {
        this.defaultCupSize = defaultCupSize;
        this.ingredients = ingredients;
    }
}
