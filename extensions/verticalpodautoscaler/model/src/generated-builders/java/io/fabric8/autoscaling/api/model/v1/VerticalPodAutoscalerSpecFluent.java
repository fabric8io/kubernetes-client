package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.autoscaling.v1.CrossVersionObjectReference;
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
public class VerticalPodAutoscalerSpecFluent<A extends io.fabric8.autoscaling.api.model.v1.VerticalPodAutoscalerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<VerticalPodAutoscalerRecommenderSelectorBuilder> recommenders = new ArrayList<VerticalPodAutoscalerRecommenderSelectorBuilder>();
  private PodResourcePolicyBuilder resourcePolicy;
  private StartupBoostBuilder startupBoost;
  private CrossVersionObjectReference targetRef;
  private PodUpdatePolicyBuilder updatePolicy;

  public VerticalPodAutoscalerSpecFluent() {
  }
  
  public VerticalPodAutoscalerSpecFluent(VerticalPodAutoscalerSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToRecommenders(Collection<VerticalPodAutoscalerRecommenderSelector> items) {
    if (this.recommenders == null) {
      this.recommenders = new ArrayList();
    }
    for (VerticalPodAutoscalerRecommenderSelector item : items) {
        VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
        _visitables.get("recommenders").add(builder);
        this.recommenders.add(builder);
    }
    return (A) this;
  }
  
  public RecommendersNested<A> addNewRecommender() {
    return new RecommendersNested(-1, null);
  }
  
  public A addNewRecommender(String name) {
    return (A) this.addToRecommenders(new VerticalPodAutoscalerRecommenderSelector(name));
  }
  
  public RecommendersNested<A> addNewRecommenderLike(VerticalPodAutoscalerRecommenderSelector item) {
    return new RecommendersNested(-1, item);
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
  
  public A addToRecommenders(VerticalPodAutoscalerRecommenderSelector... items) {
    if (this.recommenders == null) {
      this.recommenders = new ArrayList();
    }
    for (VerticalPodAutoscalerRecommenderSelector item : items) {
        VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
        _visitables.get("recommenders").add(builder);
        this.recommenders.add(builder);
    }
    return (A) this;
  }
  
  public A addToRecommenders(int index,VerticalPodAutoscalerRecommenderSelector item) {
    if (this.recommenders == null) {
      this.recommenders = new ArrayList();
    }
    VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
    if (index < 0 || index >= recommenders.size()) {
        _visitables.get("recommenders").add(builder);
        recommenders.add(builder);
    } else {
        _visitables.get("recommenders").add(builder);
        recommenders.add(index, builder);
    }
    return (A) this;
  }
  
  public VerticalPodAutoscalerRecommenderSelector buildFirstRecommender() {
    return this.recommenders.get(0).build();
  }
  
  public VerticalPodAutoscalerRecommenderSelector buildLastRecommender() {
    return this.recommenders.get(recommenders.size() - 1).build();
  }
  
  public VerticalPodAutoscalerRecommenderSelector buildMatchingRecommender(Predicate<VerticalPodAutoscalerRecommenderSelectorBuilder> predicate) {
      for (VerticalPodAutoscalerRecommenderSelectorBuilder item : recommenders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VerticalPodAutoscalerRecommenderSelector buildRecommender(int index) {
    return this.recommenders.get(index).build();
  }
  
  public List<VerticalPodAutoscalerRecommenderSelector> buildRecommenders() {
    return this.recommenders != null ? build(recommenders) : null;
  }
  
  public PodResourcePolicy buildResourcePolicy() {
    return this.resourcePolicy != null ? this.resourcePolicy.build() : null;
  }
  
  public StartupBoost buildStartupBoost() {
    return this.startupBoost != null ? this.startupBoost.build() : null;
  }
  
  public PodUpdatePolicy buildUpdatePolicy() {
    return this.updatePolicy != null ? this.updatePolicy.build() : null;
  }
  
  protected void copyInstance(VerticalPodAutoscalerSpec instance) {
    instance = instance != null ? instance : new VerticalPodAutoscalerSpec();
    if (instance != null) {
        this.withRecommenders(instance.getRecommenders());
        this.withResourcePolicy(instance.getResourcePolicy());
        this.withStartupBoost(instance.getStartupBoost());
        this.withTargetRef(instance.getTargetRef());
        this.withUpdatePolicy(instance.getUpdatePolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RecommendersNested<A> editFirstRecommender() {
    if (recommenders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "recommenders"));
    }
    return this.setNewRecommenderLike(0, this.buildRecommender(0));
  }
  
  public RecommendersNested<A> editLastRecommender() {
    int index = recommenders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "recommenders"));
    }
    return this.setNewRecommenderLike(index, this.buildRecommender(index));
  }
  
  public RecommendersNested<A> editMatchingRecommender(Predicate<VerticalPodAutoscalerRecommenderSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < recommenders.size();i++) {
      if (predicate.test(recommenders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "recommenders"));
    }
    return this.setNewRecommenderLike(index, this.buildRecommender(index));
  }
  
  public ResourcePolicyNested<A> editOrNewResourcePolicy() {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(new PodResourcePolicyBuilder().build()));
  }
  
  public ResourcePolicyNested<A> editOrNewResourcePolicyLike(PodResourcePolicy item) {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(item));
  }
  
  public StartupBoostNested<A> editOrNewStartupBoost() {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(new StartupBoostBuilder().build()));
  }
  
  public StartupBoostNested<A> editOrNewStartupBoostLike(StartupBoost item) {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(item));
  }
  
  public UpdatePolicyNested<A> editOrNewUpdatePolicy() {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(new PodUpdatePolicyBuilder().build()));
  }
  
  public UpdatePolicyNested<A> editOrNewUpdatePolicyLike(PodUpdatePolicy item) {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(item));
  }
  
  public RecommendersNested<A> editRecommender(int index) {
    if (recommenders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "recommenders"));
    }
    return this.setNewRecommenderLike(index, this.buildRecommender(index));
  }
  
  public ResourcePolicyNested<A> editResourcePolicy() {
    return this.withNewResourcePolicyLike(Optional.ofNullable(this.buildResourcePolicy()).orElse(null));
  }
  
  public StartupBoostNested<A> editStartupBoost() {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(null));
  }
  
  public UpdatePolicyNested<A> editUpdatePolicy() {
    return this.withNewUpdatePolicyLike(Optional.ofNullable(this.buildUpdatePolicy()).orElse(null));
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
    VerticalPodAutoscalerSpecFluent that = (VerticalPodAutoscalerSpecFluent) o;
    if (!(Objects.equals(recommenders, that.recommenders))) {
      return false;
    }
    if (!(Objects.equals(resourcePolicy, that.resourcePolicy))) {
      return false;
    }
    if (!(Objects.equals(startupBoost, that.startupBoost))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
      return false;
    }
    if (!(Objects.equals(updatePolicy, that.updatePolicy))) {
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
  
  public CrossVersionObjectReference getTargetRef() {
    return this.targetRef;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingRecommender(Predicate<VerticalPodAutoscalerRecommenderSelectorBuilder> predicate) {
      for (VerticalPodAutoscalerRecommenderSelectorBuilder item : recommenders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRecommenders() {
    return this.recommenders != null && !(this.recommenders.isEmpty());
  }
  
  public boolean hasResourcePolicy() {
    return this.resourcePolicy != null;
  }
  
  public boolean hasStartupBoost() {
    return this.startupBoost != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public boolean hasUpdatePolicy() {
    return this.updatePolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(recommenders, resourcePolicy, startupBoost, targetRef, updatePolicy, additionalProperties);
  }
  
  public A removeAllFromRecommenders(Collection<VerticalPodAutoscalerRecommenderSelector> items) {
    if (this.recommenders == null) {
      return (A) this;
    }
    for (VerticalPodAutoscalerRecommenderSelector item : items) {
        VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
        _visitables.get("recommenders").remove(builder);
        this.recommenders.remove(builder);
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
  
  public A removeFromRecommenders(VerticalPodAutoscalerRecommenderSelector... items) {
    if (this.recommenders == null) {
      return (A) this;
    }
    for (VerticalPodAutoscalerRecommenderSelector item : items) {
        VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
        _visitables.get("recommenders").remove(builder);
        this.recommenders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRecommenders(Predicate<VerticalPodAutoscalerRecommenderSelectorBuilder> predicate) {
    if (recommenders == null) {
      return (A) this;
    }
    Iterator<VerticalPodAutoscalerRecommenderSelectorBuilder> each = recommenders.iterator();
    List visitables = _visitables.get("recommenders");
    while (each.hasNext()) {
        VerticalPodAutoscalerRecommenderSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RecommendersNested<A> setNewRecommenderLike(int index,VerticalPodAutoscalerRecommenderSelector item) {
    return new RecommendersNested(index, item);
  }
  
  public A setToRecommenders(int index,VerticalPodAutoscalerRecommenderSelector item) {
    if (this.recommenders == null) {
      this.recommenders = new ArrayList();
    }
    VerticalPodAutoscalerRecommenderSelectorBuilder builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(item);
    if (index < 0 || index >= recommenders.size()) {
        _visitables.get("recommenders").add(builder);
        recommenders.add(builder);
    } else {
        _visitables.get("recommenders").add(builder);
        recommenders.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(recommenders == null) && !(recommenders.isEmpty())) {
        sb.append("recommenders:");
        sb.append(recommenders);
        sb.append(",");
    }
    if (!(resourcePolicy == null)) {
        sb.append("resourcePolicy:");
        sb.append(resourcePolicy);
        sb.append(",");
    }
    if (!(startupBoost == null)) {
        sb.append("startupBoost:");
        sb.append(startupBoost);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
        sb.append(",");
    }
    if (!(updatePolicy == null)) {
        sb.append("updatePolicy:");
        sb.append(updatePolicy);
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
  
  public ResourcePolicyNested<A> withNewResourcePolicy() {
    return new ResourcePolicyNested(null);
  }
  
  public ResourcePolicyNested<A> withNewResourcePolicyLike(PodResourcePolicy item) {
    return new ResourcePolicyNested(item);
  }
  
  public StartupBoostNested<A> withNewStartupBoost() {
    return new StartupBoostNested(null);
  }
  
  public StartupBoostNested<A> withNewStartupBoostLike(StartupBoost item) {
    return new StartupBoostNested(item);
  }
  
  public A withNewTargetRef(String apiVersion,String kind,String name) {
    return (A) this.withTargetRef(new CrossVersionObjectReference(apiVersion, kind, name));
  }
  
  public UpdatePolicyNested<A> withNewUpdatePolicy() {
    return new UpdatePolicyNested(null);
  }
  
  public UpdatePolicyNested<A> withNewUpdatePolicyLike(PodUpdatePolicy item) {
    return new UpdatePolicyNested(item);
  }
  
  public A withRecommenders(List<VerticalPodAutoscalerRecommenderSelector> recommenders) {
    if (this.recommenders != null) {
      this._visitables.get("recommenders").clear();
    }
    if (recommenders != null) {
        this.recommenders = new ArrayList();
        for (VerticalPodAutoscalerRecommenderSelector item : recommenders) {
          this.addToRecommenders(item);
        }
    } else {
      this.recommenders = null;
    }
    return (A) this;
  }
  
  public A withRecommenders(VerticalPodAutoscalerRecommenderSelector... recommenders) {
    if (this.recommenders != null) {
        this.recommenders.clear();
        _visitables.remove("recommenders");
    }
    if (recommenders != null) {
      for (VerticalPodAutoscalerRecommenderSelector item : recommenders) {
        this.addToRecommenders(item);
      }
    }
    return (A) this;
  }
  
  public A withResourcePolicy(PodResourcePolicy resourcePolicy) {
    this._visitables.remove("resourcePolicy");
    if (resourcePolicy != null) {
        this.resourcePolicy = new PodResourcePolicyBuilder(resourcePolicy);
        this._visitables.get("resourcePolicy").add(this.resourcePolicy);
    } else {
        this.resourcePolicy = null;
        this._visitables.get("resourcePolicy").remove(this.resourcePolicy);
    }
    return (A) this;
  }
  
  public A withStartupBoost(StartupBoost startupBoost) {
    this._visitables.remove("startupBoost");
    if (startupBoost != null) {
        this.startupBoost = new StartupBoostBuilder(startupBoost);
        this._visitables.get("startupBoost").add(this.startupBoost);
    } else {
        this.startupBoost = null;
        this._visitables.get("startupBoost").remove(this.startupBoost);
    }
    return (A) this;
  }
  
  public A withTargetRef(CrossVersionObjectReference targetRef) {
    this.targetRef = targetRef;
    return (A) this;
  }
  
  public A withUpdatePolicy(PodUpdatePolicy updatePolicy) {
    this._visitables.remove("updatePolicy");
    if (updatePolicy != null) {
        this.updatePolicy = new PodUpdatePolicyBuilder(updatePolicy);
        this._visitables.get("updatePolicy").add(this.updatePolicy);
    } else {
        this.updatePolicy = null;
        this._visitables.get("updatePolicy").remove(this.updatePolicy);
    }
    return (A) this;
  }
  public class RecommendersNested<N> extends VerticalPodAutoscalerRecommenderSelectorFluent<RecommendersNested<N>> implements Nested<N>{
  
    VerticalPodAutoscalerRecommenderSelectorBuilder builder;
    int index;
  
    RecommendersNested(int index,VerticalPodAutoscalerRecommenderSelector item) {
      this.index = index;
      this.builder = new VerticalPodAutoscalerRecommenderSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.setToRecommenders(index, builder.build());
    }
    
    public N endRecommender() {
      return and();
    }
    
  }
  public class ResourcePolicyNested<N> extends PodResourcePolicyFluent<ResourcePolicyNested<N>> implements Nested<N>{
  
    PodResourcePolicyBuilder builder;
  
    ResourcePolicyNested(PodResourcePolicy item) {
      this.builder = new PodResourcePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withResourcePolicy(builder.build());
    }
    
    public N endResourcePolicy() {
      return and();
    }
    
  }
  public class StartupBoostNested<N> extends StartupBoostFluent<StartupBoostNested<N>> implements Nested<N>{
  
    StartupBoostBuilder builder;
  
    StartupBoostNested(StartupBoost item) {
      this.builder = new StartupBoostBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withStartupBoost(builder.build());
    }
    
    public N endStartupBoost() {
      return and();
    }
    
  }
  public class UpdatePolicyNested<N> extends PodUpdatePolicyFluent<UpdatePolicyNested<N>> implements Nested<N>{
  
    PodUpdatePolicyBuilder builder;
  
    UpdatePolicyNested(PodUpdatePolicy item) {
      this.builder = new PodUpdatePolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerSpecFluent.this.withUpdatePolicy(builder.build());
    }
    
    public N endUpdatePolicy() {
      return and();
    }
    
  }
}