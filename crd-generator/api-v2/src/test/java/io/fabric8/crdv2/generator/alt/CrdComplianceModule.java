package io.fabric8.crdv2.generator.alt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.victools.jsonschema.generator.Module;
import com.github.victools.jsonschema.generator.SchemaGenerationContext;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;

/**
 * Module that enforces compliance with JSONSchema dialect used by CRDs. This should be registered last so that it removes any
 * restricted attributes added by other modules.
 */
public class CrdComplianceModule implements Module {

  // attributes not supported by CRDs according to Kubernetes documentation:
  // https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#validation
  public static final List<String> RESTRICTED_ATTRIBUTES = Collections.unmodifiableList(Arrays.asList(
      "definitions",
      "dependencies",
      "deprecated",
      "discriminator",
      "id",
      "patternProperties",
      "readOnly",
      "writeOnly",
      "xml",
      "$ref",
      "uniqueItems"));

  @Override
  public void applyToConfigBuilder(SchemaGeneratorConfigBuilder builder) {
    builder.forTypesInGeneral().withTypeAttributeOverride(this::overrideAttributes);
    builder.forFields().withInstanceAttributeOverride(this::overrideAttributes);
    builder.forMethods().withInstanceAttributeOverride(this::overrideAttributes);
  }

  protected void overrideAttributes(ObjectNode attributes, Object scope, SchemaGenerationContext context) {
    RESTRICTED_ATTRIBUTES.forEach(attributes::remove);
  }
}