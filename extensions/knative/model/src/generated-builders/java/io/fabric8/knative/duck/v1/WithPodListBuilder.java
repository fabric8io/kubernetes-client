package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WithPodListBuilder extends WithPodListFluent<WithPodListBuilder> implements VisitableBuilder<WithPodList,WithPodListBuilder>{

  WithPodListFluent<?> fluent;

  public WithPodListBuilder() {
    this(new WithPodList());
  }
  
  public WithPodListBuilder(WithPodListFluent<?> fluent) {
    this(fluent, new WithPodList());
  }
  
  public WithPodListBuilder(WithPodList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WithPodListBuilder(WithPodListFluent<?> fluent,WithPodList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WithPodList build() {
    WithPodList buildable = new WithPodList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}