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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;

public class TestOrder {
  public static void main(String[] args) {
    Template t = new TemplateBuilder()
      .addNewServiceObject().endServiceObject()
      .addNewReplicationControllerObject().endReplicationControllerObject()
      .addNewServiceAccountObject().endServiceAccountObject()
      .build();

    for (HasMetadata o : t.getObjects()) {
      System.out.println(o.getClass().getSimpleName());
    }
  }
}
