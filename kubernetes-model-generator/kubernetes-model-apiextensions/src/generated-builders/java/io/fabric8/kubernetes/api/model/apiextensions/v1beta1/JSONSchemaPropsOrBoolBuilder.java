package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JSONSchemaPropsOrBoolBuilder extends JSONSchemaPropsOrBoolFluent<JSONSchemaPropsOrBoolBuilder> implements VisitableBuilder<JSONSchemaPropsOrBool,JSONSchemaPropsOrBoolBuilder>{

  JSONSchemaPropsOrBoolFluent<?> fluent;

  public JSONSchemaPropsOrBoolBuilder() {
    this(new JSONSchemaPropsOrBool());
  }
  
  public JSONSchemaPropsOrBoolBuilder(JSONSchemaPropsOrBoolFluent<?> fluent) {
    this(fluent, new JSONSchemaPropsOrBool());
  }
  
  public JSONSchemaPropsOrBoolBuilder(JSONSchemaPropsOrBool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JSONSchemaPropsOrBoolBuilder(JSONSchemaPropsOrBoolFluent<?> fluent,JSONSchemaPropsOrBool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JSONSchemaPropsOrBool build() {
    JSONSchemaPropsOrBool buildable = new JSONSchemaPropsOrBool(fluent.getAllows(), fluent.buildSchema());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}