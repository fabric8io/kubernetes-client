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

import com.github.javaparser.ast.CompilationUnit;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import io.fabric8.java.generator.nodes.GeneratorResult;
import io.fabric8.java.generator.nodes.JCRObject;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CRGeneratorRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CRGeneratorRunner.class);

    public void run(File source, File basePath) {
        try (FileInputStream fis = new FileInputStream(source)) {
            List<HasMetadata> resources = new ArrayList<>();

            Object deserialized = Serialization.unmarshal(fis, Collections.emptyMap());
            if (deserialized instanceof List) {
                resources.addAll((List<HasMetadata>) deserialized);
            } else {
                resources.add((CustomResourceDefinition) deserialized);
            }

            for (HasMetadata resource : resources) {
                if (resource.getKind()
                        .toLowerCase(Locale.ROOT)
                        .equals("customresourcedefinition")) {
                    CustomResourceDefinition crd = (CustomResourceDefinition) resource;

                    List<WritableCRCompilationUnit> writables =
                            generate(crd, getPackage(crd.getSpec().getGroup()));

                    for (WritableCRCompilationUnit w : writables) {
                        w.writeAllJavaClasses(basePath);
                    }
                } else {
                    LOGGER.warn(
                            "Not generating nothing for resource of kind: " + resource.getKind());
                }
            }
        } catch (FileNotFoundException e) {
            throw new JavaGeneratorException("File " + source.getAbsolutePath() + " not found", e);
        } catch (IOException e) {
            throw new JavaGeneratorException("Exception reading " + source.getAbsolutePath(), e);
        }
    }

    public List<WritableCRCompilationUnit> generate(
            CustomResourceDefinition crd, String basePackageName) {
        CustomResourceDefinitionSpec crSpec = crd.getSpec();
        String crName = crSpec.getNames().getKind();
        String group = crSpec.getGroup();

        List<WritableCRCompilationUnit> writableCUs = new ArrayList<>(crSpec.getVersions().size());
        for (CustomResourceDefinitionVersion crdv : crSpec.getVersions()) {
            CompilationUnit cu = new CompilationUnit();

            String version = crdv.getName();

            String pkg =
                    Optional.ofNullable(basePackageName)
                            .map(p -> p + "." + version)
                            .orElse(version);

            cu.setPackageDeclaration(pkg);

            AbstractJSONSchema2Pojo specGenerator = null;

            JSONSchemaProps spec =
                    crdv.getSchema().getOpenAPIV3Schema().getProperties().get("spec");
            if (spec != null) {
                specGenerator = AbstractJSONSchema2Pojo.fromJsonSchema("spec", spec, crName, "");
            }

            AbstractJSONSchema2Pojo statusGenerator = null;
            JSONSchemaProps status =
                    crdv.getSchema().getOpenAPIV3Schema().getProperties().get("status");
            if (status != null) {
                statusGenerator =
                        AbstractJSONSchema2Pojo.fromJsonSchema("status", status, crName, "");
            }

            AbstractJSONSchema2Pojo crGenerator =
                    new JCRObject(
                            crName,
                            group,
                            version,
                            specGenerator != null,
                            statusGenerator != null,
                            crdv.getStorage(),
                            crdv.getServed());

            List<String> classNames =
                    validateAndAggregate(cu, crGenerator, specGenerator, statusGenerator);

            writableCUs.add(new WritableCRCompilationUnit(cu, classNames));
        }

        return writableCUs;
    }

    private List<String> validateAndAggregate(
            CompilationUnit cu, AbstractJSONSchema2Pojo... generators) {
        return Arrays.stream(generators)
                .filter(Objects::nonNull)
                .map(g -> g.generateJava(cu))
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

    protected String getPackage(String group) {
        final List<String> groupElements = Arrays.asList(group.replace('-', '_').split("\\."));

        Collections.reverse(groupElements);
        return groupElements.stream().collect(Collectors.joining("."));
    }
}
