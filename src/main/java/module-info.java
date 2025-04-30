module gupta_lab.beithir {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.apache.commons.lang3;
    requires java.desktop;

    opens gupta_lab.beithir to javafx.fxml;
    opens gupta_lab.beithir.Controllers to javafx.fxml;

    exports gupta_lab.beithir;



    uses gupta_lab.beithir.MainApp;

}