package io.fabric8.kubernetes.client.utils;

import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_ID_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_SECRET_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_PARAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.File;
import java.net.HttpURLConnection;
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
