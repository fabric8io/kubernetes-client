/*
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
package io.fabric8.crdv2.generator;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import io.fabric8.crd.generator.annotation.Annotations;
import io.fabric8.crd.generator.annotation.Labels;

import java.util.HashMap;
import java.util.Map;

public class CRDUtils {
  private CRDUtils() {
    throw new IllegalStateException("Utility class");
  }

  @SuppressWarnings("LombokGetterMayBeUsed")
  public static class SpecAndStatus {

    private final String specClassName;
    private final String statusClassName;
    private final boolean unreliable;

    public SpecAndStatus(String specClassName, String statusClassName) {
      this.specClassName = specClassName;
      this.statusClassName = statusClassName;
      this.unreliable = specClassName == null || statusClassName == null;
    }

    public String getSpecClassName() {
      return specClassName;
    }

    public String getStatusClassName() {
      return statusClassName;
    }

    public boolean isUnreliable() {
      return unreliable;
    }
  }

  /**
   * Determine the spec and status types via convention by looking for the
   * spec and status properties.
   *
   * If we support eventually support spec and status interfaces or some other mechanism
   * then this logic will need to change
   */
  public static SpecAndStatus resolveSpecAndStatusTypes(Class<?> definition) {
    SerializationConfig config = new ObjectMapper().getSerializationConfig();
    BeanDescription description = config.introspect(config.constructType(definition));
    String specClassName = null;
    String statusClassName = null;
    for (BeanPropertyDefinition bpd : description.findProperties()) {
      if (bpd.getName().equals("spec") && bpd.getRawPrimaryType() != Void.class) {
        specClassName = bpd.getRawPrimaryType().getName();
      } else if (bpd.getName().equals("status") && bpd.getRawPrimaryType() != Void.class) {
        statusClassName = bpd.getRawPrimaryType().getName();
      }
    }
    return new SpecAndStatus(specClassName, statusClassName);
  }

  public static Map<String, String> toMap(String[] arr) {
    Map<String, String> res = new HashMap<>();
    if (arr != null) {
      for (String e : arr) {
        String[] splitted = e.split("=");
        if (splitted.length >= 2) {
          res.put(splitted[0], e.substring(splitted[0].length() + 1));
        } else {
          throw new IllegalArgumentException(
              "Invalid value: " + e + " cannot be parsed as a key-value pair. Expected format is 'key=value'.");
        }
      }
    }
    return res;
  }

  /**
   * Retrieves the annotations associated with this class or an empty array if none was provided
   *
   * @param clazz the class for which the annotations are to be retrieved
   * @return the annotations associated with this class or an empty array if none was provided
   */
  public static String[] getAnnotations(Class<?> clazz) {
    Annotations annotations = clazz.getAnnotation(Annotations.class);
    if (annotations != null) {
      return annotations.value();
    }
    return new String[] {};
  }

  /**
   * Retrieves the labels associated with this class or an empty array if none was provided
   *
   * @param clazz the class for which the labels are to be retrieved
   * @return the labels associated with this class or an empty array if none was provided
   */
  public static String[] getLabels(Class<?> clazz) {
    Labels labels = clazz.getAnnotation(Labels.class);
    if (labels != null) {
      return labels.value();
    }
    return new String[] {};
  }
}
