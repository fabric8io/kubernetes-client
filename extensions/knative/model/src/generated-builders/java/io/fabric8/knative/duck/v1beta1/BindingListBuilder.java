package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BindingListBuilder extends BindingListFluent<BindingListBuilder> implements VisitableBuilder<BindingList,BindingListBuilder>{

  BindingListFluent<?> fluent;

  public BindingListBuilder() {
    this(new BindingList());
  }
  
  public BindingListBuilder(BindingListFluent<?> fluent) {
    this(fluent, new BindingList());
  }
  
  public BindingListBuilder(BindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BindingListBuilder(BindingListFluent<?> fluent,BindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BindingList build() {
    BindingList buildable = new BindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}