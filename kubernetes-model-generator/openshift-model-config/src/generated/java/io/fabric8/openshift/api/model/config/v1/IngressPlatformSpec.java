
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * IngressPlatformSpec holds the desired state of Ingress specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "type"
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
public class IngressPlatformSpec implements Editable<IngressPlatformSpecBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSIngressSpec aws;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressPlatformSpec() {
    }

    public IngressPlatformSpec(AWSIngressSpec aws, String type) {
        super();
        this.aws = aws;
        this.type = type;
    }

    /**
     * IngressPlatformSpec holds the desired state of Ingress specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("aws")
    public AWSIngressSpec getAws() {
        return aws;
    }

    /**
     * IngressPlatformSpec holds the desired state of Ingress specific to the underlying infrastructure provider of the current cluster. Since these are used at spec-level for the underlying cluster, it is supposed that only one of the spec structs is set.
     */
    @JsonProperty("aws")
    public void setAws(AWSIngressSpec aws) {
        this.aws = aws;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "KubeVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the underlying infrastructure provider for the cluster. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", "KubeVirt", "EquinixMetal", "PowerVS", "AlibabaCloud", "Nutanix" and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public IngressPlatformSpecBuilder edit() {
        return new IngressPlatformSpecBuilder(this);
    }

    @JsonIgnore
    public IngressPlatformSpecBuilder toBuilder() {
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
        if (!(o instanceof IngressPlatformSpec)) {
            return false;
        }
        IngressPlatformSpec other = (IngressPlatformSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof IngressPlatformSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressPlatformSpec(" + "aws=" + this.getAws() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
