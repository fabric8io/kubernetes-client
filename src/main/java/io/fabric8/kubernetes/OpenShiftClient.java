package io.fabric8.kubernetes;

import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  NamespaceAwareResourceList<BuildConfig, BuildConfigList, BuildConfigBuilder> buildConfigs();

  NamespaceAwareResourceList<DeploymentConfig, DeploymentConfigList, DeploymentConfigBuilder> deploymentConfigs();

  NamespaceAwareResourceList<ImageStream, ImageStreamList, ImageStreamBuilder> imageStreams();

  ResourceList<OAuthAccessToken, OAuthAccessTokenList, OAuthAccessTokenBuilder> oAuthAccessTokens();

  ResourceList<OAuthAuthorizeToken, OAuthAuthorizeTokenList, OAuthAuthorizeTokenBuilder> oAuthAuthorizeTokens();

  ResourceList<OAuthClient, OAuthClientList, OAuthClientBuilder> oAuthClients();

  NamespaceAwareResourceList<Route, RouteList, RouteBuilder> routes();

}
