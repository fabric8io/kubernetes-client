package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIEndpointBuilder extends APIEndpointFluent<APIEndpointBuilder> implements VisitableBuilder<APIEndpoint,APIEndpointBuilder>{

  APIEndpointFluent<?> fluent;

  public APIEndpointBuilder() {
    this(new APIEndpoint());
  }
  
  public APIEndpointBuilder(APIEndpointFluent<?> fluent) {
    this(fluent, new APIEndpoint());
  }
  
  public APIEndpointBuilder(APIEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIEndpointBuilder(APIEndpointFluent<?> fluent,APIEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIEndpoint build() {
    APIEndpoint buildable = new APIEndpoint(fluent.getHost(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}