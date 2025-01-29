
package io.fabric8.istio.api.api.extensions.v1alpha1;

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
import io.fabric8.istio.api.api.type.v1beta1.PortSelector;
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
 * TrafficSelector provides a mechanism to select a specific traffic flow for which this Wasm Plugin will be enabled. When all the sub conditions in the TrafficSelector are satisfied, the traffic will be selected.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "ports"
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
public class WasmPluginTrafficSelector implements Editable<WasmPluginTrafficSelectorBuilder>, KubernetesResource
{

    @JsonProperty("mode")
    private Integer mode;
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PortSelector> ports = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WasmPluginTrafficSelector() {
    }

    public WasmPluginTrafficSelector(Integer mode, List<PortSelector> ports) {
        super();
        this.mode = mode;
        this.ports = ports;
    }

    /**
     * Criteria for selecting traffic by their direction. Note that `CLIENT` and `SERVER` are analogous to OUTBOUND and INBOUND, respectively. For the gateway, the field should be `CLIENT` or `CLIENT_AND_SERVER`. If not specified, the default value is `CLIENT_AND_SERVER`.
     */
    @JsonProperty("mode")
    public Integer getMode() {
        return mode;
    }

    /**
     * Criteria for selecting traffic by their direction. Note that `CLIENT` and `SERVER` are analogous to OUTBOUND and INBOUND, respectively. For the gateway, the field should be `CLIENT` or `CLIENT_AND_SERVER`. If not specified, the default value is `CLIENT_AND_SERVER`.
     */
    @JsonProperty("mode")
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**
     * Criteria for selecting traffic by their destination port. More specifically, for the outbound traffic, the destination port would be the port of the target service. On the other hand, for the inbound traffic, the destination port is the port bound by the server process in the same Pod.<br><p> <br><p> If one of the given `ports` is matched, this condition is evaluated to true. If not specified, this condition is evaluated to true for any port.
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PortSelector> getPorts() {
        return ports;
    }

    /**
     * Criteria for selecting traffic by their destination port. More specifically, for the outbound traffic, the destination port would be the port of the target service. On the other hand, for the inbound traffic, the destination port is the port bound by the server process in the same Pod.<br><p> <br><p> If one of the given `ports` is matched, this condition is evaluated to true. If not specified, this condition is evaluated to true for any port.
     */
    @JsonProperty("ports")
    public void setPorts(List<PortSelector> ports) {
        this.ports = ports;
    }

    @JsonIgnore
    public WasmPluginTrafficSelectorBuilder edit() {
        return new WasmPluginTrafficSelectorBuilder(this);
    }

    @JsonIgnore
    public WasmPluginTrafficSelectorBuilder toBuilder() {
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
