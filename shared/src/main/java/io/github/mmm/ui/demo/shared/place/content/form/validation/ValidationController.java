/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.form.validation;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link ValidationView}.
 */
public class ValidationController extends TabController<ValidationView> {

  /** @see #getId() */
  public static final String ID = "Validation";

  /**
   * The constructor.
   */
  public ValidationController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected ValidationView createView() {

    return new ValidationView();
  }

}
