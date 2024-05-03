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

import io.fabric8.kubernetes.client.CustomResource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class CustomResourceClassLoader {

  private final List<String> classpathList = new ArrayList<>();

  private ClassLoader parentClassLoader;

  private ClassLoader classLoader;

  public CustomResourceClassLoader withParentClassLoader(ClassLoader parentClassLoader) {
    this.parentClassLoader = parentClassLoader;
    return this;
  }

  public CustomResourceClassLoader withClasspath(String... classpaths) {
    withClasspaths(Arrays.asList(classpaths));
    return this;
  }

  public CustomResourceClassLoader withClasspaths(Collection<String> classpaths) {
    classpathList.addAll(classpaths);
    return this;
  }

  @SuppressWarnings("unchecked")
  public Class<CustomResource<?, ?>> loadCustomResourceClass(String className) {
    Class<?> clazz = loadClass(className);
    return (Class<CustomResource<?, ?>>) clazz;
  }

  private Class<?> loadClass(String className) {
    try {
      return getClassLoader().loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private ClassLoader getClassLoader() {
    if (classLoader != null) {
      return classLoader;
    }

    if (!classpathList.isEmpty()) {
      URL[] urls = classpathList.stream()
          .map(s -> {
            try {
              return new File(s).toURI().toURL();
            } catch (MalformedURLException e) {
              throw new RuntimeException(e);
            }
          }).toArray(URL[]::new);

      if (parentClassLoader != null) {
        this.classLoader = new URLClassLoader(urls, parentClassLoader);
      } else {
        this.classLoader = new URLClassLoader(urls);
      }
      return classLoader;
    }

    if (parentClassLoader != null) {
      this.classLoader = parentClassLoader;
    } else {
      this.classLoader = Thread.currentThread().getContextClassLoader();
    }

    return classLoader;
  }

}
