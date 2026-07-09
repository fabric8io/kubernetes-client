package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIDriverSpecBuilder extends CSIDriverSpecFluent<CSIDriverSpecBuilder> implements VisitableBuilder<CSIDriverSpec,CSIDriverSpecBuilder>{

  CSIDriverSpecFluent<?> fluent;

  public CSIDriverSpecBuilder() {
    this(new CSIDriverSpec());
  }
  
  public CSIDriverSpecBuilder(CSIDriverSpecFluent<?> fluent) {
    this(fluent, new CSIDriverSpec());
  }
  
  public CSIDriverSpecBuilder(CSIDriverSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIDriverSpecBuilder(CSIDriverSpecFluent<?> fluent,CSIDriverSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIDriverSpec build() {
    CSIDriverSpec buildable = new CSIDriverSpec(fluent.getAttachRequired(), fluent.getFsGroupPolicy(), fluent.getPodInfoOnMount(), fluent.getRequiresRepublish(), fluent.getStorageCapacity(), fluent.buildTokenRequests(), fluent.getVolumeLifecycleModes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}