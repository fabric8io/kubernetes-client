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
package io.fabric8.java.generator;

import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import io.fabric8.java.generator.nodes.GeneratorResult;
import io.fabric8.java.generator.nodes.JCRObject;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CRGeneratorRunner {

  private final Config config;

  public CRGeneratorRunner(Config config) {
    this.config = config;
  }

  public List<WritableCRCompilationUnit> generate(CustomResourceDefinition crd, String basePackageName) {
    CustomResourceDefinitionSpec crSpec = crd.getSpec();
    String crName = crSpec.getNames().getKind();
    String group = crSpec.getGroup();

    List<WritableCRCompilationUnit> writableCUs = new ArrayList<>(crSpec.getVersions().size());
    for (CustomResourceDefinitionVersion crdv : crSpec.getVersions()) {
      String version = crdv.getName();

      String pkg = Optional.ofNullable(basePackageName)
          .map(p -> p + "." + version)
          .orElse(version);

      if (config.getPackageOverrides().containsKey(pkg)) {
        pkg = config.getPackageOverrides().get(pkg);
      }

      AbstractJSONSchema2Pojo specGenerator = null;

      String prefix = crName;
      if (config.getPrefixStrategy() == Config.Prefix.NEVER) {
        prefix = "";
      }

      JSONSchemaProps spec = crdv.getSchema().getOpenAPIV3Schema().getProperties().get("spec");
      if (spec != null) {
        String suffix = (config.getSuffixStrategy() != Config.Suffix.NEVER) ? "Spec" : "";
        specGenerator = AbstractJSONSchema2Pojo.fromJsonSchema(
            "spec", spec, pkg, prefix, suffix, config);
      }

      AbstractJSONSchema2Pojo statusGenerator = null;
      JSONSchemaProps status = crdv.getSchema().getOpenAPIV3Schema().getProperties().get("status");
      if (status != null) {
        String suffix = (config.getSuffixStrategy() != Config.Suffix.NEVER) ? "Status" : "";
        statusGenerator = AbstractJSONSchema2Pojo.fromJsonSchema(
            "status", status, pkg, prefix, suffix, config);
      }

      AbstractJSONSchema2Pojo crGenerator = new JCRObject(
          pkg,
          crName,
          group,
          version,
          prefix + "Spec",
          prefix + "Status",
          specGenerator != null,
          statusGenerator != null,
          crdv.getStorage(),
          crdv.getServed(),
          crSpec.getNames().getSingular(),
          crSpec.getNames().getPlural(),
          config);

      List<GeneratorResult.ClassResult> classResults = validateAndAggregate(crGenerator, specGenerator, statusGenerator);

      writableCUs.add(new WritableCRCompilationUnit(classResults));
    }

    return writableCUs;
  }

  private List<GeneratorResult.ClassResult> validateAndAggregate(
      AbstractJSONSchema2Pojo... generators) {
    return Arrays.stream(generators)
        .filter(Objects::nonNull)
        .map(AbstractJSONSchema2Pojo::generateJava)
        .map(CRGeneratorRunner::validateTopLevel)
        .flatMap(g -> g.getTopLevelClasses().stream())
        .collect(Collectors.toList());
  }

  private static GeneratorResult validateTopLevel(GeneratorResult generatorResult) {
    if (!generatorResult.getInnerClasses().isEmpty()) {
      throw new JavaGeneratorException(
          "Unmatched inner class spilled up to top level "
              + generatorResult.getInnerClasses().get(0));
    }
    return generatorResult;
  }

  protected static String groupToPackage(String group) {
    final List<String> groupElements = Arrays.asList(group.replace('-', '_').split("\\."));

    Collections.reverse(groupElements);
    return String.join(".", groupElements);
  }
}
