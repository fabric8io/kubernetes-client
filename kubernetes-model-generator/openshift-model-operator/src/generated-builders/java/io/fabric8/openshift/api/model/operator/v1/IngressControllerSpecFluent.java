package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class IngressControllerSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClientTLSBuilder clientTLS;
  private String closedClientConnectionPolicy;
  private LocalObjectReferenceBuilder defaultCertificate;
  private String domain;
  private EndpointPublishingStrategyBuilder endpointPublishingStrategy;
  private HTTPCompressionPolicyBuilder httpCompression;
  private String httpEmptyRequestsPolicy;
  private ConfigMapNameReference httpErrorCodePages;
  private IngressControllerHTTPHeadersBuilder httpHeaders;
  private String idleConnectionTerminationPolicy;
  private IngressControllerLoggingBuilder logging;
  private LabelSelectorBuilder namespaceSelector;
  private NodePlacementBuilder nodePlacement;
  private Integer replicas;
  private RouteAdmissionPolicyBuilder routeAdmission;
  private LabelSelectorBuilder routeSelector;
  private TLSSecurityProfile tlsSecurityProfile;
  private IngressControllerTuningOptionsBuilder tuningOptions;
  private Object unsupportedConfigOverrides;

  public IngressControllerSpecFluent() {
  }
  
  public IngressControllerSpecFluent(IngressControllerSpec instance) {
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
  
  public ClientTLS buildClientTLS() {
    return this.clientTLS != null ? this.clientTLS.build() : null;
  }
  
  public LocalObjectReference buildDefaultCertificate() {
    return this.defaultCertificate != null ? this.defaultCertificate.build() : null;
  }
  
  public EndpointPublishingStrategy buildEndpointPublishingStrategy() {
    return this.endpointPublishingStrategy != null ? this.endpointPublishingStrategy.build() : null;
  }
  
  public HTTPCompressionPolicy buildHttpCompression() {
    return this.httpCompression != null ? this.httpCompression.build() : null;
  }
  
  public IngressControllerHTTPHeaders buildHttpHeaders() {
    return this.httpHeaders != null ? this.httpHeaders.build() : null;
  }
  
  public IngressControllerLogging buildLogging() {
    return this.logging != null ? this.logging.build() : null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public NodePlacement buildNodePlacement() {
    return this.nodePlacement != null ? this.nodePlacement.build() : null;
  }
  
  public RouteAdmissionPolicy buildRouteAdmission() {
    return this.routeAdmission != null ? this.routeAdmission.build() : null;
  }
  
  public LabelSelector buildRouteSelector() {
    return this.routeSelector != null ? this.routeSelector.build() : null;
  }
  
  public IngressControllerTuningOptions buildTuningOptions() {
    return this.tuningOptions != null ? this.tuningOptions.build() : null;
  }
  
  protected void copyInstance(IngressControllerSpec instance) {
    instance = instance != null ? instance : new IngressControllerSpec();
    if (instance != null) {
        this.withClientTLS(instance.getClientTLS());
        this.withClosedClientConnectionPolicy(instance.getClosedClientConnectionPolicy());
        this.withDefaultCertificate(instance.getDefaultCertificate());
        this.withDomain(instance.getDomain());
        this.withEndpointPublishingStrategy(instance.getEndpointPublishingStrategy());
        this.withHttpCompression(instance.getHttpCompression());
        this.withHttpEmptyRequestsPolicy(instance.getHttpEmptyRequestsPolicy());
        this.withHttpErrorCodePages(instance.getHttpErrorCodePages());
        this.withHttpHeaders(instance.getHttpHeaders());
        this.withIdleConnectionTerminationPolicy(instance.getIdleConnectionTerminationPolicy());
        this.withLogging(instance.getLogging());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withNodePlacement(instance.getNodePlacement());
        this.withReplicas(instance.getReplicas());
        this.withRouteAdmission(instance.getRouteAdmission());
        this.withRouteSelector(instance.getRouteSelector());
        this.withTlsSecurityProfile(instance.getTlsSecurityProfile());
        this.withTuningOptions(instance.getTuningOptions());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientTLSNested<A> editClientTLS() {
    return this.withNewClientTLSLike(Optional.ofNullable(this.buildClientTLS()).orElse(null));
  }
  
  public DefaultCertificateNested<A> editDefaultCertificate() {
    return this.withNewDefaultCertificateLike(Optional.ofNullable(this.buildDefaultCertificate()).orElse(null));
  }
  
  public EndpointPublishingStrategyNested<A> editEndpointPublishingStrategy() {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(null));
  }
  
  public HttpCompressionNested<A> editHttpCompression() {
    return this.withNewHttpCompressionLike(Optional.ofNullable(this.buildHttpCompression()).orElse(null));
  }
  
  public HttpHeadersNested<A> editHttpHeaders() {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(null));
  }
  
  public LoggingNested<A> editLogging() {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public NodePlacementNested<A> editNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(null));
  }
  
  public ClientTLSNested<A> editOrNewClientTLS() {
    return this.withNewClientTLSLike(Optional.ofNullable(this.buildClientTLS()).orElse(new ClientTLSBuilder().build()));
  }
  
  public ClientTLSNested<A> editOrNewClientTLSLike(ClientTLS item) {
    return this.withNewClientTLSLike(Optional.ofNullable(this.buildClientTLS()).orElse(item));
  }
  
  public DefaultCertificateNested<A> editOrNewDefaultCertificate() {
    return this.withNewDefaultCertificateLike(Optional.ofNullable(this.buildDefaultCertificate()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public DefaultCertificateNested<A> editOrNewDefaultCertificateLike(LocalObjectReference item) {
    return this.withNewDefaultCertificateLike(Optional.ofNullable(this.buildDefaultCertificate()).orElse(item));
  }
  
  public EndpointPublishingStrategyNested<A> editOrNewEndpointPublishingStrategy() {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(new EndpointPublishingStrategyBuilder().build()));
  }
  
  public EndpointPublishingStrategyNested<A> editOrNewEndpointPublishingStrategyLike(EndpointPublishingStrategy item) {
    return this.withNewEndpointPublishingStrategyLike(Optional.ofNullable(this.buildEndpointPublishingStrategy()).orElse(item));
  }
  
  public HttpCompressionNested<A> editOrNewHttpCompression() {
    return this.withNewHttpCompressionLike(Optional.ofNullable(this.buildHttpCompression()).orElse(new HTTPCompressionPolicyBuilder().build()));
  }
  
  public HttpCompressionNested<A> editOrNewHttpCompressionLike(HTTPCompressionPolicy item) {
    return this.withNewHttpCompressionLike(Optional.ofNullable(this.buildHttpCompression()).orElse(item));
  }
  
  public HttpHeadersNested<A> editOrNewHttpHeaders() {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(new IngressControllerHTTPHeadersBuilder().build()));
  }
  
  public HttpHeadersNested<A> editOrNewHttpHeadersLike(IngressControllerHTTPHeaders item) {
    return this.withNewHttpHeadersLike(Optional.ofNullable(this.buildHttpHeaders()).orElse(item));
  }
  
  public LoggingNested<A> editOrNewLogging() {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(new IngressControllerLoggingBuilder().build()));
  }
  
  public LoggingNested<A> editOrNewLoggingLike(IngressControllerLogging item) {
    return this.withNewLoggingLike(Optional.ofNullable(this.buildLogging()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(new NodePlacementBuilder().build()));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacementLike(NodePlacement item) {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(item));
  }
  
  public RouteAdmissionNested<A> editOrNewRouteAdmission() {
    return this.withNewRouteAdmissionLike(Optional.ofNullable(this.buildRouteAdmission()).orElse(new RouteAdmissionPolicyBuilder().build()));
  }
  
  public RouteAdmissionNested<A> editOrNewRouteAdmissionLike(RouteAdmissionPolicy item) {
    return this.withNewRouteAdmissionLike(Optional.ofNullable(this.buildRouteAdmission()).orElse(item));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelectorLike(LabelSelector item) {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(item));
  }
  
  public TuningOptionsNested<A> editOrNewTuningOptions() {
    return this.withNewTuningOptionsLike(Optional.ofNullable(this.buildTuningOptions()).orElse(new IngressControllerTuningOptionsBuilder().build()));
  }
  
  public TuningOptionsNested<A> editOrNewTuningOptionsLike(IngressControllerTuningOptions item) {
    return this.withNewTuningOptionsLike(Optional.ofNullable(this.buildTuningOptions()).orElse(item));
  }
  
  public RouteAdmissionNested<A> editRouteAdmission() {
    return this.withNewRouteAdmissionLike(Optional.ofNullable(this.buildRouteAdmission()).orElse(null));
  }
  
  public RouteSelectorNested<A> editRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(null));
  }
  
  public TuningOptionsNested<A> editTuningOptions() {
    return this.withNewTuningOptionsLike(Optional.ofNullable(this.buildTuningOptions()).orElse(null));
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
    IngressControllerSpecFluent that = (IngressControllerSpecFluent) o;
    if (!(Objects.equals(clientTLS, that.clientTLS))) {
      return false;
    }
    if (!(Objects.equals(closedClientConnectionPolicy, that.closedClientConnectionPolicy))) {
      return false;
    }
    if (!(Objects.equals(defaultCertificate, that.defaultCertificate))) {
      return false;
    }
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(endpointPublishingStrategy, that.endpointPublishingStrategy))) {
      return false;
    }
    if (!(Objects.equals(httpCompression, that.httpCompression))) {
      return false;
    }
    if (!(Objects.equals(httpEmptyRequestsPolicy, that.httpEmptyRequestsPolicy))) {
      return false;
    }
    if (!(Objects.equals(httpErrorCodePages, that.httpErrorCodePages))) {
      return false;
    }
    if (!(Objects.equals(httpHeaders, that.httpHeaders))) {
      return false;
    }
    if (!(Objects.equals(idleConnectionTerminationPolicy, that.idleConnectionTerminationPolicy))) {
      return false;
    }
    if (!(Objects.equals(logging, that.logging))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(nodePlacement, that.nodePlacement))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(routeAdmission, that.routeAdmission))) {
      return false;
    }
    if (!(Objects.equals(routeSelector, that.routeSelector))) {
      return false;
    }
    if (!(Objects.equals(tlsSecurityProfile, that.tlsSecurityProfile))) {
      return false;
    }
    if (!(Objects.equals(tuningOptions, that.tuningOptions))) {
      return false;
    }
    if (!(Objects.equals(unsupportedConfigOverrides, that.unsupportedConfigOverrides))) {
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
  
  public String getClosedClientConnectionPolicy() {
    return this.closedClientConnectionPolicy;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public String getHttpEmptyRequestsPolicy() {
    return this.httpEmptyRequestsPolicy;
  }
  
  public ConfigMapNameReference getHttpErrorCodePages() {
    return this.httpErrorCodePages;
  }
  
  public String getIdleConnectionTerminationPolicy() {
    return this.idleConnectionTerminationPolicy;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public TLSSecurityProfile getTlsSecurityProfile() {
    return this.tlsSecurityProfile;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientTLS() {
    return this.clientTLS != null;
  }
  
  public boolean hasClosedClientConnectionPolicy() {
    return this.closedClientConnectionPolicy != null;
  }
  
  public boolean hasDefaultCertificate() {
    return this.defaultCertificate != null;
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasEndpointPublishingStrategy() {
    return this.endpointPublishingStrategy != null;
  }
  
  public boolean hasHttpCompression() {
    return this.httpCompression != null;
  }
  
  public boolean hasHttpEmptyRequestsPolicy() {
    return this.httpEmptyRequestsPolicy != null;
  }
  
  public boolean hasHttpErrorCodePages() {
    return this.httpErrorCodePages != null;
  }
  
  public boolean hasHttpHeaders() {
    return this.httpHeaders != null;
  }
  
  public boolean hasIdleConnectionTerminationPolicy() {
    return this.idleConnectionTerminationPolicy != null;
  }
  
  public boolean hasLogging() {
    return this.logging != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasNodePlacement() {
    return this.nodePlacement != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasRouteAdmission() {
    return this.routeAdmission != null;
  }
  
  public boolean hasRouteSelector() {
    return this.routeSelector != null;
  }
  
  public boolean hasTlsSecurityProfile() {
    return this.tlsSecurityProfile != null;
  }
  
  public boolean hasTuningOptions() {
    return this.tuningOptions != null;
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientTLS, closedClientConnectionPolicy, defaultCertificate, domain, endpointPublishingStrategy, httpCompression, httpEmptyRequestsPolicy, httpErrorCodePages, httpHeaders, idleConnectionTerminationPolicy, logging, namespaceSelector, nodePlacement, replicas, routeAdmission, routeSelector, tlsSecurityProfile, tuningOptions, unsupportedConfigOverrides, additionalProperties);
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
    if (!(clientTLS == null)) {
        sb.append("clientTLS:");
        sb.append(clientTLS);
        sb.append(",");
    }
    if (!(closedClientConnectionPolicy == null)) {
        sb.append("closedClientConnectionPolicy:");
        sb.append(closedClientConnectionPolicy);
        sb.append(",");
    }
    if (!(defaultCertificate == null)) {
        sb.append("defaultCertificate:");
        sb.append(defaultCertificate);
        sb.append(",");
    }
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(endpointPublishingStrategy == null)) {
        sb.append("endpointPublishingStrategy:");
        sb.append(endpointPublishingStrategy);
        sb.append(",");
    }
    if (!(httpCompression == null)) {
        sb.append("httpCompression:");
        sb.append(httpCompression);
        sb.append(",");
    }
    if (!(httpEmptyRequestsPolicy == null)) {
        sb.append("httpEmptyRequestsPolicy:");
        sb.append(httpEmptyRequestsPolicy);
        sb.append(",");
    }
    if (!(httpErrorCodePages == null)) {
        sb.append("httpErrorCodePages:");
        sb.append(httpErrorCodePages);
        sb.append(",");
    }
    if (!(httpHeaders == null)) {
        sb.append("httpHeaders:");
        sb.append(httpHeaders);
        sb.append(",");
    }
    if (!(idleConnectionTerminationPolicy == null)) {
        sb.append("idleConnectionTerminationPolicy:");
        sb.append(idleConnectionTerminationPolicy);
        sb.append(",");
    }
    if (!(logging == null)) {
        sb.append("logging:");
        sb.append(logging);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(nodePlacement == null)) {
        sb.append("nodePlacement:");
        sb.append(nodePlacement);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(routeAdmission == null)) {
        sb.append("routeAdmission:");
        sb.append(routeAdmission);
        sb.append(",");
    }
    if (!(routeSelector == null)) {
        sb.append("routeSelector:");
        sb.append(routeSelector);
        sb.append(",");
    }
    if (!(tlsSecurityProfile == null)) {
        sb.append("tlsSecurityProfile:");
        sb.append(tlsSecurityProfile);
        sb.append(",");
    }
    if (!(tuningOptions == null)) {
        sb.append("tuningOptions:");
        sb.append(tuningOptions);
        sb.append(",");
    }
    if (!(unsupportedConfigOverrides == null)) {
        sb.append("unsupportedConfigOverrides:");
        sb.append(unsupportedConfigOverrides);
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
  
  public A withClientTLS(ClientTLS clientTLS) {
    this._visitables.remove("clientTLS");
    if (clientTLS != null) {
        this.clientTLS = new ClientTLSBuilder(clientTLS);
        this._visitables.get("clientTLS").add(this.clientTLS);
    } else {
        this.clientTLS = null;
        this._visitables.get("clientTLS").remove(this.clientTLS);
    }
    return (A) this;
  }
  
  public A withClosedClientConnectionPolicy(String closedClientConnectionPolicy) {
    this.closedClientConnectionPolicy = closedClientConnectionPolicy;
    return (A) this;
  }
  
  public A withDefaultCertificate(LocalObjectReference defaultCertificate) {
    this._visitables.remove("defaultCertificate");
    if (defaultCertificate != null) {
        this.defaultCertificate = new LocalObjectReferenceBuilder(defaultCertificate);
        this._visitables.get("defaultCertificate").add(this.defaultCertificate);
    } else {
        this.defaultCertificate = null;
        this._visitables.get("defaultCertificate").remove(this.defaultCertificate);
    }
    return (A) this;
  }
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withEndpointPublishingStrategy(EndpointPublishingStrategy endpointPublishingStrategy) {
    this._visitables.remove("endpointPublishingStrategy");
    if (endpointPublishingStrategy != null) {
        this.endpointPublishingStrategy = new EndpointPublishingStrategyBuilder(endpointPublishingStrategy);
        this._visitables.get("endpointPublishingStrategy").add(this.endpointPublishingStrategy);
    } else {
        this.endpointPublishingStrategy = null;
        this._visitables.get("endpointPublishingStrategy").remove(this.endpointPublishingStrategy);
    }
    return (A) this;
  }
  
  public A withHttpCompression(HTTPCompressionPolicy httpCompression) {
    this._visitables.remove("httpCompression");
    if (httpCompression != null) {
        this.httpCompression = new HTTPCompressionPolicyBuilder(httpCompression);
        this._visitables.get("httpCompression").add(this.httpCompression);
    } else {
        this.httpCompression = null;
        this._visitables.get("httpCompression").remove(this.httpCompression);
    }
    return (A) this;
  }
  
  public A withHttpEmptyRequestsPolicy(String httpEmptyRequestsPolicy) {
    this.httpEmptyRequestsPolicy = httpEmptyRequestsPolicy;
    return (A) this;
  }
  
  public A withHttpErrorCodePages(ConfigMapNameReference httpErrorCodePages) {
    this.httpErrorCodePages = httpErrorCodePages;
    return (A) this;
  }
  
  public A withHttpHeaders(IngressControllerHTTPHeaders httpHeaders) {
    this._visitables.remove("httpHeaders");
    if (httpHeaders != null) {
        this.httpHeaders = new IngressControllerHTTPHeadersBuilder(httpHeaders);
        this._visitables.get("httpHeaders").add(this.httpHeaders);
    } else {
        this.httpHeaders = null;
        this._visitables.get("httpHeaders").remove(this.httpHeaders);
    }
    return (A) this;
  }
  
  public A withIdleConnectionTerminationPolicy(String idleConnectionTerminationPolicy) {
    this.idleConnectionTerminationPolicy = idleConnectionTerminationPolicy;
    return (A) this;
  }
  
  public A withLogging(IngressControllerLogging logging) {
    this._visitables.remove("logging");
    if (logging != null) {
        this.logging = new IngressControllerLoggingBuilder(logging);
        this._visitables.get("logging").add(this.logging);
    } else {
        this.logging = null;
        this._visitables.get("logging").remove(this.logging);
    }
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public ClientTLSNested<A> withNewClientTLS() {
    return new ClientTLSNested(null);
  }
  
  public ClientTLSNested<A> withNewClientTLSLike(ClientTLS item) {
    return new ClientTLSNested(item);
  }
  
  public DefaultCertificateNested<A> withNewDefaultCertificate() {
    return new DefaultCertificateNested(null);
  }
  
  public A withNewDefaultCertificate(String name) {
    return (A) this.withDefaultCertificate(new LocalObjectReference(name));
  }
  
  public DefaultCertificateNested<A> withNewDefaultCertificateLike(LocalObjectReference item) {
    return new DefaultCertificateNested(item);
  }
  
  public EndpointPublishingStrategyNested<A> withNewEndpointPublishingStrategy() {
    return new EndpointPublishingStrategyNested(null);
  }
  
  public EndpointPublishingStrategyNested<A> withNewEndpointPublishingStrategyLike(EndpointPublishingStrategy item) {
    return new EndpointPublishingStrategyNested(item);
  }
  
  public HttpCompressionNested<A> withNewHttpCompression() {
    return new HttpCompressionNested(null);
  }
  
  public HttpCompressionNested<A> withNewHttpCompressionLike(HTTPCompressionPolicy item) {
    return new HttpCompressionNested(item);
  }
  
  public A withNewHttpErrorCodePages(String name) {
    return (A) this.withHttpErrorCodePages(new ConfigMapNameReference(name));
  }
  
  public HttpHeadersNested<A> withNewHttpHeaders() {
    return new HttpHeadersNested(null);
  }
  
  public HttpHeadersNested<A> withNewHttpHeadersLike(IngressControllerHTTPHeaders item) {
    return new HttpHeadersNested(item);
  }
  
  public LoggingNested<A> withNewLogging() {
    return new LoggingNested(null);
  }
  
  public LoggingNested<A> withNewLoggingLike(IngressControllerLogging item) {
    return new LoggingNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public NodePlacementNested<A> withNewNodePlacement() {
    return new NodePlacementNested(null);
  }
  
  public NodePlacementNested<A> withNewNodePlacementLike(NodePlacement item) {
    return new NodePlacementNested(item);
  }
  
  public RouteAdmissionNested<A> withNewRouteAdmission() {
    return new RouteAdmissionNested(null);
  }
  
  public A withNewRouteAdmission(String namespaceOwnership,String wildcardPolicy) {
    return (A) this.withRouteAdmission(new RouteAdmissionPolicy(namespaceOwnership, wildcardPolicy));
  }
  
  public RouteAdmissionNested<A> withNewRouteAdmissionLike(RouteAdmissionPolicy item) {
    return new RouteAdmissionNested(item);
  }
  
  public RouteSelectorNested<A> withNewRouteSelector() {
    return new RouteSelectorNested(null);
  }
  
  public RouteSelectorNested<A> withNewRouteSelectorLike(LabelSelector item) {
    return new RouteSelectorNested(item);
  }
  
  public TuningOptionsNested<A> withNewTuningOptions() {
    return new TuningOptionsNested(null);
  }
  
  public TuningOptionsNested<A> withNewTuningOptionsLike(IngressControllerTuningOptions item) {
    return new TuningOptionsNested(item);
  }
  
  public A withNodePlacement(NodePlacement nodePlacement) {
    this._visitables.remove("nodePlacement");
    if (nodePlacement != null) {
        this.nodePlacement = new NodePlacementBuilder(nodePlacement);
        this._visitables.get("nodePlacement").add(this.nodePlacement);
    } else {
        this.nodePlacement = null;
        this._visitables.get("nodePlacement").remove(this.nodePlacement);
    }
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withRouteAdmission(RouteAdmissionPolicy routeAdmission) {
    this._visitables.remove("routeAdmission");
    if (routeAdmission != null) {
        this.routeAdmission = new RouteAdmissionPolicyBuilder(routeAdmission);
        this._visitables.get("routeAdmission").add(this.routeAdmission);
    } else {
        this.routeAdmission = null;
        this._visitables.get("routeAdmission").remove(this.routeAdmission);
    }
    return (A) this;
  }
  
  public A withRouteSelector(LabelSelector routeSelector) {
    this._visitables.remove("routeSelector");
    if (routeSelector != null) {
        this.routeSelector = new LabelSelectorBuilder(routeSelector);
        this._visitables.get("routeSelector").add(this.routeSelector);
    } else {
        this.routeSelector = null;
        this._visitables.get("routeSelector").remove(this.routeSelector);
    }
    return (A) this;
  }
  
  public A withTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
    this.tlsSecurityProfile = tlsSecurityProfile;
    return (A) this;
  }
  
  public A withTuningOptions(IngressControllerTuningOptions tuningOptions) {
    this._visitables.remove("tuningOptions");
    if (tuningOptions != null) {
        this.tuningOptions = new IngressControllerTuningOptionsBuilder(tuningOptions);
        this._visitables.get("tuningOptions").add(this.tuningOptions);
    } else {
        this.tuningOptions = null;
        this._visitables.get("tuningOptions").remove(this.tuningOptions);
    }
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  public class ClientTLSNested<N> extends ClientTLSFluent<ClientTLSNested<N>> implements Nested<N>{
  
    ClientTLSBuilder builder;
  
    ClientTLSNested(ClientTLS item) {
      this.builder = new ClientTLSBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withClientTLS(builder.build());
    }
    
    public N endClientTLS() {
      return and();
    }
    
  }
  public class DefaultCertificateNested<N> extends LocalObjectReferenceFluent<DefaultCertificateNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    DefaultCertificateNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withDefaultCertificate(builder.build());
    }
    
    public N endDefaultCertificate() {
      return and();
    }
    
  }
  public class EndpointPublishingStrategyNested<N> extends EndpointPublishingStrategyFluent<EndpointPublishingStrategyNested<N>> implements Nested<N>{
  
    EndpointPublishingStrategyBuilder builder;
  
    EndpointPublishingStrategyNested(EndpointPublishingStrategy item) {
      this.builder = new EndpointPublishingStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withEndpointPublishingStrategy(builder.build());
    }
    
    public N endEndpointPublishingStrategy() {
      return and();
    }
    
  }
  public class HttpCompressionNested<N> extends HTTPCompressionPolicyFluent<HttpCompressionNested<N>> implements Nested<N>{
  
    HTTPCompressionPolicyBuilder builder;
  
    HttpCompressionNested(HTTPCompressionPolicy item) {
      this.builder = new HTTPCompressionPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withHttpCompression(builder.build());
    }
    
    public N endHttpCompression() {
      return and();
    }
    
  }
  public class HttpHeadersNested<N> extends IngressControllerHTTPHeadersFluent<HttpHeadersNested<N>> implements Nested<N>{
  
    IngressControllerHTTPHeadersBuilder builder;
  
    HttpHeadersNested(IngressControllerHTTPHeaders item) {
      this.builder = new IngressControllerHTTPHeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withHttpHeaders(builder.build());
    }
    
    public N endHttpHeaders() {
      return and();
    }
    
  }
  public class LoggingNested<N> extends IngressControllerLoggingFluent<LoggingNested<N>> implements Nested<N>{
  
    IngressControllerLoggingBuilder builder;
  
    LoggingNested(IngressControllerLogging item) {
      this.builder = new IngressControllerLoggingBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withLogging(builder.build());
    }
    
    public N endLogging() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class NodePlacementNested<N> extends NodePlacementFluent<NodePlacementNested<N>> implements Nested<N>{
  
    NodePlacementBuilder builder;
  
    NodePlacementNested(NodePlacement item) {
      this.builder = new NodePlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withNodePlacement(builder.build());
    }
    
    public N endNodePlacement() {
      return and();
    }
    
  }
  public class RouteAdmissionNested<N> extends RouteAdmissionPolicyFluent<RouteAdmissionNested<N>> implements Nested<N>{
  
    RouteAdmissionPolicyBuilder builder;
  
    RouteAdmissionNested(RouteAdmissionPolicy item) {
      this.builder = new RouteAdmissionPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withRouteAdmission(builder.build());
    }
    
    public N endRouteAdmission() {
      return and();
    }
    
  }
  public class RouteSelectorNested<N> extends LabelSelectorFluent<RouteSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    RouteSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withRouteSelector(builder.build());
    }
    
    public N endRouteSelector() {
      return and();
    }
    
  }
  public class TuningOptionsNested<N> extends IngressControllerTuningOptionsFluent<TuningOptionsNested<N>> implements Nested<N>{
  
    IngressControllerTuningOptionsBuilder builder;
  
    TuningOptionsNested(IngressControllerTuningOptions item) {
      this.builder = new IngressControllerTuningOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) IngressControllerSpecFluent.this.withTuningOptions(builder.build());
    }
    
    public N endTuningOptions() {
      return and();
    }
    
  }
}