package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JSONSchemaPropsOrStringArrayBuilder extends JSONSchemaPropsOrStringArrayFluent<JSONSchemaPropsOrStringArrayBuilder> implements VisitableBuilder<JSONSchemaPropsOrStringArray,JSONSchemaPropsOrStringArrayBuilder>{

  JSONSchemaPropsOrStringArrayFluent<?> fluent;

  public JSONSchemaPropsOrStringArrayBuilder() {
    this(new JSONSchemaPropsOrStringArray());
  }
  
  public JSONSchemaPropsOrStringArrayBuilder(JSONSchemaPropsOrStringArrayFluent<?> fluent) {
    this(fluent, new JSONSchemaPropsOrStringArray());
  }
  
  public JSONSchemaPropsOrStringArrayBuilder(JSONSchemaPropsOrStringArray instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JSONSchemaPropsOrStringArrayBuilder(JSONSchemaPropsOrStringArrayFluent<?> fluent,JSONSchemaPropsOrStringArray instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JSONSchemaPropsOrStringArray build() {
    JSONSchemaPropsOrStringArray buildable = new JSONSchemaPropsOrStringArray(fluent.getProperty(), fluent.buildSchema());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}