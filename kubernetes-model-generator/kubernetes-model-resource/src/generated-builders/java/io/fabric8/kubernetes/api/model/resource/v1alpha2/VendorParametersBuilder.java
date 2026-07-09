package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VendorParametersBuilder extends VendorParametersFluent<VendorParametersBuilder> implements VisitableBuilder<VendorParameters,VendorParametersBuilder>{

  VendorParametersFluent<?> fluent;

  public VendorParametersBuilder() {
    this(new VendorParameters());
  }
  
  public VendorParametersBuilder(VendorParametersFluent<?> fluent) {
    this(fluent, new VendorParameters());
  }
  
  public VendorParametersBuilder(VendorParameters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VendorParametersBuilder(VendorParametersFluent<?> fluent,VendorParameters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VendorParameters build() {
    VendorParameters buildable = new VendorParameters(fluent.getDriverName(), fluent.getParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}