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

package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.StreamResetException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HttpBodyStreamTest {

  private Vertx vertx;
  private HttpServer server;
  private volatile Handler<HttpServerRequest> requestHandler;
  private HttpClient.Factory clientFactory = new VertxHttpClientFactory();

  @Before
  public void before() throws Exception {
    vertx = Vertx.vertx();
    server = vertx.createHttpServer().requestHandler(req -> {
      Handler<HttpServerRequest> handler = requestHandler;
      if (handler != null) {
        handler.handle(req);
      } else {
        req.response().setStatusCode(404).end();
      }
    });
    server.listen(8080).toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @After
  public void after() throws Exception {
    vertx.close().toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @Test
  public void testStreamFlowControl() throws Exception {

    AtomicInteger bytesSent = new AtomicInteger();
    AtomicInteger data = new AtomicInteger('A');
    AtomicInteger bytesReceived = new AtomicInteger();

    requestHandler = req -> {
      req.pause();
      AtomicInteger last = new AtomicInteger();
      vertx.setPeriodic(100, id -> {
        int val = bytesSent.get();
        if (data.get() != -1 && val - last.get() == 0) {
          req.resume();
          data.set(-1);
        }
        last.set(val);
      });
      req.handler(chunk -> {
        bytesReceived.addAndGet(chunk.length());
      });
      req.endHandler(v -> {
        req.response().end();
      });
    };
    HttpClient.Builder builder = clientFactory.newBuilder();
    HttpClient client = builder.build();

    HttpRequest request = client.newHttpRequestBuilder().uri("http://localhost:8080").post("text/plain", new InputStream() {
      @Override
      public int read() throws IOException {
        int ret = data.get();
        if (ret != -1) {
          bytesSent.incrementAndGet();
        }
        return ret;
      }
    }, -1L).build();
    HttpResponse<String> resp = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    assertEquals(bytesSent.get(), bytesReceived.get());
  }

  @Test
  public void testStreamError() throws Exception {

    requestHandler = req -> {
    };
    HttpClient.Builder builder = clientFactory.newBuilder();
    HttpClient client = builder.build();

    HttpRequest request = client.newHttpRequestBuilder().uri("http://localhost:8080").post("text/plain", new InputStream() {
      int bytesSent = 0;

      @Override
      public int read() throws IOException {
        if (bytesSent++ < 10_000) {
          return 'A';
        } else {
          throw new IOException("Cannot read");
        }
      }
    }, -1L).build();
    try {
      client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
      fail();
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      assertEquals(StreamResetException.class, cause.getClass());
    }
  }
}
