package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerBindingListBuilder extends TriggerBindingListFluent<TriggerBindingListBuilder> implements VisitableBuilder<TriggerBindingList,TriggerBindingListBuilder>{

  TriggerBindingListFluent<?> fluent;

  public TriggerBindingListBuilder() {
    this(new TriggerBindingList());
  }
  
  public TriggerBindingListBuilder(TriggerBindingListFluent<?> fluent) {
    this(fluent, new TriggerBindingList());
  }
  
  public TriggerBindingListBuilder(TriggerBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerBindingListBuilder(TriggerBindingListFluent<?> fluent,TriggerBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerBindingList build() {
    TriggerBindingList buildable = new TriggerBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}