package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetFlowConfigBuilder extends NetFlowConfigFluent<NetFlowConfigBuilder> implements VisitableBuilder<NetFlowConfig,NetFlowConfigBuilder>{

  NetFlowConfigFluent<?> fluent;

  public NetFlowConfigBuilder() {
    this(new NetFlowConfig());
  }
  
  public NetFlowConfigBuilder(NetFlowConfigFluent<?> fluent) {
    this(fluent, new NetFlowConfig());
  }
  
  public NetFlowConfigBuilder(NetFlowConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetFlowConfigBuilder(NetFlowConfigFluent<?> fluent,NetFlowConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetFlowConfig build() {
    NetFlowConfig buildable = new NetFlowConfig(fluent.getCollectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}