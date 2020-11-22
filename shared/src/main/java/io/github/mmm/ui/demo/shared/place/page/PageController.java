/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.page;

import io.github.mmm.ui.api.controller.UiEmbedding;
import io.github.mmm.ui.api.controller.UiNavigationManager;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.panel.UiBorderPanel;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.spi.controller.AbstractUiController;
import io.github.mmm.ui.spi.controller.AbstractUiControllerPage;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class PageController extends AbstractUiControllerPage {

  private UiMenuBar menuBar;

  /**
   * The constructor.
   */
  public PageController() {

    super();
  }

  @Override
  public String getTitle() {

    return "Demo of mmm-ui";
  }

  @Override
  protected UiBorderPanel createView() {

    initMenuBar();
    return super.createView();
  }

  @Override
  protected UiEmbedding doShow(UiPlace newPlace, UiEmbedding newSlot) {

    embed(UiEmbedding.NAVIGATION, UiNavigationManager.get().getController(ID_NAVIGATION));
    // embed(UiEmbedding.SLOT_HEADER, UiNavigationManager.get().getController(ID_HEADER));
    // embed(UiEmbedding.SLOT_FOOTER, UiNavigationManager.get().getController(ID_HEADER));
    return super.doShow(newPlace, newSlot);
  }

  private void initMenuBar() {

    if (this.menuBar != null) {
      return;
    }
    this.menuBar = UiMenuBar.get();
    UiMenu fileMenu = this.menuBar.addMenu("File");
    fileMenu.addItem("Back", e -> {
      UiNavigationManager.get().navigateBack();
    });
    fileMenu.addItem("Forward", e -> {
      UiNavigationManager.get().navigateForward();
    });
    fileMenu.addSeparator();
    UiMenu submenu = fileMenu.addMenu("Submenu");
    submenu.addItem("Sub-Item1", e -> {
      System.out.println("Selected Sub-Item1");
    });
    submenu.addItem("Sub-Item2", e -> {
      System.out.println("Selected Sub-Item2");
    });
    fileMenu.addItem("Exit", e -> {
      UiMainWindow.get().setVisible(false);
    });
    UiMenu optionsMenu = this.menuBar.addMenu("Options");
    optionsMenu.addItem("Theme", e -> {
      System.out.println("Selected Theme from Options menu");
    });
  }

}
