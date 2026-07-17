package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubnetBuilder extends SubnetFluent<SubnetBuilder> implements VisitableBuilder<Subnet,SubnetBuilder>{

  SubnetFluent<?> fluent;

  public SubnetBuilder() {
    this(new Subnet());
  }
  
  public SubnetBuilder(SubnetFluent<?> fluent) {
    this(fluent, new Subnet());
  }
  
  public SubnetBuilder(Subnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubnetBuilder(SubnetFluent<?> fluent,Subnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Subnet build() {
    Subnet buildable = new Subnet(fluent.getId(), fluent.buildRoles());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}