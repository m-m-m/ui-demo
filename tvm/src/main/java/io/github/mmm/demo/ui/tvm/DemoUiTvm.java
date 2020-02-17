package io.github.mmm.demo.ui.tvm;

import io.github.mmm.demo.ui.shared.DemoUi;
import io.github.mmm.ui.tvm.TvmContext;

/**
 * TeaVM client app to run {@link DemoUi} in the browser.
 */
public class DemoUiTvm {

  /**
   * @param args the command-line arguments. Actually not really used by TeaVM.
   */
  public static void main(String[] args) {

    TvmContext context = new TvmContext();
    DemoUi app = new DemoUi(context);
    app.run();
  }

}
