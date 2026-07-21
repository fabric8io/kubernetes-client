package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RefSourceBuilder extends RefSourceFluent<RefSourceBuilder> implements VisitableBuilder<RefSource,RefSourceBuilder>{

  RefSourceFluent<?> fluent;

  public RefSourceBuilder() {
    this(new RefSource());
  }
  
  public RefSourceBuilder(RefSourceFluent<?> fluent) {
    this(fluent, new RefSource());
  }
  
  public RefSourceBuilder(RefSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RefSourceBuilder(RefSourceFluent<?> fluent,RefSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RefSource build() {
    RefSource buildable = new RefSource(fluent.getDigest(), fluent.getEntryPoint(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}