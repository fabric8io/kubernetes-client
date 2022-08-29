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

package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.APIResourceBuilder;
import io.fabric8.kubernetes.api.model.APIResourceListBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Holds state related to crds by manipulating the crds known to the attributes extractor
 */
public class CustomResourceDefinitionProcessor implements Resetable {

  private static final String V1BETA1_PATH = "/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions";
  private static final String V1_PATH = "/apis/apiextensions.k8s.io/v1/customresourcedefinitions";

  private static final String API_PATH = "/apis(/(?<group>[a-zA-Z0-9-_.]+))?(/(?<version>[a-zA-Z0-9-_]+))";
  private static final Pattern API_PATH_PATTERN = Pattern.compile(API_PATH);

  private final Map<List<String>, Map<String, CustomResourceDefinitionContext>> crdContexts = new LinkedHashMap<>();

  public void process(String path, String crdString, boolean delete) {
    CustomResourceDefinitionContext context = null;
    if (path.startsWith(V1BETA1_PATH)) {
      io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition crd = Serialization
          .unmarshal(crdString, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition.class);
      context = CustomResourceDefinitionContext.fromCrd(crd);
    } else if (path.startsWith(V1_PATH)) {
      CustomResourceDefinition crd = Serialization.unmarshal(crdString, CustomResourceDefinition.class);
      context = CustomResourceDefinitionContext.fromCrd(crd);
    } else {
      return;
    }
    if (delete) {
      removeCrdContext(context);
    } else {
      addCrdContext(context);
    }
  }

  public boolean isStatusSubresourceEnabledForResource(Map<String, String> pathValues) {
    Optional<CustomResourceDefinitionContext> context = getCrdContext(pathValues.get(KubernetesAttributesExtractor.API),
        pathValues.get(KubernetesAttributesExtractor.VERSION), pathValues.get(KubernetesAttributesExtractor.PLURAL));
    return context.map(CustomResourceDefinitionContext::isStatusSubresource).orElse(false);
  }

  private static List<String> key(CustomResourceDefinitionContext c) {
    return key(c.getGroup(), c.getVersion());
  }

  private static List<String> key(String group, String version) {
    return Arrays.asList(group, version);
  }

  public Optional<CustomResourceDefinitionContext> getCrdContext(String api, String version, String plural) {
    return Optional.ofNullable(this.crdContexts.get(Arrays.asList(api, version))).map(v -> v.get(plural));
  }

  public Optional<CustomResourceDefinitionContext> findCrd(String api, String version, String kind) {
    return Optional.ofNullable(crdContexts.get(Arrays.asList(api, version)))
        .flatMap(m -> m.values().stream().filter(c -> c.getKind().equals(kind)).findFirst());
  }

  public void removeCrdContext(CustomResourceDefinitionContext context) {
    this.crdContexts.computeIfPresent(key(context), (k, v) -> {
      v.remove(context.getPlural());
      return v;
    });
  }

  public void addCrdContext(CustomResourceDefinitionContext context) {
    this.crdContexts.compute(key(context), (k, v) -> {
      if (v == null) {
        v = new LinkedHashMap<>();
      }
      v.put(context.getPlural(), context);
      return v;
    });
  }

  @Override
  public void reset() {
    this.crdContexts.clear();
  }

  public String getApiResources(String path) {
    Matcher matcher = API_PATH_PATTERN.matcher(path);
    if (!matcher.matches()) {
      return null;
    }
    String group = matcher.group("group");
    String version = matcher.group("version");
    Map<String, CustomResourceDefinitionContext> resources = crdContexts.get(key(group, version));
    APIResourceListBuilder builder = new APIResourceListBuilder()
        .withGroupVersion(ApiVersionUtil.joinApiGroupAndVersion(group, version));
    if (resources != null) {
      resources.values().forEach(rdc -> builder.addToResources(new APIResourceBuilder().withKind(rdc.getKind())
          .withNamespaced(rdc.isNamespaceScoped())
          .withName(rdc.getPlural())
          .build()));
    }
    return Serialization.asJson(builder.build());
  }

}
