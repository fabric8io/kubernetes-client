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
package io.fabric8.it.dummy;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import io.argoproj.v1alpha1.Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestToplevelFields {

  @Test
  void testHasOperationField() {
    try {
			Application.class.getField("operation");
		} catch (NoSuchFieldException e) {
      e.printStackTrace();
			fail("No field operation");
		} 
  }
  @Test
  void testHasOperationGetter() {
    try {
      Application.class.getMethod("getOperation", null);
		} catch (NoSuchMethodException e) {
      e.printStackTrace();
			fail("No getter for operation");
		} 
  }

  @Test
  void testHasOperationSetter() {
    try {
      Application.class.getMethod("setOperation", null);
		} catch (NoSuchMethodException e) {
      e.printStackTrace();
			fail("No setter for operation");
		} 
  }
}
