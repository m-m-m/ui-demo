/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.chart;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for LineChartView.
 */
public class LineChartController extends TabController<LineChartView> {

  /** @see #getId() */
  public static final String ID = "LineChart";

  /**
   * The constructor.
   */
  public LineChartController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected LineChartView createView() {

    return new LineChartView();
  }

}
