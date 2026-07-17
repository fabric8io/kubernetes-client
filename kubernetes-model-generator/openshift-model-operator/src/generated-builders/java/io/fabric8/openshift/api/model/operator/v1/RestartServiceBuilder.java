package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RestartServiceBuilder extends RestartServiceFluent<RestartServiceBuilder> implements VisitableBuilder<RestartService,RestartServiceBuilder>{

  RestartServiceFluent<?> fluent;

  public RestartServiceBuilder() {
    this(new RestartService());
  }
  
  public RestartServiceBuilder(RestartServiceFluent<?> fluent) {
    this(fluent, new RestartService());
  }
  
  public RestartServiceBuilder(RestartService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RestartServiceBuilder(RestartServiceFluent<?> fluent,RestartService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RestartService build() {
    RestartService buildable = new RestartService(fluent.getServiceName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}