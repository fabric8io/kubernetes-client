package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointsVisibilityBuilder extends EndpointsVisibilityFluent<EndpointsVisibilityBuilder> implements VisitableBuilder<EndpointsVisibility,EndpointsVisibilityBuilder>{

  EndpointsVisibilityFluent<?> fluent;

  public EndpointsVisibilityBuilder() {
    this(new EndpointsVisibility());
  }
  
  public EndpointsVisibilityBuilder(EndpointsVisibilityFluent<?> fluent) {
    this(fluent, new EndpointsVisibility());
  }
  
  public EndpointsVisibilityBuilder(EndpointsVisibility instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointsVisibilityBuilder(EndpointsVisibilityFluent<?> fluent,EndpointsVisibility instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointsVisibility build() {
    EndpointsVisibility buildable = new EndpointsVisibility(fluent.getPrivate(), fluent.getPublic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}