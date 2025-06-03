module gupta_lab.beithir {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires org.apache.commons.lang3;
    requires java.desktop;

    opens gupta_lab.beithir to javafx.fxml;
    opens gupta_lab.beithir.Controllers to javafx.fxml;
    opens gupta_lab.beithir.Models to javafx.base;
    exports gupta_lab.beithir;
}
