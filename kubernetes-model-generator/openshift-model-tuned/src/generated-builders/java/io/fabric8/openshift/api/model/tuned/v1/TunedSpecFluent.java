package io.fabric8.openshift.api.model.tuned.v1;

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
public class TunedSpecFluent<A extends io.fabric8.openshift.api.model.tuned.v1.TunedSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String managementState;
  private ArrayList<TunedProfileBuilder> profile = new ArrayList<TunedProfileBuilder>();
  private ArrayList<TunedRecommendBuilder> recommend = new ArrayList<TunedRecommendBuilder>();

  public TunedSpecFluent() {
  }
  
  public TunedSpecFluent(TunedSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToProfile(Collection<TunedProfile> items) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").add(builder);
        this.profile.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRecommend(Collection<TunedRecommend> items) {
    if (this.recommend == null) {
      this.recommend = new ArrayList();
    }
    for (TunedRecommend item : items) {
        TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
        _visitables.get("recommend").add(builder);
        this.recommend.add(builder);
    }
    return (A) this;
  }
  
  public ProfileNested<A> addNewProfile() {
    return new ProfileNested(-1, null);
  }
  
  public A addNewProfile(String data,String name) {
    return (A) this.addToProfile(new TunedProfile(data, name));
  }
  
  public ProfileNested<A> addNewProfileLike(TunedProfile item) {
    return new ProfileNested(-1, item);
  }
  
  public RecommendNested<A> addNewRecommend() {
    return new RecommendNested(-1, null);
  }
  
  public RecommendNested<A> addNewRecommendLike(TunedRecommend item) {
    return new RecommendNested(-1, item);
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
  
  public A addToProfile(TunedProfile... items) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").add(builder);
        this.profile.add(builder);
    }
    return (A) this;
  }
  
  public A addToProfile(int index,TunedProfile item) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    TunedProfileBuilder builder = new TunedProfileBuilder(item);
    if (index < 0 || index >= profile.size()) {
        _visitables.get("profile").add(builder);
        profile.add(builder);
    } else {
        _visitables.get("profile").add(builder);
        profile.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRecommend(TunedRecommend... items) {
    if (this.recommend == null) {
      this.recommend = new ArrayList();
    }
    for (TunedRecommend item : items) {
        TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
        _visitables.get("recommend").add(builder);
        this.recommend.add(builder);
    }
    return (A) this;
  }
  
  public A addToRecommend(int index,TunedRecommend item) {
    if (this.recommend == null) {
      this.recommend = new ArrayList();
    }
    TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
    if (index < 0 || index >= recommend.size()) {
        _visitables.get("recommend").add(builder);
        recommend.add(builder);
    } else {
        _visitables.get("recommend").add(builder);
        recommend.add(index, builder);
    }
    return (A) this;
  }
  
  public TunedProfile buildFirstProfile() {
    return this.profile.get(0).build();
  }
  
  public TunedRecommend buildFirstRecommend() {
    return this.recommend.get(0).build();
  }
  
  public TunedProfile buildLastProfile() {
    return this.profile.get(profile.size() - 1).build();
  }
  
  public TunedRecommend buildLastRecommend() {
    return this.recommend.get(recommend.size() - 1).build();
  }
  
  public TunedProfile buildMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
      for (TunedProfileBuilder item : profile) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TunedRecommend buildMatchingRecommend(Predicate<TunedRecommendBuilder> predicate) {
      for (TunedRecommendBuilder item : recommend) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TunedProfile> buildProfile() {
    return this.profile != null ? build(profile) : null;
  }
  
  public TunedProfile buildProfile(int index) {
    return this.profile.get(index).build();
  }
  
  public List<TunedRecommend> buildRecommend() {
    return this.recommend != null ? build(recommend) : null;
  }
  
  public TunedRecommend buildRecommend(int index) {
    return this.recommend.get(index).build();
  }
  
  protected void copyInstance(TunedSpec instance) {
    instance = instance != null ? instance : new TunedSpec();
    if (instance != null) {
        this.withManagementState(instance.getManagementState());
        this.withProfile(instance.getProfile());
        this.withRecommend(instance.getRecommend());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProfileNested<A> editFirstProfile() {
    if (profile.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "profile"));
    }
    return this.setNewProfileLike(0, this.buildProfile(0));
  }
  
  public RecommendNested<A> editFirstRecommend() {
    if (recommend.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "recommend"));
    }
    return this.setNewRecommendLike(0, this.buildRecommend(0));
  }
  
  public ProfileNested<A> editLastProfile() {
    int index = profile.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
  }
  
  public RecommendNested<A> editLastRecommend() {
    int index = recommend.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "recommend"));
    }
    return this.setNewRecommendLike(index, this.buildRecommend(index));
  }
  
  public ProfileNested<A> editMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < profile.size();i++) {
      if (predicate.test(profile.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
  }
  
  public RecommendNested<A> editMatchingRecommend(Predicate<TunedRecommendBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < recommend.size();i++) {
      if (predicate.test(recommend.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "recommend"));
    }
    return this.setNewRecommendLike(index, this.buildRecommend(index));
  }
  
  public ProfileNested<A> editProfile(int index) {
    if (profile.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "profile"));
    }
    return this.setNewProfileLike(index, this.buildProfile(index));
  }
  
  public RecommendNested<A> editRecommend(int index) {
    if (recommend.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "recommend"));
    }
    return this.setNewRecommendLike(index, this.buildRecommend(index));
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
    TunedSpecFluent that = (TunedSpecFluent) o;
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(recommend, that.recommend))) {
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
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasMatchingProfile(Predicate<TunedProfileBuilder> predicate) {
      for (TunedProfileBuilder item : profile) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRecommend(Predicate<TunedRecommendBuilder> predicate) {
      for (TunedRecommendBuilder item : recommend) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProfile() {
    return this.profile != null && !(this.profile.isEmpty());
  }
  
  public boolean hasRecommend() {
    return this.recommend != null && !(this.recommend.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(managementState, profile, recommend, additionalProperties);
  }
  
  public A removeAllFromProfile(Collection<TunedProfile> items) {
    if (this.profile == null) {
      return (A) this;
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").remove(builder);
        this.profile.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRecommend(Collection<TunedRecommend> items) {
    if (this.recommend == null) {
      return (A) this;
    }
    for (TunedRecommend item : items) {
        TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
        _visitables.get("recommend").remove(builder);
        this.recommend.remove(builder);
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
  
  public A removeFromProfile(TunedProfile... items) {
    if (this.profile == null) {
      return (A) this;
    }
    for (TunedProfile item : items) {
        TunedProfileBuilder builder = new TunedProfileBuilder(item);
        _visitables.get("profile").remove(builder);
        this.profile.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRecommend(TunedRecommend... items) {
    if (this.recommend == null) {
      return (A) this;
    }
    for (TunedRecommend item : items) {
        TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
        _visitables.get("recommend").remove(builder);
        this.recommend.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromProfile(Predicate<TunedProfileBuilder> predicate) {
    if (profile == null) {
      return (A) this;
    }
    Iterator<TunedProfileBuilder> each = profile.iterator();
    List visitables = _visitables.get("profile");
    while (each.hasNext()) {
        TunedProfileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRecommend(Predicate<TunedRecommendBuilder> predicate) {
    if (recommend == null) {
      return (A) this;
    }
    Iterator<TunedRecommendBuilder> each = recommend.iterator();
    List visitables = _visitables.get("recommend");
    while (each.hasNext()) {
        TunedRecommendBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ProfileNested<A> setNewProfileLike(int index,TunedProfile item) {
    return new ProfileNested(index, item);
  }
  
  public RecommendNested<A> setNewRecommendLike(int index,TunedRecommend item) {
    return new RecommendNested(index, item);
  }
  
  public A setToProfile(int index,TunedProfile item) {
    if (this.profile == null) {
      this.profile = new ArrayList();
    }
    TunedProfileBuilder builder = new TunedProfileBuilder(item);
    if (index < 0 || index >= profile.size()) {
        _visitables.get("profile").add(builder);
        profile.add(builder);
    } else {
        _visitables.get("profile").add(builder);
        profile.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRecommend(int index,TunedRecommend item) {
    if (this.recommend == null) {
      this.recommend = new ArrayList();
    }
    TunedRecommendBuilder builder = new TunedRecommendBuilder(item);
    if (index < 0 || index >= recommend.size()) {
        _visitables.get("recommend").add(builder);
        recommend.add(builder);
    } else {
        _visitables.get("recommend").add(builder);
        recommend.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(profile == null) && !(profile.isEmpty())) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(recommend == null) && !(recommend.isEmpty())) {
        sb.append("recommend:");
        sb.append(recommend);
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
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public A withProfile(List<TunedProfile> profile) {
    if (this.profile != null) {
      this._visitables.get("profile").clear();
    }
    if (profile != null) {
        this.profile = new ArrayList();
        for (TunedProfile item : profile) {
          this.addToProfile(item);
        }
    } else {
      this.profile = null;
    }
    return (A) this;
  }
  
  public A withProfile(TunedProfile... profile) {
    if (this.profile != null) {
        this.profile.clear();
        _visitables.remove("profile");
    }
    if (profile != null) {
      for (TunedProfile item : profile) {
        this.addToProfile(item);
      }
    }
    return (A) this;
  }
  
  public A withRecommend(List<TunedRecommend> recommend) {
    if (this.recommend != null) {
      this._visitables.get("recommend").clear();
    }
    if (recommend != null) {
        this.recommend = new ArrayList();
        for (TunedRecommend item : recommend) {
          this.addToRecommend(item);
        }
    } else {
      this.recommend = null;
    }
    return (A) this;
  }
  
  public A withRecommend(TunedRecommend... recommend) {
    if (this.recommend != null) {
        this.recommend.clear();
        _visitables.remove("recommend");
    }
    if (recommend != null) {
      for (TunedRecommend item : recommend) {
        this.addToRecommend(item);
      }
    }
    return (A) this;
  }
  public class ProfileNested<N> extends TunedProfileFluent<ProfileNested<N>> implements Nested<N>{
  
    TunedProfileBuilder builder;
    int index;
  
    ProfileNested(int index,TunedProfile item) {
      this.index = index;
      this.builder = new TunedProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) TunedSpecFluent.this.setToProfile(index, builder.build());
    }
    
    public N endProfile() {
      return and();
    }
    
  }
  public class RecommendNested<N> extends TunedRecommendFluent<RecommendNested<N>> implements Nested<N>{
  
    TunedRecommendBuilder builder;
    int index;
  
    RecommendNested(int index,TunedRecommend item) {
      this.index = index;
      this.builder = new TunedRecommendBuilder(this, item);
    }
  
    public N and() {
      return (N) TunedSpecFluent.this.setToRecommend(index, builder.build());
    }
    
    public N endRecommend() {
      return and();
    }
    
  }
}