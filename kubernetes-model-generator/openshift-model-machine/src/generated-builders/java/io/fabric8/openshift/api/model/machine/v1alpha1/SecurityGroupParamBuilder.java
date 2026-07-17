package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityGroupParamBuilder extends SecurityGroupParamFluent<SecurityGroupParamBuilder> implements VisitableBuilder<SecurityGroupParam,SecurityGroupParamBuilder>{

  SecurityGroupParamFluent<?> fluent;

  public SecurityGroupParamBuilder() {
    this(new SecurityGroupParam());
  }
  
  public SecurityGroupParamBuilder(SecurityGroupParamFluent<?> fluent) {
    this(fluent, new SecurityGroupParam());
  }
  
  public SecurityGroupParamBuilder(SecurityGroupParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityGroupParamBuilder(SecurityGroupParamFluent<?> fluent,SecurityGroupParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityGroupParam build() {
    SecurityGroupParam buildable = new SecurityGroupParam(fluent.buildFilter(), fluent.getName(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}