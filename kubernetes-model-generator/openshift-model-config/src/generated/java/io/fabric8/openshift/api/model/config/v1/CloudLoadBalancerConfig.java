
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
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

/**
 * CloudLoadBalancerConfig contains an union discriminator indicating the type of DNS solution in use within the cluster. When the DNSType is `ClusterHosted`, the cloud's Load Balancer configuration needs to be provided so that the DNS solution hosted within the cluster can be configured with those values.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterHosted",
    "dnsType"
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
public class CloudLoadBalancerConfig implements Editable<CloudLoadBalancerConfigBuilder>, KubernetesResource
{

    @JsonProperty("clusterHosted")
    private CloudLoadBalancerIPs clusterHosted;
    @JsonProperty("dnsType")
    private String dnsType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CloudLoadBalancerConfig() {
    }

    public CloudLoadBalancerConfig(CloudLoadBalancerIPs clusterHosted, String dnsType) {
        super();
        this.clusterHosted = clusterHosted;
        this.dnsType = dnsType;
    }

    /**
     * CloudLoadBalancerConfig contains an union discriminator indicating the type of DNS solution in use within the cluster. When the DNSType is `ClusterHosted`, the cloud's Load Balancer configuration needs to be provided so that the DNS solution hosted within the cluster can be configured with those values.
     */
    @JsonProperty("clusterHosted")
    public CloudLoadBalancerIPs getClusterHosted() {
        return clusterHosted;
    }

    /**
     * CloudLoadBalancerConfig contains an union discriminator indicating the type of DNS solution in use within the cluster. When the DNSType is `ClusterHosted`, the cloud's Load Balancer configuration needs to be provided so that the DNS solution hosted within the cluster can be configured with those values.
     */
    @JsonProperty("clusterHosted")
    public void setClusterHosted(CloudLoadBalancerIPs clusterHosted) {
        this.clusterHosted = clusterHosted;
    }

    /**
     * dnsType indicates the type of DNS solution in use within the cluster. Its default value of `PlatformDefault` indicates that the cluster's DNS is the default provided by the cloud platform. It can be set to `ClusterHosted` to bypass the configuration of the cloud default DNS. In this mode, the cluster needs to provide a self-hosted DNS solution for the cluster's installation to succeed. The cluster's use of the cloud's Load Balancers is unaffected by this setting. The value is immutable after it has been set at install time. Currently, there is no way for the customer to add additional DNS entries into the cluster hosted DNS. Enabling this functionality allows the user to start their own DNS solution outside the cluster after installation is complete. The customer would be responsible for configuring this custom DNS solution, and it can be run in addition to the in-cluster DNS solution.
     */
    @JsonProperty("dnsType")
    public String getDnsType() {
        return dnsType;
    }

    /**
     * dnsType indicates the type of DNS solution in use within the cluster. Its default value of `PlatformDefault` indicates that the cluster's DNS is the default provided by the cloud platform. It can be set to `ClusterHosted` to bypass the configuration of the cloud default DNS. In this mode, the cluster needs to provide a self-hosted DNS solution for the cluster's installation to succeed. The cluster's use of the cloud's Load Balancers is unaffected by this setting. The value is immutable after it has been set at install time. Currently, there is no way for the customer to add additional DNS entries into the cluster hosted DNS. Enabling this functionality allows the user to start their own DNS solution outside the cluster after installation is complete. The customer would be responsible for configuring this custom DNS solution, and it can be run in addition to the in-cluster DNS solution.
     */
    @JsonProperty("dnsType")
    public void setDnsType(String dnsType) {
        this.dnsType = dnsType;
    }

    @JsonIgnore
    public CloudLoadBalancerConfigBuilder edit() {
        return new CloudLoadBalancerConfigBuilder(this);
    }

    @JsonIgnore
    public CloudLoadBalancerConfigBuilder toBuilder() {
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
