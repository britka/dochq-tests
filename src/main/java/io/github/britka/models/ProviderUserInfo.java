
package io.github.britka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProviderUserInfo {

    @SerializedName("providerId")
    @Expose
    private String providerId;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("federatedId")
    @Expose
    private String federatedId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("rawId")
    @Expose
    private String rawId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProviderUserInfo() {
    }

    /**
     *
     * @param providerId
     * @param displayName
     * @param federatedId
     * @param rawId
     * @param email
     */
    public ProviderUserInfo(String providerId, String displayName, String federatedId, String email, String rawId) {
        super();
        this.providerId = providerId;
        this.displayName = displayName;
        this.federatedId = federatedId;
        this.email = email;
        this.rawId = rawId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public ProviderUserInfo withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ProviderUserInfo withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getFederatedId() {
        return federatedId;
    }

    public void setFederatedId(String federatedId) {
        this.federatedId = federatedId;
    }

    public ProviderUserInfo withFederatedId(String federatedId) {
        this.federatedId = federatedId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProviderUserInfo withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId;
    }

    public ProviderUserInfo withRawId(String rawId) {
        this.rawId = rawId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProviderUserInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("providerId");
        sb.append('=');
        sb.append(((this.providerId == null)?"<null>":this.providerId));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("federatedId");
        sb.append('=');
        sb.append(((this.federatedId == null)?"<null>":this.federatedId));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("rawId");
        sb.append('=');
        sb.append(((this.rawId == null)?"<null>":this.rawId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.providerId == null)? 0 :this.providerId.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.federatedId == null)? 0 :this.federatedId.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.rawId == null)? 0 :this.rawId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProviderUserInfo) == false) {
            return false;
        }
        ProviderUserInfo rhs = ((ProviderUserInfo) other);
        return ((((((this.providerId == rhs.providerId)||((this.providerId!= null)&&this.providerId.equals(rhs.providerId)))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))))&&((this.federatedId == rhs.federatedId)||((this.federatedId!= null)&&this.federatedId.equals(rhs.federatedId))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.rawId == rhs.rawId)||((this.rawId!= null)&&this.rawId.equals(rhs.rawId))));
    }

}
