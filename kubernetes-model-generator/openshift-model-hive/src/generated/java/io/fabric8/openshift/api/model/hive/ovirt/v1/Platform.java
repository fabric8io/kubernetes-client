
package io.fabric8.openshift.api.model.hive.ovirt.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "certificatesSecretRef",
    "credentialsSecretRef",
    "ovirt_cluster_id",
    "ovirt_network_name",
    "storage_domain_id"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Platform implements KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef;
    @JsonProperty("credentialsSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef;
    @JsonProperty("ovirt_cluster_id")
    private String ovirtClusterId;
    @JsonProperty("ovirt_network_name")
    private String ovirtNetworkName;
    @JsonProperty("storage_domain_id")
    private String storageDomainId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef, io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef, String ovirtClusterId, String ovirtNetworkName, String storageDomainId) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.credentialsSecretRef = credentialsSecretRef;
        this.ovirtClusterId = ovirtClusterId;
        this.ovirtNetworkName = ovirtNetworkName;
        this.storageDomainId = storageDomainId;
    }

    @JsonProperty("certificatesSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    @JsonProperty("credentialsSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    @JsonProperty("ovirt_cluster_id")
    public String getOvirtClusterId() {
        return ovirtClusterId;
    }

    @JsonProperty("ovirt_cluster_id")
    public void setOvirtClusterId(String ovirtClusterId) {
        this.ovirtClusterId = ovirtClusterId;
    }

    @JsonProperty("ovirt_network_name")
    public String getOvirtNetworkName() {
        return ovirtNetworkName;
    }

    @JsonProperty("ovirt_network_name")
    public void setOvirtNetworkName(String ovirtNetworkName) {
        this.ovirtNetworkName = ovirtNetworkName;
    }

    @JsonProperty("storage_domain_id")
    public String getStorageDomainId() {
        return storageDomainId;
    }

    @JsonProperty("storage_domain_id")
    public void setStorageDomainId(String storageDomainId) {
        this.storageDomainId = storageDomainId;
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
