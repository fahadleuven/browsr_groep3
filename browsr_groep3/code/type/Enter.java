package view.type;

import view.Component;

public class Enter implements TypeHandler {

    private final Component component;

    public Enter(Component component) {
        this.component = component;
    }

    @Override
    public void handle() {
        this.component.addTextToTextField("ENTER PRESSED");
    }
}
