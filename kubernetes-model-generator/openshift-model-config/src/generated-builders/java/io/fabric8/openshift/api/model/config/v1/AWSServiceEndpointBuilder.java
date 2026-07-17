package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSServiceEndpointBuilder extends AWSServiceEndpointFluent<AWSServiceEndpointBuilder> implements VisitableBuilder<AWSServiceEndpoint,AWSServiceEndpointBuilder>{

  AWSServiceEndpointFluent<?> fluent;

  public AWSServiceEndpointBuilder() {
    this(new AWSServiceEndpoint());
  }
  
  public AWSServiceEndpointBuilder(AWSServiceEndpointFluent<?> fluent) {
    this(fluent, new AWSServiceEndpoint());
  }
  
  public AWSServiceEndpointBuilder(AWSServiceEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSServiceEndpointBuilder(AWSServiceEndpointFluent<?> fluent,AWSServiceEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSServiceEndpoint build() {
    AWSServiceEndpoint buildable = new AWSServiceEndpoint(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}