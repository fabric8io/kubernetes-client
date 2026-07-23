package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OutageEntryBuilder extends OutageEntryFluent<OutageEntryBuilder> implements VisitableBuilder<OutageEntry,OutageEntryBuilder>{

  OutageEntryFluent<?> fluent;

  public OutageEntryBuilder() {
    this(new OutageEntry());
  }
  
  public OutageEntryBuilder(OutageEntryFluent<?> fluent) {
    this(fluent, new OutageEntry());
  }
  
  public OutageEntryBuilder(OutageEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OutageEntryBuilder(OutageEntryFluent<?> fluent,OutageEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OutageEntry build() {
    OutageEntry buildable = new OutageEntry(fluent.getEnd(), fluent.buildEndLogs(), fluent.getMessage(), fluent.getStart(), fluent.buildStartLogs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}