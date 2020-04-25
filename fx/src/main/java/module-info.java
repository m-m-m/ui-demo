/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
module io.github.mmm.ui.demo.fx {

  requires transitive io.github.mmm.ui.fx.all;

  requires transitive io.github.mmm.ui.fx.core;

  requires transitive io.github.mmm.ui.demo.shared;

  exports io.github.mmm.ui.demo.fx;

}
