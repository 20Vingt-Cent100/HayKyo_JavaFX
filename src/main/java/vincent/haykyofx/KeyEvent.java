package vincent.haykyofx;

import javafx.scene.input.KeyCode;

public class KeyEvent extends Event{
    public KeyCode keyCode;

    public KeyEvent(KeyCode keyCode){this.keyCode = keyCode;}
}
