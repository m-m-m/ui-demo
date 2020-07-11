/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.form.validation;

import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 * View of {@link ValidationController}.
 */
public class ValidationView extends UiCustomVerticalPanel {

  /**
   * The constructor.
   */
  public ValidationView() {

    super();
    ValidationForm form = new ValidationForm();
    addChild(form);
    UiButton button = UiButton.of("Validate", e -> {
      form.validate();
    });
    UiButtonPanel buttonPanel = UiButtonPanel.of(button);
    addChild(buttonPanel);
  }

}
