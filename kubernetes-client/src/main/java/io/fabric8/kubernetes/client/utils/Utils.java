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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import io.fabric8.kubernetes.client.KubernetesClientException;


public class Utils {

  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
  private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";

  public static <T> T checkNotNull(T ref, String message) {
    if (ref == null) {
      throw new NullPointerException(message);
    }
    return ref;
  }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  public static boolean isNotNullOrEmpty(String str) {
    return !isNullOrEmpty(str);
  }

  public static String getProperty(Map<String, Object> properties, String propertyName, String defaultValue) {
    String answer = (String)properties.get(propertyName);
    if (!Utils.isNullOrEmpty(answer)) {
      return answer;
    }

    return getSystemPropertyOrEnvVar(propertyName, defaultValue);
  }

  public static String getProperty(Map<String, Object> properties, String propertyName) {
    return getProperty(properties, propertyName, null);
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
    return systemPropertyName.toUpperCase().replaceAll("[.-]", "_");
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

  public static Boolean getSystemPropertyOrEnvVar(String systemPropertyName, Boolean defaultValue) {
    String result = getSystemPropertyOrEnvVar(systemPropertyName, defaultValue.toString());
    return Boolean.parseBoolean(result);
  }

  public static int getSystemPropertyOrEnvVar(String systemPropertyName, int defaultValue) {
    String result = getSystemPropertyOrEnvVar(systemPropertyName, new Integer(defaultValue).toString());
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
   * @param queue     The communication channel.
   * @param amount    The amount of time to wait.
   * @param timeUnit  The time unit.
     */
  public static boolean waitUntilReady(BlockingQueue<Object> queue, long amount, TimeUnit timeUnit) {
    try {
      Object obj = queue.poll(amount, timeUnit);
      if (obj instanceof Boolean) {
        return (Boolean) obj;
      } else if (obj instanceof Throwable) {
        throw (Throwable) obj;
      }
      return false;
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  /**
   * Closes the specified {@link ExecutorService}.
   * @param executorService   The executorService.
   * @return                  True if shutdown is complete.
   */
  public static boolean shutdownExecutorService(ExecutorService executorService) {
    if (executorService == null) {
      return false;
    }
    //If it hasn't already shutdown, do shutdown.
    if (!executorService.isShutdown()) {
      executorService.shutdown();
    }

    try {
      //Wait for clean termination
      if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
        return true;
      }

      //If not already terminated (via shutdownNow) do shutdownNow.
      if (!executorService.isTerminated()) {
        executorService.shutdownNow();
      }

      if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
        return true;
      }

      if (LOGGER.isDebugEnabled()) {
        List<Runnable> tasks = executorService.shutdownNow();
        if (!tasks.isEmpty()) {
          LOGGER.debug("ExecutorService was not cleanly shutdown, after waiting for 10 seconds. Number of remaining tasks:" + tasks.size());
        }
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      //Preserve interrupted status
      Thread.currentThread().interrupt();
    }
    return false;
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
        LOGGER.debug("Error closing:" + c);
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


  /**
   * Replaces all occurrencies of the from text with to text without any regular expressions
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

  public static String randomString(int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(ALL_CHARS.length());
      sb.append(ALL_CHARS.charAt(index));
    }
    return sb.toString();
  }

  public static String randomString(String prefix, int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length - prefix.length(); i++) {
      int index = random.nextInt(ALL_CHARS.length());
      sb.append(ALL_CHARS.charAt(index));
    }
    return sb.toString();
  }
}
