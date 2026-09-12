
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MetaData represents a keyand value of the metadata.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsServersFromIPPool",
    "fromAnnotations",
    "fromHostInterfaces",
    "fromLabels",
    "gatewaysFromIPPool",
    "indexes",
    "ipAddressesFromIPPool",
    "namespaces",
    "objectNames",
    "prefixesFromIPPool",
    "strings"
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
public class MetaData implements Editable<MetaDataBuilder>, KubernetesResource
{

    @JsonProperty("dnsServersFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FromPool> dnsServersFromIPPool = new ArrayList<>();
    @JsonProperty("fromAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataFromAnnotation> fromAnnotations = new ArrayList<>();
    @JsonProperty("fromHostInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataHostInterface> fromHostInterfaces = new ArrayList<>();
    @JsonProperty("fromLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataFromLabel> fromLabels = new ArrayList<>();
    @JsonProperty("gatewaysFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FromPool> gatewaysFromIPPool = new ArrayList<>();
    @JsonProperty("indexes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataIndex> indexes = new ArrayList<>();
    @JsonProperty("ipAddressesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FromPool> ipAddressesFromIPPool = new ArrayList<>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataNamespace> namespaces = new ArrayList<>();
    @JsonProperty("objectNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataObjectName> objectNames = new ArrayList<>();
    @JsonProperty("prefixesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FromPool> prefixesFromIPPool = new ArrayList<>();
    @JsonProperty("strings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetaDataString> strings = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetaData() {
    }

    public MetaData(List<FromPool> dnsServersFromIPPool, List<MetaDataFromAnnotation> fromAnnotations, List<MetaDataHostInterface> fromHostInterfaces, List<MetaDataFromLabel> fromLabels, List<FromPool> gatewaysFromIPPool, List<MetaDataIndex> indexes, List<FromPool> ipAddressesFromIPPool, List<MetaDataNamespace> namespaces, List<MetaDataObjectName> objectNames, List<FromPool> prefixesFromIPPool, List<MetaDataString> strings) {
        super();
        this.dnsServersFromIPPool = dnsServersFromIPPool;
        this.fromAnnotations = fromAnnotations;
        this.fromHostInterfaces = fromHostInterfaces;
        this.fromLabels = fromLabels;
        this.gatewaysFromIPPool = gatewaysFromIPPool;
        this.indexes = indexes;
        this.ipAddressesFromIPPool = ipAddressesFromIPPool;
        this.namespaces = namespaces;
        this.objectNames = objectNames;
        this.prefixesFromIPPool = prefixesFromIPPool;
        this.strings = strings;
    }

    /**
     * DNSServersFromPool is the list of metadata items to be rendered as dns servers.
     */
    @JsonProperty("dnsServersFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getDnsServersFromIPPool() {
        return dnsServersFromIPPool;
    }

    /**
     * DNSServersFromPool is the list of metadata items to be rendered as dns servers.
     */
    @JsonProperty("dnsServersFromIPPool")
    public void setDnsServersFromIPPool(List<FromPool> dnsServersFromIPPool) {
        this.dnsServersFromIPPool = dnsServersFromIPPool;
    }

    /**
     * FromAnnotations is the list of metadata items to be fetched from object Annotations
     */
    @JsonProperty("fromAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataFromAnnotation> getFromAnnotations() {
        return fromAnnotations;
    }

    /**
     * FromAnnotations is the list of metadata items to be fetched from object Annotations
     */
    @JsonProperty("fromAnnotations")
    public void setFromAnnotations(List<MetaDataFromAnnotation> fromAnnotations) {
        this.fromAnnotations = fromAnnotations;
    }

    /**
     * FromHostInterfaces is the list of metadata items to be rendered as MAC addresses of the host interfaces.
     */
    @JsonProperty("fromHostInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataHostInterface> getFromHostInterfaces() {
        return fromHostInterfaces;
    }

    /**
     * FromHostInterfaces is the list of metadata items to be rendered as MAC addresses of the host interfaces.
     */
    @JsonProperty("fromHostInterfaces")
    public void setFromHostInterfaces(List<MetaDataHostInterface> fromHostInterfaces) {
        this.fromHostInterfaces = fromHostInterfaces;
    }

    /**
     * FromLabels is the list of metadata items to be fetched from object labels
     */
    @JsonProperty("fromLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataFromLabel> getFromLabels() {
        return fromLabels;
    }

    /**
     * FromLabels is the list of metadata items to be fetched from object labels
     */
    @JsonProperty("fromLabels")
    public void setFromLabels(List<MetaDataFromLabel> fromLabels) {
        this.fromLabels = fromLabels;
    }

    /**
     * GatewaysFromPool is the list of metadata items to be rendered as gateway addresses.
     */
    @JsonProperty("gatewaysFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getGatewaysFromIPPool() {
        return gatewaysFromIPPool;
    }

    /**
     * GatewaysFromPool is the list of metadata items to be rendered as gateway addresses.
     */
    @JsonProperty("gatewaysFromIPPool")
    public void setGatewaysFromIPPool(List<FromPool> gatewaysFromIPPool) {
        this.gatewaysFromIPPool = gatewaysFromIPPool;
    }

    /**
     * Indexes is the list of metadata items to be rendered from the index of the Metal3Data
     */
    @JsonProperty("indexes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataIndex> getIndexes() {
        return indexes;
    }

    /**
     * Indexes is the list of metadata items to be rendered from the index of the Metal3Data
     */
    @JsonProperty("indexes")
    public void setIndexes(List<MetaDataIndex> indexes) {
        this.indexes = indexes;
    }

    /**
     * IPAddressesFromPool is the list of metadata items to be rendered as ip addresses.
     */
    @JsonProperty("ipAddressesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getIpAddressesFromIPPool() {
        return ipAddressesFromIPPool;
    }

    /**
     * IPAddressesFromPool is the list of metadata items to be rendered as ip addresses.
     */
    @JsonProperty("ipAddressesFromIPPool")
    public void setIpAddressesFromIPPool(List<FromPool> ipAddressesFromIPPool) {
        this.ipAddressesFromIPPool = ipAddressesFromIPPool;
    }

    /**
     * Namespaces is the list of metadata items to be rendered from the namespace
     */
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataNamespace> getNamespaces() {
        return namespaces;
    }

    /**
     * Namespaces is the list of metadata items to be rendered from the namespace
     */
    @JsonProperty("namespaces")
    public void setNamespaces(List<MetaDataNamespace> namespaces) {
        this.namespaces = namespaces;
    }

    /**
     * ObjectNames is the list of metadata items to be rendered from the name of objects.
     */
    @JsonProperty("objectNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataObjectName> getObjectNames() {
        return objectNames;
    }

    /**
     * ObjectNames is the list of metadata items to be rendered from the name of objects.
     */
    @JsonProperty("objectNames")
    public void setObjectNames(List<MetaDataObjectName> objectNames) {
        this.objectNames = objectNames;
    }

    /**
     * PrefixesFromPool is the list of metadata items to be rendered as network prefixes.
     */
    @JsonProperty("prefixesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getPrefixesFromIPPool() {
        return prefixesFromIPPool;
    }

    /**
     * PrefixesFromPool is the list of metadata items to be rendered as network prefixes.
     */
    @JsonProperty("prefixesFromIPPool")
    public void setPrefixesFromIPPool(List<FromPool> prefixesFromIPPool) {
        this.prefixesFromIPPool = prefixesFromIPPool;
    }

    /**
     * Strings is the list of metadata items to be rendered from strings
     */
    @JsonProperty("strings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataString> getStrings() {
        return strings;
    }

    /**
     * Strings is the list of metadata items to be rendered from strings
     */
    @JsonProperty("strings")
    public void setStrings(List<MetaDataString> strings) {
        this.strings = strings;
    }

    @JsonIgnore
    public MetaDataBuilder edit() {
        return new MetaDataBuilder(this);
    }

    @JsonIgnore
    public MetaDataBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MetaData)) {
            return false;
        }
        MetaData other = (MetaData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsServersFromIPPool = this.getDnsServersFromIPPool();
        Object other$dnsServersFromIPPool = other.getDnsServersFromIPPool();
        if (this$dnsServersFromIPPool == null ? other$dnsServersFromIPPool != null : !this$dnsServersFromIPPool.equals(other$dnsServersFromIPPool)) {
            return false;
        }
        Object this$fromAnnotations = this.getFromAnnotations();
        Object other$fromAnnotations = other.getFromAnnotations();
        if (this$fromAnnotations == null ? other$fromAnnotations != null : !this$fromAnnotations.equals(other$fromAnnotations)) {
            return false;
        }
        Object this$fromHostInterfaces = this.getFromHostInterfaces();
        Object other$fromHostInterfaces = other.getFromHostInterfaces();
        if (this$fromHostInterfaces == null ? other$fromHostInterfaces != null : !this$fromHostInterfaces.equals(other$fromHostInterfaces)) {
            return false;
        }
        Object this$fromLabels = this.getFromLabels();
        Object other$fromLabels = other.getFromLabels();
        if (this$fromLabels == null ? other$fromLabels != null : !this$fromLabels.equals(other$fromLabels)) {
            return false;
        }
        Object this$gatewaysFromIPPool = this.getGatewaysFromIPPool();
        Object other$gatewaysFromIPPool = other.getGatewaysFromIPPool();
        if (this$gatewaysFromIPPool == null ? other$gatewaysFromIPPool != null : !this$gatewaysFromIPPool.equals(other$gatewaysFromIPPool)) {
            return false;
        }
        Object this$indexes = this.getIndexes();
        Object other$indexes = other.getIndexes();
        if (this$indexes == null ? other$indexes != null : !this$indexes.equals(other$indexes)) {
            return false;
        }
        Object this$ipAddressesFromIPPool = this.getIpAddressesFromIPPool();
        Object other$ipAddressesFromIPPool = other.getIpAddressesFromIPPool();
        if (this$ipAddressesFromIPPool == null ? other$ipAddressesFromIPPool != null : !this$ipAddressesFromIPPool.equals(other$ipAddressesFromIPPool)) {
            return false;
        }
        Object this$namespaces = this.getNamespaces();
        Object other$namespaces = other.getNamespaces();
        if (this$namespaces == null ? other$namespaces != null : !this$namespaces.equals(other$namespaces)) {
            return false;
        }
        Object this$objectNames = this.getObjectNames();
        Object other$objectNames = other.getObjectNames();
        if (this$objectNames == null ? other$objectNames != null : !this$objectNames.equals(other$objectNames)) {
            return false;
        }
        Object this$prefixesFromIPPool = this.getPrefixesFromIPPool();
        Object other$prefixesFromIPPool = other.getPrefixesFromIPPool();
        if (this$prefixesFromIPPool == null ? other$prefixesFromIPPool != null : !this$prefixesFromIPPool.equals(other$prefixesFromIPPool)) {
            return false;
        }
        Object this$strings = this.getStrings();
        Object other$strings = other.getStrings();
        if (this$strings == null ? other$strings != null : !this$strings.equals(other$strings)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof MetaData;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsServersFromIPPool = this.getDnsServersFromIPPool();
        result = result * prime + ($dnsServersFromIPPool == null ? 43 : $dnsServersFromIPPool.hashCode());
        Object $fromAnnotations = this.getFromAnnotations();
        result = result * prime + ($fromAnnotations == null ? 43 : $fromAnnotations.hashCode());
        Object $fromHostInterfaces = this.getFromHostInterfaces();
        result = result * prime + ($fromHostInterfaces == null ? 43 : $fromHostInterfaces.hashCode());
        Object $fromLabels = this.getFromLabels();
        result = result * prime + ($fromLabels == null ? 43 : $fromLabels.hashCode());
        Object $gatewaysFromIPPool = this.getGatewaysFromIPPool();
        result = result * prime + ($gatewaysFromIPPool == null ? 43 : $gatewaysFromIPPool.hashCode());
        Object $indexes = this.getIndexes();
        result = result * prime + ($indexes == null ? 43 : $indexes.hashCode());
        Object $ipAddressesFromIPPool = this.getIpAddressesFromIPPool();
        result = result * prime + ($ipAddressesFromIPPool == null ? 43 : $ipAddressesFromIPPool.hashCode());
        Object $namespaces = this.getNamespaces();
        result = result * prime + ($namespaces == null ? 43 : $namespaces.hashCode());
        Object $objectNames = this.getObjectNames();
        result = result * prime + ($objectNames == null ? 43 : $objectNames.hashCode());
        Object $prefixesFromIPPool = this.getPrefixesFromIPPool();
        result = result * prime + ($prefixesFromIPPool == null ? 43 : $prefixesFromIPPool.hashCode());
        Object $strings = this.getStrings();
        result = result * prime + ($strings == null ? 43 : $strings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetaData(" + "dnsServersFromIPPool=" + this.getDnsServersFromIPPool() + ", fromAnnotations=" + this.getFromAnnotations() + ", fromHostInterfaces=" + this.getFromHostInterfaces() + ", fromLabels=" + this.getFromLabels() + ", gatewaysFromIPPool=" + this.getGatewaysFromIPPool() + ", indexes=" + this.getIndexes() + ", ipAddressesFromIPPool=" + this.getIpAddressesFromIPPool() + ", namespaces=" + this.getNamespaces() + ", objectNames=" + this.getObjectNames() + ", prefixesFromIPPool=" + this.getPrefixesFromIPPool() + ", strings=" + this.getStrings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
