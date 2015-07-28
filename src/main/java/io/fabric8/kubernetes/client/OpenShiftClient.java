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

  Operation<Build, Build, BuildList, DoneableBuild, Void, Boolean, Resource<Build, DoneableBuild, Void, Boolean>> builds();

  Operation<BuildConfig, BuildConfig, BuildConfigList, DoneableBuildConfig, Void, Boolean, BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean>> buildConfigs();

  Operation<DeploymentConfig, DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, Void, Boolean, Resource<DeploymentConfig, DoneableDeploymentConfig, Void, Boolean>> deploymentConfigs();

  Operation<ImageStream, ImageStream, ImageStreamList, DoneableImageStream, Void, Boolean, Resource<ImageStream, DoneableImageStream, Void, Boolean>> imageStreams();

  NonNamespaceOperation<OAuthAccessToken, OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, Void, Boolean, Resource<OAuthAccessToken, DoneableOAuthAccessToken, Void, Boolean>> oAuthAccessTokens();

  NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, Void, Boolean, Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken, Void, Boolean>> oAuthAuthorizeTokens();

  NonNamespaceOperation<OAuthClient, OAuthClient, OAuthClientList, DoneableOAuthClient, Void, Boolean, Resource<OAuthClient, DoneableOAuthClient, Void, Boolean>> oAuthClients();

  Operation<Route, Route, RouteList, DoneableRoute, Void, Boolean, Resource<Route, DoneableRoute, Void, Boolean>> routes();

}
