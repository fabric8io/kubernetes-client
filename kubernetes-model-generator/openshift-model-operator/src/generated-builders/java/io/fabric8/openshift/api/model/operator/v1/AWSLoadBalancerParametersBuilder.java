package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSLoadBalancerParametersBuilder extends AWSLoadBalancerParametersFluent<AWSLoadBalancerParametersBuilder> implements VisitableBuilder<AWSLoadBalancerParameters,AWSLoadBalancerParametersBuilder>{

  AWSLoadBalancerParametersFluent<?> fluent;

  public AWSLoadBalancerParametersBuilder() {
    this(new AWSLoadBalancerParameters());
  }
  
  public AWSLoadBalancerParametersBuilder(AWSLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new AWSLoadBalancerParameters());
  }
  
  public AWSLoadBalancerParametersBuilder(AWSLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSLoadBalancerParametersBuilder(AWSLoadBalancerParametersFluent<?> fluent,AWSLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSLoadBalancerParameters build() {
    AWSLoadBalancerParameters buildable = new AWSLoadBalancerParameters(fluent.buildClassicLoadBalancer(), fluent.buildNetworkLoadBalancer(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}