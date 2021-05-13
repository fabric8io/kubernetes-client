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

import static io.fabric8.mockwebserver.crud.AttributeType.EXISTS;
import static io.fabric8.mockwebserver.crud.AttributeType.NOT_EXISTS;
import static io.fabric8.mockwebserver.crud.AttributeType.WITHOUT;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeExtractor;
import io.fabric8.mockwebserver.crud.AttributeSet;
import okhttp3.HttpUrl;

public class KubernetesAttributesExtractor implements AttributeExtractor<HasMetadata> {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesAttributesExtractor.class);

  public static final String KEY = "key";
  public static final String KIND = "kind";
  public static final String NAME = "name";
  public static final String NAMESPACE = "namespace";
  public static final String VALUE = "value";

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
  private List<CustomResourceDefinitionContext> crdContexts;

  public KubernetesAttributesExtractor() {
    this.crdContexts = Collections.emptyList();
  }

  public KubernetesAttributesExtractor(List<CustomResourceDefinitionContext> crdContexts) {
    this.crdContexts = crdContexts;
  }

  private HttpUrl parseUrlFromPathAndQuery(String s) {
    if (!s.startsWith("/")) {
      s = "/" + s;
    }
    return HttpUrl.parse(String.format("%s://%s%s", SCHEME, HOST, s));
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
      AttributeSet set = extract(m, crdContexts);
      set = AttributeSet.merge(set, extractQueryParameters(url));
      LOGGER.debug("fromPath {} : {}", s, set);
      return set;
    }
    return new AttributeSet();
  }

  @Override
  public AttributeSet fromResource(String s) {
    if (s == null || s.isEmpty()) {
      return new AttributeSet();
    }

    HasMetadata h = toKubernetesResource(s);
    if (h != null) {
      return extract(h);
    }

    return new AttributeSet();
  }

  @Override
  public AttributeSet extract(String s) {
    if (s == null || s.isEmpty()) {
      return new AttributeSet();
    }

    HasMetadata h = toKubernetesResource(s);
    if (h != null) {
      return extract(h);
    }

    return fromPath(s);
  }

  @Override
  public AttributeSet extract(HasMetadata o) {
    AttributeSet attributes = extractMetadataAttributes(o);
    if (!Utils.isNullOrEmpty(o.getKind())) {
        attributes = attributes.add(new Attribute(KIND, o.getKind().toLowerCase(Locale.ROOT)));
    }
    return attributes;
  }

  protected AttributeSet extractMetadataAttributes(HasMetadata hasMetadata) {
      AttributeSet metadataAttributes = new AttributeSet();
      if (!Utils.isNullOrEmpty(hasMetadata.getMetadata().getName())) {
        metadataAttributes = metadataAttributes.add(new Attribute(NAME, hasMetadata.getMetadata().getName()));
      }

      if (!Utils.isNullOrEmpty(hasMetadata.getMetadata().getNamespace())) {
          metadataAttributes = metadataAttributes.add(new Attribute(NAMESPACE, hasMetadata.getMetadata().getNamespace()));
      }

    if (hasMetadata.getMetadata().getLabels() != null) {
      for (Map.Entry<String, String> label : hasMetadata.getMetadata().getLabels().entrySet()) {
        metadataAttributes = metadataAttributes.add(new Attribute(LABEL_KEY_PREFIX + label.getKey(), label.getValue()));
      }
    }
    return metadataAttributes;
  }

  private static AttributeSet extract(Matcher m, List<CustomResourceDefinitionContext> crdContexts) {
    AttributeSet attributes = new AttributeSet();
    if (m.matches()) {
      String kind = m.group(KIND);
      if (!Utils.isNullOrEmpty(kind)) {
        kind = resolveKindFromPlural(crdContexts, kind);
        attributes = attributes.add(new Attribute(KIND, kind));
      }

      String namespace = m.group(NAMESPACE);
      if (!Utils.isNullOrEmpty(namespace)) {
        attributes = attributes.add(new Attribute(NAMESPACE, namespace));
      }

      try {
        String name = m.group(NAME);
        if (!Utils.isNullOrEmpty(name)) {
          attributes = attributes.add(new Attribute(NAME, name));
        }
      } catch (IllegalArgumentException e) {
        //group is missing, which is perfectly valid for create, update etc requests.
      }
    }
    return attributes;
  }

  private static String resolveKindFromPlural(List<CustomResourceDefinitionContext> crdContexts, String kind) {
    if (isCustomResourceKind(crdContexts, kind)) {
      return getCustomResourceKindFromPlural(crdContexts, kind);
    }
    return getKindFromPluralForKubernetesTypes(kind);
  }

  private static String getKindFromPluralForKubernetesTypes(String kind) {
    //Poor mans to singular.
    //Special Case for PodSecurityPolicies and NetworkPolicies because
    //we need to return PodSecurityPolicy and NetworkPolicy respectively
    //because it is returning PodSecurityPolicie and NetworkPolicie now
    //Right now not adding generalised case of "ies" because it may break other resource not sure

    if (kind.endsWith("ses")) {
      kind = kind.substring(0, kind.length() - 2);
    }
    else if (kind.equalsIgnoreCase("PodSecurityPolicies") ||
      kind.equalsIgnoreCase("NetworkPolicies")){
      kind = kind.substring(0, kind.length() - 3) + "y";
    } else if (kind.equalsIgnoreCase("securityContextConstraints") ||
      kind.equalsIgnoreCase("endpoints")){
      // do nothing
      // because its a case which is ending with s but its name is
      // like that, it is not plural
    }
    else if (kind.endsWith("s")) {
      kind = kind.substring(0, kind.length() - 1);
    }
    return kind;
  }

  private static AttributeSet extractQueryParameters(HttpUrl url) {
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

  static HasMetadata toKubernetesResource(String s) {
    try (InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8.name()))) {
      HasMetadata result = Serialization.unmarshal(stream);
      if (result != null) {
        return result;
      }
    } catch (Exception e) {
    }
    return toRawHasMetadata(s);
  }

  private static HasMetadata toRawHasMetadata(String s) {
    try (InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8.name()))) {
      return Serialization.jsonMapper().readValue(stream, FallbackHasMetadata.class);
    } catch (Exception e) {
      return null;
    }
  }

  private static boolean isCustomResourceKind(List<CustomResourceDefinitionContext> crdContexts, String kind) {
    return crdContexts.stream()
      .anyMatch(c -> c.getPlural().equals(kind));
  }

  private static String getCustomResourceKindFromPlural(List<CustomResourceDefinitionContext> crdContexts, String kind) {
    CustomResourceDefinitionContext crdContext = crdContexts.stream()
      .filter(c -> c.getPlural().equals(kind))
      .findAny()
      .orElse(null);
    return crdContext != null && crdContext.getKind() != null ? crdContext.getKind().toLowerCase() : null;
  }
}
