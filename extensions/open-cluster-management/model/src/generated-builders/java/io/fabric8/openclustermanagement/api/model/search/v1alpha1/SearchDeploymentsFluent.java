package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

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
public class SearchDeploymentsFluent<A extends io.fabric8.openclustermanagement.api.model.search.v1alpha1.SearchDeploymentsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DeploymentConfigBuilder collector;
  private DeploymentConfigBuilder database;
  private DeploymentConfigBuilder indexer;
  private DeploymentConfigBuilder queryapi;

  public SearchDeploymentsFluent() {
  }
  
  public SearchDeploymentsFluent(SearchDeployments instance) {
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
  
  public DeploymentConfig buildCollector() {
    return this.collector != null ? this.collector.build() : null;
  }
  
  public DeploymentConfig buildDatabase() {
    return this.database != null ? this.database.build() : null;
  }
  
  public DeploymentConfig buildIndexer() {
    return this.indexer != null ? this.indexer.build() : null;
  }
  
  public DeploymentConfig buildQueryapi() {
    return this.queryapi != null ? this.queryapi.build() : null;
  }
  
  protected void copyInstance(SearchDeployments instance) {
    instance = instance != null ? instance : new SearchDeployments();
    if (instance != null) {
        this.withCollector(instance.getCollector());
        this.withDatabase(instance.getDatabase());
        this.withIndexer(instance.getIndexer());
        this.withQueryapi(instance.getQueryapi());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CollectorNested<A> editCollector() {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(null));
  }
  
  public DatabaseNested<A> editDatabase() {
    return this.withNewDatabaseLike(Optional.ofNullable(this.buildDatabase()).orElse(null));
  }
  
  public IndexerNested<A> editIndexer() {
    return this.withNewIndexerLike(Optional.ofNullable(this.buildIndexer()).orElse(null));
  }
  
  public CollectorNested<A> editOrNewCollector() {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(new DeploymentConfigBuilder().build()));
  }
  
  public CollectorNested<A> editOrNewCollectorLike(DeploymentConfig item) {
    return this.withNewCollectorLike(Optional.ofNullable(this.buildCollector()).orElse(item));
  }
  
  public DatabaseNested<A> editOrNewDatabase() {
    return this.withNewDatabaseLike(Optional.ofNullable(this.buildDatabase()).orElse(new DeploymentConfigBuilder().build()));
  }
  
  public DatabaseNested<A> editOrNewDatabaseLike(DeploymentConfig item) {
    return this.withNewDatabaseLike(Optional.ofNullable(this.buildDatabase()).orElse(item));
  }
  
  public IndexerNested<A> editOrNewIndexer() {
    return this.withNewIndexerLike(Optional.ofNullable(this.buildIndexer()).orElse(new DeploymentConfigBuilder().build()));
  }
  
  public IndexerNested<A> editOrNewIndexerLike(DeploymentConfig item) {
    return this.withNewIndexerLike(Optional.ofNullable(this.buildIndexer()).orElse(item));
  }
  
  public QueryapiNested<A> editOrNewQueryapi() {
    return this.withNewQueryapiLike(Optional.ofNullable(this.buildQueryapi()).orElse(new DeploymentConfigBuilder().build()));
  }
  
  public QueryapiNested<A> editOrNewQueryapiLike(DeploymentConfig item) {
    return this.withNewQueryapiLike(Optional.ofNullable(this.buildQueryapi()).orElse(item));
  }
  
  public QueryapiNested<A> editQueryapi() {
    return this.withNewQueryapiLike(Optional.ofNullable(this.buildQueryapi()).orElse(null));
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
    SearchDeploymentsFluent that = (SearchDeploymentsFluent) o;
    if (!(Objects.equals(collector, that.collector))) {
      return false;
    }
    if (!(Objects.equals(database, that.database))) {
      return false;
    }
    if (!(Objects.equals(indexer, that.indexer))) {
      return false;
    }
    if (!(Objects.equals(queryapi, that.queryapi))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCollector() {
    return this.collector != null;
  }
  
  public boolean hasDatabase() {
    return this.database != null;
  }
  
  public boolean hasIndexer() {
    return this.indexer != null;
  }
  
  public boolean hasQueryapi() {
    return this.queryapi != null;
  }
  
  public int hashCode() {
    return Objects.hash(collector, database, indexer, queryapi, additionalProperties);
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
    if (!(collector == null)) {
        sb.append("collector:");
        sb.append(collector);
        sb.append(",");
    }
    if (!(database == null)) {
        sb.append("database:");
        sb.append(database);
        sb.append(",");
    }
    if (!(indexer == null)) {
        sb.append("indexer:");
        sb.append(indexer);
        sb.append(",");
    }
    if (!(queryapi == null)) {
        sb.append("queryapi:");
        sb.append(queryapi);
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
  
  public A withCollector(DeploymentConfig collector) {
    this._visitables.remove("collector");
    if (collector != null) {
        this.collector = new DeploymentConfigBuilder(collector);
        this._visitables.get("collector").add(this.collector);
    } else {
        this.collector = null;
        this._visitables.get("collector").remove(this.collector);
    }
    return (A) this;
  }
  
  public A withDatabase(DeploymentConfig database) {
    this._visitables.remove("database");
    if (database != null) {
        this.database = new DeploymentConfigBuilder(database);
        this._visitables.get("database").add(this.database);
    } else {
        this.database = null;
        this._visitables.get("database").remove(this.database);
    }
    return (A) this;
  }
  
  public A withIndexer(DeploymentConfig indexer) {
    this._visitables.remove("indexer");
    if (indexer != null) {
        this.indexer = new DeploymentConfigBuilder(indexer);
        this._visitables.get("indexer").add(this.indexer);
    } else {
        this.indexer = null;
        this._visitables.get("indexer").remove(this.indexer);
    }
    return (A) this;
  }
  
  public CollectorNested<A> withNewCollector() {
    return new CollectorNested(null);
  }
  
  public CollectorNested<A> withNewCollectorLike(DeploymentConfig item) {
    return new CollectorNested(item);
  }
  
  public DatabaseNested<A> withNewDatabase() {
    return new DatabaseNested(null);
  }
  
  public DatabaseNested<A> withNewDatabaseLike(DeploymentConfig item) {
    return new DatabaseNested(item);
  }
  
  public IndexerNested<A> withNewIndexer() {
    return new IndexerNested(null);
  }
  
  public IndexerNested<A> withNewIndexerLike(DeploymentConfig item) {
    return new IndexerNested(item);
  }
  
  public QueryapiNested<A> withNewQueryapi() {
    return new QueryapiNested(null);
  }
  
  public QueryapiNested<A> withNewQueryapiLike(DeploymentConfig item) {
    return new QueryapiNested(item);
  }
  
  public A withQueryapi(DeploymentConfig queryapi) {
    this._visitables.remove("queryapi");
    if (queryapi != null) {
        this.queryapi = new DeploymentConfigBuilder(queryapi);
        this._visitables.get("queryapi").add(this.queryapi);
    } else {
        this.queryapi = null;
        this._visitables.get("queryapi").remove(this.queryapi);
    }
    return (A) this;
  }
  public class CollectorNested<N> extends DeploymentConfigFluent<CollectorNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
  
    CollectorNested(DeploymentConfig item) {
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchDeploymentsFluent.this.withCollector(builder.build());
    }
    
    public N endCollector() {
      return and();
    }
    
  }
  public class DatabaseNested<N> extends DeploymentConfigFluent<DatabaseNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
  
    DatabaseNested(DeploymentConfig item) {
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchDeploymentsFluent.this.withDatabase(builder.build());
    }
    
    public N endDatabase() {
      return and();
    }
    
  }
  public class IndexerNested<N> extends DeploymentConfigFluent<IndexerNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
  
    IndexerNested(DeploymentConfig item) {
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchDeploymentsFluent.this.withIndexer(builder.build());
    }
    
    public N endIndexer() {
      return and();
    }
    
  }
  public class QueryapiNested<N> extends DeploymentConfigFluent<QueryapiNested<N>> implements Nested<N>{
  
    DeploymentConfigBuilder builder;
  
    QueryapiNested(DeploymentConfig item) {
      this.builder = new DeploymentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SearchDeploymentsFluent.this.withQueryapi(builder.build());
    }
    
    public N endQueryapi() {
      return and();
    }
    
  }
}