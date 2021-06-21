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
package io.fabric8.tekton;

import org.junit.jupiter.api.Test;

import io.fabric8.tekton.pipeline.v1beta1.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModelTest {

  @Test
  void shouldHaveBuildableContainer()  {
    Task service = new TaskBuilder()
      .withNewSpec()
      .addNewVolume()
        .withName("m2-cache")
        .withNewNfs()
          .withPath("my.nfs-server.com")
          .withNewPath("/m2")
        .endNfs()
      .endVolume()
      .addNewStep()
        .withName("maven-build")
        .withCommand("mvn")
        .withArgs("clean", "install")
        .withImage("maven:3.6.3-jdk11")
        .addNewVolumeMount()
          .withName("m2-cache")
          .withMountPath("/m2-cache")
        .endVolumeMount()
        .addNewEnv()
          .withName("FOO")
          .withValue("BAR")
        .endEnv()
      .endStep()
      .endSpec()
      .build();
    assertNotNull(service);
  }
}

