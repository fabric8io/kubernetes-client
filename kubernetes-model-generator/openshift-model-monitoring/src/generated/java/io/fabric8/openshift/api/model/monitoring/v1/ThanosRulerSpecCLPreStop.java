
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
    "exec",
    "httpGet",
    "sleep",
    "tcpSocket"
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
public class ThanosRulerSpecCLPreStop implements Editable<ThanosRulerSpecCLPreStopBuilder> , KubernetesResource
{

    @JsonProperty("exec")
    private ThanosRulerSpecCLPSExec_1 exec;
    @JsonProperty("httpGet")
    private ThanosRulerSpecCLPSHttpGet_1 httpGet;
    @JsonProperty("sleep")
    private ThanosRulerSpecCLPSSleep_1 sleep;
    @JsonProperty("tcpSocket")
    private ThanosRulerSpecCLPSTcpSocket_1 tcpSocket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecCLPreStop() {
    }

    public ThanosRulerSpecCLPreStop(ThanosRulerSpecCLPSExec_1 exec, ThanosRulerSpecCLPSHttpGet_1 httpGet, ThanosRulerSpecCLPSSleep_1 sleep, ThanosRulerSpecCLPSTcpSocket_1 tcpSocket) {
        super();
        this.exec = exec;
        this.httpGet = httpGet;
        this.sleep = sleep;
        this.tcpSocket = tcpSocket;
    }

    @JsonProperty("exec")
    public ThanosRulerSpecCLPSExec_1 getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(ThanosRulerSpecCLPSExec_1 exec) {
        this.exec = exec;
    }

    @JsonProperty("httpGet")
    public ThanosRulerSpecCLPSHttpGet_1 getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(ThanosRulerSpecCLPSHttpGet_1 httpGet) {
        this.httpGet = httpGet;
    }

    @JsonProperty("sleep")
    public ThanosRulerSpecCLPSSleep_1 getSleep() {
        return sleep;
    }

    @JsonProperty("sleep")
    public void setSleep(ThanosRulerSpecCLPSSleep_1 sleep) {
        this.sleep = sleep;
    }

    @JsonProperty("tcpSocket")
    public ThanosRulerSpecCLPSTcpSocket_1 getTcpSocket() {
        return tcpSocket;
    }

    @JsonProperty("tcpSocket")
    public void setTcpSocket(ThanosRulerSpecCLPSTcpSocket_1 tcpSocket) {
        this.tcpSocket = tcpSocket;
    }

    @JsonIgnore
    public ThanosRulerSpecCLPreStopBuilder edit() {
        return new ThanosRulerSpecCLPreStopBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecCLPreStopBuilder toBuilder() {
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
