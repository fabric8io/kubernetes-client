
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
 * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "gcp",
    "ibm",
    "openstack",
    "type"
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
public class ProviderLoadBalancerParameters implements Editable<ProviderLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSLoadBalancerParameters aws;
    @JsonProperty("gcp")
    private GCPLoadBalancerParameters gcp;
    @JsonProperty("ibm")
    private IBMLoadBalancerParameters ibm;
    @JsonProperty("openstack")
    private OpenStackLoadBalancerParameters openstack;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProviderLoadBalancerParameters() {
    }

    public ProviderLoadBalancerParameters(AWSLoadBalancerParameters aws, GCPLoadBalancerParameters gcp, IBMLoadBalancerParameters ibm, OpenStackLoadBalancerParameters openstack, String type) {
        super();
        this.aws = aws;
        this.gcp = gcp;
        this.ibm = ibm;
        this.openstack = openstack;
        this.type = type;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("aws")
    public AWSLoadBalancerParameters getAws() {
        return aws;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("aws")
    public void setAws(AWSLoadBalancerParameters aws) {
        this.aws = aws;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("gcp")
    public GCPLoadBalancerParameters getGcp() {
        return gcp;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("gcp")
    public void setGcp(GCPLoadBalancerParameters gcp) {
        this.gcp = gcp;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("ibm")
    public IBMLoadBalancerParameters getIbm() {
        return ibm;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("ibm")
    public void setIbm(IBMLoadBalancerParameters ibm) {
        this.ibm = ibm;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("openstack")
    public OpenStackLoadBalancerParameters getOpenstack() {
        return openstack;
    }

    /**
     * ProviderLoadBalancerParameters holds desired load balancer information specific to the underlying infrastructure provider.
     */
    @JsonProperty("openstack")
    public void setOpenstack(OpenStackLoadBalancerParameters openstack) {
        this.openstack = openstack;
    }

    /**
     * type is the underlying infrastructure provider for the load balancer. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "IBM", "Nutanix", "OpenStack", and "VSphere".
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the underlying infrastructure provider for the load balancer. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "IBM", "Nutanix", "OpenStack", and "VSphere".
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ProviderLoadBalancerParametersBuilder edit() {
        return new ProviderLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public ProviderLoadBalancerParametersBuilder toBuilder() {
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
