package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceBuilder;
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReferenceFluent;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class WasmPluginFluent<A extends io.fabric8.istio.api.api.extensions.v1alpha1.WasmPluginFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FailStrategy failStrategy;
  private PullPolicy imagePullPolicy;
  private String imagePullSecret;
  private ArrayList<WasmPluginTrafficSelectorBuilder> match = new ArrayList<WasmPluginTrafficSelectorBuilder>();
  private PluginPhase phase;
  private Object pluginConfig;
  private String pluginName;
  private Integer priority;
  private WorkloadSelectorBuilder selector;
  private String sha256;
  private PolicyTargetReferenceBuilder targetRef;
  private ArrayList<PolicyTargetReferenceBuilder> targetRefs = new ArrayList<PolicyTargetReferenceBuilder>();
  private PluginType type;
  private String url;
  private String verificationKey;
  private VmConfigBuilder vmConfig;

  public WasmPluginFluent() {
  }
  
  public WasmPluginFluent(WasmPlugin instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<WasmPluginTrafficSelector> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (WasmPluginTrafficSelector item : items) {
        WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(WasmPluginTrafficSelector item) {
    return new MatchNested(-1, item);
  }
  
  public TargetRefsNested<A> addNewTargetRef() {
    return new TargetRefsNested(-1, null);
  }
  
  public A addNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.addToTargetRefs(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefsNested<A> addNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefsNested(-1, item);
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
  
  public A addToMatch(WasmPluginTrafficSelector... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (WasmPluginTrafficSelector item : items) {
        WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,WasmPluginTrafficSelector item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").add(builder);
        this.targetRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public WasmPluginTrafficSelector buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public PolicyTargetReference buildFirstTargetRef() {
    return this.targetRefs.get(0).build();
  }
  
  public WasmPluginTrafficSelector buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public PolicyTargetReference buildLastTargetRef() {
    return this.targetRefs.get(targetRefs.size() - 1).build();
  }
  
  public List<WasmPluginTrafficSelector> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public WasmPluginTrafficSelector buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public WasmPluginTrafficSelector buildMatchingMatch(Predicate<WasmPluginTrafficSelectorBuilder> predicate) {
      for (WasmPluginTrafficSelectorBuilder item : match) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyTargetReference buildMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef() {
    return this.targetRef != null ? this.targetRef.build() : null;
  }
  
  public PolicyTargetReference buildTargetRef(int index) {
    return this.targetRefs.get(index).build();
  }
  
  public List<PolicyTargetReference> buildTargetRefs() {
    return this.targetRefs != null ? build(targetRefs) : null;
  }
  
  public VmConfig buildVmConfig() {
    return this.vmConfig != null ? this.vmConfig.build() : null;
  }
  
  protected void copyInstance(WasmPlugin instance) {
    instance = instance != null ? instance : new WasmPlugin();
    if (instance != null) {
        this.withFailStrategy(instance.getFailStrategy());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecret(instance.getImagePullSecret());
        this.withMatch(instance.getMatch());
        this.withPhase(instance.getPhase());
        this.withPluginConfig(instance.getPluginConfig());
        this.withPluginName(instance.getPluginName());
        this.withPriority(instance.getPriority());
        this.withSelector(instance.getSelector());
        this.withSha256(instance.getSha256());
        this.withTargetRef(instance.getTargetRef());
        this.withTargetRefs(instance.getTargetRefs());
        this.withType(instance.getType());
        this.withUrl(instance.getUrl());
        this.withVerificationKey(instance.getVerificationKey());
        this.withVmConfig(instance.getVmConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public TargetRefsNested<A> editFirstTargetRef() {
    if (targetRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(0, this.buildTargetRef(0));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public TargetRefsNested<A> editLastTargetRef() {
    int index = targetRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<WasmPluginTrafficSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < match.size();i++) {
      if (predicate.test(match.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public TargetRefsNested<A> editMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < targetRefs.size();i++) {
      if (predicate.test(targetRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(WorkloadSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public TargetRefNested<A> editOrNewTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(new PolicyTargetReferenceBuilder().build()));
  }
  
  public TargetRefNested<A> editOrNewTargetRefLike(PolicyTargetReference item) {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(item));
  }
  
  public VmConfigNested<A> editOrNewVmConfig() {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(new VmConfigBuilder().build()));
  }
  
  public VmConfigNested<A> editOrNewVmConfigLike(VmConfig item) {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public TargetRefNested<A> editTargetRef() {
    return this.withNewTargetRefLike(Optional.ofNullable(this.buildTargetRef()).orElse(null));
  }
  
  public TargetRefsNested<A> editTargetRef(int index) {
    if (targetRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "targetRefs"));
    }
    return this.setNewTargetRefLike(index, this.buildTargetRef(index));
  }
  
  public VmConfigNested<A> editVmConfig() {
    return this.withNewVmConfigLike(Optional.ofNullable(this.buildVmConfig()).orElse(null));
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
    WasmPluginFluent that = (WasmPluginFluent) o;
    if (!(Objects.equals(failStrategy, that.failStrategy))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecret, that.imagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(pluginConfig, that.pluginConfig))) {
      return false;
    }
    if (!(Objects.equals(pluginName, that.pluginName))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(sha256, that.sha256))) {
      return false;
    }
    if (!(Objects.equals(targetRef, that.targetRef))) {
      return false;
    }
    if (!(Objects.equals(targetRefs, that.targetRefs))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(verificationKey, that.verificationKey))) {
      return false;
    }
    if (!(Objects.equals(vmConfig, that.vmConfig))) {
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
  
  public FailStrategy getFailStrategy() {
    return this.failStrategy;
  }
  
  public PullPolicy getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public String getImagePullSecret() {
    return this.imagePullSecret;
  }
  
  public PluginPhase getPhase() {
    return this.phase;
  }
  
  public Object getPluginConfig() {
    return this.pluginConfig;
  }
  
  public String getPluginName() {
    return this.pluginName;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public String getSha256() {
    return this.sha256;
  }
  
  public PluginType getType() {
    return this.type;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getVerificationKey() {
    return this.verificationKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailStrategy() {
    return this.failStrategy != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecret() {
    return this.imagePullSecret != null;
  }
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<WasmPluginTrafficSelectorBuilder> predicate) {
      for (WasmPluginTrafficSelectorBuilder item : match) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetRef(Predicate<PolicyTargetReferenceBuilder> predicate) {
      for (PolicyTargetReferenceBuilder item : targetRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasPluginConfig() {
    return this.pluginConfig != null;
  }
  
  public boolean hasPluginName() {
    return this.pluginName != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasSha256() {
    return this.sha256 != null;
  }
  
  public boolean hasTargetRef() {
    return this.targetRef != null;
  }
  
  public boolean hasTargetRefs() {
    return this.targetRefs != null && !(this.targetRefs.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasVerificationKey() {
    return this.verificationKey != null;
  }
  
  public boolean hasVmConfig() {
    return this.vmConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(failStrategy, imagePullPolicy, imagePullSecret, match, phase, pluginConfig, pluginName, priority, selector, sha256, targetRef, targetRefs, type, url, verificationKey, vmConfig, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<WasmPluginTrafficSelector> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (WasmPluginTrafficSelector item : items) {
        WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetRefs(Collection<PolicyTargetReference> items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
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
  
  public A removeFromMatch(WasmPluginTrafficSelector... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (WasmPluginTrafficSelector item : items) {
        WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTargetRefs(PolicyTargetReference... items) {
    if (this.targetRefs == null) {
      return (A) this;
    }
    for (PolicyTargetReference item : items) {
        PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
        _visitables.get("targetRefs").remove(builder);
        this.targetRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatch(Predicate<WasmPluginTrafficSelectorBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<WasmPluginTrafficSelectorBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        WasmPluginTrafficSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTargetRefs(Predicate<PolicyTargetReferenceBuilder> predicate) {
    if (targetRefs == null) {
      return (A) this;
    }
    Iterator<PolicyTargetReferenceBuilder> each = targetRefs.iterator();
    List visitables = _visitables.get("targetRefs");
    while (each.hasNext()) {
        PolicyTargetReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchNested<A> setNewMatchLike(int index,WasmPluginTrafficSelector item) {
    return new MatchNested(index, item);
  }
  
  public TargetRefsNested<A> setNewTargetRefLike(int index,PolicyTargetReference item) {
    return new TargetRefsNested(index, item);
  }
  
  public A setToMatch(int index,WasmPluginTrafficSelector item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    WasmPluginTrafficSelectorBuilder builder = new WasmPluginTrafficSelectorBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTargetRefs(int index,PolicyTargetReference item) {
    if (this.targetRefs == null) {
      this.targetRefs = new ArrayList();
    }
    PolicyTargetReferenceBuilder builder = new PolicyTargetReferenceBuilder(item);
    if (index < 0 || index >= targetRefs.size()) {
        _visitables.get("targetRefs").add(builder);
        targetRefs.add(builder);
    } else {
        _visitables.get("targetRefs").add(builder);
        targetRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(failStrategy == null)) {
        sb.append("failStrategy:");
        sb.append(failStrategy);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecret == null)) {
        sb.append("imagePullSecret:");
        sb.append(imagePullSecret);
        sb.append(",");
    }
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(pluginConfig == null)) {
        sb.append("pluginConfig:");
        sb.append(pluginConfig);
        sb.append(",");
    }
    if (!(pluginName == null)) {
        sb.append("pluginName:");
        sb.append(pluginName);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(sha256 == null)) {
        sb.append("sha256:");
        sb.append(sha256);
        sb.append(",");
    }
    if (!(targetRef == null)) {
        sb.append("targetRef:");
        sb.append(targetRef);
        sb.append(",");
    }
    if (!(targetRefs == null) && !(targetRefs.isEmpty())) {
        sb.append("targetRefs:");
        sb.append(targetRefs);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(verificationKey == null)) {
        sb.append("verificationKey:");
        sb.append(verificationKey);
        sb.append(",");
    }
    if (!(vmConfig == null)) {
        sb.append("vmConfig:");
        sb.append(vmConfig);
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
  
  public A withFailStrategy(FailStrategy failStrategy) {
    this.failStrategy = failStrategy;
    return (A) this;
  }
  
  public A withImagePullPolicy(PullPolicy imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return (A) this;
  }
  
  public A withMatch(List<WasmPluginTrafficSelector> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (WasmPluginTrafficSelector item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(WasmPluginTrafficSelector... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (WasmPluginTrafficSelector item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public TargetRefNested<A> withNewTargetRef() {
    return new TargetRefNested(null);
  }
  
  public A withNewTargetRef(String group,String kind,String name,String namespace) {
    return (A) this.withTargetRef(new PolicyTargetReference(group, kind, name, namespace));
  }
  
  public TargetRefNested<A> withNewTargetRefLike(PolicyTargetReference item) {
    return new TargetRefNested(item);
  }
  
  public VmConfigNested<A> withNewVmConfig() {
    return new VmConfigNested(null);
  }
  
  public VmConfigNested<A> withNewVmConfigLike(VmConfig item) {
    return new VmConfigNested(item);
  }
  
  public A withPhase(PluginPhase phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withPluginConfig(Object pluginConfig) {
    this.pluginConfig = pluginConfig;
    return (A) this;
  }
  
  public A withPluginName(String pluginName) {
    this.pluginName = pluginName;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withSelector(WorkloadSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new WorkloadSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withSha256(String sha256) {
    this.sha256 = sha256;
    return (A) this;
  }
  
  public A withTargetRef(PolicyTargetReference targetRef) {
    this._visitables.remove("targetRef");
    if (targetRef != null) {
        this.targetRef = new PolicyTargetReferenceBuilder(targetRef);
        this._visitables.get("targetRef").add(this.targetRef);
    } else {
        this.targetRef = null;
        this._visitables.get("targetRef").remove(this.targetRef);
    }
    return (A) this;
  }
  
  public A withTargetRefs(List<PolicyTargetReference> targetRefs) {
    if (this.targetRefs != null) {
      this._visitables.get("targetRefs").clear();
    }
    if (targetRefs != null) {
        this.targetRefs = new ArrayList();
        for (PolicyTargetReference item : targetRefs) {
          this.addToTargetRefs(item);
        }
    } else {
      this.targetRefs = null;
    }
    return (A) this;
  }
  
  public A withTargetRefs(PolicyTargetReference... targetRefs) {
    if (this.targetRefs != null) {
        this.targetRefs.clear();
        _visitables.remove("targetRefs");
    }
    if (targetRefs != null) {
      for (PolicyTargetReference item : targetRefs) {
        this.addToTargetRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withType(PluginType type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withVerificationKey(String verificationKey) {
    this.verificationKey = verificationKey;
    return (A) this;
  }
  
  public A withVmConfig(VmConfig vmConfig) {
    this._visitables.remove("vmConfig");
    if (vmConfig != null) {
        this.vmConfig = new VmConfigBuilder(vmConfig);
        this._visitables.get("vmConfig").add(this.vmConfig);
    } else {
        this.vmConfig = null;
        this._visitables.get("vmConfig").remove(this.vmConfig);
    }
    return (A) this;
  }
  public class MatchNested<N> extends WasmPluginTrafficSelectorFluent<MatchNested<N>> implements Nested<N>{
  
    WasmPluginTrafficSelectorBuilder builder;
    int index;
  
    MatchNested(int index,WasmPluginTrafficSelector item) {
      this.index = index;
      this.builder = new WasmPluginTrafficSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmPluginFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmPluginFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class TargetRefNested<N> extends PolicyTargetReferenceFluent<TargetRefNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
  
    TargetRefNested(PolicyTargetReference item) {
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmPluginFluent.this.withTargetRef(builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class TargetRefsNested<N> extends PolicyTargetReferenceFluent<TargetRefsNested<N>> implements Nested<N>{
  
    PolicyTargetReferenceBuilder builder;
    int index;
  
    TargetRefsNested(int index,PolicyTargetReference item) {
      this.index = index;
      this.builder = new PolicyTargetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmPluginFluent.this.setToTargetRefs(index, builder.build());
    }
    
    public N endTargetRef() {
      return and();
    }
    
  }
  public class VmConfigNested<N> extends VmConfigFluent<VmConfigNested<N>> implements Nested<N>{
  
    VmConfigBuilder builder;
  
    VmConfigNested(VmConfig item) {
      this.builder = new VmConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) WasmPluginFluent.this.withVmConfig(builder.build());
    }
    
    public N endVmConfig() {
      return and();
    }
    
  }
}