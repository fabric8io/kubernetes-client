package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetBuilder extends DaemonSetFluent<DaemonSetBuilder> implements VisitableBuilder<DaemonSet,DaemonSetBuilder>{

  DaemonSetFluent<?> fluent;

  public DaemonSetBuilder() {
    this(new DaemonSet());
  }
  
  public DaemonSetBuilder(DaemonSetFluent<?> fluent) {
    this(fluent, new DaemonSet());
  }
  
  public DaemonSetBuilder(DaemonSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetBuilder(DaemonSetFluent<?> fluent,DaemonSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSet build() {
    DaemonSet buildable = new DaemonSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}