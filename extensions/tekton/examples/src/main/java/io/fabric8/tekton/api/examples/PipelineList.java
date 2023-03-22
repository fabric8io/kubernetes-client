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
package io.fabric8.tekton.api.examples;

import io.fabric8.tekton.client.*;

public class PipelineList {

  public static void main(String[] args) {
    try (TektonClient client = ClientFactory.newClient(args)) {
      System.out.println("Pipelines:");
      client.v1().pipelines().list().getItems().forEach(System.out::println);
      System.out.println("done.");
    }
    System.exit(0);
  }
}
