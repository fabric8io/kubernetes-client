package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceRequestBuilder extends DeviceRequestFluent<DeviceRequestBuilder> implements VisitableBuilder<DeviceRequest,DeviceRequestBuilder>{

  DeviceRequestFluent<?> fluent;

  public DeviceRequestBuilder() {
    this(new DeviceRequest());
  }
  
  public DeviceRequestBuilder(DeviceRequestFluent<?> fluent) {
    this(fluent, new DeviceRequest());
  }
  
  public DeviceRequestBuilder(DeviceRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceRequestBuilder(DeviceRequestFluent<?> fluent,DeviceRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceRequest build() {
    DeviceRequest buildable = new DeviceRequest(fluent.getAdminAccess(), fluent.getAllocationMode(), fluent.buildCapacity(), fluent.getCount(), fluent.getDeviceClassName(), fluent.buildFirstAvailable(), fluent.getName(), fluent.buildSelectors(), fluent.buildTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}