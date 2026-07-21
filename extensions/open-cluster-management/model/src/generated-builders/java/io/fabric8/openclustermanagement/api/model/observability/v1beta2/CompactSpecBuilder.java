package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompactSpecBuilder extends CompactSpecFluent<CompactSpecBuilder> implements VisitableBuilder<CompactSpec,CompactSpecBuilder>{

  CompactSpecFluent<?> fluent;

  public CompactSpecBuilder() {
    this(new CompactSpec());
  }
  
  public CompactSpecBuilder(CompactSpecFluent<?> fluent) {
    this(fluent, new CompactSpec());
  }
  
  public CompactSpecBuilder(CompactSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompactSpecBuilder(CompactSpecFluent<?> fluent,CompactSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompactSpec build() {
    CompactSpec buildable = new CompactSpec(fluent.buildContainers(), fluent.buildResources(), fluent.getServiceAccountAnnotations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}