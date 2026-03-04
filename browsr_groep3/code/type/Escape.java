package view.type;

import view.Component;

public class Escape implements TypeHandler {

    private final Component component;

    public Escape(Component component) {
        this.component = component;
    }

    @Override
    public void handle() {
        this.component.addTextToTextField("ESCAPE PRESSED");
    }
}
