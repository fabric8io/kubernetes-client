package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ACMEIssuerDNS01ProviderAzureDNSFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAzureDNSFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientID;
  private SecretKeySelectorBuilder clientSecretSecretRef;
  private String environment;
  private String hostedZoneName;
  private AzureManagedIdentityBuilder managedIdentity;
  private String resourceGroupName;
  private String subscriptionID;
  private String tenantID;
  private String zoneType;

  public ACMEIssuerDNS01ProviderAzureDNSFluent() {
  }
  
  public ACMEIssuerDNS01ProviderAzureDNSFluent(ACMEIssuerDNS01ProviderAzureDNS instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public SecretKeySelector buildClientSecretSecretRef() {
    return this.clientSecretSecretRef != null ? this.clientSecretSecretRef.build() : null;
  }
  
  public AzureManagedIdentity buildManagedIdentity() {
    return this.managedIdentity != null ? this.managedIdentity.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderAzureDNS instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderAzureDNS();
    if (instance != null) {
        this.withClientID(instance.getClientID());
        this.withClientSecretSecretRef(instance.getClientSecretSecretRef());
        this.withEnvironment(instance.getEnvironment());
        this.withHostedZoneName(instance.getHostedZoneName());
        this.withManagedIdentity(instance.getManagedIdentity());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withSubscriptionID(instance.getSubscriptionID());
        this.withTenantID(instance.getTenantID());
        this.withZoneType(instance.getZoneType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientSecretSecretRefNested<A> editClientSecretSecretRef() {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(null));
  }
  
  public ManagedIdentityNested<A> editManagedIdentity() {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(null));
  }
  
  public ClientSecretSecretRefNested<A> editOrNewClientSecretSecretRef() {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ClientSecretSecretRefNested<A> editOrNewClientSecretSecretRefLike(SecretKeySelector item) {
    return this.withNewClientSecretSecretRefLike(Optional.ofNullable(this.buildClientSecretSecretRef()).orElse(item));
  }
  
  public ManagedIdentityNested<A> editOrNewManagedIdentity() {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(new AzureManagedIdentityBuilder().build()));
  }
  
  public ManagedIdentityNested<A> editOrNewManagedIdentityLike(AzureManagedIdentity item) {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ACMEIssuerDNS01ProviderAzureDNSFluent that = (ACMEIssuerDNS01ProviderAzureDNSFluent) o;
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecretSecretRef, that.clientSecretSecretRef))) {
      return false;
    }
    if (!(Objects.equals(environment, that.environment))) {
      return false;
    }
    if (!(Objects.equals(hostedZoneName, that.hostedZoneName))) {
      return false;
    }
    if (!(Objects.equals(managedIdentity, that.managedIdentity))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupName, that.resourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(subscriptionID, that.subscriptionID))) {
      return false;
    }
    if (!(Objects.equals(tenantID, that.tenantID))) {
      return false;
    }
    if (!(Objects.equals(zoneType, that.zoneType))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getEnvironment() {
    return this.environment;
  }
  
  public String getHostedZoneName() {
    return this.hostedZoneName;
  }
  
  public String getResourceGroupName() {
    return this.resourceGroupName;
  }
  
  public String getSubscriptionID() {
    return this.subscriptionID;
  }
  
  public String getTenantID() {
    return this.tenantID;
  }
  
  public String getZoneType() {
    return this.zoneType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecretSecretRef() {
    return this.clientSecretSecretRef != null;
  }
  
  public boolean hasEnvironment() {
    return this.environment != null;
  }
  
  public boolean hasHostedZoneName() {
    return this.hostedZoneName != null;
  }
  
  public boolean hasManagedIdentity() {
    return this.managedIdentity != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasSubscriptionID() {
    return this.subscriptionID != null;
  }
  
  public boolean hasTenantID() {
    return this.tenantID != null;
  }
  
  public boolean hasZoneType() {
    return this.zoneType != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientID, clientSecretSecretRef, environment, hostedZoneName, managedIdentity, resourceGroupName, subscriptionID, tenantID, zoneType, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(clientSecretSecretRef == null)) {
        sb.append("clientSecretSecretRef:");
        sb.append(clientSecretSecretRef);
        sb.append(",");
    }
    if (!(environment == null)) {
        sb.append("environment:");
        sb.append(environment);
        sb.append(",");
    }
    if (!(hostedZoneName == null)) {
        sb.append("hostedZoneName:");
        sb.append(hostedZoneName);
        sb.append(",");
    }
    if (!(managedIdentity == null)) {
        sb.append("managedIdentity:");
        sb.append(managedIdentity);
        sb.append(",");
    }
    if (!(resourceGroupName == null)) {
        sb.append("resourceGroupName:");
        sb.append(resourceGroupName);
        sb.append(",");
    }
    if (!(subscriptionID == null)) {
        sb.append("subscriptionID:");
        sb.append(subscriptionID);
        sb.append(",");
    }
    if (!(tenantID == null)) {
        sb.append("tenantID:");
        sb.append(tenantID);
        sb.append(",");
    }
    if (!(zoneType == null)) {
        sb.append("zoneType:");
        sb.append(zoneType);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withClientSecretSecretRef(SecretKeySelector clientSecretSecretRef) {
    this._visitables.remove("clientSecretSecretRef");
    if (clientSecretSecretRef != null) {
        this.clientSecretSecretRef = new SecretKeySelectorBuilder(clientSecretSecretRef);
        this._visitables.get("clientSecretSecretRef").add(this.clientSecretSecretRef);
    } else {
        this.clientSecretSecretRef = null;
        this._visitables.get("clientSecretSecretRef").remove(this.clientSecretSecretRef);
    }
    return (A) this;
  }
  
  public A withEnvironment(String environment) {
    this.environment = environment;
    return (A) this;
  }
  
  public A withHostedZoneName(String hostedZoneName) {
    this.hostedZoneName = hostedZoneName;
    return (A) this;
  }
  
  public A withManagedIdentity(AzureManagedIdentity managedIdentity) {
    this._visitables.remove("managedIdentity");
    if (managedIdentity != null) {
        this.managedIdentity = new AzureManagedIdentityBuilder(managedIdentity);
        this._visitables.get("managedIdentity").add(this.managedIdentity);
    } else {
        this.managedIdentity = null;
        this._visitables.get("managedIdentity").remove(this.managedIdentity);
    }
    return (A) this;
  }
  
  public ClientSecretSecretRefNested<A> withNewClientSecretSecretRef() {
    return new ClientSecretSecretRefNested(null);
  }
  
  public A withNewClientSecretSecretRef(String key,String name) {
    return (A) this.withClientSecretSecretRef(new SecretKeySelector(key, name));
  }
  
  public ClientSecretSecretRefNested<A> withNewClientSecretSecretRefLike(SecretKeySelector item) {
    return new ClientSecretSecretRefNested(item);
  }
  
  public ManagedIdentityNested<A> withNewManagedIdentity() {
    return new ManagedIdentityNested(null);
  }
  
  public A withNewManagedIdentity(String clientID,String resourceID,String tenantID) {
    return (A) this.withManagedIdentity(new AzureManagedIdentity(clientID, resourceID, tenantID));
  }
  
  public ManagedIdentityNested<A> withNewManagedIdentityLike(AzureManagedIdentity item) {
    return new ManagedIdentityNested(item);
  }
  
  public A withResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
    return (A) this;
  }
  
  public A withSubscriptionID(String subscriptionID) {
    this.subscriptionID = subscriptionID;
    return (A) this;
  }
  
  public A withTenantID(String tenantID) {
    this.tenantID = tenantID;
    return (A) this;
  }
  
  public A withZoneType(String zoneType) {
    this.zoneType = zoneType;
    return (A) this;
  }
  public class ClientSecretSecretRefNested<N> extends SecretKeySelectorFluent<ClientSecretSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ClientSecretSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAzureDNSFluent.this.withClientSecretSecretRef(builder.build());
    }
    
    public N endClientSecretSecretRef() {
      return and();
    }
    
  }
  public class ManagedIdentityNested<N> extends AzureManagedIdentityFluent<ManagedIdentityNested<N>> implements Nested<N>{
  
    AzureManagedIdentityBuilder builder;
  
    ManagedIdentityNested(AzureManagedIdentity item) {
      this.builder = new AzureManagedIdentityBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderAzureDNSFluent.this.withManagedIdentity(builder.build());
    }
    
    public N endManagedIdentity() {
      return and();
    }
    
  }
}