package com.reggie.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

/**
 * @author: yuncheng.xie
 * @date: 9/22/20 5:19 PM
 * description:
 */
@Slf4j
public class JsonUtil {
    public static final ObjectMapper MAPPER = initObjectMapper(true);
    public static final ObjectMapper MAPPER_WITHOUT_NULL = initObjectMapper(false);

    public static <T> T toObject(String json, Class<T> clazz) {
        if (null == json) {
            return null;
        }

        try {
            if (clazz.isAssignableFrom(String.class)) {
                return (T) json;
            } else if ("".equals(json)) {
                return null;
            }
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize json to type " + clazz.getSimpleName() + ": " + json, e);
        }
    }

    public static <T> T deserialize(byte[] source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        try {
            return JsonUtil.MAPPER.readValue(source, clazz);
        } catch (IOException e) {
            throw new RuntimeException("fail to deserialize {}: " + clazz.getSimpleName() + new String(source), e);
        }
    }

    public static <T> T toObject(byte[] bytes, Class<T> clazz) {
        return toObject(bytes, 0, bytes.length, clazz);
    }

    public static <T> T toObject(byte[] bytes, int offset, int len, Class<T> clazz) {
        if (null == bytes) {
            return null;
        }

        try {
            if (clazz.isAssignableFrom(String.class)) {
                return (T) new String(bytes, offset, len);
            } else if (bytes.length == 0) {
                return null;
            }

            return MAPPER.readValue(bytes, offset, len, clazz);
        } catch (Exception e) {
            log.error("", e);
            throw new RuntimeException("Failed to deserialize json to type " + clazz.getSimpleName() + ": " + new String(bytes), e);
        }
    }

    public static <T> T toObject(String json, TypeReference<T> typeRef) {
        if (null == json) {
            return null;
        }

        try {
            if ("String".equals(typeRef.getType().getTypeName())) {
                return (T) json;
            } else if ("".equals(json)) {
                return null;
            }

            return MAPPER.readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize json to type " + typeRef.getType().getTypeName() + ": " + json, e);
        }
    }

    public static <T> List<T> toList(byte[] bytes, Class<T> clazz) {
        if (null == bytes || bytes.length == 0) {
            return Collections.emptyList();
        }

        try {
            return JsonUtil.MAPPER.readValue(bytes, new TypeReference<List<T>>() {
                @Override
                public Type getType() {
                    return ParameterizedTypeImpl.make(List.class, new Type[]{clazz}, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize json to type " + clazz.getSimpleName() + ": " + new String(bytes), e);
        }
    }

    public static <T> List<T> toList(byte[][] allBytes, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (allBytes != null && allBytes.length > 0) {
            for (int i = 0; i < allBytes.length; i++) {
                byte[] bytes = allBytes[i];
                if (bytes != null && bytes.length > 0) {
                    list.add(JsonUtil.toObject(bytes, clazz));
                }
            }
        }
        return list;
    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return Collections.emptyList();
        }

        try {
            return JsonUtil.MAPPER.readValue(json, new TypeReference<List<T>>() {
                @Override
                public Type getType() {
                    return ParameterizedTypeImpl.make(List.class, new Type[]{clazz}, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize json to type " + clazz.getSimpleName() + ": " + json, e);
        }
    }

    public static String toJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize object: " + o.toString(), e);
        }
    }

    public static String toSnakeJson(Object o) {

        try {
            PropertyNamingStrategy origion = MAPPER.getPropertyNamingStrategy();
            MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            String s = MAPPER.writeValueAsString(o);
            MAPPER.setPropertyNamingStrategy(origion);
            return s;
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize object: " + o.toString(), e);
        }
    }

    public static String toJsonWithoutNull(Object o) {
        try {
            return MAPPER_WITHOUT_NULL.writeValueAsString(o);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize object: " + o.toString(), e);
        }
    }

    public static byte[] toJsonBytes(Object o) {
        try {
            return MAPPER.writeValueAsBytes(o);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize object: " + o.toString(), e);
        }
    }

    /**
     * 把对象生成为key值没有双引号的json
     *
     * @param o
     * @return
     * @throws JsonProcessingException
     */
    public static String toUnquotedJson(Object o) throws JsonProcessingException {
        MAPPER.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
        String nonStandardJson = MAPPER.writeValueAsString(o);
        MAPPER.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        return nonStandardJson;
    }

    /**
     * 把json object里name/value中name值没有双引号的非标准json转为对象
     * 如把{aName:"value"}转为对Java对象
     *
     * @param content
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T allowUnquotedFieldJsonToObject(String content, Class<T> clazz) throws IOException {
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        T result = MAPPER.readValue(content, clazz);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);
        return result;
    }

    public static ObjectMapper initObjectMapper(boolean nullable) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (!nullable) {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        }
        objectMapper.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        class DateJsonSerializer extends JsonSerializer<Date> {
            @Override
            public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(DateUtil.toString(DateUtil.toLocalDate(value)));
            }
        }

        class DateJsonDeserializer extends JsonDeserializer<Date> {

            @Override
            public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return DateUtil.toDate(DateUtil.fromString(p.getValueAsString()));
            }
        }
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(Date.class, new DateJsonSerializer());
        javaTimeModule.addDeserializer(Date.class, new DateJsonDeserializer());

        class LocalDateJsonDeserializer extends JsonDeserializer<LocalDate> {
            @Override
            public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return DateUtil.fromString(p.getValueAsString());
            }
        }
        javaTimeModule.addSerializer(YearMonth.class, new YearMonthSerializer(DateUtil.DatePattern.MONTH.getFormatter()));
        javaTimeModule.addDeserializer(YearMonth.class, new YearMonthDeserializer(DateUtil.DatePattern.MONTH.getFormatter()));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateJsonDeserializer());
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateUtil.DatePattern.SECOND.getFormatter()));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateUtil.DatePattern.SECOND.getFormatter()));

        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

    public static <T> T map2Object(LinkedHashMap map, Class<T> t) {
        return MAPPER.convertValue(map, t);
    }

    private static String tryTranslateToCamelCase(String name) {

        char[] cs = name.toCharArray();
        int len = cs.length;
        // 下划线转驼峰
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == '_') {
                char cn;
                if (++i < len && (cn = cs[i]) != '_') {
                    sb.append(Character.toUpperCase(cn));
                }
            } else {
                if (c < 91 && c > 64) {
                    c += 32;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static JsonNode toJsonNode(String value) {
        try {
            return MAPPER.readTree(value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to serialize object: " + value);
        }
    }

    public static String getValue(String key, JsonNode jsonNode) {
        if (null == jsonNode) {
            return null;
        }
        if (jsonNode.has(key)) {
            return jsonNode.get(key).textValue();
        }
        if (jsonNode.isValueNode()) {
            return null;
        }
        if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                String value = getValue(key, entry.getValue());
                if (StringUtils.isNotEmpty(value)) {
                    return value;
                }
            }
            return null;
        }

        if (jsonNode.isArray()) {
            Iterator<JsonNode> iterator = jsonNode.iterator();
            while (iterator.hasNext()) {
                String value = getValue(key, iterator.next());
                if (StringUtils.isNotEmpty(value)) {
                    return value;
                }
            }
            return null;
        }
        return null;
    }

}