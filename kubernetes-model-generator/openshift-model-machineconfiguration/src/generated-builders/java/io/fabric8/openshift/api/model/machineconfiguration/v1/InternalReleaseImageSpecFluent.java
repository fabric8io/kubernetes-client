package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class InternalReleaseImageSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.InternalReleaseImageSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<InternalReleaseImageRefBuilder> releases = new ArrayList<InternalReleaseImageRefBuilder>();

  public InternalReleaseImageSpecFluent() {
  }
  
  public InternalReleaseImageSpecFluent(InternalReleaseImageSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToReleases(Collection<InternalReleaseImageRef> items) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    for (InternalReleaseImageRef item : items) {
        InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
        _visitables.get("releases").add(builder);
        this.releases.add(builder);
    }
    return (A) this;
  }
  
  public ReleasesNested<A> addNewRelease() {
    return new ReleasesNested(-1, null);
  }
  
  public A addNewRelease(String name) {
    return (A) this.addToReleases(new InternalReleaseImageRef(name));
  }
  
  public ReleasesNested<A> addNewReleaseLike(InternalReleaseImageRef item) {
    return new ReleasesNested(-1, item);
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
  
  public A addToReleases(InternalReleaseImageRef... items) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    for (InternalReleaseImageRef item : items) {
        InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
        _visitables.get("releases").add(builder);
        this.releases.add(builder);
    }
    return (A) this;
  }
  
  public A addToReleases(int index,InternalReleaseImageRef item) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
    if (index < 0 || index >= releases.size()) {
        _visitables.get("releases").add(builder);
        releases.add(builder);
    } else {
        _visitables.get("releases").add(builder);
        releases.add(index, builder);
    }
    return (A) this;
  }
  
  public InternalReleaseImageRef buildFirstRelease() {
    return this.releases.get(0).build();
  }
  
  public InternalReleaseImageRef buildLastRelease() {
    return this.releases.get(releases.size() - 1).build();
  }
  
  public InternalReleaseImageRef buildMatchingRelease(Predicate<InternalReleaseImageRefBuilder> predicate) {
      for (InternalReleaseImageRefBuilder item : releases) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InternalReleaseImageRef buildRelease(int index) {
    return this.releases.get(index).build();
  }
  
  public List<InternalReleaseImageRef> buildReleases() {
    return this.releases != null ? build(releases) : null;
  }
  
  protected void copyInstance(InternalReleaseImageSpec instance) {
    instance = instance != null ? instance : new InternalReleaseImageSpec();
    if (instance != null) {
        this.withReleases(instance.getReleases());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReleasesNested<A> editFirstRelease() {
    if (releases.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "releases"));
    }
    return this.setNewReleaseLike(0, this.buildRelease(0));
  }
  
  public ReleasesNested<A> editLastRelease() {
    int index = releases.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
  }
  
  public ReleasesNested<A> editMatchingRelease(Predicate<InternalReleaseImageRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < releases.size();i++) {
      if (predicate.test(releases.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
  }
  
  public ReleasesNested<A> editRelease(int index) {
    if (releases.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "releases"));
    }
    return this.setNewReleaseLike(index, this.buildRelease(index));
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
    InternalReleaseImageSpecFluent that = (InternalReleaseImageSpecFluent) o;
    if (!(Objects.equals(releases, that.releases))) {
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
  
  public boolean hasMatchingRelease(Predicate<InternalReleaseImageRefBuilder> predicate) {
      for (InternalReleaseImageRefBuilder item : releases) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReleases() {
    return this.releases != null && !(this.releases.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(releases, additionalProperties);
  }
  
  public A removeAllFromReleases(Collection<InternalReleaseImageRef> items) {
    if (this.releases == null) {
      return (A) this;
    }
    for (InternalReleaseImageRef item : items) {
        InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
        _visitables.get("releases").remove(builder);
        this.releases.remove(builder);
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
  
  public A removeFromReleases(InternalReleaseImageRef... items) {
    if (this.releases == null) {
      return (A) this;
    }
    for (InternalReleaseImageRef item : items) {
        InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
        _visitables.get("releases").remove(builder);
        this.releases.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromReleases(Predicate<InternalReleaseImageRefBuilder> predicate) {
    if (releases == null) {
      return (A) this;
    }
    Iterator<InternalReleaseImageRefBuilder> each = releases.iterator();
    List visitables = _visitables.get("releases");
    while (each.hasNext()) {
        InternalReleaseImageRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ReleasesNested<A> setNewReleaseLike(int index,InternalReleaseImageRef item) {
    return new ReleasesNested(index, item);
  }
  
  public A setToReleases(int index,InternalReleaseImageRef item) {
    if (this.releases == null) {
      this.releases = new ArrayList();
    }
    InternalReleaseImageRefBuilder builder = new InternalReleaseImageRefBuilder(item);
    if (index < 0 || index >= releases.size()) {
        _visitables.get("releases").add(builder);
        releases.add(builder);
    } else {
        _visitables.get("releases").add(builder);
        releases.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(releases == null) && !(releases.isEmpty())) {
        sb.append("releases:");
        sb.append(releases);
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
  
  public A withReleases(List<InternalReleaseImageRef> releases) {
    if (this.releases != null) {
      this._visitables.get("releases").clear();
    }
    if (releases != null) {
        this.releases = new ArrayList();
        for (InternalReleaseImageRef item : releases) {
          this.addToReleases(item);
        }
    } else {
      this.releases = null;
    }
    return (A) this;
  }
  
  public A withReleases(InternalReleaseImageRef... releases) {
    if (this.releases != null) {
        this.releases.clear();
        _visitables.remove("releases");
    }
    if (releases != null) {
      for (InternalReleaseImageRef item : releases) {
        this.addToReleases(item);
      }
    }
    return (A) this;
  }
  public class ReleasesNested<N> extends InternalReleaseImageRefFluent<ReleasesNested<N>> implements Nested<N>{
  
    InternalReleaseImageRefBuilder builder;
    int index;
  
    ReleasesNested(int index,InternalReleaseImageRef item) {
      this.index = index;
      this.builder = new InternalReleaseImageRefBuilder(this, item);
    }
  
    public N and() {
      return (N) InternalReleaseImageSpecFluent.this.setToReleases(index, builder.build());
    }
    
    public N endRelease() {
      return and();
    }
    
  }
}