/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the portable UI of this demo.
 *
 * @provides io.github.mmm.ui.api.controller.UiController
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.demo.shared {

  requires transitive io.github.mmm.ui.api.all;

  requires transitive io.github.mmm.ui.spi.controller;

  provides io.github.mmm.ui.api.controller.UiController with //
      io.github.mmm.ui.demo.shared.place.content.ContentController, //
      io.github.mmm.ui.demo.shared.place.content.chart.BarChartController, //
      io.github.mmm.ui.demo.shared.place.content.chart.LineChartController, //
      io.github.mmm.ui.demo.shared.place.content.chart.PieChartController, //
      io.github.mmm.ui.demo.shared.place.content.input.InputsController, //
      io.github.mmm.ui.demo.shared.place.content.window.WindowsController, //
      io.github.mmm.ui.demo.shared.place.home.HomeController, //
      io.github.mmm.ui.demo.shared.place.navigation.NavigationController, //
      io.github.mmm.ui.demo.shared.place.page.PageController //
  ;

  exports io.github.mmm.ui.demo.shared;

}
