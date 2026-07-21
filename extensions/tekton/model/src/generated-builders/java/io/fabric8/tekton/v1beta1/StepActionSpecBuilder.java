package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepActionSpecBuilder extends StepActionSpecFluent<StepActionSpecBuilder> implements VisitableBuilder<StepActionSpec,StepActionSpecBuilder>{

  StepActionSpecFluent<?> fluent;

  public StepActionSpecBuilder() {
    this(new StepActionSpec());
  }
  
  public StepActionSpecBuilder(StepActionSpecFluent<?> fluent) {
    this(fluent, new StepActionSpec());
  }
  
  public StepActionSpecBuilder(StepActionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepActionSpecBuilder(StepActionSpecFluent<?> fluent,StepActionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepActionSpec build() {
    StepActionSpec buildable = new StepActionSpec(fluent.getArgs(), fluent.getCommand(), fluent.getDescription(), fluent.buildEnv(), fluent.getImage(), fluent.buildParams(), fluent.buildResults(), fluent.getScript(), fluent.getSecurityContext(), fluent.buildVolumeMounts(), fluent.getWorkingDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}