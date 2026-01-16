package vincent.haykyofx;

import javafx.scene.input.MouseButton;

public class MouseClickEvent extends Event{
    public MouseButton button;

    public MouseClickEvent(MouseButton button){
        this.button = button;
    }
}
