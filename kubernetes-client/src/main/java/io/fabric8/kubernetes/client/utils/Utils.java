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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
  private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
  public static final String WINDOWS = "win";
  public static final String OS_NAME = "os.name";
  public static final String PATH_WINDOWS = "Path";
  public static final String PATH_UNIX = "PATH";
  private static final Random random = new Random();
  
  private static final ExecutorService SHARED_POOL = Executors.newCachedThreadPool();
  private static final CachedSingleThreadScheduler SHARED_SCHEDULER = new CachedSingleThreadScheduler();

  private Utils() {
  }

  public static <T> T checkNotNull(T ref, String message) {
    if (ref == null) {
      throw new NullPointerException(message);
    }
    return ref;
  }

  public static String getSystemPropertyOrEnvVar(String systemPropertyName, String envVarName, String defaultValue) {
    String answer = System.getProperty(systemPropertyName);
    if (isNotNullOrEmpty(answer)) {
      return answer;
    }

    answer = System.getenv(envVarName);
    if (isNotNullOrEmpty(answer)) {
      return answer;
    }

    return defaultValue;
  }

  public static String convertSystemPropertyNameToEnvVar(String systemPropertyName) {
    return systemPropertyName.toUpperCase(Locale.ROOT).replaceAll("[.-]", "_");
  }

  public static String getEnvVar(String envVarName, String defaultValue) {
    String answer = System.getenv(envVarName);
    return isNotNullOrEmpty(answer) ? answer : defaultValue;
  }

  public static String getSystemPropertyOrEnvVar(String systemPropertyName, String defaultValue) {
    return getSystemPropertyOrEnvVar(systemPropertyName, convertSystemPropertyNameToEnvVar(systemPropertyName), defaultValue);
  }

  public static String getSystemPropertyOrEnvVar(String systemPropertyName) {
    return getSystemPropertyOrEnvVar(systemPropertyName, (String) null);
  }

  public static boolean getSystemPropertyOrEnvVar(String systemPropertyName, Boolean defaultValue) {
    String result = getSystemPropertyOrEnvVar(systemPropertyName, defaultValue.toString());
    return Boolean.parseBoolean(result);
  }

  public static int getSystemPropertyOrEnvVar(String systemPropertyName, int defaultValue) {
    String result = getSystemPropertyOrEnvVar(systemPropertyName, Integer.toString(defaultValue));
    return Integer.parseInt(result);
  }

  public static String join(final Object[] array) {
    return join(array, ',');
  }

  public static String join(final Object[] array, final char separator) {
    if (array == null) {
      return null;
    }
    if (array.length == 0) {
      return "";
    }
    final StringBuilder buf = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (i > 0) {
        buf.append(separator);
      }
      if (array[i] != null) {
        buf.append(array[i]);
      }
    }
    return buf.toString();
  }

  /**
   * Wait until an other thread signals the completion of a task.
   * If an exception is passed, it will be propagated to the caller.
   * @param future    The communication channel.
   * @param amount    The amount of time to wait.
   * @param timeUnit  The time unit.
   *
   * @return a boolean value indicating resource is ready or not.
   */
  public static boolean waitUntilReady(Future<?> future, long amount, TimeUnit timeUnit) {
    try {
      future.get(amount, timeUnit);
      return true;
    } catch (TimeoutException e) {
      return false;
    } catch (ExecutionException e) {
      Throwable t = e;
      if (e.getCause() != null) {
        t = e.getCause();
      }
      t.addSuppressed(new Throwable("waiting here"));
      throw KubernetesClientException.launderThrowable(t);      
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
  
  /**
   * Similar to {@link #waitUntilReady(Future, long, TimeUnit)}, but will always throw an exception if not ready
   */
  public static void waitUntilReadyOrFail(Future<?> future, long amount, TimeUnit timeUnit) {
    if (!waitUntilReady(future, amount, timeUnit)) {
      throw new KubernetesClientException("not ready after " + amount + " " + timeUnit);
    }
  }

  /**
   * Closes and flushes the specified {@link Closeable} items.
   * @param closeables  An {@link Iterable} of {@link Closeable} items.
   */
  public static void closeQuietly(Iterable<Closeable> closeables) {
    for (Closeable c : closeables) {
      try {
        //Check if we also need to flush
        if (c instanceof Flushable) {
          ((Flushable) c).flush();
        }

        if (c != null) {
          c.close();
        }
      } catch (IOException e) {
        LOGGER.debug("Error closing: {}", c);
      }
    }
  }

  /**
   * Closes and flushes the specified {@link Closeable} items.
   * @param closeables  An array of {@link Closeable} items.
   */
  public static void closeQuietly(Closeable... closeables) {
    closeQuietly(Arrays.asList(closeables));
  }

  public static String coalesce(String... items) {
    for (String str : items) {
      if (str != null) {
        return str;
      }
    }
    return null;
  }

  public static String randomString(int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(ALL_CHARS.length());
      sb.append(ALL_CHARS.charAt(index));
    }
    return sb.toString();
  }

  public static String randomString(String prefix, int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length - prefix.length(); i++) {
      int index = random.nextInt(ALL_CHARS.length());
      sb.append(ALL_CHARS.charAt(index));
    }
    return sb.toString();
  }

  public static String filePath(URL path) {
    try {
      return Paths.get(path.toURI()).toString();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Replaces all occurrences of the from text with to text without any regular expressions
   *
   * @param text text string
   * @param from from string
   * @param to   to string
   * @return returns processed string
   */
  public static String replaceAllWithoutRegex(String text, String from, String to) {
    if (text == null) {
      return null;
    }
    int idx = 0;
    while (true) {
      idx = text.indexOf(from, idx);
      if (idx >= 0) {
        text = text.substring(0, idx) + to + text.substring(idx + from.length());

        // lets start searching after the end of the `to` to avoid possible infinite recursion
        idx += to.length();
      } else {
        break;
      }
    }
    return text;
  }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  public static boolean isNotNullOrEmpty(Map map) {
    return !(map == null || map.isEmpty());
  }

  public static boolean isNotNullOrEmpty(String str) {
    return !isNullOrEmpty(str);
  }

  public static boolean isNotNullOrEmpty(String[] array) {
    return !(array == null || array.length == 0);
  }

  public static <T> boolean isNotNull(T... refList) {
    return Optional.ofNullable(refList)
      .map(refs -> Stream.of(refs).allMatch(Objects::nonNull))
      .orElse(false);
  }

  public static <T> T getNonNullOrElse(T obj, T defaultObj) {
    return obj != null ? obj : defaultObj;
  }

  public static String getProperty(Map<String, Object> properties, String propertyName, String defaultValue) {
    String answer = (String) properties.get(propertyName);
    if (!isNullOrEmpty(answer)) {
      return answer;
    }

    return getSystemPropertyOrEnvVar(propertyName, defaultValue);
  }

  public static String getProperty(Map<String, Object> properties, String propertyName) {
    return getProperty(properties, propertyName, null);
  }

  /**
   * Converts string to URL encoded string.
   *
   * @param str Url as string
   * @return returns encoded string
   */
  public static String toUrlEncoded(String str) {
    try {
      return URLEncoder.encode(str, StandardCharsets.UTF_8.displayName());
    } catch (UnsupportedEncodingException exception) {
      // Ignore
    }
    return null;
  }

  /**
   *
   * @param kind
   * @return
   * @deprecated use {@link io.fabric8.kubernetes.api.model.HasMetadata#getPlural(Class)}
   */
  @Deprecated
  public static String getPluralFromKind(String kind) {
    return Pluralize.toPlural(kind.toLowerCase(Locale.ROOT));
  }

  /**
   * Reads @Namespaced annotation in resource class to check whether
   * resource is namespaced or not
   *
   * @param kubernetesResourceType class for resource
   * @return boolean value indicating it's namespaced or not
   */
  public static boolean isResourceNamespaced(Class kubernetesResourceType) {
    return Namespaced.class.isAssignableFrom(kubernetesResourceType);
  }

  public static String getAnnotationValue(Class kubernetesResourceType, Class annotationClass) {
    Annotation annotation = kubernetesResourceType.getAnnotation(annotationClass);
    if (annotation instanceof Group) {
      return ((Group) annotation).value();
    } else if (annotation instanceof Version) {
      return ((Version) annotation).value();
    }
    return null;
  }

  /**
   * Interpolates a String containing variable placeholders with the values provided in the valuesMap.
   *
   * <p> This method is intended to interpolate templates loaded from YAML and JSON files.
   *
   * <p> Placeholders are indicated by the dollar sign and curly braces ({@code ${VARIABLE_KEY}}).
   *
   * <p> Placeholders can also be indicated by the dollar sign and double curly braces ({@code ${{VARIABLE_KEY}}}),
   * when this notation is used, the resulting value will be unquoted (if applicable), expected values should be JSON
   * compatible.
   *
   * @see <a href="https://docs.openshift.com/container-platform/4.3/openshift_images/using-templates.html#templates-writing-parameters_using-templates">OpenShift Templates</a>
   * @param valuesMap to interpolate in the String
   * @param templateInput raw input containing a String with placeholders ready to be interpolated
   * @return the interpolated String
   */
  public static String interpolateString(String templateInput, Map<String, String> valuesMap) {
    return Optional.ofNullable(valuesMap).orElse(Collections.emptyMap()).entrySet().stream()
      .filter(entry -> entry.getKey() != null)
      .filter(entry -> entry.getValue() != null)
      .flatMap(entry -> {
        final String key = entry.getKey();
        final String value = entry.getValue();
        return Stream.of(
          new AbstractMap.SimpleEntry<>("${" + key + "}", value),
          new AbstractMap.SimpleEntry<>("\"${{" + key + "}}\"", value),
          new AbstractMap.SimpleEntry<>("${{" + key + "}}", value)
        );
      })
      .map(explodedParam -> (Function<String, String>) s -> s.replace(explodedParam.getKey(), explodedParam.getValue()))
      .reduce(Function.identity(), Function::andThen)
      .apply(Objects.requireNonNull(templateInput, "templateInput is required"));
  }

  /**
   * Check whether platform is windows or not
   *
   * @return boolean value indicating whether OS is Windows or not.
   */
  public static boolean isWindowsOperatingSystem() {
    return getOperatingSystemFromSystemProperty().toLowerCase().contains(WINDOWS);
  }

  /**
   * Get system PATH variable
   *
   * @return a string containing value of PATH
   */
  public static String getSystemPathVariable() {
    return System.getenv(isWindowsOperatingSystem() ? PATH_WINDOWS : PATH_UNIX);
  }

  /**
   * Returns prefixes needed to invoke specified command
   * in a subprocess.
   *
   * @return a list of strings containing prefixes
   */
  public static List<String> getCommandPlatformPrefix() {
    List<String> platformPrefixParts = new ArrayList<>();
    if (Utils.isWindowsOperatingSystem()) {
      platformPrefixParts.add("cmd.exe");
      platformPrefixParts.add("/c");
    } else {
      platformPrefixParts.add("sh");
      platformPrefixParts.add("-c");
    }
    return platformPrefixParts;
  }

  private static String getOperatingSystemFromSystemProperty() {
    return System.getProperty(OS_NAME);
  }
  
  /**
   * Create a {@link ThreadFactory} with daemon threads and a thread
   * name based upon the object passed in.
   */
  public static ThreadFactory daemonThreadFactory(Object forObject) {
    String name = forObject.getClass().getSimpleName() + "-" + System.identityHashCode(forObject);
    return daemonThreadFactory(name);
  }

  static ThreadFactory daemonThreadFactory(String name) {
    return new ThreadFactory() {
      ThreadFactory threadFactory = Executors.defaultThreadFactory();
      
      @Override
      public Thread newThread(Runnable r) {
        Thread ret = threadFactory.newThread(r); 
        ret.setName(name + "-" + ret.getName());
        ret.setDaemon(true);
        return ret;
      }
    };
  }
  
  /**
   * Schedule a task to run in the given {@link Executor} - which should run the task in a different thread as to not
   * hold the scheduling thread
   */
  public static ScheduledFuture<?> schedule(Executor executor, Runnable command, long delay, TimeUnit unit) {
    return SHARED_SCHEDULER.schedule(() -> executor.execute(command), delay, unit);
  }

  /**
   * Schedule a repeated task to run in the given {@link Executor} - which should run the task in a different thread as to not
   * hold the scheduling thread
   */
  public static ScheduledFuture<?> scheduleAtFixedRate(Executor executor, Runnable command, long initialDelay, long delay, TimeUnit unit) {
    // because of the hand-off to the other executor, there's no difference between rate and delay
    return SHARED_SCHEDULER.scheduleWithFixedDelay(() -> executor.execute(command), initialDelay, delay, unit);
  }
  
  /**
   * Get the common executor service - callers should not shutdown this service
   */
  public static ExecutorService getCommonExecutorSerive() {
    return SHARED_POOL;
  }
    
}
