package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeletConfigBuilder extends KubeletConfigFluent<KubeletConfigBuilder> implements VisitableBuilder<KubeletConfig,KubeletConfigBuilder>{

  KubeletConfigFluent<?> fluent;

  public KubeletConfigBuilder() {
    this(new KubeletConfig());
  }
  
  public KubeletConfigBuilder(KubeletConfigFluent<?> fluent) {
    this(fluent, new KubeletConfig());
  }
  
  public KubeletConfigBuilder(KubeletConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeletConfigBuilder(KubeletConfigFluent<?> fluent,KubeletConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeletConfig build() {
    KubeletConfig buildable = new KubeletConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}