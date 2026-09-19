
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
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

}
