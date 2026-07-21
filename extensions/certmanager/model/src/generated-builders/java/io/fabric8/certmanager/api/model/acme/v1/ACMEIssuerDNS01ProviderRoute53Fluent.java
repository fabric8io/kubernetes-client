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
public class ACMEIssuerDNS01ProviderRoute53Fluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderRoute53Fluent<A>> extends BaseFluent<A>{

  private String accessKeyID;
  private SecretKeySelectorBuilder accessKeyIDSecretRef;
  private Map<String,Object> additionalProperties;
  private Route53AuthBuilder auth;
  private String hostedZoneID;
  private String region;
  private String role;
  private SecretKeySelectorBuilder secretAccessKeySecretRef;

  public ACMEIssuerDNS01ProviderRoute53Fluent() {
  }
  
  public ACMEIssuerDNS01ProviderRoute53Fluent(ACMEIssuerDNS01ProviderRoute53 instance) {
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
  
  public SecretKeySelector buildAccessKeyIDSecretRef() {
    return this.accessKeyIDSecretRef != null ? this.accessKeyIDSecretRef.build() : null;
  }
  
  public Route53Auth buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  public SecretKeySelector buildSecretAccessKeySecretRef() {
    return this.secretAccessKeySecretRef != null ? this.secretAccessKeySecretRef.build() : null;
  }
  
  protected void copyInstance(ACMEIssuerDNS01ProviderRoute53 instance) {
    instance = instance != null ? instance : new ACMEIssuerDNS01ProviderRoute53();
    if (instance != null) {
        this.withAccessKeyID(instance.getAccessKeyID());
        this.withAccessKeyIDSecretRef(instance.getAccessKeyIDSecretRef());
        this.withAuth(instance.getAuth());
        this.withHostedZoneID(instance.getHostedZoneID());
        this.withRegion(instance.getRegion());
        this.withRole(instance.getRole());
        this.withSecretAccessKeySecretRef(instance.getSecretAccessKeySecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessKeyIDSecretRefNested<A> editAccessKeyIDSecretRef() {
    return this.withNewAccessKeyIDSecretRefLike(Optional.ofNullable(this.buildAccessKeyIDSecretRef()).orElse(null));
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public AccessKeyIDSecretRefNested<A> editOrNewAccessKeyIDSecretRef() {
    return this.withNewAccessKeyIDSecretRefLike(Optional.ofNullable(this.buildAccessKeyIDSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public AccessKeyIDSecretRefNested<A> editOrNewAccessKeyIDSecretRefLike(SecretKeySelector item) {
    return this.withNewAccessKeyIDSecretRefLike(Optional.ofNullable(this.buildAccessKeyIDSecretRef()).orElse(item));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new Route53AuthBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(Route53Auth item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
  }
  
  public SecretAccessKeySecretRefNested<A> editOrNewSecretAccessKeySecretRef() {
    return this.withNewSecretAccessKeySecretRefLike(Optional.ofNullable(this.buildSecretAccessKeySecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public SecretAccessKeySecretRefNested<A> editOrNewSecretAccessKeySecretRefLike(SecretKeySelector item) {
    return this.withNewSecretAccessKeySecretRefLike(Optional.ofNullable(this.buildSecretAccessKeySecretRef()).orElse(item));
  }
  
  public SecretAccessKeySecretRefNested<A> editSecretAccessKeySecretRef() {
    return this.withNewSecretAccessKeySecretRefLike(Optional.ofNullable(this.buildSecretAccessKeySecretRef()).orElse(null));
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
    ACMEIssuerDNS01ProviderRoute53Fluent that = (ACMEIssuerDNS01ProviderRoute53Fluent) o;
    if (!(Objects.equals(accessKeyID, that.accessKeyID))) {
      return false;
    }
    if (!(Objects.equals(accessKeyIDSecretRef, that.accessKeyIDSecretRef))) {
      return false;
    }
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(hostedZoneID, that.hostedZoneID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(role, that.role))) {
      return false;
    }
    if (!(Objects.equals(secretAccessKeySecretRef, that.secretAccessKeySecretRef))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessKeyID() {
    return this.accessKeyID;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getHostedZoneID() {
    return this.hostedZoneID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAccessKeyID() {
    return this.accessKeyID != null;
  }
  
  public boolean hasAccessKeyIDSecretRef() {
    return this.accessKeyIDSecretRef != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasHostedZoneID() {
    return this.hostedZoneID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasSecretAccessKeySecretRef() {
    return this.secretAccessKeySecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessKeyID, accessKeyIDSecretRef, auth, hostedZoneID, region, role, secretAccessKeySecretRef, additionalProperties);
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
    if (!(accessKeyID == null)) {
        sb.append("accessKeyID:");
        sb.append(accessKeyID);
        sb.append(",");
    }
    if (!(accessKeyIDSecretRef == null)) {
        sb.append("accessKeyIDSecretRef:");
        sb.append(accessKeyIDSecretRef);
        sb.append(",");
    }
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
        sb.append(",");
    }
    if (!(hostedZoneID == null)) {
        sb.append("hostedZoneID:");
        sb.append(hostedZoneID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
        sb.append(",");
    }
    if (!(secretAccessKeySecretRef == null)) {
        sb.append("secretAccessKeySecretRef:");
        sb.append(secretAccessKeySecretRef);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessKeyID(String accessKeyID) {
    this.accessKeyID = accessKeyID;
    return (A) this;
  }
  
  public A withAccessKeyIDSecretRef(SecretKeySelector accessKeyIDSecretRef) {
    this._visitables.remove("accessKeyIDSecretRef");
    if (accessKeyIDSecretRef != null) {
        this.accessKeyIDSecretRef = new SecretKeySelectorBuilder(accessKeyIDSecretRef);
        this._visitables.get("accessKeyIDSecretRef").add(this.accessKeyIDSecretRef);
    } else {
        this.accessKeyIDSecretRef = null;
        this._visitables.get("accessKeyIDSecretRef").remove(this.accessKeyIDSecretRef);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAuth(Route53Auth auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new Route53AuthBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public A withHostedZoneID(String hostedZoneID) {
    this.hostedZoneID = hostedZoneID;
    return (A) this;
  }
  
  public AccessKeyIDSecretRefNested<A> withNewAccessKeyIDSecretRef() {
    return new AccessKeyIDSecretRefNested(null);
  }
  
  public A withNewAccessKeyIDSecretRef(String key,String name) {
    return (A) this.withAccessKeyIDSecretRef(new SecretKeySelector(key, name));
  }
  
  public AccessKeyIDSecretRefNested<A> withNewAccessKeyIDSecretRefLike(SecretKeySelector item) {
    return new AccessKeyIDSecretRefNested(item);
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(Route53Auth item) {
    return new AuthNested(item);
  }
  
  public SecretAccessKeySecretRefNested<A> withNewSecretAccessKeySecretRef() {
    return new SecretAccessKeySecretRefNested(null);
  }
  
  public A withNewSecretAccessKeySecretRef(String key,String name) {
    return (A) this.withSecretAccessKeySecretRef(new SecretKeySelector(key, name));
  }
  
  public SecretAccessKeySecretRefNested<A> withNewSecretAccessKeySecretRefLike(SecretKeySelector item) {
    return new SecretAccessKeySecretRefNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRole(String role) {
    this.role = role;
    return (A) this;
  }
  
  public A withSecretAccessKeySecretRef(SecretKeySelector secretAccessKeySecretRef) {
    this._visitables.remove("secretAccessKeySecretRef");
    if (secretAccessKeySecretRef != null) {
        this.secretAccessKeySecretRef = new SecretKeySelectorBuilder(secretAccessKeySecretRef);
        this._visitables.get("secretAccessKeySecretRef").add(this.secretAccessKeySecretRef);
    } else {
        this.secretAccessKeySecretRef = null;
        this._visitables.get("secretAccessKeySecretRef").remove(this.secretAccessKeySecretRef);
    }
    return (A) this;
  }
  public class AccessKeyIDSecretRefNested<N> extends SecretKeySelectorFluent<AccessKeyIDSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    AccessKeyIDSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderRoute53Fluent.this.withAccessKeyIDSecretRef(builder.build());
    }
    
    public N endAccessKeyIDSecretRef() {
      return and();
    }
    
  }
  public class AuthNested<N> extends Route53AuthFluent<AuthNested<N>> implements Nested<N>{
  
    Route53AuthBuilder builder;
  
    AuthNested(Route53Auth item) {
      this.builder = new Route53AuthBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderRoute53Fluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class SecretAccessKeySecretRefNested<N> extends SecretKeySelectorFluent<SecretAccessKeySecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    SecretAccessKeySecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerDNS01ProviderRoute53Fluent.this.withSecretAccessKeySecretRef(builder.build());
    }
    
    public N endSecretAccessKeySecretRef() {
      return and();
    }
    
  }
}