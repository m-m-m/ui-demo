/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import java.util.function.Consumer;

import io.github.mmm.marshall.StandardFormat;
import io.github.mmm.marshall.StructuredTextFormat;
import io.github.mmm.ui.api.attribute.AttributeWriteValue;
import io.github.mmm.ui.api.event.action.UiActionReset;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.input.UiTextArea;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 *
 */
public class JsonEditor extends UiCustomVerticalPanel implements AttributeWriteValue<Person> {

  private static final String JSON_DEFAULT = "{\n" //
      + "  \"FirstName\": \"John\",\n" //
      + "  \"LastName\": \"Doe\",\n" //
      + "  \"Age\": 42,\n" //
      + "  \"City\": \"New York\",\n" //
      + "  \"Country\": \"USA\"\n" //
      + "}";

  private final StructuredTextFormat jsonFormat;

  private final UiTextArea jsonTextArea;

  /**
   * The constructor.
   *
   * @param consumer the {@link Consumer} of the {@link Person} to update the editor.
   */
  public JsonEditor(Consumer<Person> consumer) {

    super();
    this.jsonFormat = StandardFormat.json();
    UiFormPanel<Void> form = UiFormPanel.of();
    this.jsonTextArea = UiTextArea.of("JSON");
    this.jsonTextArea.setValue(JSON_DEFAULT);
    form.addChild(this.jsonTextArea);
    addChild(form);
    UiButton updateEditorButton = UiButton.of("Update Editor", e -> {
      consumer.accept(getValue());
    });
    UiActionReset reset = e -> this.jsonTextArea.setValue(JSON_DEFAULT);
    UiButton resetButton = UiButton.of(reset);
    UiButtonPanel buttonPanel = UiButtonPanel.of(resetButton, updateEditorButton);
    addChild(buttonPanel);
  }

  @Override
  public Person getValue() {

    Person person = new Person();
    this.jsonFormat.read(this.jsonTextArea.getValue(), person);
    return person;
  }

  @Override
  public void setValue(Person person) {

    String json = this.jsonFormat.write(person);
    this.jsonTextArea.setValue(json);
  }

}
