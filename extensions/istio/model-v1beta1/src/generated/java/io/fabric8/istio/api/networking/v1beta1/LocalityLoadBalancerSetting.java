
package io.fabric8.istio.api.networking.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "distribute",
    "enabled",
    "failover",
    "failoverPriority"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class LocalityLoadBalancerSetting implements KubernetesResource
{

    @JsonProperty("distribute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalityLoadBalancerSettingDistribute> distribute = new ArrayList<LocalityLoadBalancerSettingDistribute>();
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("failover")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalityLoadBalancerSettingFailover> failover = new ArrayList<LocalityLoadBalancerSettingFailover>();
    @JsonProperty("failoverPriority")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failoverPriority = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocalityLoadBalancerSetting() {
    }

    /**
     * 
     * @param failoverPriority
     * @param failover
     * @param distribute
     * @param enabled
     */
    public LocalityLoadBalancerSetting(List<LocalityLoadBalancerSettingDistribute> distribute, Boolean enabled, List<LocalityLoadBalancerSettingFailover> failover, List<String> failoverPriority) {
        super();
        this.distribute = distribute;
        this.enabled = enabled;
        this.failover = failover;
        this.failoverPriority = failoverPriority;
    }

    @JsonProperty("distribute")
    public List<LocalityLoadBalancerSettingDistribute> getDistribute() {
        return distribute;
    }

    @JsonProperty("distribute")
    public void setDistribute(List<LocalityLoadBalancerSettingDistribute> distribute) {
        this.distribute = distribute;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("failover")
    public List<LocalityLoadBalancerSettingFailover> getFailover() {
        return failover;
    }

    @JsonProperty("failover")
    public void setFailover(List<LocalityLoadBalancerSettingFailover> failover) {
        this.failover = failover;
    }

    @JsonProperty("failoverPriority")
    public List<String> getFailoverPriority() {
        return failoverPriority;
    }

    @JsonProperty("failoverPriority")
    public void setFailoverPriority(List<String> failoverPriority) {
        this.failoverPriority = failoverPriority;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
