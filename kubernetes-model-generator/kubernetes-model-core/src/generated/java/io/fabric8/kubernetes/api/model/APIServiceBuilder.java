package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceBuilder extends APIServiceFluent<APIServiceBuilder> implements VisitableBuilder<APIService,APIServiceBuilder>{

  APIServiceFluent<?> fluent;

  public APIServiceBuilder() {
    this(new APIService());
  }
  
  public APIServiceBuilder(APIServiceFluent<?> fluent) {
    this(fluent, new APIService());
  }
  
  public APIServiceBuilder(APIService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceBuilder(APIServiceFluent<?> fluent,APIService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIService build() {
    APIService buildable = new APIService(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}