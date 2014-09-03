package net.selenate.common.comms.req;

import java.util.List;
import net.selenate.common.SelenateUtils;
import net.selenate.common.comms.SeElementSelectMethod;
import net.selenate.common.comms.SeFrameElementSelector;

public class SeReqCaptureElement implements SeCommsReq {

  private static final long serialVersionUID = 1L;

  public final String                windowHandle;
  public final List<Integer>         framePath;
  public final SeElementSelectMethod method;
  public final String                query;

  public SeReqCaptureElement(
      final String                windowHandle,
      final List<Integer>         framePath,
      final SeElementSelectMethod method,
      final String                query) {
    if (windowHandle == null) {
      throw new IllegalArgumentException("Window handle cannot be null!");
    }
    if (method == null) {
      throw new IllegalArgumentException("Method cannot be null!");
    }
    if (query == null) {
      throw new IllegalArgumentException("Query cannot be null!");
    }

    this.windowHandle = windowHandle;
    this.framePath    = framePath;
    this.method       = method;
    this.query        = query;
  }

  public SeReqCaptureElement(final SeFrameElementSelector selector) {
    if (selector == null) {
      throw new IllegalArgumentException("Selector cannot be null!");
    }

    this.windowHandle = selector.windowHandle;
    this.framePath    = selector.framePath;
    this.method       = selector.method;
    this.query        = selector.query;
  }

  @Override
  public String toString() {
    return String.format("SeReqCaptureElement(%s, %s, %s, %s)",
        windowHandle, SelenateUtils.listToString(framePath), method, query);
  }

}
