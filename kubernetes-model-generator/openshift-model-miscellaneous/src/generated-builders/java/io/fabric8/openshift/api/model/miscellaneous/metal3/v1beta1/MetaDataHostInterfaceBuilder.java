package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataHostInterfaceBuilder extends MetaDataHostInterfaceFluent<MetaDataHostInterfaceBuilder> implements VisitableBuilder<MetaDataHostInterface,MetaDataHostInterfaceBuilder>{

  MetaDataHostInterfaceFluent<?> fluent;

  public MetaDataHostInterfaceBuilder() {
    this(new MetaDataHostInterface());
  }
  
  public MetaDataHostInterfaceBuilder(MetaDataHostInterfaceFluent<?> fluent) {
    this(fluent, new MetaDataHostInterface());
  }
  
  public MetaDataHostInterfaceBuilder(MetaDataHostInterface instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataHostInterfaceBuilder(MetaDataHostInterfaceFluent<?> fluent,MetaDataHostInterface instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaDataHostInterface build() {
    MetaDataHostInterface buildable = new MetaDataHostInterface(fluent.getFromBootMAC(), fluent.getInterface(), fluent.getKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}