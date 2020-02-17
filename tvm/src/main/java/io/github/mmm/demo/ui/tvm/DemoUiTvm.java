package io.github.mmm.demo.ui.tvm;

import io.github.mmm.demo.ui.shared.DemoUi;
import io.github.mmm.ui.tvm.TvmContext;

/**
 * TeaVM client app to run {@link DemoUi} in the browser.
 */
public class DemoUiTvm {

  public static void main(String[] args) {

    TvmContext context = new TvmContext();
    DemoUi app = new DemoUi(context);
    app.run();
    // UiMainWindow browser = context.getMainWindow();
    // browser.addChild(context.createButton("Click me!", (e) -> Window.alert("Hello World!")));
    // browser.addChild(context.createTextInput("Name"));
    // browser.addChild(context.createCheckbox("Check me"));
  }

}
