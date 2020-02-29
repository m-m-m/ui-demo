/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.demo.ui.shared;

import java.util.concurrent.TimeUnit;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.datatype.media.UiMedia;
import io.github.mmm.ui.datatype.media.UiMediaSource;
import io.github.mmm.ui.datatype.media.UiMediaTrack;
import io.github.mmm.ui.event.UiValueChangeEventListener;
import io.github.mmm.ui.widget.attribute.UiWidgetWithAutocomplete;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.chart.UiPieChart;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiPasswordInput;
import io.github.mmm.ui.widget.input.UiRadioChoice;
import io.github.mmm.ui.widget.input.UiTextArea;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.ui.widget.media.UiMediaPlayer;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import io.github.mmm.ui.widget.panel.UiButtonPanel;
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
    initMenuBar(mainWindow);
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
    passwordInput.setAutocomplete(UiWidgetWithAutocomplete.AUTOCOMPLETE_NEW_PASSWORD);
    UiPasswordInput confirmPasswordInput;
    // confirmPasswordInput = passwordInput.createConfirmationInput();
    confirmPasswordInput = this.context.createPasswordInput("Confirm " + passwordInput.getName());
    confirmPasswordInput.setValidator(new ValidatorPasswordConfirmation(() -> passwordInput.getValue()));
    confirmPasswordInput.setAutocomplete(UiWidgetWithAutocomplete.AUTOCOMPLETE_NEW_PASSWORD);

    UiTextArea textArea = this.context.createTextArea("Comment");
    UiRadioChoice<TimeUnit> choice = this.context.createRadioChoiceByEnum("Time-unit", TimeUnit.class);
    UiFormGroup formGroupTabs = this.context.createFormGroup("Show Tabs", showTab1, showTab3);
    UiFormGroup formGroupInputs = this.context.createFormGroup("Generic Inputs", textInput, passwordInput,
        confirmPasswordInput, textArea, choice);

    UiFormPanel formPanel = this.context.createFormPanel(formGroupTabs, formGroupInputs);
    page2.addChild(formPanel);
    UiButton submitButton = this.context.createButton("Submit", (e) -> {
      formPanel.validate();
    });
    submitButton.getStyles().add("submit");
    UiButton deleteButton = this.context.createButton("Delete", (e) -> {
      System.out.println("Delete");
    });
    deleteButton.getStyles().add("danger");
    UiButton cancelButton = this.context.createButton("Cancel", (e) -> {
      System.out.println("Cancel");
    });
    cancelButton.getStyles().add("abort");
    UiButtonPanel buttonPanel = this.context.createButtonPanel(submitButton, deleteButton, cancelButton);
    page2.addChild(buttonPanel);
    createChartTab(tabPanel);
    createVideoTab(tabPanel);
    mainWindow.addChild(tabPanel);
    mainWindow.setVisible(true);
  }

  private void initMenuBar(UiMainWindow mainWindow) {

    UiMenuBar menuBar = mainWindow.getMenuBar();
    UiMenu fileMenu = menuBar.addMenu("File");
    fileMenu.addMenuItem("Exit", (e) -> {
      mainWindow.setVisible(false);
    });
    UiMenu optionsMenu = menuBar.addMenu("Options");
    optionsMenu.addMenuItem("Theme", (e) -> {
      System.out.println("Selected Theme from Options menu");
    });
  }

  private static void createChartTab(UiTabPanel tabPanel) {

    UiContext context = tabPanel.getContext();
    UiPieChart chart = context.create(UiPieChart.class);
    chart.setTitle("Demo Chart");
    chart.setLegendPlacement(Direction.RIGHT);
    chart.setData(UiDataSet.of("AWT", 1), UiDataSet.of("Swing", 5), UiDataSet.of("SWT/Eclipse", 4),
        UiDataSet.of("JavaFx", 5), UiDataSet.of("JSF", 3), UiDataSet.of("GWT", 1), UiDataSet.of("AngularJS", 2),
        UiDataSet.of("Angular", 5), UiDataSet.of("React", 3), UiDataSet.of("Vue", 2), UiDataSet.of("Ionic", 2),
        UiDataSet.of("Android", 6), UiDataSet.of("iOS", 4));
    UiTab tab = tabPanel.addChild(chart, "Chart");
  }

  private static void createVideoTab(UiTabPanel tabPanel) {

    UiContext context = tabPanel.getContext();
    UiVerticalPanel page = context.createVerticalPanel();
    UiMediaPlayer player = context.create(UiMediaPlayer.class);
    UiMediaSource sourceLq = new UiMediaSource("https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-576p.mp4",
        UiMediaSource.MIMETYPE_VIDEO_MP4);
    UiMediaSource sourceHq = new UiMediaSource(
        "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-1080p.mp4", UiMediaSource.MIMETYPE_VIDEO_MP4);
    UiMediaTrack track = new UiMediaTrack("https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.en.vtt",
        UiMediaTrack.KIND_CAPTIONS, "en", "English");
    player.setMedia(UiMedia.ofVideo(new UiMediaSource[] { sourceLq, sourceHq }, new UiMediaTrack[] { track },
        "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.jpg"));
    page.addChild(player);
    UiTab tab = tabPanel.addChild(page, "Video");
  }

}
