package io.fabric8.openshift.api.model.installer.ovirt.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AffinityGroupBuilder extends AffinityGroupFluent<AffinityGroupBuilder> implements VisitableBuilder<AffinityGroup,AffinityGroupBuilder>{

  AffinityGroupFluent<?> fluent;

  public AffinityGroupBuilder() {
    this(new AffinityGroup());
  }
  
  public AffinityGroupBuilder(AffinityGroupFluent<?> fluent) {
    this(fluent, new AffinityGroup());
  }
  
  public AffinityGroupBuilder(AffinityGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AffinityGroupBuilder(AffinityGroupFluent<?> fluent,AffinityGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AffinityGroup build() {
    AffinityGroup buildable = new AffinityGroup(fluent.getDescription(), fluent.getEnforcing(), fluent.getName(), fluent.getPriority());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}