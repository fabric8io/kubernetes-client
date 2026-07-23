package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataFromAnnotationBuilder extends MetaDataFromAnnotationFluent<MetaDataFromAnnotationBuilder> implements VisitableBuilder<MetaDataFromAnnotation,MetaDataFromAnnotationBuilder>{

  MetaDataFromAnnotationFluent<?> fluent;

  public MetaDataFromAnnotationBuilder() {
    this(new MetaDataFromAnnotation());
  }
  
  public MetaDataFromAnnotationBuilder(MetaDataFromAnnotationFluent<?> fluent) {
    this(fluent, new MetaDataFromAnnotation());
  }
  
  public MetaDataFromAnnotationBuilder(MetaDataFromAnnotation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataFromAnnotationBuilder(MetaDataFromAnnotationFluent<?> fluent,MetaDataFromAnnotation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataFromAnnotation build() {
    MetaDataFromAnnotation buildable = new MetaDataFromAnnotation(fluent.getAnnotation(), fluent.getKey(), fluent.getObject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}