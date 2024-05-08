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
package io.fabric8.crd.generator.collector;

import io.fabric8.kubernetes.api.model.HasMetadata;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

class CustomResourceClassLoader {

  private final List<String> classpathElements = new ArrayList<>();

  private ClassLoader parentClassLoader;

  private ClassLoader classLoader;

  public CustomResourceClassLoader withParentClassLoader(ClassLoader parentClassLoader) {
    this.parentClassLoader = parentClassLoader;
    return this;
  }

  public CustomResourceClassLoader withClasspathElement(String... classpathElements) {
    if (classpathElements != null) {
      withClasspathElements(Arrays.asList(classpathElements));
    }
    return this;
  }

  public CustomResourceClassLoader withClasspathElements(Collection<String> classpathElements) {
    if (classpathElements != null) {
      classpathElements.stream()
          .filter(Objects::nonNull)
          .forEach(this.classpathElements::add);
    }
    return this;
  }

  public Class<? extends HasMetadata> loadCustomResourceClass(String className) {
    Class<?> clazz = loadClass(className);
    if (HasMetadata.class.isAssignableFrom(clazz)) {
      return clazz.asSubclass(HasMetadata.class);
    }
    throw new CustomResourceCollectorException(
        "Could not load Custom Resource. Class does not implement HasMetadata: " + className);
  }

  private Class<?> loadClass(String className) {
    try {
      return getClassLoader().loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new CustomResourceCollectorException(e);
    }
  }

  private ClassLoader getClassLoader() {
    if (classLoader != null) {
      return classLoader;
    }

    if (!classpathElements.isEmpty()) {
      URL[] urls = classpathElements.stream()
          .map(s -> {
            try {
              return new File(s).toURI().toURL();
            } catch (MalformedURLException e) {
              throw new CustomResourceCollectorException("Could not transform file to URL: " + s, e);
            }
          }).toArray(URL[]::new);

      if (parentClassLoader != null) {
        this.classLoader = new URLClassLoader(urls, parentClassLoader);
      } else {
        this.classLoader = new URLClassLoader(urls);
      }
    } else {
      if (parentClassLoader != null) {
        this.classLoader = parentClassLoader;
      } else {
        this.classLoader = Thread.currentThread().getContextClassLoader();
      }
    }

    return classLoader;
  }

}
