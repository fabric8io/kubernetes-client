package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceSubRequestBuilder extends DeviceSubRequestFluent<DeviceSubRequestBuilder> implements VisitableBuilder<DeviceSubRequest,DeviceSubRequestBuilder>{

  DeviceSubRequestFluent<?> fluent;

  public DeviceSubRequestBuilder() {
    this(new DeviceSubRequest());
  }
  
  public DeviceSubRequestBuilder(DeviceSubRequestFluent<?> fluent) {
    this(fluent, new DeviceSubRequest());
  }
  
  public DeviceSubRequestBuilder(DeviceSubRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceSubRequestBuilder(DeviceSubRequestFluent<?> fluent,DeviceSubRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceSubRequest build() {
    DeviceSubRequest buildable = new DeviceSubRequest(fluent.getAllocationMode(), fluent.buildCapacity(), fluent.getCount(), fluent.getDeviceClassName(), fluent.getName(), fluent.buildSelectors(), fluent.buildTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}