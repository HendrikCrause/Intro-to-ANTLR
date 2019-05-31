package intro.to.antlr;

import antlr.out.CoffeeBaseListener;
import antlr.out.CoffeeParser;


public class CoffeeListener extends CoffeeBaseListener {
    
    private Order order;
    
    public CoffeeListener(Order order) {
        this.order = order;
    }
    
    @Override
    public void enterSize(CoffeeParser.SizeContext ctx) {
        CupSize size = null;
        switch (ctx.getText().toUpperCase()) {
            case "SHOT":
                size = CupSize.SHOT;
                break;
            case "SHORT":
            case "REGULAR":
                size = CupSize.SHORT;
                break;
            case "TALL":
            case "LONG":
                size = CupSize.TALL;
                break;
            case "GRANDE":
                size = CupSize.GRANDE;
                break;
        }
        
        order.setCupSize(size);
    }
    
    @Override
    public void enterType(CoffeeParser.TypeContext ctx) {
        Type type = null;
        switch (ctx.getText().toUpperCase()) {
            case "ESPRESSO":
                type = Type.ESPRESSO;
                break;
            case "MACCHIATO":
                type = Type.MACCHIATO;
                break;
            case "AMERICANO":
                type = Type.AMERICANO;
                break;
            case "CAPPUCCINO":
                type = Type.CAPPUCCINO;
                break;
        }
        if (type != null) order.makeType(type);
    }
    
    @Override public void enterInstant(CoffeeParser.InstantContext ctx) {
        order.makeType(Type.INSTANT);
        if(ctx.getText().toUpperCase().contains("WHITE")) {
            order.addIngredients(Ingredient.MILK);
        }
    }
    
    @Override
    public void enterLatte(CoffeeParser.LatteContext ctx) {
        order.makeType(Type.LATTE);
    }
    
    @Override
    public void enterMocha(CoffeeParser.MochaContext ctx) {
        order.makeType(Type.MOCHA);
    }
    
    @Override
    public void enterIrish(CoffeeParser.IrishContext ctx) {
        order.makeType(Type.IRISH);
    }
    
    @Override public void enterBreve(CoffeeParser.BreveContext ctx) {
        order.makeType(Type.BREVE);
    }
    
    @Override
    public void enterIced(CoffeeParser.IcedContext ctx) {
        order.makeType(Type.ICED);
    }
    
    @Override
    public void enterFlat_white(CoffeeParser.Flat_whiteContext ctx) {
        order.makeType(Type.FLAT_WHITE);
    }
    
    @Override
    public void enterIngredient(CoffeeParser.IngredientContext ctx) {
        Ingredient ingredient = null;
        switch (ctx.getText().toUpperCase()) {
            case "HONEY":
                ingredient = Ingredient.HONEY;
                break;
            case "MILK":
                ingredient = Ingredient.MILK;
                break;
            case "FOAM":
                ingredient = Ingredient.FOAM;
                break;
            case "WHISKEY":
                ingredient = Ingredient.WHISKEY;
                break;
        }
        if(ingredient != null) order.addIngredients(ingredient);
    }
    
    @Override
    public void enterCocoa(CoffeeParser.CocoaContext ctx) {
        order.addIngredients(Ingredient.COCOA);
    }
    
    @Override
    public void enterCinnamon(CoffeeParser.CinnamonContext ctx) {
        order.addIngredients(Ingredient.CINNAMON);
    }
    
    @Override
    public void enterPouring_cream(CoffeeParser.Pouring_creamContext ctx) {
        order.addIngredients(Ingredient.POURING_CREAM);
    }
    
    @Override
    public void enterSugar_types(CoffeeParser.Sugar_typesContext ctx) {
        if(ctx.getText().toUpperCase().contains("BROWN")) {
            order.addIngredients(Ingredient.BROWN_SUGAR);
        } else {
            order.addIngredients(Ingredient.WHITE_SUGAR);
        }
    }
    
    public void enterExtras(CoffeeParser.ExtrasContext ctx) {
        System.out.println(ctx.getText());
    }
}
