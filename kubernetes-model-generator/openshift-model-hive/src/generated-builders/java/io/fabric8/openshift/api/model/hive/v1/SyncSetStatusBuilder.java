package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncSetStatusBuilder extends SyncSetStatusFluent<SyncSetStatusBuilder> implements VisitableBuilder<SyncSetStatus,SyncSetStatusBuilder>{

  SyncSetStatusFluent<?> fluent;

  public SyncSetStatusBuilder() {
    this(new SyncSetStatus());
  }
  
  public SyncSetStatusBuilder(SyncSetStatusFluent<?> fluent) {
    this(fluent, new SyncSetStatus());
  }
  
  public SyncSetStatusBuilder(SyncSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncSetStatusBuilder(SyncSetStatusFluent<?> fluent,SyncSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncSetStatus build() {
    SyncSetStatus buildable = new SyncSetStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}