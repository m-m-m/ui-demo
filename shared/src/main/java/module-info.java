/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the portable UI of this demo.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.demo.shared {

  requires transitive io.github.mmm.ui.api.all;

  requires transitive io.github.mmm.ui.api.binding;

  provides io.github.mmm.ui.api.controller.UiController with //
      io.github.mmm.ui.demo.shared.home.UiControllerHome;

  exports io.github.mmm.ui.demo.shared;

}
