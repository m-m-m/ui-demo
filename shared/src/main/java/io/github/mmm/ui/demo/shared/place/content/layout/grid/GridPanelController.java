/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.layout.grid;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link GridPanelView}.
 */
public class GridPanelController extends TabController<GridPanelView> {

  /** @see #getId() */
  public static final String ID = "GridPanel";

  /**
   * The constructor.
   */
  public GridPanelController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected GridPanelView createView() {

    return new GridPanelView();
  }

}
