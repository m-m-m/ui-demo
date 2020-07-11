/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.form.validation;

import io.github.mmm.ui.api.widget.form.UiCustomFormPanel;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.number.UiIntegerInput;
import io.github.mmm.validation.Validator;
import io.github.mmm.validation.main.ValidatorMandatory;
import io.github.mmm.validation.main.ValidatorRange;
import io.github.mmm.validation.string.ValidatorBuilderString;

/**
 * View of {@link ValidationController}.
 */
public class ValidationForm extends UiCustomFormPanel<Void> {

  /**
   * The constructor.
   */
  public ValidationForm() {

    super();
    UiTextInput name = UiTextInput.of("Name");
    name.setValidator(ValidatorMandatory.getInstance());
    name.setTooltip(
        "This field is mandatory. The label should be highlighted to indicate this. This value must be filled in order to be valid.");
    addChild(name);
    UiIntegerInput age = UiIntegerInput.of("Age");
    age.setValidator(new ValidatorRange<>(Integer.valueOf(0), Integer.valueOf(120)));
    age.setTooltip("This field is optional but its value has to be in the range from 0 to 120 in order to be valid.");
    addChild(age);
    UiPasswordInput password = UiPasswordInput.ofCurrent("Password");
    Validator<? super String> validator = new ValidatorBuilderString<>(null).mandatory().min(8).build();
    password.setValidator(validator);
    password.setTooltip("This field is mandatory and its password value has to be at least 8 characters long.");
    addChild(password);
    addChild(password.createConfirmationInput());
  }

}
