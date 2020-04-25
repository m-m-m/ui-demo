package io.github.mmm.demo.ui.tvm;

import io.github.mmm.demo.ui.shared.DemoUi;
import io.github.mmm.ui.tvm.TvmApplication;

/**
 * TeaVM client app to run {@link DemoUi} in the browser.
 */
public class DemoUiTvm extends TvmApplication {

  @Override
  public void start() {

    DemoUi app = new DemoUi();
    app.run();
  }

  /**
   * @param args the command-line arguments. Actually not really used by TeaVM.
   */
  public static void main(String[] args) {

    new DemoUiTvm().start();
  }

}
