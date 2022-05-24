
package io.fabric8.istio.api.internal.protobuf.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import io.fabric8.istio.api.internal.protobuf.types.ValueBoolValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueListValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueNullValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueNumberValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueStringValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueStructValue;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
@JsonSubTypes({
    @JsonSubTypes.Type(ValueNullValue.class),
    @JsonSubTypes.Type(ValueNumberValue.class),
    @JsonSubTypes.Type(ValueStringValue.class),
    @JsonSubTypes.Type(ValueBoolValue.class),
    @JsonSubTypes.Type(ValueStructValue.class),
    @JsonSubTypes.Type(ValueListValue.class)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
public interface IsValueKind {


}
