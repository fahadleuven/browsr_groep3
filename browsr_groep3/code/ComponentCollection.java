package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentCollection implements Iterable<Component> {

    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        if (component != null) components.add(component);
    }

    public Component getEnabledComponent() {
        return components.stream().filter(Component::isEnabled).findFirst().orElse(null);
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }
}
