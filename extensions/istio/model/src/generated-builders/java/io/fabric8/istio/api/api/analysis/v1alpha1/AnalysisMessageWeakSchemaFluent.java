package io.fabric8.istio.api.api.analysis.v1alpha1;

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
public class AnalysisMessageWeakSchemaFluent<A extends io.fabric8.istio.api.api.analysis.v1alpha1.AnalysisMessageWeakSchemaFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AnalysisMessageWeakSchemaArgTypeBuilder> args = new ArrayList<AnalysisMessageWeakSchemaArgTypeBuilder>();
  private String description;
  private AnalysisMessageBaseBuilder messageBase;
  private String template;

  public AnalysisMessageWeakSchemaFluent() {
  }
  
  public AnalysisMessageWeakSchemaFluent(AnalysisMessageWeakSchema instance) {
    this.copyInstance(instance);
  }

  public A addAllToArgs(Collection<AnalysisMessageWeakSchemaArgType> items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (AnalysisMessageWeakSchemaArgType item : items) {
        AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
        _visitables.get("args").add(builder);
        this.args.add(builder);
    }
    return (A) this;
  }
  
  public ArgsNested<A> addNewArg() {
    return new ArgsNested(-1, null);
  }
  
  public A addNewArg(String goType,String name) {
    return (A) this.addToArgs(new AnalysisMessageWeakSchemaArgType(goType, name));
  }
  
  public ArgsNested<A> addNewArgLike(AnalysisMessageWeakSchemaArgType item) {
    return new ArgsNested(-1, item);
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
  
  public A addToArgs(AnalysisMessageWeakSchemaArgType... items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (AnalysisMessageWeakSchemaArgType item : items) {
        AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
        _visitables.get("args").add(builder);
        this.args.add(builder);
    }
    return (A) this;
  }
  
  public A addToArgs(int index,AnalysisMessageWeakSchemaArgType item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
    if (index < 0 || index >= args.size()) {
        _visitables.get("args").add(builder);
        args.add(builder);
    } else {
        _visitables.get("args").add(builder);
        args.add(index, builder);
    }
    return (A) this;
  }
  
  public AnalysisMessageWeakSchemaArgType buildArg(int index) {
    return this.args.get(index).build();
  }
  
  public List<AnalysisMessageWeakSchemaArgType> buildArgs() {
    return this.args != null ? build(args) : null;
  }
  
  public AnalysisMessageWeakSchemaArgType buildFirstArg() {
    return this.args.get(0).build();
  }
  
  public AnalysisMessageWeakSchemaArgType buildLastArg() {
    return this.args.get(args.size() - 1).build();
  }
  
  public AnalysisMessageWeakSchemaArgType buildMatchingArg(Predicate<AnalysisMessageWeakSchemaArgTypeBuilder> predicate) {
      for (AnalysisMessageWeakSchemaArgTypeBuilder item : args) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AnalysisMessageBase buildMessageBase() {
    return this.messageBase != null ? this.messageBase.build() : null;
  }
  
  protected void copyInstance(AnalysisMessageWeakSchema instance) {
    instance = instance != null ? instance : new AnalysisMessageWeakSchema();
    if (instance != null) {
        this.withArgs(instance.getArgs());
        this.withDescription(instance.getDescription());
        this.withMessageBase(instance.getMessageBase());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ArgsNested<A> editArg(int index) {
    if (args.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "args"));
    }
    return this.setNewArgLike(index, this.buildArg(index));
  }
  
  public ArgsNested<A> editFirstArg() {
    if (args.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "args"));
    }
    return this.setNewArgLike(0, this.buildArg(0));
  }
  
  public ArgsNested<A> editLastArg() {
    int index = args.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "args"));
    }
    return this.setNewArgLike(index, this.buildArg(index));
  }
  
  public ArgsNested<A> editMatchingArg(Predicate<AnalysisMessageWeakSchemaArgTypeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < args.size();i++) {
      if (predicate.test(args.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "args"));
    }
    return this.setNewArgLike(index, this.buildArg(index));
  }
  
  public MessageBaseNested<A> editMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(null));
  }
  
  public MessageBaseNested<A> editOrNewMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(new AnalysisMessageBaseBuilder().build()));
  }
  
  public MessageBaseNested<A> editOrNewMessageBaseLike(AnalysisMessageBase item) {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(item));
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
    AnalysisMessageWeakSchemaFluent that = (AnalysisMessageWeakSchemaFluent) o;
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(messageBase, that.messageBase))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getTemplate() {
    return this.template;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArgs() {
    return this.args != null && !(this.args.isEmpty());
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasMatchingArg(Predicate<AnalysisMessageWeakSchemaArgTypeBuilder> predicate) {
      for (AnalysisMessageWeakSchemaArgTypeBuilder item : args) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessageBase() {
    return this.messageBase != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(args, description, messageBase, template, additionalProperties);
  }
  
  public A removeAllFromArgs(Collection<AnalysisMessageWeakSchemaArgType> items) {
    if (this.args == null) {
      return (A) this;
    }
    for (AnalysisMessageWeakSchemaArgType item : items) {
        AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
        _visitables.get("args").remove(builder);
        this.args.remove(builder);
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
  
  public A removeFromArgs(AnalysisMessageWeakSchemaArgType... items) {
    if (this.args == null) {
      return (A) this;
    }
    for (AnalysisMessageWeakSchemaArgType item : items) {
        AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
        _visitables.get("args").remove(builder);
        this.args.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromArgs(Predicate<AnalysisMessageWeakSchemaArgTypeBuilder> predicate) {
    if (args == null) {
      return (A) this;
    }
    Iterator<AnalysisMessageWeakSchemaArgTypeBuilder> each = args.iterator();
    List visitables = _visitables.get("args");
    while (each.hasNext()) {
        AnalysisMessageWeakSchemaArgTypeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ArgsNested<A> setNewArgLike(int index,AnalysisMessageWeakSchemaArgType item) {
    return new ArgsNested(index, item);
  }
  
  public A setToArgs(int index,AnalysisMessageWeakSchemaArgType item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    AnalysisMessageWeakSchemaArgTypeBuilder builder = new AnalysisMessageWeakSchemaArgTypeBuilder(item);
    if (index < 0 || index >= args.size()) {
        _visitables.get("args").add(builder);
        args.add(builder);
    } else {
        _visitables.get("args").add(builder);
        args.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(args == null) && !(args.isEmpty())) {
        sb.append("args:");
        sb.append(args);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(messageBase == null)) {
        sb.append("messageBase:");
        sb.append(messageBase);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withArgs(List<AnalysisMessageWeakSchemaArgType> args) {
    if (this.args != null) {
      this._visitables.get("args").clear();
    }
    if (args != null) {
        this.args = new ArrayList();
        for (AnalysisMessageWeakSchemaArgType item : args) {
          this.addToArgs(item);
        }
    } else {
      this.args = null;
    }
    return (A) this;
  }
  
  public A withArgs(AnalysisMessageWeakSchemaArgType... args) {
    if (this.args != null) {
        this.args.clear();
        _visitables.remove("args");
    }
    if (args != null) {
      for (AnalysisMessageWeakSchemaArgType item : args) {
        this.addToArgs(item);
      }
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withMessageBase(AnalysisMessageBase messageBase) {
    this._visitables.remove("messageBase");
    if (messageBase != null) {
        this.messageBase = new AnalysisMessageBaseBuilder(messageBase);
        this._visitables.get("messageBase").add(this.messageBase);
    } else {
        this.messageBase = null;
        this._visitables.get("messageBase").remove(this.messageBase);
    }
    return (A) this;
  }
  
  public MessageBaseNested<A> withNewMessageBase() {
    return new MessageBaseNested(null);
  }
  
  public MessageBaseNested<A> withNewMessageBaseLike(AnalysisMessageBase item) {
    return new MessageBaseNested(item);
  }
  
  public A withTemplate(String template) {
    this.template = template;
    return (A) this;
  }
  public class ArgsNested<N> extends AnalysisMessageWeakSchemaArgTypeFluent<ArgsNested<N>> implements Nested<N>{
  
    AnalysisMessageWeakSchemaArgTypeBuilder builder;
    int index;
  
    ArgsNested(int index,AnalysisMessageWeakSchemaArgType item) {
      this.index = index;
      this.builder = new AnalysisMessageWeakSchemaArgTypeBuilder(this, item);
    }
  
    public N and() {
      return (N) AnalysisMessageWeakSchemaFluent.this.setToArgs(index, builder.build());
    }
    
    public N endArg() {
      return and();
    }
    
  }
  public class MessageBaseNested<N> extends AnalysisMessageBaseFluent<MessageBaseNested<N>> implements Nested<N>{
  
    AnalysisMessageBaseBuilder builder;
  
    MessageBaseNested(AnalysisMessageBase item) {
      this.builder = new AnalysisMessageBaseBuilder(this, item);
    }
  
    public N and() {
      return (N) AnalysisMessageWeakSchemaFluent.this.withMessageBase(builder.build());
    }
    
    public N endMessageBase() {
      return and();
    }
    
  }
}