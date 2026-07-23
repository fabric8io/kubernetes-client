package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProviderLoadBalancerParametersBuilder extends ProviderLoadBalancerParametersFluent<ProviderLoadBalancerParametersBuilder> implements VisitableBuilder<ProviderLoadBalancerParameters,ProviderLoadBalancerParametersBuilder>{

  ProviderLoadBalancerParametersFluent<?> fluent;

  public ProviderLoadBalancerParametersBuilder() {
    this(new ProviderLoadBalancerParameters());
  }
  
  public ProviderLoadBalancerParametersBuilder(ProviderLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new ProviderLoadBalancerParameters());
  }
  
  public ProviderLoadBalancerParametersBuilder(ProviderLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProviderLoadBalancerParametersBuilder(ProviderLoadBalancerParametersFluent<?> fluent,ProviderLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProviderLoadBalancerParameters build() {
    ProviderLoadBalancerParameters buildable = new ProviderLoadBalancerParameters(fluent.buildAws(), fluent.buildGcp(), fluent.buildIbm(), fluent.buildOpenstack(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}