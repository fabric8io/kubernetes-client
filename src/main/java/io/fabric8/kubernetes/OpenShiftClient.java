package io.fabric8.kubernetes;

import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  Resource<BuildConfigList, BuildConfig, BuildConfigBuilder> buildConfigs();

  Resource<DeploymentConfigList, DeploymentConfig, DeploymentConfigBuilder> deploymentConfigs();

  Resource<ImageStreamList, ImageStream, ImageStreamBuilder> imageStreams();

  Resource<OAuthAccessTokenList, OAuthAccessToken, OAuthAccessTokenBuilder> oAuthAccessTokens();

  Resource<OAuthAuthorizeTokenList, OAuthAuthorizeToken, OAuthAuthorizeTokenBuilder> oAuthAuthorizeTokens();

  Resource<OAuthClientList, OAuthClient, OAuthClientBuilder> oAuthClients();

  Resource<RouteList, Route, RouteBuilder> routes();

}
