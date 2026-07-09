package io.fabric8.kubernetes.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionBuilder extends EvictionFluent<EvictionBuilder> implements VisitableBuilder<Eviction,EvictionBuilder>{

  EvictionFluent<?> fluent;

  public EvictionBuilder() {
    this(new Eviction());
  }
  
  public EvictionBuilder(EvictionFluent<?> fluent) {
    this(fluent, new Eviction());
  }
  
  public EvictionBuilder(Eviction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionBuilder(EvictionFluent<?> fluent,Eviction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Eviction build() {
    Eviction buildable = new Eviction(fluent.getApiVersion(), fluent.getDeleteOptions(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}