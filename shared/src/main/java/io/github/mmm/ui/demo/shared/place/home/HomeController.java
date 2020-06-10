/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.home;

import io.github.mmm.ui.api.controller.UiEmbedding;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.widget.UiText;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.spi.controller.AbstractUiController;
import io.github.mmm.ui.spi.controller.AbstractUiControllerContent;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class HomeController extends AbstractUiControllerContent<UiVerticalPanel> {

  /**
   * The constructor.
   */
  public HomeController() {

    super();
  }

  @Override
  public String getId() {

    return ID_HOME;
  }

  @Override
  public String getTitle() {

    return "Demo of mmm-ui";
  }

  @Override
  protected UiEmbedding doShow(UiPlace newPlace, UiEmbedding newSlot) {

    return UiEmbedding.HOME;
  }

  @Override
  protected UiVerticalPanel createView() {

    UiVerticalPanel view = UiVerticalPanel.of();
    UiText text = UiText.of("Welcome to the wonderful world of mmm-ui!");
    view.addChild(text);
    return view;
  }

}
