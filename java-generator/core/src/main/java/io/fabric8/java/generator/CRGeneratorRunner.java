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
package io.fabric8.java.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import io.fabric8.java.generator.nodes.GeneratorResult;
import io.fabric8.java.generator.nodes.JCRObject;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;

public class CRGeneratorRunner {

  private final Config config;
  private static final List<String> STD_PROPS = Arrays.asList("metadata", "spec", "status", "apiVersion", "kind");
  
  public CRGeneratorRunner(Config config) {
    this.config = config;
  }

  public List<WritableCRCompilationUnit> generate(CustomResourceDefinition crd, String basePackageName) {
    CustomResourceDefinitionSpec crSpec = crd.getSpec();
    String crName = crSpec.getNames().getKind();
    String group = crSpec.getGroup();
    String scope = crSpec.getScope();

    List<WritableCRCompilationUnit> writableCUs = new ArrayList<>(crSpec.getVersions().size());
    for (CustomResourceDefinitionVersion crdv : crSpec.getVersions()) {
      String version = crdv.getName();

      String pkgNotOverridden = Optional.ofNullable(basePackageName)
              .map(p -> p + "." + version)
              .orElse(version);

      String pkg;
      if (config.getPackageOverrides().containsKey(pkgNotOverridden)) {
    	  pkg = config.getPackageOverrides().get(pkgNotOverridden);
      } else {
    	  pkg = pkgNotOverridden;
      }

      AbstractJSONSchema2Pojo specGenerator = null;

      JSONSchemaProps spec = crdv.getSchema().getOpenAPIV3Schema().getProperties().get("spec");
      if (spec != null) {
        specGenerator = AbstractJSONSchema2Pojo.fromJsonSchema(
            crName + "Spec", spec, pkg, config);
      }

      AbstractJSONSchema2Pojo statusGenerator = null;
      JSONSchemaProps status = crdv.getSchema().getOpenAPIV3Schema().getProperties().get("status");
      if (status != null) {
        statusGenerator = AbstractJSONSchema2Pojo.fromJsonSchema(
            crName + "Status", status, pkg, config);
      }

      boolean preserveUnknownFields = Boolean.TRUE.equals(crdv.getSchema().getOpenAPIV3Schema().getXKubernetesPreserveUnknownFields());
      
      Map<String, JSONSchemaProps> topLevelProps = crdv.getSchema().getOpenAPIV3Schema().getProperties().entrySet().stream()
    	.filter(e -> !STD_PROPS.contains(e.getKey()))
    	.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

      List<String> requiredTopLevelProps = crdv.getSchema().getOpenAPIV3Schema().getRequired().stream()
      	.filter(prop -> !STD_PROPS.contains(prop))
      	.collect(Collectors.toList());
      
      AbstractJSONSchema2Pojo crGenerator = new JCRObject(
          pkg,
          crName,
          group,
          version,
          scope,
          crName + "Spec",
          crName + "Status",
          topLevelProps,
          requiredTopLevelProps,
          preserveUnknownFields,
          crdv.getSchema().getOpenAPIV3Schema().getDescription(),
          specGenerator != null,
          statusGenerator != null,
          crdv.getStorage(),
          crdv.getServed(),
          crSpec.getNames().getSingular(),
          crSpec.getNames().getPlural(),
          config);

      List<GeneratorResult.ClassResult> classResults = validateAndAggregate(crGenerator, specGenerator, statusGenerator);

      writableCUs.add(new WritableCRCompilationUnit(classResults, basePackageName));
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
