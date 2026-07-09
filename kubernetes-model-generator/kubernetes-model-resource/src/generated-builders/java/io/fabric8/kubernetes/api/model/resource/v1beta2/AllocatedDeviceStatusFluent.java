package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
public class AllocatedDeviceStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.AllocatedDeviceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Object data;
  private String device;
  private String driver;
  private NetworkDeviceDataBuilder networkData;
  private String pool;
  private String shareID;

  public AllocatedDeviceStatusFluent() {
  }
  
  public AllocatedDeviceStatusFluent(AllocatedDeviceStatus instance) {
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
  
  public NetworkDeviceData buildNetworkData() {
    return this.networkData != null ? this.networkData.build() : null;
  }
  
  protected void copyInstance(AllocatedDeviceStatus instance) {
    instance = instance != null ? instance : new AllocatedDeviceStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withData(instance.getData());
        this.withDevice(instance.getDevice());
        this.withDriver(instance.getDriver());
        this.withNetworkData(instance.getNetworkData());
        this.withPool(instance.getPool());
        this.withShareID(instance.getShareID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NetworkDataNested<A> editNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(null));
  }
  
  public NetworkDataNested<A> editOrNewNetworkData() {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(new NetworkDeviceDataBuilder().build()));
  }
  
  public NetworkDataNested<A> editOrNewNetworkDataLike(NetworkDeviceData item) {
    return this.withNewNetworkDataLike(Optional.ofNullable(this.buildNetworkData()).orElse(item));
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
    AllocatedDeviceStatusFluent that = (AllocatedDeviceStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(data, that.data))) {
      return false;
    }
    if (!(Objects.equals(device, that.device))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(pool, that.pool))) {
      return false;
    }
    if (!(Objects.equals(shareID, that.shareID))) {
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
  
  public Object getData() {
    return this.data;
  }
  
  public String getDevice() {
    return this.device;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPool() {
    return this.pool;
  }
  
  public String getShareID() {
    return this.shareID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasData() {
    return this.data != null;
  }
  
  public boolean hasDevice() {
    return this.device != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasPool() {
    return this.pool != null;
  }
  
  public boolean hasShareID() {
    return this.shareID != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, data, device, driver, networkData, pool, shareID, additionalProperties);
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
    if (!(data == null)) {
        sb.append("data:");
        sb.append(data);
        sb.append(",");
    }
    if (!(device == null)) {
        sb.append("device:");
        sb.append(device);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
        sb.append(",");
    }
    if (!(pool == null)) {
        sb.append("pool:");
        sb.append(pool);
        sb.append(",");
    }
    if (!(shareID == null)) {
        sb.append("shareID:");
        sb.append(shareID);
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
  
  public A withData(Object data) {
    this.data = data;
    return (A) this;
  }
  
  public A withDevice(String device) {
    this.device = device;
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withNetworkData(NetworkDeviceData networkData) {
    this._visitables.remove("networkData");
    if (networkData != null) {
        this.networkData = new NetworkDeviceDataBuilder(networkData);
        this._visitables.get("networkData").add(this.networkData);
    } else {
        this.networkData = null;
        this._visitables.get("networkData").remove(this.networkData);
    }
    return (A) this;
  }
  
  public NetworkDataNested<A> withNewNetworkData() {
    return new NetworkDataNested(null);
  }
  
  public NetworkDataNested<A> withNewNetworkDataLike(NetworkDeviceData item) {
    return new NetworkDataNested(item);
  }
  
  public A withPool(String pool) {
    this.pool = pool;
    return (A) this;
  }
  
  public A withShareID(String shareID) {
    this.shareID = shareID;
    return (A) this;
  }
  public class NetworkDataNested<N> extends NetworkDeviceDataFluent<NetworkDataNested<N>> implements Nested<N>{
  
    NetworkDeviceDataBuilder builder;
  
    NetworkDataNested(NetworkDeviceData item) {
      this.builder = new NetworkDeviceDataBuilder(this, item);
    }
  
    public N and() {
      return (N) AllocatedDeviceStatusFluent.this.withNetworkData(builder.build());
    }
    
    public N endNetworkData() {
      return and();
    }
    
  }
}