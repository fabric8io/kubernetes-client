package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupSpecBuilder extends PodGroupSpecFluent<PodGroupSpecBuilder> implements VisitableBuilder<PodGroupSpec,PodGroupSpecBuilder>{

  PodGroupSpecFluent<?> fluent;

  public PodGroupSpecBuilder() {
    this(new PodGroupSpec());
  }
  
  public PodGroupSpecBuilder(PodGroupSpecFluent<?> fluent) {
    this(fluent, new PodGroupSpec());
  }
  
  public PodGroupSpecBuilder(PodGroupSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupSpecBuilder(PodGroupSpecFluent<?> fluent,PodGroupSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupSpec build() {
    PodGroupSpec buildable = new PodGroupSpec(fluent.getMinMember(), fluent.getMinResources(), fluent.getMinTaskMember(), fluent.getPriorityClassName(), fluent.getQueue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}