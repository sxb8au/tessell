package org.gwtmpv.widgets.form;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import joist.util.Join;

import org.gwtmpv.bus.StubEventBus;
import org.gwtmpv.util.HTMLPanelBuilder;
import org.gwtmpv.widgets.StubHTMLPanel;
import org.gwtmpv.widgets.StubWidget;
import org.gwtmpv.widgets.StubWidgets;
import org.junit.Before;

public class AbstractFormPresenterTest {

  protected final StubWidgets widgets = new StubWidgets();
  protected final StubEventBus eventBus = new StubEventBus();
  protected final FormPresenter p = new FormPresenter(widgets, eventBus);

  @Before
  public void resetHTMLPanelBuilderId() {
    HTMLPanelBuilder.resetId();
  }

  @Before
  public void bind() {
    p.bind();
  }

  protected StubHTMLPanel html() {
    ((StubWidget) p.getView()).fireAttached();
    return (StubHTMLPanel) p.getView().getIsWidget(0);
  }

  protected void assertHtml(String... html) {
    ((StubWidget) p.getView()).fireAttached();
    assertThat(html().getHtml(), is(Join.join(html, "")));
  }

}