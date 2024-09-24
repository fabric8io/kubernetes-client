
package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ThanosRulerSpecVPSources implements Editable<ThanosRulerSpecVPSourcesBuilder> , KubernetesResource
{

    @JsonProperty("clusterTrustBundle")
    private ThanosRulerSpecVPSClusterTrustBundle clusterTrustBundle;
    @JsonProperty("configMap")
    private ThanosRulerSpecVPSConfigMap configMap;
    @JsonProperty("downwardAPI")
    private ThanosRulerSpecVPSDownwardAPI downwardAPI;
    @JsonProperty("secret")
    private ThanosRulerSpecVPSSecret secret;
    @JsonProperty("serviceAccountToken")
    private ThanosRulerSpecVPSServiceAccountToken serviceAccountToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecVPSources() {
    }

    public ThanosRulerSpecVPSources(ThanosRulerSpecVPSClusterTrustBundle clusterTrustBundle, ThanosRulerSpecVPSConfigMap configMap, ThanosRulerSpecVPSDownwardAPI downwardAPI, ThanosRulerSpecVPSSecret secret, ThanosRulerSpecVPSServiceAccountToken serviceAccountToken) {
        super();
        this.clusterTrustBundle = clusterTrustBundle;
        this.configMap = configMap;
        this.downwardAPI = downwardAPI;
        this.secret = secret;
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonProperty("clusterTrustBundle")
    public ThanosRulerSpecVPSClusterTrustBundle getClusterTrustBundle() {
        return clusterTrustBundle;
    }

    @JsonProperty("clusterTrustBundle")
    public void setClusterTrustBundle(ThanosRulerSpecVPSClusterTrustBundle clusterTrustBundle) {
        this.clusterTrustBundle = clusterTrustBundle;
    }

    @JsonProperty("configMap")
    public ThanosRulerSpecVPSConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ThanosRulerSpecVPSConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("downwardAPI")
    public ThanosRulerSpecVPSDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(ThanosRulerSpecVPSDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("secret")
    public ThanosRulerSpecVPSSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(ThanosRulerSpecVPSSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("serviceAccountToken")
    public ThanosRulerSpecVPSServiceAccountToken getServiceAccountToken() {
        return serviceAccountToken;
    }

    @JsonProperty("serviceAccountToken")
    public void setServiceAccountToken(ThanosRulerSpecVPSServiceAccountToken serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonIgnore
    public ThanosRulerSpecVPSourcesBuilder edit() {
        return new ThanosRulerSpecVPSourcesBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecVPSourcesBuilder toBuilder() {
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
