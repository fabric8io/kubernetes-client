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
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDeserialization {

  @Test
  public void kustomizeDeserializationTest() throws Exception {
    ObjectMapper mapper = new ObjectMapper(
        new YAMLFactory().disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID));
    final Kustomization kustomization = mapper.readValue(this.getClass().getResourceAsStream("/kustomization.yaml"),
        Kustomization.class);
    Assertions.assertEquals(1, kustomization.getReplacements().size());
    Assertions.assertEquals(1, kustomization.getReplacements().get(0).getTargets().size());
    Assertions.assertEquals(1, kustomization.getReplacements().get(0).getTargets().get(0).getFieldPaths().size());
    Assertions.assertEquals("spec.volumes.[name=.*].azureFile.shareName",
        kustomization.getReplacements().get(0).getTargets().get(0).getFieldPaths().get(0));
  }
}
