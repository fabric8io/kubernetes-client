package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluent;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecFluent;
import java.lang.Integer;
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
public class StatefulSetSpecFluent<A extends io.fabric8.kubernetes.api.model.apps.StatefulSetSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minReadySeconds;
  private StatefulSetOrdinalsBuilder ordinals;
  private StatefulSetPersistentVolumeClaimRetentionPolicyBuilder persistentVolumeClaimRetentionPolicy;
  private String podManagementPolicy;
  private Integer replicas;
  private Integer revisionHistoryLimit;
  private LabelSelectorBuilder selector;
  private String serviceName;
  private PodTemplateSpecBuilder template;
  private StatefulSetUpdateStrategyBuilder updateStrategy;
  private ArrayList<PersistentVolumeClaimBuilder> volumeClaimTemplates = new ArrayList<PersistentVolumeClaimBuilder>();

  public StatefulSetSpecFluent() {
  }
  
  public StatefulSetSpecFluent(StatefulSetSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToVolumeClaimTemplates(Collection<PersistentVolumeClaim> items) {
    if (this.volumeClaimTemplates == null) {
      this.volumeClaimTemplates = new ArrayList();
    }
    for (PersistentVolumeClaim item : items) {
        PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
        _visitables.get("volumeClaimTemplates").add(builder);
        this.volumeClaimTemplates.add(builder);
    }
    return (A) this;
  }
  
  public VolumeClaimTemplatesNested<A> addNewVolumeClaimTemplate() {
    return new VolumeClaimTemplatesNested(-1, null);
  }
  
  public VolumeClaimTemplatesNested<A> addNewVolumeClaimTemplateLike(PersistentVolumeClaim item) {
    return new VolumeClaimTemplatesNested(-1, item);
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
  
  public A addToVolumeClaimTemplates(PersistentVolumeClaim... items) {
    if (this.volumeClaimTemplates == null) {
      this.volumeClaimTemplates = new ArrayList();
    }
    for (PersistentVolumeClaim item : items) {
        PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
        _visitables.get("volumeClaimTemplates").add(builder);
        this.volumeClaimTemplates.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumeClaimTemplates(int index,PersistentVolumeClaim item) {
    if (this.volumeClaimTemplates == null) {
      this.volumeClaimTemplates = new ArrayList();
    }
    PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
    if (index < 0 || index >= volumeClaimTemplates.size()) {
        _visitables.get("volumeClaimTemplates").add(builder);
        volumeClaimTemplates.add(builder);
    } else {
        _visitables.get("volumeClaimTemplates").add(builder);
        volumeClaimTemplates.add(index, builder);
    }
    return (A) this;
  }
  
  public PersistentVolumeClaim buildFirstVolumeClaimTemplate() {
    return this.volumeClaimTemplates.get(0).build();
  }
  
  public PersistentVolumeClaim buildLastVolumeClaimTemplate() {
    return this.volumeClaimTemplates.get(volumeClaimTemplates.size() - 1).build();
  }
  
  public PersistentVolumeClaim buildMatchingVolumeClaimTemplate(Predicate<PersistentVolumeClaimBuilder> predicate) {
      for (PersistentVolumeClaimBuilder item : volumeClaimTemplates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StatefulSetOrdinals buildOrdinals() {
    return this.ordinals != null ? this.ordinals.build() : null;
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicy buildPersistentVolumeClaimRetentionPolicy() {
    return this.persistentVolumeClaimRetentionPolicy != null ? this.persistentVolumeClaimRetentionPolicy.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PodTemplateSpec buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  public StatefulSetUpdateStrategy buildUpdateStrategy() {
    return this.updateStrategy != null ? this.updateStrategy.build() : null;
  }
  
  public PersistentVolumeClaim buildVolumeClaimTemplate(int index) {
    return this.volumeClaimTemplates.get(index).build();
  }
  
  public List<PersistentVolumeClaim> buildVolumeClaimTemplates() {
    return this.volumeClaimTemplates != null ? build(volumeClaimTemplates) : null;
  }
  
  protected void copyInstance(StatefulSetSpec instance) {
    instance = instance != null ? instance : new StatefulSetSpec();
    if (instance != null) {
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withOrdinals(instance.getOrdinals());
        this.withPersistentVolumeClaimRetentionPolicy(instance.getPersistentVolumeClaimRetentionPolicy());
        this.withPodManagementPolicy(instance.getPodManagementPolicy());
        this.withReplicas(instance.getReplicas());
        this.withRevisionHistoryLimit(instance.getRevisionHistoryLimit());
        this.withSelector(instance.getSelector());
        this.withServiceName(instance.getServiceName());
        this.withTemplate(instance.getTemplate());
        this.withUpdateStrategy(instance.getUpdateStrategy());
        this.withVolumeClaimTemplates(instance.getVolumeClaimTemplates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeClaimTemplatesNested<A> editFirstVolumeClaimTemplate() {
    if (volumeClaimTemplates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeClaimTemplates"));
    }
    return this.setNewVolumeClaimTemplateLike(0, this.buildVolumeClaimTemplate(0));
  }
  
  public VolumeClaimTemplatesNested<A> editLastVolumeClaimTemplate() {
    int index = volumeClaimTemplates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeClaimTemplates"));
    }
    return this.setNewVolumeClaimTemplateLike(index, this.buildVolumeClaimTemplate(index));
  }
  
  public VolumeClaimTemplatesNested<A> editMatchingVolumeClaimTemplate(Predicate<PersistentVolumeClaimBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumeClaimTemplates.size();i++) {
      if (predicate.test(volumeClaimTemplates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumeClaimTemplates"));
    }
    return this.setNewVolumeClaimTemplateLike(index, this.buildVolumeClaimTemplate(index));
  }
  
  public OrdinalsNested<A> editOrNewOrdinals() {
    return this.withNewOrdinalsLike(Optional.ofNullable(this.buildOrdinals()).orElse(new StatefulSetOrdinalsBuilder().build()));
  }
  
  public OrdinalsNested<A> editOrNewOrdinalsLike(StatefulSetOrdinals item) {
    return this.withNewOrdinalsLike(Optional.ofNullable(this.buildOrdinals()).orElse(item));
  }
  
  public PersistentVolumeClaimRetentionPolicyNested<A> editOrNewPersistentVolumeClaimRetentionPolicy() {
    return this.withNewPersistentVolumeClaimRetentionPolicyLike(Optional.ofNullable(this.buildPersistentVolumeClaimRetentionPolicy()).orElse(new StatefulSetPersistentVolumeClaimRetentionPolicyBuilder().build()));
  }
  
  public PersistentVolumeClaimRetentionPolicyNested<A> editOrNewPersistentVolumeClaimRetentionPolicyLike(StatefulSetPersistentVolumeClaimRetentionPolicy item) {
    return this.withNewPersistentVolumeClaimRetentionPolicyLike(Optional.ofNullable(this.buildPersistentVolumeClaimRetentionPolicy()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new PodTemplateSpecBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(PodTemplateSpec item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(new StatefulSetUpdateStrategyBuilder().build()));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategyLike(StatefulSetUpdateStrategy item) {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(item));
  }
  
  public OrdinalsNested<A> editOrdinals() {
    return this.withNewOrdinalsLike(Optional.ofNullable(this.buildOrdinals()).orElse(null));
  }
  
  public PersistentVolumeClaimRetentionPolicyNested<A> editPersistentVolumeClaimRetentionPolicy() {
    return this.withNewPersistentVolumeClaimRetentionPolicyLike(Optional.ofNullable(this.buildPersistentVolumeClaimRetentionPolicy()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
  }
  
  public UpdateStrategyNested<A> editUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(null));
  }
  
  public VolumeClaimTemplatesNested<A> editVolumeClaimTemplate(int index) {
    if (volumeClaimTemplates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeClaimTemplates"));
    }
    return this.setNewVolumeClaimTemplateLike(index, this.buildVolumeClaimTemplate(index));
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
    StatefulSetSpecFluent that = (StatefulSetSpecFluent) o;
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(ordinals, that.ordinals))) {
      return false;
    }
    if (!(Objects.equals(persistentVolumeClaimRetentionPolicy, that.persistentVolumeClaimRetentionPolicy))) {
      return false;
    }
    if (!(Objects.equals(podManagementPolicy, that.podManagementPolicy))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(revisionHistoryLimit, that.revisionHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(updateStrategy, that.updateStrategy))) {
      return false;
    }
    if (!(Objects.equals(volumeClaimTemplates, that.volumeClaimTemplates))) {
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
  
  public Integer getMinReadySeconds() {
    return this.minReadySeconds;
  }
  
  public String getPodManagementPolicy() {
    return this.podManagementPolicy;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public Integer getRevisionHistoryLimit() {
    return this.revisionHistoryLimit;
  }
  
  public String getServiceName() {
    return this.serviceName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingVolumeClaimTemplate(Predicate<PersistentVolumeClaimBuilder> predicate) {
      for (PersistentVolumeClaimBuilder item : volumeClaimTemplates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasOrdinals() {
    return this.ordinals != null;
  }
  
  public boolean hasPersistentVolumeClaimRetentionPolicy() {
    return this.persistentVolumeClaimRetentionPolicy != null;
  }
  
  public boolean hasPodManagementPolicy() {
    return this.podManagementPolicy != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasRevisionHistoryLimit() {
    return this.revisionHistoryLimit != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasServiceName() {
    return this.serviceName != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasUpdateStrategy() {
    return this.updateStrategy != null;
  }
  
  public boolean hasVolumeClaimTemplates() {
    return this.volumeClaimTemplates != null && !(this.volumeClaimTemplates.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(minReadySeconds, ordinals, persistentVolumeClaimRetentionPolicy, podManagementPolicy, replicas, revisionHistoryLimit, selector, serviceName, template, updateStrategy, volumeClaimTemplates, additionalProperties);
  }
  
  public A removeAllFromVolumeClaimTemplates(Collection<PersistentVolumeClaim> items) {
    if (this.volumeClaimTemplates == null) {
      return (A) this;
    }
    for (PersistentVolumeClaim item : items) {
        PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
        _visitables.get("volumeClaimTemplates").remove(builder);
        this.volumeClaimTemplates.remove(builder);
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
  
  public A removeFromVolumeClaimTemplates(PersistentVolumeClaim... items) {
    if (this.volumeClaimTemplates == null) {
      return (A) this;
    }
    for (PersistentVolumeClaim item : items) {
        PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
        _visitables.get("volumeClaimTemplates").remove(builder);
        this.volumeClaimTemplates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumeClaimTemplates(Predicate<PersistentVolumeClaimBuilder> predicate) {
    if (volumeClaimTemplates == null) {
      return (A) this;
    }
    Iterator<PersistentVolumeClaimBuilder> each = volumeClaimTemplates.iterator();
    List visitables = _visitables.get("volumeClaimTemplates");
    while (each.hasNext()) {
        PersistentVolumeClaimBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public VolumeClaimTemplatesNested<A> setNewVolumeClaimTemplateLike(int index,PersistentVolumeClaim item) {
    return new VolumeClaimTemplatesNested(index, item);
  }
  
  public A setToVolumeClaimTemplates(int index,PersistentVolumeClaim item) {
    if (this.volumeClaimTemplates == null) {
      this.volumeClaimTemplates = new ArrayList();
    }
    PersistentVolumeClaimBuilder builder = new PersistentVolumeClaimBuilder(item);
    if (index < 0 || index >= volumeClaimTemplates.size()) {
        _visitables.get("volumeClaimTemplates").add(builder);
        volumeClaimTemplates.add(builder);
    } else {
        _visitables.get("volumeClaimTemplates").add(builder);
        volumeClaimTemplates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(minReadySeconds == null)) {
        sb.append("minReadySeconds:");
        sb.append(minReadySeconds);
        sb.append(",");
    }
    if (!(ordinals == null)) {
        sb.append("ordinals:");
        sb.append(ordinals);
        sb.append(",");
    }
    if (!(persistentVolumeClaimRetentionPolicy == null)) {
        sb.append("persistentVolumeClaimRetentionPolicy:");
        sb.append(persistentVolumeClaimRetentionPolicy);
        sb.append(",");
    }
    if (!(podManagementPolicy == null)) {
        sb.append("podManagementPolicy:");
        sb.append(podManagementPolicy);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(revisionHistoryLimit == null)) {
        sb.append("revisionHistoryLimit:");
        sb.append(revisionHistoryLimit);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(serviceName == null)) {
        sb.append("serviceName:");
        sb.append(serviceName);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(updateStrategy == null)) {
        sb.append("updateStrategy:");
        sb.append(updateStrategy);
        sb.append(",");
    }
    if (!(volumeClaimTemplates == null) && !(volumeClaimTemplates.isEmpty())) {
        sb.append("volumeClaimTemplates:");
        sb.append(volumeClaimTemplates);
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
  
  public A withMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
    return (A) this;
  }
  
  public OrdinalsNested<A> withNewOrdinals() {
    return new OrdinalsNested(null);
  }
  
  public A withNewOrdinals(Integer start) {
    return (A) this.withOrdinals(new StatefulSetOrdinals(start));
  }
  
  public OrdinalsNested<A> withNewOrdinalsLike(StatefulSetOrdinals item) {
    return new OrdinalsNested(item);
  }
  
  public PersistentVolumeClaimRetentionPolicyNested<A> withNewPersistentVolumeClaimRetentionPolicy() {
    return new PersistentVolumeClaimRetentionPolicyNested(null);
  }
  
  public A withNewPersistentVolumeClaimRetentionPolicy(String whenDeleted,String whenScaled) {
    return (A) this.withPersistentVolumeClaimRetentionPolicy(new StatefulSetPersistentVolumeClaimRetentionPolicy(whenDeleted, whenScaled));
  }
  
  public PersistentVolumeClaimRetentionPolicyNested<A> withNewPersistentVolumeClaimRetentionPolicyLike(StatefulSetPersistentVolumeClaimRetentionPolicy item) {
    return new PersistentVolumeClaimRetentionPolicyNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(PodTemplateSpec item) {
    return new TemplateNested(item);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategy() {
    return new UpdateStrategyNested(null);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategyLike(StatefulSetUpdateStrategy item) {
    return new UpdateStrategyNested(item);
  }
  
  public A withOrdinals(StatefulSetOrdinals ordinals) {
    this._visitables.remove("ordinals");
    if (ordinals != null) {
        this.ordinals = new StatefulSetOrdinalsBuilder(ordinals);
        this._visitables.get("ordinals").add(this.ordinals);
    } else {
        this.ordinals = null;
        this._visitables.get("ordinals").remove(this.ordinals);
    }
    return (A) this;
  }
  
  public A withPersistentVolumeClaimRetentionPolicy(StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
    this._visitables.remove("persistentVolumeClaimRetentionPolicy");
    if (persistentVolumeClaimRetentionPolicy != null) {
        this.persistentVolumeClaimRetentionPolicy = new StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(persistentVolumeClaimRetentionPolicy);
        this._visitables.get("persistentVolumeClaimRetentionPolicy").add(this.persistentVolumeClaimRetentionPolicy);
    } else {
        this.persistentVolumeClaimRetentionPolicy = null;
        this._visitables.get("persistentVolumeClaimRetentionPolicy").remove(this.persistentVolumeClaimRetentionPolicy);
    }
    return (A) this;
  }
  
  public A withPodManagementPolicy(String podManagementPolicy) {
    this.podManagementPolicy = podManagementPolicy;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withRevisionHistoryLimit(Integer revisionHistoryLimit) {
    this.revisionHistoryLimit = revisionHistoryLimit;
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withServiceName(String serviceName) {
    this.serviceName = serviceName;
    return (A) this;
  }
  
  public A withTemplate(PodTemplateSpec template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new PodTemplateSpecBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  
  public A withUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
    this._visitables.remove("updateStrategy");
    if (updateStrategy != null) {
        this.updateStrategy = new StatefulSetUpdateStrategyBuilder(updateStrategy);
        this._visitables.get("updateStrategy").add(this.updateStrategy);
    } else {
        this.updateStrategy = null;
        this._visitables.get("updateStrategy").remove(this.updateStrategy);
    }
    return (A) this;
  }
  
  public A withVolumeClaimTemplates(List<PersistentVolumeClaim> volumeClaimTemplates) {
    if (this.volumeClaimTemplates != null) {
      this._visitables.get("volumeClaimTemplates").clear();
    }
    if (volumeClaimTemplates != null) {
        this.volumeClaimTemplates = new ArrayList();
        for (PersistentVolumeClaim item : volumeClaimTemplates) {
          this.addToVolumeClaimTemplates(item);
        }
    } else {
      this.volumeClaimTemplates = null;
    }
    return (A) this;
  }
  
  public A withVolumeClaimTemplates(PersistentVolumeClaim... volumeClaimTemplates) {
    if (this.volumeClaimTemplates != null) {
        this.volumeClaimTemplates.clear();
        _visitables.remove("volumeClaimTemplates");
    }
    if (volumeClaimTemplates != null) {
      for (PersistentVolumeClaim item : volumeClaimTemplates) {
        this.addToVolumeClaimTemplates(item);
      }
    }
    return (A) this;
  }
  public class OrdinalsNested<N> extends StatefulSetOrdinalsFluent<OrdinalsNested<N>> implements Nested<N>{
  
    StatefulSetOrdinalsBuilder builder;
  
    OrdinalsNested(StatefulSetOrdinals item) {
      this.builder = new StatefulSetOrdinalsBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.withOrdinals(builder.build());
    }
    
    public N endOrdinals() {
      return and();
    }
    
  }
  public class PersistentVolumeClaimRetentionPolicyNested<N> extends StatefulSetPersistentVolumeClaimRetentionPolicyFluent<PersistentVolumeClaimRetentionPolicyNested<N>> implements Nested<N>{
  
    StatefulSetPersistentVolumeClaimRetentionPolicyBuilder builder;
  
    PersistentVolumeClaimRetentionPolicyNested(StatefulSetPersistentVolumeClaimRetentionPolicy item) {
      this.builder = new StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.withPersistentVolumeClaimRetentionPolicy(builder.build());
    }
    
    public N endPersistentVolumeClaimRetentionPolicy() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends PodTemplateSpecFluent<TemplateNested<N>> implements Nested<N>{
  
    PodTemplateSpecBuilder builder;
  
    TemplateNested(PodTemplateSpec item) {
      this.builder = new PodTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
  public class UpdateStrategyNested<N> extends StatefulSetUpdateStrategyFluent<UpdateStrategyNested<N>> implements Nested<N>{
  
    StatefulSetUpdateStrategyBuilder builder;
  
    UpdateStrategyNested(StatefulSetUpdateStrategy item) {
      this.builder = new StatefulSetUpdateStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.withUpdateStrategy(builder.build());
    }
    
    public N endUpdateStrategy() {
      return and();
    }
    
  }
  public class VolumeClaimTemplatesNested<N> extends PersistentVolumeClaimFluent<VolumeClaimTemplatesNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimBuilder builder;
    int index;
  
    VolumeClaimTemplatesNested(int index,PersistentVolumeClaim item) {
      this.index = index;
      this.builder = new PersistentVolumeClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) StatefulSetSpecFluent.this.setToVolumeClaimTemplates(index, builder.build());
    }
    
    public N endVolumeClaimTemplate() {
      return and();
    }
    
  }
}