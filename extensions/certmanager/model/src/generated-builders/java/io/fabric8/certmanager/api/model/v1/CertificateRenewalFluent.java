package io.fabric8.certmanager.api.model.v1;

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
public class CertificateRenewalFluent<A extends io.fabric8.certmanager.api.model.v1.CertificateRenewalFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String policy;
  private ArrayList<CertificateRenewalWindowsBuilder> windows = new ArrayList<CertificateRenewalWindowsBuilder>();

  public CertificateRenewalFluent() {
  }
  
  public CertificateRenewalFluent(CertificateRenewal instance) {
    this.copyInstance(instance);
  }

  public A addAllToWindows(Collection<CertificateRenewalWindows> items) {
    if (this.windows == null) {
      this.windows = new ArrayList();
    }
    for (CertificateRenewalWindows item : items) {
        CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
        _visitables.get("windows").add(builder);
        this.windows.add(builder);
    }
    return (A) this;
  }
  
  public WindowsNested<A> addNewWindow() {
    return new WindowsNested(-1, null);
  }
  
  public WindowsNested<A> addNewWindowLike(CertificateRenewalWindows item) {
    return new WindowsNested(-1, item);
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
  
  public A addToWindows(CertificateRenewalWindows... items) {
    if (this.windows == null) {
      this.windows = new ArrayList();
    }
    for (CertificateRenewalWindows item : items) {
        CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
        _visitables.get("windows").add(builder);
        this.windows.add(builder);
    }
    return (A) this;
  }
  
  public A addToWindows(int index,CertificateRenewalWindows item) {
    if (this.windows == null) {
      this.windows = new ArrayList();
    }
    CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
    if (index < 0 || index >= windows.size()) {
        _visitables.get("windows").add(builder);
        windows.add(builder);
    } else {
        _visitables.get("windows").add(builder);
        windows.add(index, builder);
    }
    return (A) this;
  }
  
  public CertificateRenewalWindows buildFirstWindow() {
    return this.windows.get(0).build();
  }
  
  public CertificateRenewalWindows buildLastWindow() {
    return this.windows.get(windows.size() - 1).build();
  }
  
  public CertificateRenewalWindows buildMatchingWindow(Predicate<CertificateRenewalWindowsBuilder> predicate) {
      for (CertificateRenewalWindowsBuilder item : windows) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CertificateRenewalWindows buildWindow(int index) {
    return this.windows.get(index).build();
  }
  
  public List<CertificateRenewalWindows> buildWindows() {
    return this.windows != null ? build(windows) : null;
  }
  
  protected void copyInstance(CertificateRenewal instance) {
    instance = instance != null ? instance : new CertificateRenewal();
    if (instance != null) {
        this.withPolicy(instance.getPolicy());
        this.withWindows(instance.getWindows());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WindowsNested<A> editFirstWindow() {
    if (windows.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "windows"));
    }
    return this.setNewWindowLike(0, this.buildWindow(0));
  }
  
  public WindowsNested<A> editLastWindow() {
    int index = windows.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "windows"));
    }
    return this.setNewWindowLike(index, this.buildWindow(index));
  }
  
  public WindowsNested<A> editMatchingWindow(Predicate<CertificateRenewalWindowsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < windows.size();i++) {
      if (predicate.test(windows.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "windows"));
    }
    return this.setNewWindowLike(index, this.buildWindow(index));
  }
  
  public WindowsNested<A> editWindow(int index) {
    if (windows.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "windows"));
    }
    return this.setNewWindowLike(index, this.buildWindow(index));
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
    CertificateRenewalFluent that = (CertificateRenewalFluent) o;
    if (!(Objects.equals(policy, that.policy))) {
      return false;
    }
    if (!(Objects.equals(windows, that.windows))) {
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
  
  public String getPolicy() {
    return this.policy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingWindow(Predicate<CertificateRenewalWindowsBuilder> predicate) {
      for (CertificateRenewalWindowsBuilder item : windows) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicy() {
    return this.policy != null;
  }
  
  public boolean hasWindows() {
    return this.windows != null && !(this.windows.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(policy, windows, additionalProperties);
  }
  
  public A removeAllFromWindows(Collection<CertificateRenewalWindows> items) {
    if (this.windows == null) {
      return (A) this;
    }
    for (CertificateRenewalWindows item : items) {
        CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
        _visitables.get("windows").remove(builder);
        this.windows.remove(builder);
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
  
  public A removeFromWindows(CertificateRenewalWindows... items) {
    if (this.windows == null) {
      return (A) this;
    }
    for (CertificateRenewalWindows item : items) {
        CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
        _visitables.get("windows").remove(builder);
        this.windows.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromWindows(Predicate<CertificateRenewalWindowsBuilder> predicate) {
    if (windows == null) {
      return (A) this;
    }
    Iterator<CertificateRenewalWindowsBuilder> each = windows.iterator();
    List visitables = _visitables.get("windows");
    while (each.hasNext()) {
        CertificateRenewalWindowsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public WindowsNested<A> setNewWindowLike(int index,CertificateRenewalWindows item) {
    return new WindowsNested(index, item);
  }
  
  public A setToWindows(int index,CertificateRenewalWindows item) {
    if (this.windows == null) {
      this.windows = new ArrayList();
    }
    CertificateRenewalWindowsBuilder builder = new CertificateRenewalWindowsBuilder(item);
    if (index < 0 || index >= windows.size()) {
        _visitables.get("windows").add(builder);
        windows.add(builder);
    } else {
        _visitables.get("windows").add(builder);
        windows.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(policy == null)) {
        sb.append("policy:");
        sb.append(policy);
        sb.append(",");
    }
    if (!(windows == null) && !(windows.isEmpty())) {
        sb.append("windows:");
        sb.append(windows);
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
  
  public A withPolicy(String policy) {
    this.policy = policy;
    return (A) this;
  }
  
  public A withWindows(List<CertificateRenewalWindows> windows) {
    if (this.windows != null) {
      this._visitables.get("windows").clear();
    }
    if (windows != null) {
        this.windows = new ArrayList();
        for (CertificateRenewalWindows item : windows) {
          this.addToWindows(item);
        }
    } else {
      this.windows = null;
    }
    return (A) this;
  }
  
  public A withWindows(CertificateRenewalWindows... windows) {
    if (this.windows != null) {
        this.windows.clear();
        _visitables.remove("windows");
    }
    if (windows != null) {
      for (CertificateRenewalWindows item : windows) {
        this.addToWindows(item);
      }
    }
    return (A) this;
  }
  public class WindowsNested<N> extends CertificateRenewalWindowsFluent<WindowsNested<N>> implements Nested<N>{
  
    CertificateRenewalWindowsBuilder builder;
    int index;
  
    WindowsNested(int index,CertificateRenewalWindows item) {
      this.index = index;
      this.builder = new CertificateRenewalWindowsBuilder(this, item);
    }
  
    public N and() {
      return (N) CertificateRenewalFluent.this.setToWindows(index, builder.build());
    }
    
    public N endWindow() {
      return and();
    }
    
  }
}