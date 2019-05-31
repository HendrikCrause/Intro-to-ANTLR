package intro.to.antlr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.out.CoffeeLexer;
import antlr.out.CoffeeParser;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Order {
    
    private CupSize cupSize;
    private List<Ingredient> ingredients;
    
    public Order(String input) {
        CoffeeParser.OrderContext order = getOrderParseTree(input);
        CoffeeListener listener = new CoffeeListener(this);
        ParseTreeWalker.DEFAULT.walk(listener, order);
    }
    
    private CoffeeParser.OrderContext getOrderParseTree(String input) {
        CharStream charStream = CharStreams.fromString(input);
        CoffeeLexer lexer = new CoffeeLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CoffeeParser parser = new CoffeeParser(tokenStream);
        return parser.order();
    }
    
    public void makeType(Type type) {
        if(cupSize == null) {
            cupSize = type.getDefaultCupSize();
        }
        addIngredients(type.getIngredients());
    }
    
    public void addIngredients(Ingredient... ingredients) {
        if(this.ingredients == null) {
            this.ingredients = new ArrayList<>();
        }
        this.ingredients.addAll(Arrays.asList(ingredients));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(cupSize).append("\n");
        ingredients.forEach(i -> sb.append(i).append("\n"));
        
        return sb.toString();
    }
}
