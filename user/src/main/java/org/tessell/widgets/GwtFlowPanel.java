package org.tessell.widgets;

import java.util.Iterator;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class GwtFlowPanel extends FlowPanel implements IsFlowPanel {

  @Override
  public void add(final IsWidget isWidget) {
    add(isWidget.asWidget());
  }

  @Override
  public boolean remove(final IsWidget isWidget) {
    return remove(isWidget.asWidget());
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public IsStyle getStyle() {
    return getIsElement().getStyle();
  }

  @Override
  public IsElement getIsElement() {
    return new GwtElement(getElement());
  }

  @Override
  public Iterator<IsWidget> iteratorIsWidgets() {
    return new GwtIsWidgetIteratorAdaptor(iterator());
  }

  @Override
  public void insert(IsWidget widget, int beforeIndex) {
    insert(widget.asWidget(), beforeIndex);
  }

  @Override
  public IsWidget getIsWidget(int index) {
    return (IsWidget) getWidget(index);
  }

  @Override
  public int getWidgetIndex(IsWidget child) {
    return getWidgetIndex(child.asWidget());
  }

}