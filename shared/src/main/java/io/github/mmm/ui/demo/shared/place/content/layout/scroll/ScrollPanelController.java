/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.layout.scroll;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link ScrollPanelView}.
 */
public class ScrollPanelController extends TabController<ScrollPanelView> {

  /** @see #getId() */
  public static final String ID = "ScrollPanel";

  /**
   * The constructor.
   */
  public ScrollPanelController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected ScrollPanelView createView() {

    return new ScrollPanelView();
  }

}
