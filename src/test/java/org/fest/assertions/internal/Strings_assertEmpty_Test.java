/*
 * Created on Dec 26, 2010
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

import static org.fest.assertions.error.IsNotEmpty.isNotEmpty;
import static org.fest.assertions.test.ExpectedException.none;
import static org.fest.assertions.test.FailureMessages.unexpectedNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.test.ExpectedException;
import org.junit.*;

/**
 * Tests for <code>{@link Strings#assertEmpty(AssertionInfo, String)}</code>.
 *
 * @author Alex Ruiz
 */
public class Strings_assertEmpty_Test {

  @Rule public ExpectedException thrown = none();

  private Failures failures;
  private Strings strings;

  @Before public void setUp() {
    failures = spy(Failures.instance());
    strings = new Strings(failures);
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(unexpectedNull());
    strings.assertEmpty(someInfo(), null);
  }

  @Test public void should_fail_if_actual_is_not_empty() {
    AssertionInfo info = someInfo();
    try {
      strings.assertEmpty(info, "Yoda");
      fail();
    } catch (AssertionError e) {}
    verify(failures).failure(info, isNotEmpty("Yoda"));
  }

  @Test public void should_pass_if_actual_is_empty() {
    strings.assertEmpty(someInfo(), "");
  }
}
