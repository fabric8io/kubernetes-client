package io.fabric8.openshift.api.model.hive.azure.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSDiskBuilder extends OSDiskFluent<OSDiskBuilder> implements VisitableBuilder<OSDisk,OSDiskBuilder>{

  OSDiskFluent<?> fluent;

  public OSDiskBuilder() {
    this(new OSDisk());
  }
  
  public OSDiskBuilder(OSDiskFluent<?> fluent) {
    this(fluent, new OSDisk());
  }
  
  public OSDiskBuilder(OSDisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSDiskBuilder(OSDiskFluent<?> fluent,OSDisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSDisk build() {
    OSDisk buildable = new OSDisk(fluent.buildDiskEncryptionSet(), fluent.getDiskSizeGB(), fluent.getDiskType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}