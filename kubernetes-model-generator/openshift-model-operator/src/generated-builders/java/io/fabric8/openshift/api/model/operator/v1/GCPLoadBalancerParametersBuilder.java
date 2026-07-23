package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPLoadBalancerParametersBuilder extends GCPLoadBalancerParametersFluent<GCPLoadBalancerParametersBuilder> implements VisitableBuilder<GCPLoadBalancerParameters,GCPLoadBalancerParametersBuilder>{

  GCPLoadBalancerParametersFluent<?> fluent;

  public GCPLoadBalancerParametersBuilder() {
    this(new GCPLoadBalancerParameters());
  }
  
  public GCPLoadBalancerParametersBuilder(GCPLoadBalancerParametersFluent<?> fluent) {
    this(fluent, new GCPLoadBalancerParameters());
  }
  
  public GCPLoadBalancerParametersBuilder(GCPLoadBalancerParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPLoadBalancerParametersBuilder(GCPLoadBalancerParametersFluent<?> fluent,GCPLoadBalancerParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPLoadBalancerParameters build() {
    GCPLoadBalancerParameters buildable = new GCPLoadBalancerParameters(fluent.getClientAccess());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}