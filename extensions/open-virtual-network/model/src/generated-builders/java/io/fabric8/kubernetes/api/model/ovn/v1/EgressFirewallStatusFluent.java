package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class EgressFirewallStatusFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> messages = new ArrayList<String>();
  private String status;

  public EgressFirewallStatusFluent() {
  }
  
  public EgressFirewallStatusFluent(EgressFirewallStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToMessages(Collection<String> items) {
    if (this.messages == null) {
      this.messages = new ArrayList();
    }
    for (String item : items) {
      this.messages.add(item);
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
  
  public A addToMessages(String... items) {
    if (this.messages == null) {
      this.messages = new ArrayList();
    }
    for (String item : items) {
      this.messages.add(item);
    }
    return (A) this;
  }
  
  public A addToMessages(int index,String item) {
    if (this.messages == null) {
      this.messages = new ArrayList();
    }
    this.messages.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(EgressFirewallStatus instance) {
    instance = instance != null ? instance : new EgressFirewallStatus();
    if (instance != null) {
        this.withMessages(instance.getMessages());
        this.withStatus(instance.getStatus());
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
    EgressFirewallStatusFluent that = (EgressFirewallStatusFluent) o;
    if (!(Objects.equals(messages, that.messages))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
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
  
  public String getFirstMessage() {
    return this.messages.get(0);
  }
  
  public String getLastMessage() {
    return this.messages.get(messages.size() - 1);
  }
  
  public String getMatchingMessage(Predicate<String> predicate) {
      for (String item : messages) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessage(int index) {
    return this.messages.get(index);
  }
  
  public List<String> getMessages() {
    return this.messages;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingMessage(Predicate<String> predicate) {
      for (String item : messages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessages() {
    return this.messages != null && !(this.messages.isEmpty());
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(messages, status, additionalProperties);
  }
  
  public A removeAllFromMessages(Collection<String> items) {
    if (this.messages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.messages.remove(item);
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
  
  public A removeFromMessages(String... items) {
    if (this.messages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.messages.remove(item);
    }
    return (A) this;
  }
  
  public A setToMessages(int index,String item) {
    if (this.messages == null) {
      this.messages = new ArrayList();
    }
    this.messages.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(messages == null) && !(messages.isEmpty())) {
        sb.append("messages:");
        sb.append(messages);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public A withMessages(List<String> messages) {
    if (messages != null) {
        this.messages = new ArrayList();
        for (String item : messages) {
          this.addToMessages(item);
        }
    } else {
      this.messages = null;
    }
    return (A) this;
  }
  
  public A withMessages(String... messages) {
    if (this.messages != null) {
        this.messages.clear();
        _visitables.remove("messages");
    }
    if (messages != null) {
      for (String item : messages) {
        this.addToMessages(item);
      }
    }
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
}