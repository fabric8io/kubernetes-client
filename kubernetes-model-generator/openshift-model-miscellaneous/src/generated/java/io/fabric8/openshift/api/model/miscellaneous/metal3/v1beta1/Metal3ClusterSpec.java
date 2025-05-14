
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Metal3ClusterSpec defines the desired state of Metal3Cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controlPlaneEndpoint",
    "noCloudProvider"
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
public class Metal3ClusterSpec implements Editable<Metal3ClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("noCloudProvider")
    private Boolean noCloudProvider;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3ClusterSpec() {
    }

    public Metal3ClusterSpec(APIEndpoint controlPlaneEndpoint, Boolean noCloudProvider) {
        super();
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.noCloudProvider = noCloudProvider;
    }

    /**
     * Metal3ClusterSpec defines the desired state of Metal3Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * Metal3ClusterSpec defines the desired state of Metal3Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * Determines if the cluster is not to be deployed with an external cloud provider. If set to true, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to false, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource.
     */
    @JsonProperty("noCloudProvider")
    public Boolean getNoCloudProvider() {
        return noCloudProvider;
    }

    /**
     * Determines if the cluster is not to be deployed with an external cloud provider. If set to true, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to false, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource.
     */
    @JsonProperty("noCloudProvider")
    public void setNoCloudProvider(Boolean noCloudProvider) {
        this.noCloudProvider = noCloudProvider;
    }

    @JsonIgnore
    public Metal3ClusterSpecBuilder edit() {
        return new Metal3ClusterSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3ClusterSpecBuilder toBuilder() {
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
