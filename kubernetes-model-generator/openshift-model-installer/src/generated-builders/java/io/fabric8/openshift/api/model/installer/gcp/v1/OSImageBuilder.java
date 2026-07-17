package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OSImageBuilder extends OSImageFluent<OSImageBuilder> implements VisitableBuilder<OSImage,OSImageBuilder>{

  OSImageFluent<?> fluent;

  public OSImageBuilder() {
    this(new OSImage());
  }
  
  public OSImageBuilder(OSImageFluent<?> fluent) {
    this(fluent, new OSImage());
  }
  
  public OSImageBuilder(OSImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OSImageBuilder(OSImageFluent<?> fluent,OSImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OSImage build() {
    OSImage buildable = new OSImage(fluent.getName(), fluent.getProject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}