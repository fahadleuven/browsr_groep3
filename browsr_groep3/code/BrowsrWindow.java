package view;

import view.click.ClickFactory;
import view.click.ClickHandler;
import view.type.TypeFactory;
import view.type.TypeHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BrowsrWindow extends CanvasWindow {

    private final Font font = new Font(Font.DIALOG, Font.PLAIN, 14);
    private final ComponentCollection componentCollection = new ComponentCollection();
    private final TextField textField = new TextField("hallo");

    protected BrowsrWindow(String title) {
        super(title);
    }

    @Override
    protected void handleShown() {
    }

    @Override
    protected void paint(Graphics graphics) {
        Component addressBar = new Component(graphics, Position.of(0, 0), getWidth(), 25)
                .addBackground(Color.LIGHT_GRAY)
                .addText("URL: ", Position.of(5, 17), Color.BLACK, font)
                .addTextField(textField, Position.of(40, 17), Color.BLACK, font);
        addressBar.setTextField(textField);
        componentCollection.addComponent(addressBar);
    }

    @Override
    protected void handleMouseEvent(int id, int x, int y, int clickCount) {
        Position clickedPosition = Position.of(x, y);
        ClickHandler clickHandler = ClickFactory.createClickHandler(id, clickCount, clickedPosition, componentCollection);
        if (clickHandler != null) {
            clickHandler.handle();
        }
        repaint();
    }

    @Override
    protected void handleKeyEvent(int id, int keyCode, char keyChar) {
        if (id == KeyEvent.KEY_TYPED) {
            Component enabledComponent = componentCollection.getEnabledComponent();
            if (enabledComponent != null) {
                TypeHandler typeHandler = TypeFactory.createTypeHandler(keyChar, enabledComponent);
                typeHandler.handle();
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new BrowsrWindow("Browsr").show());
    }
}
