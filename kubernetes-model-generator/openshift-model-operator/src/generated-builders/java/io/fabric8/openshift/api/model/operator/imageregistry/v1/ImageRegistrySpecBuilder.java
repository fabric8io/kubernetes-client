package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistrySpecBuilder extends ImageRegistrySpecFluent<ImageRegistrySpecBuilder> implements VisitableBuilder<ImageRegistrySpec,ImageRegistrySpecBuilder>{

  ImageRegistrySpecFluent<?> fluent;

  public ImageRegistrySpecBuilder() {
    this(new ImageRegistrySpec());
  }
  
  public ImageRegistrySpecBuilder(ImageRegistrySpecFluent<?> fluent) {
    this(fluent, new ImageRegistrySpec());
  }
  
  public ImageRegistrySpecBuilder(ImageRegistrySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistrySpecBuilder(ImageRegistrySpecFluent<?> fluent,ImageRegistrySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistrySpec build() {
    ImageRegistrySpec buildable = new ImageRegistrySpec(fluent.getAffinity(), fluent.getDefaultRoute(), fluent.getDisableRedirect(), fluent.getHttpSecret(), fluent.getLogLevel(), fluent.getLogging(), fluent.getManagementState(), fluent.getNodeSelector(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.buildProxy(), fluent.getReadOnly(), fluent.getReplicas(), fluent.buildRequests(), fluent.buildResources(), fluent.getRolloutStrategy(), fluent.buildRoutes(), fluent.buildStorage(), fluent.getTolerations(), fluent.getTopologySpreadConstraints(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}