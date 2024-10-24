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

import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class KubeConfigFileTest {

  private KubeConfigFile kubeConfig;
  private KubeConfigFile noFileConfig;

  @BeforeEach
  void setUp() throws URISyntaxException {
    Path path = Paths.get(Objects.requireNonNull(ConfigTest.class.getResource("/test-kubeconfig")).toURI());
    this.kubeConfig = new KubeConfigFile(path.toFile());
    this.noFileConfig = new KubeConfigFile(new File("bogus"));
  }

  @Test
  void isReadable_whenFileDoesNotExist_returnsFalse() {
    // given
    // when
    boolean readable = noFileConfig.isReadable();
    // then
    assertThat(readable).isFalse();
  }

  @Test
  void isReadable_whenFileIsDirectory_returnsFalse() {
    // given
    KubeConfigFile config = new KubeConfigFile(new File(System.getProperty("user.dir")));
    // when
    boolean readable = config.isReadable();
    // then
    assertThat(readable).isFalse();
  }

  @Test
  void isReadable_whenFileExist_returnsTrue() {
    // given
    boolean readable = kubeConfig.isReadable();
    // then
    assertThat(readable).isTrue();
  }

  @Test
  void getConfig_whenFileExists_returnsConfig() {
    // given
    Config config = kubeConfig.getConfig();
    // then
    assertThat(config).isNotNull();
  }

  @Test
  void getConfig_whenGettingConfig_isParsingLazily() {
    // given
    try (MockedStatic<KubeConfigUtils> utilsMock = Mockito.mockStatic(KubeConfigUtils.class)) {
      utilsMock.verify(() -> KubeConfigUtils.parseConfig(any()), Mockito.never());
      // when
      kubeConfig.getConfig();
      // then
      utilsMock.verify(() -> KubeConfigUtils.parseConfig(kubeConfig.getFile()), Mockito.times(1));
    }
  }

  @Test
  void getConfig_whenGettingConfig_isNotParsingASecondTime() {
    // given
    try (MockedStatic<KubeConfigUtils> utilsMock = Mockito.mockStatic(KubeConfigUtils.class)) {
      kubeConfig.getConfig();
      // when
      kubeConfig.getConfig();
      // then
      utilsMock.verify(() -> KubeConfigUtils.parseConfig(kubeConfig.getFile()), Mockito.times(1));
    }
  }

  @Test
  void getConfig_whenFileDoesntExist_returnsNull() {
    // given
    Config config = noFileConfig.getConfig();
    // then
    assertThat(config).isNull();
  }

}
