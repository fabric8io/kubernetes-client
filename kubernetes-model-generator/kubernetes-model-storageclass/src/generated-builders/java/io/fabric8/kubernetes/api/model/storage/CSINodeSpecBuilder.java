package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSINodeSpecBuilder extends CSINodeSpecFluent<CSINodeSpecBuilder> implements VisitableBuilder<CSINodeSpec,CSINodeSpecBuilder>{

  CSINodeSpecFluent<?> fluent;

  public CSINodeSpecBuilder() {
    this(new CSINodeSpec());
  }
  
  public CSINodeSpecBuilder(CSINodeSpecFluent<?> fluent) {
    this(fluent, new CSINodeSpec());
  }
  
  public CSINodeSpecBuilder(CSINodeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSINodeSpecBuilder(CSINodeSpecFluent<?> fluent,CSINodeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSINodeSpec build() {
    CSINodeSpec buildable = new CSINodeSpec(fluent.buildDrivers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}