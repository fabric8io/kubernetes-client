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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeExtractor;
import io.fabric8.mockwebserver.crud.AttributeSet;
import okhttp3.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static io.fabric8.mockwebserver.crud.AttributeType.EXISTS;
import static io.fabric8.mockwebserver.crud.AttributeType.NOT_EXISTS;
import static io.fabric8.mockwebserver.crud.AttributeType.WITHOUT;

public class KubernetesAttributesExtractor implements AttributeExtractor {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesAttributesExtractor.class);

  public static final String KEY = "key";
  public static final String KIND = "kind";
  public static final String API = "api";
  public static final String VERSION = "version";
  public static final String NAME = "name";
  public static final String METADATA_NAME = "metadata.name";
  public static final String NAMESPACE = "namespace";
  public static final String METADATA_NAMESPACE = "metadata.namespace";
  public static final String VALUE = "value";
  public static final String PLURAL = "plural";

  public static final String UNKNOWN_KIND = "%unknown";

  private static final String API_GROUP = "/o?api(s/[a-zA-Z0-9-_.]+)?";
  private static final String VERSION_GROUP = "(/(?<version>[a-zA-Z0-9-_]+))?";
  private static final String KIND_GROUP = "/(?<kind>[^/?]+)";
  private static final String NAME_GROUP = "(/(?<name>[^/?]+))?";
  private static final String NAMESPACE_GROUP = "(/namespaces/(?<namespace>[^/]+))?";
  private static final String SUBRESOURCE_MAYBE_GROUP = "(/(status|scale))?";
  private static final String END_GROUP = "[^ /]*";

  protected static final Pattern PATTERN = Pattern.compile(API_GROUP + VERSION_GROUP + NAMESPACE_GROUP + KIND_GROUP + NAME_GROUP + SUBRESOURCE_MAYBE_GROUP + END_GROUP);

  private static final String LABEL_KEY_PREFIX = "labels:";
  private static final String KEY_GROUP = "(?<key>[a-zA-Z0-9-_./]+)";
  // Matches a==b and a=b but not a!=b.
  private static final String EQUALITY_GROUP = "(==|(?<!!)=)";
  // Matches a!=b but not a==b or a=b .
  private static final String NOT_EQUALITY_GROUP = "(!=)";
  private static final String VALUE_GROUP = "(?<value>[a-zA-Z0-9-_.]+)";
  private static final Pattern LABEL_REQUIREMENT_EQUALITY = Pattern.compile(KEY_GROUP + EQUALITY_GROUP + VALUE_GROUP);
  private static final Pattern LABEL_REQUIREMENT_NOT_EQUALITY = Pattern.compile(KEY_GROUP + NOT_EQUALITY_GROUP + VALUE_GROUP);
  private static final Pattern LABEL_REQUIREMENT_EXISTS = Pattern.compile(KEY_GROUP);
  private static final Pattern LABEL_REQUIREMENT_NOT_EXISTS = Pattern.compile("!" + KEY_GROUP);

  // These elements are added to the path/query fragment so that it can be parsed by HttpUrl. Their
  // values are not important, HttpUrl expects the scheme to be http or https.
  private static final String SCHEME = "http";
  private static final String HOST = "localhost";

  private final Map<List<String>, CustomResourceDefinitionContext> crdContexts;

  public KubernetesAttributesExtractor() {
    this(Collections.emptyList());
  }

  public KubernetesAttributesExtractor(List<CustomResourceDefinitionContext> crdContexts) {
    this.crdContexts = crdContexts.stream().collect(Collectors.toMap(KubernetesAttributesExtractor::pluralKey, Function.identity()));
  }

  private static List<String> pluralKey(CustomResourceDefinitionContext c) {
    return pluralKey(c.getGroup(), c.getVersion(), c.getPlural());
  }

  private static List<String> pluralKey(String api, String version, String plural) {
    return Arrays.asList(api, version, plural);
  }

  private HttpUrl parseUrlFromPathAndQuery(String s) {
    if (!s.startsWith("/")) {
      s = "/" + s;
    }
    return HttpUrl.parse(String.format("%s://%s%s", SCHEME, HOST, s));
  }

  /**
   * Get the name, namespace, api, version, plural, and kind from the path
   */
  public Map<String, String> fromKubernetesPath(String s) {
    if (s == null || s.isEmpty()) {
      return Collections.emptyMap();
    }

    //Get paths
    HttpUrl url = parseUrlFromPathAndQuery(s);
    Matcher m = PATTERN.matcher(url.encodedPath());
    if (m.matches()) {
      return extract(m);
    }
    return Collections.emptyMap();
  }

  @Override
  public AttributeSet fromPath(String s) {
    if (s == null || s.isEmpty()) {
      return new AttributeSet();
    }

    //Get paths
    HttpUrl url = parseUrlFromPathAndQuery(s);
    Matcher m = PATTERN.matcher(url.encodedPath());
    if (m.matches()) {
      AttributeSet set = new AttributeSet(extract(m).entrySet()
          .stream()
          .map(e -> new Attribute(e.getKey(), e.getValue()))
          .collect(Collectors.toList()));
      set = AttributeSet.merge(set, extractQueryParameters(url));
      LOGGER.debug("fromPath {} : {}", s, set);
      return set;
    }
    return new AttributeSet();
  }

  @Override
  public AttributeSet fromResource(String s) {
    HasMetadata h = toKubernetesResource(s);
    if (h != null) {
      return extract(h);
    }
    return new AttributeSet();
  }

  public AttributeSet extract(HasMetadata hasMetadata) {
    AttributeSet metadataAttributes = new AttributeSet();
    String apiVersion = hasMetadata.getApiVersion();
    String api = null;
    String version = null;
    if (!Utils.isNullOrEmpty(apiVersion)) {
      api = ApiVersionUtil.trimGroup(apiVersion);
      version = ApiVersionUtil.trimVersion(apiVersion);
      if (!api.equals(apiVersion)) {
        metadataAttributes = metadataAttributes.add(new Attribute(API, api));
      } else {
        api = null;
      }
      metadataAttributes = metadataAttributes.add(new Attribute(VERSION, version));
    }
    if (!Utils.isNullOrEmpty(hasMetadata.getMetadata().getName())) {
      metadataAttributes = metadataAttributes.add(new Attribute(NAME, hasMetadata.getMetadata().getName()));
      metadataAttributes = metadataAttributes.add(new Attribute(METADATA_NAME, hasMetadata.getMetadata().getName()));
    }

    if (!Utils.isNullOrEmpty(hasMetadata.getMetadata().getNamespace())) {
      metadataAttributes = metadataAttributes.add(new Attribute(NAMESPACE, hasMetadata.getMetadata().getNamespace()));
      metadataAttributes = metadataAttributes.add(new Attribute(METADATA_NAMESPACE, hasMetadata.getMetadata().getNamespace()));
    }

    if (hasMetadata.getMetadata().getLabels() != null) {
      for (Map.Entry<String, String> label : hasMetadata.getMetadata().getLabels().entrySet()) {
        metadataAttributes = metadataAttributes.add(new Attribute(LABEL_KEY_PREFIX + label.getKey(), label.getValue()));
      }
    }
    if (!(hasMetadata instanceof GenericKubernetesResource)) {
      metadataAttributes = metadataAttributes.add(new Attribute(PLURAL, hasMetadata.getPlural()));
    } else {
      Optional<CustomResourceDefinitionContext> context = findCrd(api, version);
      if (context.isPresent()) {
        metadataAttributes = metadataAttributes.add(new Attribute(PLURAL, context.get().getPlural()));
      } // else we shouldn't infer the plural without a crd registered - it will come from the path instead
    }
    return metadataAttributes;
  }

  private Optional<CustomResourceDefinitionContext> findCrd(String api, String version) {
    return crdContexts.values()
        .stream()
        .filter(c -> Objects.equals(api, c.getGroup()) && Objects.equals(version, c.getVersion()))
        .findFirst();
  }

  private Map<String, String> extract(Matcher m) {
    Map<String, String> attributes = new HashMap<>();
    if (m.matches()) {

      String api = m.group(1);
      if (api != null) {
        api = api.substring(2);
        attributes.put(API, api);
      }

      String version = m.group(VERSION);
      if (!Utils.isNullOrEmpty(version)) {
        attributes.put(VERSION, version);
      }

      String kind = m.group(KIND);
      if (!Utils.isNullOrEmpty(kind)) {
        attributes.put(PLURAL, kind);
      }

      String namespace = m.group(NAMESPACE);
      if (!Utils.isNullOrEmpty(namespace)) {
        attributes.put(NAMESPACE, namespace);
      }

      try {
        String name = m.group(NAME);
        if (!Utils.isNullOrEmpty(name)) {
          attributes.put(NAME, name);
        }
      } catch (IllegalArgumentException e) {
        //group is missing, which is perfectly valid for create, update etc requests.
      }
    }
    return attributes;
  }

  private static AttributeSet extractQueryParameters(HttpUrl url) {
    return AttributeSet.merge(extractLabelSelector(url),extractFieldSelector(url));
  }

  private static AttributeSet extractLabelSelector(HttpUrl url) {
    AttributeSet attributes = new AttributeSet();
    String labelSelector = url.queryParameter("labelSelector");
    if (labelSelector != null) {
      for (String requirement : labelSelector.split(",")) {
        Attribute label = parseLabel(requirement);

        if (label != null) {
          attributes = attributes.add(label);
        } else {
          LOGGER.warn("Ignoring unsupported label requirement: {}", requirement);
        }
      }
    }
    return attributes;
  }

  private static AttributeSet extractFieldSelector(HttpUrl url) {
    AttributeSet attributes = new AttributeSet();
    String fieldSelector = url.queryParameter("fieldSelector");
    if (fieldSelector != null) {
      for (String requirement : fieldSelector.split(",")) {
        Attribute field = parseField(requirement);
        if (field != null) {
          attributes = attributes.add(field);
        } else {
          LOGGER.warn("Ignoring unsupported field requirement: {}", requirement);
        }
      }
    }
    return attributes;
  }

  private static Attribute parseLabel(String label) {
    Matcher m = LABEL_REQUIREMENT_EQUALITY.matcher(label);
    if (m.matches()) {
      return new Attribute(LABEL_KEY_PREFIX + m.group(KEY), m.group(VALUE));
    }

    m = LABEL_REQUIREMENT_NOT_EQUALITY.matcher(label);
    if (m.matches()) {
      return new Attribute(LABEL_KEY_PREFIX + m.group(KEY), m.group(VALUE), WITHOUT);
    }

    m = LABEL_REQUIREMENT_EXISTS.matcher(label);
    if (m.matches()) {
      return new Attribute(LABEL_KEY_PREFIX + m.group(KEY), "", EXISTS);
    }

    m = LABEL_REQUIREMENT_NOT_EXISTS.matcher(label);
    if (m.matches()) {
      return new Attribute(LABEL_KEY_PREFIX + m.group(KEY), "", NOT_EXISTS);
    }

    return null;
  }

  private static Attribute parseField(String field) {
    Matcher m = LABEL_REQUIREMENT_EQUALITY.matcher(field);
    if (m.matches()) {
      return new Attribute(m.group(KEY), m.group(VALUE));
    }

    m = LABEL_REQUIREMENT_NOT_EQUALITY.matcher(field);
    if (m.matches()) {
      return new Attribute(m.group(KEY), m.group(VALUE), WITHOUT);
    }

    m = LABEL_REQUIREMENT_EXISTS.matcher(field);
    if (m.matches()) {
      return new Attribute(m.group(KEY), "", EXISTS);
    }

    m = LABEL_REQUIREMENT_NOT_EXISTS.matcher(field);
    if (m.matches()) {
      return new Attribute(m.group(KEY), "", NOT_EXISTS);
    }

    return null;
  }

  static HasMetadata toKubernetesResource(String s) {
    if (Utils.isNullOrEmpty(s)) {
      return null;
    }
    HasMetadata result = Serialization.unmarshal(s);
    if (result == null) {
      throw new IllegalArgumentException("Required value: kind is required");
    }
    return result;
  }

  public CustomResourceDefinitionContext getCrdContext(String api, String version, String plural) {
    return this.crdContexts.get(pluralKey(api, version, plural));
  }

  public void removeCrdContext(CustomResourceDefinitionContext context) {
    this.crdContexts.remove(pluralKey(context));
  }

  public void addCrdContext(CustomResourceDefinitionContext context) {
    this.crdContexts.put(pluralKey(context), context);
  }
}
