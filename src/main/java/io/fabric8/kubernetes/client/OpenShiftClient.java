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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.dsl.BuildConfigResource;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Operation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.*;

public interface OpenShiftClient extends KubernetesClient {

  Operation<Build, BuildList, DoneableBuild, Resource<Build, DoneableBuild>> builds();

  Operation<BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigResource<BuildConfig, DoneableBuildConfig>> buildConfigs();

  Operation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, Resource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs();

  Operation<ImageStream, ImageStreamList, DoneableImageStream, Resource<ImageStream, DoneableImageStream>> imageStreams();

  NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, Resource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens();

  NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens();

  NonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, Resource<OAuthClient, DoneableOAuthClient>> oAuthClients();

  Operation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();

}
