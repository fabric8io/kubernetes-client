package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepActionListBuilder extends StepActionListFluent<StepActionListBuilder> implements VisitableBuilder<StepActionList,StepActionListBuilder>{

  StepActionListFluent<?> fluent;

  public StepActionListBuilder() {
    this(new StepActionList());
  }
  
  public StepActionListBuilder(StepActionListFluent<?> fluent) {
    this(fluent, new StepActionList());
  }
  
  public StepActionListBuilder(StepActionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepActionListBuilder(StepActionListFluent<?> fluent,StepActionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepActionList build() {
    StepActionList buildable = new StepActionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}