package io.fabric8.openshift.api.model.config.v1;

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
public class PolicyRootOfTrustFluent<A extends io.fabric8.openshift.api.model.config.v1.PolicyRootOfTrustFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImagePolicyFulcioCAWithRekorRootOfTrustBuilder fulcioCAWithRekor;
  private ImagePolicyPKIRootOfTrustBuilder pki;
  private String policyType;
  private ImagePolicyPublicKeyRootOfTrustBuilder publicKey;

  public PolicyRootOfTrustFluent() {
  }
  
  public PolicyRootOfTrustFluent(PolicyRootOfTrust instance) {
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
  
  public ImagePolicyFulcioCAWithRekorRootOfTrust buildFulcioCAWithRekor() {
    return this.fulcioCAWithRekor != null ? this.fulcioCAWithRekor.build() : null;
  }
  
  public ImagePolicyPKIRootOfTrust buildPki() {
    return this.pki != null ? this.pki.build() : null;
  }
  
  public ImagePolicyPublicKeyRootOfTrust buildPublicKey() {
    return this.publicKey != null ? this.publicKey.build() : null;
  }
  
  protected void copyInstance(PolicyRootOfTrust instance) {
    instance = instance != null ? instance : new PolicyRootOfTrust();
    if (instance != null) {
        this.withFulcioCAWithRekor(instance.getFulcioCAWithRekor());
        this.withPki(instance.getPki());
        this.withPolicyType(instance.getPolicyType());
        this.withPublicKey(instance.getPublicKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FulcioCAWithRekorNested<A> editFulcioCAWithRekor() {
    return this.withNewFulcioCAWithRekorLike(Optional.ofNullable(this.buildFulcioCAWithRekor()).orElse(null));
  }
  
  public FulcioCAWithRekorNested<A> editOrNewFulcioCAWithRekor() {
    return this.withNewFulcioCAWithRekorLike(Optional.ofNullable(this.buildFulcioCAWithRekor()).orElse(new ImagePolicyFulcioCAWithRekorRootOfTrustBuilder().build()));
  }
  
  public FulcioCAWithRekorNested<A> editOrNewFulcioCAWithRekorLike(ImagePolicyFulcioCAWithRekorRootOfTrust item) {
    return this.withNewFulcioCAWithRekorLike(Optional.ofNullable(this.buildFulcioCAWithRekor()).orElse(item));
  }
  
  public PkiNested<A> editOrNewPki() {
    return this.withNewPkiLike(Optional.ofNullable(this.buildPki()).orElse(new ImagePolicyPKIRootOfTrustBuilder().build()));
  }
  
  public PkiNested<A> editOrNewPkiLike(ImagePolicyPKIRootOfTrust item) {
    return this.withNewPkiLike(Optional.ofNullable(this.buildPki()).orElse(item));
  }
  
  public PublicKeyNested<A> editOrNewPublicKey() {
    return this.withNewPublicKeyLike(Optional.ofNullable(this.buildPublicKey()).orElse(new ImagePolicyPublicKeyRootOfTrustBuilder().build()));
  }
  
  public PublicKeyNested<A> editOrNewPublicKeyLike(ImagePolicyPublicKeyRootOfTrust item) {
    return this.withNewPublicKeyLike(Optional.ofNullable(this.buildPublicKey()).orElse(item));
  }
  
  public PkiNested<A> editPki() {
    return this.withNewPkiLike(Optional.ofNullable(this.buildPki()).orElse(null));
  }
  
  public PublicKeyNested<A> editPublicKey() {
    return this.withNewPublicKeyLike(Optional.ofNullable(this.buildPublicKey()).orElse(null));
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
    PolicyRootOfTrustFluent that = (PolicyRootOfTrustFluent) o;
    if (!(Objects.equals(fulcioCAWithRekor, that.fulcioCAWithRekor))) {
      return false;
    }
    if (!(Objects.equals(pki, that.pki))) {
      return false;
    }
    if (!(Objects.equals(policyType, that.policyType))) {
      return false;
    }
    if (!(Objects.equals(publicKey, that.publicKey))) {
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
  
  public String getPolicyType() {
    return this.policyType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFulcioCAWithRekor() {
    return this.fulcioCAWithRekor != null;
  }
  
  public boolean hasPki() {
    return this.pki != null;
  }
  
  public boolean hasPolicyType() {
    return this.policyType != null;
  }
  
  public boolean hasPublicKey() {
    return this.publicKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(fulcioCAWithRekor, pki, policyType, publicKey, additionalProperties);
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
    if (!(fulcioCAWithRekor == null)) {
        sb.append("fulcioCAWithRekor:");
        sb.append(fulcioCAWithRekor);
        sb.append(",");
    }
    if (!(pki == null)) {
        sb.append("pki:");
        sb.append(pki);
        sb.append(",");
    }
    if (!(policyType == null)) {
        sb.append("policyType:");
        sb.append(policyType);
        sb.append(",");
    }
    if (!(publicKey == null)) {
        sb.append("publicKey:");
        sb.append(publicKey);
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
  
  public A withFulcioCAWithRekor(ImagePolicyFulcioCAWithRekorRootOfTrust fulcioCAWithRekor) {
    this._visitables.remove("fulcioCAWithRekor");
    if (fulcioCAWithRekor != null) {
        this.fulcioCAWithRekor = new ImagePolicyFulcioCAWithRekorRootOfTrustBuilder(fulcioCAWithRekor);
        this._visitables.get("fulcioCAWithRekor").add(this.fulcioCAWithRekor);
    } else {
        this.fulcioCAWithRekor = null;
        this._visitables.get("fulcioCAWithRekor").remove(this.fulcioCAWithRekor);
    }
    return (A) this;
  }
  
  public FulcioCAWithRekorNested<A> withNewFulcioCAWithRekor() {
    return new FulcioCAWithRekorNested(null);
  }
  
  public FulcioCAWithRekorNested<A> withNewFulcioCAWithRekorLike(ImagePolicyFulcioCAWithRekorRootOfTrust item) {
    return new FulcioCAWithRekorNested(item);
  }
  
  public PkiNested<A> withNewPki() {
    return new PkiNested(null);
  }
  
  public PkiNested<A> withNewPkiLike(ImagePolicyPKIRootOfTrust item) {
    return new PkiNested(item);
  }
  
  public PublicKeyNested<A> withNewPublicKey() {
    return new PublicKeyNested(null);
  }
  
  public A withNewPublicKey(String keyData,String rekorKeyData) {
    return (A) this.withPublicKey(new ImagePolicyPublicKeyRootOfTrust(keyData, rekorKeyData));
  }
  
  public PublicKeyNested<A> withNewPublicKeyLike(ImagePolicyPublicKeyRootOfTrust item) {
    return new PublicKeyNested(item);
  }
  
  public A withPki(ImagePolicyPKIRootOfTrust pki) {
    this._visitables.remove("pki");
    if (pki != null) {
        this.pki = new ImagePolicyPKIRootOfTrustBuilder(pki);
        this._visitables.get("pki").add(this.pki);
    } else {
        this.pki = null;
        this._visitables.get("pki").remove(this.pki);
    }
    return (A) this;
  }
  
  public A withPolicyType(String policyType) {
    this.policyType = policyType;
    return (A) this;
  }
  
  public A withPublicKey(ImagePolicyPublicKeyRootOfTrust publicKey) {
    this._visitables.remove("publicKey");
    if (publicKey != null) {
        this.publicKey = new ImagePolicyPublicKeyRootOfTrustBuilder(publicKey);
        this._visitables.get("publicKey").add(this.publicKey);
    } else {
        this.publicKey = null;
        this._visitables.get("publicKey").remove(this.publicKey);
    }
    return (A) this;
  }
  public class FulcioCAWithRekorNested<N> extends ImagePolicyFulcioCAWithRekorRootOfTrustFluent<FulcioCAWithRekorNested<N>> implements Nested<N>{
  
    ImagePolicyFulcioCAWithRekorRootOfTrustBuilder builder;
  
    FulcioCAWithRekorNested(ImagePolicyFulcioCAWithRekorRootOfTrust item) {
      this.builder = new ImagePolicyFulcioCAWithRekorRootOfTrustBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRootOfTrustFluent.this.withFulcioCAWithRekor(builder.build());
    }
    
    public N endFulcioCAWithRekor() {
      return and();
    }
    
  }
  public class PkiNested<N> extends ImagePolicyPKIRootOfTrustFluent<PkiNested<N>> implements Nested<N>{
  
    ImagePolicyPKIRootOfTrustBuilder builder;
  
    PkiNested(ImagePolicyPKIRootOfTrust item) {
      this.builder = new ImagePolicyPKIRootOfTrustBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRootOfTrustFluent.this.withPki(builder.build());
    }
    
    public N endPki() {
      return and();
    }
    
  }
  public class PublicKeyNested<N> extends ImagePolicyPublicKeyRootOfTrustFluent<PublicKeyNested<N>> implements Nested<N>{
  
    ImagePolicyPublicKeyRootOfTrustBuilder builder;
  
    PublicKeyNested(ImagePolicyPublicKeyRootOfTrust item) {
      this.builder = new ImagePolicyPublicKeyRootOfTrustBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyRootOfTrustFluent.this.withPublicKey(builder.build());
    }
    
    public N endPublicKey() {
      return and();
    }
    
  }
}