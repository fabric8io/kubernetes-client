package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntegrationSinkBuilder extends IntegrationSinkFluent<IntegrationSinkBuilder> implements VisitableBuilder<IntegrationSink,IntegrationSinkBuilder>{

  IntegrationSinkFluent<?> fluent;

  public IntegrationSinkBuilder() {
    this(new IntegrationSink());
  }
  
  public IntegrationSinkBuilder(IntegrationSinkFluent<?> fluent) {
    this(fluent, new IntegrationSink());
  }
  
  public IntegrationSinkBuilder(IntegrationSink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntegrationSinkBuilder(IntegrationSinkFluent<?> fluent,IntegrationSink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntegrationSink build() {
    IntegrationSink buildable = new IntegrationSink(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}