package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIDriverBuilder extends CSIDriverFluent<CSIDriverBuilder> implements VisitableBuilder<CSIDriver,CSIDriverBuilder>{

  CSIDriverFluent<?> fluent;

  public CSIDriverBuilder() {
    this(new CSIDriver());
  }
  
  public CSIDriverBuilder(CSIDriverFluent<?> fluent) {
    this(fluent, new CSIDriver());
  }
  
  public CSIDriverBuilder(CSIDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIDriverBuilder(CSIDriverFluent<?> fluent,CSIDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIDriver build() {
    CSIDriver buildable = new CSIDriver(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}