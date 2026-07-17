package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerStatusBuilder extends APIServerStatusFluent<APIServerStatusBuilder> implements VisitableBuilder<APIServerStatus,APIServerStatusBuilder>{

  APIServerStatusFluent<?> fluent;

  public APIServerStatusBuilder() {
    this(new APIServerStatus());
  }
  
  public APIServerStatusBuilder(APIServerStatusFluent<?> fluent) {
    this(fluent, new APIServerStatus());
  }
  
  public APIServerStatusBuilder(APIServerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerStatusBuilder(APIServerStatusFluent<?> fluent,APIServerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerStatus build() {
    APIServerStatus buildable = new APIServerStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}