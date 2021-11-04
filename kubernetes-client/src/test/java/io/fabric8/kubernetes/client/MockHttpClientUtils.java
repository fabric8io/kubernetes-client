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

import io.fabric8.kubernetes.client.http.HttpResponse;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;

public class MockHttpClientUtils {
  
  public static HttpResponse<InputStream> buildResponse(int code, String body) {
    HttpResponse<InputStream> response = Mockito.mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    when(response.code()).thenReturn(code);
    when(response.body()).thenReturn(new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)));
    return response;
  }
  
  public static HttpResponse<InputStream> buildResponse(int code) {
    return buildResponse(code, "{\"kind\":\"Status\",\"status\":\"Success\"}");
  }
}
