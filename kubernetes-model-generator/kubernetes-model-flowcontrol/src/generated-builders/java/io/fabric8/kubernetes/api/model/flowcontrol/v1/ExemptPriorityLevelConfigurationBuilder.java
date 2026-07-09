package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExemptPriorityLevelConfigurationBuilder extends ExemptPriorityLevelConfigurationFluent<ExemptPriorityLevelConfigurationBuilder> implements VisitableBuilder<ExemptPriorityLevelConfiguration,ExemptPriorityLevelConfigurationBuilder>{

  ExemptPriorityLevelConfigurationFluent<?> fluent;

  public ExemptPriorityLevelConfigurationBuilder() {
    this(new ExemptPriorityLevelConfiguration());
  }
  
  public ExemptPriorityLevelConfigurationBuilder(ExemptPriorityLevelConfigurationFluent<?> fluent) {
    this(fluent, new ExemptPriorityLevelConfiguration());
  }
  
  public ExemptPriorityLevelConfigurationBuilder(ExemptPriorityLevelConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExemptPriorityLevelConfigurationBuilder(ExemptPriorityLevelConfigurationFluent<?> fluent,ExemptPriorityLevelConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExemptPriorityLevelConfiguration build() {
    ExemptPriorityLevelConfiguration buildable = new ExemptPriorityLevelConfiguration(fluent.getLendablePercent(), fluent.getNominalConcurrencyShares());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}