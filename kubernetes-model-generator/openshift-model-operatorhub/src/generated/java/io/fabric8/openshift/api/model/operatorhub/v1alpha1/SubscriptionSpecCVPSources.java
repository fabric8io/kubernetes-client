
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
public class SubscriptionSpecCVPSources implements Editable<SubscriptionSpecCVPSourcesBuilder> , KubernetesResource
{

    @JsonProperty("clusterTrustBundle")
    private SubscriptionSpecCVPSClusterTrustBundle clusterTrustBundle;
    @JsonProperty("configMap")
    private SubscriptionSpecCVPSConfigMap configMap;
    @JsonProperty("downwardAPI")
    private SubscriptionSpecCVPSDownwardAPI downwardAPI;
    @JsonProperty("secret")
    private SubscriptionSpecCVPSSecret secret;
    @JsonProperty("serviceAccountToken")
    private SubscriptionSpecCVPSServiceAccountToken serviceAccountToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpecCVPSources() {
    }

    public SubscriptionSpecCVPSources(SubscriptionSpecCVPSClusterTrustBundle clusterTrustBundle, SubscriptionSpecCVPSConfigMap configMap, SubscriptionSpecCVPSDownwardAPI downwardAPI, SubscriptionSpecCVPSSecret secret, SubscriptionSpecCVPSServiceAccountToken serviceAccountToken) {
        super();
        this.clusterTrustBundle = clusterTrustBundle;
        this.configMap = configMap;
        this.downwardAPI = downwardAPI;
        this.secret = secret;
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonProperty("clusterTrustBundle")
    public SubscriptionSpecCVPSClusterTrustBundle getClusterTrustBundle() {
        return clusterTrustBundle;
    }

    @JsonProperty("clusterTrustBundle")
    public void setClusterTrustBundle(SubscriptionSpecCVPSClusterTrustBundle clusterTrustBundle) {
        this.clusterTrustBundle = clusterTrustBundle;
    }

    @JsonProperty("configMap")
    public SubscriptionSpecCVPSConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(SubscriptionSpecCVPSConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("downwardAPI")
    public SubscriptionSpecCVPSDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(SubscriptionSpecCVPSDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("secret")
    public SubscriptionSpecCVPSSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(SubscriptionSpecCVPSSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("serviceAccountToken")
    public SubscriptionSpecCVPSServiceAccountToken getServiceAccountToken() {
        return serviceAccountToken;
    }

    @JsonProperty("serviceAccountToken")
    public void setServiceAccountToken(SubscriptionSpecCVPSServiceAccountToken serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonIgnore
    public SubscriptionSpecCVPSourcesBuilder edit() {
        return new SubscriptionSpecCVPSourcesBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecCVPSourcesBuilder toBuilder() {
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
