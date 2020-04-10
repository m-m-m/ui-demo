package io.github.mmm.demo.ui.tvm;

import io.github.mmm.demo.ui.shared.DemoUi;

/**
 * TeaVM client app to run {@link DemoUi} in the browser.
 */
public class DemoUiTvm {

  /**
   * @param args the command-line arguments. Actually not really used by TeaVM.
   */
  public static void main(String[] args) {

    DemoUi app = new DemoUi();
    app.run();
  }

}
