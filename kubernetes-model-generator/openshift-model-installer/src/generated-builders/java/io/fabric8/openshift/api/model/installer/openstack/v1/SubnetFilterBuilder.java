package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubnetFilterBuilder extends SubnetFilterFluent<SubnetFilterBuilder> implements VisitableBuilder<SubnetFilter,SubnetFilterBuilder>{

  SubnetFilterFluent<?> fluent;

  public SubnetFilterBuilder() {
    this(new SubnetFilter());
  }
  
  public SubnetFilterBuilder(SubnetFilterFluent<?> fluent) {
    this(fluent, new SubnetFilter());
  }
  
  public SubnetFilterBuilder(SubnetFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubnetFilterBuilder(SubnetFilterFluent<?> fluent,SubnetFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubnetFilter build() {
    SubnetFilter buildable = new SubnetFilter(fluent.getId(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}