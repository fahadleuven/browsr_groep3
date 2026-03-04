package view.type;

import view.Component;

public class Backspace implements TypeHandler {

    private final Component component;

    public Backspace(Component component) {
        this.component = component;
    }

    @Override
    public void handle() {
        this.component.removeLastCharFromTextField();
    }
}
