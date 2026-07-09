package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PatchBuilder extends PatchFluent<PatchBuilder> implements VisitableBuilder<Patch,PatchBuilder>{

  PatchFluent<?> fluent;

  public PatchBuilder() {
    this(new Patch());
  }
  
  public PatchBuilder(PatchFluent<?> fluent) {
    this(fluent, new Patch());
  }
  
  public PatchBuilder(Patch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PatchBuilder(PatchFluent<?> fluent,Patch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Patch build() {
    Patch buildable = new Patch(fluent.buildOptions(), fluent.getPatch(), fluent.getPath(), fluent.buildTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}