/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.datatype.UiPoint;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.chart.UiLineChart;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 * {@link io.github.mmm.ui.api.controller.UiController#getView() View} of {@link LineChartController}.
 */
public class LineChartView extends UiCustomVerticalPanel {

  /**
   * The constructor.
   */
  @SuppressWarnings("unchecked")
  public LineChartView() {

    super();
    UiLineChart chart = UiLineChart.of("Line Chart Demo", Direction.RIGHT,
        UiDataSet.of("Linear",
            new UiPoint[] { new UiPoint(1, 1), new UiPoint(2, 2), new UiPoint(3, 3), new UiPoint(4, 4),
            new UiPoint(5, 5) }),
        UiDataSet.of("Square", new UiPoint[] { new UiPoint(1, 1), new UiPoint(2, 4), new UiPoint(3, 9),
        new UiPoint(4, 16), new UiPoint(5, 25) }));
    this.delegate.addChild(chart);
  }

}
