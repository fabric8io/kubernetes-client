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
package io.fabric8.kubernetes.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class KubeConfigFile {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubeConfigFile.class);

  @Getter
  private final File file;
  private boolean parsed = false;
  private Config config;

  @JsonCreator
  public KubeConfigFile(@JsonProperty("file") String file) {
    this(new File(file), null);
  }

  public KubeConfigFile(File file) {
    this(file, null);
  }

  private KubeConfigFile(File file, Config config) {
    this.file = file;
    this.config = config;
  }

  public Config getConfig() {
    if (!parsed) {
      this.config = createConfig(file);
      this.parsed = true;
    }
    return config;
  }

  private Config createConfig(File file) {
    Config created = null;
    try {
      if (isReadable(file)) {
        LOGGER.debug("Found for Kubernetes config at: [{}].", file.getPath());
        created = KubeConfigUtils.parseConfig(file);
      }
    } catch (IOException e) {
      LOGGER.debug("Kubernetes file at [{}] is not a valid config. Ignoring.", file.getPath(), e);
    }
    return created;
  }

  @JsonIgnore
  public boolean isReadable() {
    return isReadable(file);
  }

  private boolean isReadable(File file) {
    try {
      return file != null
          && file.isFile();
    } catch (SecurityException e) {
      return false;
    }
  }
}