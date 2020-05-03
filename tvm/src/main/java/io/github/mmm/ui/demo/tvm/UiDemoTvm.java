package io.github.mmm.ui.demo.tvm;

import io.github.mmm.ui.api.controller.UiNavigationManager;
import io.github.mmm.ui.spi.controller.AbstractUiNavigationManager;
import io.github.mmm.ui.tvm.TvmApplication;

/**
 * TeaVM client app to run this UI demo in the browser with TeaVM.
 */
public class UiDemoTvm extends TvmApplication {

  @Override
  public void start() {

    ((AbstractUiNavigationManager) UiNavigationManager.get()).init();
  }

  /**
   * @param args the command-line arguments. Actually not really used by TeaVM.
   */
  public static void main(String[] args) {

    new UiDemoTvm().start();
  }

}
