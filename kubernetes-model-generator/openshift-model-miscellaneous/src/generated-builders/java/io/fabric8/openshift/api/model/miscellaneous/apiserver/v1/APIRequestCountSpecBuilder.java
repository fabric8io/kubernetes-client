package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIRequestCountSpecBuilder extends APIRequestCountSpecFluent<APIRequestCountSpecBuilder> implements VisitableBuilder<APIRequestCountSpec,APIRequestCountSpecBuilder>{

  APIRequestCountSpecFluent<?> fluent;

  public APIRequestCountSpecBuilder() {
    this(new APIRequestCountSpec());
  }
  
  public APIRequestCountSpecBuilder(APIRequestCountSpecFluent<?> fluent) {
    this(fluent, new APIRequestCountSpec());
  }
  
  public APIRequestCountSpecBuilder(APIRequestCountSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIRequestCountSpecBuilder(APIRequestCountSpecFluent<?> fluent,APIRequestCountSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIRequestCountSpec build() {
    APIRequestCountSpec buildable = new APIRequestCountSpec(fluent.getNumberOfUsersToReport());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}