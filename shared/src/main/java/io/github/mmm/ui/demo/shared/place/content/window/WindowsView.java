/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.window;

import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.event.action.UiActionClose;
import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.api.widget.UiText;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.custom.panel.UiCustomVerticalPanel;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.window.UiPopup;
import io.github.mmm.ui.api.widget.window.UiWindow;

/**
 * View of {@link WindowsController}.
 */
public class WindowsView extends UiCustomVerticalPanel {

  private UiPopup popup;

  private int counter = 1;

  /**
   * The constructor.
   */
  public WindowsView() {

    super();
    this.delegate.addChild(UiText.of("Here you can test some simple window and popup features..."));
    this.delegate.addChild(UiButton.of("Open Window", (e) -> {
      UiButtonPanel buttonPanel = UiButtonPanel.of();
      UiWindow window = UiWindow.of("Window" + this.counter++, buttonPanel);
      UiActionClose action = evt -> {
        window.close();
      };
      buttonPanel.addChild(UiButton.of(action));
      window.getPosition().setX(200 + this.counter * 20);
      window.getPosition().setY(200 + this.counter * 20);
      window.getSize().setWidthInPixel(200);
      window.getSize().setHeightInPixel(200);
      window.open();
    }));
    this.delegate.addChild(UiButton.of("Open Popup", (e) -> {
      if (this.popup == null) {
        this.popup = UiNotifier.get().showPopupOk("This is a test\n<br><blink>blink</blink>", UiSeverity.INFORMATION);
        this.popup.getSize().setWidthInPixel(200);
        this.popup.getSize().setHeightInPixel(200);
      } else {
        this.popup.open();
      }
    }));
  }

}
