
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * HTTPServingInfo holds configuration for serving HTTP
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindAddress",
    "bindNetwork",
    "certFile",
    "cipherSuites",
    "clientCA",
    "keyFile",
    "maxRequestsInFlight",
    "minTLSVersion",
    "namedCertificates",
    "requestTimeoutSeconds"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HTTPServingInfo implements Editable<HTTPServingInfoBuilder>, KubernetesResource
{

    @JsonProperty("bindAddress")
    private String bindAddress;
    @JsonProperty("bindNetwork")
    private String bindNetwork;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cipherSuites = new ArrayList<>();
    @JsonProperty("clientCA")
    private String clientCA;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("maxRequestsInFlight")
    private Long maxRequestsInFlight;
    @JsonProperty("minTLSVersion")
    private String minTLSVersion;
    @JsonProperty("namedCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedCertificate> namedCertificates = new ArrayList<>();
    @JsonProperty("requestTimeoutSeconds")
    private Long requestTimeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPServingInfo() {
    }

    public HTTPServingInfo(String bindAddress, String bindNetwork, String certFile, List<String> cipherSuites, String clientCA, String keyFile, Long maxRequestsInFlight, String minTLSVersion, List<NamedCertificate> namedCertificates, Long requestTimeoutSeconds) {
        super();
        this.bindAddress = bindAddress;
        this.bindNetwork = bindNetwork;
        this.certFile = certFile;
        this.cipherSuites = cipherSuites;
        this.clientCA = clientCA;
        this.keyFile = keyFile;
        this.maxRequestsInFlight = maxRequestsInFlight;
        this.minTLSVersion = minTLSVersion;
        this.namedCertificates = namedCertificates;
        this.requestTimeoutSeconds = requestTimeoutSeconds;
    }

    /**
     * bindAddress is the ip:port to serve on
     */
    @JsonProperty("bindAddress")
    public String getBindAddress() {
        return bindAddress;
    }

    /**
     * bindAddress is the ip:port to serve on
     */
    @JsonProperty("bindAddress")
    public void setBindAddress(String bindAddress) {
        this.bindAddress = bindAddress;
    }

    /**
     * bindNetwork is the type of network to bind to - defaults to "tcp4", accepts "tcp", "tcp4", and "tcp6"
     */
    @JsonProperty("bindNetwork")
    public String getBindNetwork() {
        return bindNetwork;
    }

    /**
     * bindNetwork is the type of network to bind to - defaults to "tcp4", accepts "tcp", "tcp4", and "tcp6"
     */
    @JsonProperty("bindNetwork")
    public void setBindNetwork(String bindNetwork) {
        this.bindNetwork = bindNetwork;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * cipherSuites contains an overridden list of ciphers for the server to support. Values must match cipher suite IDs from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    /**
     * cipherSuites contains an overridden list of ciphers for the server to support. Values must match cipher suite IDs from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    /**
     * clientCA is the certificate bundle for all the signers that you'll recognize for incoming client certificates
     */
    @JsonProperty("clientCA")
    public String getClientCA() {
        return clientCA;
    }

    /**
     * clientCA is the certificate bundle for all the signers that you'll recognize for incoming client certificates
     */
    @JsonProperty("clientCA")
    public void setClientCA(String clientCA) {
        this.clientCA = clientCA;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    /**
     * maxRequestsInFlight is the number of concurrent requests allowed to the server. If zero, no limit.
     */
    @JsonProperty("maxRequestsInFlight")
    public Long getMaxRequestsInFlight() {
        return maxRequestsInFlight;
    }

    /**
     * maxRequestsInFlight is the number of concurrent requests allowed to the server. If zero, no limit.
     */
    @JsonProperty("maxRequestsInFlight")
    public void setMaxRequestsInFlight(Long maxRequestsInFlight) {
        this.maxRequestsInFlight = maxRequestsInFlight;
    }

    /**
     * minTLSVersion is the minimum TLS version supported. Values must match version names from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("minTLSVersion")
    public String getMinTLSVersion() {
        return minTLSVersion;
    }

    /**
     * minTLSVersion is the minimum TLS version supported. Values must match version names from https://golang.org/pkg/crypto/tls/#pkg-constants
     */
    @JsonProperty("minTLSVersion")
    public void setMinTLSVersion(String minTLSVersion) {
        this.minTLSVersion = minTLSVersion;
    }

    /**
     * namedCertificates is a list of certificates to use to secure requests to specific hostnames
     */
    @JsonProperty("namedCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedCertificate> getNamedCertificates() {
        return namedCertificates;
    }

    /**
     * namedCertificates is a list of certificates to use to secure requests to specific hostnames
     */
    @JsonProperty("namedCertificates")
    public void setNamedCertificates(List<NamedCertificate> namedCertificates) {
        this.namedCertificates = namedCertificates;
    }

    /**
     * requestTimeoutSeconds is the number of seconds before requests are timed out. The default is 60 minutes, if -1 there is no limit on requests.
     */
    @JsonProperty("requestTimeoutSeconds")
    public Long getRequestTimeoutSeconds() {
        return requestTimeoutSeconds;
    }

    /**
     * requestTimeoutSeconds is the number of seconds before requests are timed out. The default is 60 minutes, if -1 there is no limit on requests.
     */
    @JsonProperty("requestTimeoutSeconds")
    public void setRequestTimeoutSeconds(Long requestTimeoutSeconds) {
        this.requestTimeoutSeconds = requestTimeoutSeconds;
    }

    @JsonIgnore
    public HTTPServingInfoBuilder edit() {
        return new HTTPServingInfoBuilder(this);
    }

    @JsonIgnore
    public HTTPServingInfoBuilder toBuilder() {
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
