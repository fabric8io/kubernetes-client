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

import io.fabric8.kubernetes.api.model.v4_0.HasMetadata;
import io.fabric8.kubernetes.clnt.v4_0.ResourceHandler;
import io.fabric8.openshift.api.model.v4_0.Build;
import io.fabric8.openshift.api.model.v4_0.BuildConfig;
import io.fabric8.openshift.api.model.v4_0.DeploymentConfig;
import io.fabric8.openshift.api.model.v4_0.Group;
import io.fabric8.openshift.api.model.v4_0.ImageStream;
import io.fabric8.openshift.api.model.v4_0.ImageStreamTag;
import io.fabric8.openshift.api.model.v4_0.OAuthAccessToken;
import io.fabric8.openshift.api.model.v4_0.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.v4_0.OAuthClient;
import io.fabric8.openshift.api.model.v4_0.PolicyBinding;
import io.fabric8.openshift.api.model.v4_0.Project;
import io.fabric8.openshift.api.model.v4_0.RoleBinding;
import io.fabric8.openshift.api.model.v4_0.Route;
import io.fabric8.openshift.api.model.v4_0.SecurityContextConstraints;
import io.fabric8.openshift.api.model.v4_0.Template;
import io.fabric8.openshift.api.model.v4_0.User;
import io.fabric8.openshift.clnt.v4_0.handlers.BuildConfigHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.BuildHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.DeploymentConfigHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.GroupHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.ImageStreamHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.ImageStreamTagHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.OAuthAccessTokenHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.OAuthAuthorizeTokenHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.OAuthClientHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.PolicyBindingHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.ProjectHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.RoleBindingHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.RouteHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.SecurityContextConstraintsHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.TemplateHandler;
import io.fabric8.openshift.clnt.v4_0.handlers.UserHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Handlersv4Test {

  @Test
  public void checkHandlers() {
    checkHandler(new BuildConfig(), new BuildConfigHandler());
    checkHandler(new Build(), new BuildHandler());
    checkHandler(new DeploymentConfig(), new DeploymentConfigHandler());
    checkHandler(new Group(), new GroupHandler());
    checkHandler(new ImageStream(), new ImageStreamHandler());
    checkHandler(new ImageStreamTag(), new ImageStreamTagHandler());
    checkHandler(new OAuthAccessToken(), new OAuthAccessTokenHandler());
    checkHandler(new OAuthAuthorizeToken(), new OAuthAuthorizeTokenHandler());
    checkHandler(new OAuthClient(), new OAuthClientHandler());
    checkHandler(new PolicyBinding(), new PolicyBindingHandler());
    checkHandler(new Project(), new ProjectHandler());
    checkHandler(new RoleBinding(), new RoleBindingHandler());
    checkHandler(new Route(), new RouteHandler());
    checkHandler(new SecurityContextConstraints(), new SecurityContextConstraintsHandler());
    checkHandler(new Template(), new TemplateHandler());
    checkHandler(new User(), new UserHandler());
  }

  private void checkHandler(HasMetadata hasMetadata, ResourceHandler handler) {
    assertEquals(hasMetadata.getKind().toLowerCase(), handler.getKind().toLowerCase());
  }
}
