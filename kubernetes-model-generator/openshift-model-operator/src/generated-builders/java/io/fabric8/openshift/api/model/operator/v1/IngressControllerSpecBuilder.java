package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerSpecBuilder extends IngressControllerSpecFluent<IngressControllerSpecBuilder> implements VisitableBuilder<IngressControllerSpec,IngressControllerSpecBuilder>{

  IngressControllerSpecFluent<?> fluent;

  public IngressControllerSpecBuilder() {
    this(new IngressControllerSpec());
  }
  
  public IngressControllerSpecBuilder(IngressControllerSpecFluent<?> fluent) {
    this(fluent, new IngressControllerSpec());
  }
  
  public IngressControllerSpecBuilder(IngressControllerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerSpecBuilder(IngressControllerSpecFluent<?> fluent,IngressControllerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerSpec build() {
    IngressControllerSpec buildable = new IngressControllerSpec(fluent.buildClientTLS(), fluent.getClosedClientConnectionPolicy(), fluent.buildDefaultCertificate(), fluent.getDomain(), fluent.buildEndpointPublishingStrategy(), fluent.buildHttpCompression(), fluent.getHttpEmptyRequestsPolicy(), fluent.getHttpErrorCodePages(), fluent.buildHttpHeaders(), fluent.getIdleConnectionTerminationPolicy(), fluent.buildLogging(), fluent.buildNamespaceSelector(), fluent.buildNodePlacement(), fluent.getReplicas(), fluent.buildRouteAdmission(), fluent.buildRouteSelector(), fluent.getTlsSecurityProfile(), fluent.buildTuningOptions(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}