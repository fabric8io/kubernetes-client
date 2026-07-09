package io.fabric8.kubernetes.api.model.resource.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceClassListBuilder extends DeviceClassListFluent<DeviceClassListBuilder> implements VisitableBuilder<DeviceClassList,DeviceClassListBuilder>{

  DeviceClassListFluent<?> fluent;

  public DeviceClassListBuilder() {
    this(new DeviceClassList());
  }
  
  public DeviceClassListBuilder(DeviceClassListFluent<?> fluent) {
    this(fluent, new DeviceClassList());
  }
  
  public DeviceClassListBuilder(DeviceClassList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceClassListBuilder(DeviceClassListFluent<?> fluent,DeviceClassList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceClassList build() {
    DeviceClassList buildable = new DeviceClassList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}