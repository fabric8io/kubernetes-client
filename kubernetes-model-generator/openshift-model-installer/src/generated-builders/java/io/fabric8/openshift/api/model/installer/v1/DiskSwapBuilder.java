package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskSwapBuilder extends DiskSwapFluent<DiskSwapBuilder> implements VisitableBuilder<DiskSwap,DiskSwapBuilder>{

  DiskSwapFluent<?> fluent;

  public DiskSwapBuilder() {
    this(new DiskSwap());
  }
  
  public DiskSwapBuilder(DiskSwapFluent<?> fluent) {
    this(fluent, new DiskSwap());
  }
  
  public DiskSwapBuilder(DiskSwap instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskSwapBuilder(DiskSwapFluent<?> fluent,DiskSwap instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskSwap build() {
    DiskSwap buildable = new DiskSwap(fluent.getPlatformDiskID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}