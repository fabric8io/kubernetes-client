package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressServiceSpecBuilder extends EgressServiceSpecFluent<EgressServiceSpecBuilder> implements VisitableBuilder<EgressServiceSpec,EgressServiceSpecBuilder>{

  EgressServiceSpecFluent<?> fluent;

  public EgressServiceSpecBuilder() {
    this(new EgressServiceSpec());
  }
  
  public EgressServiceSpecBuilder(EgressServiceSpecFluent<?> fluent) {
    this(fluent, new EgressServiceSpec());
  }
  
  public EgressServiceSpecBuilder(EgressServiceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressServiceSpecBuilder(EgressServiceSpecFluent<?> fluent,EgressServiceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressServiceSpec build() {
    EgressServiceSpec buildable = new EgressServiceSpec(fluent.getNetwork(), fluent.buildNodeSelector(), fluent.getSourceIPBy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}