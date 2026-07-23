package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScalewaySDConfigBuilder extends ScalewaySDConfigFluent<ScalewaySDConfigBuilder> implements VisitableBuilder<ScalewaySDConfig,ScalewaySDConfigBuilder>{

  ScalewaySDConfigFluent<?> fluent;

  public ScalewaySDConfigBuilder() {
    this(new ScalewaySDConfig());
  }
  
  public ScalewaySDConfigBuilder(ScalewaySDConfigFluent<?> fluent) {
    this(fluent, new ScalewaySDConfig());
  }
  
  public ScalewaySDConfigBuilder(ScalewaySDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScalewaySDConfigBuilder(ScalewaySDConfigFluent<?> fluent,ScalewaySDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScalewaySDConfig build() {
    ScalewaySDConfig buildable = new ScalewaySDConfig(fluent.getAccessKey(), fluent.getApiURL(), fluent.getEnableHTTP2(), fluent.getFollowRedirects(), fluent.getNameFilter(), fluent.getNoProxy(), fluent.getPort(), fluent.getProjectID(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getRefreshInterval(), fluent.getRole(), fluent.getSecretKey(), fluent.getTagsFilter(), fluent.buildTlsConfig(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}