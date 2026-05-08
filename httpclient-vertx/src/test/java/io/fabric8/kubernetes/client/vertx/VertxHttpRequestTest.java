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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClosedException;
import io.vertx.core.http.RequestOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("VertxHttpRequest")
class VertxHttpRequestTest {

  @Mock
  private HttpClient httpClient;

  @Mock
  private Vertx vertx;

  private VertxHttpRequest vertxHttpRequest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    StandardHttpRequest request = (StandardHttpRequest) new StandardHttpRequest.Builder()
        .uri("http://localhost/test")
        .build();
    vertxHttpRequest = new VertxHttpRequest(vertx, new RequestOptions(), request);
  }

  @Test
  @DisplayName("HttpClosedException should be wrapped as IOException")
  void httpClosedExceptionIsWrappedAsIOException() {
    when(httpClient.request(any(RequestOptions.class)))
        .thenReturn(Future.failedFuture(new HttpClosedException("connection closed")));

    assertThatThrownBy(() -> vertxHttpRequest.consumeBytes(httpClient, (b, ab) -> {
    }).get(5, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .cause()
        .isInstanceOf(IOException.class)
        .hasCauseInstanceOf(HttpClosedException.class)
        .hasMessage("connection closed");
  }

}