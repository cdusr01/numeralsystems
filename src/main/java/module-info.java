module ru.skyrkov.numeralsystems {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.skyrkov.numeralsystems to javafx.fxml;
    exports ru.skyrkov.numeralsystems;
    exports ru.skyrkov.numeralsystems.controller;
    opens ru.skyrkov.numeralsystems.controller to javafx.fxml;
}