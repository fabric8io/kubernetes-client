package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JSONSchemaPropsBuilder extends JSONSchemaPropsFluent<JSONSchemaPropsBuilder> implements VisitableBuilder<JSONSchemaProps,JSONSchemaPropsBuilder>{

  JSONSchemaPropsFluent<?> fluent;

  public JSONSchemaPropsBuilder() {
    this(new JSONSchemaProps());
  }
  
  public JSONSchemaPropsBuilder(JSONSchemaPropsFluent<?> fluent) {
    this(fluent, new JSONSchemaProps());
  }
  
  public JSONSchemaPropsBuilder(JSONSchemaProps instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JSONSchemaPropsBuilder(JSONSchemaPropsFluent<?> fluent,JSONSchemaProps instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JSONSchemaProps build() {
    JSONSchemaProps buildable = new JSONSchemaProps(fluent.getRef(), fluent.getSchema(), fluent.buildAdditionalItems(), fluent.buildAdditionalProperties(), fluent.buildAllOf(), fluent.buildAnyOf(), fluent.getDefault(), fluent.getDefinitions(), fluent.getDependencies(), fluent.getDescription(), fluent.getEnum(), fluent.getExample(), fluent.getExclusiveMaximum(), fluent.getExclusiveMinimum(), fluent.buildExternalDocs(), fluent.getFormat(), fluent.getId(), fluent.buildItems(), fluent.getMaxItems(), fluent.getMaxLength(), fluent.getMaxProperties(), fluent.getMaximum(), fluent.getMinItems(), fluent.getMinLength(), fluent.getMinProperties(), fluent.getMinimum(), fluent.getMultipleOf(), fluent.buildNot(), fluent.getNullable(), fluent.buildOneOf(), fluent.getPattern(), fluent.getPatternProperties(), fluent.getProperties(), fluent.getRequired(), fluent.getTitle(), fluent.getType(), fluent.getUniqueItems(), fluent.getXKubernetesEmbeddedResource(), fluent.getXKubernetesIntOrString(), fluent.getXKubernetesListMapKeys(), fluent.getXKubernetesListType(), fluent.getXKubernetesMapType(), fluent.getXKubernetesPreserveUnknownFields(), fluent.buildXKubernetesValidations());
    return buildable;
  }
  
}