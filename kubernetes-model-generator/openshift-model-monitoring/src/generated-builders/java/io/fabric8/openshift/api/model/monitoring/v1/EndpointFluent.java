package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
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
public class EndpointFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.EndpointFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private String bearerTokenFile;
  private SecretKeySelector bearerTokenSecret;
  private Boolean enableHttp2;
  private Boolean filterRunning;
  private Boolean followRedirects;
  private Boolean honorLabels;
  private Boolean honorTimestamps;
  private String interval;
  private ArrayList<RelabelConfigBuilder> metricRelabelings = new ArrayList<RelabelConfigBuilder>();
  private String noProxy;
  private OAuth2Builder oauth2;
  private Map<String,List<String>> params;
  private String path;
  private String port;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private ArrayList<RelabelConfigBuilder> relabelings = new ArrayList<RelabelConfigBuilder>();
  private String scheme;
  private String scrapeTimeout;
  private IntOrStringBuilder targetPort;
  private TLSConfigBuilder tlsConfig;
  private Boolean trackTimestampsStaleness;

  public EndpointFluent() {
  }
  
  public EndpointFluent(Endpoint instance) {
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
  
  public A addToParams(Map<String,List<String>> map) {
    if (this.params == null && map != null) {
      this.params = new LinkedHashMap();
    }
    if (map != null) {
      this.params.putAll(map);
    }
    return (A) this;
  }
  
  public A addToParams(String key,List<String> value) {
    if (this.params == null && key != null && value != null) {
      this.params = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.params.put(key, value);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null && map != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyConnectHeader.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(String key,List<SecretKeySelector> value) {
    if (this.proxyConnectHeader == null && key != null && value != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyConnectHeader.put(key, value);
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
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
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
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public RelabelConfig buildRelabeling(int index) {
    return this.relabelings.get(index).build();
  }
  
  public List<RelabelConfig> buildRelabelings() {
    return this.relabelings != null ? build(relabelings) : null;
  }
  
  public IntOrString buildTargetPort() {
    return this.targetPort != null ? this.targetPort.build() : null;
  }
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(Endpoint instance) {
    instance = instance != null ? instance : new Endpoint();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBearerTokenFile(instance.getBearerTokenFile());
        this.withBearerTokenSecret(instance.getBearerTokenSecret());
        this.withEnableHttp2(instance.getEnableHttp2());
        this.withFilterRunning(instance.getFilterRunning());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withHonorLabels(instance.getHonorLabels());
        this.withHonorTimestamps(instance.getHonorTimestamps());
        this.withInterval(instance.getInterval());
        this.withMetricRelabelings(instance.getMetricRelabelings());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withParams(instance.getParams());
        this.withPath(instance.getPath());
        this.withPort(instance.getPort());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRelabelings(instance.getRelabelings());
        this.withScheme(instance.getScheme());
        this.withScrapeTimeout(instance.getScrapeTimeout());
        this.withTargetPort(instance.getTargetPort());
        this.withTlsConfig(instance.getTlsConfig());
        this.withTrackTimestampsStaleness(instance.getTrackTimestampsStaleness());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
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
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new SafeAuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(SafeAuthorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuth item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public Oauth2Nested<A> editOrNewOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(new OAuth2Builder().build()));
  }
  
  public Oauth2Nested<A> editOrNewOauth2Like(OAuth2 item) {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(item));
  }
  
  public TargetPortNested<A> editOrNewTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(new IntOrStringBuilder().build()));
  }
  
  public TargetPortNested<A> editOrNewTargetPortLike(IntOrString item) {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(item));
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
  
  public TargetPortNested<A> editTargetPort() {
    return this.withNewTargetPortLike(Optional.ofNullable(this.buildTargetPort()).orElse(null));
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
    EndpointFluent that = (EndpointFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenFile, that.bearerTokenFile))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenSecret, that.bearerTokenSecret))) {
      return false;
    }
    if (!(Objects.equals(enableHttp2, that.enableHttp2))) {
      return false;
    }
    if (!(Objects.equals(filterRunning, that.filterRunning))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(honorLabels, that.honorLabels))) {
      return false;
    }
    if (!(Objects.equals(honorTimestamps, that.honorTimestamps))) {
      return false;
    }
    if (!(Objects.equals(interval, that.interval))) {
      return false;
    }
    if (!(Objects.equals(metricRelabelings, that.metricRelabelings))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(proxyConnectHeader, that.proxyConnectHeader))) {
      return false;
    }
    if (!(Objects.equals(proxyFromEnvironment, that.proxyFromEnvironment))) {
      return false;
    }
    if (!(Objects.equals(proxyUrl, that.proxyUrl))) {
      return false;
    }
    if (!(Objects.equals(relabelings, that.relabelings))) {
      return false;
    }
    if (!(Objects.equals(scheme, that.scheme))) {
      return false;
    }
    if (!(Objects.equals(scrapeTimeout, that.scrapeTimeout))) {
      return false;
    }
    if (!(Objects.equals(targetPort, that.targetPort))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(trackTimestampsStaleness, that.trackTimestampsStaleness))) {
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
  
  public String getBearerTokenFile() {
    return this.bearerTokenFile;
  }
  
  public SecretKeySelector getBearerTokenSecret() {
    return this.bearerTokenSecret;
  }
  
  public Boolean getEnableHttp2() {
    return this.enableHttp2;
  }
  
  public Boolean getFilterRunning() {
    return this.filterRunning;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public Boolean getHonorLabels() {
    return this.honorLabels;
  }
  
  public Boolean getHonorTimestamps() {
    return this.honorTimestamps;
  }
  
  public String getInterval() {
    return this.interval;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public Map<String,List<String>> getParams() {
    return this.params;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getPort() {
    return this.port;
  }
  
  public Map<String,List<SecretKeySelector>> getProxyConnectHeader() {
    return this.proxyConnectHeader;
  }
  
  public Boolean getProxyFromEnvironment() {
    return this.proxyFromEnvironment;
  }
  
  public String getProxyUrl() {
    return this.proxyUrl;
  }
  
  public String getScheme() {
    return this.scheme;
  }
  
  public String getScrapeTimeout() {
    return this.scrapeTimeout;
  }
  
  public Boolean getTrackTimestampsStaleness() {
    return this.trackTimestampsStaleness;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasBearerTokenFile() {
    return this.bearerTokenFile != null;
  }
  
  public boolean hasBearerTokenSecret() {
    return this.bearerTokenSecret != null;
  }
  
  public boolean hasEnableHttp2() {
    return this.enableHttp2 != null;
  }
  
  public boolean hasFilterRunning() {
    return this.filterRunning != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasHonorLabels() {
    return this.honorLabels != null;
  }
  
  public boolean hasHonorTimestamps() {
    return this.honorTimestamps != null;
  }
  
  public boolean hasInterval() {
    return this.interval != null;
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
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
  }
  
  public boolean hasParams() {
    return this.params != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProxyConnectHeader() {
    return this.proxyConnectHeader != null;
  }
  
  public boolean hasProxyFromEnvironment() {
    return this.proxyFromEnvironment != null;
  }
  
  public boolean hasProxyUrl() {
    return this.proxyUrl != null;
  }
  
  public boolean hasRelabelings() {
    return this.relabelings != null && !(this.relabelings.isEmpty());
  }
  
  public boolean hasScheme() {
    return this.scheme != null;
  }
  
  public boolean hasScrapeTimeout() {
    return this.scrapeTimeout != null;
  }
  
  public boolean hasTargetPort() {
    return this.targetPort != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasTrackTimestampsStaleness() {
    return this.trackTimestampsStaleness != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorization, basicAuth, bearerTokenFile, bearerTokenSecret, enableHttp2, filterRunning, followRedirects, honorLabels, honorTimestamps, interval, metricRelabelings, noProxy, oauth2, params, path, port, proxyConnectHeader, proxyFromEnvironment, proxyUrl, relabelings, scheme, scrapeTimeout, targetPort, tlsConfig, trackTimestampsStaleness, additionalProperties);
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
  
  public A removeFromParams(String key) {
    if (this.params == null) {
      return (A) this;
    }
    if (key != null && this.params != null) {
      this.params.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromParams(Map<String,List<String>> map) {
    if (this.params == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.params != null) {
          this.params.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(String key) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (key != null && this.proxyConnectHeader != null) {
      this.proxyConnectHeader.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyConnectHeader != null) {
          this.proxyConnectHeader.remove(key);
        }
      }
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
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(bearerTokenFile == null)) {
        sb.append("bearerTokenFile:");
        sb.append(bearerTokenFile);
        sb.append(",");
    }
    if (!(bearerTokenSecret == null)) {
        sb.append("bearerTokenSecret:");
        sb.append(bearerTokenSecret);
        sb.append(",");
    }
    if (!(enableHttp2 == null)) {
        sb.append("enableHttp2:");
        sb.append(enableHttp2);
        sb.append(",");
    }
    if (!(filterRunning == null)) {
        sb.append("filterRunning:");
        sb.append(filterRunning);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(honorLabels == null)) {
        sb.append("honorLabels:");
        sb.append(honorLabels);
        sb.append(",");
    }
    if (!(honorTimestamps == null)) {
        sb.append("honorTimestamps:");
        sb.append(honorTimestamps);
        sb.append(",");
    }
    if (!(interval == null)) {
        sb.append("interval:");
        sb.append(interval);
        sb.append(",");
    }
    if (!(metricRelabelings == null) && !(metricRelabelings.isEmpty())) {
        sb.append("metricRelabelings:");
        sb.append(metricRelabelings);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(oauth2 == null)) {
        sb.append("oauth2:");
        sb.append(oauth2);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(proxyConnectHeader == null) && !(proxyConnectHeader.isEmpty())) {
        sb.append("proxyConnectHeader:");
        sb.append(proxyConnectHeader);
        sb.append(",");
    }
    if (!(proxyFromEnvironment == null)) {
        sb.append("proxyFromEnvironment:");
        sb.append(proxyFromEnvironment);
        sb.append(",");
    }
    if (!(proxyUrl == null)) {
        sb.append("proxyUrl:");
        sb.append(proxyUrl);
        sb.append(",");
    }
    if (!(relabelings == null) && !(relabelings.isEmpty())) {
        sb.append("relabelings:");
        sb.append(relabelings);
        sb.append(",");
    }
    if (!(scheme == null)) {
        sb.append("scheme:");
        sb.append(scheme);
        sb.append(",");
    }
    if (!(scrapeTimeout == null)) {
        sb.append("scrapeTimeout:");
        sb.append(scrapeTimeout);
        sb.append(",");
    }
    if (!(targetPort == null)) {
        sb.append("targetPort:");
        sb.append(targetPort);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(trackTimestampsStaleness == null)) {
        sb.append("trackTimestampsStaleness:");
        sb.append(trackTimestampsStaleness);
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
  
  public A withAuthorization(SafeAuthorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new SafeAuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withBasicAuth(BasicAuth basicAuth) {
    this._visitables.remove("basicAuth");
    if (basicAuth != null) {
        this.basicAuth = new BasicAuthBuilder(basicAuth);
        this._visitables.get("basicAuth").add(this.basicAuth);
    } else {
        this.basicAuth = null;
        this._visitables.get("basicAuth").remove(this.basicAuth);
    }
    return (A) this;
  }
  
  public A withBearerTokenFile(String bearerTokenFile) {
    this.bearerTokenFile = bearerTokenFile;
    return (A) this;
  }
  
  public A withBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
    this.bearerTokenSecret = bearerTokenSecret;
    return (A) this;
  }
  
  public A withEnableHttp2() {
    return withEnableHttp2(true);
  }
  
  public A withEnableHttp2(Boolean enableHttp2) {
    this.enableHttp2 = enableHttp2;
    return (A) this;
  }
  
  public A withFilterRunning() {
    return withFilterRunning(true);
  }
  
  public A withFilterRunning(Boolean filterRunning) {
    this.filterRunning = filterRunning;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public A withHonorLabels() {
    return withHonorLabels(true);
  }
  
  public A withHonorLabels(Boolean honorLabels) {
    this.honorLabels = honorLabels;
    return (A) this;
  }
  
  public A withHonorTimestamps() {
    return withHonorTimestamps(true);
  }
  
  public A withHonorTimestamps(Boolean honorTimestamps) {
    this.honorTimestamps = honorTimestamps;
    return (A) this;
  }
  
  public A withInterval(String interval) {
    this.interval = interval;
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
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(SafeAuthorization item) {
    return new AuthorizationNested(item);
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuth item) {
    return new BasicAuthNested(item);
  }
  
  public A withNewBearerTokenSecret(String key,String name,Boolean optional) {
    return (A) this.withBearerTokenSecret(new SecretKeySelector(key, name, optional));
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public TargetPortNested<A> withNewTargetPort() {
    return new TargetPortNested(null);
  }
  
  public A withNewTargetPort(Object value) {
    return (A) this.withTargetPort(new IntOrString(value));
  }
  
  public TargetPortNested<A> withNewTargetPortLike(IntOrString item) {
    return new TargetPortNested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(TLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withOauth2(OAuth2 oauth2) {
    this._visitables.remove("oauth2");
    if (oauth2 != null) {
        this.oauth2 = new OAuth2Builder(oauth2);
        this._visitables.get("oauth2").add(this.oauth2);
    } else {
        this.oauth2 = null;
        this._visitables.get("oauth2").remove(this.oauth2);
    }
    return (A) this;
  }
  
  public <K,V>A withParams(Map<String,List<String>> params) {
    if (params == null) {
      this.params = null;
    } else {
      this.params = new LinkedHashMap(params);
    }
    return (A) this;
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withPort(String port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withProxyConnectHeader(Map<String,List<SecretKeySelector>> proxyConnectHeader) {
    if (proxyConnectHeader == null) {
      this.proxyConnectHeader = null;
    } else {
      this.proxyConnectHeader = new LinkedHashMap(proxyConnectHeader);
    }
    return (A) this;
  }
  
  public A withProxyFromEnvironment() {
    return withProxyFromEnvironment(true);
  }
  
  public A withProxyFromEnvironment(Boolean proxyFromEnvironment) {
    this.proxyFromEnvironment = proxyFromEnvironment;
    return (A) this;
  }
  
  public A withProxyUrl(String proxyUrl) {
    this.proxyUrl = proxyUrl;
    return (A) this;
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
  
  public A withScheme(String scheme) {
    this.scheme = scheme;
    return (A) this;
  }
  
  public A withScrapeTimeout(String scrapeTimeout) {
    this.scrapeTimeout = scrapeTimeout;
    return (A) this;
  }
  
  public A withTargetPort(IntOrString targetPort) {
    this._visitables.remove("targetPort");
    if (targetPort != null) {
        this.targetPort = new IntOrStringBuilder(targetPort);
        this._visitables.get("targetPort").add(this.targetPort);
    } else {
        this.targetPort = null;
        this._visitables.get("targetPort").remove(this.targetPort);
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
  
  public A withTrackTimestampsStaleness() {
    return withTrackTimestampsStaleness(true);
  }
  
  public A withTrackTimestampsStaleness(Boolean trackTimestampsStaleness) {
    this.trackTimestampsStaleness = trackTimestampsStaleness;
    return (A) this;
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class BasicAuthNested<N> extends BasicAuthFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthBuilder builder;
  
    BasicAuthNested(BasicAuth item) {
      this.builder = new BasicAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
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
      return (N) EndpointFluent.this.setToMetricRelabelings(index, builder.build());
    }
    
    public N endMetricRelabeling() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
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
      return (N) EndpointFluent.this.setToRelabelings(index, builder.build());
    }
    
    public N endRelabeling() {
      return and();
    }
    
  }
  public class TargetPortNested<N> extends IntOrStringFluent<TargetPortNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    TargetPortNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withTargetPort(builder.build());
    }
    
    public N endTargetPort() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends TLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsConfigNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}