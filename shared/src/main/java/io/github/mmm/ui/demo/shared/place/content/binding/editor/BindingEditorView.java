/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
* http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;

/**
 * View of {@link BindingEditorController}.
 */
public class BindingEditorView extends UiCustomVerticalPanel {

  private final JsonEditor jsonEditor;

  private final PersonEditor personEditor;

  /**
   * The constructor.
   */
  public BindingEditorView() {

    super();
    this.jsonEditor = new JsonEditor(this::updatePerson);
    addChild(this.jsonEditor);
    this.personEditor = new PersonEditor(this::updateJson);
    addChild(this.personEditor);
  }

  private void updateJson(Person person) {

    this.jsonEditor.setValue(person);
  }

  private void updatePerson(Person person) {

    this.personEditor.setValue(person);
  }

}
