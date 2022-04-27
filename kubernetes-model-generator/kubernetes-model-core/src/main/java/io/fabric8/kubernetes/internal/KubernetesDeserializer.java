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
import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.util.Helper;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;
import java.util.function.Predicate;
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

  private static final Mapping mapping = new Mapping();

  @Override
  public KubernetesResource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.readValueAsTree();
    if (node.isObject()) {
      return fromObjectNode(jp, node);
    } else if (node.isArray()) {
      return fromArrayNode(jp, node);
    } else {
      return null;
    }
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
      }
    }
    return new KubernetesListBuilder().withItems(list).build();
  }

  private static KubernetesResource fromObjectNode(JsonParser jp, JsonNode node) throws IOException {
    TypeKey key = getKey(node);
    Class<? extends KubernetesResource> resourceType = mapping.getForKey(key);
    if (resourceType == null) {
      if (key == null || (key.version == null && key.apiGroup == null)) {
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

  /**
   * Return a string representation of the key of the type: <version>#<kind>.
   */
  private static TypeKey getKey(JsonNode node) {
    JsonNode apiVersion = node.get(API_VERSION);
    JsonNode kind = node.get(KIND);

    return mapping.createKey(
        apiVersion != null ? apiVersion.textValue() : null,
        kind != null ? kind.textValue() : null);
  }

  /**
   * Registers a Custom Resource Definition Kind
   */
  public static void registerCustomKind(String kind, Class<? extends KubernetesResource> clazz) {
    registerCustomKind(null, kind, clazz);
  }

  /**
   * Registers a Custom Resource Definition Kind
   */
  public static void registerCustomKind(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
    mapping.registerKind(apiVersion, kind, clazz);
  }

  /**
   * Registers a Custom Resource Mapping Provider
   */
  public static void registerProvider(KubernetesResourceMappingProvider provider) {
    mapping.registerProvider(provider);
  }

  static class Mapping {

    // n.b. classes from each of the internal packages that lack a mapping provider
    // needed for osgi resource loading:
    private static final String[] CLASSES = {
        "io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest",
        "io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionRequest",
        "io.fabric8.kubernetes.api.model.apps.Deployment",
        "io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler",
        "io.fabric8.kubernetes.api.model.batch.v1.CronJob",
        "io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest",
        "io.fabric8.kubernetes.api.model.coordination.v1.Lease",
        "io.fabric8.kubernetes.api.model.discovery.v1.Endpoint",
        "io.fabric8.kubernetes.api.model.events.v1.Event",
        "io.fabric8.kubernetes.api.model.extensions.DaemonSet",
        "io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema",
        "io.fabric8.kubernetes.api.model.metrics.v1beta1.ContainerMetrics",
        "io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressPath",
        "io.fabric8.kubernetes.api.model.policy.v1.Eviction",
        "io.fabric8.kubernetes.api.model.rbac.ClusterRole",
        "io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass",
        "io.fabric8.kubernetes.api.model.storage.CSIDriver",
        "io.fabric8.kubernetes.api.model.node.v1beta1.Overhead",
        "io.fabric8.openshift.api.model.APIServer",
        "io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler",
        "io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownload",
        "io.fabric8.openshift.api.model.hive.v1.AWSAssociatedVPC",
        "io.fabric8.openshift.api.model.installer.v1.BootstrapInPlace",
        "io.fabric8.openshift.api.model.monitoring.v1.Alertmanager",
        "io.fabric8.openshift.api.model.machine.v1beta1.Condition",
        "io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfig",
        "io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest",
        "io.fabric8.openshift.api.model.operator.v1.AccessLogging",
        "io.fabric8.openshift.api.model.operatorhub.v1.Operator",
        "io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.GroupResource",
        "io.fabric8.openshift.api.model.tuned.v1.OperandConfig",
        "io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPAllocation",
    };

    private Map<TypeKey, Class<? extends KubernetesResource>> mappings = new ConcurrentHashMap<>();
    private Set<String> urlsLoaded = new ConcurrentSkipListSet<>();

    Mapping() {
      registerAllProviders();
      loadFromJandex(Mapping.class.getClassLoader());
      loadFromJandex(Thread.currentThread().getContextClassLoader());
      // when in osgi, the jandex won't be visible from the current classloader, so we
      // need the specific classloaders
      Stream.of(CLASSES).map(this::getClassloader).filter(Objects::nonNull).forEach(this::loadFromJandex);
    }

    private ClassLoader getClassloader(String className) {
      try {
        Class<?> clazz = KubernetesDeserializer.class.getClassLoader().loadClass(className);
        return clazz.getClassLoader();
      } catch (Exception t) {
        return null;
      }
    }

    void loadFromJandex(ClassLoader classLoader) {
      try {
        internalLoadFromJandex(classLoader);
      } catch (IOException e) {
        System.err.println(String.format("Could not process jandex files for classloader %s", classLoader));
      }
    }

    public Class<? extends KubernetesResource> getForKey(TypeKey key) {
      if (key == null) {
        return null;
      }
      return mappings.get(key);
    }

    public void registerKind(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
      mappings.put(createKey(apiVersion, kind), clazz);
    }

    public void registerProvider(KubernetesResourceMappingProvider provider) {
      if (provider == null) {
        return;
      }
      provider.provideClasses(this::addMapping);
      loadFromJandex(provider.getClass().getClassLoader());
    }

    /**
     * Returns a composite key for apiVersion and kind.
     */
    TypeKey createKey(String apiVersion, String kind) {
      if (kind == null) {
        return null;
      } else if (apiVersion == null) {
        return new TypeKey(kind, null, null);
      } else {
        String[] versionParts = new String[] { null, apiVersion };
        if (apiVersion.contains("/")) {
          versionParts = apiVersion.split("/", 2);
        }
        return new TypeKey(kind, versionParts[0], versionParts[1]);
      }
    }

    private void registerAllProviders() {
      getAllMappingProviders().forEach(this::registerProvider);
    }

    Stream<KubernetesResourceMappingProvider> getAllMappingProviders() {
      //Use service loader to load extension types.
      Iterable<KubernetesResourceMappingProvider> currentThreadClassLoader = () -> ServiceLoader
          .load(KubernetesResourceMappingProvider.class, Thread.currentThread().getContextClassLoader())
          .iterator();
      Iterable<KubernetesResourceMappingProvider> classClassLoader = () -> ServiceLoader
          .load(KubernetesResourceMappingProvider.class, KubernetesDeserializer.class.getClassLoader())
          .iterator();
      return Stream.concat(
          StreamSupport.stream(currentThreadClassLoader.spliterator(), false),
          StreamSupport.stream(classClassLoader.spliterator(), false))
          .filter(distinctByClassName(KubernetesResourceMappingProvider::getClass));
    }

    TypeKey getKeyFromClass(Class<? extends KubernetesResource> clazz) {
      String apiGroup = Helper.getAnnotationValue(clazz, Group.class);
      String apiVersion = Helper.getAnnotationValue(clazz, Version.class);
      String kind = HasMetadata.getKind(clazz);
      if (apiGroup != null && !apiGroup.isEmpty() && apiVersion != null && !apiVersion.isEmpty()) {
        return new TypeKey(kind, apiGroup, apiVersion);
      } else if (apiVersion != null && !apiVersion.isEmpty()) {
        return createKey(apiVersion, kind);
      }
      return new TypeKey(kind, null, null);
    }

    private Predicate<KubernetesResourceMappingProvider> distinctByClassName(
        Function<KubernetesResourceMappingProvider, Class<? extends KubernetesResourceMappingProvider>> mapperProvider) {
      Set<String> existing = ConcurrentHashMap.newKeySet();
      return provider -> existing.add(mapperProvider.apply(provider).getName());
    }

    private void internalLoadFromJandex(ClassLoader classLoader) throws IOException {
      Enumeration<URL> indecies = classLoader.getResources("META-INF/jandex.idx");
      while (indecies.hasMoreElements()) {
        URL u = indecies.nextElement();
        if (!urlsLoaded.add(u.toString())) {
          continue;
        }
        URLConnection uc = u.openConnection();
        uc.setUseCaches(false);
        try (InputStream input = uc.getInputStream()) {
          IndexReader reader = new IndexReader(input);
          Index index = reader.read();
          List<AnnotationInstance> annotations = index.getAnnotations(DotName.createSimple(Version.class.getName()));
          for (AnnotationInstance a : annotations) {
            DotName name = a.target().asClass().name();
            Class<?> clazz;
            try {
              clazz = classLoader.loadClass(name.toString());
            } catch (ClassNotFoundException e) {
              continue;
            }
            addMapping(clazz);
          }
        }
      }
    }

    private void addMapping(Class<?> clazz) {
      if (!KubernetesResource.class.isAssignableFrom(clazz)) {
        //If the model is shaded (which is as part of kubernetes-client uberjar) this is going to cause conflicts.
        //This is why we NEED TO filter out incompatible resources.
        return;
      }
      if (KubernetesResourceList.class.isAssignableFrom(clazz)) {
        // list classes don't need a mapping
        return;
      }
      Class<? extends KubernetesResource> krClazz = (Class<? extends KubernetesResource>) clazz;
      TypeKey keyFromClass = getKeyFromClass(krClazz);
      mappings.put(keyFromClass, krClazz);

      // oc behavior - allow resolving against just the version
      if (keyFromClass.apiGroup != null && keyFromClass.apiGroup.endsWith(".openshift.io")) {
        mappings.putIfAbsent(new TypeKey(keyFromClass.kind, null, keyFromClass.version), krClazz);
      }
    }
  }
}
