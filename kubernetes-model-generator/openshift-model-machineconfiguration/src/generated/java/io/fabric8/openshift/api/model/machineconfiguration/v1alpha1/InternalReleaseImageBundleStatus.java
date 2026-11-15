
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Condition;
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
    "conditions",
    "image",
    "name"
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
public class InternalReleaseImageBundleStatus implements Editable<InternalReleaseImageBundleStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InternalReleaseImageBundleStatus() {
    }

    public InternalReleaseImageBundleStatus(List<Condition> conditions, String image, String name) {
        super();
        this.conditions = conditions;
        this.image = image;
        this.name = name;
    }

    /**
     * conditions represent the observations of an internal release image current state. Valid types are: Mounted, Installing, Available, Removing and Degraded.<br><p> <br><p> If Mounted is true, that means that a valid ISO has been discovered and mounted on one of the cluster nodes. If Installing is true, that means that a new release bundle is currently being copied on one (or more) cluster nodes, and not yet completed. If Available is true, it means that the release has been previously installed on all the cluster nodes, and it can be used. If Removing is true, it means that a release deletion is in progress on one (or more) cluster nodes, and not yet completed. If Degraded is true, that means something has gone wrong (possibly on one or more cluster nodes).<br><p> <br><p> In general, after installing a new release bundle, it is required to wait for the Conditions "Available" to become "True" (and all the other conditions to be equal to "False") before being able to pull its content.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the observations of an internal release image current state. Valid types are: Mounted, Installing, Available, Removing and Degraded.<br><p> <br><p> If Mounted is true, that means that a valid ISO has been discovered and mounted on one of the cluster nodes. If Installing is true, that means that a new release bundle is currently being copied on one (or more) cluster nodes, and not yet completed. If Available is true, it means that the release has been previously installed on all the cluster nodes, and it can be used. If Removing is true, it means that a release deletion is in progress on one (or more) cluster nodes, and not yet completed. If Degraded is true, that means something has gone wrong (possibly on one or more cluster nodes).<br><p> <br><p> In general, after installing a new release bundle, it is required to wait for the Conditions "Available" to become "True" (and all the other conditions to be equal to "False") before being able to pull its content.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * image is an OCP release image referenced by digest. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters. The field is optional, and it will be provided after a release will be successfully installed.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is an OCP release image referenced by digest. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters. The field is optional, and it will be provided after a release will be successfully installed.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * name indicates the desired release bundle identifier. This field is required and must be between 1 and 64 characters long. The expected name format is ocp-release-bundle-&lt;version&gt;-&lt;arch|stream&gt;.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name indicates the desired release bundle identifier. This field is required and must be between 1 and 64 characters long. The expected name format is ocp-release-bundle-&lt;version&gt;-&lt;arch|stream&gt;.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public InternalReleaseImageBundleStatusBuilder edit() {
        return new InternalReleaseImageBundleStatusBuilder(this);
    }

    @JsonIgnore
    public InternalReleaseImageBundleStatusBuilder toBuilder() {
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
        if (!(o instanceof InternalReleaseImageBundleStatus)) {
            return false;
        }
        InternalReleaseImageBundleStatus other = (InternalReleaseImageBundleStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof InternalReleaseImageBundleStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InternalReleaseImageBundleStatus(" + "conditions=" + this.getConditions() + ", image=" + this.getImage() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
