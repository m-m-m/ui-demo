/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.chart.UiPieChart;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 * {@link io.github.mmm.ui.api.controller.UiController#getView() View} of {@link PieChartController}.
 */
public class PieChartView extends UiCustomVerticalPanel {

  /**
   * The constructor.
   */
  @SuppressWarnings("unchecked")
  public PieChartView() {

    super();
    UiPieChart chart = UiPieChart.of("Pie Chart Demo", Direction.RIGHT, UiDataSet.of("AWT", 1),
        UiDataSet.of("Swing", 5), UiDataSet.of("SWT/Eclipse", 4), UiDataSet.of("JavaFx", 5), UiDataSet.of("JSF", 3),
        UiDataSet.of("GWT", 1), UiDataSet.of("AngularJS", 2), UiDataSet.of("Angular", 5), UiDataSet.of("React", 3),
        UiDataSet.of("Vue", 2), UiDataSet.of("Ionic", 2), UiDataSet.of("Android", 6), UiDataSet.of("iOS", 4));
    chart.setLegendPlacement(Direction.RIGHT);
    this.delegate.addChild(chart);
  }

}
