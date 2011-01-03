/*
 * Created on Dec 20, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.error.IsEmpty.isEmpty;
import static org.fest.assertions.test.DoubleArrayFactory.*;
import static org.fest.assertions.test.ExpectedException.none;
import static org.fest.assertions.test.FailureMessages.unexpectedNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.test.ExpectedException;
import org.junit.*;

/**
 * Tests for <code>{@link DoubleArrays#assertNotEmpty(AssertionInfo, double[])}</code>.
 *
 * @author Alex Ruiz
 */
public class DoubleArrays_assertNotEmpty_Test {

  @Rule public ExpectedException thrown = none();

  private Failures failures;
  private DoubleArrays arrays;

  @Before public void setUp() {
    failures = spy(Failures.instance());
    arrays = new DoubleArrays(failures);
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(unexpectedNull());
    arrays.assertNotEmpty(someInfo(), null);
  }

  @Test public void should_fail_if_actual_is_empty() {
    AssertionInfo info = someInfo();
    try {
      arrays.assertNotEmpty(info, emptyArray());
      fail();
    } catch (AssertionError e) {}
    verify(failures).failure(info, isEmpty());
  }

  @Test public void should_pass_if_actual_is_not_empty() {
    arrays.assertNotEmpty(someInfo(), array(8d));
  }
}
