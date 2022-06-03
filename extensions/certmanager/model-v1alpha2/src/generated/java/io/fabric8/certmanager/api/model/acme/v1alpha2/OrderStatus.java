
package io.fabric8.certmanager.api.model.acme.v1alpha2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "authorizations",
    "certificate",
    "failureTime",
    "finalizeURL",
    "reason",
    "state",
    "url"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class OrderStatus implements KubernetesResource
{

    @JsonProperty("authorizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ACMEAuthorization> authorizations = new ArrayList<ACMEAuthorization>();
    @JsonProperty("certificate")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String certificate;
    @JsonProperty("failureTime")
    private String failureTime;
    @JsonProperty("finalizeURL")
    private String finalizeURL;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("state")
    private String state;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderStatus() {
    }

    /**
     * 
     * @param reason
     * @param authorizations
     * @param certificate
     * @param failureTime
     * @param state
     * @param finalizeURL
     * @param url
     */
    public OrderStatus(List<ACMEAuthorization> authorizations, String certificate, String failureTime, String finalizeURL, String reason, String state, String url) {
        super();
        this.authorizations = authorizations;
        this.certificate = certificate;
        this.failureTime = failureTime;
        this.finalizeURL = finalizeURL;
        this.reason = reason;
        this.state = state;
        this.url = url;
    }

    @JsonProperty("authorizations")
    public List<ACMEAuthorization> getAuthorizations() {
        return authorizations;
    }

    @JsonProperty("authorizations")
    public void setAuthorizations(List<ACMEAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @JsonProperty("failureTime")
    public String getFailureTime() {
        return failureTime;
    }

    @JsonProperty("failureTime")
    public void setFailureTime(String failureTime) {
        this.failureTime = failureTime;
    }

    @JsonProperty("finalizeURL")
    public String getFinalizeURL() {
        return finalizeURL;
    }

    @JsonProperty("finalizeURL")
    public void setFinalizeURL(String finalizeURL) {
        this.finalizeURL = finalizeURL;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
