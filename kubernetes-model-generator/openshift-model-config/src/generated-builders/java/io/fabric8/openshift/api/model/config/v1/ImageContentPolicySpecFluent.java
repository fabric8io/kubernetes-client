package io.fabric8.openshift.api.model.config.v1;

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
public class ImageContentPolicySpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageContentPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RepositoryDigestMirrorsBuilder> repositoryDigestMirrors = new ArrayList<RepositoryDigestMirrorsBuilder>();

  public ImageContentPolicySpecFluent() {
  }
  
  public ImageContentPolicySpecFluent(ImageContentPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRepositoryDigestMirrors(Collection<RepositoryDigestMirrors> items) {
    if (this.repositoryDigestMirrors == null) {
      this.repositoryDigestMirrors = new ArrayList();
    }
    for (RepositoryDigestMirrors item : items) {
        RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
        _visitables.get("repositoryDigestMirrors").add(builder);
        this.repositoryDigestMirrors.add(builder);
    }
    return (A) this;
  }
  
  public RepositoryDigestMirrorsNested<A> addNewRepositoryDigestMirror() {
    return new RepositoryDigestMirrorsNested(-1, null);
  }
  
  public RepositoryDigestMirrorsNested<A> addNewRepositoryDigestMirrorLike(RepositoryDigestMirrors item) {
    return new RepositoryDigestMirrorsNested(-1, item);
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
  
  public A addToRepositoryDigestMirrors(RepositoryDigestMirrors... items) {
    if (this.repositoryDigestMirrors == null) {
      this.repositoryDigestMirrors = new ArrayList();
    }
    for (RepositoryDigestMirrors item : items) {
        RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
        _visitables.get("repositoryDigestMirrors").add(builder);
        this.repositoryDigestMirrors.add(builder);
    }
    return (A) this;
  }
  
  public A addToRepositoryDigestMirrors(int index,RepositoryDigestMirrors item) {
    if (this.repositoryDigestMirrors == null) {
      this.repositoryDigestMirrors = new ArrayList();
    }
    RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
    if (index < 0 || index >= repositoryDigestMirrors.size()) {
        _visitables.get("repositoryDigestMirrors").add(builder);
        repositoryDigestMirrors.add(builder);
    } else {
        _visitables.get("repositoryDigestMirrors").add(builder);
        repositoryDigestMirrors.add(index, builder);
    }
    return (A) this;
  }
  
  public RepositoryDigestMirrors buildFirstRepositoryDigestMirror() {
    return this.repositoryDigestMirrors.get(0).build();
  }
  
  public RepositoryDigestMirrors buildLastRepositoryDigestMirror() {
    return this.repositoryDigestMirrors.get(repositoryDigestMirrors.size() - 1).build();
  }
  
  public RepositoryDigestMirrors buildMatchingRepositoryDigestMirror(Predicate<RepositoryDigestMirrorsBuilder> predicate) {
      for (RepositoryDigestMirrorsBuilder item : repositoryDigestMirrors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RepositoryDigestMirrors buildRepositoryDigestMirror(int index) {
    return this.repositoryDigestMirrors.get(index).build();
  }
  
  public List<RepositoryDigestMirrors> buildRepositoryDigestMirrors() {
    return this.repositoryDigestMirrors != null ? build(repositoryDigestMirrors) : null;
  }
  
  protected void copyInstance(ImageContentPolicySpec instance) {
    instance = instance != null ? instance : new ImageContentPolicySpec();
    if (instance != null) {
        this.withRepositoryDigestMirrors(instance.getRepositoryDigestMirrors());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RepositoryDigestMirrorsNested<A> editFirstRepositoryDigestMirror() {
    if (repositoryDigestMirrors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "repositoryDigestMirrors"));
    }
    return this.setNewRepositoryDigestMirrorLike(0, this.buildRepositoryDigestMirror(0));
  }
  
  public RepositoryDigestMirrorsNested<A> editLastRepositoryDigestMirror() {
    int index = repositoryDigestMirrors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "repositoryDigestMirrors"));
    }
    return this.setNewRepositoryDigestMirrorLike(index, this.buildRepositoryDigestMirror(index));
  }
  
  public RepositoryDigestMirrorsNested<A> editMatchingRepositoryDigestMirror(Predicate<RepositoryDigestMirrorsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < repositoryDigestMirrors.size();i++) {
      if (predicate.test(repositoryDigestMirrors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "repositoryDigestMirrors"));
    }
    return this.setNewRepositoryDigestMirrorLike(index, this.buildRepositoryDigestMirror(index));
  }
  
  public RepositoryDigestMirrorsNested<A> editRepositoryDigestMirror(int index) {
    if (repositoryDigestMirrors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "repositoryDigestMirrors"));
    }
    return this.setNewRepositoryDigestMirrorLike(index, this.buildRepositoryDigestMirror(index));
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
    ImageContentPolicySpecFluent that = (ImageContentPolicySpecFluent) o;
    if (!(Objects.equals(repositoryDigestMirrors, that.repositoryDigestMirrors))) {
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
  
  public boolean hasMatchingRepositoryDigestMirror(Predicate<RepositoryDigestMirrorsBuilder> predicate) {
      for (RepositoryDigestMirrorsBuilder item : repositoryDigestMirrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRepositoryDigestMirrors() {
    return this.repositoryDigestMirrors != null && !(this.repositoryDigestMirrors.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(repositoryDigestMirrors, additionalProperties);
  }
  
  public A removeAllFromRepositoryDigestMirrors(Collection<RepositoryDigestMirrors> items) {
    if (this.repositoryDigestMirrors == null) {
      return (A) this;
    }
    for (RepositoryDigestMirrors item : items) {
        RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
        _visitables.get("repositoryDigestMirrors").remove(builder);
        this.repositoryDigestMirrors.remove(builder);
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
  
  public A removeFromRepositoryDigestMirrors(RepositoryDigestMirrors... items) {
    if (this.repositoryDigestMirrors == null) {
      return (A) this;
    }
    for (RepositoryDigestMirrors item : items) {
        RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
        _visitables.get("repositoryDigestMirrors").remove(builder);
        this.repositoryDigestMirrors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRepositoryDigestMirrors(Predicate<RepositoryDigestMirrorsBuilder> predicate) {
    if (repositoryDigestMirrors == null) {
      return (A) this;
    }
    Iterator<RepositoryDigestMirrorsBuilder> each = repositoryDigestMirrors.iterator();
    List visitables = _visitables.get("repositoryDigestMirrors");
    while (each.hasNext()) {
        RepositoryDigestMirrorsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RepositoryDigestMirrorsNested<A> setNewRepositoryDigestMirrorLike(int index,RepositoryDigestMirrors item) {
    return new RepositoryDigestMirrorsNested(index, item);
  }
  
  public A setToRepositoryDigestMirrors(int index,RepositoryDigestMirrors item) {
    if (this.repositoryDigestMirrors == null) {
      this.repositoryDigestMirrors = new ArrayList();
    }
    RepositoryDigestMirrorsBuilder builder = new RepositoryDigestMirrorsBuilder(item);
    if (index < 0 || index >= repositoryDigestMirrors.size()) {
        _visitables.get("repositoryDigestMirrors").add(builder);
        repositoryDigestMirrors.add(builder);
    } else {
        _visitables.get("repositoryDigestMirrors").add(builder);
        repositoryDigestMirrors.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(repositoryDigestMirrors == null) && !(repositoryDigestMirrors.isEmpty())) {
        sb.append("repositoryDigestMirrors:");
        sb.append(repositoryDigestMirrors);
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
  
  public A withRepositoryDigestMirrors(List<RepositoryDigestMirrors> repositoryDigestMirrors) {
    if (this.repositoryDigestMirrors != null) {
      this._visitables.get("repositoryDigestMirrors").clear();
    }
    if (repositoryDigestMirrors != null) {
        this.repositoryDigestMirrors = new ArrayList();
        for (RepositoryDigestMirrors item : repositoryDigestMirrors) {
          this.addToRepositoryDigestMirrors(item);
        }
    } else {
      this.repositoryDigestMirrors = null;
    }
    return (A) this;
  }
  
  public A withRepositoryDigestMirrors(RepositoryDigestMirrors... repositoryDigestMirrors) {
    if (this.repositoryDigestMirrors != null) {
        this.repositoryDigestMirrors.clear();
        _visitables.remove("repositoryDigestMirrors");
    }
    if (repositoryDigestMirrors != null) {
      for (RepositoryDigestMirrors item : repositoryDigestMirrors) {
        this.addToRepositoryDigestMirrors(item);
      }
    }
    return (A) this;
  }
  public class RepositoryDigestMirrorsNested<N> extends RepositoryDigestMirrorsFluent<RepositoryDigestMirrorsNested<N>> implements Nested<N>{
  
    RepositoryDigestMirrorsBuilder builder;
    int index;
  
    RepositoryDigestMirrorsNested(int index,RepositoryDigestMirrors item) {
      this.index = index;
      this.builder = new RepositoryDigestMirrorsBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageContentPolicySpecFluent.this.setToRepositoryDigestMirrors(index, builder.build());
    }
    
    public N endRepositoryDigestMirror() {
      return and();
    }
    
  }
}