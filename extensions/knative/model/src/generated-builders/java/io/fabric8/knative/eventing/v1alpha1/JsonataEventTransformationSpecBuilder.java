package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JsonataEventTransformationSpecBuilder extends JsonataEventTransformationSpecFluent<JsonataEventTransformationSpecBuilder> implements VisitableBuilder<JsonataEventTransformationSpec,JsonataEventTransformationSpecBuilder>{

  JsonataEventTransformationSpecFluent<?> fluent;

  public JsonataEventTransformationSpecBuilder() {
    this(new JsonataEventTransformationSpec());
  }
  
  public JsonataEventTransformationSpecBuilder(JsonataEventTransformationSpecFluent<?> fluent) {
    this(fluent, new JsonataEventTransformationSpec());
  }
  
  public JsonataEventTransformationSpecBuilder(JsonataEventTransformationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JsonataEventTransformationSpecBuilder(JsonataEventTransformationSpecFluent<?> fluent,JsonataEventTransformationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JsonataEventTransformationSpec build() {
    JsonataEventTransformationSpec buildable = new JsonataEventTransformationSpec(fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}