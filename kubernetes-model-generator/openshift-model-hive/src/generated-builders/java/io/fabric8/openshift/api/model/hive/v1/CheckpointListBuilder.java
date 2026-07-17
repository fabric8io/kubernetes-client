package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CheckpointListBuilder extends CheckpointListFluent<CheckpointListBuilder> implements VisitableBuilder<CheckpointList,CheckpointListBuilder>{

  CheckpointListFluent<?> fluent;

  public CheckpointListBuilder() {
    this(new CheckpointList());
  }
  
  public CheckpointListBuilder(CheckpointListFluent<?> fluent) {
    this(fluent, new CheckpointList());
  }
  
  public CheckpointListBuilder(CheckpointList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CheckpointListBuilder(CheckpointListFluent<?> fluent,CheckpointList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CheckpointList build() {
    CheckpointList buildable = new CheckpointList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}