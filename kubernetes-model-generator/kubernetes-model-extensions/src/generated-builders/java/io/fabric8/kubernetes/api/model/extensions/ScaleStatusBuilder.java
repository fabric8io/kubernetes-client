package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScaleStatusBuilder extends ScaleStatusFluent<ScaleStatusBuilder> implements VisitableBuilder<ScaleStatus,ScaleStatusBuilder>{

  ScaleStatusFluent<?> fluent;

  public ScaleStatusBuilder() {
    this(new ScaleStatus());
  }
  
  public ScaleStatusBuilder(ScaleStatusFluent<?> fluent) {
    this(fluent, new ScaleStatus());
  }
  
  public ScaleStatusBuilder(ScaleStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScaleStatusBuilder(ScaleStatusFluent<?> fluent,ScaleStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScaleStatus build() {
    ScaleStatus buildable = new ScaleStatus(fluent.getReplicas(), fluent.getSelector(), fluent.getTargetSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}