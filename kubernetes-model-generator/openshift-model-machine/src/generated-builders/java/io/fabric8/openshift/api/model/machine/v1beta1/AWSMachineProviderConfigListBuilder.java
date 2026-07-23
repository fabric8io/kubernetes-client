package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSMachineProviderConfigListBuilder extends AWSMachineProviderConfigListFluent<AWSMachineProviderConfigListBuilder> implements VisitableBuilder<AWSMachineProviderConfigList,AWSMachineProviderConfigListBuilder>{

  AWSMachineProviderConfigListFluent<?> fluent;

  public AWSMachineProviderConfigListBuilder() {
    this(new AWSMachineProviderConfigList());
  }
  
  public AWSMachineProviderConfigListBuilder(AWSMachineProviderConfigListFluent<?> fluent) {
    this(fluent, new AWSMachineProviderConfigList());
  }
  
  public AWSMachineProviderConfigListBuilder(AWSMachineProviderConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSMachineProviderConfigListBuilder(AWSMachineProviderConfigListFluent<?> fluent,AWSMachineProviderConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSMachineProviderConfigList build() {
    AWSMachineProviderConfigList buildable = new AWSMachineProviderConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}