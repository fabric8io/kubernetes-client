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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeExtractor;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.zjsonpatch.internal.guava.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KubernetesAttributesExtractor implements AttributeExtractor<HasMetadata> {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesAttributesExtractor.class);

  public static final String KIND = "kind";
  public static final String NAME = "name";
  public static final String NAMESPACE = "namespace";

  private static final String API_GROUP = "/api(s/[a-zA-Z0-9-_.]+)?";
  private static final String VERSION_GROUP = "(/(?<version>[a-zA-Z0-9-_]+))?";
  private static final String KIND_GROUP = "/(?<kind>[^/?]+)";
  private static final String NAME_GROUP = "(/(?<name>[^/?]+))?";
  private static final String NAMESPACE_GROUP = "(/namespaces/(?<namespace>[^/]+))?";
  private static final String END_GROUP = "[^ /]*";

  protected static final Pattern PATTERN = Pattern.compile(API_GROUP + VERSION_GROUP + NAMESPACE_GROUP + KIND_GROUP + NAME_GROUP + END_GROUP);

  @Override
  public AttributeSet fromPath(String s) {
    if (s == null || s.isEmpty()) {
      return new AttributeSet();
    }

    //Get paths
    Matcher m = PATTERN.matcher(s);
    if (m.matches()) {
      AttributeSet set = extract(m);
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

    //Get paths
    Matcher m = PATTERN.matcher(s);
    if (m.matches()) {
      AttributeSet set = extract(m);
      LOGGER.debug("extract {} : {}", s, set);
      return set;
    }
    LOGGER.debug("extract {} : no attributes", s);
    return new AttributeSet();
  }


  @Override
  public AttributeSet extract(HasMetadata o) {
    AttributeSet attributes = new AttributeSet();
    if (!Strings.isNullOrEmpty(o.getKind())) {
      attributes = attributes.add(new Attribute(KIND, o.getKind().toLowerCase()));
    }

    if (!Strings.isNullOrEmpty(o.getMetadata().getName())) {
      attributes = attributes.add(new Attribute(NAME, o.getMetadata().getName()));
    }

    if (!Strings.isNullOrEmpty(o.getMetadata().getNamespace())) {
      attributes = attributes.add(new Attribute(NAMESPACE, o.getMetadata().getNamespace()));
    }
    return attributes;
  }

  private static AttributeSet extract(Matcher m) {
    AttributeSet attributes = new AttributeSet();
    if (m.matches()) {
      String kind = m.group(KIND);
      if (!Strings.isNullOrEmpty(kind)) {

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
          kind = kind.substring(0,kind.length() - 3) + "y";
        }
        else if (kind.equalsIgnoreCase("securityContextConstraints")){
          // do nothing
          // because its a case which is ending with s but its name is
          // like that, it is not plural
        }
        else if (kind.endsWith("s")) {
          kind = kind.substring(0, kind.length() - 1);
        }
        attributes = attributes.add(new Attribute(KIND, kind));
      }

      String namespace = m.group(NAMESPACE);
      if (!Strings.isNullOrEmpty(namespace)) {
        attributes = attributes.add(new Attribute(NAMESPACE, namespace));
      }

      try {
        String name = m.group(NAME);
        if (!Strings.isNullOrEmpty(name)) {
          attributes = attributes.add(new Attribute(NAME, name));
        }
      } catch (IllegalArgumentException e) {
        //group is missing, which is perfectly valid for create, update etc requests.
      }
    }
    return attributes;
  }

  private static HasMetadata toKubernetesResource(String s) {
    try (InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8.name()))) {
      return Serialization.unmarshal(stream);
    } catch (Exception e) {
      return null;
    }
  }
}
