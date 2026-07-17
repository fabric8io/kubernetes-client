package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereCSIDriverConfigSpecBuilder extends VSphereCSIDriverConfigSpecFluent<VSphereCSIDriverConfigSpecBuilder> implements VisitableBuilder<VSphereCSIDriverConfigSpec,VSphereCSIDriverConfigSpecBuilder>{

  VSphereCSIDriverConfigSpecFluent<?> fluent;

  public VSphereCSIDriverConfigSpecBuilder() {
    this(new VSphereCSIDriverConfigSpec());
  }
  
  public VSphereCSIDriverConfigSpecBuilder(VSphereCSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new VSphereCSIDriverConfigSpec());
  }
  
  public VSphereCSIDriverConfigSpecBuilder(VSphereCSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereCSIDriverConfigSpecBuilder(VSphereCSIDriverConfigSpecFluent<?> fluent,VSphereCSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereCSIDriverConfigSpec build() {
    VSphereCSIDriverConfigSpec buildable = new VSphereCSIDriverConfigSpec(fluent.getGlobalMaxSnapshotsPerBlockVolume(), fluent.getGranularMaxSnapshotsPerBlockVolumeInVSAN(), fluent.getGranularMaxSnapshotsPerBlockVolumeInVVOL(), fluent.getMaxAllowedBlockVolumesPerNode(), fluent.getTopologyCategories());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}