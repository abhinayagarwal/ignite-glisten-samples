package com.gluonhq.hello.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.hello.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class FirstPresenter {

    @FXML
    private View first;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;

    @Inject
    Service service;

    public void initialize() {
        first.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                MobileApplication appManager = MobileApplication.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        appManager.getDrawer().open()));
                appBar.setTitleText("First");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e ->
                        System.out.println("Search")));
            }
        });

    }

    @FXML
    void buttonClick() {
        label.setText(resources.getString("label.text.2"));
        System.out.println(service.getText());
    }

}
