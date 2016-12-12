package org.assertj.core.api;

/**
 * Assertions for {@link FailableAction}.
 *
 * @author Asher James
 * @since 3.6.2
 */
public class FailableActionAssert extends AbstractFailableActionAssert<FailableActionAssert> {

  protected FailableActionAssert(FailableAction actual) {
    super(actual, FailableActionAssert.class);
  }
}
