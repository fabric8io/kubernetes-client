package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackLoadBalancerParametersBuilder extends OpenStackLoadBalancerParametersFluent<OpenStackLoadBalancerParametersBuilder> implements VisitableBuilder<OpenStackLoadBalancerParameters,OpenStackLoadBalancerParametersBuilder>{

  OpenStackLoadBalancerParametersFluent<?> fluent;

  public OpenStackLoadBalancerParametersBuilder() {
    this(new OpenStackLoadBalancerParameters());
  }
  
  public OpenStackLoadBalancerParametersBuilder(OpenStackLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new OpenStackLoadBalancerParameters());
  }
  
  public OpenStackLoadBalancerParametersBuilder(OpenStackLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackLoadBalancerParametersBuilder(OpenStackLoadBalancerParametersFluent<?> fluent,OpenStackLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackLoadBalancerParameters build() {
    OpenStackLoadBalancerParameters buildable = new OpenStackLoadBalancerParameters(fluent.getFloatingIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}