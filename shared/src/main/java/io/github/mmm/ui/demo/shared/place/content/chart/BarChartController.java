/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.chart;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link BarChartView}.
 */
public class BarChartController extends TabController<BarChartView> {

  /** @see #getId() */
  public static final String ID = "BarChart";

  /**
   * The constructor.
   */
  public BarChartController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected BarChartView createView() {

    return new BarChartView();
  }

}
