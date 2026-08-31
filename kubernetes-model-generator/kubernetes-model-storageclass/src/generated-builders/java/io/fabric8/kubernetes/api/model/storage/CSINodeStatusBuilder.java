package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSINodeStatusBuilder extends CSINodeStatusFluent<CSINodeStatusBuilder> implements VisitableBuilder<CSINodeStatus,CSINodeStatusBuilder>{

  CSINodeStatusFluent<?> fluent;

  public CSINodeStatusBuilder() {
    this(new CSINodeStatus());
  }
  
  public CSINodeStatusBuilder(CSINodeStatusFluent<?> fluent) {
    this(fluent, new CSINodeStatus());
  }
  
  public CSINodeStatusBuilder(CSINodeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSINodeStatusBuilder(CSINodeStatusFluent<?> fluent,CSINodeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSINodeStatus build() {
    CSINodeStatus buildable = new CSINodeStatus(fluent.buildStorageHealth());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}