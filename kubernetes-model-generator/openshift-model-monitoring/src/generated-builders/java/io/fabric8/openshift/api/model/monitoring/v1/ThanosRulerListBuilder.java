package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosRulerListBuilder extends ThanosRulerListFluent<ThanosRulerListBuilder> implements VisitableBuilder<ThanosRulerList,ThanosRulerListBuilder>{

  ThanosRulerListFluent<?> fluent;

  public ThanosRulerListBuilder() {
    this(new ThanosRulerList());
  }
  
  public ThanosRulerListBuilder(ThanosRulerListFluent<?> fluent) {
    this(fluent, new ThanosRulerList());
  }
  
  public ThanosRulerListBuilder(ThanosRulerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosRulerListBuilder(ThanosRulerListFluent<?> fluent,ThanosRulerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosRulerList build() {
    ThanosRulerList buildable = new ThanosRulerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}