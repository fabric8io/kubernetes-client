package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletSpecBuilder extends KlusterletSpecFluent<KlusterletSpecBuilder> implements VisitableBuilder<KlusterletSpec,KlusterletSpecBuilder>{

  KlusterletSpecFluent<?> fluent;

  public KlusterletSpecBuilder() {
    this(new KlusterletSpec());
  }
  
  public KlusterletSpecBuilder(KlusterletSpecFluent<?> fluent) {
    this(fluent, new KlusterletSpec());
  }
  
  public KlusterletSpecBuilder(KlusterletSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletSpecBuilder(KlusterletSpecFluent<?> fluent,KlusterletSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletSpec build() {
    KlusterletSpec buildable = new KlusterletSpec(fluent.getClusterName(), fluent.buildDeployOption(), fluent.buildExternalServerURLs(), fluent.buildHubApiServerHostAlias(), fluent.getImagePullSpec(), fluent.getNamespace(), fluent.buildNodePlacement(), fluent.getPriorityClassName(), fluent.buildRegistrationConfiguration(), fluent.getRegistrationImagePullSpec(), fluent.buildResourceRequirement(), fluent.buildWorkConfiguration(), fluent.getWorkImagePullSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}