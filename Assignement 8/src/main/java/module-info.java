module org.assignements.assignement8 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.assignements.assignement8 to javafx.fxml;
    exports org.assignements.assignement8;
}