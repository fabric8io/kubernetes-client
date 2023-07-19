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

import lombok.Getter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStandardHttpClientFactory implements HttpClient.Factory {

  @Getter
  private final ConcurrentLinkedQueue<TestStandardHttpClient> instances = new ConcurrentLinkedQueue<>();

  @Override
  public TestStandardHttpClientBuilder newBuilder() {
    return new TestStandardHttpClientBuilder(this, instances);
  }

  public final TestStandardHttpClient getInstance(int index) {
    return instances.toArray(new TestStandardHttpClient[0])[index];
  }

  public final Stream<TestStandardHttpClientFactory> times(int iterations) {
    return IntStream.range(0, iterations).mapToObj(i -> this);
  }

  public final void expect(String pathRegex, int statusCode) {
    instances.forEach(c -> c.expect(pathRegex, statusCode));
  }

  public final void expect(String pathRegex, int statusCode, String body) {
    instances.forEach(c -> c.expect(pathRegex, statusCode, body));
  }

  public final void expect(String pathRegex, int statusCode, byte[] body) {
    instances.forEach(c -> c.expect(pathRegex, statusCode, body));
  }

}
