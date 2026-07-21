package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSinkListBuilder extends IntegrationSinkListFluent<IntegrationSinkListBuilder> implements VisitableBuilder<IntegrationSinkList,IntegrationSinkListBuilder>{

  IntegrationSinkListFluent<?> fluent;

  public IntegrationSinkListBuilder() {
    this(new IntegrationSinkList());
  }
  
  public IntegrationSinkListBuilder(IntegrationSinkListFluent<?> fluent) {
    this(fluent, new IntegrationSinkList());
  }
  
  public IntegrationSinkListBuilder(IntegrationSinkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSinkListBuilder(IntegrationSinkListFluent<?> fluent,IntegrationSinkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSinkList build() {
    IntegrationSinkList buildable = new IntegrationSinkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}