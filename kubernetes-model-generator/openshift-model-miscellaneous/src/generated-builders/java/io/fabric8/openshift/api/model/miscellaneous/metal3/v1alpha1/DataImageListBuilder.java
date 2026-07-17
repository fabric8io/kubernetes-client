package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DataImageListBuilder extends DataImageListFluent<DataImageListBuilder> implements VisitableBuilder<DataImageList,DataImageListBuilder>{

  DataImageListFluent<?> fluent;

  public DataImageListBuilder() {
    this(new DataImageList());
  }
  
  public DataImageListBuilder(DataImageListFluent<?> fluent) {
    this(fluent, new DataImageList());
  }
  
  public DataImageListBuilder(DataImageList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DataImageListBuilder(DataImageListFluent<?> fluent,DataImageList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DataImageList build() {
    DataImageList buildable = new DataImageList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}