
package io.fabric8.istio.api.telemetry.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum MetricSelectorIstioMetric {

    ALL_METRICS(0),
    REQUEST_COUNT(1),
    REQUEST_DURATION(2),
    REQUEST_SIZE(3),
    RESPONSE_SIZE(4),
    TCP_OPENED_CONNECTIONS(5),
    TCP_CLOSED_CONNECTIONS(6),
    TCP_SENT_BYTES(7),
    TCP_RECEIVED_BYTES(8),
    GRPC_REQUEST_MESSAGES(9),
    GRPC_RESPONSE_MESSAGES(10);
    private final Integer value;
    private final static Map<Integer, MetricSelectorIstioMetric> CONSTANTS = new HashMap<Integer, MetricSelectorIstioMetric>();
    private final static Map<String, MetricSelectorIstioMetric> NAME_CONSTANTS = new HashMap<String, MetricSelectorIstioMetric>();

    static {
        for (MetricSelectorIstioMetric c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (MetricSelectorIstioMetric c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    MetricSelectorIstioMetric(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static MetricSelectorIstioMetric fromValue(Object value) {
        if (value instanceof String) {
            {
                MetricSelectorIstioMetric constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        MetricSelectorIstioMetric constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
