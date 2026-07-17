package io.fabric8.openshift.api.model.operator.v1;

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
public class AddPageFluent<A extends io.fabric8.openshift.api.model.operator.v1.AddPageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> disabledActions = new ArrayList<String>();

  public AddPageFluent() {
  }
  
  public AddPageFluent(AddPage instance) {
    this.copyInstance(instance);
  }

  public A addAllToDisabledActions(Collection<String> items) {
    if (this.disabledActions == null) {
      this.disabledActions = new ArrayList();
    }
    for (String item : items) {
      this.disabledActions.add(item);
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
  
  public A addToDisabledActions(String... items) {
    if (this.disabledActions == null) {
      this.disabledActions = new ArrayList();
    }
    for (String item : items) {
      this.disabledActions.add(item);
    }
    return (A) this;
  }
  
  public A addToDisabledActions(int index,String item) {
    if (this.disabledActions == null) {
      this.disabledActions = new ArrayList();
    }
    this.disabledActions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(AddPage instance) {
    instance = instance != null ? instance : new AddPage();
    if (instance != null) {
        this.withDisabledActions(instance.getDisabledActions());
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
    AddPageFluent that = (AddPageFluent) o;
    if (!(Objects.equals(disabledActions, that.disabledActions))) {
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
  
  public String getDisabledAction(int index) {
    return this.disabledActions.get(index);
  }
  
  public List<String> getDisabledActions() {
    return this.disabledActions;
  }
  
  public String getFirstDisabledAction() {
    return this.disabledActions.get(0);
  }
  
  public String getLastDisabledAction() {
    return this.disabledActions.get(disabledActions.size() - 1);
  }
  
  public String getMatchingDisabledAction(Predicate<String> predicate) {
      for (String item : disabledActions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisabledActions() {
    return this.disabledActions != null && !(this.disabledActions.isEmpty());
  }
  
  public boolean hasMatchingDisabledAction(Predicate<String> predicate) {
      for (String item : disabledActions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(disabledActions, additionalProperties);
  }
  
  public A removeAllFromDisabledActions(Collection<String> items) {
    if (this.disabledActions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledActions.remove(item);
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
  
  public A removeFromDisabledActions(String... items) {
    if (this.disabledActions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.disabledActions.remove(item);
    }
    return (A) this;
  }
  
  public A setToDisabledActions(int index,String item) {
    if (this.disabledActions == null) {
      this.disabledActions = new ArrayList();
    }
    this.disabledActions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(disabledActions == null) && !(disabledActions.isEmpty())) {
        sb.append("disabledActions:");
        sb.append(disabledActions);
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
  
  public A withDisabledActions(List<String> disabledActions) {
    if (disabledActions != null) {
        this.disabledActions = new ArrayList();
        for (String item : disabledActions) {
          this.addToDisabledActions(item);
        }
    } else {
      this.disabledActions = null;
    }
    return (A) this;
  }
  
  public A withDisabledActions(String... disabledActions) {
    if (this.disabledActions != null) {
        this.disabledActions.clear();
        _visitables.remove("disabledActions");
    }
    if (disabledActions != null) {
      for (String item : disabledActions) {
        this.addToDisabledActions(item);
      }
    }
    return (A) this;
  }
  
}