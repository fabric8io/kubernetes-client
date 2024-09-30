
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class HTTPServingInfo implements Editable<HTTPServingInfoBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("bindAddress")
    public String getBindAddress() {
        return bindAddress;
    }

    @JsonProperty("bindAddress")
    public void setBindAddress(String bindAddress) {
        this.bindAddress = bindAddress;
    }

    @JsonProperty("bindNetwork")
    public String getBindNetwork() {
        return bindNetwork;
    }

    @JsonProperty("bindNetwork")
    public void setBindNetwork(String bindNetwork) {
        this.bindNetwork = bindNetwork;
    }

    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    @JsonProperty("cipherSuites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCipherSuites() {
        return cipherSuites;
    }

    @JsonProperty("cipherSuites")
    public void setCipherSuites(List<String> cipherSuites) {
        this.cipherSuites = cipherSuites;
    }

    @JsonProperty("clientCA")
    public String getClientCA() {
        return clientCA;
    }

    @JsonProperty("clientCA")
    public void setClientCA(String clientCA) {
        this.clientCA = clientCA;
    }

    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    @JsonProperty("maxRequestsInFlight")
    public Long getMaxRequestsInFlight() {
        return maxRequestsInFlight;
    }

    @JsonProperty("maxRequestsInFlight")
    public void setMaxRequestsInFlight(Long maxRequestsInFlight) {
        this.maxRequestsInFlight = maxRequestsInFlight;
    }

    @JsonProperty("minTLSVersion")
    public String getMinTLSVersion() {
        return minTLSVersion;
    }

    @JsonProperty("minTLSVersion")
    public void setMinTLSVersion(String minTLSVersion) {
        this.minTLSVersion = minTLSVersion;
    }

    @JsonProperty("namedCertificates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedCertificate> getNamedCertificates() {
        return namedCertificates;
    }

    @JsonProperty("namedCertificates")
    public void setNamedCertificates(List<NamedCertificate> namedCertificates) {
        this.namedCertificates = namedCertificates;
    }

    @JsonProperty("requestTimeoutSeconds")
    public Long getRequestTimeoutSeconds() {
        return requestTimeoutSeconds;
    }

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
