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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.Image;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.client.handlers.build.BuildConfigHandler;
import io.fabric8.openshift.client.handlers.build.BuildHandler;
import io.fabric8.openshift.client.handlers.apps.DeploymentConfigHandler;
import io.fabric8.openshift.client.handlers.ProjectRequestHandler;
import io.fabric8.openshift.client.handlers.image.ImageHandler;
import io.fabric8.openshift.client.handlers.image.ImageStreamHandler;
import io.fabric8.openshift.client.handlers.image.ImageStreamTagHandler;
import io.fabric8.openshift.client.handlers.network.NetNamespaceHandler;
import io.fabric8.openshift.client.handlers.oauth.OAuthAccessTokenHandler;
import io.fabric8.openshift.client.handlers.oauth.OAuthAuthorizeTokenHandler;
import io.fabric8.openshift.client.handlers.oauth.OAuthClientHandler;
import io.fabric8.openshift.client.handlers.project.ProjectHandler;
import io.fabric8.openshift.client.handlers.route.RouteHandler;
import io.fabric8.openshift.client.handlers.security.SecurityContextConstraintsHandler;
import io.fabric8.openshift.client.handlers.user.GroupHandler;
import io.fabric8.openshift.client.handlers.user.IdentityHandler;
import io.fabric8.openshift.client.handlers.user.UserHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class HandlersTest {

  @Test
  void checkHandlers() {
    checkHandler(new BuildConfig(), new BuildConfigHandler());
    checkHandler(new Build(), new BuildHandler());
    checkHandler(new DeploymentConfig(), new DeploymentConfigHandler());
    checkHandler(new Group(), new GroupHandler());
    checkHandler(new Identity(), new IdentityHandler());
    checkHandler(new Image(), new ImageHandler());
    checkHandler(new ImageStream(), new ImageStreamHandler());
    checkHandler(new ImageStreamTag(), new ImageStreamTagHandler());
    checkHandler(new NetNamespace(), new NetNamespaceHandler());
    checkHandler(new OAuthAccessToken(), new OAuthAccessTokenHandler());
    checkHandler(new OAuthAuthorizeToken(), new OAuthAuthorizeTokenHandler());
    checkHandler(new OAuthClient(), new OAuthClientHandler());
    checkHandler(new Project(), new ProjectHandler());
    checkHandler(new ProjectRequest(), new ProjectRequestHandler());
    checkHandler(new Route(), new RouteHandler());
    checkHandler(new SecurityContextConstraints(), new SecurityContextConstraintsHandler());
    checkHandler(new User(), new UserHandler());
  }

  private void checkHandler(HasMetadata hasMetadata, ResourceHandler handler) {
    Assertions.assertEquals(hasMetadata.getKind().toLowerCase(Locale.ROOT), handler.getKind().toLowerCase(Locale.ROOT));
    Assertions.assertEquals(hasMetadata.getApiVersion().toLowerCase(Locale.ROOT), handler.getApiVersion().toLowerCase(Locale.ROOT));
  }
}
