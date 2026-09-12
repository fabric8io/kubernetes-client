
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * Metal3DataTemplateSpec defines the desired state of Metal3DataTemplate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterName",
    "metaData",
    "networkData",
    "templateReference"
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
public class Metal3DataTemplateSpec implements Editable<Metal3DataTemplateSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("metaData")
    private MetaData metaData;
    @JsonProperty("networkData")
    private NetworkData networkData;
    @JsonProperty("templateReference")
    private String templateReference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3DataTemplateSpec() {
    }

    public Metal3DataTemplateSpec(String clusterName, MetaData metaData, NetworkData networkData, String templateReference) {
        super();
        this.clusterName = clusterName;
        this.metaData = metaData;
        this.networkData = networkData;
        this.templateReference = templateReference;
    }

    /**
     * ClusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * ClusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * Metal3DataTemplateSpec defines the desired state of Metal3DataTemplate.
     */
    @JsonProperty("metaData")
    public MetaData getMetaData() {
        return metaData;
    }

    /**
     * Metal3DataTemplateSpec defines the desired state of Metal3DataTemplate.
     */
    @JsonProperty("metaData")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    /**
     * Metal3DataTemplateSpec defines the desired state of Metal3DataTemplate.
     */
    @JsonProperty("networkData")
    public NetworkData getNetworkData() {
        return networkData;
    }

    /**
     * Metal3DataTemplateSpec defines the desired state of Metal3DataTemplate.
     */
    @JsonProperty("networkData")
    public void setNetworkData(NetworkData networkData) {
        this.networkData = networkData;
    }

    /**
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to.<br><p> <br><p> Deprecated: This field is deprecated and will be removed in a future release.
     */
    @JsonProperty("templateReference")
    public String getTemplateReference() {
        return templateReference;
    }

    /**
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to.<br><p> <br><p> Deprecated: This field is deprecated and will be removed in a future release.
     */
    @JsonProperty("templateReference")
    public void setTemplateReference(String templateReference) {
        this.templateReference = templateReference;
    }

    @JsonIgnore
    public Metal3DataTemplateSpecBuilder edit() {
        return new Metal3DataTemplateSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3DataTemplateSpecBuilder toBuilder() {
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
        if (!(o instanceof Metal3DataTemplateSpec)) {
            return false;
        }
        Metal3DataTemplateSpec other = (Metal3DataTemplateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterName = this.getClusterName();
        Object other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$templateReference = this.getTemplateReference();
        Object other$templateReference = other.getTemplateReference();
        if (this$templateReference == null ? other$templateReference != null : !this$templateReference.equals(other$templateReference)) {
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
        return other instanceof Metal3DataTemplateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterName = this.getClusterName();
        result = result * prime + ($clusterName == null ? 43 : $clusterName.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $templateReference = this.getTemplateReference();
        result = result * prime + ($templateReference == null ? 43 : $templateReference.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3DataTemplateSpec(" + "clusterName=" + this.getClusterName() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", templateReference=" + this.getTemplateReference() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
