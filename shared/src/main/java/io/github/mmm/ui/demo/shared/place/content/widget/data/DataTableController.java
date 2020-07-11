/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.data;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link DataTableView}.
 */
public class DataTableController extends TabController<DataTableView> {

  /** @see #getId() */
  public static final String ID = "DataTable";

  /**
   * The constructor.
   */
  public DataTableController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected DataTableView createView() {

    return new DataTableView();
  }

}
