package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootstrapInPlaceBuilder extends BootstrapInPlaceFluent<BootstrapInPlaceBuilder> implements VisitableBuilder<BootstrapInPlace,BootstrapInPlaceBuilder>{

  BootstrapInPlaceFluent<?> fluent;

  public BootstrapInPlaceBuilder() {
    this(new BootstrapInPlace());
  }
  
  public BootstrapInPlaceBuilder(BootstrapInPlaceFluent<?> fluent) {
    this(fluent, new BootstrapInPlace());
  }
  
  public BootstrapInPlaceBuilder(BootstrapInPlace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootstrapInPlaceBuilder(BootstrapInPlaceFluent<?> fluent,BootstrapInPlace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BootstrapInPlace build() {
    BootstrapInPlace buildable = new BootstrapInPlace(fluent.getInstallationDisk());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}