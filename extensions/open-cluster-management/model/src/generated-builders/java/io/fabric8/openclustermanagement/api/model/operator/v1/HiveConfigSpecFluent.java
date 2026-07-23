package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class HiveConfigSpecFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.HiveConfigSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<LocalObjectReferenceBuilder> additionalCertificateAuthorities = new ArrayList<LocalObjectReferenceBuilder>();
  private Map<String,Object> additionalProperties;
  private BackupConfigBuilder backup;
  private ExternalDNSConfigBuilder externalDNS;
  private FailedProvisionConfigBuilder failedProvisionConfig;
  private LocalObjectReferenceBuilder globalPullSecret;
  private Boolean maintenanceMode;

  public HiveConfigSpecFluent() {
  }
  
  public HiveConfigSpecFluent(HiveConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalCertificateAuthorities(Collection<LocalObjectReference> items) {
    if (this.additionalCertificateAuthorities == null) {
      this.additionalCertificateAuthorities = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthorities").add(builder);
        this.additionalCertificateAuthorities.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalCertificateAuthoritiesNested<A> addNewAdditionalCertificateAuthority() {
    return new AdditionalCertificateAuthoritiesNested(-1, null);
  }
  
  public A addNewAdditionalCertificateAuthority(String name) {
    return (A) this.addToAdditionalCertificateAuthorities(new LocalObjectReference(name));
  }
  
  public AdditionalCertificateAuthoritiesNested<A> addNewAdditionalCertificateAuthorityLike(LocalObjectReference item) {
    return new AdditionalCertificateAuthoritiesNested(-1, item);
  }
  
  public A addToAdditionalCertificateAuthorities(LocalObjectReference... items) {
    if (this.additionalCertificateAuthorities == null) {
      this.additionalCertificateAuthorities = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthorities").add(builder);
        this.additionalCertificateAuthorities.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalCertificateAuthorities(int index,LocalObjectReference item) {
    if (this.additionalCertificateAuthorities == null) {
      this.additionalCertificateAuthorities = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= additionalCertificateAuthorities.size()) {
        _visitables.get("additionalCertificateAuthorities").add(builder);
        additionalCertificateAuthorities.add(builder);
    } else {
        _visitables.get("additionalCertificateAuthorities").add(builder);
        additionalCertificateAuthorities.add(index, builder);
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
  
  public List<LocalObjectReference> buildAdditionalCertificateAuthorities() {
    return this.additionalCertificateAuthorities != null ? build(additionalCertificateAuthorities) : null;
  }
  
  public LocalObjectReference buildAdditionalCertificateAuthority(int index) {
    return this.additionalCertificateAuthorities.get(index).build();
  }
  
  public BackupConfig buildBackup() {
    return this.backup != null ? this.backup.build() : null;
  }
  
  public ExternalDNSConfig buildExternalDNS() {
    return this.externalDNS != null ? this.externalDNS.build() : null;
  }
  
  public FailedProvisionConfig buildFailedProvisionConfig() {
    return this.failedProvisionConfig != null ? this.failedProvisionConfig.build() : null;
  }
  
  public LocalObjectReference buildFirstAdditionalCertificateAuthority() {
    return this.additionalCertificateAuthorities.get(0).build();
  }
  
  public LocalObjectReference buildGlobalPullSecret() {
    return this.globalPullSecret != null ? this.globalPullSecret.build() : null;
  }
  
  public LocalObjectReference buildLastAdditionalCertificateAuthority() {
    return this.additionalCertificateAuthorities.get(additionalCertificateAuthorities.size() - 1).build();
  }
  
  public LocalObjectReference buildMatchingAdditionalCertificateAuthority(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : additionalCertificateAuthorities) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(HiveConfigSpec instance) {
    instance = instance != null ? instance : new HiveConfigSpec();
    if (instance != null) {
        this.withAdditionalCertificateAuthorities(instance.getAdditionalCertificateAuthorities());
        this.withBackup(instance.getBackup());
        this.withExternalDNS(instance.getExternalDNS());
        this.withFailedProvisionConfig(instance.getFailedProvisionConfig());
        this.withGlobalPullSecret(instance.getGlobalPullSecret());
        this.withMaintenanceMode(instance.getMaintenanceMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalCertificateAuthoritiesNested<A> editAdditionalCertificateAuthority(int index) {
    if (additionalCertificateAuthorities.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalCertificateAuthorities"));
    }
    return this.setNewAdditionalCertificateAuthorityLike(index, this.buildAdditionalCertificateAuthority(index));
  }
  
  public BackupNested<A> editBackup() {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(null));
  }
  
  public ExternalDNSNested<A> editExternalDNS() {
    return this.withNewExternalDNSLike(Optional.ofNullable(this.buildExternalDNS()).orElse(null));
  }
  
  public FailedProvisionConfigNested<A> editFailedProvisionConfig() {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(null));
  }
  
  public AdditionalCertificateAuthoritiesNested<A> editFirstAdditionalCertificateAuthority() {
    if (additionalCertificateAuthorities.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalCertificateAuthorities"));
    }
    return this.setNewAdditionalCertificateAuthorityLike(0, this.buildAdditionalCertificateAuthority(0));
  }
  
  public GlobalPullSecretNested<A> editGlobalPullSecret() {
    return this.withNewGlobalPullSecretLike(Optional.ofNullable(this.buildGlobalPullSecret()).orElse(null));
  }
  
  public AdditionalCertificateAuthoritiesNested<A> editLastAdditionalCertificateAuthority() {
    int index = additionalCertificateAuthorities.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalCertificateAuthorities"));
    }
    return this.setNewAdditionalCertificateAuthorityLike(index, this.buildAdditionalCertificateAuthority(index));
  }
  
  public AdditionalCertificateAuthoritiesNested<A> editMatchingAdditionalCertificateAuthority(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalCertificateAuthorities.size();i++) {
      if (predicate.test(additionalCertificateAuthorities.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalCertificateAuthorities"));
    }
    return this.setNewAdditionalCertificateAuthorityLike(index, this.buildAdditionalCertificateAuthority(index));
  }
  
  public BackupNested<A> editOrNewBackup() {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(new BackupConfigBuilder().build()));
  }
  
  public BackupNested<A> editOrNewBackupLike(BackupConfig item) {
    return this.withNewBackupLike(Optional.ofNullable(this.buildBackup()).orElse(item));
  }
  
  public ExternalDNSNested<A> editOrNewExternalDNS() {
    return this.withNewExternalDNSLike(Optional.ofNullable(this.buildExternalDNS()).orElse(new ExternalDNSConfigBuilder().build()));
  }
  
  public ExternalDNSNested<A> editOrNewExternalDNSLike(ExternalDNSConfig item) {
    return this.withNewExternalDNSLike(Optional.ofNullable(this.buildExternalDNS()).orElse(item));
  }
  
  public FailedProvisionConfigNested<A> editOrNewFailedProvisionConfig() {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(new FailedProvisionConfigBuilder().build()));
  }
  
  public FailedProvisionConfigNested<A> editOrNewFailedProvisionConfigLike(FailedProvisionConfig item) {
    return this.withNewFailedProvisionConfigLike(Optional.ofNullable(this.buildFailedProvisionConfig()).orElse(item));
  }
  
  public GlobalPullSecretNested<A> editOrNewGlobalPullSecret() {
    return this.withNewGlobalPullSecretLike(Optional.ofNullable(this.buildGlobalPullSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public GlobalPullSecretNested<A> editOrNewGlobalPullSecretLike(LocalObjectReference item) {
    return this.withNewGlobalPullSecretLike(Optional.ofNullable(this.buildGlobalPullSecret()).orElse(item));
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
    HiveConfigSpecFluent that = (HiveConfigSpecFluent) o;
    if (!(Objects.equals(additionalCertificateAuthorities, that.additionalCertificateAuthorities))) {
      return false;
    }
    if (!(Objects.equals(backup, that.backup))) {
      return false;
    }
    if (!(Objects.equals(externalDNS, that.externalDNS))) {
      return false;
    }
    if (!(Objects.equals(failedProvisionConfig, that.failedProvisionConfig))) {
      return false;
    }
    if (!(Objects.equals(globalPullSecret, that.globalPullSecret))) {
      return false;
    }
    if (!(Objects.equals(maintenanceMode, that.maintenanceMode))) {
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
  
  public Boolean getMaintenanceMode() {
    return this.maintenanceMode;
  }
  
  public boolean hasAdditionalCertificateAuthorities() {
    return this.additionalCertificateAuthorities != null && !(this.additionalCertificateAuthorities.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackup() {
    return this.backup != null;
  }
  
  public boolean hasExternalDNS() {
    return this.externalDNS != null;
  }
  
  public boolean hasFailedProvisionConfig() {
    return this.failedProvisionConfig != null;
  }
  
  public boolean hasGlobalPullSecret() {
    return this.globalPullSecret != null;
  }
  
  public boolean hasMaintenanceMode() {
    return this.maintenanceMode != null;
  }
  
  public boolean hasMatchingAdditionalCertificateAuthority(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : additionalCertificateAuthorities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(additionalCertificateAuthorities, backup, externalDNS, failedProvisionConfig, globalPullSecret, maintenanceMode, additionalProperties);
  }
  
  public A removeAllFromAdditionalCertificateAuthorities(Collection<LocalObjectReference> items) {
    if (this.additionalCertificateAuthorities == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthorities").remove(builder);
        this.additionalCertificateAuthorities.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalCertificateAuthorities(LocalObjectReference... items) {
    if (this.additionalCertificateAuthorities == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("additionalCertificateAuthorities").remove(builder);
        this.additionalCertificateAuthorities.remove(builder);
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
  
  public A removeMatchingFromAdditionalCertificateAuthorities(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (additionalCertificateAuthorities == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = additionalCertificateAuthorities.iterator();
    List visitables = _visitables.get("additionalCertificateAuthorities");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalCertificateAuthoritiesNested<A> setNewAdditionalCertificateAuthorityLike(int index,LocalObjectReference item) {
    return new AdditionalCertificateAuthoritiesNested(index, item);
  }
  
  public A setToAdditionalCertificateAuthorities(int index,LocalObjectReference item) {
    if (this.additionalCertificateAuthorities == null) {
      this.additionalCertificateAuthorities = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= additionalCertificateAuthorities.size()) {
        _visitables.get("additionalCertificateAuthorities").add(builder);
        additionalCertificateAuthorities.add(builder);
    } else {
        _visitables.get("additionalCertificateAuthorities").add(builder);
        additionalCertificateAuthorities.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalCertificateAuthorities == null) && !(additionalCertificateAuthorities.isEmpty())) {
        sb.append("additionalCertificateAuthorities:");
        sb.append(additionalCertificateAuthorities);
        sb.append(",");
    }
    if (!(backup == null)) {
        sb.append("backup:");
        sb.append(backup);
        sb.append(",");
    }
    if (!(externalDNS == null)) {
        sb.append("externalDNS:");
        sb.append(externalDNS);
        sb.append(",");
    }
    if (!(failedProvisionConfig == null)) {
        sb.append("failedProvisionConfig:");
        sb.append(failedProvisionConfig);
        sb.append(",");
    }
    if (!(globalPullSecret == null)) {
        sb.append("globalPullSecret:");
        sb.append(globalPullSecret);
        sb.append(",");
    }
    if (!(maintenanceMode == null)) {
        sb.append("maintenanceMode:");
        sb.append(maintenanceMode);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalCertificateAuthorities(List<LocalObjectReference> additionalCertificateAuthorities) {
    if (this.additionalCertificateAuthorities != null) {
      this._visitables.get("additionalCertificateAuthorities").clear();
    }
    if (additionalCertificateAuthorities != null) {
        this.additionalCertificateAuthorities = new ArrayList();
        for (LocalObjectReference item : additionalCertificateAuthorities) {
          this.addToAdditionalCertificateAuthorities(item);
        }
    } else {
      this.additionalCertificateAuthorities = null;
    }
    return (A) this;
  }
  
  public A withAdditionalCertificateAuthorities(LocalObjectReference... additionalCertificateAuthorities) {
    if (this.additionalCertificateAuthorities != null) {
        this.additionalCertificateAuthorities.clear();
        _visitables.remove("additionalCertificateAuthorities");
    }
    if (additionalCertificateAuthorities != null) {
      for (LocalObjectReference item : additionalCertificateAuthorities) {
        this.addToAdditionalCertificateAuthorities(item);
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
  
  public A withBackup(BackupConfig backup) {
    this._visitables.remove("backup");
    if (backup != null) {
        this.backup = new BackupConfigBuilder(backup);
        this._visitables.get("backup").add(this.backup);
    } else {
        this.backup = null;
        this._visitables.get("backup").remove(this.backup);
    }
    return (A) this;
  }
  
  public A withExternalDNS(ExternalDNSConfig externalDNS) {
    this._visitables.remove("externalDNS");
    if (externalDNS != null) {
        this.externalDNS = new ExternalDNSConfigBuilder(externalDNS);
        this._visitables.get("externalDNS").add(this.externalDNS);
    } else {
        this.externalDNS = null;
        this._visitables.get("externalDNS").remove(this.externalDNS);
    }
    return (A) this;
  }
  
  public A withFailedProvisionConfig(FailedProvisionConfig failedProvisionConfig) {
    this._visitables.remove("failedProvisionConfig");
    if (failedProvisionConfig != null) {
        this.failedProvisionConfig = new FailedProvisionConfigBuilder(failedProvisionConfig);
        this._visitables.get("failedProvisionConfig").add(this.failedProvisionConfig);
    } else {
        this.failedProvisionConfig = null;
        this._visitables.get("failedProvisionConfig").remove(this.failedProvisionConfig);
    }
    return (A) this;
  }
  
  public A withGlobalPullSecret(LocalObjectReference globalPullSecret) {
    this._visitables.remove("globalPullSecret");
    if (globalPullSecret != null) {
        this.globalPullSecret = new LocalObjectReferenceBuilder(globalPullSecret);
        this._visitables.get("globalPullSecret").add(this.globalPullSecret);
    } else {
        this.globalPullSecret = null;
        this._visitables.get("globalPullSecret").remove(this.globalPullSecret);
    }
    return (A) this;
  }
  
  public A withMaintenanceMode() {
    return withMaintenanceMode(true);
  }
  
  public A withMaintenanceMode(Boolean maintenanceMode) {
    this.maintenanceMode = maintenanceMode;
    return (A) this;
  }
  
  public BackupNested<A> withNewBackup() {
    return new BackupNested(null);
  }
  
  public BackupNested<A> withNewBackupLike(BackupConfig item) {
    return new BackupNested(item);
  }
  
  public ExternalDNSNested<A> withNewExternalDNS() {
    return new ExternalDNSNested(null);
  }
  
  public ExternalDNSNested<A> withNewExternalDNSLike(ExternalDNSConfig item) {
    return new ExternalDNSNested(item);
  }
  
  public FailedProvisionConfigNested<A> withNewFailedProvisionConfig() {
    return new FailedProvisionConfigNested(null);
  }
  
  public A withNewFailedProvisionConfig(Boolean skipGatherLogs) {
    return (A) this.withFailedProvisionConfig(new FailedProvisionConfig(skipGatherLogs));
  }
  
  public FailedProvisionConfigNested<A> withNewFailedProvisionConfigLike(FailedProvisionConfig item) {
    return new FailedProvisionConfigNested(item);
  }
  
  public GlobalPullSecretNested<A> withNewGlobalPullSecret() {
    return new GlobalPullSecretNested(null);
  }
  
  public A withNewGlobalPullSecret(String name) {
    return (A) this.withGlobalPullSecret(new LocalObjectReference(name));
  }
  
  public GlobalPullSecretNested<A> withNewGlobalPullSecretLike(LocalObjectReference item) {
    return new GlobalPullSecretNested(item);
  }
  public class AdditionalCertificateAuthoritiesNested<N> extends LocalObjectReferenceFluent<AdditionalCertificateAuthoritiesNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    AdditionalCertificateAuthoritiesNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.setToAdditionalCertificateAuthorities(index, builder.build());
    }
    
    public N endAdditionalCertificateAuthority() {
      return and();
    }
    
  }
  public class BackupNested<N> extends BackupConfigFluent<BackupNested<N>> implements Nested<N>{
  
    BackupConfigBuilder builder;
  
    BackupNested(BackupConfig item) {
      this.builder = new BackupConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withBackup(builder.build());
    }
    
    public N endBackup() {
      return and();
    }
    
  }
  public class ExternalDNSNested<N> extends ExternalDNSConfigFluent<ExternalDNSNested<N>> implements Nested<N>{
  
    ExternalDNSConfigBuilder builder;
  
    ExternalDNSNested(ExternalDNSConfig item) {
      this.builder = new ExternalDNSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withExternalDNS(builder.build());
    }
    
    public N endExternalDNS() {
      return and();
    }
    
  }
  public class FailedProvisionConfigNested<N> extends FailedProvisionConfigFluent<FailedProvisionConfigNested<N>> implements Nested<N>{
  
    FailedProvisionConfigBuilder builder;
  
    FailedProvisionConfigNested(FailedProvisionConfig item) {
      this.builder = new FailedProvisionConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withFailedProvisionConfig(builder.build());
    }
    
    public N endFailedProvisionConfig() {
      return and();
    }
    
  }
  public class GlobalPullSecretNested<N> extends LocalObjectReferenceFluent<GlobalPullSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    GlobalPullSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HiveConfigSpecFluent.this.withGlobalPullSecret(builder.build());
    }
    
    public N endGlobalPullSecret() {
      return and();
    }
    
  }
}