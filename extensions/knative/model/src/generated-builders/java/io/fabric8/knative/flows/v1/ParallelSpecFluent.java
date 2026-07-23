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
public class ParallelSpecFluent<A extends io.fabric8.knative.flows.v1.ParallelSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ParallelBranchBuilder> branches = new ArrayList<ParallelBranchBuilder>();
  private ChannelTemplateSpecBuilder channelTemplate;
  private DestinationBuilder reply;

  public ParallelSpecFluent() {
  }
  
  public ParallelSpecFluent(ParallelSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBranches(Collection<ParallelBranch> items) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    for (ParallelBranch item : items) {
        ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
        _visitables.get("branches").add(builder);
        this.branches.add(builder);
    }
    return (A) this;
  }
  
  public BranchesNested<A> addNewBranch() {
    return new BranchesNested(-1, null);
  }
  
  public BranchesNested<A> addNewBranchLike(ParallelBranch item) {
    return new BranchesNested(-1, item);
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
  
  public A addToBranches(ParallelBranch... items) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    for (ParallelBranch item : items) {
        ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
        _visitables.get("branches").add(builder);
        this.branches.add(builder);
    }
    return (A) this;
  }
  
  public A addToBranches(int index,ParallelBranch item) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
    if (index < 0 || index >= branches.size()) {
        _visitables.get("branches").add(builder);
        branches.add(builder);
    } else {
        _visitables.get("branches").add(builder);
        branches.add(index, builder);
    }
    return (A) this;
  }
  
  public ParallelBranch buildBranch(int index) {
    return this.branches.get(index).build();
  }
  
  public List<ParallelBranch> buildBranches() {
    return this.branches != null ? build(branches) : null;
  }
  
  public ChannelTemplateSpec buildChannelTemplate() {
    return this.channelTemplate != null ? this.channelTemplate.build() : null;
  }
  
  public ParallelBranch buildFirstBranch() {
    return this.branches.get(0).build();
  }
  
  public ParallelBranch buildLastBranch() {
    return this.branches.get(branches.size() - 1).build();
  }
  
  public ParallelBranch buildMatchingBranch(Predicate<ParallelBranchBuilder> predicate) {
      for (ParallelBranchBuilder item : branches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Destination buildReply() {
    return this.reply != null ? this.reply.build() : null;
  }
  
  protected void copyInstance(ParallelSpec instance) {
    instance = instance != null ? instance : new ParallelSpec();
    if (instance != null) {
        this.withBranches(instance.getBranches());
        this.withChannelTemplate(instance.getChannelTemplate());
        this.withReply(instance.getReply());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BranchesNested<A> editBranch(int index) {
    if (branches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
  }
  
  public ChannelTemplateNested<A> editChannelTemplate() {
    return this.withNewChannelTemplateLike(Optional.ofNullable(this.buildChannelTemplate()).orElse(null));
  }
  
  public BranchesNested<A> editFirstBranch() {
    if (branches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "branches"));
    }
    return this.setNewBranchLike(0, this.buildBranch(0));
  }
  
  public BranchesNested<A> editLastBranch() {
    int index = branches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
  }
  
  public BranchesNested<A> editMatchingBranch(Predicate<ParallelBranchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < branches.size();i++) {
      if (predicate.test(branches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "branches"));
    }
    return this.setNewBranchLike(index, this.buildBranch(index));
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
    ParallelSpecFluent that = (ParallelSpecFluent) o;
    if (!(Objects.equals(branches, that.branches))) {
      return false;
    }
    if (!(Objects.equals(channelTemplate, that.channelTemplate))) {
      return false;
    }
    if (!(Objects.equals(reply, that.reply))) {
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
  
  public boolean hasBranches() {
    return this.branches != null && !(this.branches.isEmpty());
  }
  
  public boolean hasChannelTemplate() {
    return this.channelTemplate != null;
  }
  
  public boolean hasMatchingBranch(Predicate<ParallelBranchBuilder> predicate) {
      for (ParallelBranchBuilder item : branches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReply() {
    return this.reply != null;
  }
  
  public int hashCode() {
    return Objects.hash(branches, channelTemplate, reply, additionalProperties);
  }
  
  public A removeAllFromBranches(Collection<ParallelBranch> items) {
    if (this.branches == null) {
      return (A) this;
    }
    for (ParallelBranch item : items) {
        ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
        _visitables.get("branches").remove(builder);
        this.branches.remove(builder);
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
  
  public A removeFromBranches(ParallelBranch... items) {
    if (this.branches == null) {
      return (A) this;
    }
    for (ParallelBranch item : items) {
        ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
        _visitables.get("branches").remove(builder);
        this.branches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBranches(Predicate<ParallelBranchBuilder> predicate) {
    if (branches == null) {
      return (A) this;
    }
    Iterator<ParallelBranchBuilder> each = branches.iterator();
    List visitables = _visitables.get("branches");
    while (each.hasNext()) {
        ParallelBranchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BranchesNested<A> setNewBranchLike(int index,ParallelBranch item) {
    return new BranchesNested(index, item);
  }
  
  public A setToBranches(int index,ParallelBranch item) {
    if (this.branches == null) {
      this.branches = new ArrayList();
    }
    ParallelBranchBuilder builder = new ParallelBranchBuilder(item);
    if (index < 0 || index >= branches.size()) {
        _visitables.get("branches").add(builder);
        branches.add(builder);
    } else {
        _visitables.get("branches").add(builder);
        branches.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(branches == null) && !(branches.isEmpty())) {
        sb.append("branches:");
        sb.append(branches);
        sb.append(",");
    }
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
  
  public A withBranches(List<ParallelBranch> branches) {
    if (this.branches != null) {
      this._visitables.get("branches").clear();
    }
    if (branches != null) {
        this.branches = new ArrayList();
        for (ParallelBranch item : branches) {
          this.addToBranches(item);
        }
    } else {
      this.branches = null;
    }
    return (A) this;
  }
  
  public A withBranches(ParallelBranch... branches) {
    if (this.branches != null) {
        this.branches.clear();
        _visitables.remove("branches");
    }
    if (branches != null) {
      for (ParallelBranch item : branches) {
        this.addToBranches(item);
      }
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
  public class BranchesNested<N> extends ParallelBranchFluent<BranchesNested<N>> implements Nested<N>{
  
    ParallelBranchBuilder builder;
    int index;
  
    BranchesNested(int index,ParallelBranch item) {
      this.index = index;
      this.builder = new ParallelBranchBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelSpecFluent.this.setToBranches(index, builder.build());
    }
    
    public N endBranch() {
      return and();
    }
    
  }
  public class ChannelTemplateNested<N> extends ChannelTemplateSpecFluent<ChannelTemplateNested<N>> implements Nested<N>{
  
    ChannelTemplateSpecBuilder builder;
  
    ChannelTemplateNested(ChannelTemplateSpec item) {
      this.builder = new ChannelTemplateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ParallelSpecFluent.this.withChannelTemplate(builder.build());
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
      return (N) ParallelSpecFluent.this.withReply(builder.build());
    }
    
    public N endReply() {
      return and();
    }
    
  }
}