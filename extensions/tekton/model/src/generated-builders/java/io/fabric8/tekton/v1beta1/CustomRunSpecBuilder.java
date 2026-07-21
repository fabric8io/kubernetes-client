package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomRunSpecBuilder extends CustomRunSpecFluent<CustomRunSpecBuilder> implements VisitableBuilder<CustomRunSpec,CustomRunSpecBuilder>{

  CustomRunSpecFluent<?> fluent;

  public CustomRunSpecBuilder() {
    this(new CustomRunSpec());
  }
  
  public CustomRunSpecBuilder(CustomRunSpecFluent<?> fluent) {
    this(fluent, new CustomRunSpec());
  }
  
  public CustomRunSpecBuilder(CustomRunSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomRunSpecBuilder(CustomRunSpecFluent<?> fluent,CustomRunSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomRunSpec build() {
    CustomRunSpec buildable = new CustomRunSpec(fluent.buildCustomRef(), fluent.buildCustomSpec(), fluent.buildParams(), fluent.getRetries(), fluent.getServiceAccountName(), fluent.getStatus(), fluent.getStatusMessage(), fluent.getTimeout(), fluent.buildWorkspaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}