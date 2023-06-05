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
package io.fabric8.kubernetes.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class KubernetesDeserializer extends JsonDeserializer<KubernetesResource> {

  static class TypeKey {
    final String kind;
    final String apiGroup;
    final String version;

    TypeKey(String kind, String apiGroup, String version) {
      this.kind = kind;
      this.apiGroup = apiGroup;
      this.version = version;
    }

    @Override
    public int hashCode() {
      return Objects.hash(kind, apiGroup, version);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (!(obj instanceof TypeKey)) {
        return false;
      }
      TypeKey o = (TypeKey) obj;
      return Objects.equals(kind, o.kind) && Objects.equals(apiGroup, o.apiGroup)
          && Objects.equals(version, o.version);
    }

  }

  private static final String KIND = "kind";
  private static final String API_VERSION = "apiVersion";

  private final Mapping mapping = new Mapping();

  private static Mapping DEFAULT_MAPPING;

  public KubernetesDeserializer() {
    this(true);
  }

  public KubernetesDeserializer(boolean scanClassloaders) {
    if (scanClassloaders) {
      synchronized (KubernetesDeserializer.class) {
        if (DEFAULT_MAPPING == null) {
          DEFAULT_MAPPING = new Mapping();
          DEFAULT_MAPPING.registerClassesFromClassLoaders();
        }
      }
      mapping.mappings.putAll(DEFAULT_MAPPING.mappings);
    }
  }

  @Override
  public KubernetesResource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.readValueAsTree();
    if (node.isObject()) {
      return fromObjectNode(jp, node);
    } else if (node.isArray()) {
      return fromArrayNode(jp, node);
    }
    Object object = node.traverse(jp.getCodec()).readValueAs(Object.class);
    if (object == null) {
      return null;
    }
    return new RawExtension(object);
  }

  private KubernetesResource fromArrayNode(JsonParser jp, JsonNode node) throws IOException {
    Iterator<JsonNode> iterator = node.elements();
    List<HasMetadata> list = new ArrayList<>();
    while (iterator.hasNext()) {
      JsonNode jsonNode = iterator.next();
      if (jsonNode.isObject()) {
        KubernetesResource resource = fromObjectNode(jp, jsonNode);
        if (!(resource instanceof HasMetadata)) {
          throw new JsonMappingException(jp, "Cannot parse a nested array containing a non-HasMetadata resource");
        }
        list.add((HasMetadata) resource);
      } else {
        throw new JsonMappingException(jp, "Cannot parse a nested array containing non-object resource");
      }
    }
    return new KubernetesListBuilder().withItems(list).build();
  }

  private KubernetesResource fromObjectNode(JsonParser jp, JsonNode node) throws IOException {
    TypeKey key = createKey(node);
    Class<? extends KubernetesResource> resourceType = mapping.getForKey(key);
    if (resourceType == null) {
      if (key == null) {
        // just a wrapper around a map
        // if this raw mapping typed as HasMetadata, a failure will result
        return jp.getCodec().treeToValue(node, RawExtension.class);
      }
      // this is not quite correct as not all resources have metadata - see LocalResourceAccessReview
      return jp.getCodec().treeToValue(node, GenericKubernetesResource.class);
    } else if (KubernetesResource.class.isAssignableFrom(resourceType)) {
      return jp.getCodec().treeToValue(node, resourceType);
    }
    throw new JsonMappingException(jp, String.format(
        "There's a class loading issue, %s is registered as a KubernetesResource, but is not an instance of KubernetesResource",
        resourceType.getName()));
  }

  private TypeKey createKey(JsonNode node) {
    JsonNode apiVersion = node.get(API_VERSION);
    JsonNode kind = node.get(KIND);

    return mapping.createKey(
        apiVersion != null ? apiVersion.textValue() : null,
        kind != null ? kind.textValue() : null);
  }

  /**
   * Registers a Custom Resource Definition Kind
   */
  public void registerCustomKind(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
    mapping.registerKind(apiVersion, kind, clazz);
  }

  /**
   * Registers a KubernetesResource implementation class. The group, version, and kind are derived from the class
   * annotations.
   * <p>
   * This method is especially interesting when registering classes that are discovered using SPI and multiple class
   * loaders.
   *
   * @param clazz the class to register.
   */
  public void registerKubernetesResource(Class<? extends KubernetesResource> clazz) {
    mapping.addMapping(clazz);
  }

  static class Mapping {

    private final Map<TypeKey, Class<? extends KubernetesResource>> mappings = new ConcurrentHashMap<>();

    public Class<? extends KubernetesResource> getForKey(TypeKey key) {
      if (key == null) {
        return null;
      }
      return mappings.get(key);
    }

    public void registerKind(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
      Optional.ofNullable(createKey(apiVersion, kind)).ifPresent(k -> mappings.put(k, clazz));
    }

    /**
     * Returns a composite key for apiVersion and kind.
     */
    TypeKey createKey(String apiVersion, String kind) {
      if (kind == null || apiVersion == null) {
        return null;
      }
      String[] versionParts = new String[] { null, apiVersion };
      if (apiVersion.contains("/")) {
        versionParts = apiVersion.split("/", 2);
      }
      return new TypeKey(kind, versionParts[0], versionParts[1]);
    }

    void registerClassesFromClassLoaders() {
      Stream.of(Thread.currentThread().getContextClassLoader(), KubernetesDeserializer.class.getClassLoader())
          .filter(Objects::nonNull)
          .map(cl -> ServiceLoader.load(KubernetesResource.class, cl))
          .map(ServiceLoader::iterator)
          .map(i -> (Iterable<KubernetesResource>) () -> i)
          .flatMap(i -> StreamSupport.stream(i.spliterator(), false))
          .map(KubernetesResource::getClass)
          .forEach(this::addMapping);
    }

    TypeKey getKeyFromClass(Class<? extends KubernetesResource> clazz) {
      String apiGroup = HasMetadata.getGroup(clazz);
      String apiVersion = HasMetadata.getVersion(clazz);
      String kind = HasMetadata.getKind(clazz);
      if (apiGroup != null && !apiGroup.isEmpty() && apiVersion != null && !apiVersion.isEmpty()) {
        return new TypeKey(kind, apiGroup, apiVersion);
      } else if (apiVersion != null && !apiVersion.isEmpty()) {
        return createKey(apiVersion, kind);
      }
      return null;
    }

    private void addMapping(Class<? extends KubernetesResource> clazz) {
      TypeKey keyFromClass = getKeyFromClass(clazz);
      if (keyFromClass == null) {
        return;
      }
      mappings.put(keyFromClass, clazz);

      // oc behavior - allow resolving against just the version
      if (keyFromClass.apiGroup != null && keyFromClass.apiGroup.endsWith(".openshift.io")) {
        mappings.putIfAbsent(new TypeKey(keyFromClass.kind, null, keyFromClass.version), clazz);
      }
    }
  }

  public Class<? extends KubernetesResource> getRegisteredKind(String apiVersion, String kind) {
    return mapping.getForKey(mapping.createKey(apiVersion, kind));
  }
}
