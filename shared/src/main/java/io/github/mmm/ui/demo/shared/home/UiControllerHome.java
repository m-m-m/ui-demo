/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.home;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.attribute.AttributeWriteAutocomplete;
import io.github.mmm.ui.api.binding.data.UiDataBinding;
import io.github.mmm.ui.api.controller.AbstractUiController;
import io.github.mmm.ui.api.controller.AbstractUiControllerMain;
import io.github.mmm.ui.api.controller.UiControllerSlot;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.datatype.UiPoint;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.datatype.chart.UiDataSeriesDouble;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.datatype.media.UiMedia;
import io.github.mmm.ui.api.datatype.media.UiMediaSource;
import io.github.mmm.ui.api.datatype.media.UiMediaTrack;
import io.github.mmm.ui.api.event.UiValueChangeEventListener;
import io.github.mmm.ui.api.event.action.UiActionCancel;
import io.github.mmm.ui.api.event.action.UiActionClose;
import io.github.mmm.ui.api.event.action.UiActionDelete;
import io.github.mmm.ui.api.event.action.UiActionReset;
import io.github.mmm.ui.api.event.action.UiActionSubmit;
import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.chart.UiBarChartHorizontal;
import io.github.mmm.ui.api.widget.chart.UiLineChart;
import io.github.mmm.ui.api.widget.chart.UiPieChart;
import io.github.mmm.ui.api.widget.data.UiDataTable;
import io.github.mmm.ui.api.widget.form.UiFormGroup;
import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.input.UiCheckbox;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import io.github.mmm.ui.api.widget.input.UiTextArea;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.media.UiMediaPlayer;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.number.UiIntegerSlider;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiScrollPanel;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.api.widget.tab.UiTab;
import io.github.mmm.ui.api.widget.tab.UiTabPanel;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.api.widget.window.UiPopup;
import io.github.mmm.ui.api.widget.window.UiWindow;
import io.github.mmm.ui.demo.shared.TestBean;
import io.github.mmm.validation.main.ValidatorMandatory;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class UiControllerHome extends AbstractUiControllerMain<UiTabPanel> {

  private UiMenuBar menuBar;

  private UiPopup popup;

  private int counter = 1;

  /**
   * The constructor.
   */
  public UiControllerHome() {

    super();
  }

  @Override
  public String getId() {

    return ID_HOME;
  }

  @Override
  public String getTitle() {

    return "Demo of mmm-ui";
  }

  @Override
  protected UiControllerSlot doShow(UiPlace newPlace, UiControllerSlot newSlot) {

    return UiControllerSlot.SLOT_ROOT;
  }

  @Override
  protected UiTabPanel createView() {

    initMenuBar();
    UiDataBinding binding = new UiDataBinding();
    UiTabPanel tabPanel = UiTabPanel.of();
    UiTab tab1 = createWindowTab(tabPanel);
    UiVerticalPanel page2 = UiVerticalPanel.of();
    // UiTab tab2 =
    tabPanel.addTab("Tab2", page2);
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
    UiCheckbox showLogin = UiCheckbox.of("Show Login");
    showLogin.setId("showLogin");
    showLogin.setSelected(true);
    UiTextInput textInput = UiTextInput.of("Login");
    UiValueChangeEventListener showLoginListener = (e) -> {
      textInput.setVisible(showLogin.isSelected());
    };
    showLogin.addListener(showLoginListener);
    textInput.setId("login");
    textInput.setTooltip("Unique identifier of the user for authentication");
    textInput.setAutocomplete(AttributeWriteAutocomplete.AUTOCOMPLETE_USERNAME);
    textInput.setValidator(ValidatorMandatory.getInstance());
    UiPasswordInput passwordInput = UiPasswordInput.ofNew("Password");
    UiPasswordInput confirmPasswordInput;
    confirmPasswordInput = passwordInput.createConfirmationInput();

    UiTextArea textArea = UiTextArea.of("Comment");
    UiRadioChoice<TimeUnit> choice = UiRadioChoice.ofEnum("Time-unit", TimeUnit.class);
    choice.setTooltip("Choose a time-unit from the options of the enum.");
    UiIntegerSlider slider = UiIntegerSlider.of("Slider");
    slider.setTextEditable(true);
    UiFormGroup<Void> formGroupTabs = UiFormGroup.of("Show Tabs", showTab1, showTab3, showLogin);
    UiFormGroup<Void> formGroupInputs = UiFormGroup.of("Generic Inputs", textInput, passwordInput, confirmPasswordInput,
        textArea, choice, slider);

    UiFormPanel<Void> formPanel = UiFormPanel.of(formGroupTabs, formGroupInputs);
    page2.addChild(formPanel);
    UiActionSubmit submit = e -> {
      formPanel.validate();
    };
    UiButton submitButton = UiButton.of(submit);
    UiActionReset reset = UiActionReset.of(formPanel);
    UiButton resetButton = UiButton.of(reset);
    UiActionDelete delete = e -> {
      System.out.println("Delete");
    };
    UiButton deleteButton = UiButton.of(delete);
    UiActionCancel cancel = e -> {
      System.out.println("Cancel");
    };
    UiButton cancelButton = UiButton.of(cancel);
    cancelButton.getStyles().add("abort");
    UiButtonPanel buttonPanel = UiButtonPanel.of(submitButton, resetButton, deleteButton, cancelButton);
    page2.addChild(buttonPanel);
    // TemporalDemo.createTab(tabPanel);
    createChartTab(tabPanel);
    createVideoTab(tabPanel);
    createTableTab(tabPanel);
    return tabPanel;
  }

  private UiTab createWindowTab(UiTabPanel tabPanel) {

    UiVerticalPanel page1 = UiVerticalPanel.of();
    UiTab tab1 = tabPanel.addTab("Tab1", page1);
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
    UiActionSubmit submit = e -> {
      System.out.println("Submit");
      boolean valid = formPanel.validate();
      System.out.println("Valid:" + valid);
      System.out.println(formPanel.getValue().toString());
    };
    UiButton submitButton = UiButton.of(submit);
    UiButtonPanel buttonPanel = UiButtonPanel.of(submitButton);
    page3.addChild(buttonPanel);
    UiTab tab3 = tabPanel.addTab("Tab3", page3);
    return tab3;
  }

  @SuppressWarnings("unchecked")
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
    UiScrollPanel scrollPanel = UiScrollPanel.of(panel);
    tabPanel.addTab("Chart", scrollPanel);
  }

  private static void createTableTab(UiTabPanel tabPanel) {

    TestBean template = new TestBean();
    UiDataTable<TestBean> table = UiDataTable.of(template);
    table.setShowRowNumbers(true);
    table.addColumn(template.Name);
    table.addColumn(template.Age);
    List<TestBean> data = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      TestBean bean = new TestBean();
      bean.Name.set("Name " + i);
      bean.Age.set(i + 10);
      data.add(bean);
    }
    table.setValue(data);
    UiVerticalPanel panel = UiVerticalPanel.of(table);
    tabPanel.addTab("Table", panel);
  }

  private static void createVideoTab(UiTabPanel tabPanel) {

    Supplier<UiRegularWidget> supplier = () -> {
      UiVerticalPanel page = UiVerticalPanel.of();
      UiMediaSource sourceLq = new UiMediaSource(
          "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-576p.mp4", UiMediaSource.MIMETYPE_VIDEO_MP4);
      UiMediaSource sourceHq = new UiMediaSource(
          "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-1080p.mp4", UiMediaSource.MIMETYPE_VIDEO_MP4);
      UiMediaTrack track = new UiMediaTrack("https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.en.vtt",
          UiMediaTrack.KIND_CAPTIONS, "en", "English");
      UiMedia video = UiMedia.ofVideo(new UiMediaSource[] { sourceLq, sourceHq }, new UiMediaTrack[] { track },
          "https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.jpg");
      UiMediaPlayer player = UiMediaPlayer.of(video);
      player.setMedia(video);
      page.addChild(player);
      return page;
    };
    tabPanel.addTab("Video", supplier);
  }

  private void initMenuBar() {

    if (this.menuBar != null) {
      return;
    }
    this.menuBar = UiMenuBar.get();
    UiMenu fileMenu = this.menuBar.addMenu("File");
    fileMenu.addMenuItem("Exit", (e) -> {
      UiMainWindow.get().setVisible(false);
    });
    UiMenu optionsMenu = this.menuBar.addMenu("Options");
    optionsMenu.addMenuItem("Theme", (e) -> {
      System.out.println("Selected Theme from Options menu");
    });
  }

}
