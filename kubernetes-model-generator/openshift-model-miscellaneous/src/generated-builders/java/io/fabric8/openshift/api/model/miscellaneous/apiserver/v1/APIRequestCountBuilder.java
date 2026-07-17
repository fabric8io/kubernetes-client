package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIRequestCountBuilder extends APIRequestCountFluent<APIRequestCountBuilder> implements VisitableBuilder<APIRequestCount,APIRequestCountBuilder>{

  APIRequestCountFluent<?> fluent;

  public APIRequestCountBuilder() {
    this(new APIRequestCount());
  }
  
  public APIRequestCountBuilder(APIRequestCountFluent<?> fluent) {
    this(fluent, new APIRequestCount());
  }
  
  public APIRequestCountBuilder(APIRequestCount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIRequestCountBuilder(APIRequestCountFluent<?> fluent,APIRequestCount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIRequestCount build() {
    APIRequestCount buildable = new APIRequestCount(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}