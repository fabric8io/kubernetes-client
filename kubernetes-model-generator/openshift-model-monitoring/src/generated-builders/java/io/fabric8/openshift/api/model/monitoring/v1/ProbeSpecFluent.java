package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
import java.lang.Long;
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
public class ProbeSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ProbeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private SecretKeySelector bearerTokenSecret;
  private Boolean convertClassicHistogramsToNHCB;
  private Boolean enableHttp2;
  private String fallbackScrapeProtocol;
  private Boolean followRedirects;
  private String interval;
  private String jobName;
  private Long keepDroppedTargets;
  private Long labelLimit;
  private Long labelNameLengthLimit;
  private Long labelValueLengthLimit;
  private ArrayList<RelabelConfigBuilder> metricRelabelings = new ArrayList<RelabelConfigBuilder>();
  private String module;
  private Long nativeHistogramBucketLimit;
  private Quantity nativeHistogramMinBucketFactor;
  private OAuth2Builder oauth2;
  private ArrayList<ProbeParamBuilder> params = new ArrayList<ProbeParamBuilder>();
  private ProberSpecBuilder prober;
  private Long sampleLimit;
  private String scrapeClass;
  private Boolean scrapeClassicHistograms;
  private Boolean scrapeNativeHistograms;
  private List<String> scrapeProtocols = new ArrayList<String>();
  private String scrapeTimeout;
  private Long targetLimit;
  private ProbeTargetsBuilder targets;
  private SafeTLSConfigBuilder tlsConfig;

  public ProbeSpecFluent() {
  }
  
  public ProbeSpecFluent(ProbeSpec instance) {
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
  
  public A addAllToParams(Collection<ProbeParam> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ProbeParam item : items) {
        ProbeParamBuilder builder = new ProbeParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabeling() {
    return new MetricRelabelingsNested(-1, null);
  }
  
  public MetricRelabelingsNested<A> addNewMetricRelabelingLike(RelabelConfig item) {
    return new MetricRelabelingsNested(-1, item);
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public ParamsNested<A> addNewParamLike(ProbeParam item) {
    return new ParamsNested(-1, item);
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
  
  public A addToParams(ProbeParam... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ProbeParam item : items) {
        ProbeParamBuilder builder = new ProbeParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,ProbeParam item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ProbeParamBuilder builder = new ProbeParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.add(index, item);
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
  
  public ProbeParam buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public RelabelConfig buildLastMetricRelabeling() {
    return this.metricRelabelings.get(metricRelabelings.size() - 1).build();
  }
  
  public ProbeParam buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public RelabelConfig buildMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ProbeParam buildMatchingParam(Predicate<ProbeParamBuilder> predicate) {
      for (ProbeParamBuilder item : params) {
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
  
  public ProbeParam buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<ProbeParam> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public ProberSpec buildProber() {
    return this.prober != null ? this.prober.build() : null;
  }
  
  public ProbeTargets buildTargets() {
    return this.targets != null ? this.targets.build() : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(ProbeSpec instance) {
    instance = instance != null ? instance : new ProbeSpec();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBearerTokenSecret(instance.getBearerTokenSecret());
        this.withConvertClassicHistogramsToNHCB(instance.getConvertClassicHistogramsToNHCB());
        this.withEnableHttp2(instance.getEnableHttp2());
        this.withFallbackScrapeProtocol(instance.getFallbackScrapeProtocol());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withInterval(instance.getInterval());
        this.withJobName(instance.getJobName());
        this.withKeepDroppedTargets(instance.getKeepDroppedTargets());
        this.withLabelLimit(instance.getLabelLimit());
        this.withLabelNameLengthLimit(instance.getLabelNameLengthLimit());
        this.withLabelValueLengthLimit(instance.getLabelValueLengthLimit());
        this.withMetricRelabelings(instance.getMetricRelabelings());
        this.withModule(instance.getModule());
        this.withNativeHistogramBucketLimit(instance.getNativeHistogramBucketLimit());
        this.withNativeHistogramMinBucketFactor(instance.getNativeHistogramMinBucketFactor());
        this.withOauth2(instance.getOauth2());
        this.withParams(instance.getParams());
        this.withProber(instance.getProber());
        this.withSampleLimit(instance.getSampleLimit());
        this.withScrapeClass(instance.getScrapeClass());
        this.withScrapeClassicHistograms(instance.getScrapeClassicHistograms());
        this.withScrapeNativeHistograms(instance.getScrapeNativeHistograms());
        this.withScrapeProtocols(instance.getScrapeProtocols());
        this.withScrapeTimeout(instance.getScrapeTimeout());
        this.withTargetLimit(instance.getTargetLimit());
        this.withTargets(instance.getTargets());
        this.withTlsConfig(instance.getTlsConfig());
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
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public MetricRelabelingsNested<A> editLastMetricRelabeling() {
    int index = metricRelabelings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "metricRelabelings"));
    }
    return this.setNewMetricRelabelingLike(index, this.buildMetricRelabeling(index));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
  
  public ParamsNested<A> editMatchingParam(Predicate<ProbeParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < params.size();i++) {
      if (predicate.test(params.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
  
  public ProberNested<A> editOrNewProber() {
    return this.withNewProberLike(Optional.ofNullable(this.buildProber()).orElse(new ProberSpecBuilder().build()));
  }
  
  public ProberNested<A> editOrNewProberLike(ProberSpec item) {
    return this.withNewProberLike(Optional.ofNullable(this.buildProber()).orElse(item));
  }
  
  public TargetsNested<A> editOrNewTargets() {
    return this.withNewTargetsLike(Optional.ofNullable(this.buildTargets()).orElse(new ProbeTargetsBuilder().build()));
  }
  
  public TargetsNested<A> editOrNewTargetsLike(ProbeTargets item) {
    return this.withNewTargetsLike(Optional.ofNullable(this.buildTargets()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public ProberNested<A> editProber() {
    return this.withNewProberLike(Optional.ofNullable(this.buildProber()).orElse(null));
  }
  
  public TargetsNested<A> editTargets() {
    return this.withNewTargetsLike(Optional.ofNullable(this.buildTargets()).orElse(null));
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
    ProbeSpecFluent that = (ProbeSpecFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenSecret, that.bearerTokenSecret))) {
      return false;
    }
    if (!(Objects.equals(convertClassicHistogramsToNHCB, that.convertClassicHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(enableHttp2, that.enableHttp2))) {
      return false;
    }
    if (!(Objects.equals(fallbackScrapeProtocol, that.fallbackScrapeProtocol))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(interval, that.interval))) {
      return false;
    }
    if (!(Objects.equals(jobName, that.jobName))) {
      return false;
    }
    if (!(Objects.equals(keepDroppedTargets, that.keepDroppedTargets))) {
      return false;
    }
    if (!(Objects.equals(labelLimit, that.labelLimit))) {
      return false;
    }
    if (!(Objects.equals(labelNameLengthLimit, that.labelNameLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(labelValueLengthLimit, that.labelValueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(metricRelabelings, that.metricRelabelings))) {
      return false;
    }
    if (!(Objects.equals(module, that.module))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramBucketLimit, that.nativeHistogramBucketLimit))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramMinBucketFactor, that.nativeHistogramMinBucketFactor))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(prober, that.prober))) {
      return false;
    }
    if (!(Objects.equals(sampleLimit, that.sampleLimit))) {
      return false;
    }
    if (!(Objects.equals(scrapeClass, that.scrapeClass))) {
      return false;
    }
    if (!(Objects.equals(scrapeClassicHistograms, that.scrapeClassicHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeNativeHistograms, that.scrapeNativeHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeProtocols, that.scrapeProtocols))) {
      return false;
    }
    if (!(Objects.equals(scrapeTimeout, that.scrapeTimeout))) {
      return false;
    }
    if (!(Objects.equals(targetLimit, that.targetLimit))) {
      return false;
    }
    if (!(Objects.equals(targets, that.targets))) {
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
  
  public SecretKeySelector getBearerTokenSecret() {
    return this.bearerTokenSecret;
  }
  
  public Boolean getConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB;
  }
  
  public Boolean getEnableHttp2() {
    return this.enableHttp2;
  }
  
  public String getFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol;
  }
  
  public String getFirstScrapeProtocol() {
    return this.scrapeProtocols.get(0);
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getInterval() {
    return this.interval;
  }
  
  public String getJobName() {
    return this.jobName;
  }
  
  public Long getKeepDroppedTargets() {
    return this.keepDroppedTargets;
  }
  
  public Long getLabelLimit() {
    return this.labelLimit;
  }
  
  public Long getLabelNameLengthLimit() {
    return this.labelNameLengthLimit;
  }
  
  public Long getLabelValueLengthLimit() {
    return this.labelValueLengthLimit;
  }
  
  public String getLastScrapeProtocol() {
    return this.scrapeProtocols.get(scrapeProtocols.size() - 1);
  }
  
  public String getMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getModule() {
    return this.module;
  }
  
  public Long getNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit;
  }
  
  public Quantity getNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor;
  }
  
  public Long getSampleLimit() {
    return this.sampleLimit;
  }
  
  public String getScrapeClass() {
    return this.scrapeClass;
  }
  
  public Boolean getScrapeClassicHistograms() {
    return this.scrapeClassicHistograms;
  }
  
  public Boolean getScrapeNativeHistograms() {
    return this.scrapeNativeHistograms;
  }
  
  public String getScrapeProtocol(int index) {
    return this.scrapeProtocols.get(index);
  }
  
  public List<String> getScrapeProtocols() {
    return this.scrapeProtocols;
  }
  
  public String getScrapeTimeout() {
    return this.scrapeTimeout;
  }
  
  public Long getTargetLimit() {
    return this.targetLimit;
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
  
  public boolean hasBearerTokenSecret() {
    return this.bearerTokenSecret != null;
  }
  
  public boolean hasConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB != null;
  }
  
  public boolean hasEnableHttp2() {
    return this.enableHttp2 != null;
  }
  
  public boolean hasFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasInterval() {
    return this.interval != null;
  }
  
  public boolean hasJobName() {
    return this.jobName != null;
  }
  
  public boolean hasKeepDroppedTargets() {
    return this.keepDroppedTargets != null;
  }
  
  public boolean hasLabelLimit() {
    return this.labelLimit != null;
  }
  
  public boolean hasLabelNameLengthLimit() {
    return this.labelNameLengthLimit != null;
  }
  
  public boolean hasLabelValueLengthLimit() {
    return this.labelValueLengthLimit != null;
  }
  
  public boolean hasMatchingMetricRelabeling(Predicate<RelabelConfigBuilder> predicate) {
      for (RelabelConfigBuilder item : metricRelabelings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingParam(Predicate<ProbeParamBuilder> predicate) {
      for (ProbeParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetricRelabelings() {
    return this.metricRelabelings != null && !(this.metricRelabelings.isEmpty());
  }
  
  public boolean hasModule() {
    return this.module != null;
  }
  
  public boolean hasNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit != null;
  }
  
  public boolean hasNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasProber() {
    return this.prober != null;
  }
  
  public boolean hasSampleLimit() {
    return this.sampleLimit != null;
  }
  
  public boolean hasScrapeClass() {
    return this.scrapeClass != null;
  }
  
  public boolean hasScrapeClassicHistograms() {
    return this.scrapeClassicHistograms != null;
  }
  
  public boolean hasScrapeNativeHistograms() {
    return this.scrapeNativeHistograms != null;
  }
  
  public boolean hasScrapeProtocols() {
    return this.scrapeProtocols != null && !(this.scrapeProtocols.isEmpty());
  }
  
  public boolean hasScrapeTimeout() {
    return this.scrapeTimeout != null;
  }
  
  public boolean hasTargetLimit() {
    return this.targetLimit != null;
  }
  
  public boolean hasTargets() {
    return this.targets != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorization, basicAuth, bearerTokenSecret, convertClassicHistogramsToNHCB, enableHttp2, fallbackScrapeProtocol, followRedirects, interval, jobName, keepDroppedTargets, labelLimit, labelNameLengthLimit, labelValueLengthLimit, metricRelabelings, module, nativeHistogramBucketLimit, nativeHistogramMinBucketFactor, oauth2, params, prober, sampleLimit, scrapeClass, scrapeClassicHistograms, scrapeNativeHistograms, scrapeProtocols, scrapeTimeout, targetLimit, targets, tlsConfig, additionalProperties);
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
  
  public A removeAllFromParams(Collection<ProbeParam> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ProbeParam item : items) {
        ProbeParamBuilder builder = new ProbeParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
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
  
  public A removeFromParams(ProbeParam... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ProbeParam item : items) {
        ProbeParamBuilder builder = new ProbeParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
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
  
  public A removeMatchingFromParams(Predicate<ProbeParamBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ProbeParamBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ProbeParamBuilder builder = each.next();
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
  
  public ParamsNested<A> setNewParamLike(int index,ProbeParam item) {
    return new ParamsNested(index, item);
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
  
  public A setToParams(int index,ProbeParam item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ProbeParamBuilder builder = new ProbeParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.set(index, item);
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
    if (!(bearerTokenSecret == null)) {
        sb.append("bearerTokenSecret:");
        sb.append(bearerTokenSecret);
        sb.append(",");
    }
    if (!(convertClassicHistogramsToNHCB == null)) {
        sb.append("convertClassicHistogramsToNHCB:");
        sb.append(convertClassicHistogramsToNHCB);
        sb.append(",");
    }
    if (!(enableHttp2 == null)) {
        sb.append("enableHttp2:");
        sb.append(enableHttp2);
        sb.append(",");
    }
    if (!(fallbackScrapeProtocol == null)) {
        sb.append("fallbackScrapeProtocol:");
        sb.append(fallbackScrapeProtocol);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(interval == null)) {
        sb.append("interval:");
        sb.append(interval);
        sb.append(",");
    }
    if (!(jobName == null)) {
        sb.append("jobName:");
        sb.append(jobName);
        sb.append(",");
    }
    if (!(keepDroppedTargets == null)) {
        sb.append("keepDroppedTargets:");
        sb.append(keepDroppedTargets);
        sb.append(",");
    }
    if (!(labelLimit == null)) {
        sb.append("labelLimit:");
        sb.append(labelLimit);
        sb.append(",");
    }
    if (!(labelNameLengthLimit == null)) {
        sb.append("labelNameLengthLimit:");
        sb.append(labelNameLengthLimit);
        sb.append(",");
    }
    if (!(labelValueLengthLimit == null)) {
        sb.append("labelValueLengthLimit:");
        sb.append(labelValueLengthLimit);
        sb.append(",");
    }
    if (!(metricRelabelings == null) && !(metricRelabelings.isEmpty())) {
        sb.append("metricRelabelings:");
        sb.append(metricRelabelings);
        sb.append(",");
    }
    if (!(module == null)) {
        sb.append("module:");
        sb.append(module);
        sb.append(",");
    }
    if (!(nativeHistogramBucketLimit == null)) {
        sb.append("nativeHistogramBucketLimit:");
        sb.append(nativeHistogramBucketLimit);
        sb.append(",");
    }
    if (!(nativeHistogramMinBucketFactor == null)) {
        sb.append("nativeHistogramMinBucketFactor:");
        sb.append(nativeHistogramMinBucketFactor);
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
    if (!(prober == null)) {
        sb.append("prober:");
        sb.append(prober);
        sb.append(",");
    }
    if (!(sampleLimit == null)) {
        sb.append("sampleLimit:");
        sb.append(sampleLimit);
        sb.append(",");
    }
    if (!(scrapeClass == null)) {
        sb.append("scrapeClass:");
        sb.append(scrapeClass);
        sb.append(",");
    }
    if (!(scrapeClassicHistograms == null)) {
        sb.append("scrapeClassicHistograms:");
        sb.append(scrapeClassicHistograms);
        sb.append(",");
    }
    if (!(scrapeNativeHistograms == null)) {
        sb.append("scrapeNativeHistograms:");
        sb.append(scrapeNativeHistograms);
        sb.append(",");
    }
    if (!(scrapeProtocols == null) && !(scrapeProtocols.isEmpty())) {
        sb.append("scrapeProtocols:");
        sb.append(scrapeProtocols);
        sb.append(",");
    }
    if (!(scrapeTimeout == null)) {
        sb.append("scrapeTimeout:");
        sb.append(scrapeTimeout);
        sb.append(",");
    }
    if (!(targetLimit == null)) {
        sb.append("targetLimit:");
        sb.append(targetLimit);
        sb.append(",");
    }
    if (!(targets == null)) {
        sb.append("targets:");
        sb.append(targets);
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
  
  public A withBearerTokenSecret(SecretKeySelector bearerTokenSecret) {
    this.bearerTokenSecret = bearerTokenSecret;
    return (A) this;
  }
  
  public A withConvertClassicHistogramsToNHCB() {
    return withConvertClassicHistogramsToNHCB(true);
  }
  
  public A withConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
    this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    return (A) this;
  }
  
  public A withEnableHttp2() {
    return withEnableHttp2(true);
  }
  
  public A withEnableHttp2(Boolean enableHttp2) {
    this.enableHttp2 = enableHttp2;
    return (A) this;
  }
  
  public A withFallbackScrapeProtocol(String fallbackScrapeProtocol) {
    this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public A withInterval(String interval) {
    this.interval = interval;
    return (A) this;
  }
  
  public A withJobName(String jobName) {
    this.jobName = jobName;
    return (A) this;
  }
  
  public A withKeepDroppedTargets(Long keepDroppedTargets) {
    this.keepDroppedTargets = keepDroppedTargets;
    return (A) this;
  }
  
  public A withLabelLimit(Long labelLimit) {
    this.labelLimit = labelLimit;
    return (A) this;
  }
  
  public A withLabelNameLengthLimit(Long labelNameLengthLimit) {
    this.labelNameLengthLimit = labelNameLengthLimit;
    return (A) this;
  }
  
  public A withLabelValueLengthLimit(Long labelValueLengthLimit) {
    this.labelValueLengthLimit = labelValueLengthLimit;
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
  
  public A withModule(String module) {
    this.module = module;
    return (A) this;
  }
  
  public A withNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
    this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    return (A) this;
  }
  
  public A withNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
    this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
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
  
  public A withNewNativeHistogramMinBucketFactor(String amount) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount));
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount,String format) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount, format));
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public ProberNested<A> withNewProber() {
    return new ProberNested(null);
  }
  
  public ProberNested<A> withNewProberLike(ProberSpec item) {
    return new ProberNested(item);
  }
  
  public TargetsNested<A> withNewTargets() {
    return new TargetsNested(null);
  }
  
  public TargetsNested<A> withNewTargetsLike(ProbeTargets item) {
    return new TargetsNested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
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
  
  public A withParams(List<ProbeParam> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (ProbeParam item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(ProbeParam... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (ProbeParam item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  
  public A withProber(ProberSpec prober) {
    this._visitables.remove("prober");
    if (prober != null) {
        this.prober = new ProberSpecBuilder(prober);
        this._visitables.get("prober").add(this.prober);
    } else {
        this.prober = null;
        this._visitables.get("prober").remove(this.prober);
    }
    return (A) this;
  }
  
  public A withSampleLimit(Long sampleLimit) {
    this.sampleLimit = sampleLimit;
    return (A) this;
  }
  
  public A withScrapeClass(String scrapeClass) {
    this.scrapeClass = scrapeClass;
    return (A) this;
  }
  
  public A withScrapeClassicHistograms() {
    return withScrapeClassicHistograms(true);
  }
  
  public A withScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
    this.scrapeClassicHistograms = scrapeClassicHistograms;
    return (A) this;
  }
  
  public A withScrapeNativeHistograms() {
    return withScrapeNativeHistograms(true);
  }
  
  public A withScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
    this.scrapeNativeHistograms = scrapeNativeHistograms;
    return (A) this;
  }
  
  public A withScrapeProtocols(List<String> scrapeProtocols) {
    if (scrapeProtocols != null) {
        this.scrapeProtocols = new ArrayList();
        for (String item : scrapeProtocols) {
          this.addToScrapeProtocols(item);
        }
    } else {
      this.scrapeProtocols = null;
    }
    return (A) this;
  }
  
  public A withScrapeProtocols(String... scrapeProtocols) {
    if (this.scrapeProtocols != null) {
        this.scrapeProtocols.clear();
        _visitables.remove("scrapeProtocols");
    }
    if (scrapeProtocols != null) {
      for (String item : scrapeProtocols) {
        this.addToScrapeProtocols(item);
      }
    }
    return (A) this;
  }
  
  public A withScrapeTimeout(String scrapeTimeout) {
    this.scrapeTimeout = scrapeTimeout;
    return (A) this;
  }
  
  public A withTargetLimit(Long targetLimit) {
    this.targetLimit = targetLimit;
    return (A) this;
  }
  
  public A withTargets(ProbeTargets targets) {
    this._visitables.remove("targets");
    if (targets != null) {
        this.targets = new ProbeTargetsBuilder(targets);
        this._visitables.get("targets").add(this.targets);
    } else {
        this.targets = null;
        this._visitables.get("targets").remove(this.targets);
    }
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeSpecFluent.this.withAuthorization(builder.build());
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
      return (N) ProbeSpecFluent.this.withBasicAuth(builder.build());
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
      return (N) ProbeSpecFluent.this.setToMetricRelabelings(index, builder.build());
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
      return (N) ProbeSpecFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class ParamsNested<N> extends ProbeParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ProbeParamBuilder builder;
    int index;
  
    ParamsNested(int index,ProbeParam item) {
      this.index = index;
      this.builder = new ProbeParamBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class ProberNested<N> extends ProberSpecFluent<ProberNested<N>> implements Nested<N>{
  
    ProberSpecBuilder builder;
  
    ProberNested(ProberSpec item) {
      this.builder = new ProberSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeSpecFluent.this.withProber(builder.build());
    }
    
    public N endProber() {
      return and();
    }
    
  }
  public class TargetsNested<N> extends ProbeTargetsFluent<TargetsNested<N>> implements Nested<N>{
  
    ProbeTargetsBuilder builder;
  
    TargetsNested(ProbeTargets item) {
      this.builder = new ProbeTargetsBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeSpecFluent.this.withTargets(builder.build());
    }
    
    public N endTargets() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeSpecFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}