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
package io.fabric8.java.generator.testing.extensions.camlek;

import io.fabric8.camelk.v1.CamelArtifactBuilder;
import io.fabric8.camelk.v1.CamelArtifactDependencyBuilder;
import io.fabric8.camelk.v1.CamelArtifactExclusionBuilder;
import io.fabric8.camelk.v1.CamelCatalog;
import io.fabric8.camelk.v1.CamelCatalogBuilder;
import io.fabric8.camelk.v1.MavenArtifactBuilder;

public class ExtensionCamelK {

  public static CamelCatalog dummyCamelKCatalog() {
    CamelCatalog camelkCatalog = new CamelCatalogBuilder()
        .withNewMetadata()
        .withName("dummy")
        .endMetadata()
        .withNewSpec()
        .addToArtifacts("artifact1",
            new CamelArtifactBuilder()
                .withArtifactId("artifact1ID")
                .withDataformats("dataformat1")
                .withDependencies(
                    new CamelArtifactDependencyBuilder()
                        .withArtifactId("artifact2")
                        .withGroupId("mygroupid")
                        .withVersion("1.0.0")
                        .withExclusions(
                            new CamelArtifactExclusionBuilder()
                                .withArtifactId("artifact3")
                                .build())
                        .build())
                .withGroupId("mygroupid")
                .withJavaTypes("javatype1", "javatype2")
                .withLanguages("java", "kotlin")
                .build())
        .withNewRuntime()
        .withVersion("2.0.0")
        .withProvider("myprovider")
        .withDependencies(
            new MavenArtifactBuilder()
                .withArtifactId("aid")
                .withGroupId("gid")
                .withVersion("v")
                .build())
        .endRuntime()
        .endSpec()
        .build();

    return camelkCatalog;
  }
}
