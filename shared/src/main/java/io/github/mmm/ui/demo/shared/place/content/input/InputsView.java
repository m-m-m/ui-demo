/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.input;

import io.github.mmm.base.range.RangeType;
import io.github.mmm.ui.api.widget.custom.form.UiCustomFormPanel;
import io.github.mmm.ui.api.widget.form.UiFormGroup;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import io.github.mmm.ui.api.widget.input.UiTextArea;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.number.UiDoubleInput;
import io.github.mmm.ui.api.widget.number.UiIntegerInput;
import io.github.mmm.ui.api.widget.number.UiIntegerSlider;
import io.github.mmm.validation.main.ValidatorRange;

/**
 * View of {@link InputsController}.
 */
public class InputsView extends UiCustomFormPanel<Void> {

  /**
   * The constructor.
   */
  public InputsView() {

    super();
    UiFormGroup<Void> basic = UiFormGroup.of("Basic Inputs");
    basic.addChild(UiTextInput.of("TextInput"));
    basic.addChild(UiPasswordInput.ofOff("PasswordInput"));
    basic.addChild(UiTextArea.of("TextArea"));
    this.delegate.addChild(basic);
    UiFormGroup<Void> numeric = UiFormGroup.of("Numeric Inputs");
    UiIntegerInput integerInput = UiIntegerInput.of("IntegerInput");
    ValidatorRange<Integer> validator = new ValidatorRange<>(new RangeType<>(-10, 10));
    integerInput.setValidator(validator);
    numeric.addChild(integerInput);
    UiIntegerSlider integerSlider = UiIntegerSlider.of("IntegerSlider");
    integerSlider.setValidator(validator);
    numeric.addChild(integerSlider);
    UiDoubleInput doubleInput = UiDoubleInput.of("DoubleInput");
    ValidatorRange<Double> validatorDouble = new ValidatorRange<>(new RangeType<>(-1.0, 1.0));
    doubleInput.setValidator(validatorDouble);
    numeric.addChild(doubleInput);
    this.delegate.addChild(numeric);
  }

}
