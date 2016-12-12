package org.assertj.core.api.failableaction;

import org.assertj.core.api.FailableActionAssert;
import org.assertj.core.api.FailableActionBaseTest;
import org.junit.Test;

public class FailableAction_completesWithoutExceptions_Test extends FailableActionBaseTest {

  @Test
  public void should_fail_when_action_is_null() {

  }

  @Override
  protected FailableActionAssert create_assertions() {
    return null;
  }

  @Override
  protected FailableActionAssert invoke_api_method() {
    return null;
  }

  @Override
  protected void verify_internal_effects() {

  }
}
