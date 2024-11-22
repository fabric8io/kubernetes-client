
package io.fabric8.openclustermanagement.api.model.cluster.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hubAcceptsClient",
    "leaseDurationSeconds",
    "managedClusterClientConfigs",
    "taints"
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
public class ManagedClusterSpec implements Editable<ManagedClusterSpecBuilder> , KubernetesResource
{

    @JsonProperty("hubAcceptsClient")
    private Boolean hubAcceptsClient;
    @JsonProperty("leaseDurationSeconds")
    private Integer leaseDurationSeconds;
    @JsonProperty("managedClusterClientConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClientConfig> managedClusterClientConfigs = new ArrayList<>();
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ManagedClusterSpec() {
    }

    public ManagedClusterSpec(Boolean hubAcceptsClient, Integer leaseDurationSeconds, List<ClientConfig> managedClusterClientConfigs, List<Taint> taints) {
        super();
        this.hubAcceptsClient = hubAcceptsClient;
        this.leaseDurationSeconds = leaseDurationSeconds;
        this.managedClusterClientConfigs = managedClusterClientConfigs;
        this.taints = taints;
    }

    @JsonProperty("hubAcceptsClient")
    public Boolean getHubAcceptsClient() {
        return hubAcceptsClient;
    }

    @JsonProperty("hubAcceptsClient")
    public void setHubAcceptsClient(Boolean hubAcceptsClient) {
        this.hubAcceptsClient = hubAcceptsClient;
    }

    @JsonProperty("leaseDurationSeconds")
    public Integer getLeaseDurationSeconds() {
        return leaseDurationSeconds;
    }

    @JsonProperty("leaseDurationSeconds")
    public void setLeaseDurationSeconds(Integer leaseDurationSeconds) {
        this.leaseDurationSeconds = leaseDurationSeconds;
    }

    @JsonProperty("managedClusterClientConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClientConfig> getManagedClusterClientConfigs() {
        return managedClusterClientConfigs;
    }

    @JsonProperty("managedClusterClientConfigs")
    public void setManagedClusterClientConfigs(List<ClientConfig> managedClusterClientConfigs) {
        this.managedClusterClientConfigs = managedClusterClientConfigs;
    }

    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public ManagedClusterSpecBuilder edit() {
        return new ManagedClusterSpecBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSpecBuilder toBuilder() {
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
