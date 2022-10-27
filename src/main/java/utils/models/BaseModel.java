package utils.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseModel {

}
