package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SelectorSyncSetStatusBuilder extends SelectorSyncSetStatusFluent<SelectorSyncSetStatusBuilder> implements VisitableBuilder<SelectorSyncSetStatus,SelectorSyncSetStatusBuilder>{

  SelectorSyncSetStatusFluent<?> fluent;

  public SelectorSyncSetStatusBuilder() {
    this(new SelectorSyncSetStatus());
  }
  
  public SelectorSyncSetStatusBuilder(SelectorSyncSetStatusFluent<?> fluent) {
    this(fluent, new SelectorSyncSetStatus());
  }
  
  public SelectorSyncSetStatusBuilder(SelectorSyncSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SelectorSyncSetStatusBuilder(SelectorSyncSetStatusFluent<?> fluent,SelectorSyncSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SelectorSyncSetStatus build() {
    SelectorSyncSetStatus buildable = new SelectorSyncSetStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}