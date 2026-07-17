package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CheckpointBuilder extends CheckpointFluent<CheckpointBuilder> implements VisitableBuilder<Checkpoint,CheckpointBuilder>{

  CheckpointFluent<?> fluent;

  public CheckpointBuilder() {
    this(new Checkpoint());
  }
  
  public CheckpointBuilder(CheckpointFluent<?> fluent) {
    this(fluent, new Checkpoint());
  }
  
  public CheckpointBuilder(Checkpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CheckpointBuilder(CheckpointFluent<?> fluent,Checkpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Checkpoint build() {
    Checkpoint buildable = new Checkpoint(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}