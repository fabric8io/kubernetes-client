package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableBuildConfig;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableDeploymentConfig;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableImageStream;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableOAuthAccessToken;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableOAuthAuthorizeToken;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableOAuthClient;
import io.fabric8.kubernetes.client.dsl.internal.updateables.UpdateableRoute;
import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  NamespaceAwareResourceList<BuildConfig, BuildConfigList, BuildConfigBuilder, UpdateableBuildConfig> buildConfigs();

  NamespaceAwareResourceList<DeploymentConfig, DeploymentConfigList, DeploymentConfigBuilder, UpdateableDeploymentConfig> deploymentConfigs();

  NamespaceAwareResourceList<ImageStream, ImageStreamList, ImageStreamBuilder, UpdateableImageStream> imageStreams();

  NonNamespacedResourceList<OAuthAccessToken, OAuthAccessTokenList, OAuthAccessTokenBuilder, UpdateableOAuthAccessToken> oAuthAccessTokens();

  NonNamespacedResourceList<OAuthAuthorizeToken, OAuthAuthorizeTokenList, OAuthAuthorizeTokenBuilder, UpdateableOAuthAuthorizeToken> oAuthAuthorizeTokens();

  NonNamespacedResourceList<OAuthClient, OAuthClientList, OAuthClientBuilder, UpdateableOAuthClient> oAuthClients();

  NamespaceAwareResourceList<Route, RouteList, RouteBuilder, UpdateableRoute> routes();

}
