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
package io.fabric8.kubernetes.client.dsl.internal.batch.v1;

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JobOperationsImplTest {

  @Test
  void testGetJobPodLabels() {
    // Given
    Job job = getMockedJob();

    // When
    Map<String, String> labels = JobOperationsImpl.getJobPodLabels(job);

    // Then
    assertNotNull(labels);
    assertEquals(1, labels.size());
    assertEquals(job.getMetadata().getUid(), labels.get("controller-uid"));
  }

  private Job getMockedJob() {
    return new JobBuilder()
        .withNewMetadata()
        .addToLabels("controller-uid", "63e8e54b-bc7a-4bb3-a7ad-2ea5f0b5b591")
        .addToLabels("job-name", "pi")
        .withName("pi")
        .withUid("63e8e54b-bc7a-4bb3-a7ad-2ea5f0b5b591")
        .endMetadata()
        .build();
  }

}
