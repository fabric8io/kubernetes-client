package io.fabric8.kubernetes.client.dsl;

import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  NamespaceAwareResourceList<BuildConfig, BuildConfigList, BuildConfigBuilder> buildConfigs();

  NamespaceAwareResourceList<DeploymentConfig, DeploymentConfigList, DeploymentConfigBuilder> deploymentConfigs();

  NamespaceAwareResourceList<ImageStream, ImageStreamList, ImageStreamBuilder> imageStreams();

  NonNamespacedResourceList<OAuthAccessToken, OAuthAccessTokenList, OAuthAccessTokenBuilder> oAuthAccessTokens();

  NonNamespacedResourceList<OAuthAuthorizeToken, OAuthAuthorizeTokenList, OAuthAuthorizeTokenBuilder> oAuthAuthorizeTokens();

  NonNamespacedResourceList<OAuthClient, OAuthClientList, OAuthClientBuilder> oAuthClients();

  NamespaceAwareResourceList<Route, RouteList, RouteBuilder> routes();

}
