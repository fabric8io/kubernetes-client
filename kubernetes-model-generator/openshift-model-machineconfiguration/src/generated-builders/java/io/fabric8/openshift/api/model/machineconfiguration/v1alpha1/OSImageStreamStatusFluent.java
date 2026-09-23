package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
public class OSImageStreamStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1alpha1.OSImageStreamStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<OSImageStreamSetBuilder> availableStreams = new ArrayList<OSImageStreamSetBuilder>();
  private String defaultStream;

  public OSImageStreamStatusFluent() {
  }
  
  public OSImageStreamStatusFluent(OSImageStreamStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAvailableStreams(Collection<OSImageStreamSet> items) {
    if (this.availableStreams == null) {
      this.availableStreams = new ArrayList();
    }
    for (OSImageStreamSet item : items) {
        OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
        _visitables.get("availableStreams").add(builder);
        this.availableStreams.add(builder);
    }
    return (A) this;
  }
  
  public AvailableStreamsNested<A> addNewAvailableStream() {
    return new AvailableStreamsNested(-1, null);
  }
  
  public A addNewAvailableStream(String name,String osExtensionsImage,String osImage) {
    return (A) this.addToAvailableStreams(new OSImageStreamSet(name, osExtensionsImage, osImage));
  }
  
  public AvailableStreamsNested<A> addNewAvailableStreamLike(OSImageStreamSet item) {
    return new AvailableStreamsNested(-1, item);
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
  
  public A addToAvailableStreams(OSImageStreamSet... items) {
    if (this.availableStreams == null) {
      this.availableStreams = new ArrayList();
    }
    for (OSImageStreamSet item : items) {
        OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
        _visitables.get("availableStreams").add(builder);
        this.availableStreams.add(builder);
    }
    return (A) this;
  }
  
  public A addToAvailableStreams(int index,OSImageStreamSet item) {
    if (this.availableStreams == null) {
      this.availableStreams = new ArrayList();
    }
    OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
    if (index < 0 || index >= availableStreams.size()) {
        _visitables.get("availableStreams").add(builder);
        availableStreams.add(builder);
    } else {
        _visitables.get("availableStreams").add(builder);
        availableStreams.add(index, builder);
    }
    return (A) this;
  }
  
  public OSImageStreamSet buildAvailableStream(int index) {
    return this.availableStreams.get(index).build();
  }
  
  public List<OSImageStreamSet> buildAvailableStreams() {
    return this.availableStreams != null ? build(availableStreams) : null;
  }
  
  public OSImageStreamSet buildFirstAvailableStream() {
    return this.availableStreams.get(0).build();
  }
  
  public OSImageStreamSet buildLastAvailableStream() {
    return this.availableStreams.get(availableStreams.size() - 1).build();
  }
  
  public OSImageStreamSet buildMatchingAvailableStream(Predicate<OSImageStreamSetBuilder> predicate) {
      for (OSImageStreamSetBuilder item : availableStreams) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(OSImageStreamStatus instance) {
    instance = instance != null ? instance : new OSImageStreamStatus();
    if (instance != null) {
        this.withAvailableStreams(instance.getAvailableStreams());
        this.withDefaultStream(instance.getDefaultStream());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AvailableStreamsNested<A> editAvailableStream(int index) {
    if (availableStreams.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "availableStreams"));
    }
    return this.setNewAvailableStreamLike(index, this.buildAvailableStream(index));
  }
  
  public AvailableStreamsNested<A> editFirstAvailableStream() {
    if (availableStreams.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "availableStreams"));
    }
    return this.setNewAvailableStreamLike(0, this.buildAvailableStream(0));
  }
  
  public AvailableStreamsNested<A> editLastAvailableStream() {
    int index = availableStreams.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "availableStreams"));
    }
    return this.setNewAvailableStreamLike(index, this.buildAvailableStream(index));
  }
  
  public AvailableStreamsNested<A> editMatchingAvailableStream(Predicate<OSImageStreamSetBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < availableStreams.size();i++) {
      if (predicate.test(availableStreams.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "availableStreams"));
    }
    return this.setNewAvailableStreamLike(index, this.buildAvailableStream(index));
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
    OSImageStreamStatusFluent that = (OSImageStreamStatusFluent) o;
    if (!(Objects.equals(availableStreams, that.availableStreams))) {
      return false;
    }
    if (!(Objects.equals(defaultStream, that.defaultStream))) {
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
  
  public String getDefaultStream() {
    return this.defaultStream;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableStreams() {
    return this.availableStreams != null && !(this.availableStreams.isEmpty());
  }
  
  public boolean hasDefaultStream() {
    return this.defaultStream != null;
  }
  
  public boolean hasMatchingAvailableStream(Predicate<OSImageStreamSetBuilder> predicate) {
      for (OSImageStreamSetBuilder item : availableStreams) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(availableStreams, defaultStream, additionalProperties);
  }
  
  public A removeAllFromAvailableStreams(Collection<OSImageStreamSet> items) {
    if (this.availableStreams == null) {
      return (A) this;
    }
    for (OSImageStreamSet item : items) {
        OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
        _visitables.get("availableStreams").remove(builder);
        this.availableStreams.remove(builder);
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
  
  public A removeFromAvailableStreams(OSImageStreamSet... items) {
    if (this.availableStreams == null) {
      return (A) this;
    }
    for (OSImageStreamSet item : items) {
        OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
        _visitables.get("availableStreams").remove(builder);
        this.availableStreams.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAvailableStreams(Predicate<OSImageStreamSetBuilder> predicate) {
    if (availableStreams == null) {
      return (A) this;
    }
    Iterator<OSImageStreamSetBuilder> each = availableStreams.iterator();
    List visitables = _visitables.get("availableStreams");
    while (each.hasNext()) {
        OSImageStreamSetBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AvailableStreamsNested<A> setNewAvailableStreamLike(int index,OSImageStreamSet item) {
    return new AvailableStreamsNested(index, item);
  }
  
  public A setToAvailableStreams(int index,OSImageStreamSet item) {
    if (this.availableStreams == null) {
      this.availableStreams = new ArrayList();
    }
    OSImageStreamSetBuilder builder = new OSImageStreamSetBuilder(item);
    if (index < 0 || index >= availableStreams.size()) {
        _visitables.get("availableStreams").add(builder);
        availableStreams.add(builder);
    } else {
        _visitables.get("availableStreams").add(builder);
        availableStreams.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableStreams == null) && !(availableStreams.isEmpty())) {
        sb.append("availableStreams:");
        sb.append(availableStreams);
        sb.append(",");
    }
    if (!(defaultStream == null)) {
        sb.append("defaultStream:");
        sb.append(defaultStream);
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
  
  public A withAvailableStreams(List<OSImageStreamSet> availableStreams) {
    if (this.availableStreams != null) {
      this._visitables.get("availableStreams").clear();
    }
    if (availableStreams != null) {
        this.availableStreams = new ArrayList();
        for (OSImageStreamSet item : availableStreams) {
          this.addToAvailableStreams(item);
        }
    } else {
      this.availableStreams = null;
    }
    return (A) this;
  }
  
  public A withAvailableStreams(OSImageStreamSet... availableStreams) {
    if (this.availableStreams != null) {
        this.availableStreams.clear();
        _visitables.remove("availableStreams");
    }
    if (availableStreams != null) {
      for (OSImageStreamSet item : availableStreams) {
        this.addToAvailableStreams(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultStream(String defaultStream) {
    this.defaultStream = defaultStream;
    return (A) this;
  }
  public class AvailableStreamsNested<N> extends OSImageStreamSetFluent<AvailableStreamsNested<N>> implements Nested<N>{
  
    OSImageStreamSetBuilder builder;
    int index;
  
    AvailableStreamsNested(int index,OSImageStreamSet item) {
      this.index = index;
      this.builder = new OSImageStreamSetBuilder(this, item);
    }
  
    public N and() {
      return (N) OSImageStreamStatusFluent.this.setToAvailableStreams(index, builder.build());
    }
    
    public N endAvailableStream() {
      return and();
    }
    
  }
}