/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.fx;

import io.github.mmm.ui.api.controller.UiNavigationManager;
import io.github.mmm.ui.fx.FxApplication;
import io.github.mmm.ui.spi.controller.AbstractUiNavigationManager;
import javafx.application.Application;

/**
 * {@link FxApplication} for to run this UI demo with JavaFx.
 */
public class UiDemoFx extends FxApplication {

  @Override
  public void start() {

    ((AbstractUiNavigationManager) UiNavigationManager.get()).init();
  }

  /**
   * @param args the command-line arguments.
   */
  public static void main(String[] args) {

    Application.launch(UiDemoFx.class, args);
  }

}
