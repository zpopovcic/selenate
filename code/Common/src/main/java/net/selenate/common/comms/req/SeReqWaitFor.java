package net.selenate.common.comms.req;

import java.util.ArrayList;
import java.util.List;

import net.selenate.common.comms.*;

public class SeReqWaitFor extends SeCommsReq {
  private static final long serialVersionUID = 1L;

  public final List<SePage> pageList;

  public SeReqWaitFor(final List<SePage> pageList) {
    if (pageList == null) {
      throw new IllegalArgumentException("Page list cannot be null!");
    }
    if (pageList.isEmpty()) {
      throw new IllegalArgumentException("Page list cannot be empty!");
    }

    this.pageList = pageList;
  }

  public SeReqWaitFor(final SePage page) {
    if (page == null) {
      throw new IllegalArgumentException("Page cannot be null!");
    }

    this.pageList = new ArrayList<SePage>();
    this.pageList.add(page);
  }
}
