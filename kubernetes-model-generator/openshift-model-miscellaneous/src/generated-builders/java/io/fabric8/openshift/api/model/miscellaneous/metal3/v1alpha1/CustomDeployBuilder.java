package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomDeployBuilder extends CustomDeployFluent<CustomDeployBuilder> implements VisitableBuilder<CustomDeploy,CustomDeployBuilder>{

  CustomDeployFluent<?> fluent;

  public CustomDeployBuilder() {
    this(new CustomDeploy());
  }
  
  public CustomDeployBuilder(CustomDeployFluent<?> fluent) {
    this(fluent, new CustomDeploy());
  }
  
  public CustomDeployBuilder(CustomDeploy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomDeployBuilder(CustomDeployFluent<?> fluent,CustomDeploy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomDeploy build() {
    CustomDeploy buildable = new CustomDeploy(fluent.getMethod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}