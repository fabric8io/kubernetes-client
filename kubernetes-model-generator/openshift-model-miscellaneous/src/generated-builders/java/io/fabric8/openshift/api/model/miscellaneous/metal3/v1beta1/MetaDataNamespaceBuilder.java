package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataNamespaceBuilder extends MetaDataNamespaceFluent<MetaDataNamespaceBuilder> implements VisitableBuilder<MetaDataNamespace,MetaDataNamespaceBuilder>{

  MetaDataNamespaceFluent<?> fluent;

  public MetaDataNamespaceBuilder() {
    this(new MetaDataNamespace());
  }
  
  public MetaDataNamespaceBuilder(MetaDataNamespaceFluent<?> fluent) {
    this(fluent, new MetaDataNamespace());
  }
  
  public MetaDataNamespaceBuilder(MetaDataNamespace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataNamespaceBuilder(MetaDataNamespaceFluent<?> fluent,MetaDataNamespace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataNamespace build() {
    MetaDataNamespace buildable = new MetaDataNamespace(fluent.getKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}