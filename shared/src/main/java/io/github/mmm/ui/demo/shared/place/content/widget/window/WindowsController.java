/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.window;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class WindowsController extends TabController<WindowsView> {

  /** @see #getId() */
  public static final String ID = "Windows";

  /**
   * The constructor.
   */
  public WindowsController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected WindowsView createView() {

    return new WindowsView();
  }

}
