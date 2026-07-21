package io.fabric8.tekton.v1beta1;

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
public class TaskRunResourcesFluent<A extends io.fabric8.tekton.v1beta1.TaskRunResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TaskResourceBindingBuilder> inputs = new ArrayList<TaskResourceBindingBuilder>();
  private ArrayList<TaskResourceBindingBuilder> outputs = new ArrayList<TaskResourceBindingBuilder>();

  public TaskRunResourcesFluent() {
  }
  
  public TaskRunResourcesFluent(TaskRunResources instance) {
    this.copyInstance(instance);
  }

  public A addAllToInputs(Collection<TaskResourceBinding> items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOutputs(Collection<TaskResourceBinding> items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
  }
  
  public InputsNested<A> addNewInput() {
    return new InputsNested(-1, null);
  }
  
  public InputsNested<A> addNewInputLike(TaskResourceBinding item) {
    return new InputsNested(-1, item);
  }
  
  public OutputsNested<A> addNewOutput() {
    return new OutputsNested(-1, null);
  }
  
  public OutputsNested<A> addNewOutputLike(TaskResourceBinding item) {
    return new OutputsNested(-1, item);
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
  
  public A addToInputs(TaskResourceBinding... items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToInputs(int index,TaskResourceBinding item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(TaskResourceBinding... items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(int index,TaskResourceBinding item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
    if (index < 0 || index >= outputs.size()) {
        _visitables.get("outputs").add(builder);
        outputs.add(builder);
    } else {
        _visitables.get("outputs").add(builder);
        outputs.add(index, builder);
    }
    return (A) this;
  }
  
  public TaskResourceBinding buildFirstInput() {
    return this.inputs.get(0).build();
  }
  
  public TaskResourceBinding buildFirstOutput() {
    return this.outputs.get(0).build();
  }
  
  public TaskResourceBinding buildInput(int index) {
    return this.inputs.get(index).build();
  }
  
  public List<TaskResourceBinding> buildInputs() {
    return this.inputs != null ? build(inputs) : null;
  }
  
  public TaskResourceBinding buildLastInput() {
    return this.inputs.get(inputs.size() - 1).build();
  }
  
  public TaskResourceBinding buildLastOutput() {
    return this.outputs.get(outputs.size() - 1).build();
  }
  
  public TaskResourceBinding buildMatchingInput(Predicate<TaskResourceBindingBuilder> predicate) {
      for (TaskResourceBindingBuilder item : inputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskResourceBinding buildMatchingOutput(Predicate<TaskResourceBindingBuilder> predicate) {
      for (TaskResourceBindingBuilder item : outputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TaskResourceBinding buildOutput(int index) {
    return this.outputs.get(index).build();
  }
  
  public List<TaskResourceBinding> buildOutputs() {
    return this.outputs != null ? build(outputs) : null;
  }
  
  protected void copyInstance(TaskRunResources instance) {
    instance = instance != null ? instance : new TaskRunResources();
    if (instance != null) {
        this.withInputs(instance.getInputs());
        this.withOutputs(instance.getOutputs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InputsNested<A> editFirstInput() {
    if (inputs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "inputs"));
    }
    return this.setNewInputLike(0, this.buildInput(0));
  }
  
  public OutputsNested<A> editFirstOutput() {
    if (outputs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "outputs"));
    }
    return this.setNewOutputLike(0, this.buildOutput(0));
  }
  
  public InputsNested<A> editInput(int index) {
    if (inputs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public InputsNested<A> editLastInput() {
    int index = inputs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public OutputsNested<A> editLastOutput() {
    int index = outputs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
  }
  
  public InputsNested<A> editMatchingInput(Predicate<TaskResourceBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < inputs.size();i++) {
      if (predicate.test(inputs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "inputs"));
    }
    return this.setNewInputLike(index, this.buildInput(index));
  }
  
  public OutputsNested<A> editMatchingOutput(Predicate<TaskResourceBindingBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < outputs.size();i++) {
      if (predicate.test(outputs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
  }
  
  public OutputsNested<A> editOutput(int index) {
    if (outputs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "outputs"));
    }
    return this.setNewOutputLike(index, this.buildOutput(index));
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
    TaskRunResourcesFluent that = (TaskRunResourcesFluent) o;
    if (!(Objects.equals(inputs, that.inputs))) {
      return false;
    }
    if (!(Objects.equals(outputs, that.outputs))) {
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
  
  public boolean hasInputs() {
    return this.inputs != null && !(this.inputs.isEmpty());
  }
  
  public boolean hasMatchingInput(Predicate<TaskResourceBindingBuilder> predicate) {
      for (TaskResourceBindingBuilder item : inputs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOutput(Predicate<TaskResourceBindingBuilder> predicate) {
      for (TaskResourceBindingBuilder item : outputs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOutputs() {
    return this.outputs != null && !(this.outputs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(inputs, outputs, additionalProperties);
  }
  
  public A removeAllFromInputs(Collection<TaskResourceBinding> items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOutputs(Collection<TaskResourceBinding> items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("outputs").remove(builder);
        this.outputs.remove(builder);
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
  
  public A removeFromInputs(TaskResourceBinding... items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOutputs(TaskResourceBinding... items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (TaskResourceBinding item : items) {
        TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
        _visitables.get("outputs").remove(builder);
        this.outputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInputs(Predicate<TaskResourceBindingBuilder> predicate) {
    if (inputs == null) {
      return (A) this;
    }
    Iterator<TaskResourceBindingBuilder> each = inputs.iterator();
    List visitables = _visitables.get("inputs");
    while (each.hasNext()) {
        TaskResourceBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOutputs(Predicate<TaskResourceBindingBuilder> predicate) {
    if (outputs == null) {
      return (A) this;
    }
    Iterator<TaskResourceBindingBuilder> each = outputs.iterator();
    List visitables = _visitables.get("outputs");
    while (each.hasNext()) {
        TaskResourceBindingBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InputsNested<A> setNewInputLike(int index,TaskResourceBinding item) {
    return new InputsNested(index, item);
  }
  
  public OutputsNested<A> setNewOutputLike(int index,TaskResourceBinding item) {
    return new OutputsNested(index, item);
  }
  
  public A setToInputs(int index,TaskResourceBinding item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOutputs(int index,TaskResourceBinding item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    TaskResourceBindingBuilder builder = new TaskResourceBindingBuilder(item);
    if (index < 0 || index >= outputs.size()) {
        _visitables.get("outputs").add(builder);
        outputs.add(builder);
    } else {
        _visitables.get("outputs").add(builder);
        outputs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(inputs == null) && !(inputs.isEmpty())) {
        sb.append("inputs:");
        sb.append(inputs);
        sb.append(",");
    }
    if (!(outputs == null) && !(outputs.isEmpty())) {
        sb.append("outputs:");
        sb.append(outputs);
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
  
  public A withInputs(List<TaskResourceBinding> inputs) {
    if (this.inputs != null) {
      this._visitables.get("inputs").clear();
    }
    if (inputs != null) {
        this.inputs = new ArrayList();
        for (TaskResourceBinding item : inputs) {
          this.addToInputs(item);
        }
    } else {
      this.inputs = null;
    }
    return (A) this;
  }
  
  public A withInputs(TaskResourceBinding... inputs) {
    if (this.inputs != null) {
        this.inputs.clear();
        _visitables.remove("inputs");
    }
    if (inputs != null) {
      for (TaskResourceBinding item : inputs) {
        this.addToInputs(item);
      }
    }
    return (A) this;
  }
  
  public A withOutputs(List<TaskResourceBinding> outputs) {
    if (this.outputs != null) {
      this._visitables.get("outputs").clear();
    }
    if (outputs != null) {
        this.outputs = new ArrayList();
        for (TaskResourceBinding item : outputs) {
          this.addToOutputs(item);
        }
    } else {
      this.outputs = null;
    }
    return (A) this;
  }
  
  public A withOutputs(TaskResourceBinding... outputs) {
    if (this.outputs != null) {
        this.outputs.clear();
        _visitables.remove("outputs");
    }
    if (outputs != null) {
      for (TaskResourceBinding item : outputs) {
        this.addToOutputs(item);
      }
    }
    return (A) this;
  }
  public class InputsNested<N> extends TaskResourceBindingFluent<InputsNested<N>> implements Nested<N>{
  
    TaskResourceBindingBuilder builder;
    int index;
  
    InputsNested(int index,TaskResourceBinding item) {
      this.index = index;
      this.builder = new TaskResourceBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunResourcesFluent.this.setToInputs(index, builder.build());
    }
    
    public N endInput() {
      return and();
    }
    
  }
  public class OutputsNested<N> extends TaskResourceBindingFluent<OutputsNested<N>> implements Nested<N>{
  
    TaskResourceBindingBuilder builder;
    int index;
  
    OutputsNested(int index,TaskResourceBinding item) {
      this.index = index;
      this.builder = new TaskResourceBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) TaskRunResourcesFluent.this.setToOutputs(index, builder.build());
    }
    
    public N endOutput() {
      return and();
    }
    
  }
}