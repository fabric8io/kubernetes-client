package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftAPIServerListBuilder extends OpenShiftAPIServerListFluent<OpenShiftAPIServerListBuilder> implements VisitableBuilder<OpenShiftAPIServerList,OpenShiftAPIServerListBuilder>{

  OpenShiftAPIServerListFluent<?> fluent;

  public OpenShiftAPIServerListBuilder() {
    this(new OpenShiftAPIServerList());
  }
  
  public OpenShiftAPIServerListBuilder(OpenShiftAPIServerListFluent<?> fluent) {
    this(fluent, new OpenShiftAPIServerList());
  }
  
  public OpenShiftAPIServerListBuilder(OpenShiftAPIServerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftAPIServerListBuilder(OpenShiftAPIServerListFluent<?> fluent,OpenShiftAPIServerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftAPIServerList build() {
    OpenShiftAPIServerList buildable = new OpenShiftAPIServerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}