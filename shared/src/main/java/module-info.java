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

  requires transitive io.github.mmm.marshall.json;

  provides io.github.mmm.ui.api.controller.UiController with //
      io.github.mmm.ui.demo.shared.place.content.ContentController, //
      io.github.mmm.ui.demo.shared.place.content.binding.editor.BindingEditorController, //
      io.github.mmm.ui.demo.shared.place.content.chart.BarChartController, //
      io.github.mmm.ui.demo.shared.place.content.chart.LineChartController, //
      io.github.mmm.ui.demo.shared.place.content.chart.PieChartController, //
      io.github.mmm.ui.demo.shared.place.content.form.validation.ValidationController, //
      io.github.mmm.ui.demo.shared.place.content.layout.grid.GridPanelController, //
      io.github.mmm.ui.demo.shared.place.content.layout.scroll.ScrollPanelController, //
      io.github.mmm.ui.demo.shared.place.content.widget.data.DataTableController, //
      io.github.mmm.ui.demo.shared.place.content.widget.input.InputsController, //
      io.github.mmm.ui.demo.shared.place.content.widget.window.WindowsController, //
      io.github.mmm.ui.demo.shared.place.home.HomeController, //
      io.github.mmm.ui.demo.shared.place.navigation.NavigationController, //
      io.github.mmm.ui.demo.shared.place.page.PageController //
  ;

  exports io.github.mmm.ui.demo.shared;

}
