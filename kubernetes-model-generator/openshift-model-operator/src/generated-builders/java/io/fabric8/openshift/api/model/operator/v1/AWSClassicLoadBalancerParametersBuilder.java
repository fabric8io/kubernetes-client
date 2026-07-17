package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSClassicLoadBalancerParametersBuilder extends AWSClassicLoadBalancerParametersFluent<AWSClassicLoadBalancerParametersBuilder> implements VisitableBuilder<AWSClassicLoadBalancerParameters,AWSClassicLoadBalancerParametersBuilder>{

  AWSClassicLoadBalancerParametersFluent<?> fluent;

  public AWSClassicLoadBalancerParametersBuilder() {
    this(new AWSClassicLoadBalancerParameters());
  }
  
  public AWSClassicLoadBalancerParametersBuilder(AWSClassicLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new AWSClassicLoadBalancerParameters());
  }
  
  public AWSClassicLoadBalancerParametersBuilder(AWSClassicLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSClassicLoadBalancerParametersBuilder(AWSClassicLoadBalancerParametersFluent<?> fluent,AWSClassicLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSClassicLoadBalancerParameters build() {
    AWSClassicLoadBalancerParameters buildable = new AWSClassicLoadBalancerParameters(fluent.getConnectionIdleTimeout(), fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}