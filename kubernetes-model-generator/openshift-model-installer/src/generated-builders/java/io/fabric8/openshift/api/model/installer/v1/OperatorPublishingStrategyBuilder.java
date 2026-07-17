package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorPublishingStrategyBuilder extends OperatorPublishingStrategyFluent<OperatorPublishingStrategyBuilder> implements VisitableBuilder<OperatorPublishingStrategy,OperatorPublishingStrategyBuilder>{

  OperatorPublishingStrategyFluent<?> fluent;

  public OperatorPublishingStrategyBuilder() {
    this(new OperatorPublishingStrategy());
  }
  
  public OperatorPublishingStrategyBuilder(OperatorPublishingStrategyFluent<?> fluent) {
    this(fluent, new OperatorPublishingStrategy());
  }
  
  public OperatorPublishingStrategyBuilder(OperatorPublishingStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorPublishingStrategyBuilder(OperatorPublishingStrategyFluent<?> fluent,OperatorPublishingStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorPublishingStrategy build() {
    OperatorPublishingStrategy buildable = new OperatorPublishingStrategy(fluent.getApiserver(), fluent.getIngress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}