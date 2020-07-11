/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.widget.data;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.api.widget.data.UiDataTable;
import io.github.mmm.ui.api.widget.panel.UiCustomVerticalPanel;
import io.github.mmm.ui.demo.shared.TestBean;

/**
 * View of {@link DataTableController}.
 */
public class DataTableView extends UiCustomVerticalPanel {

  /**
   * The constructor.
   */
  public DataTableView() {

    super();
    TestBean template = new TestBean();
    UiDataTable<TestBean> table = UiDataTable.of(template);
    table.setShowRowNumbers(true);
    table.addColumn(template.Name);
    table.addColumn(template.Age);
    List<TestBean> data = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      TestBean bean = new TestBean();
      bean.Name.set("Name " + i);
      bean.Age.set(i + 10);
      data.add(bean);
    }
    table.setValue(data);
    addChild(table);
  }

}
