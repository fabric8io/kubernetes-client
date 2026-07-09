package io.fabric8.kubernetes.api.model.resource.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DeviceRequestFluent<A extends io.fabric8.kubernetes.api.model.resource.v1.DeviceRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExactDeviceRequestBuilder exactly;
  private ArrayList<DeviceSubRequestBuilder> firstAvailable = new ArrayList<DeviceSubRequestBuilder>();
  private String name;

  public DeviceRequestFluent() {
  }
  
  public DeviceRequestFluent(DeviceRequest instance) {
    this.copyInstance(instance);
  }

  public A addAllToFirstAvailable(Collection<DeviceSubRequest> items) {
    if (this.firstAvailable == null) {
      this.firstAvailable = new ArrayList();
    }
    for (DeviceSubRequest item : items) {
        DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
        _visitables.get("firstAvailable").add(builder);
        this.firstAvailable.add(builder);
    }
    return (A) this;
  }
  
  public FirstAvailableNested<A> addNewFirstAvailable() {
    return new FirstAvailableNested(-1, null);
  }
  
  public FirstAvailableNested<A> addNewFirstAvailableLike(DeviceSubRequest item) {
    return new FirstAvailableNested(-1, item);
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
  
  public A addToFirstAvailable(DeviceSubRequest... items) {
    if (this.firstAvailable == null) {
      this.firstAvailable = new ArrayList();
    }
    for (DeviceSubRequest item : items) {
        DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
        _visitables.get("firstAvailable").add(builder);
        this.firstAvailable.add(builder);
    }
    return (A) this;
  }
  
  public A addToFirstAvailable(int index,DeviceSubRequest item) {
    if (this.firstAvailable == null) {
      this.firstAvailable = new ArrayList();
    }
    DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
    if (index < 0 || index >= firstAvailable.size()) {
        _visitables.get("firstAvailable").add(builder);
        firstAvailable.add(builder);
    } else {
        _visitables.get("firstAvailable").add(builder);
        firstAvailable.add(index, builder);
    }
    return (A) this;
  }
  
  public ExactDeviceRequest buildExactly() {
    return this.exactly != null ? this.exactly.build() : null;
  }
  
  public List<DeviceSubRequest> buildFirstAvailable() {
    return this.firstAvailable != null ? build(firstAvailable) : null;
  }
  
  public DeviceSubRequest buildFirstAvailable(int index) {
    return this.firstAvailable.get(index).build();
  }
  
  public DeviceSubRequest buildFirstFirstAvailable() {
    return this.firstAvailable.get(0).build();
  }
  
  public DeviceSubRequest buildLastFirstAvailable() {
    return this.firstAvailable.get(firstAvailable.size() - 1).build();
  }
  
  public DeviceSubRequest buildMatchingFirstAvailable(Predicate<DeviceSubRequestBuilder> predicate) {
      for (DeviceSubRequestBuilder item : firstAvailable) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DeviceRequest instance) {
    instance = instance != null ? instance : new DeviceRequest();
    if (instance != null) {
        this.withExactly(instance.getExactly());
        this.withFirstAvailable(instance.getFirstAvailable());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExactlyNested<A> editExactly() {
    return this.withNewExactlyLike(Optional.ofNullable(this.buildExactly()).orElse(null));
  }
  
  public FirstAvailableNested<A> editFirstAvailable(int index) {
    if (firstAvailable.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "firstAvailable"));
    }
    return this.setNewFirstAvailableLike(index, this.buildFirstAvailable(index));
  }
  
  public FirstAvailableNested<A> editFirstFirstAvailable() {
    if (firstAvailable.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "firstAvailable"));
    }
    return this.setNewFirstAvailableLike(0, this.buildFirstAvailable(0));
  }
  
  public FirstAvailableNested<A> editLastFirstAvailable() {
    int index = firstAvailable.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "firstAvailable"));
    }
    return this.setNewFirstAvailableLike(index, this.buildFirstAvailable(index));
  }
  
  public FirstAvailableNested<A> editMatchingFirstAvailable(Predicate<DeviceSubRequestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < firstAvailable.size();i++) {
      if (predicate.test(firstAvailable.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "firstAvailable"));
    }
    return this.setNewFirstAvailableLike(index, this.buildFirstAvailable(index));
  }
  
  public ExactlyNested<A> editOrNewExactly() {
    return this.withNewExactlyLike(Optional.ofNullable(this.buildExactly()).orElse(new ExactDeviceRequestBuilder().build()));
  }
  
  public ExactlyNested<A> editOrNewExactlyLike(ExactDeviceRequest item) {
    return this.withNewExactlyLike(Optional.ofNullable(this.buildExactly()).orElse(item));
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
    DeviceRequestFluent that = (DeviceRequestFluent) o;
    if (!(Objects.equals(exactly, that.exactly))) {
      return false;
    }
    if (!(Objects.equals(firstAvailable, that.firstAvailable))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExactly() {
    return this.exactly != null;
  }
  
  public boolean hasFirstAvailable() {
    return this.firstAvailable != null && !(this.firstAvailable.isEmpty());
  }
  
  public boolean hasMatchingFirstAvailable(Predicate<DeviceSubRequestBuilder> predicate) {
      for (DeviceSubRequestBuilder item : firstAvailable) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(exactly, firstAvailable, name, additionalProperties);
  }
  
  public A removeAllFromFirstAvailable(Collection<DeviceSubRequest> items) {
    if (this.firstAvailable == null) {
      return (A) this;
    }
    for (DeviceSubRequest item : items) {
        DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
        _visitables.get("firstAvailable").remove(builder);
        this.firstAvailable.remove(builder);
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
  
  public A removeFromFirstAvailable(DeviceSubRequest... items) {
    if (this.firstAvailable == null) {
      return (A) this;
    }
    for (DeviceSubRequest item : items) {
        DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
        _visitables.get("firstAvailable").remove(builder);
        this.firstAvailable.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFirstAvailable(Predicate<DeviceSubRequestBuilder> predicate) {
    if (firstAvailable == null) {
      return (A) this;
    }
    Iterator<DeviceSubRequestBuilder> each = firstAvailable.iterator();
    List visitables = _visitables.get("firstAvailable");
    while (each.hasNext()) {
        DeviceSubRequestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FirstAvailableNested<A> setNewFirstAvailableLike(int index,DeviceSubRequest item) {
    return new FirstAvailableNested(index, item);
  }
  
  public A setToFirstAvailable(int index,DeviceSubRequest item) {
    if (this.firstAvailable == null) {
      this.firstAvailable = new ArrayList();
    }
    DeviceSubRequestBuilder builder = new DeviceSubRequestBuilder(item);
    if (index < 0 || index >= firstAvailable.size()) {
        _visitables.get("firstAvailable").add(builder);
        firstAvailable.add(builder);
    } else {
        _visitables.get("firstAvailable").add(builder);
        firstAvailable.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(exactly == null)) {
        sb.append("exactly:");
        sb.append(exactly);
        sb.append(",");
    }
    if (!(firstAvailable == null) && !(firstAvailable.isEmpty())) {
        sb.append("firstAvailable:");
        sb.append(firstAvailable);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withExactly(ExactDeviceRequest exactly) {
    this._visitables.remove("exactly");
    if (exactly != null) {
        this.exactly = new ExactDeviceRequestBuilder(exactly);
        this._visitables.get("exactly").add(this.exactly);
    } else {
        this.exactly = null;
        this._visitables.get("exactly").remove(this.exactly);
    }
    return (A) this;
  }
  
  public A withFirstAvailable(List<DeviceSubRequest> firstAvailable) {
    if (this.firstAvailable != null) {
      this._visitables.get("firstAvailable").clear();
    }
    if (firstAvailable != null) {
        this.firstAvailable = new ArrayList();
        for (DeviceSubRequest item : firstAvailable) {
          this.addToFirstAvailable(item);
        }
    } else {
      this.firstAvailable = null;
    }
    return (A) this;
  }
  
  public A withFirstAvailable(DeviceSubRequest... firstAvailable) {
    if (this.firstAvailable != null) {
        this.firstAvailable.clear();
        _visitables.remove("firstAvailable");
    }
    if (firstAvailable != null) {
      for (DeviceSubRequest item : firstAvailable) {
        this.addToFirstAvailable(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ExactlyNested<A> withNewExactly() {
    return new ExactlyNested(null);
  }
  
  public ExactlyNested<A> withNewExactlyLike(ExactDeviceRequest item) {
    return new ExactlyNested(item);
  }
  public class ExactlyNested<N> extends ExactDeviceRequestFluent<ExactlyNested<N>> implements Nested<N>{
  
    ExactDeviceRequestBuilder builder;
  
    ExactlyNested(ExactDeviceRequest item) {
      this.builder = new ExactDeviceRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceRequestFluent.this.withExactly(builder.build());
    }
    
    public N endExactly() {
      return and();
    }
    
  }
  public class FirstAvailableNested<N> extends DeviceSubRequestFluent<FirstAvailableNested<N>> implements Nested<N>{
  
    DeviceSubRequestBuilder builder;
    int index;
  
    FirstAvailableNested(int index,DeviceSubRequest item) {
      this.index = index;
      this.builder = new DeviceSubRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) DeviceRequestFluent.this.setToFirstAvailable(index, builder.build());
    }
    
    public N endFirstAvailable() {
      return and();
    }
    
  }
}