
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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

/**
 * MachineConfigNodeStatusInternalReleaseImageRef is used to provide a more detailed reference for a release bundle.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "image",
    "name"
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
public class MachineConfigNodeStatusInternalReleaseImageRef implements Editable<MachineConfigNodeStatusInternalReleaseImageRefBuilder>, KubernetesResource
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
    public MachineConfigNodeStatusInternalReleaseImageRef() {
    }

    public MachineConfigNodeStatusInternalReleaseImageRef(List<Condition> conditions, String image, String name) {
        super();
        this.conditions = conditions;
        this.image = image;
        this.name = name;
    }

    /**
     * conditions represent the observations of an internal release image current state. Valid types are: Mounted, Installing, Available, Removing and Degraded.<br><p> <br><p> If Mounted is true, that means that a valid ISO has been mounted on the current node. If Installing is true, that means that a new release bundle is currently being copied on the current node, and not yet completed. If Available is true, it means that the release has been previously installed on the current node, and it can be used. If Removing is true, it means that a release deletion is in progress on the current node, and not yet completed. If Degraded is true, that means something has gone wrong in the current node.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the observations of an internal release image current state. Valid types are: Mounted, Installing, Available, Removing and Degraded.<br><p> <br><p> If Mounted is true, that means that a valid ISO has been mounted on the current node. If Installing is true, that means that a new release bundle is currently being copied on the current node, and not yet completed. If Available is true, it means that the release has been previously installed on the current node, and it can be used. If Removing is true, it means that a release deletion is in progress on the current node, and not yet completed. If Degraded is true, that means something has gone wrong in the current node.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * image is an OCP release image referenced by digest. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The host must be either exactly "localhost" or a dot-qualified domain name. Single-label hosts other than "localhost" are not permitted. The length of the whole spec must be between 1 to 447 characters. The field is optional, and it will be provided after a release will be successfully installed.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is an OCP release image referenced by digest. The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The host must be either exactly "localhost" or a dot-qualified domain name. Single-label hosts other than "localhost" are not permitted. The length of the whole spec must be between 1 to 447 characters. The field is optional, and it will be provided after a release will be successfully installed.
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
    public MachineConfigNodeStatusInternalReleaseImageRefBuilder edit() {
        return new MachineConfigNodeStatusInternalReleaseImageRefBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeStatusInternalReleaseImageRefBuilder toBuilder() {
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
