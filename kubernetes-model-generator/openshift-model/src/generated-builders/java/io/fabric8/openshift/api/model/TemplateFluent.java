package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class TemplateFluent<A extends io.fabric8.openshift.api.model.TemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private Map<String,String> labels;
  private String message;
  private ObjectMetaBuilder metadata;
  private List<Object> objects = new ArrayList<Object>();
  private ArrayList<ParameterBuilder> parameters = new ArrayList<ParameterBuilder>();

  public TemplateFluent() {
  }
  
  public TemplateFluent(Template instance) {
    this.copyInstance(instance);
  }

  public A addAllToObjects(Collection<Object> items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (Object item : items) {
      this.objects.add(item);
    }
    return (A) this;
  }
  
  public A addAllToParameters(Collection<Parameter> items) {
    if (this.parameters == null) {
      this.parameters = new ArrayList();
    }
    for (Parameter item : items) {
        ParameterBuilder builder = new ParameterBuilder(item);
        _visitables.get("parameters").add(builder);
        this.parameters.add(builder);
    }
    return (A) this;
  }
  
  public ParametersNested<A> addNewParameter() {
    return new ParametersNested(-1, null);
  }
  
  public ParametersNested<A> addNewParameterLike(Parameter item) {
    return new ParametersNested(-1, item);
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToObjects(Object... items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (Object item : items) {
      this.objects.add(item);
    }
    return (A) this;
  }
  
  public A addToObjects(int index,Object item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    this.objects.add(index, item);
    return (A) this;
  }
  
  public A addToParameters(Parameter... items) {
    if (this.parameters == null) {
      this.parameters = new ArrayList();
    }
    for (Parameter item : items) {
        ParameterBuilder builder = new ParameterBuilder(item);
        _visitables.get("parameters").add(builder);
        this.parameters.add(builder);
    }
    return (A) this;
  }
  
  public A addToParameters(int index,Parameter item) {
    if (this.parameters == null) {
      this.parameters = new ArrayList();
    }
    ParameterBuilder builder = new ParameterBuilder(item);
    if (index < 0 || index >= parameters.size()) {
        _visitables.get("parameters").add(builder);
        parameters.add(builder);
    } else {
        _visitables.get("parameters").add(builder);
        parameters.add(index, builder);
    }
    return (A) this;
  }
  
  public Parameter buildFirstParameter() {
    return this.parameters.get(0).build();
  }
  
  public Parameter buildLastParameter() {
    return this.parameters.get(parameters.size() - 1).build();
  }
  
  public Parameter buildMatchingParameter(Predicate<ParameterBuilder> predicate) {
      for (ParameterBuilder item : parameters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public Parameter buildParameter(int index) {
    return this.parameters.get(index).build();
  }
  
  public List<Parameter> buildParameters() {
    return this.parameters != null ? build(parameters) : null;
  }
  
  protected void copyInstance(Template instance) {
    instance = instance != null ? instance : new Template();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withLabels(instance.getLabels());
        this.withMessage(instance.getMessage());
        this.withMetadata(instance.getMetadata());
        this.withObjects(instance.getObjects());
        this.withParameters(instance.getParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParametersNested<A> editFirstParameter() {
    if (parameters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "parameters"));
    }
    return this.setNewParameterLike(0, this.buildParameter(0));
  }
  
  public ParametersNested<A> editLastParameter() {
    int index = parameters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "parameters"));
    }
    return this.setNewParameterLike(index, this.buildParameter(index));
  }
  
  public ParametersNested<A> editMatchingParameter(Predicate<ParameterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < parameters.size();i++) {
      if (predicate.test(parameters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "parameters"));
    }
    return this.setNewParameterLike(index, this.buildParameter(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ParametersNested<A> editParameter(int index) {
    if (parameters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "parameters"));
    }
    return this.setNewParameterLike(index, this.buildParameter(index));
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
    TemplateFluent that = (TemplateFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(objects, that.objects))) {
      return false;
    }
    if (!(Objects.equals(parameters, that.parameters))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public Object getFirstObject() {
    return this.objects.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public Object getLastObject() {
    return this.objects.get(objects.size() - 1);
  }
  
  public Object getMatchingObject(Predicate<Object> predicate) {
      for (Object item : objects) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Object getObject(int index) {
    return this.objects.get(index);
  }
  
  public List<Object> getObjects() {
    return this.objects;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasMatchingObject(Predicate<Object> predicate) {
      for (Object item : objects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingParameter(Predicate<ParameterBuilder> predicate) {
      for (ParameterBuilder item : parameters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasObjects() {
    return this.objects != null && !(this.objects.isEmpty());
  }
  
  public boolean hasParameters() {
    return this.parameters != null && !(this.parameters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, labels, message, metadata, objects, parameters, additionalProperties);
  }
  
  public A removeAllFromObjects(Collection<Object> items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.objects.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromParameters(Collection<Parameter> items) {
    if (this.parameters == null) {
      return (A) this;
    }
    for (Parameter item : items) {
        ParameterBuilder builder = new ParameterBuilder(item);
        _visitables.get("parameters").remove(builder);
        this.parameters.remove(builder);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromObjects(Object... items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (Object item : items) {
      this.objects.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromParameters(Parameter... items) {
    if (this.parameters == null) {
      return (A) this;
    }
    for (Parameter item : items) {
        ParameterBuilder builder = new ParameterBuilder(item);
        _visitables.get("parameters").remove(builder);
        this.parameters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParameters(Predicate<ParameterBuilder> predicate) {
    if (parameters == null) {
      return (A) this;
    }
    Iterator<ParameterBuilder> each = parameters.iterator();
    List visitables = _visitables.get("parameters");
    while (each.hasNext()) {
        ParameterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParametersNested<A> setNewParameterLike(int index,Parameter item) {
    return new ParametersNested(index, item);
  }
  
  public A setToObjects(int index,Object item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    this.objects.set(index, item);
    return (A) this;
  }
  
  public A setToParameters(int index,Parameter item) {
    if (this.parameters == null) {
      this.parameters = new ArrayList();
    }
    ParameterBuilder builder = new ParameterBuilder(item);
    if (index < 0 || index >= parameters.size()) {
        _visitables.get("parameters").add(builder);
        parameters.add(builder);
    } else {
        _visitables.get("parameters").add(builder);
        parameters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(objects == null) && !(objects.isEmpty())) {
        sb.append("objects:");
        sb.append(objects);
        sb.append(",");
    }
    if (!(parameters == null) && !(parameters.isEmpty())) {
        sb.append("parameters:");
        sb.append(parameters);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withObjects(List<Object> objects) {
    if (objects != null) {
        this.objects = new ArrayList();
        for (Object item : objects) {
          this.addToObjects(item);
        }
    } else {
      this.objects = null;
    }
    return (A) this;
  }
  
  public A withObjects(Object... objects) {
    if (this.objects != null) {
        this.objects.clear();
        _visitables.remove("objects");
    }
    if (objects != null) {
      for (Object item : objects) {
        this.addToObjects(item);
      }
    }
    return (A) this;
  }
  
  public A withParameters(List<Parameter> parameters) {
    if (this.parameters != null) {
      this._visitables.get("parameters").clear();
    }
    if (parameters != null) {
        this.parameters = new ArrayList();
        for (Parameter item : parameters) {
          this.addToParameters(item);
        }
    } else {
      this.parameters = null;
    }
    return (A) this;
  }
  
  public A withParameters(Parameter... parameters) {
    if (this.parameters != null) {
        this.parameters.clear();
        _visitables.remove("parameters");
    }
    if (parameters != null) {
      for (Parameter item : parameters) {
        this.addToParameters(item);
      }
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ParametersNested<N> extends ParameterFluent<ParametersNested<N>> implements Nested<N>{
  
    ParameterBuilder builder;
    int index;
  
    ParametersNested(int index,Parameter item) {
      this.index = index;
      this.builder = new ParameterBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateFluent.this.setToParameters(index, builder.build());
    }
    
    public N endParameter() {
      return and();
    }
    
  }
}