package io.fabric8.volcano.api.model.batch.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DependsOnBuilder extends DependsOnFluent<DependsOnBuilder> implements VisitableBuilder<DependsOn,DependsOnBuilder>{

  DependsOnFluent<?> fluent;

  public DependsOnBuilder() {
    this(new DependsOn());
  }
  
  public DependsOnBuilder(DependsOnFluent<?> fluent) {
    this(fluent, new DependsOn());
  }
  
  public DependsOnBuilder(DependsOn instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DependsOnBuilder(DependsOnFluent<?> fluent,DependsOn instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DependsOn build() {
    DependsOn buildable = new DependsOn(fluent.getIteration(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}