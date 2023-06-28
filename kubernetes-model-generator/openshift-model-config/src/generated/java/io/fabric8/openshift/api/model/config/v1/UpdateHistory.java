
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acceptedRisks",
    "completionTime",
    "image",
    "startedTime",
    "state",
    "verified",
    "version"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class UpdateHistory implements KubernetesResource
{

    @JsonProperty("acceptedRisks")
    private java.lang.String acceptedRisks;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("startedTime")
    private String startedTime;
    @JsonProperty("state")
    private java.lang.String state;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("version")
    private java.lang.String version;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public UpdateHistory() {
    }

    public UpdateHistory(java.lang.String acceptedRisks, String completionTime, java.lang.String image, String startedTime, java.lang.String state, Boolean verified, java.lang.String version) {
        super();
        this.acceptedRisks = acceptedRisks;
        this.completionTime = completionTime;
        this.image = image;
        this.startedTime = startedTime;
        this.state = state;
        this.verified = verified;
        this.version = version;
    }

    @JsonProperty("acceptedRisks")
    public java.lang.String getAcceptedRisks() {
        return acceptedRisks;
    }

    @JsonProperty("acceptedRisks")
    public void setAcceptedRisks(java.lang.String acceptedRisks) {
        this.acceptedRisks = acceptedRisks;
    }

    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("startedTime")
    public String getStartedTime() {
        return startedTime;
    }

    @JsonProperty("startedTime")
    public void setStartedTime(String startedTime) {
        this.startedTime = startedTime;
    }

    @JsonProperty("state")
    public java.lang.String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(java.lang.String state) {
        this.state = state;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
