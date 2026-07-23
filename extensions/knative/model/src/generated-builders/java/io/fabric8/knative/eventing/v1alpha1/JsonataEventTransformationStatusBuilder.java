package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JsonataEventTransformationStatusBuilder extends JsonataEventTransformationStatusFluent<JsonataEventTransformationStatusBuilder> implements VisitableBuilder<JsonataEventTransformationStatus,JsonataEventTransformationStatusBuilder>{

  JsonataEventTransformationStatusFluent<?> fluent;

  public JsonataEventTransformationStatusBuilder() {
    this(new JsonataEventTransformationStatus());
  }
  
  public JsonataEventTransformationStatusBuilder(JsonataEventTransformationStatusFluent<?> fluent) {
    this(fluent, new JsonataEventTransformationStatus());
  }
  
  public JsonataEventTransformationStatusBuilder(JsonataEventTransformationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JsonataEventTransformationStatusBuilder(JsonataEventTransformationStatusFluent<?> fluent,JsonataEventTransformationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JsonataEventTransformationStatus build() {
    JsonataEventTransformationStatus buildable = new JsonataEventTransformationStatus(fluent.getDeployment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}