package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositePodGroupBuilder extends CompositePodGroupFluent<CompositePodGroupBuilder> implements VisitableBuilder<CompositePodGroup,CompositePodGroupBuilder>{

  CompositePodGroupFluent<?> fluent;

  public CompositePodGroupBuilder() {
    this(new CompositePodGroup());
  }
  
  public CompositePodGroupBuilder(CompositePodGroupFluent<?> fluent) {
    this(fluent, new CompositePodGroup());
  }
  
  public CompositePodGroupBuilder(CompositePodGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositePodGroupBuilder(CompositePodGroupFluent<?> fluent,CompositePodGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositePodGroup build() {
    CompositePodGroup buildable = new CompositePodGroup(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}