package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class VictorOpsConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.VictorOpsConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretKeySelector apiKey;
  private String apiUrl;
  private ArrayList<KeyValueBuilder> customFields = new ArrayList<KeyValueBuilder>();
  private String entityDisplayName;
  private HTTPConfigBuilder httpConfig;
  private String messageType;
  private String monitoringTool;
  private String routingKey;
  private Boolean sendResolved;
  private String stateMessage;

  public VictorOpsConfigFluent() {
  }
  
  public VictorOpsConfigFluent(VictorOpsConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCustomFields(Collection<KeyValue> items) {
    if (this.customFields == null) {
      this.customFields = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("customFields").add(builder);
        this.customFields.add(builder);
    }
    return (A) this;
  }
  
  public CustomFieldsNested<A> addNewCustomField() {
    return new CustomFieldsNested(-1, null);
  }
  
  public A addNewCustomField(String key,String value) {
    return (A) this.addToCustomFields(new KeyValue(key, value));
  }
  
  public CustomFieldsNested<A> addNewCustomFieldLike(KeyValue item) {
    return new CustomFieldsNested(-1, item);
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
  
  public A addToCustomFields(KeyValue... items) {
    if (this.customFields == null) {
      this.customFields = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("customFields").add(builder);
        this.customFields.add(builder);
    }
    return (A) this;
  }
  
  public A addToCustomFields(int index,KeyValue item) {
    if (this.customFields == null) {
      this.customFields = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= customFields.size()) {
        _visitables.get("customFields").add(builder);
        customFields.add(builder);
    } else {
        _visitables.get("customFields").add(builder);
        customFields.add(index, builder);
    }
    return (A) this;
  }
  
  public KeyValue buildCustomField(int index) {
    return this.customFields.get(index).build();
  }
  
  public List<KeyValue> buildCustomFields() {
    return this.customFields != null ? build(customFields) : null;
  }
  
  public KeyValue buildFirstCustomField() {
    return this.customFields.get(0).build();
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public KeyValue buildLastCustomField() {
    return this.customFields.get(customFields.size() - 1).build();
  }
  
  public KeyValue buildMatchingCustomField(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : customFields) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(VictorOpsConfig instance) {
    instance = instance != null ? instance : new VictorOpsConfig();
    if (instance != null) {
        this.withApiKey(instance.getApiKey());
        this.withApiUrl(instance.getApiUrl());
        this.withCustomFields(instance.getCustomFields());
        this.withEntityDisplayName(instance.getEntityDisplayName());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessageType(instance.getMessageType());
        this.withMonitoringTool(instance.getMonitoringTool());
        this.withRoutingKey(instance.getRoutingKey());
        this.withSendResolved(instance.getSendResolved());
        this.withStateMessage(instance.getStateMessage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomFieldsNested<A> editCustomField(int index) {
    if (customFields.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "customFields"));
    }
    return this.setNewCustomFieldLike(index, this.buildCustomField(index));
  }
  
  public CustomFieldsNested<A> editFirstCustomField() {
    if (customFields.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "customFields"));
    }
    return this.setNewCustomFieldLike(0, this.buildCustomField(0));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public CustomFieldsNested<A> editLastCustomField() {
    int index = customFields.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "customFields"));
    }
    return this.setNewCustomFieldLike(index, this.buildCustomField(index));
  }
  
  public CustomFieldsNested<A> editMatchingCustomField(Predicate<KeyValueBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < customFields.size();i++) {
      if (predicate.test(customFields.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "customFields"));
    }
    return this.setNewCustomFieldLike(index, this.buildCustomField(index));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
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
    VictorOpsConfigFluent that = (VictorOpsConfigFluent) o;
    if (!(Objects.equals(apiKey, that.apiKey))) {
      return false;
    }
    if (!(Objects.equals(apiUrl, that.apiUrl))) {
      return false;
    }
    if (!(Objects.equals(customFields, that.customFields))) {
      return false;
    }
    if (!(Objects.equals(entityDisplayName, that.entityDisplayName))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(messageType, that.messageType))) {
      return false;
    }
    if (!(Objects.equals(monitoringTool, that.monitoringTool))) {
      return false;
    }
    if (!(Objects.equals(routingKey, that.routingKey))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(stateMessage, that.stateMessage))) {
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
  
  public SecretKeySelector getApiKey() {
    return this.apiKey;
  }
  
  public String getApiUrl() {
    return this.apiUrl;
  }
  
  public String getEntityDisplayName() {
    return this.entityDisplayName;
  }
  
  public String getMessageType() {
    return this.messageType;
  }
  
  public String getMonitoringTool() {
    return this.monitoringTool;
  }
  
  public String getRoutingKey() {
    return this.routingKey;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getStateMessage() {
    return this.stateMessage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiKey() {
    return this.apiKey != null;
  }
  
  public boolean hasApiUrl() {
    return this.apiUrl != null;
  }
  
  public boolean hasCustomFields() {
    return this.customFields != null && !(this.customFields.isEmpty());
  }
  
  public boolean hasEntityDisplayName() {
    return this.entityDisplayName != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMatchingCustomField(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : customFields) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessageType() {
    return this.messageType != null;
  }
  
  public boolean hasMonitoringTool() {
    return this.monitoringTool != null;
  }
  
  public boolean hasRoutingKey() {
    return this.routingKey != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasStateMessage() {
    return this.stateMessage != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiKey, apiUrl, customFields, entityDisplayName, httpConfig, messageType, monitoringTool, routingKey, sendResolved, stateMessage, additionalProperties);
  }
  
  public A removeAllFromCustomFields(Collection<KeyValue> items) {
    if (this.customFields == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("customFields").remove(builder);
        this.customFields.remove(builder);
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
  
  public A removeFromCustomFields(KeyValue... items) {
    if (this.customFields == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("customFields").remove(builder);
        this.customFields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCustomFields(Predicate<KeyValueBuilder> predicate) {
    if (customFields == null) {
      return (A) this;
    }
    Iterator<KeyValueBuilder> each = customFields.iterator();
    List visitables = _visitables.get("customFields");
    while (each.hasNext()) {
        KeyValueBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CustomFieldsNested<A> setNewCustomFieldLike(int index,KeyValue item) {
    return new CustomFieldsNested(index, item);
  }
  
  public A setToCustomFields(int index,KeyValue item) {
    if (this.customFields == null) {
      this.customFields = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= customFields.size()) {
        _visitables.get("customFields").add(builder);
        customFields.add(builder);
    } else {
        _visitables.get("customFields").add(builder);
        customFields.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiKey == null)) {
        sb.append("apiKey:");
        sb.append(apiKey);
        sb.append(",");
    }
    if (!(apiUrl == null)) {
        sb.append("apiUrl:");
        sb.append(apiUrl);
        sb.append(",");
    }
    if (!(customFields == null) && !(customFields.isEmpty())) {
        sb.append("customFields:");
        sb.append(customFields);
        sb.append(",");
    }
    if (!(entityDisplayName == null)) {
        sb.append("entityDisplayName:");
        sb.append(entityDisplayName);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(messageType == null)) {
        sb.append("messageType:");
        sb.append(messageType);
        sb.append(",");
    }
    if (!(monitoringTool == null)) {
        sb.append("monitoringTool:");
        sb.append(monitoringTool);
        sb.append(",");
    }
    if (!(routingKey == null)) {
        sb.append("routingKey:");
        sb.append(routingKey);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(stateMessage == null)) {
        sb.append("stateMessage:");
        sb.append(stateMessage);
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
  
  public A withApiKey(SecretKeySelector apiKey) {
    this.apiKey = apiKey;
    return (A) this;
  }
  
  public A withApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
    return (A) this;
  }
  
  public A withCustomFields(List<KeyValue> customFields) {
    if (this.customFields != null) {
      this._visitables.get("customFields").clear();
    }
    if (customFields != null) {
        this.customFields = new ArrayList();
        for (KeyValue item : customFields) {
          this.addToCustomFields(item);
        }
    } else {
      this.customFields = null;
    }
    return (A) this;
  }
  
  public A withCustomFields(KeyValue... customFields) {
    if (this.customFields != null) {
        this.customFields.clear();
        _visitables.remove("customFields");
    }
    if (customFields != null) {
      for (KeyValue item : customFields) {
        this.addToCustomFields(item);
      }
    }
    return (A) this;
  }
  
  public A withEntityDisplayName(String entityDisplayName) {
    this.entityDisplayName = entityDisplayName;
    return (A) this;
  }
  
  public A withHttpConfig(HTTPConfig httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withMessageType(String messageType) {
    this.messageType = messageType;
    return (A) this;
  }
  
  public A withMonitoringTool(String monitoringTool) {
    this.monitoringTool = monitoringTool;
    return (A) this;
  }
  
  public A withNewApiKey(String key,String name,Boolean optional) {
    return (A) this.withApiKey(new SecretKeySelector(key, name, optional));
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withRoutingKey(String routingKey) {
    this.routingKey = routingKey;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withStateMessage(String stateMessage) {
    this.stateMessage = stateMessage;
    return (A) this;
  }
  public class CustomFieldsNested<N> extends KeyValueFluent<CustomFieldsNested<N>> implements Nested<N>{
  
    KeyValueBuilder builder;
    int index;
  
    CustomFieldsNested(int index,KeyValue item) {
      this.index = index;
      this.builder = new KeyValueBuilder(this, item);
    }
  
    public N and() {
      return (N) VictorOpsConfigFluent.this.setToCustomFields(index, builder.build());
    }
    
    public N endCustomField() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) VictorOpsConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}