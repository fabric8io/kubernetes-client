
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * LoadBalancerSpec defines an Azure load balancer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendPool",
    "frontendIPs",
    "frontendIPsCount",
    "id",
    "idleTimeoutInMinutes",
    "name",
    "sku",
    "type"
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
public class LoadBalancerSpec implements Editable<LoadBalancerSpecBuilder>, KubernetesResource
{

    @JsonProperty("backendPool")
    private BackendPool backendPool;
    @JsonProperty("frontendIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FrontendIP> frontendIPs = new ArrayList<>();
    @JsonProperty("frontendIPsCount")
    private Integer frontendIPsCount;
    @JsonProperty("id")
    private String id;
    @JsonProperty("idleTimeoutInMinutes")
    private Integer idleTimeoutInMinutes;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerSpec() {
    }

    public LoadBalancerSpec(BackendPool backendPool, List<FrontendIP> frontendIPs, Integer frontendIPsCount, String id, Integer idleTimeoutInMinutes, String name, String sku, String type) {
        super();
        this.backendPool = backendPool;
        this.frontendIPs = frontendIPs;
        this.frontendIPsCount = frontendIPsCount;
        this.id = id;
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        this.name = name;
        this.sku = sku;
        this.type = type;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("backendPool")
    public BackendPool getBackendPool() {
        return backendPool;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("backendPool")
    public void setBackendPool(BackendPool backendPool) {
        this.backendPool = backendPool;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("frontendIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FrontendIP> getFrontendIPs() {
        return frontendIPs;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("frontendIPs")
    public void setFrontendIPs(List<FrontendIP> frontendIPs) {
        this.frontendIPs = frontendIPs;
    }

    /**
     * FrontendIPsCount specifies the number of frontend IP addresses for the load balancer.
     */
    @JsonProperty("frontendIPsCount")
    public Integer getFrontendIPsCount() {
        return frontendIPsCount;
    }

    /**
     * FrontendIPsCount specifies the number of frontend IP addresses for the load balancer.
     */
    @JsonProperty("frontendIPsCount")
    public void setFrontendIPsCount(Integer frontendIPsCount) {
        this.frontendIPsCount = frontendIPsCount;
    }

    /**
     * ID is the Azure resource ID of the load balancer. READ-ONLY
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID is the Azure resource ID of the load balancer. READ-ONLY
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * IdleTimeoutInMinutes specifies the timeout for the TCP idle connection.
     */
    @JsonProperty("idleTimeoutInMinutes")
    public Integer getIdleTimeoutInMinutes() {
        return idleTimeoutInMinutes;
    }

    /**
     * IdleTimeoutInMinutes specifies the timeout for the TCP idle connection.
     */
    @JsonProperty("idleTimeoutInMinutes")
    public void setIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * LoadBalancerSpec defines an Azure load balancer.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public LoadBalancerSpecBuilder edit() {
        return new LoadBalancerSpecBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerSpecBuilder toBuilder() {
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
