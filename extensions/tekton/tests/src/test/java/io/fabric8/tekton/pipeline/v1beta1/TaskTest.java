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
package io.fabric8.tekton.pipeline.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

  @Test
  void testTaskFromJSON() throws IOException {
    InputStream is = TaskTest.class.getResourceAsStream("/task-v1beta1.json");
    ObjectMapper mapper = new ObjectMapper();
    Task task = mapper.readValue(is, Task.class);
    assertEquals("Task", task.getKind());
    assertEquals("tekton.dev/v1beta1", task.getApiVersion());

    List<Step> steps = task.getSpec().getSteps();
    assertEquals(1, steps.size());
    Step step = steps.get(0);
    assertEquals("echo", step.getName());
    assertEquals("ubuntu", step.getImage());
    List<String> command = step.getCommand();
    assertEquals(1, command.size());
    assertEquals("echo", command.get(0));
    List<String> args = step.getArgs();
    assertEquals(1, args.size());
    assertEquals("hello world", args.get(0));
  }

}
