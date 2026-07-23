package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SELinuxStrategyOptionsBuilder extends SELinuxStrategyOptionsFluent<SELinuxStrategyOptionsBuilder> implements VisitableBuilder<SELinuxStrategyOptions,SELinuxStrategyOptionsBuilder>{

  SELinuxStrategyOptionsFluent<?> fluent;

  public SELinuxStrategyOptionsBuilder() {
    this(new SELinuxStrategyOptions());
  }
  
  public SELinuxStrategyOptionsBuilder(SELinuxStrategyOptionsFluent<?> fluent) {
    this(fluent, new SELinuxStrategyOptions());
  }
  
  public SELinuxStrategyOptionsBuilder(SELinuxStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SELinuxStrategyOptionsBuilder(SELinuxStrategyOptionsFluent<?> fluent,SELinuxStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SELinuxStrategyOptions build() {
    SELinuxStrategyOptions buildable = new SELinuxStrategyOptions(fluent.getRule(), fluent.getSeLinuxOptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}