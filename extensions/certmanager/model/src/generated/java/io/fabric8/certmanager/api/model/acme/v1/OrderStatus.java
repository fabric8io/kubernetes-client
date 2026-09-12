
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorizations",
    "certificate",
    "failureTime",
    "finalizeURL",
    "reason",
    "state",
    "url"
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
public class OrderStatus implements Editable<OrderStatusBuilder>, KubernetesResource
{

    @JsonProperty("authorizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ACMEAuthorization> authorizations = new ArrayList<>();
    @JsonProperty("certificate")
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OrderStatus() {
    }

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

    /**
     * Authorizations contains data returned from the ACME server on what authorizations must be completed in order to validate the DNS names specified on the Order.
     */
    @JsonProperty("authorizations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ACMEAuthorization> getAuthorizations() {
        return authorizations;
    }

    /**
     * Authorizations contains data returned from the ACME server on what authorizations must be completed in order to validate the DNS names specified on the Order.
     */
    @JsonProperty("authorizations")
    public void setAuthorizations(List<ACMEAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    /**
     * Certificate is a copy of the PEM encoded certificate for this Order. This field will be populated after the order has been successfully finalized with the ACME server, and the order has transitioned to the 'valid' state.
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * Certificate is a copy of the PEM encoded certificate for this Order. This field will be populated after the order has been successfully finalized with the ACME server, and the order has transitioned to the 'valid' state.
     */
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

    /**
     * FinalizeURL of the Order. This is used to obtain certificates for this order once it has been completed.
     */
    @JsonProperty("finalizeURL")
    public String getFinalizeURL() {
        return finalizeURL;
    }

    /**
     * FinalizeURL of the Order. This is used to obtain certificates for this order once it has been completed.
     */
    @JsonProperty("finalizeURL")
    public void setFinalizeURL(String finalizeURL) {
        this.finalizeURL = finalizeURL;
    }

    /**
     * Reason optionally provides more information about a why the order is in the current state.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Reason optionally provides more information about a why the order is in the current state.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * State contains the current state of this Order resource. States 'success' and 'expired' are 'final'
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * State contains the current state of this Order resource. States 'success' and 'expired' are 'final'
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * URL of the Order. This will initially be empty when the resource is first created. The Order controller will populate this field when the Order is first processed. This field will be immutable after it is initially set.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL of the Order. This will initially be empty when the resource is first created. The Order controller will populate this field when the Order is first processed. This field will be immutable after it is initially set.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public OrderStatusBuilder edit() {
        return new OrderStatusBuilder(this);
    }

    @JsonIgnore
    public OrderStatusBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authorizations = this.getAuthorizations();
        Object other$authorizations = other.getAuthorizations();
        if (this$authorizations == null ? other$authorizations != null : !this$authorizations.equals(other$authorizations)) {
            return false;
        }
        Object this$certificate = this.getCertificate();
        Object other$certificate = other.getCertificate();
        if (this$certificate == null ? other$certificate != null : !this$certificate.equals(other$certificate)) {
            return false;
        }
        Object this$failureTime = this.getFailureTime();
        Object other$failureTime = other.getFailureTime();
        if (this$failureTime == null ? other$failureTime != null : !this$failureTime.equals(other$failureTime)) {
            return false;
        }
        Object this$finalizeURL = this.getFinalizeURL();
        Object other$finalizeURL = other.getFinalizeURL();
        if (this$finalizeURL == null ? other$finalizeURL != null : !this$finalizeURL.equals(other$finalizeURL)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof OrderStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authorizations = this.getAuthorizations();
        result = result * prime + ($authorizations == null ? 43 : $authorizations.hashCode());
        Object $certificate = this.getCertificate();
        result = result * prime + ($certificate == null ? 43 : $certificate.hashCode());
        Object $failureTime = this.getFailureTime();
        result = result * prime + ($failureTime == null ? 43 : $failureTime.hashCode());
        Object $finalizeURL = this.getFinalizeURL();
        result = result * prime + ($finalizeURL == null ? 43 : $finalizeURL.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OrderStatus(" + "authorizations=" + this.getAuthorizations() + ", certificate=" + this.getCertificate() + ", failureTime=" + this.getFailureTime() + ", finalizeURL=" + this.getFinalizeURL() + ", reason=" + this.getReason() + ", state=" + this.getState() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
