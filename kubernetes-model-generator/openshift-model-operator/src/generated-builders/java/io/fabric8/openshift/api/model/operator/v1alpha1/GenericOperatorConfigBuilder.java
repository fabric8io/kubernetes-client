package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericOperatorConfigBuilder extends GenericOperatorConfigFluent<GenericOperatorConfigBuilder> implements VisitableBuilder<GenericOperatorConfig,GenericOperatorConfigBuilder>{

  GenericOperatorConfigFluent<?> fluent;

  public GenericOperatorConfigBuilder() {
    this(new GenericOperatorConfig());
  }
  
  public GenericOperatorConfigBuilder(GenericOperatorConfigFluent<?> fluent) {
    this(fluent, new GenericOperatorConfig());
  }
  
  public GenericOperatorConfigBuilder(GenericOperatorConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericOperatorConfigBuilder(GenericOperatorConfigFluent<?> fluent,GenericOperatorConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericOperatorConfig build() {
    GenericOperatorConfig buildable = new GenericOperatorConfig(fluent.getApiVersion(), fluent.buildAuthentication(), fluent.buildAuthorization(), fluent.getKind(), fluent.getLeaderElection(), fluent.getServingInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}