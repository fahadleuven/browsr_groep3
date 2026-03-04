package view;

public class TextField {

    private String text;

    public TextField(String text) {
        this.text = text;
    }

    public boolean isEmpty() {
        return text == null || text.trim().isEmpty();
    }

    public int getlengthOfText() {
        return text.length();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null) {
            this.text = text;
        }
    }
}
