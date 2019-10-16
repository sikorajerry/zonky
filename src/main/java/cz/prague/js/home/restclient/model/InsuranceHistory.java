package cz.prague.js.home.restclient.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class InsuranceHistory implements Serializable {

    private String policyPeriodFrom;
    private String policyPeriodTo;

}