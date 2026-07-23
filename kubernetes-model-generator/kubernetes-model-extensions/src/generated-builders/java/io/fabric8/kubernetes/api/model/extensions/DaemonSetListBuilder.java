package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetListBuilder extends DaemonSetListFluent<DaemonSetListBuilder> implements VisitableBuilder<DaemonSetList,DaemonSetListBuilder>{

  DaemonSetListFluent<?> fluent;

  public DaemonSetListBuilder() {
    this(new DaemonSetList());
  }
  
  public DaemonSetListBuilder(DaemonSetListFluent<?> fluent) {
    this(fluent, new DaemonSetList());
  }
  
  public DaemonSetListBuilder(DaemonSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetListBuilder(DaemonSetListFluent<?> fluent,DaemonSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSetList build() {
    DaemonSetList buildable = new DaemonSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}