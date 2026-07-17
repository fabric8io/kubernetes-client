package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMLoadBalancerParametersBuilder extends IBMLoadBalancerParametersFluent<IBMLoadBalancerParametersBuilder> implements VisitableBuilder<IBMLoadBalancerParameters,IBMLoadBalancerParametersBuilder>{

  IBMLoadBalancerParametersFluent<?> fluent;

  public IBMLoadBalancerParametersBuilder() {
    this(new IBMLoadBalancerParameters());
  }
  
  public IBMLoadBalancerParametersBuilder(IBMLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new IBMLoadBalancerParameters());
  }
  
  public IBMLoadBalancerParametersBuilder(IBMLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMLoadBalancerParametersBuilder(IBMLoadBalancerParametersFluent<?> fluent,IBMLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMLoadBalancerParameters build() {
    IBMLoadBalancerParameters buildable = new IBMLoadBalancerParameters(fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}