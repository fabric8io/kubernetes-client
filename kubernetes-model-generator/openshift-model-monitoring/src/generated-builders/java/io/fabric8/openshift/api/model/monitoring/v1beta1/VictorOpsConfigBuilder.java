package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VictorOpsConfigBuilder extends VictorOpsConfigFluent<VictorOpsConfigBuilder> implements VisitableBuilder<VictorOpsConfig,VictorOpsConfigBuilder>{

  VictorOpsConfigFluent<?> fluent;

  public VictorOpsConfigBuilder() {
    this(new VictorOpsConfig());
  }
  
  public VictorOpsConfigBuilder(VictorOpsConfigFluent<?> fluent) {
    this(fluent, new VictorOpsConfig());
  }
  
  public VictorOpsConfigBuilder(VictorOpsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VictorOpsConfigBuilder(VictorOpsConfigFluent<?> fluent,VictorOpsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VictorOpsConfig build() {
    VictorOpsConfig buildable = new VictorOpsConfig(fluent.buildApiKey(), fluent.getApiUrl(), fluent.buildCustomFields(), fluent.getEntityDisplayName(), fluent.buildHttpConfig(), fluent.getMessageType(), fluent.getMonitoringTool(), fluent.getRoutingKey(), fluent.getSendResolved(), fluent.getStateMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}