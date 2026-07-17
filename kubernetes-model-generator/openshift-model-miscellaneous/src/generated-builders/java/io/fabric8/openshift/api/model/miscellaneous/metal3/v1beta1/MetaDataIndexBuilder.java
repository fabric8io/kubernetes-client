package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataIndexBuilder extends MetaDataIndexFluent<MetaDataIndexBuilder> implements VisitableBuilder<MetaDataIndex,MetaDataIndexBuilder>{

  MetaDataIndexFluent<?> fluent;

  public MetaDataIndexBuilder() {
    this(new MetaDataIndex());
  }
  
  public MetaDataIndexBuilder(MetaDataIndexFluent<?> fluent) {
    this(fluent, new MetaDataIndex());
  }
  
  public MetaDataIndexBuilder(MetaDataIndex instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataIndexBuilder(MetaDataIndexFluent<?> fluent,MetaDataIndex instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataIndex build() {
    MetaDataIndex buildable = new MetaDataIndex(fluent.getKey(), fluent.getOffset(), fluent.getPrefix(), fluent.getStep(), fluent.getSuffix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}