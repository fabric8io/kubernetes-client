
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bindAddress",
    "iptablesSyncPeriod",
    "proxyArguments"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ProxyConfig implements KubernetesResource
{

    @JsonProperty("bindAddress")
    private java.lang.String bindAddress;
    @JsonProperty("iptablesSyncPeriod")
    private java.lang.String iptablesSyncPeriod;
    @JsonProperty("proxyArguments")
    private Map<String, ArrayList<String>> proxyArguments;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProxyConfig() {
    }

    /**
     * 
     * @param iptablesSyncPeriod
     * @param proxyArguments
     * @param bindAddress
     */
    public ProxyConfig(java.lang.String bindAddress, java.lang.String iptablesSyncPeriod, Map<String, ArrayList<String>> proxyArguments) {
        super();
        this.bindAddress = bindAddress;
        this.iptablesSyncPeriod = iptablesSyncPeriod;
        this.proxyArguments = proxyArguments;
    }

    @JsonProperty("bindAddress")
    public java.lang.String getBindAddress() {
        return bindAddress;
    }

    @JsonProperty("bindAddress")
    public void setBindAddress(java.lang.String bindAddress) {
        this.bindAddress = bindAddress;
    }

    @JsonProperty("iptablesSyncPeriod")
    public java.lang.String getIptablesSyncPeriod() {
        return iptablesSyncPeriod;
    }

    @JsonProperty("iptablesSyncPeriod")
    public void setIptablesSyncPeriod(java.lang.String iptablesSyncPeriod) {
        this.iptablesSyncPeriod = iptablesSyncPeriod;
    }

    @JsonProperty("proxyArguments")
    public Map<String, ArrayList<String>> getProxyArguments() {
        return proxyArguments;
    }

    @JsonProperty("proxyArguments")
    public void setProxyArguments(Map<String, ArrayList<String>> proxyArguments) {
        this.proxyArguments = proxyArguments;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
