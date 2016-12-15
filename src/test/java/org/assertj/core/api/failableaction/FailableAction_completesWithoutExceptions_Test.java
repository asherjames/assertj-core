package org.assertj.core.api.failableaction;

import static org.assertj.core.api.Assertions.assertThatAction;

import org.assertj.core.api.FailableAction;
import org.junit.Test;

public class FailableAction_completesWithoutExceptions_Test {

  @Test
  public void action_with_no_exception_passes() {
    FailableAction action = () -> {};

    assertThatAction(action).completesWithoutExceptions();
  }

  @Test
  public void action_with_exception_fails() {
    FailableAction action = () -> {
      throw new RuntimeException("whoops");
    };

    try {
      assertThatAction(action).completesWithoutExceptions();
    } catch (AssertionError e) {
      return;
    }
  }

  @Test
  public void lambda_in_assert_method_still_works() {
    try {
      assertThatAction(() -> {
        throw new Exception("boom");
      }).completesWithoutExceptions();
    } catch (AssertionError e) {
      return;
    }
  }
}
