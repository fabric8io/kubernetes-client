package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DriverRequestsBuilder extends DriverRequestsFluent<DriverRequestsBuilder> implements VisitableBuilder<DriverRequests,DriverRequestsBuilder>{

  DriverRequestsFluent<?> fluent;

  public DriverRequestsBuilder() {
    this(new DriverRequests());
  }
  
  public DriverRequestsBuilder(DriverRequestsFluent<?> fluent) {
    this(fluent, new DriverRequests());
  }
  
  public DriverRequestsBuilder(DriverRequests instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DriverRequestsBuilder(DriverRequestsFluent<?> fluent,DriverRequests instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DriverRequests build() {
    DriverRequests buildable = new DriverRequests(fluent.getDriverName(), fluent.buildRequests(), fluent.getVendorParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}