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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

public class ValidationTest {

  @Test
  public void testNodeName() throws JsonProcessingException {
    new io.fabric8.kubernetes.api.model.NodeBuilder().withNewMetadata().withName("1.0.0.1").and().build();
  }

  @Test(expected = ConstraintViolationException.class)
  public void testIllegalNodeName() throws JsonProcessingException {
    new io.fabric8.kubernetes.api.model.NodeBuilder().withNewMetadata().withName("..").and().build();
  }

}
