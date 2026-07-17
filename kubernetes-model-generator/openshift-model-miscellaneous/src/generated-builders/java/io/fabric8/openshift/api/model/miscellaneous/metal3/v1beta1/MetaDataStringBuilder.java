package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataStringBuilder extends MetaDataStringFluent<MetaDataStringBuilder> implements VisitableBuilder<MetaDataString,MetaDataStringBuilder>{

  MetaDataStringFluent<?> fluent;

  public MetaDataStringBuilder() {
    this(new MetaDataString());
  }
  
  public MetaDataStringBuilder(MetaDataStringFluent<?> fluent) {
    this(fluent, new MetaDataString());
  }
  
  public MetaDataStringBuilder(MetaDataString instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataStringBuilder(MetaDataStringFluent<?> fluent,MetaDataString instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataString build() {
    MetaDataString buildable = new MetaDataString(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}