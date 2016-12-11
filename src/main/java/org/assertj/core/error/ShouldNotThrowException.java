package org.assertj.core.error;

import org.assertj.core.api.FailableAction;

public class ShouldNotThrowException extends BasicErrorMessageFactory {

  private static final String SHOULD_NOT_THROW_EXCEPTION = "%nExpecting%n  <%s>%not to throw an exception";

  public static ErrorMessageFactory shouldNotThrowAnException(FailableAction actual) {
    return new ShouldNotThrowException(actual);
  }

  private ShouldNotThrowException(FailableAction actual) {
    super(SHOULD_NOT_THROW_EXCEPTION, actual);
  }
}
