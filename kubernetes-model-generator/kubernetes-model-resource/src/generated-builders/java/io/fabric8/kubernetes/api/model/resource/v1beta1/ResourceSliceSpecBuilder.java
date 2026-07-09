package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceSliceSpecBuilder extends ResourceSliceSpecFluent<ResourceSliceSpecBuilder> implements VisitableBuilder<ResourceSliceSpec,ResourceSliceSpecBuilder>{

  ResourceSliceSpecFluent<?> fluent;

  public ResourceSliceSpecBuilder() {
    this(new ResourceSliceSpec());
  }
  
  public ResourceSliceSpecBuilder(ResourceSliceSpecFluent<?> fluent) {
    this(fluent, new ResourceSliceSpec());
  }
  
  public ResourceSliceSpecBuilder(ResourceSliceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceSliceSpecBuilder(ResourceSliceSpecFluent<?> fluent,ResourceSliceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceSliceSpec build() {
    ResourceSliceSpec buildable = new ResourceSliceSpec(fluent.getAllNodes(), fluent.buildDevices(), fluent.getDriver(), fluent.getNodeName(), fluent.getNodeSelector(), fluent.getPerDeviceNodeSelection(), fluent.buildPool(), fluent.buildSharedCounters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}