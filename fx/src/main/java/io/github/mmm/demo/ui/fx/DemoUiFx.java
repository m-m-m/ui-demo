/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.demo.ui.fx;

import io.github.mmm.demo.ui.shared.DemoUi;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.FxApplication;
import javafx.application.Application;

/**
 * {@link FxApplication} for {@link DemoUi} to run in JavaFx.
 */
public class DemoUiFx extends FxApplication {

  @Override
  protected void start(UiContext context) {

    new DemoUi(context).run();
  }

  public static void main(String[] args) {

    Application.launch(DemoUiFx.class, args);
  }

}
