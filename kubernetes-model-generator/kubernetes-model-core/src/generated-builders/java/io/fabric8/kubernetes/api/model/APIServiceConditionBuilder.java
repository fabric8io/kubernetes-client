package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceConditionBuilder extends APIServiceConditionFluent<APIServiceConditionBuilder> implements VisitableBuilder<APIServiceCondition,APIServiceConditionBuilder>{

  APIServiceConditionFluent<?> fluent;

  public APIServiceConditionBuilder() {
    this(new APIServiceCondition());
  }
  
  public APIServiceConditionBuilder(APIServiceConditionFluent<?> fluent) {
    this(fluent, new APIServiceCondition());
  }
  
  public APIServiceConditionBuilder(APIServiceCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceConditionBuilder(APIServiceConditionFluent<?> fluent,APIServiceCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceCondition build() {
    APIServiceCondition buildable = new APIServiceCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}