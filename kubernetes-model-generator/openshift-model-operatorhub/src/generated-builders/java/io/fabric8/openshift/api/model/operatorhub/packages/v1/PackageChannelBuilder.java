package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageChannelBuilder extends PackageChannelFluent<PackageChannelBuilder> implements VisitableBuilder<PackageChannel,PackageChannelBuilder>{

  PackageChannelFluent<?> fluent;

  public PackageChannelBuilder() {
    this(new PackageChannel());
  }
  
  public PackageChannelBuilder(PackageChannelFluent<?> fluent) {
    this(fluent, new PackageChannel());
  }
  
  public PackageChannelBuilder(PackageChannel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageChannelBuilder(PackageChannelFluent<?> fluent,PackageChannel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageChannel build() {
    PackageChannel buildable = new PackageChannel(fluent.getCurrentCSV(), fluent.buildCurrentCSVDesc(), fluent.buildDeprecation(), fluent.buildEntries(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}