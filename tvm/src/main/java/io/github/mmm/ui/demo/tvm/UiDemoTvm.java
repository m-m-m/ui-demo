package io.github.mmm.ui.demo.tvm;

import io.github.mmm.ui.demo.shared.UiDemo;
import io.github.mmm.ui.tvm.TvmApplication;

/**
 * TeaVM client app to run {@link UiDemo} in the browser.
 */
public class UiDemoTvm extends TvmApplication {

  @Override
  public void start() {

    UiDemo app = new UiDemo();
    app.start();
  }

  /**
   * @param args the command-line arguments. Actually not really used by TeaVM.
   */
  public static void main(String[] args) {

    new UiDemoTvm().start();
  }

}
