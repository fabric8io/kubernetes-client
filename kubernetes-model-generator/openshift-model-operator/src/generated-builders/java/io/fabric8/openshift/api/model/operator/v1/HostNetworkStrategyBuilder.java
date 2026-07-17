package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostNetworkStrategyBuilder extends HostNetworkStrategyFluent<HostNetworkStrategyBuilder> implements VisitableBuilder<HostNetworkStrategy,HostNetworkStrategyBuilder>{

  HostNetworkStrategyFluent<?> fluent;

  public HostNetworkStrategyBuilder() {
    this(new HostNetworkStrategy());
  }
  
  public HostNetworkStrategyBuilder(HostNetworkStrategyFluent<?> fluent) {
    this(fluent, new HostNetworkStrategy());
  }
  
  public HostNetworkStrategyBuilder(HostNetworkStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostNetworkStrategyBuilder(HostNetworkStrategyFluent<?> fluent,HostNetworkStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostNetworkStrategy build() {
    HostNetworkStrategy buildable = new HostNetworkStrategy(fluent.getHttpPort(), fluent.getHttpsPort(), fluent.getProtocol(), fluent.getStatsPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}