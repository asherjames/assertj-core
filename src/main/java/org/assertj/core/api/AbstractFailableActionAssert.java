package org.assertj.core.api;

import static org.assertj.core.error.ShouldNotThrowException.shouldNotThrowAnException;

public abstract class AbstractFailableActionAssert<SELF extends AbstractFailableActionAssert<SELF>> extends
  AbstractAssert<SELF, FailableAction> {

  protected AbstractFailableActionAssert(FailableAction actual, Class<?> selfType) {
    super(actual, selfType);
  }

  public SELF completesWithoutExceptions() {
    isNotNull();
    try {
      actual.invoke();
    } catch (Exception e) {
      throwAssertionError(shouldNotThrowAnException(actual));
    }
  }
}
