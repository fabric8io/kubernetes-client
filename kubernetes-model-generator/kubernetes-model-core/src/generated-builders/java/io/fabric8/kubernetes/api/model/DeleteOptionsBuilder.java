package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeleteOptionsBuilder extends DeleteOptionsFluent<DeleteOptionsBuilder> implements VisitableBuilder<DeleteOptions,DeleteOptionsBuilder>{

  DeleteOptionsFluent<?> fluent;

  public DeleteOptionsBuilder() {
    this(new DeleteOptions());
  }
  
  public DeleteOptionsBuilder(DeleteOptionsFluent<?> fluent) {
    this(fluent, new DeleteOptions());
  }
  
  public DeleteOptionsBuilder(DeleteOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeleteOptionsBuilder(DeleteOptionsFluent<?> fluent,DeleteOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeleteOptions build() {
    DeleteOptions buildable = new DeleteOptions(fluent.getApiVersion(), fluent.getDryRun(), fluent.getGracePeriodSeconds(), fluent.getIgnoreStoreReadErrorWithClusterBreakingPotential(), fluent.getKind(), fluent.getOrphanDependents(), fluent.buildPreconditions(), fluent.getPropagationPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}