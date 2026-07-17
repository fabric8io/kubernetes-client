package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubnetParamBuilder extends SubnetParamFluent<SubnetParamBuilder> implements VisitableBuilder<SubnetParam,SubnetParamBuilder>{

  SubnetParamFluent<?> fluent;

  public SubnetParamBuilder() {
    this(new SubnetParam());
  }
  
  public SubnetParamBuilder(SubnetParamFluent<?> fluent) {
    this(fluent, new SubnetParam());
  }
  
  public SubnetParamBuilder(SubnetParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubnetParamBuilder(SubnetParamFluent<?> fluent,SubnetParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubnetParam build() {
    SubnetParam buildable = new SubnetParam(fluent.buildFilter(), fluent.getPortSecurity(), fluent.getPortTags(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}