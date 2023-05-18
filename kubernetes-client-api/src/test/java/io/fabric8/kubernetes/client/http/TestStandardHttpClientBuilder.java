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
package io.fabric8.kubernetes.client.http;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestStandardHttpClientBuilder
    extends StandardHttpClientBuilder<TestStandardHttpClient, TestStandardHttpClientFactory, TestStandardHttpClientBuilder> {

  private final ConcurrentLinkedQueue<TestStandardHttpClient> instances;

  protected TestStandardHttpClientBuilder(TestStandardHttpClientFactory clientFactory,
      ConcurrentLinkedQueue<TestStandardHttpClient> instances) {
    super(clientFactory);
    this.instances = instances;
  }

  @Override
  public TestStandardHttpClient build() {
    final TestStandardHttpClient instance = new TestStandardHttpClient(this);
    instances.add(instance);
    return instance;
  }

  @Override
  protected TestStandardHttpClientBuilder newInstance(TestStandardHttpClientFactory clientFactory) {
    return new TestStandardHttpClientBuilder(clientFactory, instances);
  }

  @Override
  public TestStandardHttpClientBuilder tag(Object value) {
    return (TestStandardHttpClientBuilder) super.tag(value);
  }

}
