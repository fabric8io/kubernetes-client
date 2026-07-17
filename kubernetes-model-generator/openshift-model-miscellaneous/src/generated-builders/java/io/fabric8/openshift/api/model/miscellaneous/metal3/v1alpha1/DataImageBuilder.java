package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataImageBuilder extends DataImageFluent<DataImageBuilder> implements VisitableBuilder<DataImage,DataImageBuilder>{

  DataImageFluent<?> fluent;

  public DataImageBuilder() {
    this(new DataImage());
  }
  
  public DataImageBuilder(DataImageFluent<?> fluent) {
    this(fluent, new DataImage());
  }
  
  public DataImageBuilder(DataImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataImageBuilder(DataImageFluent<?> fluent,DataImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataImage build() {
    DataImage buildable = new DataImage(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}