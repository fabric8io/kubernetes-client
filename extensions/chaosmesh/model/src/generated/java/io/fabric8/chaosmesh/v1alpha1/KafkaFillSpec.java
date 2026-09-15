
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "maxBytes",
    "messageSize",
    "password",
    "port",
    "reloadCommand",
    "topic",
    "username"
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
public class KafkaFillSpec implements Editable<KafkaFillSpecBuilder>, KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("maxBytes")
    private Long maxBytes;
    @JsonProperty("messageSize")
    private Integer messageSize;
    @JsonProperty("password")
    private String password;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("reloadCommand")
    private String reloadCommand;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaFillSpec() {
    }

    public KafkaFillSpec(String host, Long maxBytes, Integer messageSize, String password, Integer port, String reloadCommand, String topic, String username) {
        super();
        this.host = host;
        this.maxBytes = maxBytes;
        this.messageSize = messageSize;
        this.password = password;
        this.port = port;
        this.reloadCommand = reloadCommand;
        this.topic = topic;
        this.username = username;
    }

    /**
     * The host of kafka server
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * The host of kafka server
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * The max bytes to fill
     */
    @JsonProperty("maxBytes")
    public Long getMaxBytes() {
        return maxBytes;
    }

    /**
     * The max bytes to fill
     */
    @JsonProperty("maxBytes")
    public void setMaxBytes(Long maxBytes) {
        this.maxBytes = maxBytes;
    }

    /**
     * The size of each message
     */
    @JsonProperty("messageSize")
    public Integer getMessageSize() {
        return messageSize;
    }

    /**
     * The size of each message
     */
    @JsonProperty("messageSize")
    public void setMessageSize(Integer messageSize) {
        this.messageSize = messageSize;
    }

    /**
     * The password of kafka client
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * The password of kafka client
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The port of kafka server
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * The port of kafka server
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * The command to reload kafka config
     */
    @JsonProperty("reloadCommand")
    public String getReloadCommand() {
        return reloadCommand;
    }

    /**
     * The command to reload kafka config
     */
    @JsonProperty("reloadCommand")
    public void setReloadCommand(String reloadCommand) {
        this.reloadCommand = reloadCommand;
    }

    /**
     * The topic to attack
     */
    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    /**
     * The topic to attack
     */
    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * The username of kafka client
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * The username of kafka client
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public KafkaFillSpecBuilder edit() {
        return new KafkaFillSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaFillSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaFillSpec)) {
            return false;
        }
        KafkaFillSpec other = (KafkaFillSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$maxBytes = this.getMaxBytes();
        Object other$maxBytes = other.getMaxBytes();
        if (this$maxBytes == null ? other$maxBytes != null : !this$maxBytes.equals(other$maxBytes)) {
            return false;
        }
        Object this$messageSize = this.getMessageSize();
        Object other$messageSize = other.getMessageSize();
        if (this$messageSize == null ? other$messageSize != null : !this$messageSize.equals(other$messageSize)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$reloadCommand = this.getReloadCommand();
        Object other$reloadCommand = other.getReloadCommand();
        if (this$reloadCommand == null ? other$reloadCommand != null : !this$reloadCommand.equals(other$reloadCommand)) {
            return false;
        }
        Object this$topic = this.getTopic();
        Object other$topic = other.getTopic();
        if (this$topic == null ? other$topic != null : !this$topic.equals(other$topic)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof KafkaFillSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $maxBytes = this.getMaxBytes();
        result = result * prime + ($maxBytes == null ? 43 : $maxBytes.hashCode());
        Object $messageSize = this.getMessageSize();
        result = result * prime + ($messageSize == null ? 43 : $messageSize.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $reloadCommand = this.getReloadCommand();
        result = result * prime + ($reloadCommand == null ? 43 : $reloadCommand.hashCode());
        Object $topic = this.getTopic();
        result = result * prime + ($topic == null ? 43 : $topic.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaFillSpec(" + "host=" + this.getHost() + ", maxBytes=" + this.getMaxBytes() + ", messageSize=" + this.getMessageSize() + ", password=" + this.getPassword() + ", port=" + this.getPort() + ", reloadCommand=" + this.getReloadCommand() + ", topic=" + this.getTopic() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
