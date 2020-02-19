/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.demo.ui.shared;

import java.util.Collection;
import java.util.Map;

import io.github.mmm.base.i18n.Localizable;
import io.github.mmm.validation.AbstractValueValidator;

/**
 * TODO: Temporary replacement until java.time and NLS is supported by TeaVM.
 *
 * @since 1.0.0
 */
public class ValidatorMandatory extends AbstractValueValidator<Object> {

  /** @see #getCode() */
  public static final String CODE = "Mandatory";

  private static final ValidatorMandatory INSTANCE = new ValidatorMandatory();

  /**
   * The constructor.
   */
  public ValidatorMandatory() {

    super();
  }

  @Override
  protected String getCode() {

    return CODE;
  }

  /**
   * @return the singleton instance of this class.
   */
  public static ValidatorMandatory getInstance() {

    return INSTANCE;
  }

  @Override
  protected Localizable validateNull() {

    return getFailureMessage();
  }

  private Localizable getFailureMessage() {

    return Localizable.ofStatic("The value has to be filled.");
  }

  @Override
  protected Localizable validateNotNull(Object value) {

    if (value instanceof Collection) {
      Collection<?> collection = (Collection<?>) value;
      if (collection.isEmpty()) {
        return getFailureMessage();
      }
    } else if (value instanceof Map) {
      Map<?, ?> map = (Map<?, ?>) value;
      if (map.isEmpty()) {
        return getFailureMessage();
      }
    } else if (value instanceof CharSequence) {
      CharSequence sequence = (CharSequence) value;
      if (sequence.length() == 0) {
        return getFailureMessage();
      }
    }
    return null;
  }

  @Override
  public final boolean isMandatory() {

    return true;
  }

}
