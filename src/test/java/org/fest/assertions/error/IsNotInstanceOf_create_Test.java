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
package org.fest.assertions.error;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.error.IsNotInstanceOf.isNotInstanceOf;

import java.io.File;

import org.fest.assertions.description.Description;
import org.fest.assertions.internal.TestDescription;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for <code>{@link IsNotInstanceOf#create(Description)}</code>.
 *
 * @author Alex Ruiz
 */
public class IsNotInstanceOf_create_Test {

  private ErrorMessage errorMessage;

  @Before public void setUp() {
    errorMessage = isNotInstanceOf("Yoda", File.class);
  }

  @Test public void should_create_error_message() {
    String message = errorMessage.create(new TestDescription("Test"));
    assertEquals("[Test] expected <'Yoda'> to be an instance of:<java.io.File> but was instance of:<java.lang.String>", message);
  }
}
