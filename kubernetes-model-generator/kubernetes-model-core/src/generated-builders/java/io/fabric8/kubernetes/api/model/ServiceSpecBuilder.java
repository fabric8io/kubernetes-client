package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceSpecBuilder extends ServiceSpecFluent<ServiceSpecBuilder> implements VisitableBuilder<ServiceSpec,ServiceSpecBuilder>{

  ServiceSpecFluent<?> fluent;

  public ServiceSpecBuilder() {
    this(new ServiceSpec());
  }
  
  public ServiceSpecBuilder(ServiceSpecFluent<?> fluent) {
    this(fluent, new ServiceSpec());
  }
  
  public ServiceSpecBuilder(ServiceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceSpecBuilder(ServiceSpecFluent<?> fluent,ServiceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceSpec build() {
    ServiceSpec buildable = new ServiceSpec(fluent.getAllocateLoadBalancerNodePorts(), fluent.getClusterIP(), fluent.getClusterIPs(), fluent.getExternalIPs(), fluent.getExternalName(), fluent.getExternalTrafficPolicy(), fluent.getHealthCheckNodePort(), fluent.getInternalTrafficPolicy(), fluent.getIpFamilies(), fluent.getIpFamilyPolicy(), fluent.getLoadBalancerClass(), fluent.getLoadBalancerIP(), fluent.getLoadBalancerSourceRanges(), fluent.buildPorts(), fluent.getPublishNotReadyAddresses(), fluent.getSelector(), fluent.getSessionAffinity(), fluent.buildSessionAffinityConfig(), fluent.getTrafficDistribution(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}