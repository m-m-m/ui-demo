/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content;

import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.controller.UiController;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.tab.UiTab;
import io.github.mmm.ui.api.widget.tab.UiTabPanel;
import io.github.mmm.ui.spi.controller.AbstractUiController;
import io.github.mmm.ui.spi.controller.AbstractUiControllerContent;

/**
 * {@link AbstractUiController Controller} for home dialog.
 */
public class ContentController extends AbstractUiControllerContent<UiTabPanel> {

  private UiTab homeTab;

  /**
   * The constructor.
   */
  public ContentController() {

    super();
  }

  @Override
  protected UiTabPanel createView() {

    return UiTabPanel.of();
  }

  @Override
  protected void onReset() {

    super.onReset();
    this.homeTab = null;
  }

  @Override
  protected boolean doEmbed(String slotId, UiController<?> childController) {

    UiRegularWidget child = childController.getView();
    UiTabPanel tabPanel = getView();
    if (ID_HOME.equals(slotId)) {
      if (this.homeTab == null) {
        this.homeTab = tabPanel.addTab("Home", child, 0);
      } else {
        tabPanel.setActiveChildIndex(0);
      }
    } else {
      UiTab tab = null;
      for (int i = tabPanel.getChildCount() - 1; i > 0; i--) {
        UiTab existingTab = tabPanel.getChild(i);
        if (slotId.equals(existingTab.getId())) {
          tab = existingTab;
          tab.setChild(child);
        }
      }
      if (tab == null) {
        String text = UiLocalizer.get().localize(slotId);
        if (text == null) {
          text = slotId;
        }
        tab = tabPanel.addTab(text, child);
        tab.setId(slotId);
        tab.setClosable(true);
      }
      tabPanel.setActiveChild(tab);
    }
    return true;
  }

}
