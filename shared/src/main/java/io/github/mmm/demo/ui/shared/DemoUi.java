/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.demo.ui.shared;

import java.util.concurrent.TimeUnit;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiValueChangeEventListener;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiPasswordInput;
import io.github.mmm.ui.widget.input.UiRadioChoice;
import io.github.mmm.ui.widget.input.UiTextArea;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.panel.UiFormGroup;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiTabPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.widget.window.UiMainWindow;

/**
 * Demo of portable User-Interface with {@code mmm-ui}.
 */
public class DemoUi {

  private final UiContext context;

  /**
   * The constructor.
   */
  public DemoUi(UiContext context) {

    super();
    this.context = context;
  }

  public void run() {

    UiMainWindow mainWindow = this.context.getMainWindow();
    UiMenu fileMenu = mainWindow.getMenuBar().addMenu("File");
    fileMenu.addMenuItem("Exit", (e) -> {
      mainWindow.setVisible(false);
    });
    UiTabPanel tabPanel = this.context.createTabPanel();
    UiVerticalPanel page1 = this.context.createVerticalPanel();
    UiTab tab1 = tabPanel.addChild(page1, "Tab1");
    page1.addChild(this.context.createLabel("Hello World"));
    page1.addChild(this.context.createButton("OK", (e) -> {
      System.out.println("OK");
    }));
    UiVerticalPanel page2 = this.context.createVerticalPanel();
    UiTab tab2 = tabPanel.addChild(page2, "Tab2");
    UiVerticalPanel page3 = this.context.createVerticalPanel();
    page3.addChild(this.context.createLabel("Hi from Tab3"));
    UiTab tab3 = tabPanel.addChild(page3, "Tab3");

    UiCheckbox showTab1 = this.context.createCheckbox("Show Tab1");
    showTab1.setId("showTab1");
    showTab1.setSelected(true);
    UiValueChangeEventListener showTab1Listener = (e) -> {
      boolean selected = showTab1.isSelected();
      tab1.setVisible(selected);
    };
    showTab1.addListener(showTab1Listener);
    UiCheckbox showTab3 = this.context.createCheckbox("Show Tab3");
    showTab3.setId("showTab3");
    showTab3.setSelected(true);
    UiValueChangeEventListener showTab3Listener = (e) -> {
      tab3.setVisible(showTab3.isSelected());
    };
    showTab3.addListener(showTab3Listener);
    UiTextInput textInput = this.context.createTextInput("Login");
    textInput.setValidator(ValidatorMandatory.getInstance());
    UiPasswordInput passwordInput = this.context.createPasswordInput("Password");
    UiTextArea textArea = this.context.createTextArea("Comment");
    UiRadioChoice<TimeUnit> choice = this.context.createRadioChoiceByEnum("Time-unit", TimeUnit.class);
    UiFormGroup formGroupTabs = this.context.createFormGroup("Show Tabs", showTab1, showTab3);
    UiFormGroup formGroupInputs = this.context.createFormGroup("Generic Inputs", textInput, passwordInput, textArea,
        choice);

    UiFormPanel formPanel = this.context.createFormPanel(formGroupTabs, formGroupInputs);
    page2.addChild(formPanel);

    page2.addChild(this.context.createButton("Submit", (e) -> {
      formPanel.validate();
    }));
    mainWindow.addChild(tabPanel);
    mainWindow.setVisible(true);
  }

}
