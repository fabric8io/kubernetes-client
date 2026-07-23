package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftAPIServerBuilder extends OpenShiftAPIServerFluent<OpenShiftAPIServerBuilder> implements VisitableBuilder<OpenShiftAPIServer,OpenShiftAPIServerBuilder>{

  OpenShiftAPIServerFluent<?> fluent;

  public OpenShiftAPIServerBuilder() {
    this(new OpenShiftAPIServer());
  }
  
  public OpenShiftAPIServerBuilder(OpenShiftAPIServerFluent<?> fluent) {
    this(fluent, new OpenShiftAPIServer());
  }
  
  public OpenShiftAPIServerBuilder(OpenShiftAPIServer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftAPIServerBuilder(OpenShiftAPIServerFluent<?> fluent,OpenShiftAPIServer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftAPIServer build() {
    OpenShiftAPIServer buildable = new OpenShiftAPIServer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}