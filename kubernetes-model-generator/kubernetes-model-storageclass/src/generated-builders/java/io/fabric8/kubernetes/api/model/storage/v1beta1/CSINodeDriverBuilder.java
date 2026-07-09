package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSINodeDriverBuilder extends CSINodeDriverFluent<CSINodeDriverBuilder> implements VisitableBuilder<CSINodeDriver,CSINodeDriverBuilder>{

  CSINodeDriverFluent<?> fluent;

  public CSINodeDriverBuilder() {
    this(new CSINodeDriver());
  }
  
  public CSINodeDriverBuilder(CSINodeDriverFluent<?> fluent) {
    this(fluent, new CSINodeDriver());
  }
  
  public CSINodeDriverBuilder(CSINodeDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSINodeDriverBuilder(CSINodeDriverFluent<?> fluent,CSINodeDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSINodeDriver build() {
    CSINodeDriver buildable = new CSINodeDriver(fluent.buildAllocatable(), fluent.getName(), fluent.getNodeID(), fluent.getTopologyKeys());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}