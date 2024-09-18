
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterTrustBundle",
    "configMap",
    "downwardAPI",
    "secret",
    "serviceAccountToken"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterServiceVersionSpecISpecDSpecTSpecVPSources implements Editable<ClusterServiceVersionSpecISpecDSpecTSpecVPSourcesBuilder> , KubernetesResource
{

    @JsonProperty("clusterTrustBundle")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPSClusterTrustBundle clusterTrustBundle;
    @JsonProperty("configMap")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPSConfigMap configMap;
    @JsonProperty("downwardAPI")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPSDownwardAPI downwardAPI;
    @JsonProperty("secret")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPSSecret secret;
    @JsonProperty("serviceAccountToken")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPSServiceAccountToken serviceAccountToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSources() {
    }

    public ClusterServiceVersionSpecISpecDSpecTSpecVPSources(ClusterServiceVersionSpecISpecDSpecTSpecVPSClusterTrustBundle clusterTrustBundle, ClusterServiceVersionSpecISpecDSpecTSpecVPSConfigMap configMap, ClusterServiceVersionSpecISpecDSpecTSpecVPSDownwardAPI downwardAPI, ClusterServiceVersionSpecISpecDSpecTSpecVPSSecret secret, ClusterServiceVersionSpecISpecDSpecTSpecVPSServiceAccountToken serviceAccountToken) {
        super();
        this.clusterTrustBundle = clusterTrustBundle;
        this.configMap = configMap;
        this.downwardAPI = downwardAPI;
        this.secret = secret;
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonProperty("clusterTrustBundle")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSClusterTrustBundle getClusterTrustBundle() {
        return clusterTrustBundle;
    }

    @JsonProperty("clusterTrustBundle")
    public void setClusterTrustBundle(ClusterServiceVersionSpecISpecDSpecTSpecVPSClusterTrustBundle clusterTrustBundle) {
        this.clusterTrustBundle = clusterTrustBundle;
    }

    @JsonProperty("configMap")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ClusterServiceVersionSpecISpecDSpecTSpecVPSConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("downwardAPI")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(ClusterServiceVersionSpecISpecDSpecTSpecVPSDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("secret")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(ClusterServiceVersionSpecISpecDSpecTSpecVPSSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("serviceAccountToken")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSServiceAccountToken getServiceAccountToken() {
        return serviceAccountToken;
    }

    @JsonProperty("serviceAccountToken")
    public void setServiceAccountToken(ClusterServiceVersionSpecISpecDSpecTSpecVPSServiceAccountToken serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSourcesBuilder edit() {
        return new ClusterServiceVersionSpecISpecDSpecTSpecVPSourcesBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVPSourcesBuilder toBuilder() {
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
