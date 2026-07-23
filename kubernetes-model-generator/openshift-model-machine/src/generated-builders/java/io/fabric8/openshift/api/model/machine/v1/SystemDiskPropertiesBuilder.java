package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SystemDiskPropertiesBuilder extends SystemDiskPropertiesFluent<SystemDiskPropertiesBuilder> implements VisitableBuilder<SystemDiskProperties,SystemDiskPropertiesBuilder>{

  SystemDiskPropertiesFluent<?> fluent;

  public SystemDiskPropertiesBuilder() {
    this(new SystemDiskProperties());
  }
  
  public SystemDiskPropertiesBuilder(SystemDiskPropertiesFluent<?> fluent) {
    this(fluent, new SystemDiskProperties());
  }
  
  public SystemDiskPropertiesBuilder(SystemDiskProperties instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SystemDiskPropertiesBuilder(SystemDiskPropertiesFluent<?> fluent,SystemDiskProperties instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SystemDiskProperties build() {
    SystemDiskProperties buildable = new SystemDiskProperties(fluent.getCategory(), fluent.getName(), fluent.getPerformanceLevel(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}