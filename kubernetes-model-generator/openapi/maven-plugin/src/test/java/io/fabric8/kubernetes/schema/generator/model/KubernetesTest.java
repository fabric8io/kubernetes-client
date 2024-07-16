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
package io.fabric8.kubernetes.schema.generator.model;

import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.logging.Logger;

@Disabled("Manual tests")
class KubernetesTest {

  private static final Logger logger = Logger.getLogger(KubernetesTest.class.getName());

  private GeneratorSettings.GeneratorSettingsBuilder baseSettings;

  @BeforeEach
  void setUp() {
    baseSettings = GeneratorSettings.builder()
        .logger(logger)
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .outputDirectory(new File(""))
        .packageName("io.fabric8.kubernetes.api.model")
        .builderPackage("io.fabric8.kubernetes.api.builder")
        .addBuildableReferences(true)
        .packageMapping("io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.apimachinery.pkg", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.apimachinery.pkg.apis.meta.v1", "io.fabric8.kubernetes.api.model")
        .generateJavadoc(false);
  }

  @Test
  void core() {
    new ModelGenerator(baseSettings
        .addBuildableReferences(false)
        .schema(new File("../schemas/kubernetes-config.json"))
        .schema(new File("../schemas/api-machinery-extra.json"))
        .schema(new File("../schemas/admission-registration.json"))
        .skipGenerationRegex("^io\\.k8s\\.apimachinery\\.pkg\\.runtime\\.RawExtension$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.core\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.apimachinery\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.client-go\\.tools\\.clientcmd\\.api\\.v1\\..*$") // Config
        .includeGenerationRegex("^io\\.k8s\\.kube-aggregator\\.pkg\\.apis\\.apiregistration\\..*$")
        .packageMapping("io.k8s.client-go.tools.clientcmd.api.v1", "io.fabric8.kubernetes.api.model") //Config // TODO: fix package sanitization
        .packageMapping("io.k8s.kube-aggregator.pkg.apis.apiregistration.v1", "io.fabric8.kubernetes.api.model") // TODO: fix package sanitization
        .build())
        .generate();
  }

  @Test
  void admissionRegistration() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .schema(new File("../schemas/admission-registration.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.admission\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.admissionregistration\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.authentication\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.authorization\\..*$")
        .packageMapping("io.k8s.api", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.api.authentication.v1", "io.fabric8.kubernetes.api.model.authentication")
        .build())
        .generate();
  }

  @Test
  void apiExtensions() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .schema(new File("../schemas/apiextensions.json"))
        .skipGenerationRegex("^io\\.k8s\\.apiextensions-apiserver\\.pkg\\.apis\\.apiextensions\\.v1beta1\\.JSON$")
        .skipGenerationRegex("^io\\.k8s\\.apiextensions-apiserver\\.pkg\\.apis\\.apiextensions\\.v1\\.JSON$")
        .includeGenerationRegex("^io\\.k8s\\.apiextensions-apiserver\\..*$")
        .packageMapping("io.k8s.apiextensions-apiserver.pkg.apis", "io.fabric8.kubernetes.api.model")
        .build())
        .generate();
  }

  @Test
  void apps() {
    new ModelGenerator(baseSettings
        .includeGenerationRegex("^io\\.k8s\\.api\\.apps\\..*$")
        .packageMapping("io.k8s.api.apps.v1", "io.fabric8.kubernetes.api.model.apps")
        .build())
        .generate();
  }

  @Test
  void autoscaling() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.autoscaling\\..*$")
        .packageMapping("io.k8s.api.autoscaling", "io.fabric8.kubernetes.api.model.autoscaling")
        .build())
        .generate();
  }

  @Test
  void batch() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.batch\\..*$")
        .packageMapping("io.k8s.api.batch", "io.fabric8.kubernetes.api.model.batch")
        .build())
        .generate();
  }

  @Test
  void certificates() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.certificates\\..*$")
        .packageMapping("io.k8s.api.certificates", "io.fabric8.kubernetes.api.model.certificates")
        .build())
        .generate();
  }

  @Test
  void coordination() {
    new ModelGenerator(baseSettings
        .skipGenerationRegex("^io\\.k8s\\.api\\.coordination\\.v1\\.LeaseSpec$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.coordination\\..*$")
        .packageMapping("io.k8s.api.coordination", "io.fabric8.kubernetes.api.model.coordination")
        .build())
        .generate();
  }

  @Test
  void discovery() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.discovery\\..*$")
        .packageMapping("io.k8s.api.discovery", "io.fabric8.kubernetes.api.model.discovery")
        .build())
        .generate();
  }

  @Test
  void events() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.events\\..*$")
        .packageMapping("io.k8s.api.events", "io.fabric8.kubernetes.api.model.events")
        .build())
        .generate();
  }

  @Test
  void extensions() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.17.17.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.extensions\\..*$")
        .packageMapping("io.k8s.api.extensions.v1beta1", "io.fabric8.kubernetes.api.model.extensions")
        .build())
        .generate();
  }

  @Test
  void flowControl() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.26.15.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.flowcontrol\\..*$")
        .packageMapping("io.k8s.api.flowcontrol", "io.fabric8.kubernetes.api.model.flowcontrol")
        .build())
        .generate();
  }

  @Test
  void gatewayApi() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/gateway-api.json"))
        .includeGenerationRegex("^io\\.k8s\\.sigs\\.gateway-api\\.apis\\..*$")
        .packageMapping("io.k8s.sigs.gateway-api.apis", "io.fabric8.kubernetes.api.model.gatewayapi")
        .build())
        .generate();
  }

  @Test
  void kustomize() {
    new ModelGenerator(baseSettings
        .addBuildableReferences(false)
        .clearSchemas()
        .schema(new File("../schemas/kustomize.json"))
        .includeGenerationRegex("^io\\.k8s\\.sigs\\.kustomize\\.api\\..*$")
        .packageMapping("io.k8s.sigs.kustomize.api.types", "io.fabric8.kubernetes.api.model.kustomize.v1beta1")
        .build())
        .generate();
  }

  @Test
  void metrics() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/metrics.json"))
        .includeGenerationRegex("^io\\.k8s\\.metrics\\.pkg\\.apis\\.metrics\\..*$")
        .packageMapping("io.k8s.metrics.pkg.apis.metrics", "io.fabric8.kubernetes.api.model.metrics")
        .build())
        .generate();
  }

  @Test
  void networking() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.networking\\..*$")
        .packageMapping("io.k8s.api.networking", "io.fabric8.kubernetes.api.model.networking")
        .build())
        .generate();
  }

  @Test
  void node() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.node\\..*$")
        .packageMapping("io.k8s.api.node", "io.fabric8.kubernetes.api.model.node")
        .build())
        .generate();
  }

  @Test
  void policy() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.policy\\..*$")
        .packageMapping("io.k8s.api.policy", "io.fabric8.kubernetes.api.model.policy")
        .build())
        .generate();
  }

  @Test
  void rbac() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.rbac\\..*$")
        .packageMapping("io.k8s.api.rbac.v1", "io.fabric8.kubernetes.api.model.rbac")
        .build())
        .generate();
  }

  @Test
  void resource() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.resource\\..*$")
        .packageMapping("io.k8s.api.resource", "io.fabric8.kubernetes.api.model.resource")
        .build())
        .generate();
  }

  @Test
  void scheduling() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.scheduling\\..*$")
        .packageMapping("io.k8s.api.scheduling", "io.fabric8.kubernetes.api.model.scheduling")
        .build())
        .generate();
  }

  @Test
  void storageclass() {
    new ModelGenerator(baseSettings
        .clearSchemas()
        .schema(new File("../schemas/kubernetes-1.21.14.json"))
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .includeGenerationRegex("^io\\.k8s\\.api\\.storage\\..*$")
        .includeGenerationRegex("^io\\.k8s\\.api\\.storagemigration\\..*$")
        .packageMapping("io.k8s.api.storage", "io.fabric8.kubernetes.api.model.storage")
        .packageMapping("io.k8s.api.storage.v1", "io.fabric8.kubernetes.api.model.storage")
        .packageMapping("io.k8s.api.storagemigration", "io.fabric8.kubernetes.api.model.storagemigration")
        .build())
        .generate();
  }

}
