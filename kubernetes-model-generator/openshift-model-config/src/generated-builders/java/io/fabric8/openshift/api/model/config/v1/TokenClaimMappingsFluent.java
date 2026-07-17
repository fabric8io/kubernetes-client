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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class TokenClaimMappingsFluent<A extends io.fabric8.openshift.api.model.config.v1.TokenClaimMappingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ExtraMappingBuilder> extra = new ArrayList<ExtraMappingBuilder>();
  private PrefixedClaimMappingBuilder groups;
  private TokenClaimOrExpressionMappingBuilder uid;
  private UsernameClaimMappingBuilder username;

  public TokenClaimMappingsFluent() {
  }
  
  public TokenClaimMappingsFluent(TokenClaimMappings instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtra(Collection<ExtraMapping> items) {
    if (this.extra == null) {
      this.extra = new ArrayList();
    }
    for (ExtraMapping item : items) {
        ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
        _visitables.get("extra").add(builder);
        this.extra.add(builder);
    }
    return (A) this;
  }
  
  public ExtraNested<A> addNewExtra() {
    return new ExtraNested(-1, null);
  }
  
  public A addNewExtra(String key,String valueExpression) {
    return (A) this.addToExtra(new ExtraMapping(key, valueExpression));
  }
  
  public ExtraNested<A> addNewExtraLike(ExtraMapping item) {
    return new ExtraNested(-1, item);
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
  
  public A addToExtra(ExtraMapping... items) {
    if (this.extra == null) {
      this.extra = new ArrayList();
    }
    for (ExtraMapping item : items) {
        ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
        _visitables.get("extra").add(builder);
        this.extra.add(builder);
    }
    return (A) this;
  }
  
  public A addToExtra(int index,ExtraMapping item) {
    if (this.extra == null) {
      this.extra = new ArrayList();
    }
    ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
    if (index < 0 || index >= extra.size()) {
        _visitables.get("extra").add(builder);
        extra.add(builder);
    } else {
        _visitables.get("extra").add(builder);
        extra.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ExtraMapping> buildExtra() {
    return this.extra != null ? build(extra) : null;
  }
  
  public ExtraMapping buildExtra(int index) {
    return this.extra.get(index).build();
  }
  
  public ExtraMapping buildFirstExtra() {
    return this.extra.get(0).build();
  }
  
  public PrefixedClaimMapping buildGroups() {
    return this.groups != null ? this.groups.build() : null;
  }
  
  public ExtraMapping buildLastExtra() {
    return this.extra.get(extra.size() - 1).build();
  }
  
  public ExtraMapping buildMatchingExtra(Predicate<ExtraMappingBuilder> predicate) {
      for (ExtraMappingBuilder item : extra) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TokenClaimOrExpressionMapping buildUid() {
    return this.uid != null ? this.uid.build() : null;
  }
  
  public UsernameClaimMapping buildUsername() {
    return this.username != null ? this.username.build() : null;
  }
  
  protected void copyInstance(TokenClaimMappings instance) {
    instance = instance != null ? instance : new TokenClaimMappings();
    if (instance != null) {
        this.withExtra(instance.getExtra());
        this.withGroups(instance.getGroups());
        this.withUid(instance.getUid());
        this.withUsername(instance.getUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtraNested<A> editExtra(int index) {
    if (extra.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extra"));
    }
    return this.setNewExtraLike(index, this.buildExtra(index));
  }
  
  public ExtraNested<A> editFirstExtra() {
    if (extra.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extra"));
    }
    return this.setNewExtraLike(0, this.buildExtra(0));
  }
  
  public GroupsNested<A> editGroups() {
    return this.withNewGroupsLike(Optional.ofNullable(this.buildGroups()).orElse(null));
  }
  
  public ExtraNested<A> editLastExtra() {
    int index = extra.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extra"));
    }
    return this.setNewExtraLike(index, this.buildExtra(index));
  }
  
  public ExtraNested<A> editMatchingExtra(Predicate<ExtraMappingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < extra.size();i++) {
      if (predicate.test(extra.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "extra"));
    }
    return this.setNewExtraLike(index, this.buildExtra(index));
  }
  
  public GroupsNested<A> editOrNewGroups() {
    return this.withNewGroupsLike(Optional.ofNullable(this.buildGroups()).orElse(new PrefixedClaimMappingBuilder().build()));
  }
  
  public GroupsNested<A> editOrNewGroupsLike(PrefixedClaimMapping item) {
    return this.withNewGroupsLike(Optional.ofNullable(this.buildGroups()).orElse(item));
  }
  
  public UidNested<A> editOrNewUid() {
    return this.withNewUidLike(Optional.ofNullable(this.buildUid()).orElse(new TokenClaimOrExpressionMappingBuilder().build()));
  }
  
  public UidNested<A> editOrNewUidLike(TokenClaimOrExpressionMapping item) {
    return this.withNewUidLike(Optional.ofNullable(this.buildUid()).orElse(item));
  }
  
  public UsernameNested<A> editOrNewUsername() {
    return this.withNewUsernameLike(Optional.ofNullable(this.buildUsername()).orElse(new UsernameClaimMappingBuilder().build()));
  }
  
  public UsernameNested<A> editOrNewUsernameLike(UsernameClaimMapping item) {
    return this.withNewUsernameLike(Optional.ofNullable(this.buildUsername()).orElse(item));
  }
  
  public UidNested<A> editUid() {
    return this.withNewUidLike(Optional.ofNullable(this.buildUid()).orElse(null));
  }
  
  public UsernameNested<A> editUsername() {
    return this.withNewUsernameLike(Optional.ofNullable(this.buildUsername()).orElse(null));
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
    TokenClaimMappingsFluent that = (TokenClaimMappingsFluent) o;
    if (!(Objects.equals(extra, that.extra))) {
      return false;
    }
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public boolean hasExtra() {
    return this.extra != null && !(this.extra.isEmpty());
  }
  
  public boolean hasGroups() {
    return this.groups != null;
  }
  
  public boolean hasMatchingExtra(Predicate<ExtraMappingBuilder> predicate) {
      for (ExtraMappingBuilder item : extra) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(extra, groups, uid, username, additionalProperties);
  }
  
  public A removeAllFromExtra(Collection<ExtraMapping> items) {
    if (this.extra == null) {
      return (A) this;
    }
    for (ExtraMapping item : items) {
        ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
        _visitables.get("extra").remove(builder);
        this.extra.remove(builder);
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
  
  public A removeFromExtra(ExtraMapping... items) {
    if (this.extra == null) {
      return (A) this;
    }
    for (ExtraMapping item : items) {
        ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
        _visitables.get("extra").remove(builder);
        this.extra.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExtra(Predicate<ExtraMappingBuilder> predicate) {
    if (extra == null) {
      return (A) this;
    }
    Iterator<ExtraMappingBuilder> each = extra.iterator();
    List visitables = _visitables.get("extra");
    while (each.hasNext()) {
        ExtraMappingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExtraNested<A> setNewExtraLike(int index,ExtraMapping item) {
    return new ExtraNested(index, item);
  }
  
  public A setToExtra(int index,ExtraMapping item) {
    if (this.extra == null) {
      this.extra = new ArrayList();
    }
    ExtraMappingBuilder builder = new ExtraMappingBuilder(item);
    if (index < 0 || index >= extra.size()) {
        _visitables.get("extra").add(builder);
        extra.add(builder);
    } else {
        _visitables.get("extra").add(builder);
        extra.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(extra == null) && !(extra.isEmpty())) {
        sb.append("extra:");
        sb.append(extra);
        sb.append(",");
    }
    if (!(groups == null)) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withExtra(List<ExtraMapping> extra) {
    if (this.extra != null) {
      this._visitables.get("extra").clear();
    }
    if (extra != null) {
        this.extra = new ArrayList();
        for (ExtraMapping item : extra) {
          this.addToExtra(item);
        }
    } else {
      this.extra = null;
    }
    return (A) this;
  }
  
  public A withExtra(ExtraMapping... extra) {
    if (this.extra != null) {
        this.extra.clear();
        _visitables.remove("extra");
    }
    if (extra != null) {
      for (ExtraMapping item : extra) {
        this.addToExtra(item);
      }
    }
    return (A) this;
  }
  
  public A withGroups(PrefixedClaimMapping groups) {
    this._visitables.remove("groups");
    if (groups != null) {
        this.groups = new PrefixedClaimMappingBuilder(groups);
        this._visitables.get("groups").add(this.groups);
    } else {
        this.groups = null;
        this._visitables.get("groups").remove(this.groups);
    }
    return (A) this;
  }
  
  public GroupsNested<A> withNewGroups() {
    return new GroupsNested(null);
  }
  
  public A withNewGroups(String claim,String prefix) {
    return (A) this.withGroups(new PrefixedClaimMapping(claim, prefix));
  }
  
  public GroupsNested<A> withNewGroupsLike(PrefixedClaimMapping item) {
    return new GroupsNested(item);
  }
  
  public UidNested<A> withNewUid() {
    return new UidNested(null);
  }
  
  public A withNewUid(String claim,String expression) {
    return (A) this.withUid(new TokenClaimOrExpressionMapping(claim, expression));
  }
  
  public UidNested<A> withNewUidLike(TokenClaimOrExpressionMapping item) {
    return new UidNested(item);
  }
  
  public UsernameNested<A> withNewUsername() {
    return new UsernameNested(null);
  }
  
  public UsernameNested<A> withNewUsernameLike(UsernameClaimMapping item) {
    return new UsernameNested(item);
  }
  
  public A withUid(TokenClaimOrExpressionMapping uid) {
    this._visitables.remove("uid");
    if (uid != null) {
        this.uid = new TokenClaimOrExpressionMappingBuilder(uid);
        this._visitables.get("uid").add(this.uid);
    } else {
        this.uid = null;
        this._visitables.get("uid").remove(this.uid);
    }
    return (A) this;
  }
  
  public A withUsername(UsernameClaimMapping username) {
    this._visitables.remove("username");
    if (username != null) {
        this.username = new UsernameClaimMappingBuilder(username);
        this._visitables.get("username").add(this.username);
    } else {
        this.username = null;
        this._visitables.get("username").remove(this.username);
    }
    return (A) this;
  }
  public class ExtraNested<N> extends ExtraMappingFluent<ExtraNested<N>> implements Nested<N>{
  
    ExtraMappingBuilder builder;
    int index;
  
    ExtraNested(int index,ExtraMapping item) {
      this.index = index;
      this.builder = new ExtraMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenClaimMappingsFluent.this.setToExtra(index, builder.build());
    }
    
    public N endExtra() {
      return and();
    }
    
  }
  public class GroupsNested<N> extends PrefixedClaimMappingFluent<GroupsNested<N>> implements Nested<N>{
  
    PrefixedClaimMappingBuilder builder;
  
    GroupsNested(PrefixedClaimMapping item) {
      this.builder = new PrefixedClaimMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenClaimMappingsFluent.this.withGroups(builder.build());
    }
    
    public N endGroups() {
      return and();
    }
    
  }
  public class UidNested<N> extends TokenClaimOrExpressionMappingFluent<UidNested<N>> implements Nested<N>{
  
    TokenClaimOrExpressionMappingBuilder builder;
  
    UidNested(TokenClaimOrExpressionMapping item) {
      this.builder = new TokenClaimOrExpressionMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenClaimMappingsFluent.this.withUid(builder.build());
    }
    
    public N endUid() {
      return and();
    }
    
  }
  public class UsernameNested<N> extends UsernameClaimMappingFluent<UsernameNested<N>> implements Nested<N>{
  
    UsernameClaimMappingBuilder builder;
  
    UsernameNested(UsernameClaimMapping item) {
      this.builder = new UsernameClaimMappingBuilder(this, item);
    }
  
    public N and() {
      return (N) TokenClaimMappingsFluent.this.withUsername(builder.build());
    }
    
    public N endUsername() {
      return and();
    }
    
  }
}