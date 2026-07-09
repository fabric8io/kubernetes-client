package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIStorageCapacityBuilder extends CSIStorageCapacityFluent<CSIStorageCapacityBuilder> implements VisitableBuilder<CSIStorageCapacity,CSIStorageCapacityBuilder>{

  CSIStorageCapacityFluent<?> fluent;

  public CSIStorageCapacityBuilder() {
    this(new CSIStorageCapacity());
  }
  
  public CSIStorageCapacityBuilder(CSIStorageCapacityFluent<?> fluent) {
    this(fluent, new CSIStorageCapacity());
  }
  
  public CSIStorageCapacityBuilder(CSIStorageCapacity instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIStorageCapacityBuilder(CSIStorageCapacityFluent<?> fluent,CSIStorageCapacity instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIStorageCapacity build() {
    CSIStorageCapacity buildable = new CSIStorageCapacity(fluent.getApiVersion(), fluent.getCapacity(), fluent.getKind(), fluent.getMaximumVolumeSize(), fluent.buildMetadata(), fluent.buildNodeTopology(), fluent.getStorageClassName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}