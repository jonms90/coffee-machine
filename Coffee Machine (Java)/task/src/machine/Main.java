package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120,9 ,550);
        String input;

        do{
            coffeeMachine.display();
            input = scanner.nextLine();
            coffeeMachine.handle(input);
        } while(!"exit".equals(input));
    }
}
