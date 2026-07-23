package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSourceListBuilder extends IntegrationSourceListFluent<IntegrationSourceListBuilder> implements VisitableBuilder<IntegrationSourceList,IntegrationSourceListBuilder>{

  IntegrationSourceListFluent<?> fluent;

  public IntegrationSourceListBuilder() {
    this(new IntegrationSourceList());
  }
  
  public IntegrationSourceListBuilder(IntegrationSourceListFluent<?> fluent) {
    this(fluent, new IntegrationSourceList());
  }
  
  public IntegrationSourceListBuilder(IntegrationSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSourceListBuilder(IntegrationSourceListFluent<?> fluent,IntegrationSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSourceList build() {
    IntegrationSourceList buildable = new IntegrationSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}