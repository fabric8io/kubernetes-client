package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PatchArgsBuilder extends PatchArgsFluent<PatchArgsBuilder> implements VisitableBuilder<PatchArgs,PatchArgsBuilder>{

  PatchArgsFluent<?> fluent;

  public PatchArgsBuilder() {
    this(new PatchArgs());
  }
  
  public PatchArgsBuilder(PatchArgsFluent<?> fluent) {
    this(fluent, new PatchArgs());
  }
  
  public PatchArgsBuilder(PatchArgs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PatchArgsBuilder(PatchArgsFluent<?> fluent,PatchArgs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PatchArgs build() {
    PatchArgs buildable = new PatchArgs(fluent.getAllowKindChange(), fluent.getAllowNameChange());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}