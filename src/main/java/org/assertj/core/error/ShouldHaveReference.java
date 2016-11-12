/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.error;

public class ShouldHaveReference extends BasicErrorMessageFactory {

  private static final String SHOULD_HAVE_REFERENCE = "%nExpecting%n  <%s>%nto have reference:%n  <%s>%nbut had:%n  <%s>";

  private <REF> ShouldHaveReference(Object  actual, REF actualReference, REF expectedReference) {
    super(SHOULD_HAVE_REFERENCE, actual, expectedReference, actualReference);
  }

  public static <REF> ErrorMessageFactory shouldHaveReference(Object  actual, REF actualReference, REF expectedReference) {
    return new ShouldHaveReference(actual, actualReference, expectedReference);
  }
}
