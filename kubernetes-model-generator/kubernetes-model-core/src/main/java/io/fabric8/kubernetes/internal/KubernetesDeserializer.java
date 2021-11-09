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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.util.Helper;

public class KubernetesDeserializer extends JsonDeserializer<KubernetesResource> {

    private static final String TEMPLATE_CLASS_NAME = "io.fabric8.openshift.api.model.Template";
    private static final String KIND = "kind";
    private static final String API_VERSION = "apiVersion";

    private static final Mapping mapping = new Mapping();

    private static final ThreadLocal<Boolean> IN_TEMPLATE = ThreadLocal.withInitial(() -> false);

    public static boolean isInTemplate() {
        return IN_TEMPLATE.get();
    }

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
                if (resource instanceof HasMetadata) {
                    list.add((HasMetadata)resource);
                }
            }
        }
        return new KubernetesListBuilder().withItems(list).build();
    }

    private static KubernetesResource fromObjectNode(JsonParser jp, JsonNode node) throws IOException {
        String key = getKey(node);
        if (key != null) {
            Class<? extends KubernetesResource> resourceType = mapping.getForKey(key);
            if (resourceType == null) {
              return jp.getCodec().treeToValue(node, GenericKubernetesResource.class);
            } else if (KubernetesResource.class.isAssignableFrom(resourceType)){
              boolean inTemplate = false;
              if (TEMPLATE_CLASS_NAME.equals(resourceType.getName())) {
                inTemplate = true;
                IN_TEMPLATE.set(true);
              }
              try {
                return jp.getCodec().treeToValue(node, resourceType);
              } finally {
                if (inTemplate) {
                  IN_TEMPLATE.remove();
                }
              }
            }
        }
        return null;
    }

    /**
     * Return a string representation of the key of the type: <version>#<kind>.
     */
    private static String getKey(JsonNode node) {
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

        private static final String KEY_SEPARATOR = "#";

        // n.b. Packages sorted in order of precedence, deserialization of resources with no
        // specific version will default to first available Class in one of these packages:
        private static final String[] PACKAGES = {
                "io.fabric8.kubernetes.api.model.",
                "io.fabric8.kubernetes.api.model.admission.v1.",
                "io.fabric8.kubernetes.api.model.admission.v1beta1.",
                "io.fabric8.kubernetes.api.model.admissionregistration.v1.",
                "io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.",
                "io.fabric8.kubernetes.api.model.authentication.",
                "io.fabric8.kubernetes.api.model.authorization.v1.",
                "io.fabric8.kubernetes.api.model.authorization.v1beta1.",
                "io.fabric8.kubernetes.api.model.apiextensions.v1.",
                "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.",
                "io.fabric8.kubernetes.api.model.apps.",
                "io.fabric8.kubernetes.api.model.autoscaling.v1.",
                "io.fabric8.kubernetes.api.model.autoscaling.",
                "io.fabric8.kubernetes.api.model.autoscaling.v2beta1.",
                "io.fabric8.kubernetes.api.model.autoscaling.v2beta2.",
                "io.fabric8.kubernetes.api.model.batch.v1.",
                "io.fabric8.kubernetes.api.model.batch.v1beta1.",
                "io.fabric8.kubernetes.api.model.certificates.v1.",
                "io.fabric8.kubernetes.api.model.certificates.v1beta1.",
                "io.fabric8.kubernetes.api.model.coordination.v1.",
                "io.fabric8.kubernetes.api.model.coordination.",
                "io.fabric8.kubernetes.api.model.discovery.v1.",
                "io.fabric8.kubernetes.api.model.events.v1.",
                "io.fabric8.kubernetes.api.model.events.v1beta1.",
                "io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.",
                "io.fabric8.kubernetes.api.model.discovery.v1beta1.",
                "io.fabric8.kubernetes.api.model.metrics.v1beta1.",
                "io.fabric8.kubernetes.api.model.networking.v1.",
                "io.fabric8.kubernetes.api.model.networking.v1beta1.",
                "io.fabric8.kubernetes.api.model.policy.v1.",
                "io.fabric8.kubernetes.api.model.policy.v1beta1.",
                "io.fabric8.kubernetes.api.model.rbac.",
                "io.fabric8.kubernetes.api.model.storage.",
                "io.fabric8.kubernetes.api.model.scheduling.v1.",
                "io.fabric8.kubernetes.api.model.scheduling.v1beta1.",
                "io.fabric8.kubernetes.api.model.storage.",
                "io.fabric8.kubernetes.api.model.storage.v1beta1.",
                "io.fabric8.kubernetes.api.model.node.v1alpha1.",
                "io.fabric8.kubernetes.api.model.node.v1beta1.",
                "io.fabric8.openshift.api.model.",
                "io.fabric8.openshift.api.model.clusterautoscaling.v1.",
                "io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.",
                "io.fabric8.openshift.api.model.runtime.",
                "io.fabric8.openshift.api.model.console.v1.",
                "io.fabric8.openshift.api.model.console.v1alpha1.",
                "io.fabric8.openshift.api.model.monitoring.v1.",
                "io.fabric8.openshift.api.model.machine.v1beta1.",
                "io.fabric8.openshift.api.model.operator.",
                "io.fabric8.openshift.api.model.operator.v1.",
                "io.fabric8.openshift.api.model.operator.v1alpha1.",
                "io.fabric8.openshift.api.model.imageregistry.v1.",
                "io.fabric8.openshift.api.model.operatorhub.manifests.",
                "io.fabric8.openshift.api.model.operatorhub.v1.",
                "io.fabric8.openshift.api.model.operatorhub.v1alpha1.",
                "io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.",
                "io.fabric8.openshift.api.model.machineconfig.v1.",
                "io.fabric8.openshift.api.model.tuned.v1.",
                "io.fabric8.openshift.api.model.whereabouts.v1alpha1.",
                "io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.",
                "io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.",
                "io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.",
                "io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.",
                "io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.",
                "io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.",
                "io.fabric8.kubernetes.api.model.extensions."
        };

        private Map<String, Class<? extends KubernetesResource>> mappings = new ConcurrentHashMap<>();

        Mapping() {
        	registerAllProviders();
        }

        public Class<? extends KubernetesResource> getForKey(String key) {
            if (key == null) {
                return null;
            }
            Class<? extends KubernetesResource> clazz = mappings.get(key);
            if (clazz != null) {
                return clazz;
            }
            clazz = getInternalTypeForName(key);
            if (clazz != null) {
                mappings.put(key, clazz);
            }
            return clazz;
        }

        public void registerKind(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
          mappings.put(createKey(apiVersion, kind), clazz);
        }

        public void registerProvider(KubernetesResourceMappingProvider provider) {
            if (provider == null) {
                return;
            }
            Map<String, Class<? extends KubernetesResource>> providerMappings = provider.getMappings().entrySet().stream()
                    //If the model is shaded (which is as part of kubernetes-client uberjar) this is going to cause conflicts.
                    //This is why we NEED TO filter out incompatible resources.
                    .filter(entry -> KubernetesResource.class.isAssignableFrom(entry.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            mappings.putAll(providerMappings);
        }

        /**
         * Returns a composite key for apiVersion and kind.
         */
        String createKey(String apiVersion, String kind) {
            if (kind == null) {
                return null;
            } else if (apiVersion == null) {
                return kind;
            } else {
                return apiVersion + KEY_SEPARATOR + kind;
            }
        }

        private void registerAllProviders() {
            getAllMappingProviders().forEach(this::registerProvider);
        }

        Stream<KubernetesResourceMappingProvider> getAllMappingProviders() {
            //Use service loader to load extension types.
            Iterable<KubernetesResourceMappingProvider> currentThreadClassLoader =
                    () -> ServiceLoader.load(KubernetesResourceMappingProvider.class, Thread.currentThread().getContextClassLoader())
                            .iterator();
            Iterable<KubernetesResourceMappingProvider> classClassLoader =
                    () -> ServiceLoader.load(KubernetesResourceMappingProvider.class, KubernetesDeserializer.class.getClassLoader())
                            .iterator();
            return Stream.concat(
                    StreamSupport.stream(currentThreadClassLoader.spliterator(), false),
                    StreamSupport.stream(classClassLoader.spliterator(), false))
                    .filter(distinctByClassName(KubernetesResourceMappingProvider::getClass));
        }

        private String getClassName(String key) {
            if (key != null && key.contains(KEY_SEPARATOR)) {
                return key.substring(key.indexOf(KEY_SEPARATOR) + 1);
            } else {
                return key;
            }
        }

        private Class<? extends KubernetesResource> getInternalTypeForName(String key) {
            String name = getClassName(key);
            List<Class<? extends KubernetesResource>> possibleResults = new ArrayList<>();

            // First pass, check if there are more than one class of same name
            for (String aPackage : PACKAGES) {
                Class<? extends KubernetesResource> result = loadClassIfExists(aPackage + name);
                if (result != null) {
                    possibleResults.add(result);
                }
            }

            // If only one class found, return it
            if (possibleResults.size() == 1) {
                return possibleResults.get(0);
            } else if (possibleResults.size() > 1) {
              // Compare with apiVersions being compared for set of classes found
              for (Class<? extends KubernetesResource> result : possibleResults) {
                String defaultKeyFromClass = getKeyFromClass(result);
                if (key.equals(defaultKeyFromClass)) {
                  return result;
                }
              }
              return possibleResults.get(0);
            } else {
              return null;
            }
        }

        private String getKeyFromClass(Class<? extends KubernetesResource> clazz) {
          String apiGroup = Helper.getAnnotationValue(clazz, Group.class);
          String apiVersion = Helper.getAnnotationValue(clazz, Version.class);
          if (apiGroup != null && !apiGroup.isEmpty() && apiVersion != null && !apiVersion.isEmpty()) {
            return createKey(apiGroup + "/" + apiVersion, clazz.getSimpleName());
          } else if (apiVersion != null && !apiVersion.isEmpty()) {
            return createKey(apiVersion, clazz.getSimpleName());
          }
          return clazz.getSimpleName();
        }

        private Class<? extends KubernetesResource> loadClassIfExists(String className) {
            try {
            	Class<?> clazz = KubernetesDeserializer.class.getClassLoader().loadClass(className);
                if (!KubernetesResource.class.isAssignableFrom(clazz)) {
                    return null;
                }
                return (Class<? extends KubernetesResource>) clazz;
            } catch (Exception t) {
                return null;
            }
        }

        private Predicate<KubernetesResourceMappingProvider> distinctByClassName(
                Function<KubernetesResourceMappingProvider, Class<? extends KubernetesResourceMappingProvider>> mapperProvider) {
            Set<String> existing = ConcurrentHashMap.newKeySet();
            return provider -> existing.add(mapperProvider.apply(provider).getName());
        }

    }
}
