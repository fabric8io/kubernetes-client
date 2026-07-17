package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class OpsGenieConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.OpsGenieConfigFluent<A>> extends BaseFluent<A>{

  private String actions;
  private Map<String,Object> additionalProperties;
  private SecretKeySelectorBuilder apiKey;
  private String apiURL;
  private String description;
  private ArrayList<KeyValueBuilder> details = new ArrayList<KeyValueBuilder>();
  private String entity;
  private HTTPConfigBuilder httpConfig;
  private String message;
  private String note;
  private String priority;
  private ArrayList<OpsGenieConfigResponderBuilder> responders = new ArrayList<OpsGenieConfigResponderBuilder>();
  private Boolean sendResolved;
  private String source;
  private String tags;

  public OpsGenieConfigFluent() {
  }
  
  public OpsGenieConfigFluent(OpsGenieConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToDetails(Collection<KeyValue> items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResponders(Collection<OpsGenieConfigResponder> items) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    for (OpsGenieConfigResponder item : items) {
        OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
        _visitables.get("responders").add(builder);
        this.responders.add(builder);
    }
    return (A) this;
  }
  
  public DetailsNested<A> addNewDetail() {
    return new DetailsNested(-1, null);
  }
  
  public A addNewDetail(String key,String value) {
    return (A) this.addToDetails(new KeyValue(key, value));
  }
  
  public DetailsNested<A> addNewDetailLike(KeyValue item) {
    return new DetailsNested(-1, item);
  }
  
  public RespondersNested<A> addNewResponder() {
    return new RespondersNested(-1, null);
  }
  
  public A addNewResponder(String id,String name,String type,String username) {
    return (A) this.addToResponders(new OpsGenieConfigResponder(id, name, type, username));
  }
  
  public RespondersNested<A> addNewResponderLike(OpsGenieConfigResponder item) {
    return new RespondersNested(-1, item);
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
  
  public A addToDetails(KeyValue... items) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("details").add(builder);
        this.details.add(builder);
    }
    return (A) this;
  }
  
  public A addToDetails(int index,KeyValue item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResponders(OpsGenieConfigResponder... items) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    for (OpsGenieConfigResponder item : items) {
        OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
        _visitables.get("responders").add(builder);
        this.responders.add(builder);
    }
    return (A) this;
  }
  
  public A addToResponders(int index,OpsGenieConfigResponder item) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
    if (index < 0 || index >= responders.size()) {
        _visitables.get("responders").add(builder);
        responders.add(builder);
    } else {
        _visitables.get("responders").add(builder);
        responders.add(index, builder);
    }
    return (A) this;
  }
  
  public SecretKeySelector buildApiKey() {
    return this.apiKey != null ? this.apiKey.build() : null;
  }
  
  public KeyValue buildDetail(int index) {
    return this.details.get(index).build();
  }
  
  public List<KeyValue> buildDetails() {
    return this.details != null ? build(details) : null;
  }
  
  public KeyValue buildFirstDetail() {
    return this.details.get(0).build();
  }
  
  public OpsGenieConfigResponder buildFirstResponder() {
    return this.responders.get(0).build();
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public KeyValue buildLastDetail() {
    return this.details.get(details.size() - 1).build();
  }
  
  public OpsGenieConfigResponder buildLastResponder() {
    return this.responders.get(responders.size() - 1).build();
  }
  
  public KeyValue buildMatchingDetail(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : details) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OpsGenieConfigResponder buildMatchingResponder(Predicate<OpsGenieConfigResponderBuilder> predicate) {
      for (OpsGenieConfigResponderBuilder item : responders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OpsGenieConfigResponder buildResponder(int index) {
    return this.responders.get(index).build();
  }
  
  public List<OpsGenieConfigResponder> buildResponders() {
    return this.responders != null ? build(responders) : null;
  }
  
  protected void copyInstance(OpsGenieConfig instance) {
    instance = instance != null ? instance : new OpsGenieConfig();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withApiKey(instance.getApiKey());
        this.withApiURL(instance.getApiURL());
        this.withDescription(instance.getDescription());
        this.withDetails(instance.getDetails());
        this.withEntity(instance.getEntity());
        this.withHttpConfig(instance.getHttpConfig());
        this.withMessage(instance.getMessage());
        this.withNote(instance.getNote());
        this.withPriority(instance.getPriority());
        this.withResponders(instance.getResponders());
        this.withSendResolved(instance.getSendResolved());
        this.withSource(instance.getSource());
        this.withTags(instance.getTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApiKeyNested<A> editApiKey() {
    return this.withNewApiKeyLike(Optional.ofNullable(this.buildApiKey()).orElse(null));
  }
  
  public DetailsNested<A> editDetail(int index) {
    if (details.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public DetailsNested<A> editFirstDetail() {
    if (details.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(0, this.buildDetail(0));
  }
  
  public RespondersNested<A> editFirstResponder() {
    if (responders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "responders"));
    }
    return this.setNewResponderLike(0, this.buildResponder(0));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public DetailsNested<A> editLastDetail() {
    int index = details.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public RespondersNested<A> editLastResponder() {
    int index = responders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
  }
  
  public DetailsNested<A> editMatchingDetail(Predicate<KeyValueBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < details.size();i++) {
      if (predicate.test(details.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "details"));
    }
    return this.setNewDetailLike(index, this.buildDetail(index));
  }
  
  public RespondersNested<A> editMatchingResponder(Predicate<OpsGenieConfigResponderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < responders.size();i++) {
      if (predicate.test(responders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
  }
  
  public ApiKeyNested<A> editOrNewApiKey() {
    return this.withNewApiKeyLike(Optional.ofNullable(this.buildApiKey()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ApiKeyNested<A> editOrNewApiKeyLike(SecretKeySelector item) {
    return this.withNewApiKeyLike(Optional.ofNullable(this.buildApiKey()).orElse(item));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public RespondersNested<A> editResponder(int index) {
    if (responders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "responders"));
    }
    return this.setNewResponderLike(index, this.buildResponder(index));
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
    OpsGenieConfigFluent that = (OpsGenieConfigFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(apiKey, that.apiKey))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(entity, that.entity))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(note, that.note))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(responders, that.responders))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getActions() {
    return this.actions;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getEntity() {
    return this.entity;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getNote() {
    return this.note;
  }
  
  public String getPriority() {
    return this.priority;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getTags() {
    return this.tags;
  }
  
  public boolean hasActions() {
    return this.actions != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiKey() {
    return this.apiKey != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDetails() {
    return this.details != null && !(this.details.isEmpty());
  }
  
  public boolean hasEntity() {
    return this.entity != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasMatchingDetail(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : details) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResponder(Predicate<OpsGenieConfigResponderBuilder> predicate) {
      for (OpsGenieConfigResponderBuilder item : responders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasNote() {
    return this.note != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasResponders() {
    return this.responders != null && !(this.responders.isEmpty());
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasTags() {
    return this.tags != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, apiKey, apiURL, description, details, entity, httpConfig, message, note, priority, responders, sendResolved, source, tags, additionalProperties);
  }
  
  public A removeAllFromDetails(Collection<KeyValue> items) {
    if (this.details == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResponders(Collection<OpsGenieConfigResponder> items) {
    if (this.responders == null) {
      return (A) this;
    }
    for (OpsGenieConfigResponder item : items) {
        OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
        _visitables.get("responders").remove(builder);
        this.responders.remove(builder);
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
  
  public A removeFromDetails(KeyValue... items) {
    if (this.details == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("details").remove(builder);
        this.details.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResponders(OpsGenieConfigResponder... items) {
    if (this.responders == null) {
      return (A) this;
    }
    for (OpsGenieConfigResponder item : items) {
        OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
        _visitables.get("responders").remove(builder);
        this.responders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDetails(Predicate<KeyValueBuilder> predicate) {
    if (details == null) {
      return (A) this;
    }
    Iterator<KeyValueBuilder> each = details.iterator();
    List visitables = _visitables.get("details");
    while (each.hasNext()) {
        KeyValueBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResponders(Predicate<OpsGenieConfigResponderBuilder> predicate) {
    if (responders == null) {
      return (A) this;
    }
    Iterator<OpsGenieConfigResponderBuilder> each = responders.iterator();
    List visitables = _visitables.get("responders");
    while (each.hasNext()) {
        OpsGenieConfigResponderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DetailsNested<A> setNewDetailLike(int index,KeyValue item) {
    return new DetailsNested(index, item);
  }
  
  public RespondersNested<A> setNewResponderLike(int index,OpsGenieConfigResponder item) {
    return new RespondersNested(index, item);
  }
  
  public A setToDetails(int index,KeyValue item) {
    if (this.details == null) {
      this.details = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= details.size()) {
        _visitables.get("details").add(builder);
        details.add(builder);
    } else {
        _visitables.get("details").add(builder);
        details.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResponders(int index,OpsGenieConfigResponder item) {
    if (this.responders == null) {
      this.responders = new ArrayList();
    }
    OpsGenieConfigResponderBuilder builder = new OpsGenieConfigResponderBuilder(item);
    if (index < 0 || index >= responders.size()) {
        _visitables.get("responders").add(builder);
        responders.add(builder);
    } else {
        _visitables.get("responders").add(builder);
        responders.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null)) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(apiKey == null)) {
        sb.append("apiKey:");
        sb.append(apiKey);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(details == null) && !(details.isEmpty())) {
        sb.append("details:");
        sb.append(details);
        sb.append(",");
    }
    if (!(entity == null)) {
        sb.append("entity:");
        sb.append(entity);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(note == null)) {
        sb.append("note:");
        sb.append(note);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(responders == null) && !(responders.isEmpty())) {
        sb.append("responders:");
        sb.append(responders);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(tags == null)) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(String actions) {
    this.actions = actions;
    return (A) this;
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
    this._visitables.remove("apiKey");
    if (apiKey != null) {
        this.apiKey = new SecretKeySelectorBuilder(apiKey);
        this._visitables.get("apiKey").add(this.apiKey);
    } else {
        this.apiKey = null;
        this._visitables.get("apiKey").remove(this.apiKey);
    }
    return (A) this;
  }
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDetails(List<KeyValue> details) {
    if (this.details != null) {
      this._visitables.get("details").clear();
    }
    if (details != null) {
        this.details = new ArrayList();
        for (KeyValue item : details) {
          this.addToDetails(item);
        }
    } else {
      this.details = null;
    }
    return (A) this;
  }
  
  public A withDetails(KeyValue... details) {
    if (this.details != null) {
        this.details.clear();
        _visitables.remove("details");
    }
    if (details != null) {
      for (KeyValue item : details) {
        this.addToDetails(item);
      }
    }
    return (A) this;
  }
  
  public A withEntity(String entity) {
    this.entity = entity;
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
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public ApiKeyNested<A> withNewApiKey() {
    return new ApiKeyNested(null);
  }
  
  public A withNewApiKey(String key,String name) {
    return (A) this.withApiKey(new SecretKeySelector(key, name));
  }
  
  public ApiKeyNested<A> withNewApiKeyLike(SecretKeySelector item) {
    return new ApiKeyNested(item);
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withNote(String note) {
    this.note = note;
    return (A) this;
  }
  
  public A withPriority(String priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withResponders(List<OpsGenieConfigResponder> responders) {
    if (this.responders != null) {
      this._visitables.get("responders").clear();
    }
    if (responders != null) {
        this.responders = new ArrayList();
        for (OpsGenieConfigResponder item : responders) {
          this.addToResponders(item);
        }
    } else {
      this.responders = null;
    }
    return (A) this;
  }
  
  public A withResponders(OpsGenieConfigResponder... responders) {
    if (this.responders != null) {
        this.responders.clear();
        _visitables.remove("responders");
    }
    if (responders != null) {
      for (OpsGenieConfigResponder item : responders) {
        this.addToResponders(item);
      }
    }
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
  public A withTags(String tags) {
    this.tags = tags;
    return (A) this;
  }
  public class ApiKeyNested<N> extends SecretKeySelectorFluent<ApiKeyNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ApiKeyNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) OpsGenieConfigFluent.this.withApiKey(builder.build());
    }
    
    public N endApiKey() {
      return and();
    }
    
  }
  public class DetailsNested<N> extends KeyValueFluent<DetailsNested<N>> implements Nested<N>{
  
    KeyValueBuilder builder;
    int index;
  
    DetailsNested(int index,KeyValue item) {
      this.index = index;
      this.builder = new KeyValueBuilder(this, item);
    }
  
    public N and() {
      return (N) OpsGenieConfigFluent.this.setToDetails(index, builder.build());
    }
    
    public N endDetail() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OpsGenieConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class RespondersNested<N> extends OpsGenieConfigResponderFluent<RespondersNested<N>> implements Nested<N>{
  
    OpsGenieConfigResponderBuilder builder;
    int index;
  
    RespondersNested(int index,OpsGenieConfigResponder item) {
      this.index = index;
      this.builder = new OpsGenieConfigResponderBuilder(this, item);
    }
  
    public N and() {
      return (N) OpsGenieConfigFluent.this.setToResponders(index, builder.build());
    }
    
    public N endResponder() {
      return and();
    }
    
  }
}