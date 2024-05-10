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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Allows to build a class loader to load Custom Resource classes.
 * The actual class loader is built lazy and is cached once used.
 */
class CustomResourceClassLoader {

  private static final Logger log = LoggerFactory.getLogger(CustomResourceClassLoader.class);

  private final Set<String> classpathElements = new LinkedHashSet<>();

  private ClassLoader parentClassLoader;

  private ClassLoader cachedClassLoader;

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

  /**
   * Load a Custom Resource class by its name and the previously configured class loader.
   *
   * @param className the class name of the Custom Resource class
   * @return the Custom Resource class
   */
  public Class<? extends HasMetadata> loadCustomResourceClass(String className) {
    Class<?> clazz = loadClass(className);
    if (HasMetadata.class.isAssignableFrom(clazz)) {
      return clazz.asSubclass(HasMetadata.class);
    }
    throw new CustomResourceClassLoaderException(
        "Could not load Custom Resource. Class does not implement HasMetadata: " + className);
  }

  private Class<?> loadClass(String className) {
    try {
      return getClassLoader().loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new CustomResourceClassLoaderException(e);
    }
  }

  ClassLoader getClassLoader() {
    if (cachedClassLoader == null) {
      cachedClassLoader = createClassLoader();
    }
    return cachedClassLoader;
  }

  private ClassLoader createClassLoader() {
    if (!classpathElements.isEmpty()) {
      URL[] urls = classpathElements.stream()
          .map(s -> {
            try {
              return new File(s).toURI().toURL();
            } catch (MalformedURLException e) {
              throw new CustomResourceClassLoaderException("Could not transform file to URL: " + s, e);
            }
          }).toArray(URL[]::new);
      if (parentClassLoader != null) {
        log.trace("Using URLClassLoader with parent ClassLoader {} and {}", parentClassLoader, Arrays.toString(urls));
        return new URLClassLoader(urls, parentClassLoader);
      } else {
        log.trace("Using URLClassLoader with {}", Arrays.toString(urls));
        return new URLClassLoader(urls);
      }
    } else {
      if (parentClassLoader != null) {
        log.trace("Using given ClassLoader {}", parentClassLoader);
        return parentClassLoader;
      } else {
        log.trace("Using default ClassLoader");
        return getDefaultClassLoader();
      }
    }
  }

  private ClassLoader getDefaultClassLoader() {
    return Thread.currentThread().getContextClassLoader();
  }

  public void reset() {
    classpathElements.clear();
    parentClassLoader = null;
    cachedClassLoader = null;
  }

}
