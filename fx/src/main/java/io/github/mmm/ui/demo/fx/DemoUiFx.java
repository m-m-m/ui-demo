/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.fx;

import io.github.mmm.ui.demo.shared.DemoUi;
import io.github.mmm.ui.fx.FxApplication;
import javafx.application.Application;

/**
 * {@link FxApplication} for {@link DemoUi} to run in JavaFx.
 */
public class DemoUiFx extends FxApplication {

  @Override
  public void start() {

    new DemoUi().run();
  }

  /**
   * @param args the command-line arguments.
   */
  public static void main(String[] args) {

    Application.launch(DemoUiFx.class, args);
  }

}
