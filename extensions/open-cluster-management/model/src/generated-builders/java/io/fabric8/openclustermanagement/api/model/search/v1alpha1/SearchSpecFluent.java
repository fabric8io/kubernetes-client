package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Toleration;
import java.lang.Long;
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
public class SearchSpecFluent<A extends io.fabric8.openclustermanagement.api.model.search.v1alpha1.SearchSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String availabilityConfig;
  private String dbConfig;
  private StorageSpecBuilder dbStorage;
  private SearchDeploymentsBuilder deployments;
  private String externalDBInstance;
  private String imagePullPolicy;
  private String imagePullSecret;
  private Map<String,String> nodeSelector;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public SearchSpecFluent() {
  }
  
  public SearchSpecFluent(SearchSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public StorageSpec buildDbStorage() {
    return this.dbStorage != null ? this.dbStorage.build() : null;
  }
  
  public SearchDeployments buildDeployments() {
    return this.deployments != null ? this.deployments.build() : null;
  }
  
  protected void copyInstance(SearchSpec instance) {
    instance = instance != null ? instance : new SearchSpec();
    if (instance != null) {
        this.withAvailabilityConfig(instance.getAvailabilityConfig());
        this.withDbConfig(instance.getDbConfig());
        this.withDbStorage(instance.getDbStorage());
        this.withDeployments(instance.getDeployments());
        this.withExternalDBInstance(instance.getExternalDBInstance());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withNodeSelector(instance.getNodeSelector());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DbStorageNested<A> editDbStorage() {
    return this.withNewDbStorageLike(Optional.ofNullable(this.buildDbStorage()).orElse(null));
  }
  
  public DeploymentsNested<A> editDeployments() {
    return this.withNewDeploymentsLike(Optional.ofNullable(this.buildDeployments()).orElse(null));
  }
  
  public DbStorageNested<A> editOrNewDbStorage() {
    return this.withNewDbStorageLike(Optional.ofNullable(this.buildDbStorage()).orElse(new StorageSpecBuilder().build()));
  }
  
  public DbStorageNested<A> editOrNewDbStorageLike(StorageSpec item) {
    return this.withNewDbStorageLike(Optional.ofNullable(this.buildDbStorage()).orElse(item));
  }
  
  public DeploymentsNested<A> editOrNewDeployments() {
    return this.withNewDeploymentsLike(Optional.ofNullable(this.buildDeployments()).orElse(new SearchDeploymentsBuilder().build()));
  }
  
  public DeploymentsNested<A> editOrNewDeploymentsLike(SearchDeployments item) {
    return this.withNewDeploymentsLike(Optional.ofNullable(this.buildDeployments()).orElse(item));
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
    SearchSpecFluent that = (SearchSpecFluent) o;
    if (!(Objects.equals(availabilityConfig, that.availabilityConfig))) {
      return false;
    }
    if (!(Objects.equals(dbConfig, that.dbConfig))) {
      return false;
    }
    if (!(Objects.equals(dbStorage, that.dbStorage))) {
      return false;
    }
    if (!(Objects.equals(deployments, that.deployments))) {
      return false;
    }
    if (!(Objects.equals(externalDBInstance, that.externalDBInstance))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public String getAvailabilityConfig() {
    return this.availabilityConfig;
  }
  
  public String getDbConfig() {
    return this.dbConfig;
  }
  
  public String getExternalDBInstance() {
    return this.externalDBInstance;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailabilityConfig() {
    return this.availabilityConfig != null;
  }
  
  public boolean hasDbConfig() {
    return this.dbConfig != null;
  }
  
  public boolean hasDbStorage() {
    return this.dbStorage != null;
  }
  
  public boolean hasDeployments() {
    return this.deployments != null;
  }
  
  public boolean hasExternalDBInstance() {
    return this.externalDBInstance != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(availabilityConfig, dbConfig, dbStorage, deployments, externalDBInstance, imagePullPolicy, imagePullSecret, nodeSelector, tolerations, additionalProperties);
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availabilityConfig == null)) {
        sb.append("availabilityConfig:");
        sb.append(availabilityConfig);
        sb.append(",");
    }
    if (!(dbConfig == null)) {
        sb.append("dbConfig:");
        sb.append(dbConfig);
        sb.append(",");
    }
    if (!(dbStorage == null)) {
        sb.append("dbStorage:");
        sb.append(dbStorage);
        sb.append(",");
    }
    if (!(deployments == null)) {
        sb.append("deployments:");
        sb.append(deployments);
        sb.append(",");
    }
    if (!(externalDBInstance == null)) {
        sb.append("externalDBInstance:");
        sb.append(externalDBInstance);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAvailabilityConfig(String availabilityConfig) {
    this.availabilityConfig = availabilityConfig;
    return (A) this;
  }
  
  public A withDbConfig(String dbConfig) {
    this.dbConfig = dbConfig;
    return (A) this;
  }
  
  public A withDbStorage(StorageSpec dbStorage) {
    this._visitables.remove("dbStorage");
    if (dbStorage != null) {
        this.dbStorage = new StorageSpecBuilder(dbStorage);
        this._visitables.get("dbStorage").add(this.dbStorage);
    } else {
        this.dbStorage = null;
        this._visitables.get("dbStorage").remove(this.dbStorage);
    }
    return (A) this;
  }
  
  public A withDeployments(SearchDeployments deployments) {
    this._visitables.remove("deployments");
    if (deployments != null) {
        this.deployments = new SearchDeploymentsBuilder(deployments);
        this._visitables.get("deployments").add(this.deployments);
    } else {
        this.deployments = null;
        this._visitables.get("deployments").remove(this.deployments);
    }
    return (A) this;
  }
  
  public A withExternalDBInstance(String externalDBInstance) {
    this.externalDBInstance = externalDBInstance;
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public DbStorageNested<A> withNewDbStorage() {
    return new DbStorageNested(null);
  }
  
  public DbStorageNested<A> withNewDbStorageLike(StorageSpec item) {
    return new DbStorageNested(item);
  }
  
  public DeploymentsNested<A> withNewDeployments() {
    return new DeploymentsNested(null);
  }
  
  public DeploymentsNested<A> withNewDeploymentsLike(SearchDeployments item) {
    return new DeploymentsNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class DbStorageNested<N> extends StorageSpecFluent<DbStorageNested<N>> implements Nested<N>{
  
    StorageSpecBuilder builder;
  
    DbStorageNested(StorageSpec item) {
      this.builder = new StorageSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchSpecFluent.this.withDbStorage(builder.build());
    }
    
    public N endDbStorage() {
      return and();
    }
    
  }
  public class DeploymentsNested<N> extends SearchDeploymentsFluent<DeploymentsNested<N>> implements Nested<N>{
  
    SearchDeploymentsBuilder builder;
  
    DeploymentsNested(SearchDeployments item) {
      this.builder = new SearchDeploymentsBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchSpecFluent.this.withDeployments(builder.build());
    }
    
    public N endDeployments() {
      return and();
    }
    
  }
}