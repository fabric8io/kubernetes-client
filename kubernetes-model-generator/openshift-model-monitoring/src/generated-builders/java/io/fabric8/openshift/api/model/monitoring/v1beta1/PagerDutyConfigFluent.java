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
public class PagerDutyConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1beta1.PagerDutyConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String className;
  private String client;
  private String clientURL;
  private String component;
  private String description;
  private ArrayList<KeyValueBuilder> details = new ArrayList<KeyValueBuilder>();
  private String group;
  private HTTPConfigBuilder httpConfig;
  private ArrayList<PagerDutyImageConfigBuilder> pagerDutyImageConfigs = new ArrayList<PagerDutyImageConfigBuilder>();
  private ArrayList<PagerDutyLinkConfigBuilder> pagerDutyLinkConfigs = new ArrayList<PagerDutyLinkConfigBuilder>();
  private SecretKeySelectorBuilder routingKey;
  private Boolean sendResolved;
  private SecretKeySelectorBuilder serviceKey;
  private String severity;
  private String source;
  private String timeout;
  private String url;

  public PagerDutyConfigFluent() {
  }
  
  public PagerDutyConfigFluent(PagerDutyConfig instance) {
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
  
  public A addAllToPagerDutyImageConfigs(Collection<PagerDutyImageConfig> items) {
    if (this.pagerDutyImageConfigs == null) {
      this.pagerDutyImageConfigs = new ArrayList();
    }
    for (PagerDutyImageConfig item : items) {
        PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
        _visitables.get("pagerDutyImageConfigs").add(builder);
        this.pagerDutyImageConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPagerDutyLinkConfigs(Collection<PagerDutyLinkConfig> items) {
    if (this.pagerDutyLinkConfigs == null) {
      this.pagerDutyLinkConfigs = new ArrayList();
    }
    for (PagerDutyLinkConfig item : items) {
        PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        this.pagerDutyLinkConfigs.add(builder);
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
  
  public PagerDutyImageConfigsNested<A> addNewPagerDutyImageConfig() {
    return new PagerDutyImageConfigsNested(-1, null);
  }
  
  public A addNewPagerDutyImageConfig(String alt,String href,String src) {
    return (A) this.addToPagerDutyImageConfigs(new PagerDutyImageConfig(alt, href, src));
  }
  
  public PagerDutyImageConfigsNested<A> addNewPagerDutyImageConfigLike(PagerDutyImageConfig item) {
    return new PagerDutyImageConfigsNested(-1, item);
  }
  
  public PagerDutyLinkConfigsNested<A> addNewPagerDutyLinkConfig() {
    return new PagerDutyLinkConfigsNested(-1, null);
  }
  
  public A addNewPagerDutyLinkConfig(String alt,String href) {
    return (A) this.addToPagerDutyLinkConfigs(new PagerDutyLinkConfig(alt, href));
  }
  
  public PagerDutyLinkConfigsNested<A> addNewPagerDutyLinkConfigLike(PagerDutyLinkConfig item) {
    return new PagerDutyLinkConfigsNested(-1, item);
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
  
  public A addToPagerDutyImageConfigs(PagerDutyImageConfig... items) {
    if (this.pagerDutyImageConfigs == null) {
      this.pagerDutyImageConfigs = new ArrayList();
    }
    for (PagerDutyImageConfig item : items) {
        PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
        _visitables.get("pagerDutyImageConfigs").add(builder);
        this.pagerDutyImageConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPagerDutyImageConfigs(int index,PagerDutyImageConfig item) {
    if (this.pagerDutyImageConfigs == null) {
      this.pagerDutyImageConfigs = new ArrayList();
    }
    PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
    if (index < 0 || index >= pagerDutyImageConfigs.size()) {
        _visitables.get("pagerDutyImageConfigs").add(builder);
        pagerDutyImageConfigs.add(builder);
    } else {
        _visitables.get("pagerDutyImageConfigs").add(builder);
        pagerDutyImageConfigs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPagerDutyLinkConfigs(PagerDutyLinkConfig... items) {
    if (this.pagerDutyLinkConfigs == null) {
      this.pagerDutyLinkConfigs = new ArrayList();
    }
    for (PagerDutyLinkConfig item : items) {
        PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        this.pagerDutyLinkConfigs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPagerDutyLinkConfigs(int index,PagerDutyLinkConfig item) {
    if (this.pagerDutyLinkConfigs == null) {
      this.pagerDutyLinkConfigs = new ArrayList();
    }
    PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
    if (index < 0 || index >= pagerDutyLinkConfigs.size()) {
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        pagerDutyLinkConfigs.add(builder);
    } else {
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        pagerDutyLinkConfigs.add(index, builder);
    }
    return (A) this;
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
  
  public PagerDutyImageConfig buildFirstPagerDutyImageConfig() {
    return this.pagerDutyImageConfigs.get(0).build();
  }
  
  public PagerDutyLinkConfig buildFirstPagerDutyLinkConfig() {
    return this.pagerDutyLinkConfigs.get(0).build();
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public KeyValue buildLastDetail() {
    return this.details.get(details.size() - 1).build();
  }
  
  public PagerDutyImageConfig buildLastPagerDutyImageConfig() {
    return this.pagerDutyImageConfigs.get(pagerDutyImageConfigs.size() - 1).build();
  }
  
  public PagerDutyLinkConfig buildLastPagerDutyLinkConfig() {
    return this.pagerDutyLinkConfigs.get(pagerDutyLinkConfigs.size() - 1).build();
  }
  
  public KeyValue buildMatchingDetail(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : details) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PagerDutyImageConfig buildMatchingPagerDutyImageConfig(Predicate<PagerDutyImageConfigBuilder> predicate) {
      for (PagerDutyImageConfigBuilder item : pagerDutyImageConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PagerDutyLinkConfig buildMatchingPagerDutyLinkConfig(Predicate<PagerDutyLinkConfigBuilder> predicate) {
      for (PagerDutyLinkConfigBuilder item : pagerDutyLinkConfigs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PagerDutyImageConfig buildPagerDutyImageConfig(int index) {
    return this.pagerDutyImageConfigs.get(index).build();
  }
  
  public List<PagerDutyImageConfig> buildPagerDutyImageConfigs() {
    return this.pagerDutyImageConfigs != null ? build(pagerDutyImageConfigs) : null;
  }
  
  public PagerDutyLinkConfig buildPagerDutyLinkConfig(int index) {
    return this.pagerDutyLinkConfigs.get(index).build();
  }
  
  public List<PagerDutyLinkConfig> buildPagerDutyLinkConfigs() {
    return this.pagerDutyLinkConfigs != null ? build(pagerDutyLinkConfigs) : null;
  }
  
  public SecretKeySelector buildRoutingKey() {
    return this.routingKey != null ? this.routingKey.build() : null;
  }
  
  public SecretKeySelector buildServiceKey() {
    return this.serviceKey != null ? this.serviceKey.build() : null;
  }
  
  protected void copyInstance(PagerDutyConfig instance) {
    instance = instance != null ? instance : new PagerDutyConfig();
    if (instance != null) {
        this.withClassName(instance.getClassName());
        this.withClient(instance.getClient());
        this.withClientURL(instance.getClientURL());
        this.withComponent(instance.getComponent());
        this.withDescription(instance.getDescription());
        this.withDetails(instance.getDetails());
        this.withGroup(instance.getGroup());
        this.withHttpConfig(instance.getHttpConfig());
        this.withPagerDutyImageConfigs(instance.getPagerDutyImageConfigs());
        this.withPagerDutyLinkConfigs(instance.getPagerDutyLinkConfigs());
        this.withRoutingKey(instance.getRoutingKey());
        this.withSendResolved(instance.getSendResolved());
        this.withServiceKey(instance.getServiceKey());
        this.withSeverity(instance.getSeverity());
        this.withSource(instance.getSource());
        this.withTimeout(instance.getTimeout());
        this.withUrl(instance.getUrl());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public PagerDutyImageConfigsNested<A> editFirstPagerDutyImageConfig() {
    if (pagerDutyImageConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pagerDutyImageConfigs"));
    }
    return this.setNewPagerDutyImageConfigLike(0, this.buildPagerDutyImageConfig(0));
  }
  
  public PagerDutyLinkConfigsNested<A> editFirstPagerDutyLinkConfig() {
    if (pagerDutyLinkConfigs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "pagerDutyLinkConfigs"));
    }
    return this.setNewPagerDutyLinkConfigLike(0, this.buildPagerDutyLinkConfig(0));
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
  
  public PagerDutyImageConfigsNested<A> editLastPagerDutyImageConfig() {
    int index = pagerDutyImageConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pagerDutyImageConfigs"));
    }
    return this.setNewPagerDutyImageConfigLike(index, this.buildPagerDutyImageConfig(index));
  }
  
  public PagerDutyLinkConfigsNested<A> editLastPagerDutyLinkConfig() {
    int index = pagerDutyLinkConfigs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "pagerDutyLinkConfigs"));
    }
    return this.setNewPagerDutyLinkConfigLike(index, this.buildPagerDutyLinkConfig(index));
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
  
  public PagerDutyImageConfigsNested<A> editMatchingPagerDutyImageConfig(Predicate<PagerDutyImageConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pagerDutyImageConfigs.size();i++) {
      if (predicate.test(pagerDutyImageConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pagerDutyImageConfigs"));
    }
    return this.setNewPagerDutyImageConfigLike(index, this.buildPagerDutyImageConfig(index));
  }
  
  public PagerDutyLinkConfigsNested<A> editMatchingPagerDutyLinkConfig(Predicate<PagerDutyLinkConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < pagerDutyLinkConfigs.size();i++) {
      if (predicate.test(pagerDutyLinkConfigs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "pagerDutyLinkConfigs"));
    }
    return this.setNewPagerDutyLinkConfigLike(index, this.buildPagerDutyLinkConfig(index));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public RoutingKeyNested<A> editOrNewRoutingKey() {
    return this.withNewRoutingKeyLike(Optional.ofNullable(this.buildRoutingKey()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public RoutingKeyNested<A> editOrNewRoutingKeyLike(SecretKeySelector item) {
    return this.withNewRoutingKeyLike(Optional.ofNullable(this.buildRoutingKey()).orElse(item));
  }
  
  public ServiceKeyNested<A> editOrNewServiceKey() {
    return this.withNewServiceKeyLike(Optional.ofNullable(this.buildServiceKey()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ServiceKeyNested<A> editOrNewServiceKeyLike(SecretKeySelector item) {
    return this.withNewServiceKeyLike(Optional.ofNullable(this.buildServiceKey()).orElse(item));
  }
  
  public PagerDutyImageConfigsNested<A> editPagerDutyImageConfig(int index) {
    if (pagerDutyImageConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pagerDutyImageConfigs"));
    }
    return this.setNewPagerDutyImageConfigLike(index, this.buildPagerDutyImageConfig(index));
  }
  
  public PagerDutyLinkConfigsNested<A> editPagerDutyLinkConfig(int index) {
    if (pagerDutyLinkConfigs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "pagerDutyLinkConfigs"));
    }
    return this.setNewPagerDutyLinkConfigLike(index, this.buildPagerDutyLinkConfig(index));
  }
  
  public RoutingKeyNested<A> editRoutingKey() {
    return this.withNewRoutingKeyLike(Optional.ofNullable(this.buildRoutingKey()).orElse(null));
  }
  
  public ServiceKeyNested<A> editServiceKey() {
    return this.withNewServiceKeyLike(Optional.ofNullable(this.buildServiceKey()).orElse(null));
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
    PagerDutyConfigFluent that = (PagerDutyConfigFluent) o;
    if (!(Objects.equals(className, that.className))) {
      return false;
    }
    if (!(Objects.equals(client, that.client))) {
      return false;
    }
    if (!(Objects.equals(clientURL, that.clientURL))) {
      return false;
    }
    if (!(Objects.equals(component, that.component))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(details, that.details))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(pagerDutyImageConfigs, that.pagerDutyImageConfigs))) {
      return false;
    }
    if (!(Objects.equals(pagerDutyLinkConfigs, that.pagerDutyLinkConfigs))) {
      return false;
    }
    if (!(Objects.equals(routingKey, that.routingKey))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(serviceKey, that.serviceKey))) {
      return false;
    }
    if (!(Objects.equals(severity, that.severity))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getClassName() {
    return this.className;
  }
  
  public String getClient() {
    return this.client;
  }
  
  public String getClientURL() {
    return this.clientURL;
  }
  
  public String getComponent() {
    return this.component;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getSeverity() {
    return this.severity;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClassName() {
    return this.className != null;
  }
  
  public boolean hasClient() {
    return this.client != null;
  }
  
  public boolean hasClientURL() {
    return this.clientURL != null;
  }
  
  public boolean hasComponent() {
    return this.component != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDetails() {
    return this.details != null && !(this.details.isEmpty());
  }
  
  public boolean hasGroup() {
    return this.group != null;
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
  
  public boolean hasMatchingPagerDutyImageConfig(Predicate<PagerDutyImageConfigBuilder> predicate) {
      for (PagerDutyImageConfigBuilder item : pagerDutyImageConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPagerDutyLinkConfig(Predicate<PagerDutyLinkConfigBuilder> predicate) {
      for (PagerDutyLinkConfigBuilder item : pagerDutyLinkConfigs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPagerDutyImageConfigs() {
    return this.pagerDutyImageConfigs != null && !(this.pagerDutyImageConfigs.isEmpty());
  }
  
  public boolean hasPagerDutyLinkConfigs() {
    return this.pagerDutyLinkConfigs != null && !(this.pagerDutyLinkConfigs.isEmpty());
  }
  
  public boolean hasRoutingKey() {
    return this.routingKey != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasServiceKey() {
    return this.serviceKey != null;
  }
  
  public boolean hasSeverity() {
    return this.severity != null;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(className, client, clientURL, component, description, details, group, httpConfig, pagerDutyImageConfigs, pagerDutyLinkConfigs, routingKey, sendResolved, serviceKey, severity, source, timeout, url, additionalProperties);
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
  
  public A removeAllFromPagerDutyImageConfigs(Collection<PagerDutyImageConfig> items) {
    if (this.pagerDutyImageConfigs == null) {
      return (A) this;
    }
    for (PagerDutyImageConfig item : items) {
        PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
        _visitables.get("pagerDutyImageConfigs").remove(builder);
        this.pagerDutyImageConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPagerDutyLinkConfigs(Collection<PagerDutyLinkConfig> items) {
    if (this.pagerDutyLinkConfigs == null) {
      return (A) this;
    }
    for (PagerDutyLinkConfig item : items) {
        PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
        _visitables.get("pagerDutyLinkConfigs").remove(builder);
        this.pagerDutyLinkConfigs.remove(builder);
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
  
  public A removeFromPagerDutyImageConfigs(PagerDutyImageConfig... items) {
    if (this.pagerDutyImageConfigs == null) {
      return (A) this;
    }
    for (PagerDutyImageConfig item : items) {
        PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
        _visitables.get("pagerDutyImageConfigs").remove(builder);
        this.pagerDutyImageConfigs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPagerDutyLinkConfigs(PagerDutyLinkConfig... items) {
    if (this.pagerDutyLinkConfigs == null) {
      return (A) this;
    }
    for (PagerDutyLinkConfig item : items) {
        PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
        _visitables.get("pagerDutyLinkConfigs").remove(builder);
        this.pagerDutyLinkConfigs.remove(builder);
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
  
  public A removeMatchingFromPagerDutyImageConfigs(Predicate<PagerDutyImageConfigBuilder> predicate) {
    if (pagerDutyImageConfigs == null) {
      return (A) this;
    }
    Iterator<PagerDutyImageConfigBuilder> each = pagerDutyImageConfigs.iterator();
    List visitables = _visitables.get("pagerDutyImageConfigs");
    while (each.hasNext()) {
        PagerDutyImageConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPagerDutyLinkConfigs(Predicate<PagerDutyLinkConfigBuilder> predicate) {
    if (pagerDutyLinkConfigs == null) {
      return (A) this;
    }
    Iterator<PagerDutyLinkConfigBuilder> each = pagerDutyLinkConfigs.iterator();
    List visitables = _visitables.get("pagerDutyLinkConfigs");
    while (each.hasNext()) {
        PagerDutyLinkConfigBuilder builder = each.next();
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
  
  public PagerDutyImageConfigsNested<A> setNewPagerDutyImageConfigLike(int index,PagerDutyImageConfig item) {
    return new PagerDutyImageConfigsNested(index, item);
  }
  
  public PagerDutyLinkConfigsNested<A> setNewPagerDutyLinkConfigLike(int index,PagerDutyLinkConfig item) {
    return new PagerDutyLinkConfigsNested(index, item);
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
  
  public A setToPagerDutyImageConfigs(int index,PagerDutyImageConfig item) {
    if (this.pagerDutyImageConfigs == null) {
      this.pagerDutyImageConfigs = new ArrayList();
    }
    PagerDutyImageConfigBuilder builder = new PagerDutyImageConfigBuilder(item);
    if (index < 0 || index >= pagerDutyImageConfigs.size()) {
        _visitables.get("pagerDutyImageConfigs").add(builder);
        pagerDutyImageConfigs.add(builder);
    } else {
        _visitables.get("pagerDutyImageConfigs").add(builder);
        pagerDutyImageConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPagerDutyLinkConfigs(int index,PagerDutyLinkConfig item) {
    if (this.pagerDutyLinkConfigs == null) {
      this.pagerDutyLinkConfigs = new ArrayList();
    }
    PagerDutyLinkConfigBuilder builder = new PagerDutyLinkConfigBuilder(item);
    if (index < 0 || index >= pagerDutyLinkConfigs.size()) {
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        pagerDutyLinkConfigs.add(builder);
    } else {
        _visitables.get("pagerDutyLinkConfigs").add(builder);
        pagerDutyLinkConfigs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(className == null)) {
        sb.append("className:");
        sb.append(className);
        sb.append(",");
    }
    if (!(client == null)) {
        sb.append("client:");
        sb.append(client);
        sb.append(",");
    }
    if (!(clientURL == null)) {
        sb.append("clientURL:");
        sb.append(clientURL);
        sb.append(",");
    }
    if (!(component == null)) {
        sb.append("component:");
        sb.append(component);
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
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(pagerDutyImageConfigs == null) && !(pagerDutyImageConfigs.isEmpty())) {
        sb.append("pagerDutyImageConfigs:");
        sb.append(pagerDutyImageConfigs);
        sb.append(",");
    }
    if (!(pagerDutyLinkConfigs == null) && !(pagerDutyLinkConfigs.isEmpty())) {
        sb.append("pagerDutyLinkConfigs:");
        sb.append(pagerDutyLinkConfigs);
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
    if (!(serviceKey == null)) {
        sb.append("serviceKey:");
        sb.append(serviceKey);
        sb.append(",");
    }
    if (!(severity == null)) {
        sb.append("severity:");
        sb.append(severity);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withClassName(String className) {
    this.className = className;
    return (A) this;
  }
  
  public A withClient(String client) {
    this.client = client;
    return (A) this;
  }
  
  public A withClientURL(String clientURL) {
    this.clientURL = clientURL;
    return (A) this;
  }
  
  public A withComponent(String component) {
    this.component = component;
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
  
  public A withGroup(String group) {
    this.group = group;
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
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public RoutingKeyNested<A> withNewRoutingKey() {
    return new RoutingKeyNested(null);
  }
  
  public A withNewRoutingKey(String key,String name) {
    return (A) this.withRoutingKey(new SecretKeySelector(key, name));
  }
  
  public RoutingKeyNested<A> withNewRoutingKeyLike(SecretKeySelector item) {
    return new RoutingKeyNested(item);
  }
  
  public ServiceKeyNested<A> withNewServiceKey() {
    return new ServiceKeyNested(null);
  }
  
  public A withNewServiceKey(String key,String name) {
    return (A) this.withServiceKey(new SecretKeySelector(key, name));
  }
  
  public ServiceKeyNested<A> withNewServiceKeyLike(SecretKeySelector item) {
    return new ServiceKeyNested(item);
  }
  
  public A withPagerDutyImageConfigs(List<PagerDutyImageConfig> pagerDutyImageConfigs) {
    if (this.pagerDutyImageConfigs != null) {
      this._visitables.get("pagerDutyImageConfigs").clear();
    }
    if (pagerDutyImageConfigs != null) {
        this.pagerDutyImageConfigs = new ArrayList();
        for (PagerDutyImageConfig item : pagerDutyImageConfigs) {
          this.addToPagerDutyImageConfigs(item);
        }
    } else {
      this.pagerDutyImageConfigs = null;
    }
    return (A) this;
  }
  
  public A withPagerDutyImageConfigs(PagerDutyImageConfig... pagerDutyImageConfigs) {
    if (this.pagerDutyImageConfigs != null) {
        this.pagerDutyImageConfigs.clear();
        _visitables.remove("pagerDutyImageConfigs");
    }
    if (pagerDutyImageConfigs != null) {
      for (PagerDutyImageConfig item : pagerDutyImageConfigs) {
        this.addToPagerDutyImageConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withPagerDutyLinkConfigs(List<PagerDutyLinkConfig> pagerDutyLinkConfigs) {
    if (this.pagerDutyLinkConfigs != null) {
      this._visitables.get("pagerDutyLinkConfigs").clear();
    }
    if (pagerDutyLinkConfigs != null) {
        this.pagerDutyLinkConfigs = new ArrayList();
        for (PagerDutyLinkConfig item : pagerDutyLinkConfigs) {
          this.addToPagerDutyLinkConfigs(item);
        }
    } else {
      this.pagerDutyLinkConfigs = null;
    }
    return (A) this;
  }
  
  public A withPagerDutyLinkConfigs(PagerDutyLinkConfig... pagerDutyLinkConfigs) {
    if (this.pagerDutyLinkConfigs != null) {
        this.pagerDutyLinkConfigs.clear();
        _visitables.remove("pagerDutyLinkConfigs");
    }
    if (pagerDutyLinkConfigs != null) {
      for (PagerDutyLinkConfig item : pagerDutyLinkConfigs) {
        this.addToPagerDutyLinkConfigs(item);
      }
    }
    return (A) this;
  }
  
  public A withRoutingKey(SecretKeySelector routingKey) {
    this._visitables.remove("routingKey");
    if (routingKey != null) {
        this.routingKey = new SecretKeySelectorBuilder(routingKey);
        this._visitables.get("routingKey").add(this.routingKey);
    } else {
        this.routingKey = null;
        this._visitables.get("routingKey").remove(this.routingKey);
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
  
  public A withServiceKey(SecretKeySelector serviceKey) {
    this._visitables.remove("serviceKey");
    if (serviceKey != null) {
        this.serviceKey = new SecretKeySelectorBuilder(serviceKey);
        this._visitables.get("serviceKey").add(this.serviceKey);
    } else {
        this.serviceKey = null;
        this._visitables.get("serviceKey").remove(this.serviceKey);
    }
    return (A) this;
  }
  
  public A withSeverity(String severity) {
    this.severity = severity;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class DetailsNested<N> extends KeyValueFluent<DetailsNested<N>> implements Nested<N>{
  
    KeyValueBuilder builder;
    int index;
  
    DetailsNested(int index,KeyValue item) {
      this.index = index;
      this.builder = new KeyValueBuilder(this, item);
    }
  
    public N and() {
      return (N) PagerDutyConfigFluent.this.setToDetails(index, builder.build());
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
      return (N) PagerDutyConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class PagerDutyImageConfigsNested<N> extends PagerDutyImageConfigFluent<PagerDutyImageConfigsNested<N>> implements Nested<N>{
  
    PagerDutyImageConfigBuilder builder;
    int index;
  
    PagerDutyImageConfigsNested(int index,PagerDutyImageConfig item) {
      this.index = index;
      this.builder = new PagerDutyImageConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PagerDutyConfigFluent.this.setToPagerDutyImageConfigs(index, builder.build());
    }
    
    public N endPagerDutyImageConfig() {
      return and();
    }
    
  }
  public class PagerDutyLinkConfigsNested<N> extends PagerDutyLinkConfigFluent<PagerDutyLinkConfigsNested<N>> implements Nested<N>{
  
    PagerDutyLinkConfigBuilder builder;
    int index;
  
    PagerDutyLinkConfigsNested(int index,PagerDutyLinkConfig item) {
      this.index = index;
      this.builder = new PagerDutyLinkConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PagerDutyConfigFluent.this.setToPagerDutyLinkConfigs(index, builder.build());
    }
    
    public N endPagerDutyLinkConfig() {
      return and();
    }
    
  }
  public class RoutingKeyNested<N> extends SecretKeySelectorFluent<RoutingKeyNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    RoutingKeyNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PagerDutyConfigFluent.this.withRoutingKey(builder.build());
    }
    
    public N endRoutingKey() {
      return and();
    }
    
  }
  public class ServiceKeyNested<N> extends SecretKeySelectorFluent<ServiceKeyNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ServiceKeyNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PagerDutyConfigFluent.this.withServiceKey(builder.build());
    }
    
    public N endServiceKey() {
      return and();
    }
    
  }
}