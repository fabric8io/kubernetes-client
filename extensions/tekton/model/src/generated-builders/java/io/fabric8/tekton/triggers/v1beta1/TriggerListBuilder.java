package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerListBuilder extends TriggerListFluent<TriggerListBuilder> implements VisitableBuilder<TriggerList,TriggerListBuilder>{

  TriggerListFluent<?> fluent;

  public TriggerListBuilder() {
    this(new TriggerList());
  }
  
  public TriggerListBuilder(TriggerListFluent<?> fluent) {
    this(fluent, new TriggerList());
  }
  
  public TriggerListBuilder(TriggerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerListBuilder(TriggerListFluent<?> fluent,TriggerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerList build() {
    TriggerList buildable = new TriggerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}