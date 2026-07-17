package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataObjectNameBuilder extends MetaDataObjectNameFluent<MetaDataObjectNameBuilder> implements VisitableBuilder<MetaDataObjectName,MetaDataObjectNameBuilder>{

  MetaDataObjectNameFluent<?> fluent;

  public MetaDataObjectNameBuilder() {
    this(new MetaDataObjectName());
  }
  
  public MetaDataObjectNameBuilder(MetaDataObjectNameFluent<?> fluent) {
    this(fluent, new MetaDataObjectName());
  }
  
  public MetaDataObjectNameBuilder(MetaDataObjectName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataObjectNameBuilder(MetaDataObjectNameFluent<?> fluent,MetaDataObjectName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataObjectName build() {
    MetaDataObjectName buildable = new MetaDataObjectName(fluent.getKey(), fluent.getObject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}