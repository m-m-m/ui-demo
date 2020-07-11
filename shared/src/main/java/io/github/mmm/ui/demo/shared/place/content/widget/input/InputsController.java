/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.input;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link InputsView}.
 */
public class InputsController extends TabController<InputsView> {

  /** @see #getId() */
  public static final String ID = "Inputs";

  /**
   * The constructor.
   */
  public InputsController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected InputsView createView() {

    return new InputsView();
  }

}
