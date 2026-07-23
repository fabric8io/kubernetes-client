package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSourceBuilder extends IntegrationSourceFluent<IntegrationSourceBuilder> implements VisitableBuilder<IntegrationSource,IntegrationSourceBuilder>{

  IntegrationSourceFluent<?> fluent;

  public IntegrationSourceBuilder() {
    this(new IntegrationSource());
  }
  
  public IntegrationSourceBuilder(IntegrationSourceFluent<?> fluent) {
    this(fluent, new IntegrationSource());
  }
  
  public IntegrationSourceBuilder(IntegrationSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSourceBuilder(IntegrationSourceFluent<?> fluent,IntegrationSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSource build() {
    IntegrationSource buildable = new IntegrationSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}