package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
import java.lang.Long;
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
public class BuildStatusFluent<A extends io.fabric8.openshift.api.model.BuildStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean cancelled;
  private String completionTimestamp;
  private ArrayList<BuildConditionBuilder> conditions = new ArrayList<BuildConditionBuilder>();
  private ObjectReferenceBuilder config;
  private Long duration;
  private String logSnippet;
  private String message;
  private BuildStatusOutputBuilder output;
  private String outputDockerImageReference;
  private String phase;
  private String reason;
  private ArrayList<StageInfoBuilder> stages = new ArrayList<StageInfoBuilder>();
  private String startTimestamp;

  public BuildStatusFluent() {
  }
  
  public BuildStatusFluent(BuildStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<BuildCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (BuildCondition item : items) {
        BuildConditionBuilder builder = new BuildConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStages(Collection<StageInfo> items) {
    if (this.stages == null) {
      this.stages = new ArrayList();
    }
    for (StageInfo item : items) {
        StageInfoBuilder builder = new StageInfoBuilder(item);
        _visitables.get("stages").add(builder);
        this.stages.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(BuildCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public StagesNested<A> addNewStage() {
    return new StagesNested(-1, null);
  }
  
  public StagesNested<A> addNewStageLike(StageInfo item) {
    return new StagesNested(-1, item);
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
  
  public A addToConditions(BuildCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (BuildCondition item : items) {
        BuildConditionBuilder builder = new BuildConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,BuildCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    BuildConditionBuilder builder = new BuildConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStages(StageInfo... items) {
    if (this.stages == null) {
      this.stages = new ArrayList();
    }
    for (StageInfo item : items) {
        StageInfoBuilder builder = new StageInfoBuilder(item);
        _visitables.get("stages").add(builder);
        this.stages.add(builder);
    }
    return (A) this;
  }
  
  public A addToStages(int index,StageInfo item) {
    if (this.stages == null) {
      this.stages = new ArrayList();
    }
    StageInfoBuilder builder = new StageInfoBuilder(item);
    if (index < 0 || index >= stages.size()) {
        _visitables.get("stages").add(builder);
        stages.add(builder);
    } else {
        _visitables.get("stages").add(builder);
        stages.add(index, builder);
    }
    return (A) this;
  }
  
  public BuildCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<BuildCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ObjectReference buildConfig() {
    return this.config != null ? this.config.build() : null;
  }
  
  public BuildCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public StageInfo buildFirstStage() {
    return this.stages.get(0).build();
  }
  
  public BuildCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public StageInfo buildLastStage() {
    return this.stages.get(stages.size() - 1).build();
  }
  
  public BuildCondition buildMatchingCondition(Predicate<BuildConditionBuilder> predicate) {
      for (BuildConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StageInfo buildMatchingStage(Predicate<StageInfoBuilder> predicate) {
      for (StageInfoBuilder item : stages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public BuildStatusOutput buildOutput() {
    return this.output != null ? this.output.build() : null;
  }
  
  public StageInfo buildStage(int index) {
    return this.stages.get(index).build();
  }
  
  public List<StageInfo> buildStages() {
    return this.stages != null ? build(stages) : null;
  }
  
  protected void copyInstance(BuildStatus instance) {
    instance = instance != null ? instance : new BuildStatus();
    if (instance != null) {
        this.withCancelled(instance.getCancelled());
        this.withCompletionTimestamp(instance.getCompletionTimestamp());
        this.withConditions(instance.getConditions());
        this.withConfig(instance.getConfig());
        this.withDuration(instance.getDuration());
        this.withLogSnippet(instance.getLogSnippet());
        this.withMessage(instance.getMessage());
        this.withOutput(instance.getOutput());
        this.withOutputDockerImageReference(instance.getOutputDockerImageReference());
        this.withPhase(instance.getPhase());
        this.withReason(instance.getReason());
        this.withStages(instance.getStages());
        this.withStartTimestamp(instance.getStartTimestamp());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConfigNested<A> editConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(null));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public StagesNested<A> editFirstStage() {
    if (stages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "stages"));
    }
    return this.setNewStageLike(0, this.buildStage(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public StagesNested<A> editLastStage() {
    int index = stages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "stages"));
    }
    return this.setNewStageLike(index, this.buildStage(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<BuildConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public StagesNested<A> editMatchingStage(Predicate<StageInfoBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < stages.size();i++) {
      if (predicate.test(stages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "stages"));
    }
    return this.setNewStageLike(index, this.buildStage(index));
  }
  
  public ConfigNested<A> editOrNewConfig() {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ConfigNested<A> editOrNewConfigLike(ObjectReference item) {
    return this.withNewConfigLike(Optional.ofNullable(this.buildConfig()).orElse(item));
  }
  
  public OutputNested<A> editOrNewOutput() {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(new BuildStatusOutputBuilder().build()));
  }
  
  public OutputNested<A> editOrNewOutputLike(BuildStatusOutput item) {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(item));
  }
  
  public OutputNested<A> editOutput() {
    return this.withNewOutputLike(Optional.ofNullable(this.buildOutput()).orElse(null));
  }
  
  public StagesNested<A> editStage(int index) {
    if (stages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "stages"));
    }
    return this.setNewStageLike(index, this.buildStage(index));
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
    BuildStatusFluent that = (BuildStatusFluent) o;
    if (!(Objects.equals(cancelled, that.cancelled))) {
      return false;
    }
    if (!(Objects.equals(completionTimestamp, that.completionTimestamp))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(logSnippet, that.logSnippet))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(output, that.output))) {
      return false;
    }
    if (!(Objects.equals(outputDockerImageReference, that.outputDockerImageReference))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(stages, that.stages))) {
      return false;
    }
    if (!(Objects.equals(startTimestamp, that.startTimestamp))) {
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
  
  public Boolean getCancelled() {
    return this.cancelled;
  }
  
  public String getCompletionTimestamp() {
    return this.completionTimestamp;
  }
  
  public Long getDuration() {
    return this.duration;
  }
  
  public String getLogSnippet() {
    return this.logSnippet;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getOutputDockerImageReference() {
    return this.outputDockerImageReference;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getStartTimestamp() {
    return this.startTimestamp;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCancelled() {
    return this.cancelled != null;
  }
  
  public boolean hasCompletionTimestamp() {
    return this.completionTimestamp != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasLogSnippet() {
    return this.logSnippet != null;
  }
  
  public boolean hasMatchingCondition(Predicate<BuildConditionBuilder> predicate) {
      for (BuildConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStage(Predicate<StageInfoBuilder> predicate) {
      for (StageInfoBuilder item : stages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasOutput() {
    return this.output != null;
  }
  
  public boolean hasOutputDockerImageReference() {
    return this.outputDockerImageReference != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasStages() {
    return this.stages != null && !(this.stages.isEmpty());
  }
  
  public boolean hasStartTimestamp() {
    return this.startTimestamp != null;
  }
  
  public int hashCode() {
    return Objects.hash(cancelled, completionTimestamp, conditions, config, duration, logSnippet, message, output, outputDockerImageReference, phase, reason, stages, startTimestamp, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<BuildCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (BuildCondition item : items) {
        BuildConditionBuilder builder = new BuildConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStages(Collection<StageInfo> items) {
    if (this.stages == null) {
      return (A) this;
    }
    for (StageInfo item : items) {
        StageInfoBuilder builder = new StageInfoBuilder(item);
        _visitables.get("stages").remove(builder);
        this.stages.remove(builder);
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
  
  public A removeFromConditions(BuildCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (BuildCondition item : items) {
        BuildConditionBuilder builder = new BuildConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStages(StageInfo... items) {
    if (this.stages == null) {
      return (A) this;
    }
    for (StageInfo item : items) {
        StageInfoBuilder builder = new StageInfoBuilder(item);
        _visitables.get("stages").remove(builder);
        this.stages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<BuildConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<BuildConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        BuildConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStages(Predicate<StageInfoBuilder> predicate) {
    if (stages == null) {
      return (A) this;
    }
    Iterator<StageInfoBuilder> each = stages.iterator();
    List visitables = _visitables.get("stages");
    while (each.hasNext()) {
        StageInfoBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,BuildCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public StagesNested<A> setNewStageLike(int index,StageInfo item) {
    return new StagesNested(index, item);
  }
  
  public A setToConditions(int index,BuildCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    BuildConditionBuilder builder = new BuildConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStages(int index,StageInfo item) {
    if (this.stages == null) {
      this.stages = new ArrayList();
    }
    StageInfoBuilder builder = new StageInfoBuilder(item);
    if (index < 0 || index >= stages.size()) {
        _visitables.get("stages").add(builder);
        stages.add(builder);
    } else {
        _visitables.get("stages").add(builder);
        stages.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cancelled == null)) {
        sb.append("cancelled:");
        sb.append(cancelled);
        sb.append(",");
    }
    if (!(completionTimestamp == null)) {
        sb.append("completionTimestamp:");
        sb.append(completionTimestamp);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(logSnippet == null)) {
        sb.append("logSnippet:");
        sb.append(logSnippet);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(output == null)) {
        sb.append("output:");
        sb.append(output);
        sb.append(",");
    }
    if (!(outputDockerImageReference == null)) {
        sb.append("outputDockerImageReference:");
        sb.append(outputDockerImageReference);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(stages == null) && !(stages.isEmpty())) {
        sb.append("stages:");
        sb.append(stages);
        sb.append(",");
    }
    if (!(startTimestamp == null)) {
        sb.append("startTimestamp:");
        sb.append(startTimestamp);
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
  
  public A withCancelled() {
    return withCancelled(true);
  }
  
  public A withCancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return (A) this;
  }
  
  public A withCompletionTimestamp(String completionTimestamp) {
    this.completionTimestamp = completionTimestamp;
    return (A) this;
  }
  
  public A withConditions(List<BuildCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (BuildCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(BuildCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (BuildCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConfig(ObjectReference config) {
    this._visitables.remove("config");
    if (config != null) {
        this.config = new ObjectReferenceBuilder(config);
        this._visitables.get("config").add(this.config);
    } else {
        this.config = null;
        this._visitables.get("config").remove(this.config);
    }
    return (A) this;
  }
  
  public A withDuration(Long duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withLogSnippet(String logSnippet) {
    this.logSnippet = logSnippet;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public ConfigNested<A> withNewConfig() {
    return new ConfigNested(null);
  }
  
  public ConfigNested<A> withNewConfigLike(ObjectReference item) {
    return new ConfigNested(item);
  }
  
  public OutputNested<A> withNewOutput() {
    return new OutputNested(null);
  }
  
  public OutputNested<A> withNewOutputLike(BuildStatusOutput item) {
    return new OutputNested(item);
  }
  
  public A withOutput(BuildStatusOutput output) {
    this._visitables.remove("output");
    if (output != null) {
        this.output = new BuildStatusOutputBuilder(output);
        this._visitables.get("output").add(this.output);
    } else {
        this.output = null;
        this._visitables.get("output").remove(this.output);
    }
    return (A) this;
  }
  
  public A withOutputDockerImageReference(String outputDockerImageReference) {
    this.outputDockerImageReference = outputDockerImageReference;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withStages(List<StageInfo> stages) {
    if (this.stages != null) {
      this._visitables.get("stages").clear();
    }
    if (stages != null) {
        this.stages = new ArrayList();
        for (StageInfo item : stages) {
          this.addToStages(item);
        }
    } else {
      this.stages = null;
    }
    return (A) this;
  }
  
  public A withStages(StageInfo... stages) {
    if (this.stages != null) {
        this.stages.clear();
        _visitables.remove("stages");
    }
    if (stages != null) {
      for (StageInfo item : stages) {
        this.addToStages(item);
      }
    }
    return (A) this;
  }
  
  public A withStartTimestamp(String startTimestamp) {
    this.startTimestamp = startTimestamp;
    return (A) this;
  }
  public class ConditionsNested<N> extends BuildConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    BuildConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,BuildCondition item) {
      this.index = index;
      this.builder = new BuildConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ConfigNested<N> extends ObjectReferenceFluent<ConfigNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ConfigNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStatusFluent.this.withConfig(builder.build());
    }
    
    public N endConfig() {
      return and();
    }
    
  }
  public class OutputNested<N> extends BuildStatusOutputFluent<OutputNested<N>> implements Nested<N>{
  
    BuildStatusOutputBuilder builder;
  
    OutputNested(BuildStatusOutput item) {
      this.builder = new BuildStatusOutputBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStatusFluent.this.withOutput(builder.build());
    }
    
    public N endOutput() {
      return and();
    }
    
  }
  public class StagesNested<N> extends StageInfoFluent<StagesNested<N>> implements Nested<N>{
  
    StageInfoBuilder builder;
    int index;
  
    StagesNested(int index,StageInfo item) {
      this.index = index;
      this.builder = new StageInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStatusFluent.this.setToStages(index, builder.build());
    }
    
    public N endStage() {
      return and();
    }
    
  }
}