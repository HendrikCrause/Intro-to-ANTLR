package intro.to.antlr;

import java.util.Scanner;

class MachineInstructionGenerator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Order order;
        
        while(!"q".equals(input.toLowerCase())) {
            System.out.println("Enter your coffee order (Q to exit)");
            input = scanner.nextLine();
            order = new Order(input);
            System.out.println("\nMachine instructions: \n" + order.toString() + "\n");
        }
    }
}