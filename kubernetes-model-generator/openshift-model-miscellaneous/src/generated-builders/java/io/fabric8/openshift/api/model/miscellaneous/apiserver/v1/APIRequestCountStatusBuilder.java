package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIRequestCountStatusBuilder extends APIRequestCountStatusFluent<APIRequestCountStatusBuilder> implements VisitableBuilder<APIRequestCountStatus,APIRequestCountStatusBuilder>{

  APIRequestCountStatusFluent<?> fluent;

  public APIRequestCountStatusBuilder() {
    this(new APIRequestCountStatus());
  }
  
  public APIRequestCountStatusBuilder(APIRequestCountStatusFluent<?> fluent) {
    this(fluent, new APIRequestCountStatus());
  }
  
  public APIRequestCountStatusBuilder(APIRequestCountStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIRequestCountStatusBuilder(APIRequestCountStatusFluent<?> fluent,APIRequestCountStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIRequestCountStatus build() {
    APIRequestCountStatus buildable = new APIRequestCountStatus(fluent.getConditions(), fluent.buildCurrentHour(), fluent.buildLast24h(), fluent.getRemovedInRelease(), fluent.getRequestCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}