/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.navigation;

import io.github.mmm.ui.api.controller.action.UiActionNavigate;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiNavigationBar;
import io.github.mmm.ui.demo.shared.place.content.chart.BarChartController;
import io.github.mmm.ui.demo.shared.place.content.chart.LineChartController;
import io.github.mmm.ui.demo.shared.place.content.chart.PieChartController;
import io.github.mmm.ui.demo.shared.place.content.form.validation.ValidationController;
import io.github.mmm.ui.demo.shared.place.content.layout.grid.GridPanelController;
import io.github.mmm.ui.demo.shared.place.content.layout.scroll.ScrollPanelController;
import io.github.mmm.ui.demo.shared.place.content.widget.data.DataTableController;
import io.github.mmm.ui.demo.shared.place.content.widget.input.InputsController;
import io.github.mmm.ui.demo.shared.place.content.widget.window.WindowsController;
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
    addBasicWidgets(view);
    addDataWidgets(view);
    addForms(view);
    addLayouts(view);
    addCharts(view);
    return view;
  }

  private void addCharts(UiNavigationBar view) {

    UiMenu menu = view.addMenu("Charts");
    menu.addItem(UiActionNavigate.ofId(PieChartController.ID));
    menu.addItem(UiActionNavigate.ofId(BarChartController.ID));
    menu.addItem(UiActionNavigate.ofId(LineChartController.ID));
  }

  private void addLayouts(UiNavigationBar view) {

    UiMenu menu = view.addMenu("Layouts");
    menu.addItem(UiActionNavigate.ofId(ScrollPanelController.ID));
    menu.addItem(UiActionNavigate.ofId(GridPanelController.ID));
  }

  private void addForms(UiNavigationBar view) {

    UiMenu menu = view.addMenu("Forms");
    menu.addItem(UiActionNavigate.ofId(ValidationController.ID));
  }

  private void addBasicWidgets(UiNavigationBar view) {

    UiMenu menu = view.addMenu("Basic Widgets");
    menu.addItem(UiActionNavigate.ofId(InputsController.ID));
    menu.addItem(UiActionNavigate.ofId(WindowsController.ID));
  }

  private void addDataWidgets(UiNavigationBar view) {

    UiMenu menu = view.addMenu("Data Widgets");
    menu.addItem(UiActionNavigate.ofId(DataTableController.ID));
  }

}
