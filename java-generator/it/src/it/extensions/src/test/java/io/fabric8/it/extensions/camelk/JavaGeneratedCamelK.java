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
package io.fabric8.it.extensions.camelk;

import org.apache.camel.v1.CamelCatalog;
import org.apache.camel.v1.CamelCatalogBuilder;
import org.apache.camel.v1.CamelCatalogSpecBuilder;
import org.apache.camel.v1.camelcatalogspec.ArtifactsBuilder;
import org.apache.camel.v1.camelcatalogspec.RuntimeBuilder;
import org.apache.camel.v1.camelcatalogspec.artifacts.dependencies.ExclusionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;

public class JavaGeneratedCamelK {

  // Code generated with
  // ./java-generator/cli/target/java-gen -t="java-generator/it/src/main/java" -s="java-generator/it/src/it/extensions/src/test/resources/camel-k.crds.1.8.1.yaml" --add-extra-annotations

  public static CamelCatalog dummyCamelKCatalog() {
    CamelCatalog camelCatalog = new CamelCatalogBuilder()
      .withNewMetadata()
      .withName("dummy")
      .endMetadata()
      .withNewSpec()
      .addToArtifacts("artifact1",
        new ArtifactsBuilder()
          .withArtifactId("artifact1ID")
          .withDataformats("dataformat1")
          .withDependencies(
            new org.apache.camel.v1.camelcatalogspec.artifacts.DependenciesBuilder()
              .withArtifactId("artifact2")
              .withGroupId("mygroupid")
              .withVersion("1.0.0")
              .withExclusions(
                new ExclusionsBuilder()
                  .withArtifactId("artifact3")
                  .build()
              )
              .build()
          )
          .withGroupId("mygroupid")
          .withJavaTypes("javatype1", "javatype2")
          .withLanguages("java", "kotlin")
          .build()
      )
      .withRuntime(
        new RuntimeBuilder()
          .withVersion("2.0.0")
          .withProvider("myprovider")
          .withDependencies(
            new org.apache.camel.v1.camelcatalogspec.runtime.DependenciesBuilder()
              .withArtifactId("aid")
              .withGroupId("gid")
              .withVersion("v")
              .build()
          )
          .build()
      )
      .endSpec()
      .build();

    return camelCatalog;
  }
  
}
