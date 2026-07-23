package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPDiskBuilder extends GCPDiskFluent<GCPDiskBuilder> implements VisitableBuilder<GCPDisk,GCPDiskBuilder>{

  GCPDiskFluent<?> fluent;

  public GCPDiskBuilder() {
    this(new GCPDisk());
  }
  
  public GCPDiskBuilder(GCPDiskFluent<?> fluent) {
    this(fluent, new GCPDisk());
  }
  
  public GCPDiskBuilder(GCPDisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPDiskBuilder(GCPDiskFluent<?> fluent,GCPDisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPDisk build() {
    GCPDisk buildable = new GCPDisk(fluent.getAutoDelete(), fluent.getBoot(), fluent.buildEncryptionKey(), fluent.getImage(), fluent.getLabels(), fluent.getSizeGb(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}