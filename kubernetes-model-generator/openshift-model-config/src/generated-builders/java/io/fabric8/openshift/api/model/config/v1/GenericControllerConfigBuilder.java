package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericControllerConfigBuilder extends GenericControllerConfigFluent<GenericControllerConfigBuilder> implements VisitableBuilder<GenericControllerConfig,GenericControllerConfigBuilder>{

  GenericControllerConfigFluent<?> fluent;

  public GenericControllerConfigBuilder() {
    this(new GenericControllerConfig());
  }
  
  public GenericControllerConfigBuilder(GenericControllerConfigFluent<?> fluent) {
    this(fluent, new GenericControllerConfig());
  }
  
  public GenericControllerConfigBuilder(GenericControllerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericControllerConfigBuilder(GenericControllerConfigFluent<?> fluent,GenericControllerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericControllerConfig build() {
    GenericControllerConfig buildable = new GenericControllerConfig(fluent.buildAuthentication(), fluent.buildAuthorization(), fluent.buildLeaderElection(), fluent.buildServingInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}