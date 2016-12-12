package org.assertj.core.error;

import org.assertj.core.api.FailableAction;

public class ShouldNotThrowException extends BasicErrorMessageFactory {

  private static final String SHOULD_NOT_THROW_EXCEPTION = "%nExpecting%n  %nto not to throw an exception, but it threw <%s>";

  public static ErrorMessageFactory shouldNotThrowAnException(FailableAction actual, Exception exception) {
    return new ShouldNotThrowException(actual, exception);
  }

  private ShouldNotThrowException(FailableAction actual, Exception exception) {
    super(SHOULD_NOT_THROW_EXCEPTION, actual, exception.getMessage());
  }
}
