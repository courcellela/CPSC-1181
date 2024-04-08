module com.assignement.assignement7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.assignement.assignement7 to javafx.fxml;
    exports com.assignement.assignement7;
}