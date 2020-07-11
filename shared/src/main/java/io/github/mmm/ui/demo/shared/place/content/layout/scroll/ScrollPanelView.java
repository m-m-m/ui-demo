/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.demo.shared.place.content.layout.scroll;

import io.github.mmm.ui.api.datatype.UiScrollBarVisibility;
import io.github.mmm.ui.api.widget.UiText;
import io.github.mmm.ui.api.widget.panel.UiCustomScrollPanel;

/**
 * View of {@link ScrollPanelController}.
 */
public class ScrollPanelView extends UiCustomScrollPanel {

  /**
   * The constructor.
   */
  public ScrollPanelView() {

    super();
    UiText text = UiText
        .of("This is a very long text to ensure the content does not easily fit into the scroll panel.\n"
            + "Therefore it will produce an overflow and ensure that scrolling gets enabled (at least a vertical scrollbar should be present). "
            + "Maybe if you zoom out in the web-ui to the maximum or use the browser debugger to reduce the font size the text will entirely fit into the scroll panel and the scroll bars might dissappear. "
            + "To demonstrate the scroll panel we enforce the verical scroll bar by setting VerticalScrolling to UiScrollBarVisibility.ALWAYS. "
            + "You may also use CSS to customize the scollbars but the programmatic API makes it easier as typically the scollbar visibility is more a functional feature than a styling issue.\n"
            + "In this demo we only put a UiText inside the scroll panel. Of course you can put any widget (any instance of UiRegularWidget) into a UiScrollPanel.\n"
            + "To enable scrolling you typically place a UiScrollPanel explicitly into your UI.\n"
            + "This gives you the flexibility to fully control where scrolling should happen and where not.\n"
            + "Also not building this feature into every panel by default reduces overhead and allows more efficient UI structures.\n"
            + "If you want to have scrolling by default for typical panels like UiVerticalPanel or for UiNavigationBar,\n"
            + "you can easily create your own UiCustomWidget combining a UiScrollPanel with the according layout panel.\n"
            + "The only excuse to this principle is the browser window itself that will allow scrolling by default and\n"
            + "also data grids (UiDataTable, UiDataTree, and UiDataTreeTable) where the scrolling has to happen inside the table body\n"
            + "what could not be solved with an explicit UiScrollPanel.\n"
            + "Further it is a very common demand to have vertical scrolling for data grids by default.\n"
            + "So actually there is not much more to say about scroll panels.\n"
            + "So instead of further reading this stupid text, you better read the documentation of this cool UI framework and\n"
            + "study one of the many other cool features.\n"
            + "The most valuable and productive features however can not be shown easily with this demo app.\n"
            + "You need to have a look at the code examples for dynamic binding of entire beans to the UI.\n"
            + "While other frameworks either do not support this at all or if they do\n"
            + "prevent to customize the resulting UI our apporach is both fully efficient\n"
            + "and yet flexible to allow influencing the ordering, filtering, rendering, visualization to view and edit,"
            + "sub-grouping, adding of additinal custom widgets at any place, etc.\n"
            + "Also client/server communication is extremely easy and for standard CRUD you do not even have to code anything if you like.\n"
            + "Standard REST support for simple crud comes with only a single line of code on the backend.\n"
            + "On the frontend you can immediately use the RPC API to invoke services.\n"
            + "When you run your app in the browser this will use AJAX (XMLHttpRequest) while if you run a native desktop client (e.g. using JavaFx) the build-in HTTP client from the JDK is used.\n"
            + "Coding UIs has never been so easy, fast, and fun!\n"
            + "We are aware that many other frameworks in the past have already given such promise.\n"
            + "The sad truth is that most of them never kept it and therefore developers are dissapointed.\n"
            + "You might not even buy our story easily but please give it a try to build your first simple app\n"
            + "with pure Java, low code, fast results.\n"
            + "However, unlike other low code or no code platforms this is all based on the established and open Java ecosystem.\n"
            + "This prevents a vendor-lockin and gives you full control to implement every 'bell and whistle' you need to have in order to satisfy your demands.\n"
            + "We hope to get your feedback on github.\n"
            + "Please feel invited to contribute and make this project better every day.\n"
            + "Everything is designed fully modular based on the Java module system (JPMS).\n"
            + "This allows developers using the framework to replace widget implementations easily.\n"
            + "Also developers can create their own widget APIs and implementation for missing features.\n"
            + "If possible they can share their code and via Github PRs we can integrate it so the rest of the world can benefit.\n"
            + "However, it is also possible to do your own proprietary custom extensions for closed-sourced industrial-secret USPs.\n"
            + "So enough of writing here that nobody will ever read.\n"
            + "I will continue with the regular nonsense texts:\n"
            + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr,\n"
            + "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.\n"
            + "At vero eos et accusam et justo duo dolores et ea rebum.\n"
            + "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\n"
            + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.\n"
            + "At vero eos et accusam et justo duo dolores et ea rebum.\n"
            + "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\\n"
            + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.\\n"
            + "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet\n"
            + "\n" //
            + "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,\n"
            + "vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.\n"
            + "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.\n"
            + "\n"
            + "Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.\n"
            + "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,\n"
            + "vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.\n"
            + "\n"
            + "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.   \n"
            + "\n" //
            + "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,\n"
            + "vel illum dolore eu feugiat nulla facilisis.\n" //
            + "\n" //
            + "At vero eos et accusam et justo duo dolores et ea rebum.\n"
            + "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\n"
            + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,\n"
            + "sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.\n"
            + "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.\n"
            + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr,\n"
            + "At accusam aliquyam diam diam dolore dolores duo eirmod eos erat,\n"
            + "et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum.\n"
            + "Sanctus sea sed takimata ut vero voluptua.\n" + "Est Lorem ipsum dolor sit amet.\n");
    setChild(text);
    setVerticalScrolling(UiScrollBarVisibility.ALWAYS);
  }

}
