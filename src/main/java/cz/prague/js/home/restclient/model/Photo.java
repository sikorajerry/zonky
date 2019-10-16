package cz.prague.js.home.restclient.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Photo implements Serializable {

    private String name;
    private String url;
}