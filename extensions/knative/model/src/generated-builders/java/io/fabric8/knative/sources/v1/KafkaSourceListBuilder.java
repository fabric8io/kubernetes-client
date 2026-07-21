package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSourceListBuilder extends KafkaSourceListFluent<KafkaSourceListBuilder> implements VisitableBuilder<KafkaSourceList,KafkaSourceListBuilder>{

  KafkaSourceListFluent<?> fluent;

  public KafkaSourceListBuilder() {
    this(new KafkaSourceList());
  }
  
  public KafkaSourceListBuilder(KafkaSourceListFluent<?> fluent) {
    this(fluent, new KafkaSourceList());
  }
  
  public KafkaSourceListBuilder(KafkaSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSourceListBuilder(KafkaSourceListFluent<?> fluent,KafkaSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSourceList build() {
    KafkaSourceList buildable = new KafkaSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}