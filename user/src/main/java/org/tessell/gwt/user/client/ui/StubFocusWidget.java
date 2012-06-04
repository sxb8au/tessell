package org.tessell.gwt.user.client.ui;

import org.tessell.gwt.dom.client.StubBlurEvent;
import org.tessell.gwt.dom.client.StubClickEvent;
import org.tessell.gwt.dom.client.StubFocusEvent;
import org.tessell.gwt.dom.client.StubKeyDownEvent;
import org.tessell.gwt.dom.client.StubKeyPressEvent;
import org.tessell.gwt.dom.client.StubKeyUpEvent;
import org.tessell.gwt.dom.client.StubMouseOutEvent;
import org.tessell.gwt.dom.client.StubMouseOverEvent;
import org.tessell.widgets.StubWidget;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public class StubFocusWidget extends StubWidget implements IsFocusWidget {

  private static StubFocusWidget lastFocus;
  private boolean enabled = true;
  private boolean focus;
  private int tabIndex;
  private char accessKey;

  public void click() {
    // is only-click if enabled true for all FocusWidgets?
    if (!enabled) {
      throw new IllegalStateException(this + " is disabled");
    }
    fireEvent(new StubClickEvent());
  }

  /** @return only a vague heuristic of whether we're focused */
  public boolean isFocused() {
    return focus;
  }

  @Override
  public void setFocus(final boolean focused) {
    if (focused) {
      if (lastFocus != null) {
        lastFocus.setFocus(false);
      }
      focus = true;
      fireEvent(new StubFocusEvent());
      lastFocus = this;
    } else {
      focus = false;
      blur();
    }
  }

  public void focus() {
    fireEvent(new StubFocusEvent());
  }

  public void blur() {
    fireEvent(new StubBlurEvent());
  }

  public void mouseOver() {
    fireEvent(new StubMouseOverEvent());
  }

  public void mouseOut() {
    fireEvent(new StubMouseOutEvent());
  }

  public void keyUp() {
    fireEvent(new StubKeyUpEvent(0));
  }

  public void keyUp(int keyCode) {
    fireEvent(new StubKeyUpEvent(keyCode));
  }

  public void keyDown() {
    fireEvent(new StubKeyDownEvent(0));
  }

  public void keyDown(int keyCode) {
    fireEvent(new StubKeyDownEvent(keyCode));
  }

  public void keyPress() {
    fireEvent(new StubKeyPressEvent());
  }

  @Override
  public HandlerRegistration addClickHandler(final ClickHandler handler) {
    return handlers.addHandler(ClickEvent.getType(), handler);
  }

  @Override
  public int getTabIndex() {
    return tabIndex;
  }

  public char getAccessKey() {
    return accessKey;
  }

  @Override
  public void setAccessKey(final char key) {
    accessKey = key;
  }

  @Override
  public void setTabIndex(final int index) {
    tabIndex = index;
  }

  @Override
  public HandlerRegistration addFocusHandler(final FocusHandler handler) {
    return handlers.addHandler(FocusEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addBlurHandler(final BlurHandler handler) {
    return handlers.addHandler(BlurEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
    return handlers.addHandler(KeyUpEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addKeyDownHandler(final KeyDownHandler handler) {
    return handlers.addHandler(KeyDownEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addKeyPressHandler(final KeyPressHandler handler) {
    return handlers.addHandler(KeyPressEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseDownHandler(final MouseDownHandler handler) {
    return handlers.addHandler(MouseDownEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseUpHandler(final MouseUpHandler handler) {
    return handlers.addHandler(MouseUpEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
    return handlers.addHandler(MouseOutEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseOverHandler(final MouseOverHandler handler) {
    return handlers.addHandler(MouseOverEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseMoveHandler(final MouseMoveHandler handler) {
    return handlers.addHandler(MouseMoveEvent.getType(), handler);
  }

  @Override
  public HandlerRegistration addMouseWheelHandler(final MouseWheelHandler handler) {
    return handlers.addHandler(MouseWheelEvent.getType(), handler);
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

}