package cz.prague.js.home.restclient.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode
public class Marketplace implements Serializable {

    private Integer id;
    private String url;
    private String name;
    private String story;
    private String purpose;
    private List<Photo> photos = null;
    private Integer userId;
    private String nickName;
    private Integer termInMonths;
    private Double interestRate;
    private Double revenueRate;
    private Double annuity;
    private Integer premium;
    private String rating;
    private Boolean topped;
    private Double amount;
    private Double remainingInvestment;
    private Double investmentRate;
    private Boolean covered;
    private Double reservedAmount;
    private Double zonkyPlusAmount;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ssZZ")
    private Date datePublished;
    private Boolean published;
    private String deadline;
    private Integer myOtherInvestments;
    private Integer borrowerRelatedInvestmentInfo;
    private Integer investmentsCount;
    private Integer questionsCount;
    private String region;
    private String mainIncomeType;
    private Boolean questionsAllowed;
    private Integer activeLoansCount;
    private Boolean insuranceActive;
    private List<InsuranceHistory> insuranceHistory = null;
    private String countryOfOrigin;
    private String currency;
    private Boolean insuredInFuture;
    private Boolean additionallyInsured;
    private Double annuityWithInsurance;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
