package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageManifestBuilder extends ImageManifestFluent<ImageManifestBuilder> implements VisitableBuilder<ImageManifest,ImageManifestBuilder>{

  ImageManifestFluent<?> fluent;

  public ImageManifestBuilder() {
    this(new ImageManifest());
  }
  
  public ImageManifestBuilder(ImageManifestFluent<?> fluent) {
    this(fluent, new ImageManifest());
  }
  
  public ImageManifestBuilder(ImageManifest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageManifestBuilder(ImageManifestFluent<?> fluent,ImageManifest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageManifest build() {
    ImageManifest buildable = new ImageManifest(fluent.getArchitecture(), fluent.getDigest(), fluent.getManifestSize(), fluent.getMediaType(), fluent.getOs(), fluent.getVariant());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}