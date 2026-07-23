package io.fabric8.knative.bindings.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaBindingListBuilder extends KafkaBindingListFluent<KafkaBindingListBuilder> implements VisitableBuilder<KafkaBindingList,KafkaBindingListBuilder>{

  KafkaBindingListFluent<?> fluent;

  public KafkaBindingListBuilder() {
    this(new KafkaBindingList());
  }
  
  public KafkaBindingListBuilder(KafkaBindingListFluent<?> fluent) {
    this(fluent, new KafkaBindingList());
  }
  
  public KafkaBindingListBuilder(KafkaBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaBindingListBuilder(KafkaBindingListFluent<?> fluent,KafkaBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaBindingList build() {
    KafkaBindingList buildable = new KafkaBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}