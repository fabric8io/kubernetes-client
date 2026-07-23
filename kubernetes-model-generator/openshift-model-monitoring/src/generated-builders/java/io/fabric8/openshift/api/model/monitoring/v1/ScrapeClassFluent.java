package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ScrapeClassFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ScrapeClassFluent<A>> extends BaseFluent<A>{

  private Boolean _default;
  private Map<String,Object> additionalProperties;
  private AttachMetadataBuilder attachMetadata;
  private AuthorizationBuilder authorization;
  private String fallbackScrapeProtocol;
  private ArrayList<RelabelConfigBuilder> metricRelabelings = new ArrayList<RelabelConfigBuilder>();
  private String name;
  private ArrayList<RelabelConfigBuilder> relabelings = new ArrayList<RelabelConfigBuilder>();
  private TLSConfigBuilder tlsConfig;

  public ScrapeClassFluent() {
  }
  
  public ScrapeClassFluent(ScrapeClass instance) {
    this.copyInstance(instance);
  }

  public A addAllToMetricRelabelings(Collection<RelabelConfig> items) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").add(builder);
        this.metricRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabeling() {
    return new MetricRelabelingsNested(-1, null);
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabelingLike(RelabelConfig item) {
    return new MetricRelabelingsNested(-1, item);
  }
  
  public RelabelingsNested<A> addNewRelabeling() {
    return new RelabelingsNested(-1, null);
  }
  
  public RelabelingsNested<A> addNewRelabelingLike(RelabelConfig item) {
    return new RelabelingsNested(-1, item);
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
  
  public A addToMetricRelabelings(RelabelConfig... items) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").add(builder);
        this.metricRelabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToMetricRelabelings(int index,RelabelConfig item) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= metricRelabelings.size()) {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(builder);
    } else {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").add(builder);
        this.relabelings.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.add(index, builder);
    }
    return (A) this;
  }
  
  public AttachMetadata buildAttachMetadata() {
    return this.attachMetadata != null ? this.attachMetadata.build() : null;
  }
  
  public Authorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public RelabelConfig buildFirstMetricRelabeling() {
    return this.metricRelabelings.get(0).build();
  }
  
  public RelabelConfig buildFirstRelabeling() {
    return this.relabelings.get(0).build();
  }
  
  public RelabelConfig buildLastMetricRelabeling() {
    return this.metricRelabelings.get(metricRelabelings.size() - 1).build();
  }
  
  public RelabelConfig buildLastRelabeling() {
    return this.relabelings.get(relabelings.size() - 1).build();
  }
  
  public RelabelConfig buildMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RelabelConfig buildMetricRelabeling(int index) {
    return this.metricRelabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildMetricRelabelings() {
    return this.metricRelabelings != null ? build(metricRelabelings) : null;
  }
  
  public RelabelConfig buildRelabeling(int index) {
    return this.relabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelings() {
    return this.relabelings != null ? build(relabelings) : null;
  }
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(ScrapeClass instance) {
    instance = instance != null ? instance : new ScrapeClass();
    if (instance != null) {
        this.withAttachMetadata(instance.getAttachMetadata());
        this.withAuthorization(instance.getAuthorization());
        this.withDefault(instance.getDefault());
        this.withFallbackScrapeProtocol(instance.getFallbackScrapeProtocol());
        this.withMetricRelabelings(instance.getMetricRelabelings());
        this.withName(instance.getName());
        this.withRelabelings(instance.getRelabelings());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttachMetadataNested<A> editAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(null));
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public MetricRelabelingsNested<A> editFirstMetricRelabeling() {
    if (metricRelabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(0, this.buildMetricRelabeling(0));
  }
  
  public RelabelingsNested<A> editFirstRelabeling() {
    if (relabelings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(0, this.buildRelabeling(0));
  }
  
  public MetricRelabelingsNested<A> editLastMetricRelabeling() {
    int index = metricRelabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public RelabelingsNested<A> editLastRelabeling() {
    int index = relabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public MetricRelabelingsNested<A> editMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < metricRelabelings.size();i++) {
      if (predicate.test(metricRelabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public RelabelingsNested<A> editMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relabelings.size();i++) {
      if (predicate.test(relabelings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public MetricRelabelingsNested<A> editMetricRelabeling(int index) {
    if (metricRelabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(new AttachMetadataBuilder().build()));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadataLike(AttachMetadata item) {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(item));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new AuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(Authorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new TLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(TLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public RelabelingsNested<A> editRelabeling(int index) {
    if (relabelings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relabelings"));
    }
    return this.setNewRelabelingLike(index, this.buildRelabeling(index));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
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
    ScrapeClassFluent that = (ScrapeClassFluent) o;
    if (!(Objects.equals(attachMetadata, that.attachMetadata))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(fallbackScrapeProtocol, that.fallbackScrapeProtocol))) {
      return false;
    }
    if (!(Objects.equals(metricRelabelings, that.metricRelabelings))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(relabelings, that.relabelings))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
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
  
  public Boolean getDefault() {
    return this._default;
  }
  
  public String getFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachMetadata() {
    return this.attachMetadata != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol != null;
  }
  
  public boolean hasMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : relabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricRelabelings() {
    return this.metricRelabelings != null && !(this.metricRelabelings.isEmpty());
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRelabelings() {
    return this.relabelings != null && !(this.relabelings.isEmpty());
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(attachMetadata, authorization, _default, fallbackScrapeProtocol, metricRelabelings, name, relabelings, tlsConfig, additionalProperties);
  }
  
  public A removeAllFromMetricRelabelings(Collection<RelabelConfig> items) {
    if (this.metricRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").remove(builder);
        this.metricRelabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRelabelings(Collection<RelabelConfig> items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
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
  
  public A removeFromMetricRelabelings(RelabelConfig... items) {
    if (this.metricRelabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("metricRelabelings").remove(builder);
        this.metricRelabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRelabelings(RelabelConfig... items) {
    if (this.relabelings == null) {
      return (A) this;
    }
    for (RelabelConfig item : items) {
        RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
        _visitables.get("relabelings").remove(builder);
        this.relabelings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMetricRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (metricRelabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = metricRelabelings.iterator();
    List visitables = _visitables.get("metricRelabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelabelings(Predicate<RelabelConfigBuilder> predicate) {
    if (relabelings == null) {
      return (A) this;
    }
    Iterator<RelabelConfigBuilder> each = relabelings.iterator();
    List visitables = _visitables.get("relabelings");
    while (each.hasNext()) {
        RelabelConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MetricRelabelingsNested<A> setNewMetricRelabelingLike(int index,RelabelConfig item) {
    return new MetricRelabelingsNested(index, item);
  }
  
  public RelabelingsNested<A> setNewRelabelingLike(int index,RelabelConfig item) {
    return new RelabelingsNested(index, item);
  }
  
  public A setToMetricRelabelings(int index,RelabelConfig item) {
    if (this.metricRelabelings == null) {
      this.metricRelabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= metricRelabelings.size()) {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.add(builder);
    } else {
        _visitables.get("metricRelabelings").add(builder);
        metricRelabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRelabelings(int index,RelabelConfig item) {
    if (this.relabelings == null) {
      this.relabelings = new ArrayList();
    }
    RelabelConfigBuilder builder = new RelabelConfigBuilder(item);
    if (index < 0 || index >= relabelings.size()) {
        _visitables.get("relabelings").add(builder);
        relabelings.add(builder);
    } else {
        _visitables.get("relabelings").add(builder);
        relabelings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attachMetadata == null)) {
        sb.append("attachMetadata:");
        sb.append(attachMetadata);
        sb.append(",");
    }
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(fallbackScrapeProtocol == null)) {
        sb.append("fallbackScrapeProtocol:");
        sb.append(fallbackScrapeProtocol);
        sb.append(",");
    }
    if (!(metricRelabelings == null) && !(metricRelabelings.isEmpty())) {
        sb.append("metricRelabelings:");
        sb.append(metricRelabelings);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(relabelings == null) && !(relabelings.isEmpty())) {
        sb.append("relabelings:");
        sb.append(relabelings);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
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
  
  public A withAttachMetadata(AttachMetadata attachMetadata) {
    this._visitables.remove("attachMetadata");
    if (attachMetadata != null) {
        this.attachMetadata = new AttachMetadataBuilder(attachMetadata);
        this._visitables.get("attachMetadata").add(this.attachMetadata);
    } else {
        this.attachMetadata = null;
        this._visitables.get("attachMetadata").remove(this.attachMetadata);
    }
    return (A) this;
  }
  
  public A withAuthorization(Authorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new AuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withDefault() {
    return withDefault(true);
  }
  
  public A withDefault(Boolean _default) {
    this._default = _default;
    return (A) this;
  }
  
  public A withFallbackScrapeProtocol(String fallbackScrapeProtocol) {
    this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    return (A) this;
  }
  
  public A withMetricRelabelings(List<RelabelConfig> metricRelabelings) {
    if (this.metricRelabelings != null) {
      this._visitables.get("metricRelabelings").clear();
    }
    if (metricRelabelings != null) {
        this.metricRelabelings = new ArrayList();
        for (RelabelConfig item : metricRelabelings) {
          this.addToMetricRelabelings(item);
        }
    } else {
      this.metricRelabelings = null;
    }
    return (A) this;
  }
  
  public A withMetricRelabelings(RelabelConfig... metricRelabelings) {
    if (this.metricRelabelings != null) {
        this.metricRelabelings.clear();
        _visitables.remove("metricRelabelings");
    }
    if (metricRelabelings != null) {
      for (RelabelConfig item : metricRelabelings) {
        this.addToMetricRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AttachMetadataNested<A> withNewAttachMetadata() {
    return new AttachMetadataNested(null);
  }
  
  public A withNewAttachMetadata(Boolean node) {
    return (A) this.withAttachMetadata(new AttachMetadata(node));
  }
  
  public AttachMetadataNested<A> withNewAttachMetadataLike(AttachMetadata item) {
    return new AttachMetadataNested(item);
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(Authorization item) {
    return new AuthorizationNested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(TLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withRelabelings(List<RelabelConfig> relabelings) {
    if (this.relabelings != null) {
      this._visitables.get("relabelings").clear();
    }
    if (relabelings != null) {
        this.relabelings = new ArrayList();
        for (RelabelConfig item : relabelings) {
          this.addToRelabelings(item);
        }
    } else {
      this.relabelings = null;
    }
    return (A) this;
  }
  
  public A withRelabelings(RelabelConfig... relabelings) {
    if (this.relabelings != null) {
        this.relabelings.clear();
        _visitables.remove("relabelings");
    }
    if (relabelings != null) {
      for (RelabelConfig item : relabelings) {
        this.addToRelabelings(item);
      }
    }
    return (A) this;
  }
  
  public A withTlsConfig(TLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new TLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  public class AttachMetadataNested<N> extends AttachMetadataFluent<AttachMetadataNested<N>> implements Nested<N>{
  
    AttachMetadataBuilder builder;
  
    AttachMetadataNested(AttachMetadata item) {
      this.builder = new AttachMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeClassFluent.this.withAttachMetadata(builder.build());
    }
    
    public N endAttachMetadata() {
      return and();
    }
    
  }
  public class AuthorizationNested<N> extends AuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    AuthorizationBuilder builder;
  
    AuthorizationNested(Authorization item) {
      this.builder = new AuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeClassFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class MetricRelabelingsNested<N> extends RelabelConfigFluent<MetricRelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    MetricRelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeClassFluent.this.setToMetricRelabelings(index, builder.build());
    }
    
    public N endMetricRelabeling() {
      return and();
    }
    
  }
  public class RelabelingsNested<N> extends RelabelConfigFluent<RelabelingsNested<N>> implements Nested<N>{
  
    RelabelConfigBuilder builder;
    int index;
  
    RelabelingsNested(int index,RelabelConfig item) {
      this.index = index;
      this.builder = new RelabelConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeClassFluent.this.setToRelabelings(index, builder.build());
    }
    
    public N endRelabeling() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends TLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsConfigNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ScrapeClassFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}