package io.fabric8.kubernetes.client.dsl;

import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  NamespaceAwareResourceList<BuildConfig, BuildConfigList, BuildConfigBuilder, DoneableBuildConfig> buildConfigs();

  NamespaceAwareResourceList<DeploymentConfig, DeploymentConfigList, DeploymentConfigBuilder, DoneableDeploymentConfig> deploymentConfigs();

  NamespaceAwareResourceList<ImageStream, ImageStreamList, ImageStreamBuilder, DoneableImageStream> imageStreams();

  NonNamespacedResourceList<OAuthAccessToken, OAuthAccessTokenList, OAuthAccessTokenBuilder, DoneableOAuthAccessToken> oAuthAccessTokens();

  NonNamespacedResourceList<OAuthAuthorizeToken, OAuthAuthorizeTokenList, OAuthAuthorizeTokenBuilder, DoneableOAuthAuthorizeToken> oAuthAuthorizeTokens();

  NonNamespacedResourceList<OAuthClient, OAuthClientList, OAuthClientBuilder, DoneableOAuthClient> oAuthClients();

  NamespaceAwareResourceList<Route, RouteList, RouteBuilder, DoneableRoute> routes();

}
