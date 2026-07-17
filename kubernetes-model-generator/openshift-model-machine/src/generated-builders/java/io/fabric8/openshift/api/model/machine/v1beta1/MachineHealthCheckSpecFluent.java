package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class MachineHealthCheckSpecFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IntOrStringBuilder maxUnhealthy;
  private String nodeStartupTimeout;
  private ObjectReferenceBuilder remediationTemplate;
  private LabelSelectorBuilder selector;
  private ArrayList<UnhealthyConditionBuilder> unhealthyConditions = new ArrayList<UnhealthyConditionBuilder>();

  public MachineHealthCheckSpecFluent() {
  }
  
  public MachineHealthCheckSpecFluent(MachineHealthCheckSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToUnhealthyConditions(Collection<UnhealthyCondition> items) {
    if (this.unhealthyConditions == null) {
      this.unhealthyConditions = new ArrayList();
    }
    for (UnhealthyCondition item : items) {
        UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
        _visitables.get("unhealthyConditions").add(builder);
        this.unhealthyConditions.add(builder);
    }
    return (A) this;
  }
  
  public UnhealthyConditionsNested<A> addNewUnhealthyCondition() {
    return new UnhealthyConditionsNested(-1, null);
  }
  
  public A addNewUnhealthyCondition(String status,String timeout,String type) {
    return (A) this.addToUnhealthyConditions(new UnhealthyCondition(status, timeout, type));
  }
  
  public UnhealthyConditionsNested<A> addNewUnhealthyConditionLike(UnhealthyCondition item) {
    return new UnhealthyConditionsNested(-1, item);
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
  
  public A addToUnhealthyConditions(UnhealthyCondition... items) {
    if (this.unhealthyConditions == null) {
      this.unhealthyConditions = new ArrayList();
    }
    for (UnhealthyCondition item : items) {
        UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
        _visitables.get("unhealthyConditions").add(builder);
        this.unhealthyConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToUnhealthyConditions(int index,UnhealthyCondition item) {
    if (this.unhealthyConditions == null) {
      this.unhealthyConditions = new ArrayList();
    }
    UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
    if (index < 0 || index >= unhealthyConditions.size()) {
        _visitables.get("unhealthyConditions").add(builder);
        unhealthyConditions.add(builder);
    } else {
        _visitables.get("unhealthyConditions").add(builder);
        unhealthyConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public UnhealthyCondition buildFirstUnhealthyCondition() {
    return this.unhealthyConditions.get(0).build();
  }
  
  public UnhealthyCondition buildLastUnhealthyCondition() {
    return this.unhealthyConditions.get(unhealthyConditions.size() - 1).build();
  }
  
  public UnhealthyCondition buildMatchingUnhealthyCondition(Predicate<UnhealthyConditionBuilder> predicate) {
      for (UnhealthyConditionBuilder item : unhealthyConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IntOrString buildMaxUnhealthy() {
    return this.maxUnhealthy != null ? this.maxUnhealthy.build() : null;
  }
  
  public ObjectReference buildRemediationTemplate() {
    return this.remediationTemplate != null ? this.remediationTemplate.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public UnhealthyCondition buildUnhealthyCondition(int index) {
    return this.unhealthyConditions.get(index).build();
  }
  
  public List<UnhealthyCondition> buildUnhealthyConditions() {
    return this.unhealthyConditions != null ? build(unhealthyConditions) : null;
  }
  
  protected void copyInstance(MachineHealthCheckSpec instance) {
    instance = instance != null ? instance : new MachineHealthCheckSpec();
    if (instance != null) {
        this.withMaxUnhealthy(instance.getMaxUnhealthy());
        this.withNodeStartupTimeout(instance.getNodeStartupTimeout());
        this.withRemediationTemplate(instance.getRemediationTemplate());
        this.withSelector(instance.getSelector());
        this.withUnhealthyConditions(instance.getUnhealthyConditions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UnhealthyConditionsNested<A> editFirstUnhealthyCondition() {
    if (unhealthyConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "unhealthyConditions"));
    }
    return this.setNewUnhealthyConditionLike(0, this.buildUnhealthyCondition(0));
  }
  
  public UnhealthyConditionsNested<A> editLastUnhealthyCondition() {
    int index = unhealthyConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "unhealthyConditions"));
    }
    return this.setNewUnhealthyConditionLike(index, this.buildUnhealthyCondition(index));
  }
  
  public UnhealthyConditionsNested<A> editMatchingUnhealthyCondition(Predicate<UnhealthyConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < unhealthyConditions.size();i++) {
      if (predicate.test(unhealthyConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "unhealthyConditions"));
    }
    return this.setNewUnhealthyConditionLike(index, this.buildUnhealthyCondition(index));
  }
  
  public MaxUnhealthyNested<A> editMaxUnhealthy() {
    return this.withNewMaxUnhealthyLike(Optional.ofNullable(this.buildMaxUnhealthy()).orElse(null));
  }
  
  public MaxUnhealthyNested<A> editOrNewMaxUnhealthy() {
    return this.withNewMaxUnhealthyLike(Optional.ofNullable(this.buildMaxUnhealthy()).orElse(new IntOrStringBuilder().build()));
  }
  
  public MaxUnhealthyNested<A> editOrNewMaxUnhealthyLike(IntOrString item) {
    return this.withNewMaxUnhealthyLike(Optional.ofNullable(this.buildMaxUnhealthy()).orElse(item));
  }
  
  public RemediationTemplateNested<A> editOrNewRemediationTemplate() {
    return this.withNewRemediationTemplateLike(Optional.ofNullable(this.buildRemediationTemplate()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RemediationTemplateNested<A> editOrNewRemediationTemplateLike(ObjectReference item) {
    return this.withNewRemediationTemplateLike(Optional.ofNullable(this.buildRemediationTemplate()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public RemediationTemplateNested<A> editRemediationTemplate() {
    return this.withNewRemediationTemplateLike(Optional.ofNullable(this.buildRemediationTemplate()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public UnhealthyConditionsNested<A> editUnhealthyCondition(int index) {
    if (unhealthyConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "unhealthyConditions"));
    }
    return this.setNewUnhealthyConditionLike(index, this.buildUnhealthyCondition(index));
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
    MachineHealthCheckSpecFluent that = (MachineHealthCheckSpecFluent) o;
    if (!(Objects.equals(maxUnhealthy, that.maxUnhealthy))) {
      return false;
    }
    if (!(Objects.equals(nodeStartupTimeout, that.nodeStartupTimeout))) {
      return false;
    }
    if (!(Objects.equals(remediationTemplate, that.remediationTemplate))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(unhealthyConditions, that.unhealthyConditions))) {
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
  
  public String getNodeStartupTimeout() {
    return this.nodeStartupTimeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUnhealthyCondition(Predicate<UnhealthyConditionBuilder> predicate) {
      for (UnhealthyConditionBuilder item : unhealthyConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxUnhealthy() {
    return this.maxUnhealthy != null;
  }
  
  public boolean hasNodeStartupTimeout() {
    return this.nodeStartupTimeout != null;
  }
  
  public boolean hasRemediationTemplate() {
    return this.remediationTemplate != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasUnhealthyConditions() {
    return this.unhealthyConditions != null && !(this.unhealthyConditions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(maxUnhealthy, nodeStartupTimeout, remediationTemplate, selector, unhealthyConditions, additionalProperties);
  }
  
  public A removeAllFromUnhealthyConditions(Collection<UnhealthyCondition> items) {
    if (this.unhealthyConditions == null) {
      return (A) this;
    }
    for (UnhealthyCondition item : items) {
        UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
        _visitables.get("unhealthyConditions").remove(builder);
        this.unhealthyConditions.remove(builder);
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
  
  public A removeFromUnhealthyConditions(UnhealthyCondition... items) {
    if (this.unhealthyConditions == null) {
      return (A) this;
    }
    for (UnhealthyCondition item : items) {
        UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
        _visitables.get("unhealthyConditions").remove(builder);
        this.unhealthyConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromUnhealthyConditions(Predicate<UnhealthyConditionBuilder> predicate) {
    if (unhealthyConditions == null) {
      return (A) this;
    }
    Iterator<UnhealthyConditionBuilder> each = unhealthyConditions.iterator();
    List visitables = _visitables.get("unhealthyConditions");
    while (each.hasNext()) {
        UnhealthyConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public UnhealthyConditionsNested<A> setNewUnhealthyConditionLike(int index,UnhealthyCondition item) {
    return new UnhealthyConditionsNested(index, item);
  }
  
  public A setToUnhealthyConditions(int index,UnhealthyCondition item) {
    if (this.unhealthyConditions == null) {
      this.unhealthyConditions = new ArrayList();
    }
    UnhealthyConditionBuilder builder = new UnhealthyConditionBuilder(item);
    if (index < 0 || index >= unhealthyConditions.size()) {
        _visitables.get("unhealthyConditions").add(builder);
        unhealthyConditions.add(builder);
    } else {
        _visitables.get("unhealthyConditions").add(builder);
        unhealthyConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(maxUnhealthy == null)) {
        sb.append("maxUnhealthy:");
        sb.append(maxUnhealthy);
        sb.append(",");
    }
    if (!(nodeStartupTimeout == null)) {
        sb.append("nodeStartupTimeout:");
        sb.append(nodeStartupTimeout);
        sb.append(",");
    }
    if (!(remediationTemplate == null)) {
        sb.append("remediationTemplate:");
        sb.append(remediationTemplate);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(unhealthyConditions == null) && !(unhealthyConditions.isEmpty())) {
        sb.append("unhealthyConditions:");
        sb.append(unhealthyConditions);
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
  
  public A withMaxUnhealthy(IntOrString maxUnhealthy) {
    this._visitables.remove("maxUnhealthy");
    if (maxUnhealthy != null) {
        this.maxUnhealthy = new IntOrStringBuilder(maxUnhealthy);
        this._visitables.get("maxUnhealthy").add(this.maxUnhealthy);
    } else {
        this.maxUnhealthy = null;
        this._visitables.get("maxUnhealthy").remove(this.maxUnhealthy);
    }
    return (A) this;
  }
  
  public MaxUnhealthyNested<A> withNewMaxUnhealthy() {
    return new MaxUnhealthyNested(null);
  }
  
  public A withNewMaxUnhealthy(Object value) {
    return (A) this.withMaxUnhealthy(new IntOrString(value));
  }
  
  public MaxUnhealthyNested<A> withNewMaxUnhealthyLike(IntOrString item) {
    return new MaxUnhealthyNested(item);
  }
  
  public RemediationTemplateNested<A> withNewRemediationTemplate() {
    return new RemediationTemplateNested(null);
  }
  
  public RemediationTemplateNested<A> withNewRemediationTemplateLike(ObjectReference item) {
    return new RemediationTemplateNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public A withNodeStartupTimeout(String nodeStartupTimeout) {
    this.nodeStartupTimeout = nodeStartupTimeout;
    return (A) this;
  }
  
  public A withRemediationTemplate(ObjectReference remediationTemplate) {
    this._visitables.remove("remediationTemplate");
    if (remediationTemplate != null) {
        this.remediationTemplate = new ObjectReferenceBuilder(remediationTemplate);
        this._visitables.get("remediationTemplate").add(this.remediationTemplate);
    } else {
        this.remediationTemplate = null;
        this._visitables.get("remediationTemplate").remove(this.remediationTemplate);
    }
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
  
  public A withUnhealthyConditions(List<UnhealthyCondition> unhealthyConditions) {
    if (this.unhealthyConditions != null) {
      this._visitables.get("unhealthyConditions").clear();
    }
    if (unhealthyConditions != null) {
        this.unhealthyConditions = new ArrayList();
        for (UnhealthyCondition item : unhealthyConditions) {
          this.addToUnhealthyConditions(item);
        }
    } else {
      this.unhealthyConditions = null;
    }
    return (A) this;
  }
  
  public A withUnhealthyConditions(UnhealthyCondition... unhealthyConditions) {
    if (this.unhealthyConditions != null) {
        this.unhealthyConditions.clear();
        _visitables.remove("unhealthyConditions");
    }
    if (unhealthyConditions != null) {
      for (UnhealthyCondition item : unhealthyConditions) {
        this.addToUnhealthyConditions(item);
      }
    }
    return (A) this;
  }
  public class MaxUnhealthyNested<N> extends IntOrStringFluent<MaxUnhealthyNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    MaxUnhealthyNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineHealthCheckSpecFluent.this.withMaxUnhealthy(builder.build());
    }
    
    public N endMaxUnhealthy() {
      return and();
    }
    
  }
  public class RemediationTemplateNested<N> extends ObjectReferenceFluent<RemediationTemplateNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RemediationTemplateNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineHealthCheckSpecFluent.this.withRemediationTemplate(builder.build());
    }
    
    public N endRemediationTemplate() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineHealthCheckSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class UnhealthyConditionsNested<N> extends UnhealthyConditionFluent<UnhealthyConditionsNested<N>> implements Nested<N>{
  
    UnhealthyConditionBuilder builder;
    int index;
  
    UnhealthyConditionsNested(int index,UnhealthyCondition item) {
      this.index = index;
      this.builder = new UnhealthyConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineHealthCheckSpecFluent.this.setToUnhealthyConditions(index, builder.build());
    }
    
    public N endUnhealthyCondition() {
      return and();
    }
    
  }
}