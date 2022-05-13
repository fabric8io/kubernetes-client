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
package io.fabric8.java.generator.cli;

import io.fabric8.java.generator.CRGeneratorRunner;
import io.fabric8.java.generator.Config;
import io.quarkus.runtime.annotations.RegisterForReflection;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

@Command(name = "java-gen", mixinStandardHelpOptions = true, helpCommand = true, versionProvider = KubernetesClientVersionProvider.class)
@RegisterForReflection(targets = {
    io.fabric8.java.generator.cli.KubernetesClientVersionProvider.class,
    io.fabric8.kubernetes.api.model.FieldsV1.class,
    io.fabric8.kubernetes.api.model.HasMetadata.class,
    io.fabric8.kubernetes.api.model.KubernetesResource.class,
    io.fabric8.kubernetes.api.model.ManagedFieldsEntry.class,
    io.fabric8.kubernetes.api.model.ObjectMeta.class,
    io.fabric8.kubernetes.api.model.OwnerReference.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceConversion.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionCondition.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionStatus.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceSubresourceScale.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceSubresourceStatus.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceSubresources.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceValidation.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.ExternalDocumentation.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Serializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Deserializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Serializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Deserializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Serializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.ServiceReference.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.WebhookClientConfig.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1.WebhookConversion.class,
    io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition.class,
    io.fabric8.kubernetes.internal.KubernetesDeserializer.class
})
public class GenerateJavaSources implements Runnable {

  @Option(names = { "-s",
      "--source" }, description = "The source(file or folder) with the CustomResourceDefinition(s) to use", required = true)
  File source;

  @Option(names = { "-t", "--target" }, description = "The folder to write the generated sources", required = true)
  File target;

  @Option(names = { "-enum-uppercase", "--enum-uppercase" }, description = "Uppercase the enum values", required = false)
  Boolean uppercaseEnum = null;

  @Option(names = { "-prefix-strategy",
      "--prefix-strategy" }, description = "The prefix strategy to be used", required = false, hidden = true)
  String prefixStrategy = null;

  @Option(names = { "-suffix-strategy", "--suffix-strategy" }, description = "The suffix strategy to be used", required = false)
  String suffixStrategy = null;

  @Option(names = { "-always-preserve-unknown",
      "--always-preserve-unknown" }, description = "Always preserve unknown fields in the generated classes", required = false, hidden = true)
  Boolean alwaysPreserveUnkownFields = null;

  @Option(names = { "-add-extra-annotations",
      "--add-extra-annotations" }, description = "Add extra lombok and sundrio annotation to the generated classes", required = false)
  Boolean addExtraAnnotations = null;

  @Option(names = { "-code-structure",
      "--code-structure" }, description = "Generate classes using a specific layout", required = false, hidden = true)
  String codeStructure = null;

  @Override
  public void run() {
    final Config.Prefix pSt = (prefixStrategy != null) ? Config.Prefix.valueOf(prefixStrategy) : null;
    final Config.Suffix sSt = (suffixStrategy != null) ? Config.Suffix.valueOf(suffixStrategy) : null;
    final Config.CodeStructure structure = (codeStructure != null) ? Config.CodeStructure.valueOf(codeStructure) : null;
    final Config config = new Config(
        uppercaseEnum,
        pSt,
        sSt,
        alwaysPreserveUnkownFields,
        addExtraAnnotations,
        structure);
    final CRGeneratorRunner runner = new CRGeneratorRunner(config);
    runner.run(source, target);
  }

  public static void main(String[] args) {
    int exitCode = new CommandLine(new GenerateJavaSources()).execute(args);
    System.exit(exitCode);
  }
}
