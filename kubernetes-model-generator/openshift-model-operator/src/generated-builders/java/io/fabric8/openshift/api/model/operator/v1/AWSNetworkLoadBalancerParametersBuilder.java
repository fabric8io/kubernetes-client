package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSNetworkLoadBalancerParametersBuilder extends AWSNetworkLoadBalancerParametersFluent<AWSNetworkLoadBalancerParametersBuilder> implements VisitableBuilder<AWSNetworkLoadBalancerParameters,AWSNetworkLoadBalancerParametersBuilder>{

  AWSNetworkLoadBalancerParametersFluent<?> fluent;

  public AWSNetworkLoadBalancerParametersBuilder() {
    this(new AWSNetworkLoadBalancerParameters());
  }
  
  public AWSNetworkLoadBalancerParametersBuilder(AWSNetworkLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new AWSNetworkLoadBalancerParameters());
  }
  
  public AWSNetworkLoadBalancerParametersBuilder(AWSNetworkLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSNetworkLoadBalancerParametersBuilder(AWSNetworkLoadBalancerParametersFluent<?> fluent,AWSNetworkLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSNetworkLoadBalancerParameters build() {
    AWSNetworkLoadBalancerParameters buildable = new AWSNetworkLoadBalancerParameters(fluent.getEipAllocations(), fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}