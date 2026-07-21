package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsSqsSourceListBuilder extends AwsSqsSourceListFluent<AwsSqsSourceListBuilder> implements VisitableBuilder<AwsSqsSourceList,AwsSqsSourceListBuilder>{

  AwsSqsSourceListFluent<?> fluent;

  public AwsSqsSourceListBuilder() {
    this(new AwsSqsSourceList());
  }
  
  public AwsSqsSourceListBuilder(AwsSqsSourceListFluent<?> fluent) {
    this(fluent, new AwsSqsSourceList());
  }
  
  public AwsSqsSourceListBuilder(AwsSqsSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsSqsSourceListBuilder(AwsSqsSourceListFluent<?> fluent,AwsSqsSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsSqsSourceList build() {
    AwsSqsSourceList buildable = new AwsSqsSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}