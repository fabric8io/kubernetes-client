
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum CaptureMode {

    DEFAULT(0),
    IPTABLES(1),
    NONE(2);
    private final Integer value;
    private final static Map<Integer, CaptureMode> CONSTANTS = new HashMap<Integer, CaptureMode>();
    private final static Map<String, CaptureMode> NAME_CONSTANTS = new HashMap<String, CaptureMode>();

    static {
        for (CaptureMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (CaptureMode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    CaptureMode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static CaptureMode fromValue(Object value) {
        if (value instanceof String) {
            {
                CaptureMode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        CaptureMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
