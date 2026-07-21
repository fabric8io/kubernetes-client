package io.fabric8.tekton.v1alpha1;

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
public class VerificationPolicySpecFluent<A extends io.fabric8.tekton.v1alpha1.VerificationPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AuthorityBuilder> authorities = new ArrayList<AuthorityBuilder>();
  private String mode;
  private ArrayList<ResourcePatternBuilder> resources = new ArrayList<ResourcePatternBuilder>();

  public VerificationPolicySpecFluent() {
  }
  
  public VerificationPolicySpecFluent(VerificationPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAuthorities(Collection<Authority> items) {
    if (this.authorities == null) {
      this.authorities = new ArrayList();
    }
    for (Authority item : items) {
        AuthorityBuilder builder = new AuthorityBuilder(item);
        _visitables.get("authorities").add(builder);
        this.authorities.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<ResourcePattern> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (ResourcePattern item : items) {
        ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public AuthoritiesNested<A> addNewAuthority() {
    return new AuthoritiesNested(-1, null);
  }
  
  public AuthoritiesNested<A> addNewAuthorityLike(Authority item) {
    return new AuthoritiesNested(-1, item);
  }
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public A addNewResource(String pattern) {
    return (A) this.addToResources(new ResourcePattern(pattern));
  }
  
  public ResourcesNested<A> addNewResourceLike(ResourcePattern item) {
    return new ResourcesNested(-1, item);
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
  
  public A addToAuthorities(Authority... items) {
    if (this.authorities == null) {
      this.authorities = new ArrayList();
    }
    for (Authority item : items) {
        AuthorityBuilder builder = new AuthorityBuilder(item);
        _visitables.get("authorities").add(builder);
        this.authorities.add(builder);
    }
    return (A) this;
  }
  
  public A addToAuthorities(int index,Authority item) {
    if (this.authorities == null) {
      this.authorities = new ArrayList();
    }
    AuthorityBuilder builder = new AuthorityBuilder(item);
    if (index < 0 || index >= authorities.size()) {
        _visitables.get("authorities").add(builder);
        authorities.add(builder);
    } else {
        _visitables.get("authorities").add(builder);
        authorities.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResources(ResourcePattern... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (ResourcePattern item : items) {
        ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,ResourcePattern item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public List<Authority> buildAuthorities() {
    return this.authorities != null ? build(authorities) : null;
  }
  
  public Authority buildAuthority(int index) {
    return this.authorities.get(index).build();
  }
  
  public Authority buildFirstAuthority() {
    return this.authorities.get(0).build();
  }
  
  public ResourcePattern buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public Authority buildLastAuthority() {
    return this.authorities.get(authorities.size() - 1).build();
  }
  
  public ResourcePattern buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public Authority buildMatchingAuthority(Predicate<AuthorityBuilder> predicate) {
      for (AuthorityBuilder item : authorities) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourcePattern buildMatchingResource(Predicate<ResourcePatternBuilder> predicate) {
      for (ResourcePatternBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourcePattern buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<ResourcePattern> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  protected void copyInstance(VerificationPolicySpec instance) {
    instance = instance != null ? instance : new VerificationPolicySpec();
    if (instance != null) {
        this.withAuthorities(instance.getAuthorities());
        this.withMode(instance.getMode());
        this.withResources(instance.getResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthoritiesNested<A> editAuthority(int index) {
    if (authorities.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "authorities"));
    }
    return this.setNewAuthorityLike(index, this.buildAuthority(index));
  }
  
  public AuthoritiesNested<A> editFirstAuthority() {
    if (authorities.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "authorities"));
    }
    return this.setNewAuthorityLike(0, this.buildAuthority(0));
  }
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public AuthoritiesNested<A> editLastAuthority() {
    int index = authorities.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "authorities"));
    }
    return this.setNewAuthorityLike(index, this.buildAuthority(index));
  }
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public AuthoritiesNested<A> editMatchingAuthority(Predicate<AuthorityBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < authorities.size();i++) {
      if (predicate.test(authorities.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "authorities"));
    }
    return this.setNewAuthorityLike(index, this.buildAuthority(index));
  }
  
  public ResourcesNested<A> editMatchingResource(Predicate<ResourcePatternBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resources.size();i++) {
      if (predicate.test(resources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
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
    VerificationPolicySpecFluent that = (VerificationPolicySpecFluent) o;
    if (!(Objects.equals(authorities, that.authorities))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorities() {
    return this.authorities != null && !(this.authorities.isEmpty());
  }
  
  public boolean hasMatchingAuthority(Predicate<AuthorityBuilder> predicate) {
      for (AuthorityBuilder item : authorities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<ResourcePatternBuilder> predicate) {
      for (ResourcePatternBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(authorities, mode, resources, additionalProperties);
  }
  
  public A removeAllFromAuthorities(Collection<Authority> items) {
    if (this.authorities == null) {
      return (A) this;
    }
    for (Authority item : items) {
        AuthorityBuilder builder = new AuthorityBuilder(item);
        _visitables.get("authorities").remove(builder);
        this.authorities.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<ResourcePattern> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (ResourcePattern item : items) {
        ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
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
  
  public A removeFromAuthorities(Authority... items) {
    if (this.authorities == null) {
      return (A) this;
    }
    for (Authority item : items) {
        AuthorityBuilder builder = new AuthorityBuilder(item);
        _visitables.get("authorities").remove(builder);
        this.authorities.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResources(ResourcePattern... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (ResourcePattern item : items) {
        ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAuthorities(Predicate<AuthorityBuilder> predicate) {
    if (authorities == null) {
      return (A) this;
    }
    Iterator<AuthorityBuilder> each = authorities.iterator();
    List visitables = _visitables.get("authorities");
    while (each.hasNext()) {
        AuthorityBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResources(Predicate<ResourcePatternBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<ResourcePatternBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        ResourcePatternBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AuthoritiesNested<A> setNewAuthorityLike(int index,Authority item) {
    return new AuthoritiesNested(index, item);
  }
  
  public ResourcesNested<A> setNewResourceLike(int index,ResourcePattern item) {
    return new ResourcesNested(index, item);
  }
  
  public A setToAuthorities(int index,Authority item) {
    if (this.authorities == null) {
      this.authorities = new ArrayList();
    }
    AuthorityBuilder builder = new AuthorityBuilder(item);
    if (index < 0 || index >= authorities.size()) {
        _visitables.get("authorities").add(builder);
        authorities.add(builder);
    } else {
        _visitables.get("authorities").add(builder);
        authorities.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,ResourcePattern item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    ResourcePatternBuilder builder = new ResourcePatternBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authorities == null) && !(authorities.isEmpty())) {
        sb.append("authorities:");
        sb.append(authorities);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
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
  
  public A withAuthorities(List<Authority> authorities) {
    if (this.authorities != null) {
      this._visitables.get("authorities").clear();
    }
    if (authorities != null) {
        this.authorities = new ArrayList();
        for (Authority item : authorities) {
          this.addToAuthorities(item);
        }
    } else {
      this.authorities = null;
    }
    return (A) this;
  }
  
  public A withAuthorities(Authority... authorities) {
    if (this.authorities != null) {
        this.authorities.clear();
        _visitables.remove("authorities");
    }
    if (authorities != null) {
      for (Authority item : authorities) {
        this.addToAuthorities(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withResources(List<ResourcePattern> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (ResourcePattern item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(ResourcePattern... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (ResourcePattern item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  public class AuthoritiesNested<N> extends AuthorityFluent<AuthoritiesNested<N>> implements Nested<N>{
  
    AuthorityBuilder builder;
    int index;
  
    AuthoritiesNested(int index,Authority item) {
      this.index = index;
      this.builder = new AuthorityBuilder(this, item);
    }
  
    public N and() {
      return (N) VerificationPolicySpecFluent.this.setToAuthorities(index, builder.build());
    }
    
    public N endAuthority() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourcePatternFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourcePatternBuilder builder;
    int index;
  
    ResourcesNested(int index,ResourcePattern item) {
      this.index = index;
      this.builder = new ResourcePatternBuilder(this, item);
    }
  
    public N and() {
      return (N) VerificationPolicySpecFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
}