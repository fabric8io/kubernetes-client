
package io.fabric8.istio.api.api.security.v1beta1;

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
    "ipBlocks",
    "namespaces",
    "notIpBlocks",
    "notNamespaces",
    "notPrincipals",
    "notRemoteIpBlocks",
    "notRequestPrincipals",
    "principals",
    "remoteIpBlocks",
    "requestPrincipals"
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
public class Source implements Editable<SourceBuilder> , KubernetesResource
{

    @JsonProperty("ipBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipBlocks = new ArrayList<>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonProperty("notIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notIpBlocks = new ArrayList<>();
    @JsonProperty("notNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notNamespaces = new ArrayList<>();
    @JsonProperty("notPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPrincipals = new ArrayList<>();
    @JsonProperty("notRemoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notRemoteIpBlocks = new ArrayList<>();
    @JsonProperty("notRequestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notRequestPrincipals = new ArrayList<>();
    @JsonProperty("principals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> principals = new ArrayList<>();
    @JsonProperty("remoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remoteIpBlocks = new ArrayList<>();
    @JsonProperty("requestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requestPrincipals = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    public Source(List<String> ipBlocks, List<String> namespaces, List<String> notIpBlocks, List<String> notNamespaces, List<String> notPrincipals, List<String> notRemoteIpBlocks, List<String> notRequestPrincipals, List<String> principals, List<String> remoteIpBlocks, List<String> requestPrincipals) {
        super();
        this.ipBlocks = ipBlocks;
        this.namespaces = namespaces;
        this.notIpBlocks = notIpBlocks;
        this.notNamespaces = notNamespaces;
        this.notPrincipals = notPrincipals;
        this.notRemoteIpBlocks = notRemoteIpBlocks;
        this.notRequestPrincipals = notRequestPrincipals;
        this.principals = principals;
        this.remoteIpBlocks = remoteIpBlocks;
        this.requestPrincipals = requestPrincipals;
    }

    @JsonProperty("ipBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpBlocks() {
        return ipBlocks;
    }

    @JsonProperty("ipBlocks")
    public void setIpBlocks(List<String> ipBlocks) {
        this.ipBlocks = ipBlocks;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("notIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotIpBlocks() {
        return notIpBlocks;
    }

    @JsonProperty("notIpBlocks")
    public void setNotIpBlocks(List<String> notIpBlocks) {
        this.notIpBlocks = notIpBlocks;
    }

    @JsonProperty("notNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotNamespaces() {
        return notNamespaces;
    }

    @JsonProperty("notNamespaces")
    public void setNotNamespaces(List<String> notNamespaces) {
        this.notNamespaces = notNamespaces;
    }

    @JsonProperty("notPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotPrincipals() {
        return notPrincipals;
    }

    @JsonProperty("notPrincipals")
    public void setNotPrincipals(List<String> notPrincipals) {
        this.notPrincipals = notPrincipals;
    }

    @JsonProperty("notRemoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotRemoteIpBlocks() {
        return notRemoteIpBlocks;
    }

    @JsonProperty("notRemoteIpBlocks")
    public void setNotRemoteIpBlocks(List<String> notRemoteIpBlocks) {
        this.notRemoteIpBlocks = notRemoteIpBlocks;
    }

    @JsonProperty("notRequestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotRequestPrincipals() {
        return notRequestPrincipals;
    }

    @JsonProperty("notRequestPrincipals")
    public void setNotRequestPrincipals(List<String> notRequestPrincipals) {
        this.notRequestPrincipals = notRequestPrincipals;
    }

    @JsonProperty("principals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrincipals() {
        return principals;
    }

    @JsonProperty("principals")
    public void setPrincipals(List<String> principals) {
        this.principals = principals;
    }

    @JsonProperty("remoteIpBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemoteIpBlocks() {
        return remoteIpBlocks;
    }

    @JsonProperty("remoteIpBlocks")
    public void setRemoteIpBlocks(List<String> remoteIpBlocks) {
        this.remoteIpBlocks = remoteIpBlocks;
    }

    @JsonProperty("requestPrincipals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequestPrincipals() {
        return requestPrincipals;
    }

    @JsonProperty("requestPrincipals")
    public void setRequestPrincipals(List<String> requestPrincipals) {
        this.requestPrincipals = requestPrincipals;
    }

    @JsonIgnore
    public SourceBuilder edit() {
        return new SourceBuilder(this);
    }

    @JsonIgnore
    public SourceBuilder toBuilder() {
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
