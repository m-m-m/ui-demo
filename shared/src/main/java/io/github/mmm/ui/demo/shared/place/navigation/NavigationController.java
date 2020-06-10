/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.navigation;

import io.github.mmm.ui.api.controller.action.UiActionNavigate;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiNavigationBar;
import io.github.mmm.ui.demo.shared.place.content.chart.BarChartController;
import io.github.mmm.ui.demo.shared.place.content.chart.LineChartController;
import io.github.mmm.ui.demo.shared.place.content.chart.PieChartController;
import io.github.mmm.ui.demo.shared.place.content.input.InputsController;
import io.github.mmm.ui.demo.shared.place.content.window.WindowsController;
import io.github.mmm.ui.spi.controller.AbstractUiController;
import io.github.mmm.ui.spi.controller.AbstractUiControllerNavigation;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class NavigationController extends AbstractUiControllerNavigation<UiNavigationBar> {

  /**
   * The constructor.
   */
  public NavigationController() {

    super();
  }

  @Override
  protected UiNavigationBar createView() {

    UiNavigationBar view = UiNavigationBar.of();
    UiMenu widgetsMenu = view.addMenu("Widgets");
    widgetsMenu.addItem(UiActionNavigate.ofId(InputsController.ID));
    widgetsMenu.addItem(UiActionNavigate.ofId(WindowsController.ID));
    UiMenu chartsMenu = view.addMenu("Charts");
    chartsMenu.addItem(UiActionNavigate.ofId(PieChartController.ID));
    chartsMenu.addItem(UiActionNavigate.ofId(BarChartController.ID));
    chartsMenu.addItem(UiActionNavigate.ofId(LineChartController.ID));
    return view;
  }

}
