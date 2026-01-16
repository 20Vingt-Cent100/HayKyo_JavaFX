module vincent.haykyofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens vincent.haykyofx to javafx.fxml;
    exports vincent.haykyofx;
}