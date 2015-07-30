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

import io.fabric8.kubernetes.client.KubernetesClientException;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.internal.LastControl;
import org.easymock.internal.MocksBehavior;
import org.easymock.internal.MocksControl;
import org.easymock.internal.RecordState;
import org.easymock.internal.UnorderedBehavior;
import org.easymock.internal.matchers.And;
import org.easymock.internal.matchers.Equals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MockUtils {


  public static IArgumentMatcher getArgument(Object argument) {
    if (argument == null) {
      List<IArgumentMatcher> matchers = LastControl.pullMatchers();
      if (matchers == null || matchers.isEmpty()) {
        return null;
      } else {
        //We need to put matchers back to the stack
        for (IArgumentMatcher m : matchers) {
          LastControl.reportMatcher(m);
        }
        return WrappedMatcher.wrap(matchers.get(0));
      }
    } else if (argument instanceof IArgumentMatcher) {
      return WrappedMatcher.wrap((IArgumentMatcher) argument);
    } else {
      return new WrappedMatcher(new Equals(argument));
    }
  }

  public static IArgumentMatcher getArgument(Object... args) {
    List<IArgumentMatcher> matchers = new ArrayList<>();
    for (Object o : args) {
      matchers.add(getArgument(o));
    }
    return new And(matchers);
  }

  public static MocksControl getControl(Object mock) {
    try {
      Method m = EasyMock.class.getDeclaredMethod("getControl", Object.class);
      m.setAccessible(true);
      return (MocksControl) m.invoke(null, mock);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private static MocksBehavior getBehavior(RecordState state) {
    try {
      Field f = RecordState.class.getDeclaredField("behavior");
      f.setAccessible(true); //if security settings allow this
      return  (MocksBehavior) f.get(state);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private static List<UnorderedBehavior> getBehaviorList(MocksBehavior behavior) {
    try {

      Field f = MocksBehavior.class.getDeclaredField("behaviorLists");
      f.setAccessible(true);
      return  (List<UnorderedBehavior>) f.get(behavior);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private List getBehaviorList(RecordState state) {
    try {
      Field f = RecordState.class.getDeclaredField("behavior");
      f.setAccessible(true); //if security settings allow this
      MocksBehavior behavior = (MocksBehavior) f.get(state);

      f = MocksBehavior.class.getDeclaredField("behaviorLists");
      f.setAccessible(true);
      List<UnorderedBehavior> list = (List<UnorderedBehavior>) f.get(behavior);
      return list;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
