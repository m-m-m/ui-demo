/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.input;

import io.github.mmm.base.range.RangeType;
import io.github.mmm.ui.api.widget.form.UiCustomFormPanel;
import io.github.mmm.ui.api.widget.form.UiFormGroup;
import io.github.mmm.ui.api.widget.input.UiComboBox;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import io.github.mmm.ui.api.widget.input.UiTextArea;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.number.UiDoubleInput;
import io.github.mmm.ui.api.widget.number.UiIntegerInput;
import io.github.mmm.ui.api.widget.number.UiIntegerSlider;
import io.github.mmm.ui.demo.shared.Fruit;
import io.github.mmm.ui.demo.shared.place.content.widget.data.DataTableController;
import io.github.mmm.validation.main.ValidatorRange;

/**
 * View of {@link DataTableController}.
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
    basic.addChild(UiComboBox.ofEnum("ComboBox", Fruit.class));
    basic.addChild(UiRadioChoice.ofEnum("RadioChoice", Fruit.class));
    this.delegate.addChild(basic);

    UiFormGroup<Void> numeric = UiFormGroup.of("Numeric Inputs");
    UiIntegerInput integerInput = UiIntegerInput.of("IntegerInput");
    numeric.addChild(integerInput);
    UiIntegerSlider integerSlider = UiIntegerSlider.of("IntegerSlider");
    integerSlider.getRange().setMin(-10);
    integerSlider.getRange().setMax(10);
    numeric.addChild(integerSlider);
    UiDoubleInput doubleInput = UiDoubleInput.of("DoubleInput");
    ValidatorRange<Double> validatorDouble = new ValidatorRange<>(new RangeType<>(-1.0, 1.0));
    doubleInput.setValidator(validatorDouble);
    numeric.addChild(doubleInput);
    this.delegate.addChild(numeric);

    UiFormGroup<Void> prefixSuffix = UiFormGroup.of("Prefix/Suffix");
    UiDoubleInput prefixInput = UiDoubleInput.of("Prefix");
    prefixInput.setPrefix("$");
    prefixSuffix.addChild(prefixInput);
    UiDoubleInput suffixInput = UiDoubleInput.of("Suffix");
    suffixInput.setSuffix("m/s");
    prefixSuffix.addChild(suffixInput);
    UiIntegerInput prefixSuffixInput = UiIntegerInput.of("Phone");
    prefixSuffixInput.setPrefix("+49");
    prefixSuffixInput.setSuffix("work");
    prefixSuffix.addChild(prefixSuffixInput);
    this.delegate.addChild(prefixSuffix);

    UiFormGroup<Void> custom = UiFormGroup.of("Custom");
    CustomHorizontalInput hInput = new CustomHorizontalInput();
    hInput.setName("URL");
    custom.addChild(hInput);
    this.delegate.addChild(custom);
  }

}
