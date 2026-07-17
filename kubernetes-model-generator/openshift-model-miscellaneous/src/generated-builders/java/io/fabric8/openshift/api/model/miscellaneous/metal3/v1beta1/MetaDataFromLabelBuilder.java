package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataFromLabelBuilder extends MetaDataFromLabelFluent<MetaDataFromLabelBuilder> implements VisitableBuilder<MetaDataFromLabel,MetaDataFromLabelBuilder>{

  MetaDataFromLabelFluent<?> fluent;

  public MetaDataFromLabelBuilder() {
    this(new MetaDataFromLabel());
  }
  
  public MetaDataFromLabelBuilder(MetaDataFromLabelFluent<?> fluent) {
    this(fluent, new MetaDataFromLabel());
  }
  
  public MetaDataFromLabelBuilder(MetaDataFromLabel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataFromLabelBuilder(MetaDataFromLabelFluent<?> fluent,MetaDataFromLabel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataFromLabel build() {
    MetaDataFromLabel buildable = new MetaDataFromLabel(fluent.getKey(), fluent.getLabel(), fluent.getObject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}