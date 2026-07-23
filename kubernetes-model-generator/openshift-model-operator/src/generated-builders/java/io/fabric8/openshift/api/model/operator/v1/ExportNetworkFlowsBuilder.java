package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExportNetworkFlowsBuilder extends ExportNetworkFlowsFluent<ExportNetworkFlowsBuilder> implements VisitableBuilder<ExportNetworkFlows,ExportNetworkFlowsBuilder>{

  ExportNetworkFlowsFluent<?> fluent;

  public ExportNetworkFlowsBuilder() {
    this(new ExportNetworkFlows());
  }
  
  public ExportNetworkFlowsBuilder(ExportNetworkFlowsFluent<?> fluent) {
    this(fluent, new ExportNetworkFlows());
  }
  
  public ExportNetworkFlowsBuilder(ExportNetworkFlows instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExportNetworkFlowsBuilder(ExportNetworkFlowsFluent<?> fluent,ExportNetworkFlows instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExportNetworkFlows build() {
    ExportNetworkFlows buildable = new ExportNetworkFlows(fluent.buildIpfix(), fluent.buildNetFlow(), fluent.buildSFlow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}