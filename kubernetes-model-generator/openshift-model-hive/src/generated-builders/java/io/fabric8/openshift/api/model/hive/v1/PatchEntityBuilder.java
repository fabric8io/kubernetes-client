package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PatchEntityBuilder extends PatchEntityFluent<PatchEntityBuilder> implements VisitableBuilder<PatchEntity,PatchEntityBuilder>{

  PatchEntityFluent<?> fluent;

  public PatchEntityBuilder() {
    this(new PatchEntity());
  }
  
  public PatchEntityBuilder(PatchEntityFluent<?> fluent) {
    this(fluent, new PatchEntity());
  }
  
  public PatchEntityBuilder(PatchEntity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PatchEntityBuilder(PatchEntityFluent<?> fluent,PatchEntity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PatchEntity build() {
    PatchEntity buildable = new PatchEntity(fluent.getFrom(), fluent.getOp(), fluent.getPath(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}