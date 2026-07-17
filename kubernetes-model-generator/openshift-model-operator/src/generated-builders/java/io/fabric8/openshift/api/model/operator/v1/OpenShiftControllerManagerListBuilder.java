package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftControllerManagerListBuilder extends OpenShiftControllerManagerListFluent<OpenShiftControllerManagerListBuilder> implements VisitableBuilder<OpenShiftControllerManagerList,OpenShiftControllerManagerListBuilder>{

  OpenShiftControllerManagerListFluent<?> fluent;

  public OpenShiftControllerManagerListBuilder() {
    this(new OpenShiftControllerManagerList());
  }
  
  public OpenShiftControllerManagerListBuilder(OpenShiftControllerManagerListFluent<?> fluent) {
    this(fluent, new OpenShiftControllerManagerList());
  }
  
  public OpenShiftControllerManagerListBuilder(OpenShiftControllerManagerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftControllerManagerListBuilder(OpenShiftControllerManagerListFluent<?> fluent,OpenShiftControllerManagerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftControllerManagerList build() {
    OpenShiftControllerManagerList buildable = new OpenShiftControllerManagerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}