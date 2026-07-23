package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePrunerBuilder extends ImagePrunerFluent<ImagePrunerBuilder> implements VisitableBuilder<ImagePruner,ImagePrunerBuilder>{

  ImagePrunerFluent<?> fluent;

  public ImagePrunerBuilder() {
    this(new ImagePruner());
  }
  
  public ImagePrunerBuilder(ImagePrunerFluent<?> fluent) {
    this(fluent, new ImagePruner());
  }
  
  public ImagePrunerBuilder(ImagePruner instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePrunerBuilder(ImagePrunerFluent<?> fluent,ImagePruner instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePruner build() {
    ImagePruner buildable = new ImagePruner(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}