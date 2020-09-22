/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.binding.editor;

import io.github.mmm.bean.AbstractBean;
import io.github.mmm.bean.Bean;
import io.github.mmm.bean.Name;
import io.github.mmm.property.number.integers.IntegerProperty;
import io.github.mmm.property.string.StringProperty;

/**
 * A {@link Bean} for testing.
 */
@Name("mmm.Person")
public class Person extends Bean {

  /** Full name of person. */
  public final StringProperty FirstName;

  /** Full name of person. */
  public final StringProperty LastName;

  /** Age of person. */
  public final IntegerProperty Age;

  /**
   * The constructor.
   */
  public Person() {

    this(null, true);
  }

  /**
   * The constructor.
   *
   * @param dynamic the {@link #isDynamic() dynamic flag}.
   */
  public Person(boolean dynamic) {

    this(null, dynamic);
  }

  /**
   * The constructor.
   *
   * @param writable the writable {@link Bean} to create a {@link #isReadOnly() read-only} view on or {@code null} to
   *        create a regular mutable {@link Bean}.
   * @param dynamic the {@link #isDynamic() dynamic flag}.
   */
  public Person(AbstractBean writable, boolean dynamic) {

    super(writable, dynamic);
    this.FirstName = add().newString().withValidator().mandatory().and().build("FirstName");
    this.LastName = add().newString().withValidator().mandatory().and().build("LastName");
    this.Age = add().newInteger("Age");
  }

  @Override
  protected AbstractBean create(AbstractBean writable, boolean dynamic) {

    return new Person(writable, dynamic);
  }

}
