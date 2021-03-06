package org.tessell.widgets.cellview;

import org.tessell.gwt.dom.client.GwtElement;
import org.tessell.gwt.dom.client.IsElement;
import org.tessell.gwt.dom.client.IsStyle;
import org.tessell.gwt.user.client.ui.IsWidget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.cellview.client.CellTable;

public class GwtCellTable<T> extends CellTable<T> implements IsCellTable<T> {

  public GwtCellTable() {
  }

  public GwtCellTable(int pageSize, Resources resources) {
    super(pageSize, resources);
  }

  @Override
  public IsElement getIsElement() {
    return new GwtElement(getElement());
  }

  @Override
  public IsWidget getIsParent() {
    return (IsWidget) getParent();
  }

  @Override
  public IsStyle getStyle() {
    return getIsElement().getStyle();
  }

  @Override
  public void addColumn(IsColumn<T, ?> col) {
    addColumn(col.asColumn());
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, IsHeader<?> header) {
    addColumn(col.asColumn(), header.asHeader());
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, IsHeader<?> header, IsHeader<?> footer) {
    addColumn(col.asColumn(), header.asHeader(), footer.asHeader());
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, String headerString) {
    addColumn(col.asColumn(), headerString);
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, SafeHtml headerHtml) {
    addColumn(col.asColumn(), headerHtml);
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, String headerString, String footerString) {
    addColumn(col.asColumn(), headerString, footerString);
  }

  @Override
  public void addColumn(IsColumn<T, ?> col, SafeHtml headerHtml, SafeHtml footerHtml) {
    addColumn(col.asColumn(), headerHtml, footerHtml);
  }

  @Override
  public void removeColumn(IsColumn<T, ?> col) {
    removeColumn(col.asColumn());
  }

  @Override
  @SuppressWarnings("unchecked")
  public IsColumn<T, ?> getIsColumn(int col) {
    return (IsColumn<T, ?>) getColumn(col);
  }

  @Override
  public int getColumnIndex(IsColumn<T, ?> column) {
    return getColumnIndex(column.asColumn());
  }

  @Override
  public void setColumnWidth(IsColumn<T, ?> col, String width) {
    setColumnWidth(col.asColumn(), width);
  }

  @Override
  public void setColumnWidth(IsColumn<T, ?> col, double width, Unit unit) {
    setColumnWidth(col.asColumn(), width, unit);
  }

}
