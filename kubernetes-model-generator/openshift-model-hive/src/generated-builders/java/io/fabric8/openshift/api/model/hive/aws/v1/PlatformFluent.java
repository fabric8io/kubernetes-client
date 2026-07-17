package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.hive.aws.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AssumeRoleBuilder credentialsAssumeRole;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private PrivateLinkAccessBuilder privateLink;
  private String region;
  private Map<String,String> userTags;

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
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
  
  public A addToUserTags(Map<String,String> map) {
    if (this.userTags == null && map != null) {
      this.userTags = new LinkedHashMap();
    }
    if (map != null) {
      this.userTags.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUserTags(String key,String value) {
    if (this.userTags == null && key != null && value != null) {
      this.userTags = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.userTags.put(key, value);
    }
    return (A) this;
  }
  
  public AssumeRole buildCredentialsAssumeRole() {
    return this.credentialsAssumeRole != null ? this.credentialsAssumeRole.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public PrivateLinkAccess buildPrivateLink() {
    return this.privateLink != null ? this.privateLink.build() : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withCredentialsAssumeRole(instance.getCredentialsAssumeRole());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withPrivateLink(instance.getPrivateLink());
        this.withRegion(instance.getRegion());
        this.withUserTags(instance.getUserTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsAssumeRoleNested<A> editCredentialsAssumeRole() {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(null));
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public CredentialsAssumeRoleNested<A> editOrNewCredentialsAssumeRole() {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(new AssumeRoleBuilder().build()));
  }
  
  public CredentialsAssumeRoleNested<A> editOrNewCredentialsAssumeRoleLike(AssumeRole item) {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(item));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRefLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(item));
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(new PrivateLinkAccessBuilder().build()));
  }
  
  public PrivateLinkNested<A> editOrNewPrivateLinkLike(PrivateLinkAccess item) {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(item));
  }
  
  public PrivateLinkNested<A> editPrivateLink() {
    return this.withNewPrivateLinkLike(Optional.ofNullable(this.buildPrivateLink()).orElse(null));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(credentialsAssumeRole, that.credentialsAssumeRole))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(privateLink, that.privateLink))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(userTags, that.userTags))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public Map<String,String> getUserTags() {
    return this.userTags;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCredentialsAssumeRole() {
    return this.credentialsAssumeRole != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasPrivateLink() {
    return this.privateLink != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasUserTags() {
    return this.userTags != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentialsAssumeRole, credentialsSecretRef, privateLink, region, userTags, additionalProperties);
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
  
  public A removeFromUserTags(String key) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (key != null && this.userTags != null) {
      this.userTags.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUserTags(Map<String,String> map) {
    if (this.userTags == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.userTags != null) {
          this.userTags.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(credentialsAssumeRole == null)) {
        sb.append("credentialsAssumeRole:");
        sb.append(credentialsAssumeRole);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(privateLink == null)) {
        sb.append("privateLink:");
        sb.append(privateLink);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(userTags == null) && !(userTags.isEmpty())) {
        sb.append("userTags:");
        sb.append(userTags);
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
  
  public A withCredentialsAssumeRole(AssumeRole credentialsAssumeRole) {
    this._visitables.remove("credentialsAssumeRole");
    if (credentialsAssumeRole != null) {
        this.credentialsAssumeRole = new AssumeRoleBuilder(credentialsAssumeRole);
        this._visitables.get("credentialsAssumeRole").add(this.credentialsAssumeRole);
    } else {
        this.credentialsAssumeRole = null;
        this._visitables.get("credentialsAssumeRole").remove(this.credentialsAssumeRole);
    }
    return (A) this;
  }
  
  public A withCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
    this._visitables.remove("credentialsSecretRef");
    if (credentialsSecretRef != null) {
        this.credentialsSecretRef = new LocalObjectReferenceBuilder(credentialsSecretRef);
        this._visitables.get("credentialsSecretRef").add(this.credentialsSecretRef);
    } else {
        this.credentialsSecretRef = null;
        this._visitables.get("credentialsSecretRef").remove(this.credentialsSecretRef);
    }
    return (A) this;
  }
  
  public CredentialsAssumeRoleNested<A> withNewCredentialsAssumeRole() {
    return new CredentialsAssumeRoleNested(null);
  }
  
  public A withNewCredentialsAssumeRole(String externalID,String roleARN) {
    return (A) this.withCredentialsAssumeRole(new AssumeRole(externalID, roleARN));
  }
  
  public CredentialsAssumeRoleNested<A> withNewCredentialsAssumeRoleLike(AssumeRole item) {
    return new CredentialsAssumeRoleNested(item);
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRef() {
    return new CredentialsSecretRefNested(null);
  }
  
  public A withNewCredentialsSecretRef(String name) {
    return (A) this.withCredentialsSecretRef(new LocalObjectReference(name));
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRefLike(LocalObjectReference item) {
    return new CredentialsSecretRefNested(item);
  }
  
  public PrivateLinkNested<A> withNewPrivateLink() {
    return new PrivateLinkNested(null);
  }
  
  public PrivateLinkNested<A> withNewPrivateLinkLike(PrivateLinkAccess item) {
    return new PrivateLinkNested(item);
  }
  
  public A withPrivateLink(PrivateLinkAccess privateLink) {
    this._visitables.remove("privateLink");
    if (privateLink != null) {
        this.privateLink = new PrivateLinkAccessBuilder(privateLink);
        this._visitables.get("privateLink").add(this.privateLink);
    } else {
        this.privateLink = null;
        this._visitables.get("privateLink").remove(this.privateLink);
    }
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public <K,V>A withUserTags(Map<String,String> userTags) {
    if (userTags == null) {
      this.userTags = null;
    } else {
      this.userTags = new LinkedHashMap(userTags);
    }
    return (A) this;
  }
  public class CredentialsAssumeRoleNested<N> extends AssumeRoleFluent<CredentialsAssumeRoleNested<N>> implements Nested<N>{
  
    AssumeRoleBuilder builder;
  
    CredentialsAssumeRoleNested(AssumeRole item) {
      this.builder = new AssumeRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCredentialsAssumeRole(builder.build());
    }
    
    public N endCredentialsAssumeRole() {
      return and();
    }
    
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
  public class PrivateLinkNested<N> extends PrivateLinkAccessFluent<PrivateLinkNested<N>> implements Nested<N>{
  
    PrivateLinkAccessBuilder builder;
  
    PrivateLinkNested(PrivateLinkAccess item) {
      this.builder = new PrivateLinkAccessBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withPrivateLink(builder.build());
    }
    
    public N endPrivateLink() {
      return and();
    }
    
  }
}