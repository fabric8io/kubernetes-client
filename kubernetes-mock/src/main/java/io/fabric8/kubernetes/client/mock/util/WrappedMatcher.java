/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.mock.util;

import org.easymock.IArgumentMatcher;
import org.easymock.internal.matchers.Equals;

import java.lang.reflect.Field;

public class WrappedMatcher implements IArgumentMatcher {

  private final IArgumentMatcher delegate;

  public WrappedMatcher(IArgumentMatcher delegate) {
    this.delegate = delegate;
  }

  @Override
  public boolean matches(Object argument) {
    return delegate.matches(argument);
  }

  @Override
  public void appendTo(StringBuffer buffer) {
    delegate.appendTo(buffer);
  }

  public static IArgumentMatcher wrap(IArgumentMatcher matcher) {
    try {
      matcher.hashCode();
      return matcher;
    } catch (UnsupportedOperationException e) {
      return new WrappedMatcher(matcher);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WrappedMatcher that = (WrappedMatcher) o;

    if (delegate != null ? !delegate.equals(that.delegate) : that.delegate != null) return false;

    return true;
  }

  private static Object expectedObjectFromEquals(Equals equals) {
    try {
      Field f = Equals.class.getDeclaredField("expected");
      f.setAccessible(true);
      return f.get(equals);
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
  }

  @Override
  public int hashCode() {
    if (delegate == null) {
      return 0;
    } else if (delegate instanceof Equals) {
      return 32 + expectedObjectFromEquals((Equals) delegate).hashCode();
    } else {
     return delegate.hashCode();
    }
  }
}
