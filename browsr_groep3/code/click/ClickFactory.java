package view.click;

import view.ComponentCollection;
import view.Position;

import java.awt.event.MouseEvent;

public class ClickFactory {

    public static ClickHandler createClickHandler(int id, int clickCount, Position position, ComponentCollection componentCollection) {
        if (id == MouseEvent.MOUSE_CLICKED && clickCount == 1) {
            return new SingleClick(position, componentCollection);
        } else if (id == MouseEvent.MOUSE_CLICKED && clickCount == 2) {
            return new DoubleClick(position, componentCollection);
        }
        return null;
    }
}
