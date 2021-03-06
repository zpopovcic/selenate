package net.selenate.common.comms;

import net.selenate.common.exceptions.SeNullArgumentException;

public final class SeOption implements SeComms {
  private static final long serialVersionUID = 45749879L;

  private final SeElement element;

  public SeOption(final SeElement element) {
    this.element = element;
    validate();
  }

  public SeElement getElement() {
    return element;
  }

  public SeOption withElement(final SeElement newElement) {
    return new SeOption(newElement);
  }

  public void validate() {
    if (element == null) {
      throw new SeNullArgumentException("Element");
    }
  }

  @Override
  public String toString() {
    return String.format("SeOption(%s)", element);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((element == null) ? 0 : element.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SeOption other = (SeOption) obj;
    if (element == null) {
      if (other.element != null)
        return false;
    } else if (!element.equals(other.element))
      return false;
    return true;
  }
}
