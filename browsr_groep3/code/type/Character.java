package view.type;

import view.Component;

public class Character implements TypeHandler {

    private final Component component;
    private final char c;

    public Character(Component component, char c) {
        this.component = component;
        this.c = c;
    }

    @Override
    public void handle() {
        component.addCharToTextField(c);
    }
}
