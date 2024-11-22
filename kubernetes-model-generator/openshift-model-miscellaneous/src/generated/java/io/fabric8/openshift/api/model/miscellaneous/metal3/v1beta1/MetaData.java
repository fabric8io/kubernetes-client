
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class MetaData implements Editable<MetaDataBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("dnsServersFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getDnsServersFromIPPool() {
        return dnsServersFromIPPool;
    }

    @JsonProperty("dnsServersFromIPPool")
    public void setDnsServersFromIPPool(List<FromPool> dnsServersFromIPPool) {
        this.dnsServersFromIPPool = dnsServersFromIPPool;
    }

    @JsonProperty("fromAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataFromAnnotation> getFromAnnotations() {
        return fromAnnotations;
    }

    @JsonProperty("fromAnnotations")
    public void setFromAnnotations(List<MetaDataFromAnnotation> fromAnnotations) {
        this.fromAnnotations = fromAnnotations;
    }

    @JsonProperty("fromHostInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataHostInterface> getFromHostInterfaces() {
        return fromHostInterfaces;
    }

    @JsonProperty("fromHostInterfaces")
    public void setFromHostInterfaces(List<MetaDataHostInterface> fromHostInterfaces) {
        this.fromHostInterfaces = fromHostInterfaces;
    }

    @JsonProperty("fromLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataFromLabel> getFromLabels() {
        return fromLabels;
    }

    @JsonProperty("fromLabels")
    public void setFromLabels(List<MetaDataFromLabel> fromLabels) {
        this.fromLabels = fromLabels;
    }

    @JsonProperty("gatewaysFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getGatewaysFromIPPool() {
        return gatewaysFromIPPool;
    }

    @JsonProperty("gatewaysFromIPPool")
    public void setGatewaysFromIPPool(List<FromPool> gatewaysFromIPPool) {
        this.gatewaysFromIPPool = gatewaysFromIPPool;
    }

    @JsonProperty("indexes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataIndex> getIndexes() {
        return indexes;
    }

    @JsonProperty("indexes")
    public void setIndexes(List<MetaDataIndex> indexes) {
        this.indexes = indexes;
    }

    @JsonProperty("ipAddressesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getIpAddressesFromIPPool() {
        return ipAddressesFromIPPool;
    }

    @JsonProperty("ipAddressesFromIPPool")
    public void setIpAddressesFromIPPool(List<FromPool> ipAddressesFromIPPool) {
        this.ipAddressesFromIPPool = ipAddressesFromIPPool;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataNamespace> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<MetaDataNamespace> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("objectNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataObjectName> getObjectNames() {
        return objectNames;
    }

    @JsonProperty("objectNames")
    public void setObjectNames(List<MetaDataObjectName> objectNames) {
        this.objectNames = objectNames;
    }

    @JsonProperty("prefixesFromIPPool")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FromPool> getPrefixesFromIPPool() {
        return prefixesFromIPPool;
    }

    @JsonProperty("prefixesFromIPPool")
    public void setPrefixesFromIPPool(List<FromPool> prefixesFromIPPool) {
        this.prefixesFromIPPool = prefixesFromIPPool;
    }

    @JsonProperty("strings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetaDataString> getStrings() {
        return strings;
    }

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
