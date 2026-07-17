package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIDriverConfigSpecBuilder extends CSIDriverConfigSpecFluent<CSIDriverConfigSpecBuilder> implements VisitableBuilder<CSIDriverConfigSpec,CSIDriverConfigSpecBuilder>{

  CSIDriverConfigSpecFluent<?> fluent;

  public CSIDriverConfigSpecBuilder() {
    this(new CSIDriverConfigSpec());
  }
  
  public CSIDriverConfigSpecBuilder(CSIDriverConfigSpecFluent<?> fluent) {
    this(fluent, new CSIDriverConfigSpec());
  }
  
  public CSIDriverConfigSpecBuilder(CSIDriverConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIDriverConfigSpecBuilder(CSIDriverConfigSpecFluent<?> fluent,CSIDriverConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIDriverConfigSpec build() {
    CSIDriverConfigSpec buildable = new CSIDriverConfigSpec(fluent.buildAws(), fluent.buildAzure(), fluent.getDriverType(), fluent.buildGcp(), fluent.buildIbmcloud(), fluent.buildVSphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}