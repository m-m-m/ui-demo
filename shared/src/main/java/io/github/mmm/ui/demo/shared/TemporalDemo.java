/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared;

import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.api.widget.tab.UiTab;
import io.github.mmm.ui.api.widget.tab.UiTabPanel;
import io.github.mmm.ui.api.widget.temporal.UiDateInput;
import io.github.mmm.ui.api.widget.temporal.UiDateTimeInput;
import io.github.mmm.ui.api.widget.temporal.UiTimeInput;

/**
 * Demo for temporal widgets. Currently not working on all platforms. For TeaVM see
 */
public class TemporalDemo {

  /**
   * @param tabPanel the {@link UiTabPanel}.
   * @return the {@link UiTab} with temporal widgets.
   */
  public static UiTab createTab(UiTabPanel tabPanel) {

    UiVerticalPanel page2 = UiVerticalPanel.of();
    UiDateInput dateInput = UiDateInput.of("Birthday");
    UiTimeInput timeInput = UiTimeInput.of("Time");
    UiDateTimeInput dateTimeInput = UiDateTimeInput.of("Appointment");
    UiFormPanel<Void> formPanel = UiFormPanel.of(dateInput, timeInput, dateTimeInput);

    page2.addChild(formPanel);
    return tabPanel.addTab("Temporals", page2);
  }

}
