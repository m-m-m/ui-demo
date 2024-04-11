/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import io.github.mmm.bean.AbstractBean;
import io.github.mmm.bean.Bean;
import io.github.mmm.bean.BeanName;
import io.github.mmm.bean.DynamicBean;
import io.github.mmm.property.string.StringProperty;

/**
 * A {@link Bean} for testing.
 */
@BeanName("mmm.Person")
public class Person extends DynamicBean {

  /** Full name of person. */
  public final StringProperty FirstName;

  /** Full name of person. */
  public final StringProperty LastName;

  /**
   * The constructor.
   */
  public Person() {

    super();
    this.FirstName = add().newString().withValidator().mandatory().and().build("FirstName");
    this.LastName = add().newString().withValidator().mandatory().and().build("LastName");
  }

  @Override
  protected AbstractBean create() {

    return new Person();
  }

}
