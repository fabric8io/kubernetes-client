package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CPUOptionsBuilder extends CPUOptionsFluent<CPUOptionsBuilder> implements VisitableBuilder<CPUOptions,CPUOptionsBuilder>{

  CPUOptionsFluent<?> fluent;

  public CPUOptionsBuilder() {
    this(new CPUOptions());
  }
  
  public CPUOptionsBuilder(CPUOptionsFluent<?> fluent) {
    this(fluent, new CPUOptions());
  }
  
  public CPUOptionsBuilder(CPUOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CPUOptionsBuilder(CPUOptionsFluent<?> fluent,CPUOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CPUOptions build() {
    CPUOptions buildable = new CPUOptions(fluent.getConfidentialCompute());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}