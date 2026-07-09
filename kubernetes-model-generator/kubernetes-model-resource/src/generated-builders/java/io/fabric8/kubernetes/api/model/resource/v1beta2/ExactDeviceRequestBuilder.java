package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExactDeviceRequestBuilder extends ExactDeviceRequestFluent<ExactDeviceRequestBuilder> implements VisitableBuilder<ExactDeviceRequest,ExactDeviceRequestBuilder>{

  ExactDeviceRequestFluent<?> fluent;

  public ExactDeviceRequestBuilder() {
    this(new ExactDeviceRequest());
  }
  
  public ExactDeviceRequestBuilder(ExactDeviceRequestFluent<?> fluent) {
    this(fluent, new ExactDeviceRequest());
  }
  
  public ExactDeviceRequestBuilder(ExactDeviceRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExactDeviceRequestBuilder(ExactDeviceRequestFluent<?> fluent,ExactDeviceRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExactDeviceRequest build() {
    ExactDeviceRequest buildable = new ExactDeviceRequest(fluent.getAdminAccess(), fluent.getAllocationMode(), fluent.buildCapacity(), fluent.getCount(), fluent.getDeviceClassName(), fluent.buildSelectors(), fluent.buildTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}