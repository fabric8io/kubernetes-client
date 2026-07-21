package io.fabric8.tekton.triggers.v1alpha1;

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
public class CELInterceptorFluent<A extends io.fabric8.tekton.triggers.v1alpha1.CELInterceptorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String filter;
  private ArrayList<CELOverlayBuilder> overlays = new ArrayList<CELOverlayBuilder>();

  public CELInterceptorFluent() {
  }
  
  public CELInterceptorFluent(CELInterceptor instance) {
    this.copyInstance(instance);
  }

  public A addAllToOverlays(Collection<CELOverlay> items) {
    if (this.overlays == null) {
      this.overlays = new ArrayList();
    }
    for (CELOverlay item : items) {
        CELOverlayBuilder builder = new CELOverlayBuilder(item);
        _visitables.get("overlays").add(builder);
        this.overlays.add(builder);
    }
    return (A) this;
  }
  
  public OverlaysNested<A> addNewOverlay() {
    return new OverlaysNested(-1, null);
  }
  
  public A addNewOverlay(String expression,String key) {
    return (A) this.addToOverlays(new CELOverlay(expression, key));
  }
  
  public OverlaysNested<A> addNewOverlayLike(CELOverlay item) {
    return new OverlaysNested(-1, item);
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
  
  public A addToOverlays(CELOverlay... items) {
    if (this.overlays == null) {
      this.overlays = new ArrayList();
    }
    for (CELOverlay item : items) {
        CELOverlayBuilder builder = new CELOverlayBuilder(item);
        _visitables.get("overlays").add(builder);
        this.overlays.add(builder);
    }
    return (A) this;
  }
  
  public A addToOverlays(int index,CELOverlay item) {
    if (this.overlays == null) {
      this.overlays = new ArrayList();
    }
    CELOverlayBuilder builder = new CELOverlayBuilder(item);
    if (index < 0 || index >= overlays.size()) {
        _visitables.get("overlays").add(builder);
        overlays.add(builder);
    } else {
        _visitables.get("overlays").add(builder);
        overlays.add(index, builder);
    }
    return (A) this;
  }
  
  public CELOverlay buildFirstOverlay() {
    return this.overlays.get(0).build();
  }
  
  public CELOverlay buildLastOverlay() {
    return this.overlays.get(overlays.size() - 1).build();
  }
  
  public CELOverlay buildMatchingOverlay(Predicate<CELOverlayBuilder> predicate) {
      for (CELOverlayBuilder item : overlays) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CELOverlay buildOverlay(int index) {
    return this.overlays.get(index).build();
  }
  
  public List<CELOverlay> buildOverlays() {
    return this.overlays != null ? build(overlays) : null;
  }
  
  protected void copyInstance(CELInterceptor instance) {
    instance = instance != null ? instance : new CELInterceptor();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withOverlays(instance.getOverlays());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OverlaysNested<A> editFirstOverlay() {
    if (overlays.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "overlays"));
    }
    return this.setNewOverlayLike(0, this.buildOverlay(0));
  }
  
  public OverlaysNested<A> editLastOverlay() {
    int index = overlays.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "overlays"));
    }
    return this.setNewOverlayLike(index, this.buildOverlay(index));
  }
  
  public OverlaysNested<A> editMatchingOverlay(Predicate<CELOverlayBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < overlays.size();i++) {
      if (predicate.test(overlays.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "overlays"));
    }
    return this.setNewOverlayLike(index, this.buildOverlay(index));
  }
  
  public OverlaysNested<A> editOverlay(int index) {
    if (overlays.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "overlays"));
    }
    return this.setNewOverlayLike(index, this.buildOverlay(index));
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
    CELInterceptorFluent that = (CELInterceptorFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(overlays, that.overlays))) {
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
  
  public String getFilter() {
    return this.filter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasMatchingOverlay(Predicate<CELOverlayBuilder> predicate) {
      for (CELOverlayBuilder item : overlays) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOverlays() {
    return this.overlays != null && !(this.overlays.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(filter, overlays, additionalProperties);
  }
  
  public A removeAllFromOverlays(Collection<CELOverlay> items) {
    if (this.overlays == null) {
      return (A) this;
    }
    for (CELOverlay item : items) {
        CELOverlayBuilder builder = new CELOverlayBuilder(item);
        _visitables.get("overlays").remove(builder);
        this.overlays.remove(builder);
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
  
  public A removeFromOverlays(CELOverlay... items) {
    if (this.overlays == null) {
      return (A) this;
    }
    for (CELOverlay item : items) {
        CELOverlayBuilder builder = new CELOverlayBuilder(item);
        _visitables.get("overlays").remove(builder);
        this.overlays.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOverlays(Predicate<CELOverlayBuilder> predicate) {
    if (overlays == null) {
      return (A) this;
    }
    Iterator<CELOverlayBuilder> each = overlays.iterator();
    List visitables = _visitables.get("overlays");
    while (each.hasNext()) {
        CELOverlayBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OverlaysNested<A> setNewOverlayLike(int index,CELOverlay item) {
    return new OverlaysNested(index, item);
  }
  
  public A setToOverlays(int index,CELOverlay item) {
    if (this.overlays == null) {
      this.overlays = new ArrayList();
    }
    CELOverlayBuilder builder = new CELOverlayBuilder(item);
    if (index < 0 || index >= overlays.size()) {
        _visitables.get("overlays").add(builder);
        overlays.add(builder);
    } else {
        _visitables.get("overlays").add(builder);
        overlays.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(overlays == null) && !(overlays.isEmpty())) {
        sb.append("overlays:");
        sb.append(overlays);
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
  
  public A withFilter(String filter) {
    this.filter = filter;
    return (A) this;
  }
  
  public A withOverlays(List<CELOverlay> overlays) {
    if (this.overlays != null) {
      this._visitables.get("overlays").clear();
    }
    if (overlays != null) {
        this.overlays = new ArrayList();
        for (CELOverlay item : overlays) {
          this.addToOverlays(item);
        }
    } else {
      this.overlays = null;
    }
    return (A) this;
  }
  
  public A withOverlays(CELOverlay... overlays) {
    if (this.overlays != null) {
        this.overlays.clear();
        _visitables.remove("overlays");
    }
    if (overlays != null) {
      for (CELOverlay item : overlays) {
        this.addToOverlays(item);
      }
    }
    return (A) this;
  }
  public class OverlaysNested<N> extends CELOverlayFluent<OverlaysNested<N>> implements Nested<N>{
  
    CELOverlayBuilder builder;
    int index;
  
    OverlaysNested(int index,CELOverlay item) {
      this.index = index;
      this.builder = new CELOverlayBuilder(this, item);
    }
  
    public N and() {
      return (N) CELInterceptorFluent.this.setToOverlays(index, builder.build());
    }
    
    public N endOverlay() {
      return and();
    }
    
  }
}