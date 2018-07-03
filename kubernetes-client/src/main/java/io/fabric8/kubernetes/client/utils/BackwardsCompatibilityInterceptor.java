/**
 * Copyright (C) 2018 Original Authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BackwardsCompatibilityInterceptor implements Interceptor {

  private static final int API_GROUP = 1;
  private static final int API_VERSION = 2;
  private static final int PATH = 3;

  private static final String PATCH = "patch";
  private static final String NAME_REGEX = "[a-z0-9\\-\\.]+";
  private static final Pattern URL_PATTERN = Pattern.compile("[^ ]+/apis/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")[^ ]*");
  private static final Pattern NAMESPACED_URL_PATTERN = Pattern.compile("[^ ]+/apis/(" + NAME_REGEX + ")/(" + NAME_REGEX + ")/namespaces/" + NAME_REGEX + "/(" + NAME_REGEX + ")[^ ]*");
  private static final Map<ResourceKey, ResourceKey> transformations = new HashMap<>();

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
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
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
    transformations.put(new ResourceKey("Deployment", "deployments", "apps", "v1"), new ResourceKey("Deployment", "deployments", "extensions", "v1beta1"));
    transformations.put(new ResourceKey("StatefulSet", "statefulsets", "apps", "v1"), new ResourceKey("StatefulSet", "statefulsets", "apps", "v1beta1"));
    transformations.put(new ResourceKey("DaemonSets", "daemonsets", "apps", "v1"), new ResourceKey("DaemonSet", "daemonsets", "extensions", "v1beta1"));
    transformations.put(new ResourceKey("ReplicaSets", "replicasets", "apps", "v1"), new ResourceKey("ReplicaSet", "replicasets", "extensions", "v1beta1"));
    transformations.put(new ResourceKey("NetworkPolicy", "networkpolicies", "networking.k8s.io", "v1"), new ResourceKey("NetworkPolicy", "networkpolicies", "extensions", "v1beta1"));
    transformations.put(new ResourceKey("StorageClass", "storageclasses", "storage.k8s.io", "v1"), new ResourceKey("StorageClass", "storageclasses", "extensions", "v1beta1"));
    transformations.put(new ResourceKey("Job", "jobs", "batch", "v1"), new ResourceKey("Job", "jobs", "extensions", "v1beta1"));
  }

  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = chain.proceed(request);
    if (!response.isSuccessful() && response.code() == 404) {
      String url = request.url().toString();
      Matcher matcher = getMatcher(url);
      ResourceKey key = getKey(matcher);
      ResourceKey target = transformations.get(key);
      if (target != null) {
        String newUrl = new StringBuilder(url)
            .replace(matcher.start(API_VERSION), matcher.end(API_VERSION), target.version) // Order matters: We need to substitute right to left, so that former substitution don't affect the indexes of later.
            .replace(matcher.start(API_GROUP), matcher.end(API_GROUP), target.group)
            .toString();

        Request.Builder newRequest = request.newBuilder()
          .url(newUrl);

        Buffer buffer = new Buffer();
        if (request.body() != null && !request.method().equalsIgnoreCase(PATCH)) {
          request.body().writeTo(buffer);
            Object object = Serialization.unmarshal(buffer.inputStream());
          if (object instanceof HasMetadata) {
            HasMetadata h = (HasMetadata) object;
            h.setApiVersion(target.group + "/" + target.version);
            newRequest = newRequest.method(request.method(), RequestBody.create(OperationSupport.JSON, Serialization.asJson(h)));
          }
        }

        return chain.proceed(newRequest.build());
      }
    }
    return response;
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
}
