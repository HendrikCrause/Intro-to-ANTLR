package intro.to.antlr;

import static org.junit.Assert.*;

import org.junit.Test;


public class OrderTest {
    
    @Test
    public void simpleOrder() {
        
        String input = "Coffee";
    
        Order order = new Order(input);
        assertNotNull(order);
        assertNotNull(order.getCupSize());
        assertNotNull(order.getIngredients());
        
        assertEquals(CupSize.SHORT, order.getCupSize());
        assertEquals(2, order.getIngredients().size());
        assertEquals(Ingredient.INSTANT_COFFEE, order.getIngredients().get(0));
        assertEquals(Ingredient.HOT_WATER, order.getIngredients().get(1));
    }
    
    @Test
    public void standardOrder() {
        
        String input = "GRande Cappuccino";
    
        Order order = new Order(input);
        assertNotNull(order);
        assertNotNull(order.getCupSize());
        assertNotNull(order.getIngredients());
        
        assertEquals(CupSize.GRANDE, order.getCupSize());
        assertEquals(3, order.getIngredients().size());
        assertEquals(Ingredient.ESSPRESSO, order.getIngredients().get(0));
        assertEquals(Ingredient.FOAM, order.getIngredients().get(1));
        assertEquals(Ingredient.FOAM, order.getIngredients().get(2));
    }
    
    @Test
    public void complexishOrder() {
        
        String input = "Tall americaNO with honey, pouring cream and Cinnamon";
    
        Order order = new Order(input);
        assertNotNull(order);
        assertNotNull(order.getCupSize());
        assertNotNull(order.getIngredients());
        
        assertEquals(CupSize.TALL, order.getCupSize());
        assertEquals(5, order.getIngredients().size());
        assertEquals(Ingredient.ESSPRESSO, order.getIngredients().get(0));
        assertEquals(Ingredient.HOT_WATER, order.getIngredients().get(1));
        assertEquals(Ingredient.HONEY, order.getIngredients().get(2));
        assertEquals(Ingredient.POURING_CREAM, order.getIngredients().get(3));
        assertEquals(Ingredient.CINNAMON, order.getIngredients().get(4));
    }
    
}