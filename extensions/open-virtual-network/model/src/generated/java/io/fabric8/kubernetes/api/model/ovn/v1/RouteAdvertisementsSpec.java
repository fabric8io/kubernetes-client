
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * RouteAdvertisementsSpec defines the desired state of RouteAdvertisements
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "advertisements",
    "frrConfigurationSelector",
    "networkSelectors",
    "nodeSelector",
    "targetVRF"
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
public class RouteAdvertisementsSpec implements Editable<RouteAdvertisementsSpecBuilder>, KubernetesResource
{

    @JsonProperty("advertisements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> advertisements = new ArrayList<>();
    @JsonProperty("frrConfigurationSelector")
    private LabelSelector frrConfigurationSelector;
    @JsonProperty("networkSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkSelector> networkSelectors = new ArrayList<>();
    @JsonProperty("nodeSelector")
    private LabelSelector nodeSelector;
    @JsonProperty("targetVRF")
    private String targetVRF;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouteAdvertisementsSpec() {
    }

    public RouteAdvertisementsSpec(List<String> advertisements, LabelSelector frrConfigurationSelector, List<NetworkSelector> networkSelectors, LabelSelector nodeSelector, String targetVRF) {
        super();
        this.advertisements = advertisements;
        this.frrConfigurationSelector = frrConfigurationSelector;
        this.networkSelectors = networkSelectors;
        this.nodeSelector = nodeSelector;
        this.targetVRF = targetVRF;
    }

    /**
     * advertisements determines what is advertised.
     */
    @JsonProperty("advertisements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdvertisements() {
        return advertisements;
    }

    /**
     * advertisements determines what is advertised.
     */
    @JsonProperty("advertisements")
    public void setAdvertisements(List<String> advertisements) {
        this.advertisements = advertisements;
    }

    /**
     * RouteAdvertisementsSpec defines the desired state of RouteAdvertisements
     */
    @JsonProperty("frrConfigurationSelector")
    public LabelSelector getFrrConfigurationSelector() {
        return frrConfigurationSelector;
    }

    /**
     * RouteAdvertisementsSpec defines the desired state of RouteAdvertisements
     */
    @JsonProperty("frrConfigurationSelector")
    public void setFrrConfigurationSelector(LabelSelector frrConfigurationSelector) {
        this.frrConfigurationSelector = frrConfigurationSelector;
    }

    /**
     * networkSelectors determines which network routes should be advertised. Only ClusterUserDefinedNetworks and the default network can be selected.
     */
    @JsonProperty("networkSelectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkSelector> getNetworkSelectors() {
        return networkSelectors;
    }

    /**
     * networkSelectors determines which network routes should be advertised. Only ClusterUserDefinedNetworks and the default network can be selected.
     */
    @JsonProperty("networkSelectors")
    public void setNetworkSelectors(List<NetworkSelector> networkSelectors) {
        this.networkSelectors = networkSelectors;
    }

    /**
     * RouteAdvertisementsSpec defines the desired state of RouteAdvertisements
     */
    @JsonProperty("nodeSelector")
    public LabelSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * RouteAdvertisementsSpec defines the desired state of RouteAdvertisements
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(LabelSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * targetVRF determines which VRF the routes should be advertised in.
     */
    @JsonProperty("targetVRF")
    public String getTargetVRF() {
        return targetVRF;
    }

    /**
     * targetVRF determines which VRF the routes should be advertised in.
     */
    @JsonProperty("targetVRF")
    public void setTargetVRF(String targetVRF) {
        this.targetVRF = targetVRF;
    }

    @JsonIgnore
    public RouteAdvertisementsSpecBuilder edit() {
        return new RouteAdvertisementsSpecBuilder(this);
    }

    @JsonIgnore
    public RouteAdvertisementsSpecBuilder toBuilder() {
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
