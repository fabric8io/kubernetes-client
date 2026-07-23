package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscribableListBuilder extends SubscribableListFluent<SubscribableListBuilder> implements VisitableBuilder<SubscribableList,SubscribableListBuilder>{

  SubscribableListFluent<?> fluent;

  public SubscribableListBuilder() {
    this(new SubscribableList());
  }
  
  public SubscribableListBuilder(SubscribableListFluent<?> fluent) {
    this(fluent, new SubscribableList());
  }
  
  public SubscribableListBuilder(SubscribableList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscribableListBuilder(SubscribableListFluent<?> fluent,SubscribableList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscribableList build() {
    SubscribableList buildable = new SubscribableList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}