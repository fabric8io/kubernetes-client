
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * ClusterNetwork specifies the different networking parameters for a cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerPort",
    "pods",
    "serviceDomain",
    "services"
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
public class ClusterNetwork implements Editable<ClusterNetworkBuilder>, KubernetesResource
{

    @JsonProperty("apiServerPort")
    private Integer apiServerPort;
    @JsonProperty("pods")
    private NetworkRanges pods;
    @JsonProperty("serviceDomain")
    private String serviceDomain;
    @JsonProperty("services")
    private NetworkRanges services;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetwork() {
    }

    public ClusterNetwork(Integer apiServerPort, NetworkRanges pods, String serviceDomain, NetworkRanges services) {
        super();
        this.apiServerPort = apiServerPort;
        this.pods = pods;
        this.serviceDomain = serviceDomain;
        this.services = services;
    }

    /**
     * apiServerPort specifies the port the API Server should bind to. Defaults to 6443.
     */
    @JsonProperty("apiServerPort")
    public Integer getApiServerPort() {
        return apiServerPort;
    }

    /**
     * apiServerPort specifies the port the API Server should bind to. Defaults to 6443.
     */
    @JsonProperty("apiServerPort")
    public void setApiServerPort(Integer apiServerPort) {
        this.apiServerPort = apiServerPort;
    }

    /**
     * ClusterNetwork specifies the different networking parameters for a cluster.
     */
    @JsonProperty("pods")
    public NetworkRanges getPods() {
        return pods;
    }

    /**
     * ClusterNetwork specifies the different networking parameters for a cluster.
     */
    @JsonProperty("pods")
    public void setPods(NetworkRanges pods) {
        this.pods = pods;
    }

    /**
     * serviceDomain is the domain name for services.
     */
    @JsonProperty("serviceDomain")
    public String getServiceDomain() {
        return serviceDomain;
    }

    /**
     * serviceDomain is the domain name for services.
     */
    @JsonProperty("serviceDomain")
    public void setServiceDomain(String serviceDomain) {
        this.serviceDomain = serviceDomain;
    }

    /**
     * ClusterNetwork specifies the different networking parameters for a cluster.
     */
    @JsonProperty("services")
    public NetworkRanges getServices() {
        return services;
    }

    /**
     * ClusterNetwork specifies the different networking parameters for a cluster.
     */
    @JsonProperty("services")
    public void setServices(NetworkRanges services) {
        this.services = services;
    }

    @JsonIgnore
    public ClusterNetworkBuilder edit() {
        return new ClusterNetworkBuilder(this);
    }

    @JsonIgnore
    public ClusterNetworkBuilder toBuilder() {
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
