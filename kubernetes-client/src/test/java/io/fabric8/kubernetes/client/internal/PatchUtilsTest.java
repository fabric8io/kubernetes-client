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

package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.client.dsl.internal.PatchUtils;
import io.fabric8.kubernetes.client.dsl.internal.PatchUtils.Format;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatchUtilsTest {

  @Test
  void testOmitStatus() {
    ReplicationController rc = new ReplicationControllerBuilder().withNewStatus().withFullyLabeledReplicas(1).endStatus()
        .withNewMetadata().withName("x").endMetadata().build();
    assertEquals("---\n"
        + "apiVersion: \"v1\"\n"
        + "kind: \"ReplicationController\"\n"
        + "metadata:\n"
        + "  name: \"x\"\n"
        + "status:\n"
        + "  fullyLabeledReplicas: 1\n",
        PatchUtils.withoutRuntimeState(rc, Format.YAML, false, new KubernetesSerialization()));

    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"ReplicationController\",\"metadata\":{\"name\":\"x\"}}",
        PatchUtils.withoutRuntimeState(rc, Format.JSON, true, new KubernetesSerialization()));
  }

  @Test
  void testDiff() {
    ReplicationController rc1 = new ReplicationControllerBuilder().withNewStatus().withFullyLabeledReplicas(1).endStatus()
        .withNewMetadata().withName("x").endMetadata().build();

    ReplicationController rc2 = new ReplicationControllerBuilder(rc1).editMetadata().addToLabels("my", "label").endMetadata()
        .editStatus().withAvailableReplicas(2).endStatus().build();

    assertEquals(
        "[{\"op\":\"add\",\"path\":\"/metadata/labels\",\"value\":{\"my\":\"label\"}},{\"op\":\"add\",\"path\":\"/status/availableReplicas\",\"value\":2}]",
        PatchUtils.jsonDiff(rc1, rc2, false, new KubernetesSerialization()));
  }

  @Test
  void testDiffRemove() {
    ReplicationController rc1 = new ReplicationControllerBuilder().withNewStatus().withFullyLabeledReplicas(1).endStatus()
        .withNewMetadata().withName("x").endMetadata().build();

    ReplicationController rc2 = new ReplicationControllerBuilder(rc1).withStatus(null).build();

    assertEquals(
        "[{\"op\":\"remove\",\"path\":\"/status\"}]",
        PatchUtils.jsonDiff(rc1, rc2, false, new KubernetesSerialization()));
  }

}
