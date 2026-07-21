package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RefBuilder extends RefFluent<RefBuilder> implements VisitableBuilder<Ref,RefBuilder>{

  RefFluent<?> fluent;

  public RefBuilder() {
    this(new Ref());
  }
  
  public RefBuilder(RefFluent<?> fluent) {
    this(fluent, new Ref());
  }
  
  public RefBuilder(Ref instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RefBuilder(RefFluent<?> fluent,Ref instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Ref build() {
    Ref buildable = new Ref(fluent.getName(), fluent.buildParams(), fluent.getResolver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}