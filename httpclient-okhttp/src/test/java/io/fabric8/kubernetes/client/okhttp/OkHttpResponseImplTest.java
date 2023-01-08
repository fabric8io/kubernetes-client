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
package io.fabric8.kubernetes.client.okhttp;

import okhttp3.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class OkHttpResponseImplTest {

  @Test
  @DisplayName("constructor, with type=null, should close the response body")
  void nullTypeClosesResponseBody() throws IOException {
    // Given
    final Response response = mock(Response.class, RETURNS_DEEP_STUBS);
    // When
    new OkHttpClientImpl.OkHttpResponseImpl<>(response, null);
    // Then
    verify(response.body(), times(1)).close();
  }
}
