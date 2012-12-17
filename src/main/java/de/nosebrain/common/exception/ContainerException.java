package de.nosebrain.common.exception;

import java.util.List;

public class ContainerException extends Exception {
  private static final long serialVersionUID = 4171712420574209098L;

  private final List<? extends Throwable> causes;

  public ContainerException(final List<? extends Throwable> causes) {
    this(null, causes);
  }

  public ContainerException(final String message,
      final List<? extends Throwable> causes) {
    super(message);
    this.causes = causes;
  }

  /**
   * @return the causes
   */
  public List<? extends Throwable> getCauses() {
    return this.causes;
  }
}
