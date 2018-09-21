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
import java.util.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;

public class KubernetesDeserializer extends JsonDeserializer<KubernetesResource> {

    private static final String KIND = "kind";
    private static final String API_VERSION = "apiVersion";
    private static final String KEY_SEPARATOR = "#";

    private static final Map<String, Class<? extends KubernetesResource>> MAP = new HashMap<>();
    private static final List<String> PACKAGES;

    static {
        //Use service loader to load extension types.
        for (KubernetesResourceMappingProvider provider : ServiceLoader.load(KubernetesResourceMappingProvider.class)) {
            for (Map.Entry<String, Class<? extends KubernetesResource>> entry : provider.getMappings().entrySet()) {
                String key = entry.getKey();
                Class<? extends KubernetesResource> value = entry.getValue();
                //If the model is shaded (which is as part of kubernetes-client uberjar) this is going to cause conflicts.
                //This is why we NEED TO filter out incompatible resources.
                if (KubernetesResource.class.isAssignableFrom(value)) {
                        MAP.put(key, value);
                }
            }
        }

        PACKAGES = new ArrayList<String>(){{
            add("io.fabric8.kubernetes.api.model.");
            add("io.fabric8.kubernetes.api.model.apiextensions.");
            add("io.fabric8.kubernetes.api.model.apps.");
            add("io.fabric8.kubernetes.api.model.authentication.");
            add("io.fabric8.kubernetes.api.model.authorization.");
            add("io.fabric8.kubernetes.api.model.batch.");
            add("io.fabric8.kubernetes.api.model.extensions.");
            add("io.fabric8.kubernetes.api.model.networking.");
            add("io.fabric8.kubernetes.api.model.policy.");
            add("io.fabric8.kubernetes.api.model.rbac.");
            add("io.fabric8.kubernetes.api.model.storage.");
            add("io.fabric8.openshift.api.model.");
        }};
    }

    @Override
    public KubernetesResource deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectNode node = jp.readValueAsTree();
        String key = getKey(node);
        if (key != null) {
            Class<? extends KubernetesResource> resourceType = getTypeForKey(key);
            if (resourceType == null) {
                throw ctxt.mappingException("No resource type found for:" + key);
            } else {
                return jp.getCodec().treeToValue(node, resourceType);
            }
        }
        return null;
    }

    /**
     * Return a string representation of the key of the type: <version>#<kind>.
     */
    private static final String getKey(ObjectNode node) {
        JsonNode apiVersion = node.get(API_VERSION);
        JsonNode kind = node.get(KIND);

        return getKey(apiVersion != null ? apiVersion.textValue() : null,
                      kind != null ? kind.textValue() : null);
    }
    
    /**
     * Returns a composite key for apiVersion and kind.
     */
    private static final String getKey(String apiVersion, String kind) {
        if (kind == null) {
            return null;
        } else if (apiVersion == null) {
            return kind;
        } else {
            return String.format("%s#%s", apiVersion, kind);
        }
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
        MAP.put(getKey(apiVersion, kind), clazz);
    }

    static Class getTypeForKey(String key) {
        Class result = MAP.get(key);
        if (result == null) {
            String name = key != null && key.contains(KEY_SEPARATOR) ?
                key.substring(key.indexOf(KEY_SEPARATOR) + 1) :
                key;
            
            result = getInternalTypeForName(name);
        }

        if (result != null) {
            MAP.put(key, result);
        }
        return result;
    }

    private static Class getInternalTypeForName(String name) {

        for (int i = 0; i < PACKAGES.size(); i++ ) {
            Class result = loadClassIfExists(PACKAGES.get(i) + name);
            if (result != null) {
                return result;
            }
        }

        return null;
    } 

    private static Class loadClassIfExists(String className) {
        try {
            return KubernetesDeserializer.class.getClassLoader().loadClass(className);
        } catch (Throwable t) {
            return null;
        }
    }
}
