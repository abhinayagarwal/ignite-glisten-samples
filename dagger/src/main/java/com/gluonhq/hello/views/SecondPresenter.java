package com.gluonhq.hello.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.hello.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

public class SecondPresenter  {

    @FXML
    private View second;

    @FXML private Label label;

    @Inject
    Service service;

    public void initialize() {
        second.setShowTransitionFactory(BounceInRightTransition::new);

        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> MobileApplication.getInstance().goHome());

        fab.showOn(second);

        second.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                MobileApplication appManager = MobileApplication.getInstance();
                AppBar appBar = appManager.getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> appManager.getDrawer().open()));
                appBar.setTitleText("Second");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e ->
                        System.out.println("Favorite")));
            }
        });

        label.setText(service.getText());
    }
}
