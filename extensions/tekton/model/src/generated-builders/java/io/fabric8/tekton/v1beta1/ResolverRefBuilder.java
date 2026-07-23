package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolverRefBuilder extends ResolverRefFluent<ResolverRefBuilder> implements VisitableBuilder<ResolverRef,ResolverRefBuilder>{

  ResolverRefFluent<?> fluent;

  public ResolverRefBuilder() {
    this(new ResolverRef());
  }
  
  public ResolverRefBuilder(ResolverRefFluent<?> fluent) {
    this(fluent, new ResolverRef());
  }
  
  public ResolverRefBuilder(ResolverRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolverRefBuilder(ResolverRefFluent<?> fluent,ResolverRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolverRef build() {
    ResolverRef buildable = new ResolverRef(fluent.buildParams(), fluent.getResolver());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}