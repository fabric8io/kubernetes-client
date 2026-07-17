package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackSDConfigBuilder extends OpenStackSDConfigFluent<OpenStackSDConfigBuilder> implements VisitableBuilder<OpenStackSDConfig,OpenStackSDConfigBuilder>{

  OpenStackSDConfigFluent<?> fluent;

  public OpenStackSDConfigBuilder() {
    this(new OpenStackSDConfig());
  }
  
  public OpenStackSDConfigBuilder(OpenStackSDConfigFluent<?> fluent) {
    this(fluent, new OpenStackSDConfig());
  }
  
  public OpenStackSDConfigBuilder(OpenStackSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackSDConfigBuilder(OpenStackSDConfigFluent<?> fluent,OpenStackSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackSDConfig build() {
    OpenStackSDConfig buildable = new OpenStackSDConfig(fluent.getAllTenants(), fluent.getApplicationCredentialId(), fluent.getApplicationCredentialName(), fluent.getApplicationCredentialSecret(), fluent.getAvailability(), fluent.getDomainID(), fluent.getDomainName(), fluent.getIdentityEndpoint(), fluent.getPassword(), fluent.getPort(), fluent.getProjectID(), fluent.getProjectName(), fluent.getRefreshInterval(), fluent.getRegion(), fluent.getRole(), fluent.buildTlsConfig(), fluent.getUserid(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}