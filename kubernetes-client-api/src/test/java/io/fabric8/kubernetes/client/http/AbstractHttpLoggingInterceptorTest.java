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

import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.net.URI;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.when;

public abstract class AbstractHttpLoggingInterceptorTest {

  private static DefaultMockServer server;
  private Logger logger;
  private InOrder inOrder;
  private HttpClient httpClient;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  @BeforeEach
  void setUp() {
    logger = mock(Logger.class);
    inOrder = Mockito.inOrder(logger);
    when(logger.isTraceEnabled()).thenReturn(true);
    httpClient = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("loggingInterceptor", new HttpLoggingInterceptor(logger))
        .build();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("HTTP request URI is logged")
  public void httpRequestUriLogged() throws Exception {
    server.expect().withPath("/request-uri")
        .andReturn(200, "This is the response body")
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .uri(server.url("/request-uri"))
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger)
        .trace(eq("> {} {}"), eq("GET"), argThat((URI uri) -> uri.toString().endsWith("/request-uri")));
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("HTTP request headers are logged")
  public void httpRequestHeadersLogged() throws Exception {
    server.expect().withPath("/request-headers")
        .andReturn(200, "This is the response body")
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .header("test-type", "header-test")
        .uri(server.url("/request-headers"))
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger).trace("> {}: {}", "test-type", "header-test");
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("HTTP request body is logged")
  public void httpRequestBodyLogged() throws Exception {
    server.expect().withPath("/request-body")
        .andReturn(200, "This is the response body")
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .uri(server.url("/request-body"))
        .method("POST", "test/plain", "This is the request body")
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger).trace("This is the request body");
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("HTTP response status is logged")
  public void httpResponseStatusLogged() throws Exception {
    server.expect().withPath("/response-status")
        .andReturn(200, "This is the response body")
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .uri(server.url("/response-status"))
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger).trace("< {} {}", 200, "OK");
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("HTTP response headers are logged")
  public void httpResponseHeadersLogged() throws Exception {
    server.expect().withPath("/response-headers")
        .andReply(ResponseProviders.of(204, "", Collections.singletonMap("test-type", "response-header-test")))
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .uri(server.url("/response-headers"))
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger).trace(eq("< {} {}"), anyInt(), anyString());
    inOrder.verify(logger).trace("< {}: {}", "test-type", "response-header-test");
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("HTTP response body is logged")
  public void httpResponseBodyLogged() throws Exception {
    server.expect().withPath("/response-body")
        .andReturn(200, "This is the response body")
        .always();
    httpClient.sendAsync(httpClient.newHttpRequestBuilder()
        .uri(server.url("/response-body"))
        .build(), String.class).get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-HTTP START-");
    inOrder.verify(logger).trace(eq("< {} {}"), anyInt(), anyString());
    inOrder.verify(logger).trace("This is the response body");
    inOrder.verify(logger).trace("-HTTP END-");
  }

  @Test
  @DisplayName("WS request URI is logged")
  public void wsRequestUriLogged() throws Exception {
    server.expect().withPath("/ws-request-uri")
        .andUpgradeToWebSocket()
        .open().done().always();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/ws-request-uri")))
        .buildAsync(new WebSocket.Listener() {
        })
        .get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-WS START-");
    inOrder.verify(logger)
        .trace(eq("> {} {}"), eq("GET"), argThat((URI uri) -> uri.toString().endsWith("/ws-request-uri")));
    inOrder.verify(logger).trace("-WS END-");
  }

  @Test
  @DisplayName("WS request headers are logged")
  public void wsRequestHeadersLogged() throws Exception {
    server.expect().withPath("/ws-request-headers")
        .andUpgradeToWebSocket()
        .open().done().always();
    httpClient.newWebSocketBuilder()
        .header("test-type", "ws-header-test")
        .uri(URI.create(server.url("/ws-request-headers")))
        .buildAsync(new WebSocket.Listener() {
        })
        .get(10, TimeUnit.SECONDS);
    verify(logger, timeout(1000L)).trace("-WS END-");
    inOrder.verify(logger).trace("-WS START-");
    inOrder.verify(logger).trace("> {}: {}", "test-type", "ws-header-test");
    inOrder.verify(logger).trace("-WS END-");
  }

  @Test
  @DisplayName("WS response status is logged")
  public void wsResponseStatusLogged() throws Exception {
    server.expect().withPath("/ws-response-status")
        .andUpgradeToWebSocket()
        .open().done().always();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/ws-response-status")))
        .buildAsync(new WebSocket.Listener() {
        })
        .get(10, TimeUnit.SECONDS);
    inOrder.verify(logger, timeout(1000L)).trace("-WS START-");
    inOrder.verify(logger).trace("< {} {}", 101, "Switching Protocols");
    inOrder.verify(logger).trace("-WS END-");
  }
}
