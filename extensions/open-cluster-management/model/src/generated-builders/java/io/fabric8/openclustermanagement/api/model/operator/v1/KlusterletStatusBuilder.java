package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletStatusBuilder extends KlusterletStatusFluent<KlusterletStatusBuilder> implements VisitableBuilder<KlusterletStatus,KlusterletStatusBuilder>{

  KlusterletStatusFluent<?> fluent;

  public KlusterletStatusBuilder() {
    this(new KlusterletStatus());
  }
  
  public KlusterletStatusBuilder(KlusterletStatusFluent<?> fluent) {
    this(fluent, new KlusterletStatus());
  }
  
  public KlusterletStatusBuilder(KlusterletStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletStatusBuilder(KlusterletStatusFluent<?> fluent,KlusterletStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletStatus build() {
    KlusterletStatus buildable = new KlusterletStatus(fluent.getConditions(), fluent.buildGenerations(), fluent.getObservedGeneration(), fluent.buildRelatedResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}