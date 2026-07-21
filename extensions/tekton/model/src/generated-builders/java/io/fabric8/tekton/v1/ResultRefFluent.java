package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ResultRefFluent<A extends io.fabric8.tekton.v1.ResultRefFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String pipelineTask;
  private String property;
  private String result;
  private Integer resultsIndex;

  public ResultRefFluent() {
  }
  
  public ResultRefFluent(ResultRef instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(ResultRef instance) {
    instance = instance != null ? instance : new ResultRef();
    if (instance != null) {
        this.withPipelineTask(instance.getPipelineTask());
        this.withProperty(instance.getProperty());
        this.withResult(instance.getResult());
        this.withResultsIndex(instance.getResultsIndex());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ResultRefFluent that = (ResultRefFluent) o;
    if (!(Objects.equals(pipelineTask, that.pipelineTask))) {
      return false;
    }
    if (!(Objects.equals(property, that.property))) {
      return false;
    }
    if (!(Objects.equals(result, that.result))) {
      return false;
    }
    if (!(Objects.equals(resultsIndex, that.resultsIndex))) {
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
  
  public String getPipelineTask() {
    return this.pipelineTask;
  }
  
  public String getProperty() {
    return this.property;
  }
  
  public String getResult() {
    return this.result;
  }
  
  public Integer getResultsIndex() {
    return this.resultsIndex;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPipelineTask() {
    return this.pipelineTask != null;
  }
  
  public boolean hasProperty() {
    return this.property != null;
  }
  
  public boolean hasResult() {
    return this.result != null;
  }
  
  public boolean hasResultsIndex() {
    return this.resultsIndex != null;
  }
  
  public int hashCode() {
    return Objects.hash(pipelineTask, property, result, resultsIndex, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(pipelineTask == null)) {
        sb.append("pipelineTask:");
        sb.append(pipelineTask);
        sb.append(",");
    }
    if (!(property == null)) {
        sb.append("property:");
        sb.append(property);
        sb.append(",");
    }
    if (!(result == null)) {
        sb.append("result:");
        sb.append(result);
        sb.append(",");
    }
    if (!(resultsIndex == null)) {
        sb.append("resultsIndex:");
        sb.append(resultsIndex);
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
  
  public A withPipelineTask(String pipelineTask) {
    this.pipelineTask = pipelineTask;
    return (A) this;
  }
  
  public A withProperty(String property) {
    this.property = property;
    return (A) this;
  }
  
  public A withResult(String result) {
    this.result = result;
    return (A) this;
  }
  
  public A withResultsIndex(Integer resultsIndex) {
    this.resultsIndex = resultsIndex;
    return (A) this;
  }
  
}