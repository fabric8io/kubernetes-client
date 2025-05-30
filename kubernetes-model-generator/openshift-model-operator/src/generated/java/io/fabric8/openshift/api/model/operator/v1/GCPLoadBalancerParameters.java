
package io.fabric8.openshift.api.model.operator.v1;

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
 * GCPLoadBalancerParameters provides configuration settings that are specific to GCP load balancers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientAccess"
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
public class GCPLoadBalancerParameters implements Editable<GCPLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("clientAccess")
    private String clientAccess;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPLoadBalancerParameters() {
    }

    public GCPLoadBalancerParameters(String clientAccess) {
        super();
        this.clientAccess = clientAccess;
    }

    /**
     * clientAccess describes how client access is restricted for internal load balancers.<br><p> <br><p> Valid values are: &#42; "Global": Specifying an internal load balancer with Global client access<br><p>   allows clients from any region within the VPC to communicate with the load<br><p>   balancer.<br><p> <br><p>     https://cloud.google.com/kubernetes-engine/docs/how-to/internal-load-balancing#global_access<br><p> <br><p> &#42; "Local": Specifying an internal load balancer with Local client access<br><p>   means only clients within the same region (and VPC) as the GCP load balancer<br><p>   can communicate with the load balancer. Note that this is the default behavior.<br><p> <br><p>     https://cloud.google.com/load-balancing/docs/internal#client_access
     */
    @JsonProperty("clientAccess")
    public String getClientAccess() {
        return clientAccess;
    }

    /**
     * clientAccess describes how client access is restricted for internal load balancers.<br><p> <br><p> Valid values are: &#42; "Global": Specifying an internal load balancer with Global client access<br><p>   allows clients from any region within the VPC to communicate with the load<br><p>   balancer.<br><p> <br><p>     https://cloud.google.com/kubernetes-engine/docs/how-to/internal-load-balancing#global_access<br><p> <br><p> &#42; "Local": Specifying an internal load balancer with Local client access<br><p>   means only clients within the same region (and VPC) as the GCP load balancer<br><p>   can communicate with the load balancer. Note that this is the default behavior.<br><p> <br><p>     https://cloud.google.com/load-balancing/docs/internal#client_access
     */
    @JsonProperty("clientAccess")
    public void setClientAccess(String clientAccess) {
        this.clientAccess = clientAccess;
    }

    @JsonIgnore
    public GCPLoadBalancerParametersBuilder edit() {
        return new GCPLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public GCPLoadBalancerParametersBuilder toBuilder() {
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
