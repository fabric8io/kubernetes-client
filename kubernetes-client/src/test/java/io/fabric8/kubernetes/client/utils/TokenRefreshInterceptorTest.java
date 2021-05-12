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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_KUBECONFIG_FILE;

public class TokenRefreshInterceptorTest {

  @Test
  public void shouldAutoconfigureAfter401() throws IOException {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/test-kubeconfig-tokeninterceptor")), Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      // Prepare http call
      Interceptor.Chain chain = Mockito.mock(Interceptor.Chain.class, Mockito.RETURNS_DEEP_STUBS);
      Request req = new Request.Builder().url("http://mock").build();
      Mockito.when(chain.request()).thenReturn(req);
      final Response.Builder responseBuilder = new Response.Builder()
        .request(req)
        .protocol(Protocol.HTTP_1_1)
        .message("")
        .body(ResponseBody.create(MediaType.parse("text"), "foo"));
      Mockito.when(chain.proceed(Mockito.any())).thenReturn(responseBuilder.code(HttpURLConnection.HTTP_UNAUTHORIZED).build(), responseBuilder.code(HttpURLConnection.HTTP_OK).build());

      // Call
      new TokenRefreshInterceptor(Config.autoConfigure(null)).intercept(chain);
      Mockito.verify(chain).proceed(Mockito.argThat(argument -> "Bearer token".equals(argument.header("Authorization"))));
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
  }
}
