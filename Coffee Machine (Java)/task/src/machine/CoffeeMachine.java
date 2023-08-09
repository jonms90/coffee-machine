package machine;

public class CoffeeMachine {
    private final Resources _resources;
    private CoffeeMachineState _state;
    private final Display _display;
    private final InputHandler _inputHandler;

    public CoffeeMachine(int mlWater, int mlMilk, int gramsBeans, int disposableCups, int money){
        _display = new Display();
        _inputHandler = new InputHandler(_display);
        _resources = new Resources(mlWater, mlMilk, gramsBeans, disposableCups, money);
        _state = CoffeeMachineState.MAIN_MENU;
    }

    public void display() {
        _display.display(_state);
    }

    public void handle(String input){
        _state = _inputHandler.handle(input, _resources, _state);
    }
}
