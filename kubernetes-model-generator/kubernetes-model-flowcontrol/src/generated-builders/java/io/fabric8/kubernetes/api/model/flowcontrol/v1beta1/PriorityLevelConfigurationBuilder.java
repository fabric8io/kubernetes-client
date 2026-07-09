package io.fabric8.kubernetes.api.model.flowcontrol.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PriorityLevelConfigurationBuilder extends PriorityLevelConfigurationFluent<PriorityLevelConfigurationBuilder> implements VisitableBuilder<PriorityLevelConfiguration,PriorityLevelConfigurationBuilder>{

  PriorityLevelConfigurationFluent<?> fluent;

  public PriorityLevelConfigurationBuilder() {
    this(new PriorityLevelConfiguration());
  }
  
  public PriorityLevelConfigurationBuilder(PriorityLevelConfigurationFluent<?> fluent) {
    this(fluent, new PriorityLevelConfiguration());
  }
  
  public PriorityLevelConfigurationBuilder(PriorityLevelConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PriorityLevelConfigurationBuilder(PriorityLevelConfigurationFluent<?> fluent,PriorityLevelConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PriorityLevelConfiguration build() {
    PriorityLevelConfiguration buildable = new PriorityLevelConfiguration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}