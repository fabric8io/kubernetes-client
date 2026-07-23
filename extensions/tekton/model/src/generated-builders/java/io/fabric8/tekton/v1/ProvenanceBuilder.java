package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProvenanceBuilder extends ProvenanceFluent<ProvenanceBuilder> implements VisitableBuilder<Provenance,ProvenanceBuilder>{

  ProvenanceFluent<?> fluent;

  public ProvenanceBuilder() {
    this(new Provenance());
  }
  
  public ProvenanceBuilder(ProvenanceFluent<?> fluent) {
    this(fluent, new Provenance());
  }
  
  public ProvenanceBuilder(Provenance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProvenanceBuilder(ProvenanceFluent<?> fluent,Provenance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Provenance build() {
    Provenance buildable = new Provenance(fluent.buildFeatureFlags(), fluent.buildRefSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}