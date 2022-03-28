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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.HttpStatusMessage;
import org.mockito.Mockito;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;

public class MockHttpClientUtils {

  public static HttpResponse<byte[]> buildResponse(int code, String body) {
    HttpResponse<byte[]> response = Mockito.mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    when(response.code()).thenReturn(code);
    when(response.body()).thenReturn(body.getBytes(StandardCharsets.UTF_8));
    HttpRequest mockRequest = buildRequest();
    when(response.request()).thenReturn(mockRequest);
    return response;
  }

  public static HttpRequest buildRequest() {
    HttpRequest mockRequest = Mockito.mock(HttpRequest.class, Mockito.RETURNS_DEEP_STUBS);
    when(mockRequest.uri()).thenReturn(URI.create("http://mock:8443"));
    return mockRequest;
  }

  public static HttpResponse<byte[]> buildResponse(int code) {
    return buildResponse(code, "{\"kind\":\"Status\",\"status\":\"" + HttpStatusMessage.getMessageForStatus(code) + "\"}");
  }
}
