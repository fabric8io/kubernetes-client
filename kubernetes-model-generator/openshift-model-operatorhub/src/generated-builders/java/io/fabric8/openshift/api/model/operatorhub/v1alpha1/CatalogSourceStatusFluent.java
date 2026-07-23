package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class CatalogSourceStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private ConfigMapResourceReferenceBuilder configMapReference;
  private GRPCConnectionStateBuilder connectionState;
  private String latestImageRegistryPoll;
  private String message;
  private String reason;
  private RegistryServiceStatusBuilder registryService;

  public CatalogSourceStatusFluent() {
  }
  
  public CatalogSourceStatusFluent(CatalogSourceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public ConfigMapResourceReference buildConfigMapReference() {
    return this.configMapReference != null ? this.configMapReference.build() : null;
  }
  
  public GRPCConnectionState buildConnectionState() {
    return this.connectionState != null ? this.connectionState.build() : null;
  }
  
  public RegistryServiceStatus buildRegistryService() {
    return this.registryService != null ? this.registryService.build() : null;
  }
  
  protected void copyInstance(CatalogSourceStatus instance) {
    instance = instance != null ? instance : new CatalogSourceStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withConfigMapReference(instance.getConfigMapReference());
        this.withConnectionState(instance.getConnectionState());
        this.withLatestImageRegistryPoll(instance.getLatestImageRegistryPoll());
        this.withMessage(instance.getMessage());
        this.withReason(instance.getReason());
        this.withRegistryService(instance.getRegistryService());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapReferenceNested<A> editConfigMapReference() {
    return this.withNewConfigMapReferenceLike(Optional.ofNullable(this.buildConfigMapReference()).orElse(null));
  }
  
  public ConnectionStateNested<A> editConnectionState() {
    return this.withNewConnectionStateLike(Optional.ofNullable(this.buildConnectionState()).orElse(null));
  }
  
  public ConfigMapReferenceNested<A> editOrNewConfigMapReference() {
    return this.withNewConfigMapReferenceLike(Optional.ofNullable(this.buildConfigMapReference()).orElse(new ConfigMapResourceReferenceBuilder().build()));
  }
  
  public ConfigMapReferenceNested<A> editOrNewConfigMapReferenceLike(ConfigMapResourceReference item) {
    return this.withNewConfigMapReferenceLike(Optional.ofNullable(this.buildConfigMapReference()).orElse(item));
  }
  
  public ConnectionStateNested<A> editOrNewConnectionState() {
    return this.withNewConnectionStateLike(Optional.ofNullable(this.buildConnectionState()).orElse(new GRPCConnectionStateBuilder().build()));
  }
  
  public ConnectionStateNested<A> editOrNewConnectionStateLike(GRPCConnectionState item) {
    return this.withNewConnectionStateLike(Optional.ofNullable(this.buildConnectionState()).orElse(item));
  }
  
  public RegistryServiceNested<A> editOrNewRegistryService() {
    return this.withNewRegistryServiceLike(Optional.ofNullable(this.buildRegistryService()).orElse(new RegistryServiceStatusBuilder().build()));
  }
  
  public RegistryServiceNested<A> editOrNewRegistryServiceLike(RegistryServiceStatus item) {
    return this.withNewRegistryServiceLike(Optional.ofNullable(this.buildRegistryService()).orElse(item));
  }
  
  public RegistryServiceNested<A> editRegistryService() {
    return this.withNewRegistryServiceLike(Optional.ofNullable(this.buildRegistryService()).orElse(null));
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
    CatalogSourceStatusFluent that = (CatalogSourceStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(configMapReference, that.configMapReference))) {
      return false;
    }
    if (!(Objects.equals(connectionState, that.connectionState))) {
      return false;
    }
    if (!(Objects.equals(latestImageRegistryPoll, that.latestImageRegistryPoll))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(registryService, that.registryService))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLatestImageRegistryPoll() {
    return this.latestImageRegistryPoll;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConfigMapReference() {
    return this.configMapReference != null;
  }
  
  public boolean hasConnectionState() {
    return this.connectionState != null;
  }
  
  public boolean hasLatestImageRegistryPoll() {
    return this.latestImageRegistryPoll != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasRegistryService() {
    return this.registryService != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, configMapReference, connectionState, latestImageRegistryPoll, message, reason, registryService, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(configMapReference == null)) {
        sb.append("configMapReference:");
        sb.append(configMapReference);
        sb.append(",");
    }
    if (!(connectionState == null)) {
        sb.append("connectionState:");
        sb.append(connectionState);
        sb.append(",");
    }
    if (!(latestImageRegistryPoll == null)) {
        sb.append("latestImageRegistryPoll:");
        sb.append(latestImageRegistryPoll);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(registryService == null)) {
        sb.append("registryService:");
        sb.append(registryService);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConfigMapReference(ConfigMapResourceReference configMapReference) {
    this._visitables.remove("configMapReference");
    if (configMapReference != null) {
        this.configMapReference = new ConfigMapResourceReferenceBuilder(configMapReference);
        this._visitables.get("configMapReference").add(this.configMapReference);
    } else {
        this.configMapReference = null;
        this._visitables.get("configMapReference").remove(this.configMapReference);
    }
    return (A) this;
  }
  
  public A withConnectionState(GRPCConnectionState connectionState) {
    this._visitables.remove("connectionState");
    if (connectionState != null) {
        this.connectionState = new GRPCConnectionStateBuilder(connectionState);
        this._visitables.get("connectionState").add(this.connectionState);
    } else {
        this.connectionState = null;
        this._visitables.get("connectionState").remove(this.connectionState);
    }
    return (A) this;
  }
  
  public A withLatestImageRegistryPoll(String latestImageRegistryPoll) {
    this.latestImageRegistryPoll = latestImageRegistryPoll;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public ConfigMapReferenceNested<A> withNewConfigMapReference() {
    return new ConfigMapReferenceNested(null);
  }
  
  public A withNewConfigMapReference(String lastUpdateTime,String name,String namespace,String resourceVersion,String uid) {
    return (A) this.withConfigMapReference(new ConfigMapResourceReference(lastUpdateTime, name, namespace, resourceVersion, uid));
  }
  
  public ConfigMapReferenceNested<A> withNewConfigMapReferenceLike(ConfigMapResourceReference item) {
    return new ConfigMapReferenceNested(item);
  }
  
  public ConnectionStateNested<A> withNewConnectionState() {
    return new ConnectionStateNested(null);
  }
  
  public A withNewConnectionState(String address,String lastConnect,String lastObservedState) {
    return (A) this.withConnectionState(new GRPCConnectionState(address, lastConnect, lastObservedState));
  }
  
  public ConnectionStateNested<A> withNewConnectionStateLike(GRPCConnectionState item) {
    return new ConnectionStateNested(item);
  }
  
  public RegistryServiceNested<A> withNewRegistryService() {
    return new RegistryServiceNested(null);
  }
  
  public A withNewRegistryService(String createdAt,String port,String protocol,String serviceName,String serviceNamespace) {
    return (A) this.withRegistryService(new RegistryServiceStatus(createdAt, port, protocol, serviceName, serviceNamespace));
  }
  
  public RegistryServiceNested<A> withNewRegistryServiceLike(RegistryServiceStatus item) {
    return new RegistryServiceNested(item);
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withRegistryService(RegistryServiceStatus registryService) {
    this._visitables.remove("registryService");
    if (registryService != null) {
        this.registryService = new RegistryServiceStatusBuilder(registryService);
        this._visitables.get("registryService").add(this.registryService);
    } else {
        this.registryService = null;
        this._visitables.get("registryService").remove(this.registryService);
    }
    return (A) this;
  }
  public class ConfigMapReferenceNested<N> extends ConfigMapResourceReferenceFluent<ConfigMapReferenceNested<N>> implements Nested<N>{
  
    ConfigMapResourceReferenceBuilder builder;
  
    ConfigMapReferenceNested(ConfigMapResourceReference item) {
      this.builder = new ConfigMapResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceStatusFluent.this.withConfigMapReference(builder.build());
    }
    
    public N endConfigMapReference() {
      return and();
    }
    
  }
  public class ConnectionStateNested<N> extends GRPCConnectionStateFluent<ConnectionStateNested<N>> implements Nested<N>{
  
    GRPCConnectionStateBuilder builder;
  
    ConnectionStateNested(GRPCConnectionState item) {
      this.builder = new GRPCConnectionStateBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceStatusFluent.this.withConnectionState(builder.build());
    }
    
    public N endConnectionState() {
      return and();
    }
    
  }
  public class RegistryServiceNested<N> extends RegistryServiceStatusFluent<RegistryServiceNested<N>> implements Nested<N>{
  
    RegistryServiceStatusBuilder builder;
  
    RegistryServiceNested(RegistryServiceStatus item) {
      this.builder = new RegistryServiceStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) CatalogSourceStatusFluent.this.withRegistryService(builder.build());
    }
    
    public N endRegistryService() {
      return and();
    }
    
  }
}