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
public class GenericAPIServerConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.GenericAPIServerConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AdmissionConfigBuilder admission;
  private AuditConfigBuilder auditConfig;
  private List<String> corsAllowedOrigins = new ArrayList<String>();
  private KubeClientConfigBuilder kubeClientConfig;
  private HTTPServingInfoBuilder servingInfo;
  private EtcdStorageConfigBuilder storageConfig;

  public GenericAPIServerConfigFluent() {
  }
  
  public GenericAPIServerConfigFluent(GenericAPIServerConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCorsAllowedOrigins(Collection<String> items) {
    if (this.corsAllowedOrigins == null) {
      this.corsAllowedOrigins = new ArrayList();
    }
    for (String item : items) {
      this.corsAllowedOrigins.add(item);
    }
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
  
  public A addToCorsAllowedOrigins(String... items) {
    if (this.corsAllowedOrigins == null) {
      this.corsAllowedOrigins = new ArrayList();
    }
    for (String item : items) {
      this.corsAllowedOrigins.add(item);
    }
    return (A) this;
  }
  
  public A addToCorsAllowedOrigins(int index,String item) {
    if (this.corsAllowedOrigins == null) {
      this.corsAllowedOrigins = new ArrayList();
    }
    this.corsAllowedOrigins.add(index, item);
    return (A) this;
  }
  
  public AdmissionConfig buildAdmission() {
    return this.admission != null ? this.admission.build() : null;
  }
  
  public AuditConfig buildAuditConfig() {
    return this.auditConfig != null ? this.auditConfig.build() : null;
  }
  
  public KubeClientConfig buildKubeClientConfig() {
    return this.kubeClientConfig != null ? this.kubeClientConfig.build() : null;
  }
  
  public HTTPServingInfo buildServingInfo() {
    return this.servingInfo != null ? this.servingInfo.build() : null;
  }
  
  public EtcdStorageConfig buildStorageConfig() {
    return this.storageConfig != null ? this.storageConfig.build() : null;
  }
  
  protected void copyInstance(GenericAPIServerConfig instance) {
    instance = instance != null ? instance : new GenericAPIServerConfig();
    if (instance != null) {
        this.withAdmission(instance.getAdmission());
        this.withAuditConfig(instance.getAuditConfig());
        this.withCorsAllowedOrigins(instance.getCorsAllowedOrigins());
        this.withKubeClientConfig(instance.getKubeClientConfig());
        this.withServingInfo(instance.getServingInfo());
        this.withStorageConfig(instance.getStorageConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdmissionNested<A> editAdmission() {
    return this.withNewAdmissionLike(Optional.ofNullable(this.buildAdmission()).orElse(null));
  }
  
  public AuditConfigNested<A> editAuditConfig() {
    return this.withNewAuditConfigLike(Optional.ofNullable(this.buildAuditConfig()).orElse(null));
  }
  
  public KubeClientConfigNested<A> editKubeClientConfig() {
    return this.withNewKubeClientConfigLike(Optional.ofNullable(this.buildKubeClientConfig()).orElse(null));
  }
  
  public AdmissionNested<A> editOrNewAdmission() {
    return this.withNewAdmissionLike(Optional.ofNullable(this.buildAdmission()).orElse(new AdmissionConfigBuilder().build()));
  }
  
  public AdmissionNested<A> editOrNewAdmissionLike(AdmissionConfig item) {
    return this.withNewAdmissionLike(Optional.ofNullable(this.buildAdmission()).orElse(item));
  }
  
  public AuditConfigNested<A> editOrNewAuditConfig() {
    return this.withNewAuditConfigLike(Optional.ofNullable(this.buildAuditConfig()).orElse(new AuditConfigBuilder().build()));
  }
  
  public AuditConfigNested<A> editOrNewAuditConfigLike(AuditConfig item) {
    return this.withNewAuditConfigLike(Optional.ofNullable(this.buildAuditConfig()).orElse(item));
  }
  
  public KubeClientConfigNested<A> editOrNewKubeClientConfig() {
    return this.withNewKubeClientConfigLike(Optional.ofNullable(this.buildKubeClientConfig()).orElse(new KubeClientConfigBuilder().build()));
  }
  
  public KubeClientConfigNested<A> editOrNewKubeClientConfigLike(KubeClientConfig item) {
    return this.withNewKubeClientConfigLike(Optional.ofNullable(this.buildKubeClientConfig()).orElse(item));
  }
  
  public ServingInfoNested<A> editOrNewServingInfo() {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(new HTTPServingInfoBuilder().build()));
  }
  
  public ServingInfoNested<A> editOrNewServingInfoLike(HTTPServingInfo item) {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(item));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(new EtcdStorageConfigBuilder().build()));
  }
  
  public StorageConfigNested<A> editOrNewStorageConfigLike(EtcdStorageConfig item) {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(item));
  }
  
  public ServingInfoNested<A> editServingInfo() {
    return this.withNewServingInfoLike(Optional.ofNullable(this.buildServingInfo()).orElse(null));
  }
  
  public StorageConfigNested<A> editStorageConfig() {
    return this.withNewStorageConfigLike(Optional.ofNullable(this.buildStorageConfig()).orElse(null));
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
    GenericAPIServerConfigFluent that = (GenericAPIServerConfigFluent) o;
    if (!(Objects.equals(admission, that.admission))) {
      return false;
    }
    if (!(Objects.equals(auditConfig, that.auditConfig))) {
      return false;
    }
    if (!(Objects.equals(corsAllowedOrigins, that.corsAllowedOrigins))) {
      return false;
    }
    if (!(Objects.equals(kubeClientConfig, that.kubeClientConfig))) {
      return false;
    }
    if (!(Objects.equals(servingInfo, that.servingInfo))) {
      return false;
    }
    if (!(Objects.equals(storageConfig, that.storageConfig))) {
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
  
  public String getCorsAllowedOrigin(int index) {
    return this.corsAllowedOrigins.get(index);
  }
  
  public List<String> getCorsAllowedOrigins() {
    return this.corsAllowedOrigins;
  }
  
  public String getFirstCorsAllowedOrigin() {
    return this.corsAllowedOrigins.get(0);
  }
  
  public String getLastCorsAllowedOrigin() {
    return this.corsAllowedOrigins.get(corsAllowedOrigins.size() - 1);
  }
  
  public String getMatchingCorsAllowedOrigin(Predicate<String> predicate) {
      for (String item : corsAllowedOrigins) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdmission() {
    return this.admission != null;
  }
  
  public boolean hasAuditConfig() {
    return this.auditConfig != null;
  }
  
  public boolean hasCorsAllowedOrigins() {
    return this.corsAllowedOrigins != null && !(this.corsAllowedOrigins.isEmpty());
  }
  
  public boolean hasKubeClientConfig() {
    return this.kubeClientConfig != null;
  }
  
  public boolean hasMatchingCorsAllowedOrigin(Predicate<String> predicate) {
      for (String item : corsAllowedOrigins) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasServingInfo() {
    return this.servingInfo != null;
  }
  
  public boolean hasStorageConfig() {
    return this.storageConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(admission, auditConfig, corsAllowedOrigins, kubeClientConfig, servingInfo, storageConfig, additionalProperties);
  }
  
  public A removeAllFromCorsAllowedOrigins(Collection<String> items) {
    if (this.corsAllowedOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.corsAllowedOrigins.remove(item);
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
  
  public A removeFromCorsAllowedOrigins(String... items) {
    if (this.corsAllowedOrigins == null) {
      return (A) this;
    }
    for (String item : items) {
      this.corsAllowedOrigins.remove(item);
    }
    return (A) this;
  }
  
  public A setToCorsAllowedOrigins(int index,String item) {
    if (this.corsAllowedOrigins == null) {
      this.corsAllowedOrigins = new ArrayList();
    }
    this.corsAllowedOrigins.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(admission == null)) {
        sb.append("admission:");
        sb.append(admission);
        sb.append(",");
    }
    if (!(auditConfig == null)) {
        sb.append("auditConfig:");
        sb.append(auditConfig);
        sb.append(",");
    }
    if (!(corsAllowedOrigins == null) && !(corsAllowedOrigins.isEmpty())) {
        sb.append("corsAllowedOrigins:");
        sb.append(corsAllowedOrigins);
        sb.append(",");
    }
    if (!(kubeClientConfig == null)) {
        sb.append("kubeClientConfig:");
        sb.append(kubeClientConfig);
        sb.append(",");
    }
    if (!(servingInfo == null)) {
        sb.append("servingInfo:");
        sb.append(servingInfo);
        sb.append(",");
    }
    if (!(storageConfig == null)) {
        sb.append("storageConfig:");
        sb.append(storageConfig);
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
  
  public A withAdmission(AdmissionConfig admission) {
    this._visitables.remove("admission");
    if (admission != null) {
        this.admission = new AdmissionConfigBuilder(admission);
        this._visitables.get("admission").add(this.admission);
    } else {
        this.admission = null;
        this._visitables.get("admission").remove(this.admission);
    }
    return (A) this;
  }
  
  public A withAuditConfig(AuditConfig auditConfig) {
    this._visitables.remove("auditConfig");
    if (auditConfig != null) {
        this.auditConfig = new AuditConfigBuilder(auditConfig);
        this._visitables.get("auditConfig").add(this.auditConfig);
    } else {
        this.auditConfig = null;
        this._visitables.get("auditConfig").remove(this.auditConfig);
    }
    return (A) this;
  }
  
  public A withCorsAllowedOrigins(List<String> corsAllowedOrigins) {
    if (corsAllowedOrigins != null) {
        this.corsAllowedOrigins = new ArrayList();
        for (String item : corsAllowedOrigins) {
          this.addToCorsAllowedOrigins(item);
        }
    } else {
      this.corsAllowedOrigins = null;
    }
    return (A) this;
  }
  
  public A withCorsAllowedOrigins(String... corsAllowedOrigins) {
    if (this.corsAllowedOrigins != null) {
        this.corsAllowedOrigins.clear();
        _visitables.remove("corsAllowedOrigins");
    }
    if (corsAllowedOrigins != null) {
      for (String item : corsAllowedOrigins) {
        this.addToCorsAllowedOrigins(item);
      }
    }
    return (A) this;
  }
  
  public A withKubeClientConfig(KubeClientConfig kubeClientConfig) {
    this._visitables.remove("kubeClientConfig");
    if (kubeClientConfig != null) {
        this.kubeClientConfig = new KubeClientConfigBuilder(kubeClientConfig);
        this._visitables.get("kubeClientConfig").add(this.kubeClientConfig);
    } else {
        this.kubeClientConfig = null;
        this._visitables.get("kubeClientConfig").remove(this.kubeClientConfig);
    }
    return (A) this;
  }
  
  public AdmissionNested<A> withNewAdmission() {
    return new AdmissionNested(null);
  }
  
  public AdmissionNested<A> withNewAdmissionLike(AdmissionConfig item) {
    return new AdmissionNested(item);
  }
  
  public AuditConfigNested<A> withNewAuditConfig() {
    return new AuditConfigNested(null);
  }
  
  public AuditConfigNested<A> withNewAuditConfigLike(AuditConfig item) {
    return new AuditConfigNested(item);
  }
  
  public KubeClientConfigNested<A> withNewKubeClientConfig() {
    return new KubeClientConfigNested(null);
  }
  
  public KubeClientConfigNested<A> withNewKubeClientConfigLike(KubeClientConfig item) {
    return new KubeClientConfigNested(item);
  }
  
  public ServingInfoNested<A> withNewServingInfo() {
    return new ServingInfoNested(null);
  }
  
  public ServingInfoNested<A> withNewServingInfoLike(HTTPServingInfo item) {
    return new ServingInfoNested(item);
  }
  
  public StorageConfigNested<A> withNewStorageConfig() {
    return new StorageConfigNested(null);
  }
  
  public StorageConfigNested<A> withNewStorageConfigLike(EtcdStorageConfig item) {
    return new StorageConfigNested(item);
  }
  
  public A withServingInfo(HTTPServingInfo servingInfo) {
    this._visitables.remove("servingInfo");
    if (servingInfo != null) {
        this.servingInfo = new HTTPServingInfoBuilder(servingInfo);
        this._visitables.get("servingInfo").add(this.servingInfo);
    } else {
        this.servingInfo = null;
        this._visitables.get("servingInfo").remove(this.servingInfo);
    }
    return (A) this;
  }
  
  public A withStorageConfig(EtcdStorageConfig storageConfig) {
    this._visitables.remove("storageConfig");
    if (storageConfig != null) {
        this.storageConfig = new EtcdStorageConfigBuilder(storageConfig);
        this._visitables.get("storageConfig").add(this.storageConfig);
    } else {
        this.storageConfig = null;
        this._visitables.get("storageConfig").remove(this.storageConfig);
    }
    return (A) this;
  }
  public class AdmissionNested<N> extends AdmissionConfigFluent<AdmissionNested<N>> implements Nested<N>{
  
    AdmissionConfigBuilder builder;
  
    AdmissionNested(AdmissionConfig item) {
      this.builder = new AdmissionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAPIServerConfigFluent.this.withAdmission(builder.build());
    }
    
    public N endAdmission() {
      return and();
    }
    
  }
  public class AuditConfigNested<N> extends AuditConfigFluent<AuditConfigNested<N>> implements Nested<N>{
  
    AuditConfigBuilder builder;
  
    AuditConfigNested(AuditConfig item) {
      this.builder = new AuditConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAPIServerConfigFluent.this.withAuditConfig(builder.build());
    }
    
    public N endAuditConfig() {
      return and();
    }
    
  }
  public class KubeClientConfigNested<N> extends KubeClientConfigFluent<KubeClientConfigNested<N>> implements Nested<N>{
  
    KubeClientConfigBuilder builder;
  
    KubeClientConfigNested(KubeClientConfig item) {
      this.builder = new KubeClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAPIServerConfigFluent.this.withKubeClientConfig(builder.build());
    }
    
    public N endKubeClientConfig() {
      return and();
    }
    
  }
  public class ServingInfoNested<N> extends HTTPServingInfoFluent<ServingInfoNested<N>> implements Nested<N>{
  
    HTTPServingInfoBuilder builder;
  
    ServingInfoNested(HTTPServingInfo item) {
      this.builder = new HTTPServingInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAPIServerConfigFluent.this.withServingInfo(builder.build());
    }
    
    public N endServingInfo() {
      return and();
    }
    
  }
  public class StorageConfigNested<N> extends EtcdStorageConfigFluent<StorageConfigNested<N>> implements Nested<N>{
  
    EtcdStorageConfigBuilder builder;
  
    StorageConfigNested(EtcdStorageConfig item) {
      this.builder = new EtcdStorageConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAPIServerConfigFluent.this.withStorageConfig(builder.build());
    }
    
    public N endStorageConfig() {
      return and();
    }
    
  }
}