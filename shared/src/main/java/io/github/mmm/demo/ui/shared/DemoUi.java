/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.demo.ui.shared;

import java.util.concurrent.TimeUnit;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.attribute.AttributeWriteAutocomplete;
import io.github.mmm.ui.api.binding.data.UiDataBinding;
import io.github.mmm.ui.api.datatype.UiPoint;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.datatype.chart.UiDataSeriesDouble;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.datatype.media.UiMedia;
import io.github.mmm.ui.api.datatype.media.UiMediaSource;
import io.github.mmm.ui.api.datatype.media.UiMediaTrack;
import io.github.mmm.ui.api.event.UiValueChangeEventListener;
import io.github.mmm.ui.api.event.action.UiActionClose;
import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.chart.UiBarChartHorizontal;
import io.github.mmm.ui.api.widget.chart.UiLineChart;
import io.github.mmm.ui.api.widget.chart.UiPieChart;
import io.github.mmm.ui.api.widget.composite.UiTab;
import io.github.mmm.ui.api.widget.input.UiCheckbox;
import io.github.mmm.ui.api.widget.input.UiIntegerSlider;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import io.github.mmm.ui.api.widget.input.UiTextArea;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.media.UiMediaPlayer;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiFormGroup;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;
import io.github.mmm.ui.api.widget.panel.UiTabPanel;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.api.widget.window.UiPopup;
import io.github.mmm.ui.api.widget.window.UiWindow;

/**
 * Demo of portable User-Interface with {@code mmm-ui}.
 */
@SuppressWarnings("unchecked")
public class DemoUi implements Runnable {

  private int counter = 1;

  private UiPopup popup;

  /**
   * The constructor.
   */
  public DemoUi() {

    super();
  }

  @Override
  public void run() {

    UiDataBinding binding = new UiDataBinding();
    initMenuBar();
    UiTabPanel tabPanel = UiTabPanel.of();
    UiTab tab1 = createTab1(tabPanel);
    UiVerticalPanel page2 = UiVerticalPanel.of();
    // UiTab tab2 =
    tabPanel.addChild(page2, "Tab2");
    UiTab tab3 = createDynamicEditor(binding, tabPanel);

    UiCheckbox showTab1 = UiCheckbox.of("Show Tab1");
    showTab1.setId("showTab1");
    showTab1.setSelected(true);
    UiValueChangeEventListener showTab1Listener = (e) -> {
      boolean selected = showTab1.isSelected();
      tab1.setVisible(selected);
    };
    showTab1.addListener(showTab1Listener);
    UiCheckbox showTab3 = UiCheckbox.of("Show Tab3");
    showTab3.setId("showTab3");
    showTab3.setSelected(true);
    UiValueChangeEventListener showTab3Listener = (e) -> {
      tab3.setVisible(showTab3.isSelected());
    };
    showTab3.addListener(showTab3Listener);
    UiTextInput textInput = UiTextInput.of("Login");
    textInput.setId("login");
    textInput.setAutocomplete(AttributeWriteAutocomplete.AUTOCOMPLETE_USERNAME);
    textInput.setValidator(ValidatorMandatory.getInstance());
    UiPasswordInput passwordInput = UiPasswordInput.ofNew("Password");
    UiPasswordInput confirmPasswordInput;
    // confirmPasswordInput = passwordInput.createConfirmationInput();
    confirmPasswordInput = UiPasswordInput.of("Confirm " + passwordInput.getName(),
        AttributeWriteAutocomplete.AUTOCOMPLETE_NEW_PASSWORD);
    confirmPasswordInput.setValidator(new ValidatorPasswordConfirmation(() -> passwordInput.getValue()));

    UiTextArea textArea = UiTextArea.of("Comment");
    UiRadioChoice<TimeUnit> choice = UiRadioChoice.ofEnum("Time-unit", TimeUnit.class);
    UiIntegerSlider slider = UiIntegerSlider.of("Slider");
    slider.setTextEditable(true);
    UiFormGroup<Void> formGroupTabs = UiFormGroup.of("Show Tabs", showTab1, showTab3);
    UiFormGroup<Void> formGroupInputs = UiFormGroup.of("Generic Inputs", textInput, passwordInput, confirmPasswordInput,
        textArea, choice, slider);

    UiFormPanel<Void> formPanel = UiFormPanel.of(formGroupTabs, formGroupInputs);
    page2.addChild(formPanel);
    UiButton submitButton = UiButton.of("Submit", (e) -> {
      formPanel.validate();
    });
    submitButton.getStyles().add("submit");
    UiButton deleteButton = UiButton.of("Delete", (e) -> {
      System.out.println("Delete");
    });
    deleteButton.getStyles().add("danger");
    UiButton cancelButton = UiButton.of("Cancel", (e) -> {
      System.out.println("Cancel");
    });
    cancelButton.getStyles().add("abort");
    UiButtonPanel buttonPanel = UiButtonPanel.of(submitButton, deleteButton, cancelButton);
    page2.addChild(buttonPanel);
    // TemporalDemo.createTab(tabPanel);
    createChartTab(tabPanel);
    createVideoTab(tabPanel);
    UiMainWindow mainWindow = UiMainWindow.get();
    mainWindow.addChild(tabPanel);
    mainWindow.setVisible(true);
  }

  private UiTab createTab1(UiTabPanel tabPanel) {

    UiVerticalPanel page1 = UiVerticalPanel.of();
    UiTab tab1 = tabPanel.addChild(page1, "Tab1");
    page1.addChild(UiLabel.of("Hello World"));
    page1.addChild(UiButton.of("Open Window", (e) -> {
      UiButtonPanel buttonPanel = UiButtonPanel.of();
      UiWindow window = UiWindow.of("Window" + this.counter++, buttonPanel);
      UiActionClose action = evt -> {
        window.close();
      };
      buttonPanel.addChild(UiButton.of(action));
      window.getPosition().setX(200 + this.counter * 20);
      window.getPosition().setY(200 + this.counter * 20);
      window.open();
    }));
    page1.addChild(UiButton.of("Open Popup", (e) -> {
      if (this.popup == null) {
        this.popup = UiNotifier.get().showPopupOk("This is a test\n<br><blink>blink</blink>", UiSeverity.INFORMATION);
      } else {
        this.popup.open();
      }
    }));
    return tab1;
  }

  private UiTab createDynamicEditor(UiDataBinding binding, UiTabPanel tabPanel) {

    UiVerticalPanel page3 = UiVerticalPanel.of();
    UiFormPanel<TestBean> formPanel = binding.createFormPanel(new TestBean());
    page3.addChild(formPanel);
    UiButton submitButton = UiButton.of("Submit", (e) -> {
      System.out.println("Submit");
      boolean valid = formPanel.validate();
      System.out.println("Valid:" + valid);
      System.out.println(formPanel.getValue().toString());
    });
    submitButton.getStyles().add("submit");
    UiButtonPanel buttonPanel = UiButtonPanel.of(submitButton);
    page3.addChild(buttonPanel);
    UiTab tab3 = tabPanel.addChild(page3, "Tab3");
    return tab3;
  }

  private void initMenuBar() {

    UiMenuBar menuBar = UiMenuBar.get();
    UiMenu fileMenu = menuBar.addMenu("File");
    fileMenu.addMenuItem("Exit", (e) -> {
      UiMainWindow.get().setVisible(false);
    });
    UiMenu optionsMenu = menuBar.addMenu("Options");
    optionsMenu.addMenuItem("Theme", (e) -> {
      System.out.println("Selected Theme from Options menu");
    });
  }

  private static void createChartTab(UiTabPanel tabPanel) {

    UiVerticalPanel panel = UiVerticalPanel.of();
    UiPieChart pieChart = UiPieChart.of("Pie Chart Demo", Direction.RIGHT, UiDataSet.of("AWT", 1),
        UiDataSet.of("Swing", 5), UiDataSet.of("SWT/Eclipse", 4), UiDataSet.of("JavaFx", 5), UiDataSet.of("JSF", 3),
        UiDataSet.of("GWT", 1), UiDataSet.of("AngularJS", 2), UiDataSet.of("Angular", 5), UiDataSet.of("React", 3),
        UiDataSet.of("Vue", 2), UiDataSet.of("Ionic", 2), UiDataSet.of("Android", 6), UiDataSet.of("iOS", 4));
    pieChart.setLegendPlacement(Direction.RIGHT);
    panel.addChild(pieChart);
    UiBarChartHorizontal barChart = UiBarChartHorizontal.of("Bar Chart Demo", Direction.RIGHT,
        UiDataSet.of("Angular", new UiDataSeriesDouble(2200, 3000, 2900)),
        UiDataSet.of("React", new UiDataSeriesDouble(1200, 2100, 3000)),
        UiDataSet.of("Vue", new UiDataSeriesDouble(250, 600, 1000)));
    barChart.setSeriesLabels("2018", "2019", "2020");
    panel.addChild(barChart);
    UiLineChart lineChart = UiLineChart.of("Line Chart Demo", Direction.RIGHT,
        UiDataSet.of("Linear",
            new UiPoint[] { new UiPoint(1, 1), new UiPoint(2, 2), new UiPoint(3, 3), new UiPoint(4, 4),
            new UiPoint(5, 5) }),
        UiDataSet.of("Square", new UiPoint[] { new UiPoint(1, 1), new UiPoint(2, 4), new UiPoint(3, 9),
        new UiPoint(4, 16), new UiPoint(5, 25) }));
    panel.addChild(lineChart);
    UiTab tab = tabPanel.addChild(panel, "Chart");
  }

  private static void createVideoTab(UiTabPanel tabPanel) {

    UiVerticalPanel page = UiVerticalPanel.of();
    UiMediaSource sourceLq = new UiMediaSource("https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-576p.mp4",
        UiMediaSource.MIMETYPE_VIDEO_MP4);
    UiMediaSource sourceHq = new UiMediaSource(
        "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-1080p.mp4", UiMediaSource.MIMETYPE_VIDEO_MP4);
    UiMediaTrack track = new UiMediaTrack("https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.en.vtt",
        UiMediaTrack.KIND_CAPTIONS, "en", "English");
    UiMedia video = UiMedia.ofVideo(new UiMediaSource[] { sourceLq, sourceHq }, new UiMediaTrack[] { track },
        "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.jpg");
    UiMediaPlayer player = UiMediaPlayer.of(video);
    player.setMedia(video);
    page.addChild(player);
    UiTab tab = tabPanel.addChild(page, "Video");
  }

}
