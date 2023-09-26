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
package io.fabric8.mockwebserver.internal;

import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChunkedResponse implements ServerResponse {

  private static final int DEFAULT_MAX_CHUNK_SIZE = 204800;
  private final ResponseProvider<List<String>> bodyProvider;
  private final boolean repeatable;
  private final long responseDelay;
  private final TimeUnit responseDelayUnit;

  public ChunkedResponse(boolean repeatable, int statusCode, String... body) {
    this(repeatable, ResponseProviders.ofAll(statusCode, body));
  }

  public ChunkedResponse(boolean repeatable, ResponseProvider<List<String>> bodyProvider) {
    this(repeatable, 0, TimeUnit.MILLISECONDS, bodyProvider);
  }

  public ChunkedResponse(boolean repeatable, int statusCode, long responseDelay, TimeUnit responseDelayUnit, String... body) {
    this(repeatable, responseDelay, responseDelayUnit, ResponseProviders.ofAll(statusCode, body));
  }

  public ChunkedResponse(boolean repeatable, long responseDelay, TimeUnit responseDelayUnit,
      ResponseProvider<List<String>> bodyProvider) {
    this.bodyProvider = bodyProvider;
    this.repeatable = repeatable;
    this.responseDelay = responseDelay;
    this.responseDelayUnit = responseDelayUnit;
  }

  public ResponseProvider<List<String>> getBodyProvider() {
    return bodyProvider;
  }

  @Override
  public MockResponse toMockResponse(RecordedRequest request) {
    MockResponse mockResponse = new MockResponse();
    mockResponse.setHeaders(bodyProvider.getHeaders());
    mockResponse.setChunkedBody(concatBody(request), DEFAULT_MAX_CHUNK_SIZE);
    mockResponse.setResponseCode(bodyProvider.getStatusCode(request));

    if (responseDelay > 0) {
      mockResponse.setBodyDelay(responseDelay, responseDelayUnit);
    }

    return mockResponse;
  }

  private String concatBody(RecordedRequest request) {
    StringBuilder sb = new StringBuilder();
    for (String s : bodyProvider.getBody(request)) {
      sb.append(s);
    }
    return sb.toString();
  }

  @Override
  public boolean isRepeatable() {
    return repeatable;
  }
}
