package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceStatusBuilder extends APIServiceStatusFluent<APIServiceStatusBuilder> implements VisitableBuilder<APIServiceStatus,APIServiceStatusBuilder>{

  APIServiceStatusFluent<?> fluent;

  public APIServiceStatusBuilder() {
    this(new APIServiceStatus());
  }
  
  public APIServiceStatusBuilder(APIServiceStatusFluent<?> fluent) {
    this(fluent, new APIServiceStatus());
  }
  
  public APIServiceStatusBuilder(APIServiceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceStatusBuilder(APIServiceStatusFluent<?> fluent,APIServiceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceStatus build() {
    APIServiceStatus buildable = new APIServiceStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}