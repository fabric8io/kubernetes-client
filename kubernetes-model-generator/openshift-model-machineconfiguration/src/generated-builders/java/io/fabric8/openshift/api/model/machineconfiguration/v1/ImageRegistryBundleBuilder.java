package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageRegistryBundleBuilder extends ImageRegistryBundleFluent<ImageRegistryBundleBuilder> implements VisitableBuilder<ImageRegistryBundle,ImageRegistryBundleBuilder>{

  ImageRegistryBundleFluent<?> fluent;

  public ImageRegistryBundleBuilder() {
    this(new ImageRegistryBundle());
  }
  
  public ImageRegistryBundleBuilder(ImageRegistryBundleFluent<?> fluent) {
    this(fluent, new ImageRegistryBundle());
  }
  
  public ImageRegistryBundleBuilder(ImageRegistryBundle instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageRegistryBundleBuilder(ImageRegistryBundleFluent<?> fluent,ImageRegistryBundle instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageRegistryBundle build() {
    ImageRegistryBundle buildable = new ImageRegistryBundle(fluent.getData(), fluent.getFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}