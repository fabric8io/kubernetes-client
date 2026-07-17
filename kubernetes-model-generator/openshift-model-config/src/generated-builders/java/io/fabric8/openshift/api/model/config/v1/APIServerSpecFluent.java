package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class APIServerSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.APIServerSpecFluent<A>> extends BaseFluent<A>{

  private List<String> additionalCORSAllowedOrigins = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private AuditBuilder audit;
  private ConfigMapNameReferenceBuilder clientCA;
  private APIServerEncryptionBuilder encryption;
  private APIServerServingCertsBuilder servingCerts;
  private TLSSecurityProfileBuilder tlsSecurityProfile;

  public APIServerSpecFluent() {
  }
  
  public APIServerSpecFluent(APIServerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalCORSAllowedOrigins(Collection<String> items) {
    if (this.additionalCORSAllowedOrigins == null) {
      this.additionalCORSAllowedOrigins = new ArrayList();
    }
    for (String item : items) {
      this.additionalCORSAllowedOrigins.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalCORSAllowedOrigins(String... items) {
    if (this.additionalCORSAllowedOrigins == null) {
      this.additionalCORSAllowedOrigins = new ArrayList();
    }
    for (String item : items) {
      this.additionalCORSAllowedOrigins.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalCORSAllowedOrigins(int index,String item) {
    if (this.additionalCORSAllowedOrigins == null) {
      this.additionalCORSAllowedOrigins = new ArrayList();
    }
    this.additionalCORSAllowedOrigins.add(index, item);
    return (A) this;
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
  
  public Audit buildAudit() {
    return this.audit != null ? this.audit.build() : null;
  }
  
  public ConfigMapNameReference buildClientCA() {
    return this.clientCA != null ? this.clientCA.build() : null;
  }
  
  public APIServerEncryption buildEncryption() {
    return this.encryption != null ? this.encryption.build() : null;
  }
  
  public APIServerServingCerts buildServingCerts() {
    return this.servingCerts != null ? this.servingCerts.build() : null;
  }
  
  public TLSSecurityProfile buildTlsSecurityProfile() {
    return this.tlsSecurityProfile != null ? this.tlsSecurityProfile.build() : null;
  }
  
  protected void copyInstance(APIServerSpec instance) {
    instance = instance != null ? instance : new APIServerSpec();
    if (instance != null) {
        this.withAdditionalCORSAllowedOrigins(instance.getAdditionalCORSAllowedOrigins());
        this.withAudit(instance.getAudit());
        this.withClientCA(instance.getClientCA());
        this.withEncryption(instance.getEncryption());
        this.withServingCerts(instance.getServingCerts());
        this.withTlsSecurityProfile(instance.getTlsSecurityProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuditNested<A> editAudit() {
    return this.withNewAuditLike(Optional.ofNullable(this.buildAudit()).orElse(null));
  }
  
  public ClientCANested<A> editClientCA() {
    return this.withNewClientCALike(Optional.ofNullable(this.buildClientCA()).orElse(null));
  }
  
  public EncryptionNested<A> editEncryption() {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(null));
  }
  
  public AuditNested<A> editOrNewAudit() {
    return this.withNewAuditLike(Optional.ofNullable(this.buildAudit()).orElse(new AuditBuilder().build()));
  }
  
  public AuditNested<A> editOrNewAuditLike(Audit item) {
    return this.withNewAuditLike(Optional.ofNullable(this.buildAudit()).orElse(item));
  }
  
  public ClientCANested<A> editOrNewClientCA() {
    return this.withNewClientCALike(Optional.ofNullable(this.buildClientCA()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public ClientCANested<A> editOrNewClientCALike(ConfigMapNameReference item) {
    return this.withNewClientCALike(Optional.ofNullable(this.buildClientCA()).orElse(item));
  }
  
  public EncryptionNested<A> editOrNewEncryption() {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(new APIServerEncryptionBuilder().build()));
  }
  
  public EncryptionNested<A> editOrNewEncryptionLike(APIServerEncryption item) {
    return this.withNewEncryptionLike(Optional.ofNullable(this.buildEncryption()).orElse(item));
  }
  
  public ServingCertsNested<A> editOrNewServingCerts() {
    return this.withNewServingCertsLike(Optional.ofNullable(this.buildServingCerts()).orElse(new APIServerServingCertsBuilder().build()));
  }
  
  public ServingCertsNested<A> editOrNewServingCertsLike(APIServerServingCerts item) {
    return this.withNewServingCertsLike(Optional.ofNullable(this.buildServingCerts()).orElse(item));
  }
  
  public TlsSecurityProfileNested<A> editOrNewTlsSecurityProfile() {
    return this.withNewTlsSecurityProfileLike(Optional.ofNullable(this.buildTlsSecurityProfile()).orElse(new TLSSecurityProfileBuilder().build()));
  }
  
  public TlsSecurityProfileNested<A> editOrNewTlsSecurityProfileLike(TLSSecurityProfile item) {
    return this.withNewTlsSecurityProfileLike(Optional.ofNullable(this.buildTlsSecurityProfile()).orElse(item));
  }
  
  public ServingCertsNested<A> editServingCerts() {
    return this.withNewServingCertsLike(Optional.ofNullable(this.buildServingCerts()).orElse(null));
  }
  
  public TlsSecurityProfileNested<A> editTlsSecurityProfile() {
    return this.withNewTlsSecurityProfileLike(Optional.ofNullable(this.buildTlsSecurityProfile()).orElse(null));
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
    APIServerSpecFluent that = (APIServerSpecFluent) o;
    if (!(Objects.equals(additionalCORSAllowedOrigins, that.additionalCORSAllowedOrigins))) {
      return false;
    }
    if (!(Objects.equals(audit, that.audit))) {
      return false;
    }
    if (!(Objects.equals(clientCA, that.clientCA))) {
      return false;
    }
    if (!(Objects.equals(encryption, that.encryption))) {
      return false;
    }
    if (!(Objects.equals(servingCerts, that.servingCerts))) {
      return false;
    }
    if (!(Objects.equals(tlsSecurityProfile, that.tlsSecurityProfile))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAdditionalCORSAllowedOrigin(int index) {
    return this.additionalCORSAllowedOrigins.get(index);
  }
  
  public List<String> getAdditionalCORSAllowedOrigins() {
    return this.additionalCORSAllowedOrigins;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getFirstAdditionalCORSAllowedOrigin() {
    return this.additionalCORSAllowedOrigins.get(0);
  }
  
  public String getLastAdditionalCORSAllowedOrigin() {
    return this.additionalCORSAllowedOrigins.get(additionalCORSAllowedOrigins.size() - 1);
  }
  
  public String getMatchingAdditionalCORSAllowedOrigin(Predicate<String> predicate) {
      for (String item : additionalCORSAllowedOrigins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalCORSAllowedOrigins() {
    return this.additionalCORSAllowedOrigins != null && !(this.additionalCORSAllowedOrigins.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAudit() {
    return this.audit != null;
  }
  
  public boolean hasClientCA() {
    return this.clientCA != null;
  }
  
  public boolean hasEncryption() {
    return this.encryption != null;
  }
  
  public boolean hasMatchingAdditionalCORSAllowedOrigin(Predicate<String> predicate) {
      for (String item : additionalCORSAllowedOrigins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasServingCerts() {
    return this.servingCerts != null;
  }
  
  public boolean hasTlsSecurityProfile() {
    return this.tlsSecurityProfile != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalCORSAllowedOrigins, audit, clientCA, encryption, servingCerts, tlsSecurityProfile, additionalProperties);
  }
  
  public A removeAllFromAdditionalCORSAllowedOrigins(Collection<String> items) {
    if (this.additionalCORSAllowedOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalCORSAllowedOrigins.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalCORSAllowedOrigins(String... items) {
    if (this.additionalCORSAllowedOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalCORSAllowedOrigins.remove(item);
    }
    return (A) this;
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
  
  public A setToAdditionalCORSAllowedOrigins(int index,String item) {
    if (this.additionalCORSAllowedOrigins == null) {
      this.additionalCORSAllowedOrigins = new ArrayList();
    }
    this.additionalCORSAllowedOrigins.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalCORSAllowedOrigins == null) && !(additionalCORSAllowedOrigins.isEmpty())) {
        sb.append("additionalCORSAllowedOrigins:");
        sb.append(additionalCORSAllowedOrigins);
        sb.append(",");
    }
    if (!(audit == null)) {
        sb.append("audit:");
        sb.append(audit);
        sb.append(",");
    }
    if (!(clientCA == null)) {
        sb.append("clientCA:");
        sb.append(clientCA);
        sb.append(",");
    }
    if (!(encryption == null)) {
        sb.append("encryption:");
        sb.append(encryption);
        sb.append(",");
    }
    if (!(servingCerts == null)) {
        sb.append("servingCerts:");
        sb.append(servingCerts);
        sb.append(",");
    }
    if (!(tlsSecurityProfile == null)) {
        sb.append("tlsSecurityProfile:");
        sb.append(tlsSecurityProfile);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalCORSAllowedOrigins(List<String> additionalCORSAllowedOrigins) {
    if (additionalCORSAllowedOrigins != null) {
        this.additionalCORSAllowedOrigins = new ArrayList();
        for (String item : additionalCORSAllowedOrigins) {
          this.addToAdditionalCORSAllowedOrigins(item);
        }
    } else {
      this.additionalCORSAllowedOrigins = null;
    }
    return (A) this;
  }
  
  public A withAdditionalCORSAllowedOrigins(String... additionalCORSAllowedOrigins) {
    if (this.additionalCORSAllowedOrigins != null) {
        this.additionalCORSAllowedOrigins.clear();
        _visitables.remove("additionalCORSAllowedOrigins");
    }
    if (additionalCORSAllowedOrigins != null) {
      for (String item : additionalCORSAllowedOrigins) {
        this.addToAdditionalCORSAllowedOrigins(item);
      }
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
  
  public A withAudit(Audit audit) {
    this._visitables.remove("audit");
    if (audit != null) {
        this.audit = new AuditBuilder(audit);
        this._visitables.get("audit").add(this.audit);
    } else {
        this.audit = null;
        this._visitables.get("audit").remove(this.audit);
    }
    return (A) this;
  }
  
  public A withClientCA(ConfigMapNameReference clientCA) {
    this._visitables.remove("clientCA");
    if (clientCA != null) {
        this.clientCA = new ConfigMapNameReferenceBuilder(clientCA);
        this._visitables.get("clientCA").add(this.clientCA);
    } else {
        this.clientCA = null;
        this._visitables.get("clientCA").remove(this.clientCA);
    }
    return (A) this;
  }
  
  public A withEncryption(APIServerEncryption encryption) {
    this._visitables.remove("encryption");
    if (encryption != null) {
        this.encryption = new APIServerEncryptionBuilder(encryption);
        this._visitables.get("encryption").add(this.encryption);
    } else {
        this.encryption = null;
        this._visitables.get("encryption").remove(this.encryption);
    }
    return (A) this;
  }
  
  public AuditNested<A> withNewAudit() {
    return new AuditNested(null);
  }
  
  public AuditNested<A> withNewAuditLike(Audit item) {
    return new AuditNested(item);
  }
  
  public ClientCANested<A> withNewClientCA() {
    return new ClientCANested(null);
  }
  
  public A withNewClientCA(String name) {
    return (A) this.withClientCA(new ConfigMapNameReference(name));
  }
  
  public ClientCANested<A> withNewClientCALike(ConfigMapNameReference item) {
    return new ClientCANested(item);
  }
  
  public EncryptionNested<A> withNewEncryption() {
    return new EncryptionNested(null);
  }
  
  public EncryptionNested<A> withNewEncryptionLike(APIServerEncryption item) {
    return new EncryptionNested(item);
  }
  
  public ServingCertsNested<A> withNewServingCerts() {
    return new ServingCertsNested(null);
  }
  
  public ServingCertsNested<A> withNewServingCertsLike(APIServerServingCerts item) {
    return new ServingCertsNested(item);
  }
  
  public TlsSecurityProfileNested<A> withNewTlsSecurityProfile() {
    return new TlsSecurityProfileNested(null);
  }
  
  public TlsSecurityProfileNested<A> withNewTlsSecurityProfileLike(TLSSecurityProfile item) {
    return new TlsSecurityProfileNested(item);
  }
  
  public A withServingCerts(APIServerServingCerts servingCerts) {
    this._visitables.remove("servingCerts");
    if (servingCerts != null) {
        this.servingCerts = new APIServerServingCertsBuilder(servingCerts);
        this._visitables.get("servingCerts").add(this.servingCerts);
    } else {
        this.servingCerts = null;
        this._visitables.get("servingCerts").remove(this.servingCerts);
    }
    return (A) this;
  }
  
  public A withTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
    this._visitables.remove("tlsSecurityProfile");
    if (tlsSecurityProfile != null) {
        this.tlsSecurityProfile = new TLSSecurityProfileBuilder(tlsSecurityProfile);
        this._visitables.get("tlsSecurityProfile").add(this.tlsSecurityProfile);
    } else {
        this.tlsSecurityProfile = null;
        this._visitables.get("tlsSecurityProfile").remove(this.tlsSecurityProfile);
    }
    return (A) this;
  }
  public class AuditNested<N> extends AuditFluent<AuditNested<N>> implements Nested<N>{
  
    AuditBuilder builder;
  
    AuditNested(Audit item) {
      this.builder = new AuditBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerSpecFluent.this.withAudit(builder.build());
    }
    
    public N endAudit() {
      return and();
    }
    
  }
  public class ClientCANested<N> extends ConfigMapNameReferenceFluent<ClientCANested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    ClientCANested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerSpecFluent.this.withClientCA(builder.build());
    }
    
    public N endClientCA() {
      return and();
    }
    
  }
  public class EncryptionNested<N> extends APIServerEncryptionFluent<EncryptionNested<N>> implements Nested<N>{
  
    APIServerEncryptionBuilder builder;
  
    EncryptionNested(APIServerEncryption item) {
      this.builder = new APIServerEncryptionBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerSpecFluent.this.withEncryption(builder.build());
    }
    
    public N endEncryption() {
      return and();
    }
    
  }
  public class ServingCertsNested<N> extends APIServerServingCertsFluent<ServingCertsNested<N>> implements Nested<N>{
  
    APIServerServingCertsBuilder builder;
  
    ServingCertsNested(APIServerServingCerts item) {
      this.builder = new APIServerServingCertsBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerSpecFluent.this.withServingCerts(builder.build());
    }
    
    public N endServingCerts() {
      return and();
    }
    
  }
  public class TlsSecurityProfileNested<N> extends TLSSecurityProfileFluent<TlsSecurityProfileNested<N>> implements Nested<N>{
  
    TLSSecurityProfileBuilder builder;
  
    TlsSecurityProfileNested(TLSSecurityProfile item) {
      this.builder = new TLSSecurityProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServerSpecFluent.this.withTlsSecurityProfile(builder.build());
    }
    
    public N endTlsSecurityProfile() {
      return and();
    }
    
  }
}