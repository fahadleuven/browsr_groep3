package view.click;

import view.Component;
import view.ComponentCollection;
import view.Position;

public class SingleClick implements ClickHandler {

    private final Position position;
    private final ComponentCollection componentCollection;

    public SingleClick(Position position, ComponentCollection componentCollection) {
        this.position = position;
        this.componentCollection = componentCollection;
    }

    @Override
    public void handle() {
        for (Component component : componentCollection) {
            if (component.isInside(position)) {
                component.enable();
            } else {
                component.disable();
            }
        }
    }
}
