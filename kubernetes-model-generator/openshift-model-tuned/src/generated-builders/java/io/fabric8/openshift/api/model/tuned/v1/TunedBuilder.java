package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedBuilder extends TunedFluent<TunedBuilder> implements VisitableBuilder<Tuned,TunedBuilder>{

  TunedFluent<?> fluent;

  public TunedBuilder() {
    this(new Tuned());
  }
  
  public TunedBuilder(TunedFluent<?> fluent) {
    this(fluent, new Tuned());
  }
  
  public TunedBuilder(Tuned instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedBuilder(TunedFluent<?> fluent,Tuned instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Tuned build() {
    Tuned buildable = new Tuned(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}