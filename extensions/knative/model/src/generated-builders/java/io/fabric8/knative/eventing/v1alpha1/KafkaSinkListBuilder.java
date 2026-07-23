package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSinkListBuilder extends KafkaSinkListFluent<KafkaSinkListBuilder> implements VisitableBuilder<KafkaSinkList,KafkaSinkListBuilder>{

  KafkaSinkListFluent<?> fluent;

  public KafkaSinkListBuilder() {
    this(new KafkaSinkList());
  }
  
  public KafkaSinkListBuilder(KafkaSinkListFluent<?> fluent) {
    this(fluent, new KafkaSinkList());
  }
  
  public KafkaSinkListBuilder(KafkaSinkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSinkListBuilder(KafkaSinkListFluent<?> fluent,KafkaSinkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSinkList build() {
    KafkaSinkList buildable = new KafkaSinkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}