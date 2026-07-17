package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftControllerManagerBuilder extends OpenShiftControllerManagerFluent<OpenShiftControllerManagerBuilder> implements VisitableBuilder<OpenShiftControllerManager,OpenShiftControllerManagerBuilder>{

  OpenShiftControllerManagerFluent<?> fluent;

  public OpenShiftControllerManagerBuilder() {
    this(new OpenShiftControllerManager());
  }
  
  public OpenShiftControllerManagerBuilder(OpenShiftControllerManagerFluent<?> fluent) {
    this(fluent, new OpenShiftControllerManager());
  }
  
  public OpenShiftControllerManagerBuilder(OpenShiftControllerManager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftControllerManagerBuilder(OpenShiftControllerManagerFluent<?> fluent,OpenShiftControllerManager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftControllerManager build() {
    OpenShiftControllerManager buildable = new OpenShiftControllerManager(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}