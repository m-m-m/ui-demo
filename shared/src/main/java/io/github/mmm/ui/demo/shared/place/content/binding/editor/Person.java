/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import io.github.mmm.bean.AbstractBean;
import io.github.mmm.bean.Bean;
import io.github.mmm.bean.BeanName;
import io.github.mmm.bean.DynamicBean;
import io.github.mmm.bean.WritableBean;
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

    this(null);
  }

  /**
   * The constructor.
   *
   * @param writable the {@link WritableBean} to wrap as {@link #isReadOnly() read-only} bean or {@code null} to create
   *        a mutable bean.
   */
  public Person(WritableBean writable) {

    super(writable);
    this.FirstName = add().newString().withValidator().mandatory().and().build("FirstName");
    this.LastName = add().newString().withValidator().mandatory().and().build("LastName");
  }

  @Override
  protected AbstractBean create(WritableBean writable) {

    return new Person(writable);
  }

}
