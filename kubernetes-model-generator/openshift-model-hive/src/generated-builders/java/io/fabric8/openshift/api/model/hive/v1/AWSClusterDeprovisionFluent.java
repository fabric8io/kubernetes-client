package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRole;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRoleBuilder;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRoleFluent;
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
public class AWSClusterDeprovisionFluent<A extends io.fabric8.openshift.api.model.hive.v1.AWSClusterDeprovisionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AssumeRoleBuilder credentialsAssumeRole;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private String hostedZoneRole;
  private String region;

  public AWSClusterDeprovisionFluent() {
  }
  
  public AWSClusterDeprovisionFluent(AWSClusterDeprovision instance) {
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
  
  public AssumeRole buildCredentialsAssumeRole() {
    return this.credentialsAssumeRole != null ? this.credentialsAssumeRole.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  protected void copyInstance(AWSClusterDeprovision instance) {
    instance = instance != null ? instance : new AWSClusterDeprovision();
    if (instance != null) {
        this.withCredentialsAssumeRole(instance.getCredentialsAssumeRole());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withHostedZoneRole(instance.getHostedZoneRole());
        this.withRegion(instance.getRegion());
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
    AWSClusterDeprovisionFluent that = (AWSClusterDeprovisionFluent) o;
    if (!(Objects.equals(credentialsAssumeRole, that.credentialsAssumeRole))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(hostedZoneRole, that.hostedZoneRole))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getHostedZoneRole() {
    return this.hostedZoneRole;
  }
  
  public String getRegion() {
    return this.region;
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
  
  public boolean hasHostedZoneRole() {
    return this.hostedZoneRole != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(credentialsAssumeRole, credentialsSecretRef, hostedZoneRole, region, additionalProperties);
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
    if (!(hostedZoneRole == null)) {
        sb.append("hostedZoneRole:");
        sb.append(hostedZoneRole);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withHostedZoneRole(String hostedZoneRole) {
    this.hostedZoneRole = hostedZoneRole;
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
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  public class CredentialsAssumeRoleNested<N> extends AssumeRoleFluent<CredentialsAssumeRoleNested<N>> implements Nested<N>{
  
    AssumeRoleBuilder builder;
  
    CredentialsAssumeRoleNested(AssumeRole item) {
      this.builder = new AssumeRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSClusterDeprovisionFluent.this.withCredentialsAssumeRole(builder.build());
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
      return (N) AWSClusterDeprovisionFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
}