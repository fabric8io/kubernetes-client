
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * DNSStatus defines the observed status of the DNS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterDomain",
    "clusterIP",
    "conditions"
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
public class DNSStatus implements Editable<DNSStatusBuilder>, KubernetesResource
{

    @JsonProperty("clusterDomain")
    private String clusterDomain;
    @JsonProperty("clusterIP")
    private String clusterIP;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSStatus() {
    }

    public DNSStatus(String clusterDomain, String clusterIP, List<OperatorCondition> conditions) {
        super();
        this.clusterDomain = clusterDomain;
        this.clusterIP = clusterIP;
        this.conditions = conditions;
    }

    /**
     * clusterDomain is the local cluster DNS domain suffix for DNS services. This will be a subdomain as defined in RFC 1034, section 3.5: https://tools.ietf.org/html/rfc1034#section-3.5 Example: "cluster.local"<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/services-networking/dns-pod-service
     */
    @JsonProperty("clusterDomain")
    public String getClusterDomain() {
        return clusterDomain;
    }

    /**
     * clusterDomain is the local cluster DNS domain suffix for DNS services. This will be a subdomain as defined in RFC 1034, section 3.5: https://tools.ietf.org/html/rfc1034#section-3.5 Example: "cluster.local"<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/services-networking/dns-pod-service
     */
    @JsonProperty("clusterDomain")
    public void setClusterDomain(String clusterDomain) {
        this.clusterDomain = clusterDomain;
    }

    /**
     * clusterIP is the service IP through which this DNS is made available.<br><p> <br><p> In the case of the default DNS, this will be a well known IP that is used as the default nameserver for pods that are using the default ClusterFirst DNS policy.<br><p> <br><p> In general, this IP can be specified in a pod's spec.dnsConfig.nameservers list or used explicitly when performing name resolution from within the cluster. Example: dig foo.com @&lt;service IP&gt;<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies
     */
    @JsonProperty("clusterIP")
    public String getClusterIP() {
        return clusterIP;
    }

    /**
     * clusterIP is the service IP through which this DNS is made available.<br><p> <br><p> In the case of the default DNS, this will be a well known IP that is used as the default nameserver for pods that are using the default ClusterFirst DNS policy.<br><p> <br><p> In general, this IP can be specified in a pod's spec.dnsConfig.nameservers list or used explicitly when performing name resolution from within the cluster. Example: dig foo.com @&lt;service IP&gt;<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies
     */
    @JsonProperty("clusterIP")
    public void setClusterIP(String clusterIP) {
        this.clusterIP = clusterIP;
    }

    /**
     * conditions provide information about the state of the DNS on the cluster.<br><p> <br><p> These are the supported DNS conditions:<br><p> <br><p>   &#42; Available<br><p>   - True if the following conditions are met:<br><p>     &#42; DNS controller daemonset is available.<br><p>   - False if any of those conditions are unsatisfied.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions provide information about the state of the DNS on the cluster.<br><p> <br><p> These are the supported DNS conditions:<br><p> <br><p>   &#42; Available<br><p>   - True if the following conditions are met:<br><p>     &#42; DNS controller daemonset is available.<br><p>   - False if any of those conditions are unsatisfied.
     */
    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonIgnore
    public DNSStatusBuilder edit() {
        return new DNSStatusBuilder(this);
    }

    @JsonIgnore
    public DNSStatusBuilder toBuilder() {
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
