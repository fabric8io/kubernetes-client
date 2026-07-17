package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ReleaseFluent<A extends io.fabric8.openshift.api.model.config.v1.ReleaseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String architecture;
  private List<String> channels = new ArrayList<String>();
  private String image;
  private String url;
  private String version;

  public ReleaseFluent() {
  }
  
  public ReleaseFluent(Release instance) {
    this.copyInstance(instance);
  }

  public A addAllToChannels(Collection<String> items) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    for (String item : items) {
      this.channels.add(item);
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
  
  public A addToChannels(String... items) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    for (String item : items) {
      this.channels.add(item);
    }
    return (A) this;
  }
  
  public A addToChannels(int index,String item) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    this.channels.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Release instance) {
    instance = instance != null ? instance : new Release();
    if (instance != null) {
        this.withArchitecture(instance.getArchitecture());
        this.withChannels(instance.getChannels());
        this.withImage(instance.getImage());
        this.withUrl(instance.getUrl());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ReleaseFluent that = (ReleaseFluent) o;
    if (!(Objects.equals(architecture, that.architecture))) {
      return false;
    }
    if (!(Objects.equals(channels, that.channels))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getArchitecture() {
    return this.architecture;
  }
  
  public String getChannel(int index) {
    return this.channels.get(index);
  }
  
  public List<String> getChannels() {
    return this.channels;
  }
  
  public String getFirstChannel() {
    return this.channels.get(0);
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getLastChannel() {
    return this.channels.get(channels.size() - 1);
  }
  
  public String getMatchingChannel(Predicate<String> predicate) {
      for (String item : channels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArchitecture() {
    return this.architecture != null;
  }
  
  public boolean hasChannels() {
    return this.channels != null && !(this.channels.isEmpty());
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasMatchingChannel(Predicate<String> predicate) {
      for (String item : channels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(architecture, channels, image, url, version, additionalProperties);
  }
  
  public A removeAllFromChannels(Collection<String> items) {
    if (this.channels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.channels.remove(item);
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
  
  public A removeFromChannels(String... items) {
    if (this.channels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.channels.remove(item);
    }
    return (A) this;
  }
  
  public A setToChannels(int index,String item) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    this.channels.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(architecture == null)) {
        sb.append("architecture:");
        sb.append(architecture);
        sb.append(",");
    }
    if (!(channels == null) && !(channels.isEmpty())) {
        sb.append("channels:");
        sb.append(channels);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withArchitecture(String architecture) {
    this.architecture = architecture;
    return (A) this;
  }
  
  public A withChannels(List<String> channels) {
    if (channels != null) {
        this.channels = new ArrayList();
        for (String item : channels) {
          this.addToChannels(item);
        }
    } else {
      this.channels = null;
    }
    return (A) this;
  }
  
  public A withChannels(String... channels) {
    if (this.channels != null) {
        this.channels.clear();
        _visitables.remove("channels");
    }
    if (channels != null) {
      for (String item : channels) {
        this.addToChannels(item);
      }
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
}