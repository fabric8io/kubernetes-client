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
public class PipelineTaskResourcesFluent<A extends io.fabric8.tekton.v1beta1.PipelineTaskResourcesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PipelineTaskInputResourceBuilder> inputs = new ArrayList<PipelineTaskInputResourceBuilder>();
  private ArrayList<PipelineTaskOutputResourceBuilder> outputs = new ArrayList<PipelineTaskOutputResourceBuilder>();

  public PipelineTaskResourcesFluent() {
  }
  
  public PipelineTaskResourcesFluent(PipelineTaskResources instance) {
    this.copyInstance(instance);
  }

  public A addAllToInputs(Collection<PipelineTaskInputResource> items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (PipelineTaskInputResource item : items) {
        PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOutputs(Collection<PipelineTaskOutputResource> items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (PipelineTaskOutputResource item : items) {
        PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
  }
  
  public InputsNested<A> addNewInput() {
    return new InputsNested(-1, null);
  }
  
  public InputsNested<A> addNewInputLike(PipelineTaskInputResource item) {
    return new InputsNested(-1, item);
  }
  
  public OutputsNested<A> addNewOutput() {
    return new OutputsNested(-1, null);
  }
  
  public A addNewOutput(String name,String resource) {
    return (A) this.addToOutputs(new PipelineTaskOutputResource(name, resource));
  }
  
  public OutputsNested<A> addNewOutputLike(PipelineTaskOutputResource item) {
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
  
  public A addToInputs(PipelineTaskInputResource... items) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    for (PipelineTaskInputResource item : items) {
        PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
        _visitables.get("inputs").add(builder);
        this.inputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToInputs(int index,PipelineTaskInputResource item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(PipelineTaskOutputResource... items) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    for (PipelineTaskOutputResource item : items) {
        PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
        _visitables.get("outputs").add(builder);
        this.outputs.add(builder);
    }
    return (A) this;
  }
  
  public A addToOutputs(int index,PipelineTaskOutputResource item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
    if (index < 0 || index >= outputs.size()) {
        _visitables.get("outputs").add(builder);
        outputs.add(builder);
    } else {
        _visitables.get("outputs").add(builder);
        outputs.add(index, builder);
    }
    return (A) this;
  }
  
  public PipelineTaskInputResource buildFirstInput() {
    return this.inputs.get(0).build();
  }
  
  public PipelineTaskOutputResource buildFirstOutput() {
    return this.outputs.get(0).build();
  }
  
  public PipelineTaskInputResource buildInput(int index) {
    return this.inputs.get(index).build();
  }
  
  public List<PipelineTaskInputResource> buildInputs() {
    return this.inputs != null ? build(inputs) : null;
  }
  
  public PipelineTaskInputResource buildLastInput() {
    return this.inputs.get(inputs.size() - 1).build();
  }
  
  public PipelineTaskOutputResource buildLastOutput() {
    return this.outputs.get(outputs.size() - 1).build();
  }
  
  public PipelineTaskInputResource buildMatchingInput(Predicate<PipelineTaskInputResourceBuilder> predicate) {
      for (PipelineTaskInputResourceBuilder item : inputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTaskOutputResource buildMatchingOutput(Predicate<PipelineTaskOutputResourceBuilder> predicate) {
      for (PipelineTaskOutputResourceBuilder item : outputs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PipelineTaskOutputResource buildOutput(int index) {
    return this.outputs.get(index).build();
  }
  
  public List<PipelineTaskOutputResource> buildOutputs() {
    return this.outputs != null ? build(outputs) : null;
  }
  
  protected void copyInstance(PipelineTaskResources instance) {
    instance = instance != null ? instance : new PipelineTaskResources();
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
  
  public InputsNested<A> editMatchingInput(Predicate<PipelineTaskInputResourceBuilder> predicate) {
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
  
  public OutputsNested<A> editMatchingOutput(Predicate<PipelineTaskOutputResourceBuilder> predicate) {
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
    PipelineTaskResourcesFluent that = (PipelineTaskResourcesFluent) o;
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
  
  public boolean hasMatchingInput(Predicate<PipelineTaskInputResourceBuilder> predicate) {
      for (PipelineTaskInputResourceBuilder item : inputs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOutput(Predicate<PipelineTaskOutputResourceBuilder> predicate) {
      for (PipelineTaskOutputResourceBuilder item : outputs) {
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
  
  public A removeAllFromInputs(Collection<PipelineTaskInputResource> items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (PipelineTaskInputResource item : items) {
        PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOutputs(Collection<PipelineTaskOutputResource> items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (PipelineTaskOutputResource item : items) {
        PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
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
  
  public A removeFromInputs(PipelineTaskInputResource... items) {
    if (this.inputs == null) {
      return (A) this;
    }
    for (PipelineTaskInputResource item : items) {
        PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
        _visitables.get("inputs").remove(builder);
        this.inputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOutputs(PipelineTaskOutputResource... items) {
    if (this.outputs == null) {
      return (A) this;
    }
    for (PipelineTaskOutputResource item : items) {
        PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
        _visitables.get("outputs").remove(builder);
        this.outputs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInputs(Predicate<PipelineTaskInputResourceBuilder> predicate) {
    if (inputs == null) {
      return (A) this;
    }
    Iterator<PipelineTaskInputResourceBuilder> each = inputs.iterator();
    List visitables = _visitables.get("inputs");
    while (each.hasNext()) {
        PipelineTaskInputResourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOutputs(Predicate<PipelineTaskOutputResourceBuilder> predicate) {
    if (outputs == null) {
      return (A) this;
    }
    Iterator<PipelineTaskOutputResourceBuilder> each = outputs.iterator();
    List visitables = _visitables.get("outputs");
    while (each.hasNext()) {
        PipelineTaskOutputResourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InputsNested<A> setNewInputLike(int index,PipelineTaskInputResource item) {
    return new InputsNested(index, item);
  }
  
  public OutputsNested<A> setNewOutputLike(int index,PipelineTaskOutputResource item) {
    return new OutputsNested(index, item);
  }
  
  public A setToInputs(int index,PipelineTaskInputResource item) {
    if (this.inputs == null) {
      this.inputs = new ArrayList();
    }
    PipelineTaskInputResourceBuilder builder = new PipelineTaskInputResourceBuilder(item);
    if (index < 0 || index >= inputs.size()) {
        _visitables.get("inputs").add(builder);
        inputs.add(builder);
    } else {
        _visitables.get("inputs").add(builder);
        inputs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOutputs(int index,PipelineTaskOutputResource item) {
    if (this.outputs == null) {
      this.outputs = new ArrayList();
    }
    PipelineTaskOutputResourceBuilder builder = new PipelineTaskOutputResourceBuilder(item);
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
  
  public A withInputs(List<PipelineTaskInputResource> inputs) {
    if (this.inputs != null) {
      this._visitables.get("inputs").clear();
    }
    if (inputs != null) {
        this.inputs = new ArrayList();
        for (PipelineTaskInputResource item : inputs) {
          this.addToInputs(item);
        }
    } else {
      this.inputs = null;
    }
    return (A) this;
  }
  
  public A withInputs(PipelineTaskInputResource... inputs) {
    if (this.inputs != null) {
        this.inputs.clear();
        _visitables.remove("inputs");
    }
    if (inputs != null) {
      for (PipelineTaskInputResource item : inputs) {
        this.addToInputs(item);
      }
    }
    return (A) this;
  }
  
  public A withOutputs(List<PipelineTaskOutputResource> outputs) {
    if (this.outputs != null) {
      this._visitables.get("outputs").clear();
    }
    if (outputs != null) {
        this.outputs = new ArrayList();
        for (PipelineTaskOutputResource item : outputs) {
          this.addToOutputs(item);
        }
    } else {
      this.outputs = null;
    }
    return (A) this;
  }
  
  public A withOutputs(PipelineTaskOutputResource... outputs) {
    if (this.outputs != null) {
        this.outputs.clear();
        _visitables.remove("outputs");
    }
    if (outputs != null) {
      for (PipelineTaskOutputResource item : outputs) {
        this.addToOutputs(item);
      }
    }
    return (A) this;
  }
  public class InputsNested<N> extends PipelineTaskInputResourceFluent<InputsNested<N>> implements Nested<N>{
  
    PipelineTaskInputResourceBuilder builder;
    int index;
  
    InputsNested(int index,PipelineTaskInputResource item) {
      this.index = index;
      this.builder = new PipelineTaskInputResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskResourcesFluent.this.setToInputs(index, builder.build());
    }
    
    public N endInput() {
      return and();
    }
    
  }
  public class OutputsNested<N> extends PipelineTaskOutputResourceFluent<OutputsNested<N>> implements Nested<N>{
  
    PipelineTaskOutputResourceBuilder builder;
    int index;
  
    OutputsNested(int index,PipelineTaskOutputResource item) {
      this.index = index;
      this.builder = new PipelineTaskOutputResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineTaskResourcesFluent.this.setToOutputs(index, builder.build());
    }
    
    public N endOutput() {
      return and();
    }
    
  }
}