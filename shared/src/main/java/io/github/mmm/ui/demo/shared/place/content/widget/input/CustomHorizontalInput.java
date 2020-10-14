/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.input;

import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.event.UiValueChangeEventListener;
import io.github.mmm.ui.api.widget.form.UiCustomHorizontalInput;
import io.github.mmm.ui.api.widget.input.UiComboBox;
import io.github.mmm.ui.api.widget.input.UiTextInput;

/**
 * {@link UiCustomHorizontalInput} for a {@link java.net.URL}.
 */
public class CustomHorizontalInput extends UiCustomHorizontalInput<String> {

  private final UiComboBox<String> schemeInput;

  private final UiTextInput pathInput;

  /**
   * The constructor.
   */
  public CustomHorizontalInput() {

    super();
    this.schemeInput = UiComboBox.of("Protocol", "http://", "https://", "ftp://", "ftps://", "file://");
    this.pathInput = UiTextInput.of("Path");
    addChild(this.schemeInput);
    addChild(this.pathInput);
    initBinding(new Binding());
    UiValueChangeEventListener listener = e -> this.pathInput.setFocused();
    this.schemeInput.addListener(listener);
  }

  private class Binding implements UiValueBinding<String> {

    @Override
    public void setValue(String value, boolean forUser) {

      String scheme = null;
      String path = null;
      if (value != null) {
        int i = value.indexOf("://");
        if (i > 0) {
          scheme = value.substring(0, i + 3);
          path = value.substring(i + 3);
        } else {
          path = value;
        }
      }
      CustomHorizontalInput.this.schemeInput.setValue(scheme, forUser);
      CustomHorizontalInput.this.pathInput.setValue(path, forUser);
    }

    @Override
    public String getValue() {

      String scheme = CustomHorizontalInput.this.schemeInput.getValue();
      String path = CustomHorizontalInput.this.pathInput.getValue();
      return scheme + path;
    }

  }

}
