package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeviceClaimFluent<A extends io.fabric8.kubernetes.api.model.resource.v1beta2.DeviceClaimFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DeviceClaimConfigurationBuilder> config = new ArrayList<DeviceClaimConfigurationBuilder>();
  private ArrayList<DeviceConstraintBuilder> constraints = new ArrayList<DeviceConstraintBuilder>();
  private ArrayList<DeviceRequestBuilder> requests = new ArrayList<DeviceRequestBuilder>();

  public DeviceClaimFluent() {
  }
  
  public DeviceClaimFluent(DeviceClaim instance) {
    this.copyInstance(instance);
  }

  public A addAllToConfig(Collection<DeviceClaimConfiguration> items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceClaimConfiguration item : items) {
        DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConstraints(Collection<DeviceConstraint> items) {
    if (this.constraints == null) {
      this.constraints = new ArrayList();
    }
    for (DeviceConstraint item : items) {
        DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
        _visitables.get("constraints").add(builder);
        this.constraints.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequests(Collection<DeviceRequest> items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (DeviceRequest item : items) {
        DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
        _visitables.get("requests").add(builder);
        this.requests.add(builder);
    }
    return (A) this;
  }
  
  public ConfigNested<A> addNewConfig() {
    return new ConfigNested(-1, null);
  }
  
  public ConfigNested<A> addNewConfigLike(DeviceClaimConfiguration item) {
    return new ConfigNested(-1, item);
  }
  
  public ConstraintsNested<A> addNewConstraint() {
    return new ConstraintsNested(-1, null);
  }
  
  public ConstraintsNested<A> addNewConstraintLike(DeviceConstraint item) {
    return new ConstraintsNested(-1, item);
  }
  
  public RequestsNested<A> addNewRequest() {
    return new RequestsNested(-1, null);
  }
  
  public RequestsNested<A> addNewRequestLike(DeviceRequest item) {
    return new RequestsNested(-1, item);
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
  
  public A addToConfig(DeviceClaimConfiguration... items) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    for (DeviceClaimConfiguration item : items) {
        DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
        _visitables.get("config").add(builder);
        this.config.add(builder);
    }
    return (A) this;
  }
  
  public A addToConfig(int index,DeviceClaimConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConstraints(DeviceConstraint... items) {
    if (this.constraints == null) {
      this.constraints = new ArrayList();
    }
    for (DeviceConstraint item : items) {
        DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
        _visitables.get("constraints").add(builder);
        this.constraints.add(builder);
    }
    return (A) this;
  }
  
  public A addToConstraints(int index,DeviceConstraint item) {
    if (this.constraints == null) {
      this.constraints = new ArrayList();
    }
    DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
    if (index < 0 || index >= constraints.size()) {
        _visitables.get("constraints").add(builder);
        constraints.add(builder);
    } else {
        _visitables.get("constraints").add(builder);
        constraints.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequests(DeviceRequest... items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (DeviceRequest item : items) {
        DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
        _visitables.get("requests").add(builder);
        this.requests.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequests(int index,DeviceRequest item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
    if (index < 0 || index >= requests.size()) {
        _visitables.get("requests").add(builder);
        requests.add(builder);
    } else {
        _visitables.get("requests").add(builder);
        requests.add(index, builder);
    }
    return (A) this;
  }
  
  public List<DeviceClaimConfiguration> buildConfig() {
    return this.config != null ? build(config) : null;
  }
  
  public DeviceClaimConfiguration buildConfig(int index) {
    return this.config.get(index).build();
  }
  
  public DeviceConstraint buildConstraint(int index) {
    return this.constraints.get(index).build();
  }
  
  public List<DeviceConstraint> buildConstraints() {
    return this.constraints != null ? build(constraints) : null;
  }
  
  public DeviceClaimConfiguration buildFirstConfig() {
    return this.config.get(0).build();
  }
  
  public DeviceConstraint buildFirstConstraint() {
    return this.constraints.get(0).build();
  }
  
  public DeviceRequest buildFirstRequest() {
    return this.requests.get(0).build();
  }
  
  public DeviceClaimConfiguration buildLastConfig() {
    return this.config.get(config.size() - 1).build();
  }
  
  public DeviceConstraint buildLastConstraint() {
    return this.constraints.get(constraints.size() - 1).build();
  }
  
  public DeviceRequest buildLastRequest() {
    return this.requests.get(requests.size() - 1).build();
  }
  
  public DeviceClaimConfiguration buildMatchingConfig(Predicate<DeviceClaimConfigurationBuilder> predicate) {
      for (DeviceClaimConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceConstraint buildMatchingConstraint(Predicate<DeviceConstraintBuilder> predicate) {
      for (DeviceConstraintBuilder item : constraints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceRequest buildMatchingRequest(Predicate<DeviceRequestBuilder> predicate) {
      for (DeviceRequestBuilder item : requests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeviceRequest buildRequest(int index) {
    return this.requests.get(index).build();
  }
  
  public List<DeviceRequest> buildRequests() {
    return this.requests != null ? build(requests) : null;
  }
  
  protected void copyInstance(DeviceClaim instance) {
    instance = instance != null ? instance : new DeviceClaim();
    if (instance != null) {
        this.withConfig(instance.getConfig());
        this.withConstraints(instance.getConstraints());
        this.withRequests(instance.getRequests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigNested<A> editConfig(int index) {
    if (config.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConstraintsNested<A> editConstraint(int index) {
    if (constraints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "constraints"));
    }
    return this.setNewConstraintLike(index, this.buildConstraint(index));
  }
  
  public ConfigNested<A> editFirstConfig() {
    if (config.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(0, this.buildConfig(0));
  }
  
  public ConstraintsNested<A> editFirstConstraint() {
    if (constraints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "constraints"));
    }
    return this.setNewConstraintLike(0, this.buildConstraint(0));
  }
  
  public RequestsNested<A> editFirstRequest() {
    if (requests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requests"));
    }
    return this.setNewRequestLike(0, this.buildRequest(0));
  }
  
  public ConfigNested<A> editLastConfig() {
    int index = config.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConstraintsNested<A> editLastConstraint() {
    int index = constraints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "constraints"));
    }
    return this.setNewConstraintLike(index, this.buildConstraint(index));
  }
  
  public RequestsNested<A> editLastRequest() {
    int index = requests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public ConfigNested<A> editMatchingConfig(Predicate<DeviceClaimConfigurationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < config.size();i++) {
      if (predicate.test(config.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "config"));
    }
    return this.setNewConfigLike(index, this.buildConfig(index));
  }
  
  public ConstraintsNested<A> editMatchingConstraint(Predicate<DeviceConstraintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < constraints.size();i++) {
      if (predicate.test(constraints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "constraints"));
    }
    return this.setNewConstraintLike(index, this.buildConstraint(index));
  }
  
  public RequestsNested<A> editMatchingRequest(Predicate<DeviceRequestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requests.size();i++) {
      if (predicate.test(requests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public RequestsNested<A> editRequest(int index) {
    if (requests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
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
    DeviceClaimFluent that = (DeviceClaimFluent) o;
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(constraints, that.constraints))) {
      return false;
    }
    if (!(Objects.equals(requests, that.requests))) {
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
  
  public boolean hasConfig() {
    return this.config != null && !(this.config.isEmpty());
  }
  
  public boolean hasConstraints() {
    return this.constraints != null && !(this.constraints.isEmpty());
  }
  
  public boolean hasMatchingConfig(Predicate<DeviceClaimConfigurationBuilder> predicate) {
      for (DeviceClaimConfigurationBuilder item : config) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConstraint(Predicate<DeviceConstraintBuilder> predicate) {
      for (DeviceConstraintBuilder item : constraints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequest(Predicate<DeviceRequestBuilder> predicate) {
      for (DeviceRequestBuilder item : requests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequests() {
    return this.requests != null && !(this.requests.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(config, constraints, requests, additionalProperties);
  }
  
  public A removeAllFromConfig(Collection<DeviceClaimConfiguration> items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceClaimConfiguration item : items) {
        DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConstraints(Collection<DeviceConstraint> items) {
    if (this.constraints == null) {
      return (A) this;
    }
    for (DeviceConstraint item : items) {
        DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
        _visitables.get("constraints").remove(builder);
        this.constraints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequests(Collection<DeviceRequest> items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (DeviceRequest item : items) {
        DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
        _visitables.get("requests").remove(builder);
        this.requests.remove(builder);
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
  
  public A removeFromConfig(DeviceClaimConfiguration... items) {
    if (this.config == null) {
      return (A) this;
    }
    for (DeviceClaimConfiguration item : items) {
        DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
        _visitables.get("config").remove(builder);
        this.config.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConstraints(DeviceConstraint... items) {
    if (this.constraints == null) {
      return (A) this;
    }
    for (DeviceConstraint item : items) {
        DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
        _visitables.get("constraints").remove(builder);
        this.constraints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequests(DeviceRequest... items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (DeviceRequest item : items) {
        DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
        _visitables.get("requests").remove(builder);
        this.requests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConfig(Predicate<DeviceClaimConfigurationBuilder> predicate) {
    if (config == null) {
      return (A) this;
    }
    Iterator<DeviceClaimConfigurationBuilder> each = config.iterator();
    List visitables = _visitables.get("config");
    while (each.hasNext()) {
        DeviceClaimConfigurationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConstraints(Predicate<DeviceConstraintBuilder> predicate) {
    if (constraints == null) {
      return (A) this;
    }
    Iterator<DeviceConstraintBuilder> each = constraints.iterator();
    List visitables = _visitables.get("constraints");
    while (each.hasNext()) {
        DeviceConstraintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequests(Predicate<DeviceRequestBuilder> predicate) {
    if (requests == null) {
      return (A) this;
    }
    Iterator<DeviceRequestBuilder> each = requests.iterator();
    List visitables = _visitables.get("requests");
    while (each.hasNext()) {
        DeviceRequestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConfigNested<A> setNewConfigLike(int index,DeviceClaimConfiguration item) {
    return new ConfigNested(index, item);
  }
  
  public ConstraintsNested<A> setNewConstraintLike(int index,DeviceConstraint item) {
    return new ConstraintsNested(index, item);
  }
  
  public RequestsNested<A> setNewRequestLike(int index,DeviceRequest item) {
    return new RequestsNested(index, item);
  }
  
  public A setToConfig(int index,DeviceClaimConfiguration item) {
    if (this.config == null) {
      this.config = new ArrayList();
    }
    DeviceClaimConfigurationBuilder builder = new DeviceClaimConfigurationBuilder(item);
    if (index < 0 || index >= config.size()) {
        _visitables.get("config").add(builder);
        config.add(builder);
    } else {
        _visitables.get("config").add(builder);
        config.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConstraints(int index,DeviceConstraint item) {
    if (this.constraints == null) {
      this.constraints = new ArrayList();
    }
    DeviceConstraintBuilder builder = new DeviceConstraintBuilder(item);
    if (index < 0 || index >= constraints.size()) {
        _visitables.get("constraints").add(builder);
        constraints.add(builder);
    } else {
        _visitables.get("constraints").add(builder);
        constraints.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequests(int index,DeviceRequest item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    DeviceRequestBuilder builder = new DeviceRequestBuilder(item);
    if (index < 0 || index >= requests.size()) {
        _visitables.get("requests").add(builder);
        requests.add(builder);
    } else {
        _visitables.get("requests").add(builder);
        requests.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(config == null) && !(config.isEmpty())) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(constraints == null) && !(constraints.isEmpty())) {
        sb.append("constraints:");
        sb.append(constraints);
        sb.append(",");
    }
    if (!(requests == null) && !(requests.isEmpty())) {
        sb.append("requests:");
        sb.append(requests);
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
  
  public A withConfig(List<DeviceClaimConfiguration> config) {
    if (this.config != null) {
      this._visitables.get("config").clear();
    }
    if (config != null) {
        this.config = new ArrayList();
        for (DeviceClaimConfiguration item : config) {
          this.addToConfig(item);
        }
    } else {
      this.config = null;
    }
    return (A) this;
  }
  
  public A withConfig(DeviceClaimConfiguration... config) {
    if (this.config != null) {
        this.config.clear();
        _visitables.remove("config");
    }
    if (config != null) {
      for (DeviceClaimConfiguration item : config) {
        this.addToConfig(item);
      }
    }
    return (A) this;
  }
  
  public A withConstraints(List<DeviceConstraint> constraints) {
    if (this.constraints != null) {
      this._visitables.get("constraints").clear();
    }
    if (constraints != null) {
        this.constraints = new ArrayList();
        for (DeviceConstraint item : constraints) {
          this.addToConstraints(item);
        }
    } else {
      this.constraints = null;
    }
    return (A) this;
  }
  
  public A withConstraints(DeviceConstraint... constraints) {
    if (this.constraints != null) {
        this.constraints.clear();
        _visitables.remove("constraints");
    }
    if (constraints != null) {
      for (DeviceConstraint item : constraints) {
        this.addToConstraints(item);
      }
    }
    return (A) this;
  }
  
  public A withRequests(List<DeviceRequest> requests) {
    if (this.requests != null) {
      this._visitables.get("requests").clear();
    }
    if (requests != null) {
        this.requests = new ArrayList();
        for (DeviceRequest item : requests) {
          this.addToRequests(item);
        }
    } else {
      this.requests = null;
    }
    return (A) this;
  }
  
  public A withRequests(DeviceRequest... requests) {
    if (this.requests != null) {
        this.requests.clear();
        _visitables.remove("requests");
    }
    if (requests != null) {
      for (DeviceRequest item : requests) {
        this.addToRequests(item);
      }
    }
    return (A) this;
  }
  public class ConfigNested<N> extends DeviceClaimConfigurationFluent<ConfigNested<N>> implements Nested<N>{
  
    DeviceClaimConfigurationBuilder builder;
    int index;
  
    ConfigNested(int index,DeviceClaimConfiguration item) {
      this.index = index;
      this.builder = new DeviceClaimConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceClaimFluent.this.setToConfig(index, builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
  public class ConstraintsNested<N> extends DeviceConstraintFluent<ConstraintsNested<N>> implements Nested<N>{
  
    DeviceConstraintBuilder builder;
    int index;
  
    ConstraintsNested(int index,DeviceConstraint item) {
      this.index = index;
      this.builder = new DeviceConstraintBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceClaimFluent.this.setToConstraints(index, builder.build());
    }
    
    public N endConstraint() {
      return and();
    }
    
  }
  public class RequestsNested<N> extends DeviceRequestFluent<RequestsNested<N>> implements Nested<N>{
  
    DeviceRequestBuilder builder;
    int index;
  
    RequestsNested(int index,DeviceRequest item) {
      this.index = index;
      this.builder = new DeviceRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceClaimFluent.this.setToRequests(index, builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
}