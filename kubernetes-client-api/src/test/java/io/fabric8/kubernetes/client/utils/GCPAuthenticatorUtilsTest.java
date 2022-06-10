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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GCPAuthenticatorUtilsTest {

  @Test
  void testRefreshToken() throws Exception {
    // Given
    String fakeToken = "new-fake-token";
    String fakeTokenExpiry = "2121-08-05T02:30:24Z";
    Map<String, String> currentAuthProviderConfig = new HashMap<>();
    File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
    Files.copy(getClass().getResourceAsStream("/test-kubeconfig-gcp"), Paths.get(tempFile.getPath()),
      StandardCopyOption.REPLACE_EXISTING);
    System.setProperty("kubeconfig", tempFile.getAbsolutePath());

    GoogleCredentials mockGC = Mockito.mock(GoogleCredentials.class);
    GCPAuthenticatorUtils.setCredentials(mockGC);
    Mockito.when(mockGC.getAccessToken())
      .thenReturn(new AccessToken(fakeToken, Date.from(Instant.parse(fakeTokenExpiry))));

    // When
    String token = GCPAuthenticatorUtils.resolveTokenFromAuthConfig(currentAuthProviderConfig).get();

    // Then
    assertNotNull(token);
    assertEquals(fakeToken, token);
  }
}
