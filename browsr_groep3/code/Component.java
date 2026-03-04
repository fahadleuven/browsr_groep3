package view;

import java.awt.*;

public class Component {

    private final Graphics graphics;
    private final Position position;
    private final int width, height;
    private boolean isEnabled = false;
    private TextField textField;

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void addCharToTextField(char c) {
        this.textField.setText(this.textField.getText() + c);
    }

    public void removeLastCharFromTextField() {
        if (!textField.isEmpty()) {
            this.textField.setText(this.textField.getText().substring(0, this.textField.getlengthOfText() - 1));
        }
    }

    public void addTextToTextField(String text) {
        this.textField.setText(text);
    }

    public Component(Graphics graphics, Position position, int width, int height) {
        this.graphics = graphics;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Component addText(String text, Position relativePosition, Color color, Font font) {
        Position absolutePosition = getAbsolutePosition(relativePosition);
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(text, absolutePosition.getX(), absolutePosition.getY());
        return this;
    }

    public Component addTextField(TextField textField, Position relativePosition, Color color, Font font) {
        Position absolutePosition = getAbsolutePosition(relativePosition);
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(textField.getText(), absolutePosition.getX(), absolutePosition.getY());
        return this;
    }

    public Component addBackground(Color color) {
        graphics.setColor(color);
        graphics.fillRect(position.getX(), position.getY(), width, height);
        return this;
    }

    public boolean isInside(Position givenPosition) {
        boolean xOk = givenPosition.getX() >= position.getX() && givenPosition.getX() <= position.getX() + width;
        boolean yOk = givenPosition.getY() >= position.getY() && givenPosition.getY() <= position.getY() + height;
        return xOk && yOk;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    private Position getAbsolutePosition(Position relativePosition) {
        return Position.sum(position, relativePosition);
    }

}
