package io.fabric8.openshift.api.model.monitoring.v1;

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
public class AzureADFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AzureADFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cloud;
  private ManagedIdentityBuilder managedIdentity;
  private AzureOAuthBuilder oauth;
  private String scope;
  private AzureSDKBuilder sdk;
  private AzureWorkloadIdentityBuilder workloadIdentity;

  public AzureADFluent() {
  }
  
  public AzureADFluent(AzureAD instance) {
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
  
  public ManagedIdentity buildManagedIdentity() {
    return this.managedIdentity != null ? this.managedIdentity.build() : null;
  }
  
  public AzureOAuth buildOauth() {
    return this.oauth != null ? this.oauth.build() : null;
  }
  
  public AzureSDK buildSdk() {
    return this.sdk != null ? this.sdk.build() : null;
  }
  
  public AzureWorkloadIdentity buildWorkloadIdentity() {
    return this.workloadIdentity != null ? this.workloadIdentity.build() : null;
  }
  
  protected void copyInstance(AzureAD instance) {
    instance = instance != null ? instance : new AzureAD();
    if (instance != null) {
        this.withCloud(instance.getCloud());
        this.withManagedIdentity(instance.getManagedIdentity());
        this.withOauth(instance.getOauth());
        this.withScope(instance.getScope());
        this.withSdk(instance.getSdk());
        this.withWorkloadIdentity(instance.getWorkloadIdentity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ManagedIdentityNested<A> editManagedIdentity() {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(null));
  }
  
  public OauthNested<A> editOauth() {
    return this.withNewOauthLike(Optional.ofNullable(this.buildOauth()).orElse(null));
  }
  
  public ManagedIdentityNested<A> editOrNewManagedIdentity() {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(new ManagedIdentityBuilder().build()));
  }
  
  public ManagedIdentityNested<A> editOrNewManagedIdentityLike(ManagedIdentity item) {
    return this.withNewManagedIdentityLike(Optional.ofNullable(this.buildManagedIdentity()).orElse(item));
  }
  
  public OauthNested<A> editOrNewOauth() {
    return this.withNewOauthLike(Optional.ofNullable(this.buildOauth()).orElse(new AzureOAuthBuilder().build()));
  }
  
  public OauthNested<A> editOrNewOauthLike(AzureOAuth item) {
    return this.withNewOauthLike(Optional.ofNullable(this.buildOauth()).orElse(item));
  }
  
  public SdkNested<A> editOrNewSdk() {
    return this.withNewSdkLike(Optional.ofNullable(this.buildSdk()).orElse(new AzureSDKBuilder().build()));
  }
  
  public SdkNested<A> editOrNewSdkLike(AzureSDK item) {
    return this.withNewSdkLike(Optional.ofNullable(this.buildSdk()).orElse(item));
  }
  
  public WorkloadIdentityNested<A> editOrNewWorkloadIdentity() {
    return this.withNewWorkloadIdentityLike(Optional.ofNullable(this.buildWorkloadIdentity()).orElse(new AzureWorkloadIdentityBuilder().build()));
  }
  
  public WorkloadIdentityNested<A> editOrNewWorkloadIdentityLike(AzureWorkloadIdentity item) {
    return this.withNewWorkloadIdentityLike(Optional.ofNullable(this.buildWorkloadIdentity()).orElse(item));
  }
  
  public SdkNested<A> editSdk() {
    return this.withNewSdkLike(Optional.ofNullable(this.buildSdk()).orElse(null));
  }
  
  public WorkloadIdentityNested<A> editWorkloadIdentity() {
    return this.withNewWorkloadIdentityLike(Optional.ofNullable(this.buildWorkloadIdentity()).orElse(null));
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
    AzureADFluent that = (AzureADFluent) o;
    if (!(Objects.equals(cloud, that.cloud))) {
      return false;
    }
    if (!(Objects.equals(managedIdentity, that.managedIdentity))) {
      return false;
    }
    if (!(Objects.equals(oauth, that.oauth))) {
      return false;
    }
    if (!(Objects.equals(scope, that.scope))) {
      return false;
    }
    if (!(Objects.equals(sdk, that.sdk))) {
      return false;
    }
    if (!(Objects.equals(workloadIdentity, that.workloadIdentity))) {
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
  
  public String getCloud() {
    return this.cloud;
  }
  
  public String getScope() {
    return this.scope;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloud() {
    return this.cloud != null;
  }
  
  public boolean hasManagedIdentity() {
    return this.managedIdentity != null;
  }
  
  public boolean hasOauth() {
    return this.oauth != null;
  }
  
  public boolean hasScope() {
    return this.scope != null;
  }
  
  public boolean hasSdk() {
    return this.sdk != null;
  }
  
  public boolean hasWorkloadIdentity() {
    return this.workloadIdentity != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloud, managedIdentity, oauth, scope, sdk, workloadIdentity, additionalProperties);
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
    if (!(cloud == null)) {
        sb.append("cloud:");
        sb.append(cloud);
        sb.append(",");
    }
    if (!(managedIdentity == null)) {
        sb.append("managedIdentity:");
        sb.append(managedIdentity);
        sb.append(",");
    }
    if (!(oauth == null)) {
        sb.append("oauth:");
        sb.append(oauth);
        sb.append(",");
    }
    if (!(scope == null)) {
        sb.append("scope:");
        sb.append(scope);
        sb.append(",");
    }
    if (!(sdk == null)) {
        sb.append("sdk:");
        sb.append(sdk);
        sb.append(",");
    }
    if (!(workloadIdentity == null)) {
        sb.append("workloadIdentity:");
        sb.append(workloadIdentity);
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
  
  public A withCloud(String cloud) {
    this.cloud = cloud;
    return (A) this;
  }
  
  public A withManagedIdentity(ManagedIdentity managedIdentity) {
    this._visitables.remove("managedIdentity");
    if (managedIdentity != null) {
        this.managedIdentity = new ManagedIdentityBuilder(managedIdentity);
        this._visitables.get("managedIdentity").add(this.managedIdentity);
    } else {
        this.managedIdentity = null;
        this._visitables.get("managedIdentity").remove(this.managedIdentity);
    }
    return (A) this;
  }
  
  public ManagedIdentityNested<A> withNewManagedIdentity() {
    return new ManagedIdentityNested(null);
  }
  
  public A withNewManagedIdentity(String clientId) {
    return (A) this.withManagedIdentity(new ManagedIdentity(clientId));
  }
  
  public ManagedIdentityNested<A> withNewManagedIdentityLike(ManagedIdentity item) {
    return new ManagedIdentityNested(item);
  }
  
  public OauthNested<A> withNewOauth() {
    return new OauthNested(null);
  }
  
  public OauthNested<A> withNewOauthLike(AzureOAuth item) {
    return new OauthNested(item);
  }
  
  public SdkNested<A> withNewSdk() {
    return new SdkNested(null);
  }
  
  public A withNewSdk(String tenantId) {
    return (A) this.withSdk(new AzureSDK(tenantId));
  }
  
  public SdkNested<A> withNewSdkLike(AzureSDK item) {
    return new SdkNested(item);
  }
  
  public WorkloadIdentityNested<A> withNewWorkloadIdentity() {
    return new WorkloadIdentityNested(null);
  }
  
  public A withNewWorkloadIdentity(String clientId,String tenantId) {
    return (A) this.withWorkloadIdentity(new AzureWorkloadIdentity(clientId, tenantId));
  }
  
  public WorkloadIdentityNested<A> withNewWorkloadIdentityLike(AzureWorkloadIdentity item) {
    return new WorkloadIdentityNested(item);
  }
  
  public A withOauth(AzureOAuth oauth) {
    this._visitables.remove("oauth");
    if (oauth != null) {
        this.oauth = new AzureOAuthBuilder(oauth);
        this._visitables.get("oauth").add(this.oauth);
    } else {
        this.oauth = null;
        this._visitables.get("oauth").remove(this.oauth);
    }
    return (A) this;
  }
  
  public A withScope(String scope) {
    this.scope = scope;
    return (A) this;
  }
  
  public A withSdk(AzureSDK sdk) {
    this._visitables.remove("sdk");
    if (sdk != null) {
        this.sdk = new AzureSDKBuilder(sdk);
        this._visitables.get("sdk").add(this.sdk);
    } else {
        this.sdk = null;
        this._visitables.get("sdk").remove(this.sdk);
    }
    return (A) this;
  }
  
  public A withWorkloadIdentity(AzureWorkloadIdentity workloadIdentity) {
    this._visitables.remove("workloadIdentity");
    if (workloadIdentity != null) {
        this.workloadIdentity = new AzureWorkloadIdentityBuilder(workloadIdentity);
        this._visitables.get("workloadIdentity").add(this.workloadIdentity);
    } else {
        this.workloadIdentity = null;
        this._visitables.get("workloadIdentity").remove(this.workloadIdentity);
    }
    return (A) this;
  }
  public class ManagedIdentityNested<N> extends ManagedIdentityFluent<ManagedIdentityNested<N>> implements Nested<N>{
  
    ManagedIdentityBuilder builder;
  
    ManagedIdentityNested(ManagedIdentity item) {
      this.builder = new ManagedIdentityBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureADFluent.this.withManagedIdentity(builder.build());
    }
    
    public N endManagedIdentity() {
      return and();
    }
    
  }
  public class OauthNested<N> extends AzureOAuthFluent<OauthNested<N>> implements Nested<N>{
  
    AzureOAuthBuilder builder;
  
    OauthNested(AzureOAuth item) {
      this.builder = new AzureOAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureADFluent.this.withOauth(builder.build());
    }
    
    public N endOauth() {
      return and();
    }
    
  }
  public class SdkNested<N> extends AzureSDKFluent<SdkNested<N>> implements Nested<N>{
  
    AzureSDKBuilder builder;
  
    SdkNested(AzureSDK item) {
      this.builder = new AzureSDKBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureADFluent.this.withSdk(builder.build());
    }
    
    public N endSdk() {
      return and();
    }
    
  }
  public class WorkloadIdentityNested<N> extends AzureWorkloadIdentityFluent<WorkloadIdentityNested<N>> implements Nested<N>{
  
    AzureWorkloadIdentityBuilder builder;
  
    WorkloadIdentityNested(AzureWorkloadIdentity item) {
      this.builder = new AzureWorkloadIdentityBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureADFluent.this.withWorkloadIdentity(builder.build());
    }
    
    public N endWorkloadIdentity() {
      return and();
    }
    
  }
}