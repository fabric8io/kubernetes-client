package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class ClusterPoolSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterPoolSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private String baseDomain;
  private ClusterPoolClaimLifetimeBuilder claimLifetime;
  private String hibernateAfter;
  private HibernationConfigBuilder hibernationConfig;
  private ClusterImageSetReferenceBuilder imageSetRef;
  private Integer installAttemptsLimit;
  private LocalObjectReferenceBuilder installConfigSecretTemplateRef;
  private ArrayList<EnvVarBuilder> installerEnv = new ArrayList<EnvVarBuilder>();
  private ArrayList<InventoryEntryBuilder> inventory = new ArrayList<InventoryEntryBuilder>();
  private Map<String,String> labels;
  private Integer maxConcurrent;
  private Integer maxSize;
  private PlatformBuilder platform;
  private LocalObjectReferenceBuilder pullSecretRef;
  private Integer runningCount;
  private Integer size;
  private Boolean skipMachinePools;

  public ClusterPoolSpecFluent() {
  }
  
  public ClusterPoolSpecFluent(ClusterPoolSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToInstallerEnv(Collection<EnvVar> items) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").add(builder);
        this.installerEnv.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInventory(Collection<InventoryEntry> items) {
    if (this.inventory == null) {
      this.inventory = new ArrayList();
    }
    for (InventoryEntry item : items) {
        InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
        _visitables.get("inventory").add(builder);
        this.inventory.add(builder);
    }
    return (A) this;
  }
  
  public InstallerEnvNested<A> addNewInstallerEnv() {
    return new InstallerEnvNested(-1, null);
  }
  
  public InstallerEnvNested<A> addNewInstallerEnvLike(EnvVar item) {
    return new InstallerEnvNested(-1, item);
  }
  
  public InventoryNested<A> addNewInventory() {
    return new InventoryNested(-1, null);
  }
  
  public A addNewInventory(String kind,String name) {
    return (A) this.addToInventory(new InventoryEntry(kind, name));
  }
  
  public InventoryNested<A> addNewInventoryLike(InventoryEntry item) {
    return new InventoryNested(-1, item);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToInstallerEnv(EnvVar... items) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").add(builder);
        this.installerEnv.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstallerEnv(int index,EnvVar item) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= installerEnv.size()) {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(builder);
    } else {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInventory(InventoryEntry... items) {
    if (this.inventory == null) {
      this.inventory = new ArrayList();
    }
    for (InventoryEntry item : items) {
        InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
        _visitables.get("inventory").add(builder);
        this.inventory.add(builder);
    }
    return (A) this;
  }
  
  public A addToInventory(int index,InventoryEntry item) {
    if (this.inventory == null) {
      this.inventory = new ArrayList();
    }
    InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
    if (index < 0 || index >= inventory.size()) {
        _visitables.get("inventory").add(builder);
        inventory.add(builder);
    } else {
        _visitables.get("inventory").add(builder);
        inventory.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public ClusterPoolClaimLifetime buildClaimLifetime() {
    return this.claimLifetime != null ? this.claimLifetime.build() : null;
  }
  
  public EnvVar buildFirstInstallerEnv() {
    return this.installerEnv.get(0).build();
  }
  
  public InventoryEntry buildFirstInventory() {
    return this.inventory.get(0).build();
  }
  
  public HibernationConfig buildHibernationConfig() {
    return this.hibernationConfig != null ? this.hibernationConfig.build() : null;
  }
  
  public ClusterImageSetReference buildImageSetRef() {
    return this.imageSetRef != null ? this.imageSetRef.build() : null;
  }
  
  public LocalObjectReference buildInstallConfigSecretTemplateRef() {
    return this.installConfigSecretTemplateRef != null ? this.installConfigSecretTemplateRef.build() : null;
  }
  
  public List<EnvVar> buildInstallerEnv() {
    return this.installerEnv != null ? build(installerEnv) : null;
  }
  
  public EnvVar buildInstallerEnv(int index) {
    return this.installerEnv.get(index).build();
  }
  
  public List<InventoryEntry> buildInventory() {
    return this.inventory != null ? build(inventory) : null;
  }
  
  public InventoryEntry buildInventory(int index) {
    return this.inventory.get(index).build();
  }
  
  public EnvVar buildLastInstallerEnv() {
    return this.installerEnv.get(installerEnv.size() - 1).build();
  }
  
  public InventoryEntry buildLastInventory() {
    return this.inventory.get(inventory.size() - 1).build();
  }
  
  public EnvVar buildMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : installerEnv) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InventoryEntry buildMatchingInventory(Predicate<InventoryEntryBuilder> predicate) {
      for (InventoryEntryBuilder item : inventory) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Platform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  public LocalObjectReference buildPullSecretRef() {
    return this.pullSecretRef != null ? this.pullSecretRef.build() : null;
  }
  
  protected void copyInstance(ClusterPoolSpec instance) {
    instance = instance != null ? instance : new ClusterPoolSpec();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withBaseDomain(instance.getBaseDomain());
        this.withClaimLifetime(instance.getClaimLifetime());
        this.withHibernateAfter(instance.getHibernateAfter());
        this.withHibernationConfig(instance.getHibernationConfig());
        this.withImageSetRef(instance.getImageSetRef());
        this.withInstallAttemptsLimit(instance.getInstallAttemptsLimit());
        this.withInstallConfigSecretTemplateRef(instance.getInstallConfigSecretTemplateRef());
        this.withInstallerEnv(instance.getInstallerEnv());
        this.withInventory(instance.getInventory());
        this.withLabels(instance.getLabels());
        this.withMaxConcurrent(instance.getMaxConcurrent());
        this.withMaxSize(instance.getMaxSize());
        this.withPlatform(instance.getPlatform());
        this.withPullSecretRef(instance.getPullSecretRef());
        this.withRunningCount(instance.getRunningCount());
        this.withSize(instance.getSize());
        this.withSkipMachinePools(instance.getSkipMachinePools());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimLifetimeNested<A> editClaimLifetime() {
    return this.withNewClaimLifetimeLike(Optional.ofNullable(this.buildClaimLifetime()).orElse(null));
  }
  
  public InstallerEnvNested<A> editFirstInstallerEnv() {
    if (installerEnv.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(0, this.buildInstallerEnv(0));
  }
  
  public InventoryNested<A> editFirstInventory() {
    if (inventory.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "inventory"));
    }
    return this.setNewInventoryLike(0, this.buildInventory(0));
  }
  
  public HibernationConfigNested<A> editHibernationConfig() {
    return this.withNewHibernationConfigLike(Optional.ofNullable(this.buildHibernationConfig()).orElse(null));
  }
  
  public ImageSetRefNested<A> editImageSetRef() {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(null));
  }
  
  public InstallConfigSecretTemplateRefNested<A> editInstallConfigSecretTemplateRef() {
    return this.withNewInstallConfigSecretTemplateRefLike(Optional.ofNullable(this.buildInstallConfigSecretTemplateRef()).orElse(null));
  }
  
  public InstallerEnvNested<A> editInstallerEnv(int index) {
    if (installerEnv.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public InventoryNested<A> editInventory(int index) {
    if (inventory.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "inventory"));
    }
    return this.setNewInventoryLike(index, this.buildInventory(index));
  }
  
  public InstallerEnvNested<A> editLastInstallerEnv() {
    int index = installerEnv.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public InventoryNested<A> editLastInventory() {
    int index = inventory.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "inventory"));
    }
    return this.setNewInventoryLike(index, this.buildInventory(index));
  }
  
  public InstallerEnvNested<A> editMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < installerEnv.size();i++) {
      if (predicate.test(installerEnv.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public InventoryNested<A> editMatchingInventory(Predicate<InventoryEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < inventory.size();i++) {
      if (predicate.test(inventory.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "inventory"));
    }
    return this.setNewInventoryLike(index, this.buildInventory(index));
  }
  
  public ClaimLifetimeNested<A> editOrNewClaimLifetime() {
    return this.withNewClaimLifetimeLike(Optional.ofNullable(this.buildClaimLifetime()).orElse(new ClusterPoolClaimLifetimeBuilder().build()));
  }
  
  public ClaimLifetimeNested<A> editOrNewClaimLifetimeLike(ClusterPoolClaimLifetime item) {
    return this.withNewClaimLifetimeLike(Optional.ofNullable(this.buildClaimLifetime()).orElse(item));
  }
  
  public HibernationConfigNested<A> editOrNewHibernationConfig() {
    return this.withNewHibernationConfigLike(Optional.ofNullable(this.buildHibernationConfig()).orElse(new HibernationConfigBuilder().build()));
  }
  
  public HibernationConfigNested<A> editOrNewHibernationConfigLike(HibernationConfig item) {
    return this.withNewHibernationConfigLike(Optional.ofNullable(this.buildHibernationConfig()).orElse(item));
  }
  
  public ImageSetRefNested<A> editOrNewImageSetRef() {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(new ClusterImageSetReferenceBuilder().build()));
  }
  
  public ImageSetRefNested<A> editOrNewImageSetRefLike(ClusterImageSetReference item) {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(item));
  }
  
  public InstallConfigSecretTemplateRefNested<A> editOrNewInstallConfigSecretTemplateRef() {
    return this.withNewInstallConfigSecretTemplateRefLike(Optional.ofNullable(this.buildInstallConfigSecretTemplateRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public InstallConfigSecretTemplateRefNested<A> editOrNewInstallConfigSecretTemplateRefLike(LocalObjectReference item) {
    return this.withNewInstallConfigSecretTemplateRefLike(Optional.ofNullable(this.buildInstallConfigSecretTemplateRef()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new PlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(Platform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PullSecretRefNested<A> editOrNewPullSecretRef() {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PullSecretRefNested<A> editOrNewPullSecretRefLike(LocalObjectReference item) {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
  }
  
  public PullSecretRefNested<A> editPullSecretRef() {
    return this.withNewPullSecretRefLike(Optional.ofNullable(this.buildPullSecretRef()).orElse(null));
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
    ClusterPoolSpecFluent that = (ClusterPoolSpecFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(claimLifetime, that.claimLifetime))) {
      return false;
    }
    if (!(Objects.equals(hibernateAfter, that.hibernateAfter))) {
      return false;
    }
    if (!(Objects.equals(hibernationConfig, that.hibernationConfig))) {
      return false;
    }
    if (!(Objects.equals(imageSetRef, that.imageSetRef))) {
      return false;
    }
    if (!(Objects.equals(installAttemptsLimit, that.installAttemptsLimit))) {
      return false;
    }
    if (!(Objects.equals(installConfigSecretTemplateRef, that.installConfigSecretTemplateRef))) {
      return false;
    }
    if (!(Objects.equals(installerEnv, that.installerEnv))) {
      return false;
    }
    if (!(Objects.equals(inventory, that.inventory))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(maxConcurrent, that.maxConcurrent))) {
      return false;
    }
    if (!(Objects.equals(maxSize, that.maxSize))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(pullSecretRef, that.pullSecretRef))) {
      return false;
    }
    if (!(Objects.equals(runningCount, that.runningCount))) {
      return false;
    }
    if (!(Objects.equals(size, that.size))) {
      return false;
    }
    if (!(Objects.equals(skipMachinePools, that.skipMachinePools))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public String getHibernateAfter() {
    return this.hibernateAfter;
  }
  
  public Integer getInstallAttemptsLimit() {
    return this.installAttemptsLimit;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public Integer getMaxConcurrent() {
    return this.maxConcurrent;
  }
  
  public Integer getMaxSize() {
    return this.maxSize;
  }
  
  public Integer getRunningCount() {
    return this.runningCount;
  }
  
  public Integer getSize() {
    return this.size;
  }
  
  public Boolean getSkipMachinePools() {
    return this.skipMachinePools;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasClaimLifetime() {
    return this.claimLifetime != null;
  }
  
  public boolean hasHibernateAfter() {
    return this.hibernateAfter != null;
  }
  
  public boolean hasHibernationConfig() {
    return this.hibernationConfig != null;
  }
  
  public boolean hasImageSetRef() {
    return this.imageSetRef != null;
  }
  
  public boolean hasInstallAttemptsLimit() {
    return this.installAttemptsLimit != null;
  }
  
  public boolean hasInstallConfigSecretTemplateRef() {
    return this.installConfigSecretTemplateRef != null;
  }
  
  public boolean hasInstallerEnv() {
    return this.installerEnv != null && !(this.installerEnv.isEmpty());
  }
  
  public boolean hasInventory() {
    return this.inventory != null && !(this.inventory.isEmpty());
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : installerEnv) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInventory(Predicate<InventoryEntryBuilder> predicate) {
      for (InventoryEntryBuilder item : inventory) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxConcurrent() {
    return this.maxConcurrent != null;
  }
  
  public boolean hasMaxSize() {
    return this.maxSize != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasPullSecretRef() {
    return this.pullSecretRef != null;
  }
  
  public boolean hasRunningCount() {
    return this.runningCount != null;
  }
  
  public boolean hasSize() {
    return this.size != null;
  }
  
  public boolean hasSkipMachinePools() {
    return this.skipMachinePools != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, baseDomain, claimLifetime, hibernateAfter, hibernationConfig, imageSetRef, installAttemptsLimit, installConfigSecretTemplateRef, installerEnv, inventory, labels, maxConcurrent, maxSize, platform, pullSecretRef, runningCount, size, skipMachinePools, additionalProperties);
  }
  
  public A removeAllFromInstallerEnv(Collection<EnvVar> items) {
    if (this.installerEnv == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").remove(builder);
        this.installerEnv.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInventory(Collection<InventoryEntry> items) {
    if (this.inventory == null) {
      return (A) this;
    }
    for (InventoryEntry item : items) {
        InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
        _visitables.get("inventory").remove(builder);
        this.inventory.remove(builder);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromInstallerEnv(EnvVar... items) {
    if (this.installerEnv == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").remove(builder);
        this.installerEnv.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInventory(InventoryEntry... items) {
    if (this.inventory == null) {
      return (A) this;
    }
    for (InventoryEntry item : items) {
        InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
        _visitables.get("inventory").remove(builder);
        this.inventory.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstallerEnv(Predicate<EnvVarBuilder> predicate) {
    if (installerEnv == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = installerEnv.iterator();
    List visitables = _visitables.get("installerEnv");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInventory(Predicate<InventoryEntryBuilder> predicate) {
    if (inventory == null) {
      return (A) this;
    }
    Iterator<InventoryEntryBuilder> each = inventory.iterator();
    List visitables = _visitables.get("inventory");
    while (each.hasNext()) {
        InventoryEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InstallerEnvNested<A> setNewInstallerEnvLike(int index,EnvVar item) {
    return new InstallerEnvNested(index, item);
  }
  
  public InventoryNested<A> setNewInventoryLike(int index,InventoryEntry item) {
    return new InventoryNested(index, item);
  }
  
  public A setToInstallerEnv(int index,EnvVar item) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= installerEnv.size()) {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(builder);
    } else {
        _visitables.get("installerEnv").add(builder);
        installerEnv.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInventory(int index,InventoryEntry item) {
    if (this.inventory == null) {
      this.inventory = new ArrayList();
    }
    InventoryEntryBuilder builder = new InventoryEntryBuilder(item);
    if (index < 0 || index >= inventory.size()) {
        _visitables.get("inventory").add(builder);
        inventory.add(builder);
    } else {
        _visitables.get("inventory").add(builder);
        inventory.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(claimLifetime == null)) {
        sb.append("claimLifetime:");
        sb.append(claimLifetime);
        sb.append(",");
    }
    if (!(hibernateAfter == null)) {
        sb.append("hibernateAfter:");
        sb.append(hibernateAfter);
        sb.append(",");
    }
    if (!(hibernationConfig == null)) {
        sb.append("hibernationConfig:");
        sb.append(hibernationConfig);
        sb.append(",");
    }
    if (!(imageSetRef == null)) {
        sb.append("imageSetRef:");
        sb.append(imageSetRef);
        sb.append(",");
    }
    if (!(installAttemptsLimit == null)) {
        sb.append("installAttemptsLimit:");
        sb.append(installAttemptsLimit);
        sb.append(",");
    }
    if (!(installConfigSecretTemplateRef == null)) {
        sb.append("installConfigSecretTemplateRef:");
        sb.append(installConfigSecretTemplateRef);
        sb.append(",");
    }
    if (!(installerEnv == null) && !(installerEnv.isEmpty())) {
        sb.append("installerEnv:");
        sb.append(installerEnv);
        sb.append(",");
    }
    if (!(inventory == null) && !(inventory.isEmpty())) {
        sb.append("inventory:");
        sb.append(inventory);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(maxConcurrent == null)) {
        sb.append("maxConcurrent:");
        sb.append(maxConcurrent);
        sb.append(",");
    }
    if (!(maxSize == null)) {
        sb.append("maxSize:");
        sb.append(maxSize);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(pullSecretRef == null)) {
        sb.append("pullSecretRef:");
        sb.append(pullSecretRef);
        sb.append(",");
    }
    if (!(runningCount == null)) {
        sb.append("runningCount:");
        sb.append(runningCount);
        sb.append(",");
    }
    if (!(size == null)) {
        sb.append("size:");
        sb.append(size);
        sb.append(",");
    }
    if (!(skipMachinePools == null)) {
        sb.append("skipMachinePools:");
        sb.append(skipMachinePools);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withClaimLifetime(ClusterPoolClaimLifetime claimLifetime) {
    this._visitables.remove("claimLifetime");
    if (claimLifetime != null) {
        this.claimLifetime = new ClusterPoolClaimLifetimeBuilder(claimLifetime);
        this._visitables.get("claimLifetime").add(this.claimLifetime);
    } else {
        this.claimLifetime = null;
        this._visitables.get("claimLifetime").remove(this.claimLifetime);
    }
    return (A) this;
  }
  
  public A withHibernateAfter(String hibernateAfter) {
    this.hibernateAfter = hibernateAfter;
    return (A) this;
  }
  
  public A withHibernationConfig(HibernationConfig hibernationConfig) {
    this._visitables.remove("hibernationConfig");
    if (hibernationConfig != null) {
        this.hibernationConfig = new HibernationConfigBuilder(hibernationConfig);
        this._visitables.get("hibernationConfig").add(this.hibernationConfig);
    } else {
        this.hibernationConfig = null;
        this._visitables.get("hibernationConfig").remove(this.hibernationConfig);
    }
    return (A) this;
  }
  
  public A withImageSetRef(ClusterImageSetReference imageSetRef) {
    this._visitables.remove("imageSetRef");
    if (imageSetRef != null) {
        this.imageSetRef = new ClusterImageSetReferenceBuilder(imageSetRef);
        this._visitables.get("imageSetRef").add(this.imageSetRef);
    } else {
        this.imageSetRef = null;
        this._visitables.get("imageSetRef").remove(this.imageSetRef);
    }
    return (A) this;
  }
  
  public A withInstallAttemptsLimit(Integer installAttemptsLimit) {
    this.installAttemptsLimit = installAttemptsLimit;
    return (A) this;
  }
  
  public A withInstallConfigSecretTemplateRef(LocalObjectReference installConfigSecretTemplateRef) {
    this._visitables.remove("installConfigSecretTemplateRef");
    if (installConfigSecretTemplateRef != null) {
        this.installConfigSecretTemplateRef = new LocalObjectReferenceBuilder(installConfigSecretTemplateRef);
        this._visitables.get("installConfigSecretTemplateRef").add(this.installConfigSecretTemplateRef);
    } else {
        this.installConfigSecretTemplateRef = null;
        this._visitables.get("installConfigSecretTemplateRef").remove(this.installConfigSecretTemplateRef);
    }
    return (A) this;
  }
  
  public A withInstallerEnv(List<EnvVar> installerEnv) {
    if (this.installerEnv != null) {
      this._visitables.get("installerEnv").clear();
    }
    if (installerEnv != null) {
        this.installerEnv = new ArrayList();
        for (EnvVar item : installerEnv) {
          this.addToInstallerEnv(item);
        }
    } else {
      this.installerEnv = null;
    }
    return (A) this;
  }
  
  public A withInstallerEnv(EnvVar... installerEnv) {
    if (this.installerEnv != null) {
        this.installerEnv.clear();
        _visitables.remove("installerEnv");
    }
    if (installerEnv != null) {
      for (EnvVar item : installerEnv) {
        this.addToInstallerEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withInventory(List<InventoryEntry> inventory) {
    if (this.inventory != null) {
      this._visitables.get("inventory").clear();
    }
    if (inventory != null) {
        this.inventory = new ArrayList();
        for (InventoryEntry item : inventory) {
          this.addToInventory(item);
        }
    } else {
      this.inventory = null;
    }
    return (A) this;
  }
  
  public A withInventory(InventoryEntry... inventory) {
    if (this.inventory != null) {
        this.inventory.clear();
        _visitables.remove("inventory");
    }
    if (inventory != null) {
      for (InventoryEntry item : inventory) {
        this.addToInventory(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withMaxConcurrent(Integer maxConcurrent) {
    this.maxConcurrent = maxConcurrent;
    return (A) this;
  }
  
  public A withMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
    return (A) this;
  }
  
  public ClaimLifetimeNested<A> withNewClaimLifetime() {
    return new ClaimLifetimeNested(null);
  }
  
  public A withNewClaimLifetime(String _default,String maximum) {
    return (A) this.withClaimLifetime(new ClusterPoolClaimLifetime(_default, maximum));
  }
  
  public ClaimLifetimeNested<A> withNewClaimLifetimeLike(ClusterPoolClaimLifetime item) {
    return new ClaimLifetimeNested(item);
  }
  
  public HibernationConfigNested<A> withNewHibernationConfig() {
    return new HibernationConfigNested(null);
  }
  
  public A withNewHibernationConfig(String resumeTimeout) {
    return (A) this.withHibernationConfig(new HibernationConfig(resumeTimeout));
  }
  
  public HibernationConfigNested<A> withNewHibernationConfigLike(HibernationConfig item) {
    return new HibernationConfigNested(item);
  }
  
  public ImageSetRefNested<A> withNewImageSetRef() {
    return new ImageSetRefNested(null);
  }
  
  public A withNewImageSetRef(String name) {
    return (A) this.withImageSetRef(new ClusterImageSetReference(name));
  }
  
  public ImageSetRefNested<A> withNewImageSetRefLike(ClusterImageSetReference item) {
    return new ImageSetRefNested(item);
  }
  
  public InstallConfigSecretTemplateRefNested<A> withNewInstallConfigSecretTemplateRef() {
    return new InstallConfigSecretTemplateRefNested(null);
  }
  
  public A withNewInstallConfigSecretTemplateRef(String name) {
    return (A) this.withInstallConfigSecretTemplateRef(new LocalObjectReference(name));
  }
  
  public InstallConfigSecretTemplateRefNested<A> withNewInstallConfigSecretTemplateRefLike(LocalObjectReference item) {
    return new InstallConfigSecretTemplateRefNested(item);
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(Platform item) {
    return new PlatformNested(item);
  }
  
  public PullSecretRefNested<A> withNewPullSecretRef() {
    return new PullSecretRefNested(null);
  }
  
  public A withNewPullSecretRef(String name) {
    return (A) this.withPullSecretRef(new LocalObjectReference(name));
  }
  
  public PullSecretRefNested<A> withNewPullSecretRefLike(LocalObjectReference item) {
    return new PullSecretRefNested(item);
  }
  
  public A withPlatform(Platform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new PlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  
  public A withPullSecretRef(LocalObjectReference pullSecretRef) {
    this._visitables.remove("pullSecretRef");
    if (pullSecretRef != null) {
        this.pullSecretRef = new LocalObjectReferenceBuilder(pullSecretRef);
        this._visitables.get("pullSecretRef").add(this.pullSecretRef);
    } else {
        this.pullSecretRef = null;
        this._visitables.get("pullSecretRef").remove(this.pullSecretRef);
    }
    return (A) this;
  }
  
  public A withRunningCount(Integer runningCount) {
    this.runningCount = runningCount;
    return (A) this;
  }
  
  public A withSize(Integer size) {
    this.size = size;
    return (A) this;
  }
  
  public A withSkipMachinePools() {
    return withSkipMachinePools(true);
  }
  
  public A withSkipMachinePools(Boolean skipMachinePools) {
    this.skipMachinePools = skipMachinePools;
    return (A) this;
  }
  public class ClaimLifetimeNested<N> extends ClusterPoolClaimLifetimeFluent<ClaimLifetimeNested<N>> implements Nested<N>{
  
    ClusterPoolClaimLifetimeBuilder builder;
  
    ClaimLifetimeNested(ClusterPoolClaimLifetime item) {
      this.builder = new ClusterPoolClaimLifetimeBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withClaimLifetime(builder.build());
    }
    
    public N endClaimLifetime() {
      return and();
    }
    
  }
  public class HibernationConfigNested<N> extends HibernationConfigFluent<HibernationConfigNested<N>> implements Nested<N>{
  
    HibernationConfigBuilder builder;
  
    HibernationConfigNested(HibernationConfig item) {
      this.builder = new HibernationConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withHibernationConfig(builder.build());
    }
    
    public N endHibernationConfig() {
      return and();
    }
    
  }
  public class ImageSetRefNested<N> extends ClusterImageSetReferenceFluent<ImageSetRefNested<N>> implements Nested<N>{
  
    ClusterImageSetReferenceBuilder builder;
  
    ImageSetRefNested(ClusterImageSetReference item) {
      this.builder = new ClusterImageSetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withImageSetRef(builder.build());
    }
    
    public N endImageSetRef() {
      return and();
    }
    
  }
  public class InstallConfigSecretTemplateRefNested<N> extends LocalObjectReferenceFluent<InstallConfigSecretTemplateRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    InstallConfigSecretTemplateRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withInstallConfigSecretTemplateRef(builder.build());
    }
    
    public N endInstallConfigSecretTemplateRef() {
      return and();
    }
    
  }
  public class InstallerEnvNested<N> extends EnvVarFluent<InstallerEnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    InstallerEnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.setToInstallerEnv(index, builder.build());
    }
    
    public N endInstallerEnv() {
      return and();
    }
    
  }
  public class InventoryNested<N> extends InventoryEntryFluent<InventoryNested<N>> implements Nested<N>{
  
    InventoryEntryBuilder builder;
    int index;
  
    InventoryNested(int index,InventoryEntry item) {
      this.index = index;
      this.builder = new InventoryEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.setToInventory(index, builder.build());
    }
    
    public N endInventory() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends PlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    PlatformBuilder builder;
  
    PlatformNested(Platform item) {
      this.builder = new PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
  public class PullSecretRefNested<N> extends LocalObjectReferenceFluent<PullSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PullSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterPoolSpecFluent.this.withPullSecretRef(builder.build());
    }
    
    public N endPullSecretRef() {
      return and();
    }
    
  }
}