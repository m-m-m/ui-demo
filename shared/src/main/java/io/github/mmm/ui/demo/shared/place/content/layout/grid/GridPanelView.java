/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.layout.grid;

import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.panel.UiCustomGridPanel;
import io.github.mmm.ui.api.widget.panel.UiGridRow;
import io.github.mmm.ui.demo.shared.place.content.form.validation.ValidationController;

/**
 * View of {@link ValidationController}.
 */
public class GridPanelView extends UiCustomGridPanel {

  /**
   * The constructor.
   */
  public GridPanelView() {

    super();
    getStyles().add("grid-borders");
    addRow(UiLabel.of("A1"), UiLabel.of("A2"), UiLabel.of("A3"));
    UiGridRow row3 = addRow();
    row3.addChild(UiLabel.of("C1-3"), -1, 3);
    UiGridRow row2 = addRow(1);
    row2.addChild(UiLabel.of("B1"));
    row2.addChild(UiLabel.of("B2-3"), -1, 2);
    UiGridRow row4 = addRow();
    row4.addChild(UiLabel.of("D1"), -1, 1, 2);
    row4.addChild(UiLabel.of("D2"), -1, 2);
    UiGridRow row5 = addRow();
    row5.addChild(UiLabel.of("E2"), -1, 2);
  }

}
