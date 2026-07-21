package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuer;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerBuilder;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerFluent;
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
public class IssuerSpecFluent<A extends io.fabric8.certmanager.api.model.v1.IssuerSpecFluent<A>> extends BaseFluent<A>{

  private ACMEIssuerBuilder acme;
  private Map<String,Object> additionalProperties;
  private CAIssuerBuilder ca;
  private SelfSignedIssuerBuilder selfSigned;
  private VaultIssuerBuilder vault;
  private VenafiIssuerBuilder venafi;

  public IssuerSpecFluent() {
  }
  
  public IssuerSpecFluent(IssuerSpec instance) {
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
  
  public ACMEIssuer buildAcme() {
    return this.acme != null ? this.acme.build() : null;
  }
  
  public CAIssuer buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  public SelfSignedIssuer buildSelfSigned() {
    return this.selfSigned != null ? this.selfSigned.build() : null;
  }
  
  public VaultIssuer buildVault() {
    return this.vault != null ? this.vault.build() : null;
  }
  
  public VenafiIssuer buildVenafi() {
    return this.venafi != null ? this.venafi.build() : null;
  }
  
  protected void copyInstance(IssuerSpec instance) {
    instance = instance != null ? instance : new IssuerSpec();
    if (instance != null) {
        this.withAcme(instance.getAcme());
        this.withCa(instance.getCa());
        this.withSelfSigned(instance.getSelfSigned());
        this.withVault(instance.getVault());
        this.withVenafi(instance.getVenafi());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AcmeNested<A> editAcme() {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(null));
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public AcmeNested<A> editOrNewAcme() {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(new ACMEIssuerBuilder().build()));
  }
  
  public AcmeNested<A> editOrNewAcmeLike(ACMEIssuer item) {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(item));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new CAIssuerBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(CAIssuer item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
  }
  
  public SelfSignedNested<A> editOrNewSelfSigned() {
    return this.withNewSelfSignedLike(Optional.ofNullable(this.buildSelfSigned()).orElse(new SelfSignedIssuerBuilder().build()));
  }
  
  public SelfSignedNested<A> editOrNewSelfSignedLike(SelfSignedIssuer item) {
    return this.withNewSelfSignedLike(Optional.ofNullable(this.buildSelfSigned()).orElse(item));
  }
  
  public VaultNested<A> editOrNewVault() {
    return this.withNewVaultLike(Optional.ofNullable(this.buildVault()).orElse(new VaultIssuerBuilder().build()));
  }
  
  public VaultNested<A> editOrNewVaultLike(VaultIssuer item) {
    return this.withNewVaultLike(Optional.ofNullable(this.buildVault()).orElse(item));
  }
  
  public VenafiNested<A> editOrNewVenafi() {
    return this.withNewVenafiLike(Optional.ofNullable(this.buildVenafi()).orElse(new VenafiIssuerBuilder().build()));
  }
  
  public VenafiNested<A> editOrNewVenafiLike(VenafiIssuer item) {
    return this.withNewVenafiLike(Optional.ofNullable(this.buildVenafi()).orElse(item));
  }
  
  public SelfSignedNested<A> editSelfSigned() {
    return this.withNewSelfSignedLike(Optional.ofNullable(this.buildSelfSigned()).orElse(null));
  }
  
  public VaultNested<A> editVault() {
    return this.withNewVaultLike(Optional.ofNullable(this.buildVault()).orElse(null));
  }
  
  public VenafiNested<A> editVenafi() {
    return this.withNewVenafiLike(Optional.ofNullable(this.buildVenafi()).orElse(null));
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
    IssuerSpecFluent that = (IssuerSpecFluent) o;
    if (!(Objects.equals(acme, that.acme))) {
      return false;
    }
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(selfSigned, that.selfSigned))) {
      return false;
    }
    if (!(Objects.equals(vault, that.vault))) {
      return false;
    }
    if (!(Objects.equals(venafi, that.venafi))) {
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
  
  public boolean hasAcme() {
    return this.acme != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasSelfSigned() {
    return this.selfSigned != null;
  }
  
  public boolean hasVault() {
    return this.vault != null;
  }
  
  public boolean hasVenafi() {
    return this.venafi != null;
  }
  
  public int hashCode() {
    return Objects.hash(acme, ca, selfSigned, vault, venafi, additionalProperties);
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
    if (!(acme == null)) {
        sb.append("acme:");
        sb.append(acme);
        sb.append(",");
    }
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(selfSigned == null)) {
        sb.append("selfSigned:");
        sb.append(selfSigned);
        sb.append(",");
    }
    if (!(vault == null)) {
        sb.append("vault:");
        sb.append(vault);
        sb.append(",");
    }
    if (!(venafi == null)) {
        sb.append("venafi:");
        sb.append(venafi);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcme(ACMEIssuer acme) {
    this._visitables.remove("acme");
    if (acme != null) {
        this.acme = new ACMEIssuerBuilder(acme);
        this._visitables.get("acme").add(this.acme);
    } else {
        this.acme = null;
        this._visitables.get("acme").remove(this.acme);
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
  
  public A withCa(CAIssuer ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new CAIssuerBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public AcmeNested<A> withNewAcme() {
    return new AcmeNested(null);
  }
  
  public AcmeNested<A> withNewAcmeLike(ACMEIssuer item) {
    return new AcmeNested(item);
  }
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public CaNested<A> withNewCaLike(CAIssuer item) {
    return new CaNested(item);
  }
  
  public SelfSignedNested<A> withNewSelfSigned() {
    return new SelfSignedNested(null);
  }
  
  public SelfSignedNested<A> withNewSelfSignedLike(SelfSignedIssuer item) {
    return new SelfSignedNested(item);
  }
  
  public VaultNested<A> withNewVault() {
    return new VaultNested(null);
  }
  
  public VaultNested<A> withNewVaultLike(VaultIssuer item) {
    return new VaultNested(item);
  }
  
  public VenafiNested<A> withNewVenafi() {
    return new VenafiNested(null);
  }
  
  public VenafiNested<A> withNewVenafiLike(VenafiIssuer item) {
    return new VenafiNested(item);
  }
  
  public A withSelfSigned(SelfSignedIssuer selfSigned) {
    this._visitables.remove("selfSigned");
    if (selfSigned != null) {
        this.selfSigned = new SelfSignedIssuerBuilder(selfSigned);
        this._visitables.get("selfSigned").add(this.selfSigned);
    } else {
        this.selfSigned = null;
        this._visitables.get("selfSigned").remove(this.selfSigned);
    }
    return (A) this;
  }
  
  public A withVault(VaultIssuer vault) {
    this._visitables.remove("vault");
    if (vault != null) {
        this.vault = new VaultIssuerBuilder(vault);
        this._visitables.get("vault").add(this.vault);
    } else {
        this.vault = null;
        this._visitables.get("vault").remove(this.vault);
    }
    return (A) this;
  }
  
  public A withVenafi(VenafiIssuer venafi) {
    this._visitables.remove("venafi");
    if (venafi != null) {
        this.venafi = new VenafiIssuerBuilder(venafi);
        this._visitables.get("venafi").add(this.venafi);
    } else {
        this.venafi = null;
        this._visitables.get("venafi").remove(this.venafi);
    }
    return (A) this;
  }
  public class AcmeNested<N> extends ACMEIssuerFluent<AcmeNested<N>> implements Nested<N>{
  
    ACMEIssuerBuilder builder;
  
    AcmeNested(ACMEIssuer item) {
      this.builder = new ACMEIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerSpecFluent.this.withAcme(builder.build());
    }
    
    public N endAcme() {
      return and();
    }
    
  }
  public class CaNested<N> extends CAIssuerFluent<CaNested<N>> implements Nested<N>{
  
    CAIssuerBuilder builder;
  
    CaNested(CAIssuer item) {
      this.builder = new CAIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerSpecFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
  public class SelfSignedNested<N> extends SelfSignedIssuerFluent<SelfSignedNested<N>> implements Nested<N>{
  
    SelfSignedIssuerBuilder builder;
  
    SelfSignedNested(SelfSignedIssuer item) {
      this.builder = new SelfSignedIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerSpecFluent.this.withSelfSigned(builder.build());
    }
    
    public N endSelfSigned() {
      return and();
    }
    
  }
  public class VaultNested<N> extends VaultIssuerFluent<VaultNested<N>> implements Nested<N>{
  
    VaultIssuerBuilder builder;
  
    VaultNested(VaultIssuer item) {
      this.builder = new VaultIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerSpecFluent.this.withVault(builder.build());
    }
    
    public N endVault() {
      return and();
    }
    
  }
  public class VenafiNested<N> extends VenafiIssuerFluent<VenafiNested<N>> implements Nested<N>{
  
    VenafiIssuerBuilder builder;
  
    VenafiNested(VenafiIssuer item) {
      this.builder = new VenafiIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerSpecFluent.this.withVenafi(builder.build());
    }
    
    public N endVenafi() {
      return and();
    }
    
  }
}