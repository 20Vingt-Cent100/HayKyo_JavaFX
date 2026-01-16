package vincent.haykyofx;

import java.util.ArrayList;

public abstract class Layers {
    private final ArrayList<GameObject> LAYER_OBJECT_LIST = new ArrayList<>();

    public boolean isVisible = true;
    public abstract void initLayer();
    public abstract void onEvent(Event e);
    public abstract void onUpdateCall(double deltaTimeSecond);
    public abstract void onRender();
}
