
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to
     */
    @JsonProperty("templateReference")
    public String getTemplateReference() {
        return templateReference;
    }

    /**
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to
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

}
