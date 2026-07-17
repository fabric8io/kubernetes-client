package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMonitorListBuilder extends PodMonitorListFluent<PodMonitorListBuilder> implements VisitableBuilder<PodMonitorList,PodMonitorListBuilder>{

  PodMonitorListFluent<?> fluent;

  public PodMonitorListBuilder() {
    this(new PodMonitorList());
  }
  
  public PodMonitorListBuilder(PodMonitorListFluent<?> fluent) {
    this(fluent, new PodMonitorList());
  }
  
  public PodMonitorListBuilder(PodMonitorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMonitorListBuilder(PodMonitorListFluent<?> fluent,PodMonitorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMonitorList build() {
    PodMonitorList buildable = new PodMonitorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}