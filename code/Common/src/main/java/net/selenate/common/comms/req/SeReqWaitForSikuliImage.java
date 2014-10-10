package net.selenate.common.comms.req;

public class SeReqWaitForSikuliImage implements SeCommsReq {
  private static final long serialVersionUID = 1L;

  public final byte[] image;
  public final int    timeoutMillis;

  public SeReqWaitForSikuliImage(
      final byte[] image,
      final int    timeoutMillis) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null!");
    }

    if (timeoutMillis < 0) {
      throw new IllegalArgumentException("Timeout cannot be negative!");
    }

    this.image         = image;
    this.timeoutMillis = timeoutMillis;
  }

  @Override
  public String toString() {
    return String.format("SeReqWaitForSikuliImage(%d bytes, %d)", image.length, timeoutMillis);
  }
}
