module gupta_lab.beithir {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.apache.commons.lang3;

    opens gupta_lab.beithir to javafx.fxml;
    exports gupta_lab.beithir;
    exports gupta_lab.beithir.Controllers;
    opens gupta_lab.beithir.Controllers to javafx.fxml;
}