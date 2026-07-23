package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SELinuxContextStrategyOptionsBuilder extends SELinuxContextStrategyOptionsFluent<SELinuxContextStrategyOptionsBuilder> implements VisitableBuilder<SELinuxContextStrategyOptions,SELinuxContextStrategyOptionsBuilder>{

  SELinuxContextStrategyOptionsFluent<?> fluent;

  public SELinuxContextStrategyOptionsBuilder() {
    this(new SELinuxContextStrategyOptions());
  }
  
  public SELinuxContextStrategyOptionsBuilder(SELinuxContextStrategyOptionsFluent<?> fluent) {
    this(fluent, new SELinuxContextStrategyOptions());
  }
  
  public SELinuxContextStrategyOptionsBuilder(SELinuxContextStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SELinuxContextStrategyOptionsBuilder(SELinuxContextStrategyOptionsFluent<?> fluent,SELinuxContextStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SELinuxContextStrategyOptions build() {
    SELinuxContextStrategyOptions buildable = new SELinuxContextStrategyOptions(fluent.getSeLinuxOptions(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}