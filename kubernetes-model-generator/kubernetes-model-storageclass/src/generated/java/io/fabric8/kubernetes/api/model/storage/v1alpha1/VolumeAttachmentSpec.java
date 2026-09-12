
package io.fabric8.kubernetes.api.model.storage.v1alpha1;

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
 * VolumeAttachmentSpec is the specification of a VolumeAttachment request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attacher",
    "nodeName",
    "source"
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
public class VolumeAttachmentSpec implements Editable<VolumeAttachmentSpecBuilder>, KubernetesResource
{

    @JsonProperty("attacher")
    private String attacher;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("source")
    private VolumeAttachmentSource source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeAttachmentSpec() {
    }

    public VolumeAttachmentSpec(String attacher, String nodeName, VolumeAttachmentSource source) {
        super();
        this.attacher = attacher;
        this.nodeName = nodeName;
        this.source = source;
    }

    /**
     * Attacher indicates the name of the volume driver that MUST handle this request. This is the name returned by GetPluginName().
     */
    @JsonProperty("attacher")
    public String getAttacher() {
        return attacher;
    }

    /**
     * Attacher indicates the name of the volume driver that MUST handle this request. This is the name returned by GetPluginName().
     */
    @JsonProperty("attacher")
    public void setAttacher(String attacher) {
        this.attacher = attacher;
    }

    /**
     * The node that the volume should be attached to.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * The node that the volume should be attached to.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * VolumeAttachmentSpec is the specification of a VolumeAttachment request.
     */
    @JsonProperty("source")
    public VolumeAttachmentSource getSource() {
        return source;
    }

    /**
     * VolumeAttachmentSpec is the specification of a VolumeAttachment request.
     */
    @JsonProperty("source")
    public void setSource(VolumeAttachmentSource source) {
        this.source = source;
    }

    @JsonIgnore
    public VolumeAttachmentSpecBuilder edit() {
        return new VolumeAttachmentSpecBuilder(this);
    }

    @JsonIgnore
    public VolumeAttachmentSpecBuilder toBuilder() {
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
        if (!(o instanceof VolumeAttachmentSpec)) {
            return false;
        }
        VolumeAttachmentSpec other = (VolumeAttachmentSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attacher = this.getAttacher();
        Object other$attacher = other.getAttacher();
        if (this$attacher == null ? other$attacher != null : !this$attacher.equals(other$attacher)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof VolumeAttachmentSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attacher = this.getAttacher();
        result = result * prime + ($attacher == null ? 43 : $attacher.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeAttachmentSpec(" + "attacher=" + this.getAttacher() + ", nodeName=" + this.getNodeName() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
