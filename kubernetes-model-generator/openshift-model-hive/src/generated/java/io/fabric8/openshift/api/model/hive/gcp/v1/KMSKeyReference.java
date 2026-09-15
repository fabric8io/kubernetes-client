
package io.fabric8.openshift.api.model.hive.gcp.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * KMSKeyReference gathers required fields for looking up a GCP KMS Key
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "keyRing",
    "location",
    "name",
    "projectID"
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
public class KMSKeyReference implements Editable<KMSKeyReferenceBuilder>, KubernetesResource
{

    @JsonProperty("keyRing")
    private String keyRing;
    @JsonProperty("location")
    private String location;
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectID")
    private String projectID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KMSKeyReference() {
    }

    public KMSKeyReference(String keyRing, String location, String name, String projectID) {
        super();
        this.keyRing = keyRing;
        this.location = location;
        this.name = name;
        this.projectID = projectID;
    }

    /**
     * KeyRing is the name of the KMS Key Ring which the KMS Key belongs to.
     */
    @JsonProperty("keyRing")
    public String getKeyRing() {
        return keyRing;
    }

    /**
     * KeyRing is the name of the KMS Key Ring which the KMS Key belongs to.
     */
    @JsonProperty("keyRing")
    public void setKeyRing(String keyRing) {
        this.keyRing = keyRing;
    }

    /**
     * Location is the GCP location in which the Key Ring exists.
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * Location is the GCP location in which the Key Ring exists.
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Name is the name of the customer managed encryption key to be used for the disk encryption.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the customer managed encryption key to be used for the disk encryption.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ProjectID is the ID of the Project in which the KMS Key Ring exists. Defaults to the VM ProjectID if not set.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * ProjectID is the ID of the Project in which the KMS Key Ring exists. Defaults to the VM ProjectID if not set.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    @JsonIgnore
    public KMSKeyReferenceBuilder edit() {
        return new KMSKeyReferenceBuilder(this);
    }

    @JsonIgnore
    public KMSKeyReferenceBuilder toBuilder() {
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
        if (!(o instanceof KMSKeyReference)) {
            return false;
        }
        KMSKeyReference other = (KMSKeyReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$keyRing = this.getKeyRing();
        Object other$keyRing = other.getKeyRing();
        if (this$keyRing == null ? other$keyRing != null : !this$keyRing.equals(other$keyRing)) {
            return false;
        }
        Object this$location = this.getLocation();
        Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
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
        return other instanceof KMSKeyReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $keyRing = this.getKeyRing();
        result = result * prime + ($keyRing == null ? 43 : $keyRing.hashCode());
        Object $location = this.getLocation();
        result = result * prime + ($location == null ? 43 : $location.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KMSKeyReference(" + "keyRing=" + this.getKeyRing() + ", location=" + this.getLocation() + ", name=" + this.getName() + ", projectID=" + this.getProjectID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
