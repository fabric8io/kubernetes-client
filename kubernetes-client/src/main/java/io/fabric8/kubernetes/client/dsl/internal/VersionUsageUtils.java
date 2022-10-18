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
package io.fabric8.kubernetes.client.dsl.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class to monitor alpha/beta version usage and log.
 */
public final class VersionUsageUtils {

  private static final Logger LOG = LoggerFactory.getLogger(VersionUsageUtils.class);

  private static final ConcurrentHashMap<String, Boolean> UNSTABLE_TYPES = new ConcurrentHashMap<>();

  private static final boolean LOG_EACH_USAGE = false;

  private VersionUsageUtils() {
  }

  public static void log(String type, String version) {
    if (type == null || version == null) {
      return;
    }

    if (isUnstable(version)) {
      if (LOG_EACH_USAGE || UNSTABLE_TYPES.putIfAbsent(type + "-" + version, true) == null) {
        alert(type, version);
      }
    }
  }

  private static boolean isUnstable(String version) {
    String lowerCaseVersion = version.toLowerCase(Locale.ROOT);
    return lowerCaseVersion.contains("beta") || lowerCaseVersion.contains("alpha");
  }

  private static void alert(String type, String version) {
    String message = "The client is using resource type '{}' with unstable version '{}'";
    if (type.equals("customresourcedefinitions") && version.equals("v1beta1")) {
      LOG.debug(message, type, version);
    } else {
      LOG.warn(message, type, version);
    }
  }

}
