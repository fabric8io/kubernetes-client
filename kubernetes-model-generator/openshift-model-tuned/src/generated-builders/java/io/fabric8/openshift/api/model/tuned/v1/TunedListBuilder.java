package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedListBuilder extends TunedListFluent<TunedListBuilder> implements VisitableBuilder<TunedList,TunedListBuilder>{

  TunedListFluent<?> fluent;

  public TunedListBuilder() {
    this(new TunedList());
  }
  
  public TunedListBuilder(TunedListFluent<?> fluent) {
    this(fluent, new TunedList());
  }
  
  public TunedListBuilder(TunedList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedListBuilder(TunedListFluent<?> fluent,TunedList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedList build() {
    TunedList buildable = new TunedList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}