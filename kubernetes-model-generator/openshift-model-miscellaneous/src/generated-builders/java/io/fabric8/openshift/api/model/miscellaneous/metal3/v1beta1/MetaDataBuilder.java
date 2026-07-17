package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetaDataBuilder extends MetaDataFluent<MetaDataBuilder> implements VisitableBuilder<MetaData,MetaDataBuilder>{

  MetaDataFluent<?> fluent;

  public MetaDataBuilder() {
    this(new MetaData());
  }
  
  public MetaDataBuilder(MetaDataFluent<?> fluent) {
    this(fluent, new MetaData());
  }
  
  public MetaDataBuilder(MetaData instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetaDataBuilder(MetaDataFluent<?> fluent,MetaData instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetaData build() {
    MetaData buildable = new MetaData(fluent.buildDnsServersFromIPPool(), fluent.buildFromAnnotations(), fluent.buildFromHostInterfaces(), fluent.buildFromLabels(), fluent.buildGatewaysFromIPPool(), fluent.buildIndexes(), fluent.buildIpAddressesFromIPPool(), fluent.buildNamespaces(), fluent.buildObjectNames(), fluent.buildPrefixesFromIPPool(), fluent.buildStrings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}