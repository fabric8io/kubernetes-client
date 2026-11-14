
package io.fabric8.certmanager.api.model.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "explanationURL",
    "lastChecked",
    "lastError",
    "nextCheck",
    "suggestedWindow"
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
public class CertificateACMEARIStatus implements Editable<CertificateACMEARIStatusBuilder>, KubernetesResource
{

    @JsonProperty("explanationURL")
    private String explanationURL;
    @JsonProperty("lastChecked")
    private String lastChecked;
    @JsonProperty("lastError")
    private String lastError;
    @JsonProperty("nextCheck")
    private String nextCheck;
    @JsonProperty("suggestedWindow")
    private ACMERenewalWindow suggestedWindow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateACMEARIStatus() {
    }

    public CertificateACMEARIStatus(String explanationURL, String lastChecked, String lastError, String nextCheck, ACMERenewalWindow suggestedWindow) {
        super();
        this.explanationURL = explanationURL;
        this.lastChecked = lastChecked;
        this.lastError = lastError;
        this.nextCheck = nextCheck;
        this.suggestedWindow = suggestedWindow;
    }

    /**
     * ExplanationURL is a human-readable URL that may explain why the suggested window has its current value.
     */
    @JsonProperty("explanationURL")
    public String getExplanationURL() {
        return explanationURL;
    }

    /**
     * ExplanationURL is a human-readable URL that may explain why the suggested window has its current value.
     */
    @JsonProperty("explanationURL")
    public void setExplanationURL(String explanationURL) {
        this.explanationURL = explanationURL;
    }

    @JsonProperty("lastChecked")
    public String getLastChecked() {
        return lastChecked;
    }

    @JsonProperty("lastChecked")
    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    /**
     * LastError is the last error encountered when checking the ACME server for renewal information, if any.
     */
    @JsonProperty("lastError")
    public String getLastError() {
        return lastError;
    }

    /**
     * LastError is the last error encountered when checking the ACME server for renewal information, if any.
     */
    @JsonProperty("lastError")
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    @JsonProperty("nextCheck")
    public String getNextCheck() {
        return nextCheck;
    }

    @JsonProperty("nextCheck")
    public void setNextCheck(String nextCheck) {
        this.nextCheck = nextCheck;
    }

    @JsonProperty("suggestedWindow")
    public ACMERenewalWindow getSuggestedWindow() {
        return suggestedWindow;
    }

    @JsonProperty("suggestedWindow")
    public void setSuggestedWindow(ACMERenewalWindow suggestedWindow) {
        this.suggestedWindow = suggestedWindow;
    }

    @JsonIgnore
    public CertificateACMEARIStatusBuilder edit() {
        return new CertificateACMEARIStatusBuilder(this);
    }

    @JsonIgnore
    public CertificateACMEARIStatusBuilder toBuilder() {
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
        if (!(o instanceof CertificateACMEARIStatus)) {
            return false;
        }
        CertificateACMEARIStatus other = (CertificateACMEARIStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$explanationURL = this.getExplanationURL();
        Object other$explanationURL = other.getExplanationURL();
        if (this$explanationURL == null ? other$explanationURL != null : !this$explanationURL.equals(other$explanationURL)) {
            return false;
        }
        Object this$lastChecked = this.getLastChecked();
        Object other$lastChecked = other.getLastChecked();
        if (this$lastChecked == null ? other$lastChecked != null : !this$lastChecked.equals(other$lastChecked)) {
            return false;
        }
        Object this$lastError = this.getLastError();
        Object other$lastError = other.getLastError();
        if (this$lastError == null ? other$lastError != null : !this$lastError.equals(other$lastError)) {
            return false;
        }
        Object this$nextCheck = this.getNextCheck();
        Object other$nextCheck = other.getNextCheck();
        if (this$nextCheck == null ? other$nextCheck != null : !this$nextCheck.equals(other$nextCheck)) {
            return false;
        }
        Object this$suggestedWindow = this.getSuggestedWindow();
        Object other$suggestedWindow = other.getSuggestedWindow();
        if (this$suggestedWindow == null ? other$suggestedWindow != null : !this$suggestedWindow.equals(other$suggestedWindow)) {
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
        return other instanceof CertificateACMEARIStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $explanationURL = this.getExplanationURL();
        result = result * prime + ($explanationURL == null ? 43 : $explanationURL.hashCode());
        Object $lastChecked = this.getLastChecked();
        result = result * prime + ($lastChecked == null ? 43 : $lastChecked.hashCode());
        Object $lastError = this.getLastError();
        result = result * prime + ($lastError == null ? 43 : $lastError.hashCode());
        Object $nextCheck = this.getNextCheck();
        result = result * prime + ($nextCheck == null ? 43 : $nextCheck.hashCode());
        Object $suggestedWindow = this.getSuggestedWindow();
        result = result * prime + ($suggestedWindow == null ? 43 : $suggestedWindow.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateACMEARIStatus(" + "explanationURL=" + this.getExplanationURL() + ", lastChecked=" + this.getLastChecked() + ", lastError=" + this.getLastError() + ", nextCheck=" + this.getNextCheck() + ", suggestedWindow=" + this.getSuggestedWindow() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
