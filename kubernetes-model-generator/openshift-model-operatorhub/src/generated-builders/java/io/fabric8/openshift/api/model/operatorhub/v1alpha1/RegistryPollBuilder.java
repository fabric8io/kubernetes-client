package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistryPollBuilder extends RegistryPollFluent<RegistryPollBuilder> implements VisitableBuilder<RegistryPoll,RegistryPollBuilder>{

  RegistryPollFluent<?> fluent;

  public RegistryPollBuilder() {
    this(new RegistryPoll());
  }
  
  public RegistryPollBuilder(RegistryPollFluent<?> fluent) {
    this(fluent, new RegistryPoll());
  }
  
  public RegistryPollBuilder(RegistryPoll instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistryPollBuilder(RegistryPollFluent<?> fluent,RegistryPoll instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistryPoll build() {
    RegistryPoll buildable = new RegistryPoll(fluent.getInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}