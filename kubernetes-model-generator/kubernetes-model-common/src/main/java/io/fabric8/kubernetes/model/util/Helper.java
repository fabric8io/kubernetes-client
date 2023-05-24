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
package io.fabric8.kubernetes.model.util;

import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Scanner;

public class Helper {
  private Helper() {
    throw new IllegalStateException("Utility class");
  }

  public static String loadJson(String path) {
    try (InputStream resourceAsStream = Helper.class.getResourceAsStream(path)) {
      final Scanner scanner = new Scanner(resourceAsStream).useDelimiter("\\A");
      return scanner.hasNext() ? scanner.next() : "";
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @deprecated
   */
  @Deprecated
  public static String getAnnotationValue(Class kubernetesResourceType, Class annotationClass) {
    Annotation annotation = getAnnotation(kubernetesResourceType, annotationClass);
    if (annotation instanceof Group) {
      return ((Group) annotation).value();
    } else if (annotation instanceof Version) {
      return ((Version) annotation).value();
    }
    return null;
  }

  private static Annotation getAnnotation(Class kubernetesResourceType, Class annotationClass) {
    return Arrays.stream(kubernetesResourceType.getAnnotations())
        .filter(annotation -> annotation.annotationType().equals(annotationClass))
        .findFirst()
        .orElse(null);
  }
}
