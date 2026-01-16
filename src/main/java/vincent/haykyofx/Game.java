package vincent.haykyofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game extends Application {
    private static final ArrayList<Layers> LAYER_STACK = new ArrayList<>();
    private static final ArrayList<Event> EVENT_QUEUE = new ArrayList<>();

    private static Scene scene;
    private static final Canvas GAME_CANVAS = new Canvas();
    private static Stage window;

    private static Vec2 dimensions;
    private static String gameName;

    private static boolean resizable = true;
    private static boolean fullscreen = false;

    //Getters and setters
    public static void setGameName(String gameName) {
        Game.gameName = gameName;
    }

    public static void setDimensions(Vec2 dimensions) {
        Game.dimensions = dimensions;
    }
    public static void setDimensions(float width, float height) {
        Game.dimensions = new Vec2(width, height);
    }

    public static Vec2 getDimensions(){
        return dimensions;
    }

    public static void setResizable(boolean resizable){
        Game.resizable = resizable;
    }

    public static void setFullscreen(boolean fullscreen){
        Game.fullscreen = fullscreen;
    }

    public static void addIcon(Image icon){
        window.getIcons().add(icon);
    }

    //Window logic
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        initWindow();
        setEventCallbacks();
        initLayers();
    }

    private void initWindow(){
        Pane root = new Pane();
        root.getChildren().add(GAME_CANVAS);
        scene = new Scene(root, dimensions.x, dimensions.y);

        GAME_CANVAS.widthProperty().bind(scene.widthProperty());
        GAME_CANVAS.heightProperty().bind(scene.heightProperty());

        window.setTitle(gameName);

        window.setScene(scene);

        window.setFullScreenExitHint("");
        window.setFullScreen(fullscreen);
        window.setResizable(resizable);

        window.show();
    }
    private void setEventCallbacks(){
        scene.setOnKeyPressed((e) -> {EVENT_QUEUE.add(new KeyPressedEvent(e.getCode()));});
        scene.setOnKeyReleased((e) -> {EVENT_QUEUE.add(new KeyReleasedEvent(e.getCode()));});

        scene.setOnMouseMoved((e) -> {EVENT_QUEUE.add(new MouseMotionEvent(e.getX(), e.getY()));});
        scene.setOnMouseClicked((e) -> {EVENT_QUEUE.add(new MouseClickEvent(e.getButton()));});
    }
    private void initLayers(){
        LAYER_STACK.forEach(Layers::initLayer);
    }

    public static void startGame(){
        launch();
    }

    public static void pushLayers(Layers l){
        LAYER_STACK.add(l);
    }
}
