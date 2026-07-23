package io.fabric8.knative.flows.v1;

import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpec;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpecBuilder;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpecFluent;
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
public class SequenceSpecFluent<A extends io.fabric8.knative.flows.v1.SequenceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ChannelTemplateSpecBuilder channelTemplate;
  private DestinationBuilder reply;
  private ArrayList<SequenceStepBuilder> steps = new ArrayList<SequenceStepBuilder>();

  public SequenceSpecFluent() {
  }
  
  public SequenceSpecFluent(SequenceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSteps(Collection<SequenceStep> items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (SequenceStep item : items) {
        SequenceStepBuilder builder = new SequenceStepBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public StepsNested<A> addNewStep() {
    return new StepsNested(-1, null);
  }
  
  public StepsNested<A> addNewStepLike(SequenceStep item) {
    return new StepsNested(-1, item);
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
  
  public A addToSteps(SequenceStep... items) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    for (SequenceStep item : items) {
        SequenceStepBuilder builder = new SequenceStepBuilder(item);
        _visitables.get("steps").add(builder);
        this.steps.add(builder);
    }
    return (A) this;
  }
  
  public A addToSteps(int index,SequenceStep item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    SequenceStepBuilder builder = new SequenceStepBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.add(index, builder);
    }
    return (A) this;
  }
  
  public ChannelTemplateSpec buildChannelTemplate() {
    return this.channelTemplate != null ? this.channelTemplate.build() : null;
  }
  
  public SequenceStep buildFirstStep() {
    return this.steps.get(0).build();
  }
  
  public SequenceStep buildLastStep() {
    return this.steps.get(steps.size() - 1).build();
  }
  
  public SequenceStep buildMatchingStep(Predicate<SequenceStepBuilder> predicate) {
      for (SequenceStepBuilder item : steps) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Destination buildReply() {
    return this.reply != null ? this.reply.build() : null;
  }
  
  public SequenceStep buildStep(int index) {
    return this.steps.get(index).build();
  }
  
  public List<SequenceStep> buildSteps() {
    return this.steps != null ? build(steps) : null;
  }
  
  protected void copyInstance(SequenceSpec instance) {
    instance = instance != null ? instance : new SequenceSpec();
    if (instance != null) {
        this.withChannelTemplate(instance.getChannelTemplate());
        this.withReply(instance.getReply());
        this.withSteps(instance.getSteps());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChannelTemplateNested<A> editChannelTemplate() {
    return this.withNewChannelTemplateLike(Optional.ofNullable(this.buildChannelTemplate()).orElse(null));
  }
  
  public StepsNested<A> editFirstStep() {
    if (steps.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(0, this.buildStep(0));
  }
  
  public StepsNested<A> editLastStep() {
    int index = steps.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public StepsNested<A> editMatchingStep(Predicate<SequenceStepBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < steps.size();i++) {
      if (predicate.test(steps.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
  }
  
  public ChannelTemplateNested<A> editOrNewChannelTemplate() {
    return this.withNewChannelTemplateLike(Optional.ofNullable(this.buildChannelTemplate()).orElse(new ChannelTemplateSpecBuilder().build()));
  }
  
  public ChannelTemplateNested<A> editOrNewChannelTemplateLike(ChannelTemplateSpec item) {
    return this.withNewChannelTemplateLike(Optional.ofNullable(this.buildChannelTemplate()).orElse(item));
  }
  
  public ReplyNested<A> editOrNewReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(new DestinationBuilder().build()));
  }
  
  public ReplyNested<A> editOrNewReplyLike(Destination item) {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(item));
  }
  
  public ReplyNested<A> editReply() {
    return this.withNewReplyLike(Optional.ofNullable(this.buildReply()).orElse(null));
  }
  
  public StepsNested<A> editStep(int index) {
    if (steps.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "steps"));
    }
    return this.setNewStepLike(index, this.buildStep(index));
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
    SequenceSpecFluent that = (SequenceSpecFluent) o;
    if (!(Objects.equals(channelTemplate, that.channelTemplate))) {
      return false;
    }
    if (!(Objects.equals(reply, that.reply))) {
      return false;
    }
    if (!(Objects.equals(steps, that.steps))) {
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
  
  public boolean hasChannelTemplate() {
    return this.channelTemplate != null;
  }
  
  public boolean hasMatchingStep(Predicate<SequenceStepBuilder> predicate) {
      for (SequenceStepBuilder item : steps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReply() {
    return this.reply != null;
  }
  
  public boolean hasSteps() {
    return this.steps != null && !(this.steps.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(channelTemplate, reply, steps, additionalProperties);
  }
  
  public A removeAllFromSteps(Collection<SequenceStep> items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (SequenceStep item : items) {
        SequenceStepBuilder builder = new SequenceStepBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
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
  
  public A removeFromSteps(SequenceStep... items) {
    if (this.steps == null) {
      return (A) this;
    }
    for (SequenceStep item : items) {
        SequenceStepBuilder builder = new SequenceStepBuilder(item);
        _visitables.get("steps").remove(builder);
        this.steps.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSteps(Predicate<SequenceStepBuilder> predicate) {
    if (steps == null) {
      return (A) this;
    }
    Iterator<SequenceStepBuilder> each = steps.iterator();
    List visitables = _visitables.get("steps");
    while (each.hasNext()) {
        SequenceStepBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public StepsNested<A> setNewStepLike(int index,SequenceStep item) {
    return new StepsNested(index, item);
  }
  
  public A setToSteps(int index,SequenceStep item) {
    if (this.steps == null) {
      this.steps = new ArrayList();
    }
    SequenceStepBuilder builder = new SequenceStepBuilder(item);
    if (index < 0 || index >= steps.size()) {
        _visitables.get("steps").add(builder);
        steps.add(builder);
    } else {
        _visitables.get("steps").add(builder);
        steps.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(channelTemplate == null)) {
        sb.append("channelTemplate:");
        sb.append(channelTemplate);
        sb.append(",");
    }
    if (!(reply == null)) {
        sb.append("reply:");
        sb.append(reply);
        sb.append(",");
    }
    if (!(steps == null) && !(steps.isEmpty())) {
        sb.append("steps:");
        sb.append(steps);
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
  
  public A withChannelTemplate(ChannelTemplateSpec channelTemplate) {
    this._visitables.remove("channelTemplate");
    if (channelTemplate != null) {
        this.channelTemplate = new ChannelTemplateSpecBuilder(channelTemplate);
        this._visitables.get("channelTemplate").add(this.channelTemplate);
    } else {
        this.channelTemplate = null;
        this._visitables.get("channelTemplate").remove(this.channelTemplate);
    }
    return (A) this;
  }
  
  public ChannelTemplateNested<A> withNewChannelTemplate() {
    return new ChannelTemplateNested(null);
  }
  
  public A withNewChannelTemplate(String apiVersion,String kind,Object spec) {
    return (A) this.withChannelTemplate(new ChannelTemplateSpec(apiVersion, kind, spec));
  }
  
  public ChannelTemplateNested<A> withNewChannelTemplateLike(ChannelTemplateSpec item) {
    return new ChannelTemplateNested(item);
  }
  
  public ReplyNested<A> withNewReply() {
    return new ReplyNested(null);
  }
  
  public ReplyNested<A> withNewReplyLike(Destination item) {
    return new ReplyNested(item);
  }
  
  public A withReply(Destination reply) {
    this._visitables.remove("reply");
    if (reply != null) {
        this.reply = new DestinationBuilder(reply);
        this._visitables.get("reply").add(this.reply);
    } else {
        this.reply = null;
        this._visitables.get("reply").remove(this.reply);
    }
    return (A) this;
  }
  
  public A withSteps(List<SequenceStep> steps) {
    if (this.steps != null) {
      this._visitables.get("steps").clear();
    }
    if (steps != null) {
        this.steps = new ArrayList();
        for (SequenceStep item : steps) {
          this.addToSteps(item);
        }
    } else {
      this.steps = null;
    }
    return (A) this;
  }
  
  public A withSteps(SequenceStep... steps) {
    if (this.steps != null) {
        this.steps.clear();
        _visitables.remove("steps");
    }
    if (steps != null) {
      for (SequenceStep item : steps) {
        this.addToSteps(item);
      }
    }
    return (A) this;
  }
  public class ChannelTemplateNested<N> extends ChannelTemplateSpecFluent<ChannelTemplateNested<N>> implements Nested<N>{
  
    ChannelTemplateSpecBuilder builder;
  
    ChannelTemplateNested(ChannelTemplateSpec item) {
      this.builder = new ChannelTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceSpecFluent.this.withChannelTemplate(builder.build());
    }
    
    public N endChannelTemplate() {
      return and();
    }
    
  }
  public class ReplyNested<N> extends DestinationFluent<ReplyNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    ReplyNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceSpecFluent.this.withReply(builder.build());
    }
    
    public N endReply() {
      return and();
    }
    
  }
  public class StepsNested<N> extends SequenceStepFluent<StepsNested<N>> implements Nested<N>{
  
    SequenceStepBuilder builder;
    int index;
  
    StepsNested(int index,SequenceStep item) {
      this.index = index;
      this.builder = new SequenceStepBuilder(this, item);
    }
  
    public N and() {
      return (N) SequenceSpecFluent.this.setToSteps(index, builder.build());
    }
    
    public N endStep() {
      return and();
    }
    
  }
}