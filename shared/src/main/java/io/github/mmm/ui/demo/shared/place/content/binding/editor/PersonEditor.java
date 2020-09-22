/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import java.util.function.Consumer;

import io.github.mmm.ui.api.attribute.AttributeWriteValue;
import io.github.mmm.ui.api.binding.data.UiDataBinding;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.form.UiCustomFormPanel;
import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 * {@link UiCustomFormPanel} with the editor
 */
public class PersonEditor extends UiCustomVerticalPanel implements AttributeWriteValue<Person> {

  private final UiDataBinding binding;

  private UiFormPanel<Person> form;

  /**
   * The constructor.
   *
   * @param consumer the {@link Consumer} of the {@link Person} to update the JSON.
   */
  public PersonEditor(Consumer<Person> consumer) {

    super();
    this.binding = new UiDataBinding();
    UiButton button = UiButton.of("Update JSON", e -> {
      consumer.accept(getValue());
    });
    UiButtonPanel buttonPanel = UiButtonPanel.of(button);
    addChild(buttonPanel);
    setValue(new Person());
  }

  @Override
  public Person getValue() {

    if (this.form == null) {
      return null;
    }
    return this.form.getValue();
  }

  @Override
  public void setValue(Person person) {

    if (this.form != null) {
      removeChild(this.form);
    }
    this.form = this.binding.createFormPanel(person);
    this.form.setValue(person);
    addChild(this.form, 0);
  }

}
