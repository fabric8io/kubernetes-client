package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PatchOptionsBuilder extends PatchOptionsFluent<PatchOptionsBuilder> implements VisitableBuilder<PatchOptions,PatchOptionsBuilder>{

  PatchOptionsFluent<?> fluent;

  public PatchOptionsBuilder() {
    this(new PatchOptions());
  }
  
  public PatchOptionsBuilder(PatchOptionsFluent<?> fluent) {
    this(fluent, new PatchOptions());
  }
  
  public PatchOptionsBuilder(PatchOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PatchOptionsBuilder(PatchOptionsFluent<?> fluent,PatchOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PatchOptions build() {
    PatchOptions buildable = new PatchOptions(fluent.getApiVersion(), fluent.getDryRun(), fluent.getFieldManager(), fluent.getFieldValidation(), fluent.getForce(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}