/*
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

@Getter
public class TestStandardHttpClientFactory implements HttpClient.Factory {

  public enum Mode {
    /**
     * A new instance of the HttpClient is created for each build.
     */
    MULTIPLE,
    /**
     * The factory and builder share a single instance of the HttpClient whenever it's built.
     * Useful for mocking or setting expectations before a client is built using the factory's builder.
     */
    SINGLETON
  }

  private final Mode mode;
  private final ConcurrentLinkedQueue<TestStandardHttpClient> instances;

  public TestStandardHttpClientFactory() {
    this(Mode.MULTIPLE);
  }

  public TestStandardHttpClientFactory(Mode mode) {
    this.mode = mode == null ? Mode.MULTIPLE : mode;
    instances = new ConcurrentLinkedQueue<>();
    if (mode == Mode.SINGLETON) {
      // Create the singleton instance (will be automatically added to the instances queue)
      newBuilder().build();
    }
  }

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
