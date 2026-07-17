package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetadataBuilder extends MetadataFluent<MetadataBuilder> implements VisitableBuilder<Metadata,MetadataBuilder>{

  MetadataFluent<?> fluent;

  public MetadataBuilder() {
    this(new Metadata());
  }
  
  public MetadataBuilder(MetadataFluent<?> fluent) {
    this(fluent, new Metadata());
  }
  
  public MetadataBuilder(Metadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetadataBuilder(MetadataFluent<?> fluent,Metadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metadata build() {
    Metadata buildable = new Metadata(fluent.getBaseDomain(), fluent.getCisInstanceCRN(), fluent.getDnsInstanceCRN(), fluent.getPowerVSResourceGroup(), fluent.getRegion(), fluent.getServiceEndpoints(), fluent.getServiceInstanceGUID(), fluent.getTransitGatewayName(), fluent.getVpcName(), fluent.getVpcRegion(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}