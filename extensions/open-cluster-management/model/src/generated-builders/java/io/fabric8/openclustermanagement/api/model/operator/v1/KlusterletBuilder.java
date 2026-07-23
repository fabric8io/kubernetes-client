package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletBuilder extends KlusterletFluent<KlusterletBuilder> implements VisitableBuilder<Klusterlet,KlusterletBuilder>{

  KlusterletFluent<?> fluent;

  public KlusterletBuilder() {
    this(new Klusterlet());
  }
  
  public KlusterletBuilder(KlusterletFluent<?> fluent) {
    this(fluent, new Klusterlet());
  }
  
  public KlusterletBuilder(Klusterlet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletBuilder(KlusterletFluent<?> fluent,Klusterlet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Klusterlet build() {
    Klusterlet buildable = new Klusterlet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}