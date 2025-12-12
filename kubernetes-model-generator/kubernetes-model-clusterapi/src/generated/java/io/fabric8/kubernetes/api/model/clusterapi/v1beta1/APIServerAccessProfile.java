
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
 * APIServerAccessProfile tunes the accessibility of the cluster's control plane. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/api-server-authorized-ip-ranges
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorizedIPRanges",
    "enablePrivateCluster",
    "enablePrivateClusterPublicFQDN",
    "privateDNSZone"
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
public class APIServerAccessProfile implements Editable<APIServerAccessProfileBuilder>, KubernetesResource
{

    @JsonProperty("authorizedIPRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> authorizedIPRanges = new ArrayList<>();
    @JsonProperty("enablePrivateCluster")
    private Boolean enablePrivateCluster;
    @JsonProperty("enablePrivateClusterPublicFQDN")
    private Boolean enablePrivateClusterPublicFQDN;
    @JsonProperty("privateDNSZone")
    private String privateDNSZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServerAccessProfile() {
    }

    public APIServerAccessProfile(List<String> authorizedIPRanges, Boolean enablePrivateCluster, Boolean enablePrivateClusterPublicFQDN, String privateDNSZone) {
        super();
        this.authorizedIPRanges = authorizedIPRanges;
        this.enablePrivateCluster = enablePrivateCluster;
        this.enablePrivateClusterPublicFQDN = enablePrivateClusterPublicFQDN;
        this.privateDNSZone = privateDNSZone;
    }

    /**
     * AuthorizedIPRanges - Authorized IP Ranges to kubernetes API server.
     */
    @JsonProperty("authorizedIPRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAuthorizedIPRanges() {
        return authorizedIPRanges;
    }

    /**
     * AuthorizedIPRanges - Authorized IP Ranges to kubernetes API server.
     */
    @JsonProperty("authorizedIPRanges")
    public void setAuthorizedIPRanges(List<String> authorizedIPRanges) {
        this.authorizedIPRanges = authorizedIPRanges;
    }

    /**
     * EnablePrivateCluster indicates whether to create the cluster as a private cluster or not.
     */
    @JsonProperty("enablePrivateCluster")
    public Boolean getEnablePrivateCluster() {
        return enablePrivateCluster;
    }

    /**
     * EnablePrivateCluster indicates whether to create the cluster as a private cluster or not.
     */
    @JsonProperty("enablePrivateCluster")
    public void setEnablePrivateCluster(Boolean enablePrivateCluster) {
        this.enablePrivateCluster = enablePrivateCluster;
    }

    /**
     * EnablePrivateClusterPublicFQDN indicates whether to create additional public FQDN for private cluster or not.
     */
    @JsonProperty("enablePrivateClusterPublicFQDN")
    public Boolean getEnablePrivateClusterPublicFQDN() {
        return enablePrivateClusterPublicFQDN;
    }

    /**
     * EnablePrivateClusterPublicFQDN indicates whether to create additional public FQDN for private cluster or not.
     */
    @JsonProperty("enablePrivateClusterPublicFQDN")
    public void setEnablePrivateClusterPublicFQDN(Boolean enablePrivateClusterPublicFQDN) {
        this.enablePrivateClusterPublicFQDN = enablePrivateClusterPublicFQDN;
    }

    /**
     * PrivateDNSZone enables private dns zone mode for private cluster.
     */
    @JsonProperty("privateDNSZone")
    public String getPrivateDNSZone() {
        return privateDNSZone;
    }

    /**
     * PrivateDNSZone enables private dns zone mode for private cluster.
     */
    @JsonProperty("privateDNSZone")
    public void setPrivateDNSZone(String privateDNSZone) {
        this.privateDNSZone = privateDNSZone;
    }

    @JsonIgnore
    public APIServerAccessProfileBuilder edit() {
        return new APIServerAccessProfileBuilder(this);
    }

    @JsonIgnore
    public APIServerAccessProfileBuilder toBuilder() {
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
