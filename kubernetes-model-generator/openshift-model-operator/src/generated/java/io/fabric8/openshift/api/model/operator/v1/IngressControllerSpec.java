
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IngressControllerSpec is the specification of the desired behavior of the IngressController.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientTLS",
    "closedClientConnectionPolicy",
    "defaultCertificate",
    "domain",
    "endpointPublishingStrategy",
    "httpCompression",
    "httpEmptyRequestsPolicy",
    "httpErrorCodePages",
    "httpHeaders",
    "idleConnectionTerminationPolicy",
    "logging",
    "namespaceSelector",
    "nodePlacement",
    "replicas",
    "routeAdmission",
    "routeSelector",
    "tlsSecurityProfile",
    "tuningOptions",
    "unsupportedConfigOverrides"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IngressControllerSpec implements Editable<IngressControllerSpecBuilder>, KubernetesResource
{

    @JsonProperty("clientTLS")
    private ClientTLS clientTLS;
    @JsonProperty("closedClientConnectionPolicy")
    private String closedClientConnectionPolicy;
    @JsonProperty("defaultCertificate")
    private LocalObjectReference defaultCertificate;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private EndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("httpCompression")
    private HTTPCompressionPolicy httpCompression;
    @JsonProperty("httpEmptyRequestsPolicy")
    private String httpEmptyRequestsPolicy;
    @JsonProperty("httpErrorCodePages")
    private ConfigMapNameReference httpErrorCodePages;
    @JsonProperty("httpHeaders")
    private IngressControllerHTTPHeaders httpHeaders;
    @JsonProperty("idleConnectionTerminationPolicy")
    private String idleConnectionTerminationPolicy;
    @JsonProperty("logging")
    private IngressControllerLogging logging;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("routeAdmission")
    private RouteAdmissionPolicy routeAdmission;
    @JsonProperty("routeSelector")
    private LabelSelector routeSelector;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonProperty("tuningOptions")
    private IngressControllerTuningOptions tuningOptions;
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerSpec() {
    }

    public IngressControllerSpec(ClientTLS clientTLS, String closedClientConnectionPolicy, LocalObjectReference defaultCertificate, String domain, EndpointPublishingStrategy endpointPublishingStrategy, HTTPCompressionPolicy httpCompression, String httpEmptyRequestsPolicy, ConfigMapNameReference httpErrorCodePages, IngressControllerHTTPHeaders httpHeaders, String idleConnectionTerminationPolicy, IngressControllerLogging logging, LabelSelector namespaceSelector, NodePlacement nodePlacement, Integer replicas, RouteAdmissionPolicy routeAdmission, LabelSelector routeSelector, TLSSecurityProfile tlsSecurityProfile, IngressControllerTuningOptions tuningOptions, Object unsupportedConfigOverrides) {
        super();
        this.clientTLS = clientTLS;
        this.closedClientConnectionPolicy = closedClientConnectionPolicy;
        this.defaultCertificate = defaultCertificate;
        this.domain = domain;
        this.endpointPublishingStrategy = endpointPublishingStrategy;
        this.httpCompression = httpCompression;
        this.httpEmptyRequestsPolicy = httpEmptyRequestsPolicy;
        this.httpErrorCodePages = httpErrorCodePages;
        this.httpHeaders = httpHeaders;
        this.idleConnectionTerminationPolicy = idleConnectionTerminationPolicy;
        this.logging = logging;
        this.namespaceSelector = namespaceSelector;
        this.nodePlacement = nodePlacement;
        this.replicas = replicas;
        this.routeAdmission = routeAdmission;
        this.routeSelector = routeSelector;
        this.tlsSecurityProfile = tlsSecurityProfile;
        this.tuningOptions = tuningOptions;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("clientTLS")
    public ClientTLS getClientTLS() {
        return clientTLS;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("clientTLS")
    public void setClientTLS(ClientTLS clientTLS) {
        this.clientTLS = clientTLS;
    }

    /**
     * closedClientConnectionPolicy controls how the IngressController behaves when the client closes the TCP connection while the TLS handshake or HTTP request is in progress. This option maps directly to HAProxy’s "abortonclose" option.<br><p> <br><p> Valid values are: "Abort" and "Continue". The default value is "Continue".<br><p> <br><p> When set to "Abort", the router will stop processing the TLS handshake if it is in progress, and it will not send an HTTP request to the backend server if the request has not yet been sent when the client closes the connection.<br><p> <br><p> When set to "Continue", the router will complete the TLS handshake if it is in progress, or send an HTTP request to the backend server and wait for the backend server's response, regardless of whether the client has closed the connection.<br><p> <br><p> Setting "Abort" can help free CPU resources otherwise spent on TLS computation for connections the client has already closed, and can reduce request queue size, thereby reducing the load on saturated backend servers.<br><p> <br><p> Important Considerations:<br><p> <br><p>   - The default policy ("Continue") is HTTP-compliant, and requests<br><p>     for aborted client connections will still be served.<br><p>     Use the "Continue" policy to allow a client to send a request<br><p>     and then immediately close its side of the connection while<br><p>     still receiving a response on the half-closed connection.<br><p> <br><p>   - When clients use keep-alive connections, the most common case for premature<br><p>     closure is when the user wants to cancel the transfer or when a timeout<br><p>     occurs. In that case, the "Abort" policy may be used to reduce resource consumption.<br><p> <br><p>   - Using RSA keys larger than 2048 bits can significantly slow down<br><p>     TLS computations. Consider using the "Abort" policy to reduce CPU usage.
     */
    @JsonProperty("closedClientConnectionPolicy")
    public String getClosedClientConnectionPolicy() {
        return closedClientConnectionPolicy;
    }

    /**
     * closedClientConnectionPolicy controls how the IngressController behaves when the client closes the TCP connection while the TLS handshake or HTTP request is in progress. This option maps directly to HAProxy’s "abortonclose" option.<br><p> <br><p> Valid values are: "Abort" and "Continue". The default value is "Continue".<br><p> <br><p> When set to "Abort", the router will stop processing the TLS handshake if it is in progress, and it will not send an HTTP request to the backend server if the request has not yet been sent when the client closes the connection.<br><p> <br><p> When set to "Continue", the router will complete the TLS handshake if it is in progress, or send an HTTP request to the backend server and wait for the backend server's response, regardless of whether the client has closed the connection.<br><p> <br><p> Setting "Abort" can help free CPU resources otherwise spent on TLS computation for connections the client has already closed, and can reduce request queue size, thereby reducing the load on saturated backend servers.<br><p> <br><p> Important Considerations:<br><p> <br><p>   - The default policy ("Continue") is HTTP-compliant, and requests<br><p>     for aborted client connections will still be served.<br><p>     Use the "Continue" policy to allow a client to send a request<br><p>     and then immediately close its side of the connection while<br><p>     still receiving a response on the half-closed connection.<br><p> <br><p>   - When clients use keep-alive connections, the most common case for premature<br><p>     closure is when the user wants to cancel the transfer or when a timeout<br><p>     occurs. In that case, the "Abort" policy may be used to reduce resource consumption.<br><p> <br><p>   - Using RSA keys larger than 2048 bits can significantly slow down<br><p>     TLS computations. Consider using the "Abort" policy to reduce CPU usage.
     */
    @JsonProperty("closedClientConnectionPolicy")
    public void setClosedClientConnectionPolicy(String closedClientConnectionPolicy) {
        this.closedClientConnectionPolicy = closedClientConnectionPolicy;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("defaultCertificate")
    public LocalObjectReference getDefaultCertificate() {
        return defaultCertificate;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("defaultCertificate")
    public void setDefaultCertificate(LocalObjectReference defaultCertificate) {
        this.defaultCertificate = defaultCertificate;
    }

    /**
     * domain is a DNS name serviced by the ingress controller and is used to configure multiple features:<br><p> <br><p> &#42; For the LoadBalancerService endpoint publishing strategy, domain is<br><p>   used to configure DNS records. See endpointPublishingStrategy.<br><p> <br><p> &#42; When using a generated default certificate, the certificate will be valid<br><p>   for domain and its subdomains. See defaultCertificate.<br><p> <br><p> &#42; The value is published to individual Route statuses so that end-users<br><p>   know where to target external DNS records.<br><p> <br><p> domain must be unique among all IngressControllers, and cannot be updated.<br><p> <br><p> If empty, defaults to ingress.config.openshift.io/cluster .spec.domain.
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * domain is a DNS name serviced by the ingress controller and is used to configure multiple features:<br><p> <br><p> &#42; For the LoadBalancerService endpoint publishing strategy, domain is<br><p>   used to configure DNS records. See endpointPublishingStrategy.<br><p> <br><p> &#42; When using a generated default certificate, the certificate will be valid<br><p>   for domain and its subdomains. See defaultCertificate.<br><p> <br><p> &#42; The value is published to individual Route statuses so that end-users<br><p>   know where to target external DNS records.<br><p> <br><p> domain must be unique among all IngressControllers, and cannot be updated.<br><p> <br><p> If empty, defaults to ingress.config.openshift.io/cluster .spec.domain.
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("endpointPublishingStrategy")
    public EndpointPublishingStrategy getEndpointPublishingStrategy() {
        return endpointPublishingStrategy;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("endpointPublishingStrategy")
    public void setEndpointPublishingStrategy(EndpointPublishingStrategy endpointPublishingStrategy) {
        this.endpointPublishingStrategy = endpointPublishingStrategy;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpCompression")
    public HTTPCompressionPolicy getHttpCompression() {
        return httpCompression;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpCompression")
    public void setHttpCompression(HTTPCompressionPolicy httpCompression) {
        this.httpCompression = httpCompression;
    }

    /**
     * httpEmptyRequestsPolicy describes how HTTP connections should be handled if the connection times out before a request is received. Allowed values for this field are "Respond" and "Ignore".  If the field is set to "Respond", the ingress controller sends an HTTP 400 or 408 response, logs the connection (if access logging is enabled), and counts the connection in the appropriate metrics.  If the field is set to "Ignore", the ingress controller closes the connection without sending a response, logging the connection, or incrementing metrics.  The default value is "Respond".<br><p> <br><p> Typically, these connections come from load balancers' health probes or Web browsers' speculative connections ("preconnect") and can be safely ignored.  However, these requests may also be caused by network errors, and so setting this field to "Ignore" may impede detection and diagnosis of problems.  In addition, these requests may be caused by port scans, in which case logging empty requests may aid in detecting intrusion attempts.
     */
    @JsonProperty("httpEmptyRequestsPolicy")
    public String getHttpEmptyRequestsPolicy() {
        return httpEmptyRequestsPolicy;
    }

    /**
     * httpEmptyRequestsPolicy describes how HTTP connections should be handled if the connection times out before a request is received. Allowed values for this field are "Respond" and "Ignore".  If the field is set to "Respond", the ingress controller sends an HTTP 400 or 408 response, logs the connection (if access logging is enabled), and counts the connection in the appropriate metrics.  If the field is set to "Ignore", the ingress controller closes the connection without sending a response, logging the connection, or incrementing metrics.  The default value is "Respond".<br><p> <br><p> Typically, these connections come from load balancers' health probes or Web browsers' speculative connections ("preconnect") and can be safely ignored.  However, these requests may also be caused by network errors, and so setting this field to "Ignore" may impede detection and diagnosis of problems.  In addition, these requests may be caused by port scans, in which case logging empty requests may aid in detecting intrusion attempts.
     */
    @JsonProperty("httpEmptyRequestsPolicy")
    public void setHttpEmptyRequestsPolicy(String httpEmptyRequestsPolicy) {
        this.httpEmptyRequestsPolicy = httpEmptyRequestsPolicy;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpErrorCodePages")
    public ConfigMapNameReference getHttpErrorCodePages() {
        return httpErrorCodePages;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpErrorCodePages")
    public void setHttpErrorCodePages(ConfigMapNameReference httpErrorCodePages) {
        this.httpErrorCodePages = httpErrorCodePages;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpHeaders")
    public IngressControllerHTTPHeaders getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("httpHeaders")
    public void setHttpHeaders(IngressControllerHTTPHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    /**
     * idleConnectionTerminationPolicy maps directly to HAProxy's idle-close-on-response option and controls whether HAProxy keeps idle frontend connections open during a soft stop (router reload).<br><p> <br><p> Allowed values for this field are "Immediate" and "Deferred". The default value is "Immediate".<br><p> <br><p> When set to "Immediate", idle connections are closed immediately during router reloads. This ensures immediate propagation of route changes but may impact clients sensitive to connection resets.<br><p> <br><p> When set to "Deferred", HAProxy will maintain idle connections during a soft reload instead of closing them immediately. These connections remain open until any of the following occurs:<br><p> <br><p>   - A new request is received on the connection, in which<br><p>     case HAProxy handles it in the old process and closes<br><p>     the connection after sending the response.<br><p> <br><p>   - HAProxy's `timeout http-keep-alive` duration expires.<br><p>     By default this is 300 seconds, but it can be changed<br><p>     using httpKeepAliveTimeout tuning option.<br><p> <br><p>   - The client's keep-alive timeout expires, causing the<br><p>     client to close the connection.<br><p> <br><p> Setting Deferred can help prevent errors in clients or load balancers that do not properly handle connection resets. Additionally, this option allows you to retain the pre-2.4 HAProxy behaviour: in HAProxy version 2.2 (OpenShift versions &lt; 4.14), maintaining idle connections during a soft reload was the default behaviour, but starting with HAProxy 2.4, the default changed to closing idle connections immediately.<br><p> <br><p> Important Consideration:<br><p> <br><p>   - Using Deferred will result in temporary inconsistencies<br><p>     for the first request on each persistent connection<br><p>     after a route update and router reload. This request<br><p>     will be processed by the old HAProxy process using its<br><p>     old configuration. Subsequent requests will use the<br><p>     updated configuration.<br><p> <br><p> Operational Considerations:<br><p> <br><p>   - Keeping idle connections open during reloads may lead<br><p>     to an accumulation of old HAProxy processes if<br><p>     connections remain idle for extended periods,<br><p>     especially in environments where frequent reloads<br><p>     occur.<br><p> <br><p>   - Consider monitoring the number of HAProxy processes in<br><p>     the router pods when Deferred is set.<br><p> <br><p>   - You may need to enable or adjust the<br><p>     `ingress.operator.openshift.io/hard-stop-after`<br><p>     duration (configured via an annotation on the<br><p>     IngressController resource) in environments with<br><p>     frequent reloads to prevent resource exhaustion.
     */
    @JsonProperty("idleConnectionTerminationPolicy")
    public String getIdleConnectionTerminationPolicy() {
        return idleConnectionTerminationPolicy;
    }

    /**
     * idleConnectionTerminationPolicy maps directly to HAProxy's idle-close-on-response option and controls whether HAProxy keeps idle frontend connections open during a soft stop (router reload).<br><p> <br><p> Allowed values for this field are "Immediate" and "Deferred". The default value is "Immediate".<br><p> <br><p> When set to "Immediate", idle connections are closed immediately during router reloads. This ensures immediate propagation of route changes but may impact clients sensitive to connection resets.<br><p> <br><p> When set to "Deferred", HAProxy will maintain idle connections during a soft reload instead of closing them immediately. These connections remain open until any of the following occurs:<br><p> <br><p>   - A new request is received on the connection, in which<br><p>     case HAProxy handles it in the old process and closes<br><p>     the connection after sending the response.<br><p> <br><p>   - HAProxy's `timeout http-keep-alive` duration expires.<br><p>     By default this is 300 seconds, but it can be changed<br><p>     using httpKeepAliveTimeout tuning option.<br><p> <br><p>   - The client's keep-alive timeout expires, causing the<br><p>     client to close the connection.<br><p> <br><p> Setting Deferred can help prevent errors in clients or load balancers that do not properly handle connection resets. Additionally, this option allows you to retain the pre-2.4 HAProxy behaviour: in HAProxy version 2.2 (OpenShift versions &lt; 4.14), maintaining idle connections during a soft reload was the default behaviour, but starting with HAProxy 2.4, the default changed to closing idle connections immediately.<br><p> <br><p> Important Consideration:<br><p> <br><p>   - Using Deferred will result in temporary inconsistencies<br><p>     for the first request on each persistent connection<br><p>     after a route update and router reload. This request<br><p>     will be processed by the old HAProxy process using its<br><p>     old configuration. Subsequent requests will use the<br><p>     updated configuration.<br><p> <br><p> Operational Considerations:<br><p> <br><p>   - Keeping idle connections open during reloads may lead<br><p>     to an accumulation of old HAProxy processes if<br><p>     connections remain idle for extended periods,<br><p>     especially in environments where frequent reloads<br><p>     occur.<br><p> <br><p>   - Consider monitoring the number of HAProxy processes in<br><p>     the router pods when Deferred is set.<br><p> <br><p>   - You may need to enable or adjust the<br><p>     `ingress.operator.openshift.io/hard-stop-after`<br><p>     duration (configured via an annotation on the<br><p>     IngressController resource) in environments with<br><p>     frequent reloads to prevent resource exhaustion.
     */
    @JsonProperty("idleConnectionTerminationPolicy")
    public void setIdleConnectionTerminationPolicy(String idleConnectionTerminationPolicy) {
        this.idleConnectionTerminationPolicy = idleConnectionTerminationPolicy;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("logging")
    public IngressControllerLogging getLogging() {
        return logging;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("logging")
    public void setLogging(IngressControllerLogging logging) {
        this.logging = logging;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    /**
     * replicas is the desired number of ingress controller replicas. If unset, the default depends on the value of the defaultPlacement field in the cluster config.openshift.io/v1/ingresses status.<br><p> <br><p> The value of replicas is set based on the value of a chosen field in the Infrastructure CR. If defaultPlacement is set to ControlPlane, the chosen field will be controlPlaneTopology. If it is set to Workers the chosen field will be infrastructureTopology. Replicas will then be set to 1 or 2 based whether the chosen field's value is SingleReplica or HighlyAvailable, respectively.<br><p> <br><p> These defaults are subject to change.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas is the desired number of ingress controller replicas. If unset, the default depends on the value of the defaultPlacement field in the cluster config.openshift.io/v1/ingresses status.<br><p> <br><p> The value of replicas is set based on the value of a chosen field in the Infrastructure CR. If defaultPlacement is set to ControlPlane, the chosen field will be controlPlaneTopology. If it is set to Workers the chosen field will be infrastructureTopology. Replicas will then be set to 1 or 2 based whether the chosen field's value is SingleReplica or HighlyAvailable, respectively.<br><p> <br><p> These defaults are subject to change.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("routeAdmission")
    public RouteAdmissionPolicy getRouteAdmission() {
        return routeAdmission;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("routeAdmission")
    public void setRouteAdmission(RouteAdmissionPolicy routeAdmission) {
        this.routeAdmission = routeAdmission;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("routeSelector")
    public LabelSelector getRouteSelector() {
        return routeSelector;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("routeSelector")
    public void setRouteSelector(LabelSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("tuningOptions")
    public IngressControllerTuningOptions getTuningOptions() {
        return tuningOptions;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("tuningOptions")
    public void setTuningOptions(IngressControllerTuningOptions tuningOptions) {
        this.tuningOptions = tuningOptions;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    /**
     * IngressControllerSpec is the specification of the desired behavior of the IngressController.
     */
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public IngressControllerSpecBuilder edit() {
        return new IngressControllerSpecBuilder(this);
    }

    @JsonIgnore
    public IngressControllerSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
