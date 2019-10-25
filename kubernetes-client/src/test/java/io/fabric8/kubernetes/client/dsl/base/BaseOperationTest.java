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
package io.fabric8.kubernetes.client.dsl.base;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationsImpl;

public class BaseOperationTest {

  @Test
  public void testSimpleFieldQueryParamConcatenation() {
    Map<String, String> fieldsMap = new HashMap<>();
    fieldsMap.put("yesKey1", "yesValue1");
    fieldsMap.put("yesKey2", "yesValue2");

    final PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext());
    operation
      .withFields(fieldsMap)
      .withField("yesKey2", "overrideValue2")
      .withoutField("noKey1", "noValue1")
      .withoutField("noKey2", "noValue2");

    final String fieldQueryParam = operation.getFieldQueryParam();
    // Use contains to not be depending on map key/value pair ordering
    assertThat(fieldQueryParam, containsString("yesKey1=yesValue1"));
    assertThat(fieldQueryParam, containsString("yesKey2=overrideValue2"));
    assertThat(fieldQueryParam, containsString("noKey1!=noValue1"));
    assertThat(fieldQueryParam, containsString("noKey2!=noValue2"));
  }

  @Test
  public void testSkippingFieldNotMatchingNullValues() {
    final PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext());
    operation
      .withField("key1", "value1")
      .withoutField("key2", "value2")
      .withoutField("key2", null)
      .withoutField("key2", "")
      .withoutField("key2", "value3")
      .withoutField("key10", "value11")
      .withoutField("key10", ""); // Once more to make sure no accidental trailing comma is added

    assertThat(operation.getFieldQueryParam(), is(equalTo("key1=value1,key2!=value2,key2!=value3,key10!=value11")));
  }

  @Test
  public void testDefaultGracePeriod() {
    final BaseOperation operation = new BaseOperation(new OperationContext());

    assertThat(operation.getGracePeriodSeconds(), is(30L));
  }

  @Test
  public void testChainingGracePeriodAndPropagationPolicy() {
    final BaseOperation operation = new BaseOperation(new OperationContext());
    FilterWatchListDeletable<?, ?, Boolean, Watch, Watcher<?>> operationWithGracePeriod = operation.withGracePeriod(10L);
    FilterWatchListDeletable<?, ?, Boolean, Watch, Watcher<?>> operationWithPropagationPolicy = operation.withPropagationPolicy("Foreground");

    Object chainedGracePeriod = operationWithPropagationPolicy.withGracePeriod(10);
    Object chainedPropagationPolicy = operationWithGracePeriod.withPropagationPolicy("Foreground");

    assertThat(chainedGracePeriod, is(notNullValue()));
    assertThat(chainedPropagationPolicy, is(notNullValue()));
  }
}
