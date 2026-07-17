package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMonitorBuilder extends PodMonitorFluent<PodMonitorBuilder> implements VisitableBuilder<PodMonitor,PodMonitorBuilder>{

  PodMonitorFluent<?> fluent;

  public PodMonitorBuilder() {
    this(new PodMonitor());
  }
  
  public PodMonitorBuilder(PodMonitorFluent<?> fluent) {
    this(fluent, new PodMonitor());
  }
  
  public PodMonitorBuilder(PodMonitor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMonitorBuilder(PodMonitorFluent<?> fluent,PodMonitor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMonitor build() {
    PodMonitor buildable = new PodMonitor(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}