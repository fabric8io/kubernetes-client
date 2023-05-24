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
package io.fabric8.kubernetes.client.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackwardsCompatibilityInterceptor implements Interceptor {

  public static final String JSON = "application/json";

  public static final String NAME = "BACKWARDS";

  private static final int API_GROUP = 1;
  private static final int API_VERSION = 2;
  private static final int PATH = 3;

  private static final String PATCH = "patch";
  private static final String NAME_REGEX = "[a-z0-9\\-\\.]+";
  private static final Pattern URL_PATTERN = Pattern
      .compile("[^ ]+/apis/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")[^ ]*");
  private static final Pattern NAMESPACED_URL_PATTERN = Pattern
      .compile("[^ ]+/apis/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")/namespaces/" + NAME_REGEX + "/(" + NAME_REGEX + ")[^ ]*");
  private static final Map<ResourceKey, ResourceKey> notFoundTransformations = new HashMap<>();
  private static final Map<ResourceKey, ResourceKey> badRequestTransformations = new HashMap<>();
  private static final Map<String, ResourceKey> openshiftOAPITransformations = new HashMap<>();

  private static final Map<Integer, Map<ResourceKey, ResourceKey>> responseCodeToTransformations = new HashMap<>();

  private static class ResourceKey {
    private final String kind;
    private final String path;
    private final String group;
    private final String version;

    public ResourceKey(String kind, String path, String group, String version) {
      this.kind = kind;
      this.path = path;
      this.group = group;
      this.version = version;
    }

    public String getKind() {
      return kind;
    }

    public String getPath() {
      return path;
    }

    public String getGroup() {
      return group;
    }

    public String getVersion() {
      return version;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      ResourceKey key = (ResourceKey) o;
      return Objects.equals(path, key.path) &&
          Objects.equals(group, key.group) &&
          Objects.equals(version, key.version);
    }

    @Override
    public int hashCode() {

      return Objects.hash(path, group, version);
    }
  }

  static {
    notFoundTransformations.put(new ResourceKey("Deployment", "deployments", "apps", "v1"),
        new ResourceKey("Deployment", "deployments", "extensions", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("StatefulSet", "statefulsets", "apps", "v1"),
        new ResourceKey("StatefulSet", "statefulsets", "apps", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("DaemonSets", "daemonsets", "apps", "v1"),
        new ResourceKey("DaemonSet", "daemonsets", "extensions", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("ReplicaSets", "replicasets", "apps", "v1"),
        new ResourceKey("ReplicaSet", "replicasets", "extensions", "v1beta1"));
    notFoundTransformations
        .put(new ResourceKey("NetworkPolicy", "networkpolicies", "networking.k8s.io", "v1"),
            new ResourceKey("NetworkPolicy", "networkpolicies", "extensions", "v1beta1"));
    notFoundTransformations
        .put(new ResourceKey("StorageClass", "storageclasses", "storage.k8s.io", "v1"),
            new ResourceKey("StorageClass", "storageclasses", "extensions", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("RoleBinding", "rolebindings", "rbac.authorization.k8s.io", "v1"),
        new ResourceKey("RoleBinding", "rolebindings", "rbac.authorization.k8s.io", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("Role", "roles", "rbac.authorization.k8s.io", "v1"),
        new ResourceKey("Role", "roles", "rbac.authorization.k8s.io", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("ClusterRoleBinding", "clusterrolebindings", "rbac.authorization.k8s.io", "v1"),
        new ResourceKey("ClusterRoleBinding", "clusterrolebindings", "rbac.authorization.k8s.io", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("ClusterRole", "clusterroles", "rbac.authorization.k8s.io", "v1"),
        new ResourceKey("ClusterRole", "clusterroles", "rbac.authorization.k8s.io", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("CronJob", "cronjobs", "batch", "v1"),
        new ResourceKey("CronJob", "cronjobs", "batch", "v1beta1"));
    notFoundTransformations.put(new ResourceKey("CronJob", "cronjobs", "batch", "v1beta1"),
        new ResourceKey("CronJob", "cronjobs", "batch", "v2alpha1"));
    notFoundTransformations.put(new ResourceKey("Template", "template", "", "v1"),
        new ResourceKey("Template", "template", "template.openshift.io", "v1"));

    badRequestTransformations.put(new ResourceKey("Deployment", "deployments", "apps", "v1beta1"),
        new ResourceKey("Deployment", "deployments", "extensions", "v1beta1"));

    responseCodeToTransformations.put(400, badRequestTransformations);
    responseCodeToTransformations.put(404, notFoundTransformations);

    /**
     * OpenShift versions prior to 3.10 use the /oapi endpoint for Openshift specific resources.
     * However, since 3.10 /apis/{group} is being used. This has been removed completely in 4.x
     * versions of OpenShift. Hence, this code is to handle those cases.
     */
    openshiftOAPITransformations.put("routes", new ResourceKey("Route", "routes", "route.openshift.io", "v1"));
    openshiftOAPITransformations.put("templates", new ResourceKey("Template", "templates", "template.openshift.io", "v1"));
    openshiftOAPITransformations.put("buildconfigs",
        new ResourceKey("BuildConfig", "buildconfigs", "build.openshift.io", "v1"));
    openshiftOAPITransformations.put("deploymentconfigs",
        new ResourceKey("DeploymentConfig", "deploymentconfigs", "apps.openshift.io", "v1"));
    openshiftOAPITransformations.put("imagestreams",
        new ResourceKey("ImageStream", "imagestreams", "image.openshift.io", "v1"));
    openshiftOAPITransformations.put("imagestreamtags",
        new ResourceKey("ImageStream", "imagestreamtags", "image.openshift.io", "v1"));
    openshiftOAPITransformations.put("securitycontextconstraints",
        new ResourceKey("SecurityContextConstraints", "securitycontextconstraints", "security.openshift.io", "v1"));
  }

  @Override
  public CompletableFuture<Boolean> afterFailure(Builder builder, HttpResponse<?> response, RequestTags tags) {
    ResourceKey target = findNewTarget(builder, response);
    if (target == null) {
      return CompletableFuture.completedFuture(false);
    }

    HttpRequest request = response.request();
    if (request.bodyString() != null && !request.method().equalsIgnoreCase(PATCH)) {
      JsonNode object = Serialization.unmarshal(request.bodyString(), JsonNode.class);
      if (object.get("apiVersion") != null) {
        ((ObjectNode) object).put("apiVersion", target.group + "/" + target.version);
        switch (request.method()) {
          case "POST":
            builder.post(JSON, Serialization.asJson(object));
            break;
          case "PUT":
            builder.put(JSON, Serialization.asJson(object));
            break;
          case "DELETE":
            builder.delete(JSON, Serialization.asJson(object));
            break;
          default:
            return CompletableFuture.completedFuture(false);
        }
      }
    }

    return CompletableFuture.completedFuture(true);
  }

  public ResourceKey findNewTarget(BasicBuilder basicBuilder, HttpResponse<?> response) {
    HttpRequest request = response.request();
    if (isDeprecatedOpenshiftOapiRequest(request)) {
      return handleOpenshiftOapiRequests(basicBuilder, request, response);
    } else if (!response.isSuccessful() && responseCodeToTransformations.keySet().contains(response.code())) {
      String url = request.uri().toString();
      Matcher matcher = getMatcher(url);
      ResourceKey key = getKey(matcher);
      ResourceKey target = responseCodeToTransformations.get(response.code()).get(key);
      if (target != null) {
        String newUrl = new StringBuilder(url)
            .replace(matcher.start(API_VERSION), matcher.end(API_VERSION), target.version) // Order matters: We need to substitute right to left, so that former substitution don't affect the indexes of later.
            .replace(matcher.start(API_GROUP), matcher.end(API_GROUP), target.group)
            .toString();
        basicBuilder.uri(URI.create(newUrl));
        return target;
      }
    }
    return null;
  }

  @Override
  public CompletableFuture<Boolean> afterFailure(BasicBuilder basicBuilder, HttpResponse<?> response, RequestTags tags) {
    return CompletableFuture.completedFuture(findNewTarget(basicBuilder, response) != null);
  }

  private static Matcher getMatcher(String url) {
    Matcher m = NAMESPACED_URL_PATTERN.matcher(url);
    if (m.matches()) {
      return m;
    }

    m = URL_PATTERN.matcher(url);
    if (m.matches()) {
      return m;
    }
    return null;
  }

  private static ResourceKey getKey(Matcher m) {
    return m != null ? new ResourceKey(null, m.group(PATH), m.group(API_GROUP), m.group(API_VERSION)) : null;
  }

  private static ResourceKey handleOpenshiftOapiRequests(BasicBuilder builder, HttpRequest request, HttpResponse<?> response) {
    if (!response.isSuccessful() && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
      String requestUrl = request.uri().toString();
      // handle case when /oapi is not available
      String[] parts = requestUrl.split("/");
      String resourcePath = parts[parts.length - 1];
      ResourceKey target = openshiftOAPITransformations.get(resourcePath);
      if (target != null) {
        requestUrl = requestUrl.replace("/oapi", "/apis/" + target.getGroup());
        builder.uri(URI.create(requestUrl));
        return target;
      }
    }
    return null;
  }

  private static boolean isDeprecatedOpenshiftOapiRequest(HttpRequest request) {
    return request.uri().toString().contains("oapi");
  }
}
