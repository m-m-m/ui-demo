/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.datatype.chart.UiDataSeriesDouble;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.chart.UiBarChartHorizontal;
import io.github.mmm.ui.api.widget.custom.panel.UiCustomVerticalPanel;

/**
 * {@link io.github.mmm.ui.api.controller.UiController#getView() View} of {@link BarChartController}.
 */
public class BarChartView extends UiCustomVerticalPanel {

  /**
   * The constructor.
   */
  @SuppressWarnings("unchecked")
  public BarChartView() {

    super();
    UiBarChartHorizontal chart = UiBarChartHorizontal.of("Bar Chart Demo", Direction.RIGHT,
        UiDataSet.of("Angular", new UiDataSeriesDouble(2200, 3000, 2900)),
        UiDataSet.of("React", new UiDataSeriesDouble(1200, 2100, 3000)),
        UiDataSet.of("Vue", new UiDataSeriesDouble(250, 600, 1000)));
    chart.setSeriesLabels("2018", "2019", "2020");
    this.delegate.addChild(chart);
  }

}
