/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import io.github.mmm.ui.demo.shared.place.content.TabController;
import io.github.mmm.ui.spi.controller.AbstractUiController;

/**
 * {@link AbstractUiController Controller} for {@link BindingEditorView}.
 */
public class BindingEditorController extends TabController<BindingEditorView> {

  /** @see #getId() */
  public static final String ID = "DynamicEditor";

  /**
   * The constructor.
   */
  public BindingEditorController() {

    super();
  }

  @Override
  public String getId() {

    return ID;
  }

  @Override
  protected BindingEditorView createView() {

    return new BindingEditorView();
  }

}
