package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JSONSchemaPropsOrArrayBuilder extends JSONSchemaPropsOrArrayFluent<JSONSchemaPropsOrArrayBuilder> implements VisitableBuilder<JSONSchemaPropsOrArray,JSONSchemaPropsOrArrayBuilder>{

  JSONSchemaPropsOrArrayFluent<?> fluent;

  public JSONSchemaPropsOrArrayBuilder() {
    this(new JSONSchemaPropsOrArray());
  }
  
  public JSONSchemaPropsOrArrayBuilder(JSONSchemaPropsOrArrayFluent<?> fluent) {
    this(fluent, new JSONSchemaPropsOrArray());
  }
  
  public JSONSchemaPropsOrArrayBuilder(JSONSchemaPropsOrArray instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JSONSchemaPropsOrArrayBuilder(JSONSchemaPropsOrArrayFluent<?> fluent,JSONSchemaPropsOrArray instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JSONSchemaPropsOrArray build() {
    JSONSchemaPropsOrArray buildable = new JSONSchemaPropsOrArray(fluent.buildJSONSchemas(), fluent.buildSchema());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}