package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunBuilder extends CustomRunFluent<CustomRunBuilder> implements VisitableBuilder<CustomRun,CustomRunBuilder>{

  CustomRunFluent<?> fluent;

  public CustomRunBuilder() {
    this(new CustomRun());
  }
  
  public CustomRunBuilder(CustomRunFluent<?> fluent) {
    this(fluent, new CustomRun());
  }
  
  public CustomRunBuilder(CustomRun instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunBuilder(CustomRunFluent<?> fluent,CustomRun instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRun build() {
    CustomRun buildable = new CustomRun(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}