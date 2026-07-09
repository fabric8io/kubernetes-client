package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationReferenceBuilder extends PriorityLevelConfigurationReferenceFluent<PriorityLevelConfigurationReferenceBuilder> implements VisitableBuilder<PriorityLevelConfigurationReference,PriorityLevelConfigurationReferenceBuilder>{

  PriorityLevelConfigurationReferenceFluent<?> fluent;

  public PriorityLevelConfigurationReferenceBuilder() {
    this(new PriorityLevelConfigurationReference());
  }
  
  public PriorityLevelConfigurationReferenceBuilder(PriorityLevelConfigurationReferenceFluent<?> fluent) {
    this(fluent, new PriorityLevelConfigurationReference());
  }
  
  public PriorityLevelConfigurationReferenceBuilder(PriorityLevelConfigurationReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationReferenceBuilder(PriorityLevelConfigurationReferenceFluent<?> fluent,PriorityLevelConfigurationReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfigurationReference build() {
    PriorityLevelConfigurationReference buildable = new PriorityLevelConfigurationReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}