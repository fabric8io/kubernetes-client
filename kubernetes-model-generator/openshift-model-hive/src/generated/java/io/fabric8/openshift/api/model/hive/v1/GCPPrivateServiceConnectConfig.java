
package io.fabric8.openshift.api.model.hive.v1;

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
 * GCPPrivateServiceConnectConfig defines the gcp private service connect config for the private-link controller.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentialsSecretRef",
    "endpointVPCInventory"
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
public class GCPPrivateServiceConnectConfig implements Editable<GCPPrivateServiceConnectConfigBuilder>, KubernetesResource
{

    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("endpointVPCInventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPPrivateServiceConnectInventory> endpointVPCInventory = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPPrivateServiceConnectConfig() {
    }

    public GCPPrivateServiceConnectConfig(LocalObjectReference credentialsSecretRef, List<GCPPrivateServiceConnectInventory> endpointVPCInventory) {
        super();
        this.credentialsSecretRef = credentialsSecretRef;
        this.endpointVPCInventory = endpointVPCInventory;
    }

    /**
     * GCPPrivateServiceConnectConfig defines the gcp private service connect config for the private-link controller.
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * GCPPrivateServiceConnectConfig defines the gcp private service connect config for the private-link controller.
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * EndpointVPCInventory is a list of VPCs and the corresponding subnets in various GCP regions. The controller uses this list to choose a VPC for creating GCP Endpoints. Since the VPC Endpoints must be in the same region as the ClusterDeployment, we must have VPCs in that region to be able to setup Private Service Connect.
     */
    @JsonProperty("endpointVPCInventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPPrivateServiceConnectInventory> getEndpointVPCInventory() {
        return endpointVPCInventory;
    }

    /**
     * EndpointVPCInventory is a list of VPCs and the corresponding subnets in various GCP regions. The controller uses this list to choose a VPC for creating GCP Endpoints. Since the VPC Endpoints must be in the same region as the ClusterDeployment, we must have VPCs in that region to be able to setup Private Service Connect.
     */
    @JsonProperty("endpointVPCInventory")
    public void setEndpointVPCInventory(List<GCPPrivateServiceConnectInventory> endpointVPCInventory) {
        this.endpointVPCInventory = endpointVPCInventory;
    }

    @JsonIgnore
    public GCPPrivateServiceConnectConfigBuilder edit() {
        return new GCPPrivateServiceConnectConfigBuilder(this);
    }

    @JsonIgnore
    public GCPPrivateServiceConnectConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
