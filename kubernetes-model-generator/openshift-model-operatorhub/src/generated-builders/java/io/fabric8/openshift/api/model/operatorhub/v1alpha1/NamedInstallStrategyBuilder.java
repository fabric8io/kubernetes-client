package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedInstallStrategyBuilder extends NamedInstallStrategyFluent<NamedInstallStrategyBuilder> implements VisitableBuilder<NamedInstallStrategy,NamedInstallStrategyBuilder>{

  NamedInstallStrategyFluent<?> fluent;

  public NamedInstallStrategyBuilder() {
    this(new NamedInstallStrategy());
  }
  
  public NamedInstallStrategyBuilder(NamedInstallStrategyFluent<?> fluent) {
    this(fluent, new NamedInstallStrategy());
  }
  
  public NamedInstallStrategyBuilder(NamedInstallStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedInstallStrategyBuilder(NamedInstallStrategyFluent<?> fluent,NamedInstallStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedInstallStrategy build() {
    NamedInstallStrategy buildable = new NamedInstallStrategy(fluent.buildSpec(), fluent.getStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}