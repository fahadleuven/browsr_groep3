package view.type;

import view.Component;

import java.awt.event.KeyEvent;

public class TypeFactory {

    public static TypeHandler createTypeHandler(char key, Component component) {
        return switch (key) {
            case KeyEvent.VK_ENTER -> new Enter(component);
            case KeyEvent.VK_ESCAPE -> new Escape(component);
            case KeyEvent.VK_BACK_SPACE -> new Backspace(component);
            default -> new Character(component, key);
        };
    }
}
