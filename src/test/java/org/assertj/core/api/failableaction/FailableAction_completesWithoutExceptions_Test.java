package org.assertj.core.api.failableaction;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.FailableAction;
import org.junit.Test;

public class FailableAction_completesWithoutExceptions_Test {

  @Test
  public void action_with_no_exception_passes() {
    FailableAction action = () -> {};

    assertThat(action).completesWithoutExceptions();
  }

  @Test
  public void action_with_exception_fails() {
    FailableAction action = () -> {
      throw new RuntimeException("whoops");
    };

    try {
      assertThat(action).completesWithoutExceptions();
    } catch (AssertionError e) {
      return;
    }
  }
}
