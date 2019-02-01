package io.fabric8.kubernetes.client;

public interface OAuthTokenProvider {

  /**
   * Returns a Bearer token used for authorization between a client
   * and a kubernetes cluster. The token will be injected into an Authorization header.
   *
   * @return oauth token
   */
  String getToken();

}
