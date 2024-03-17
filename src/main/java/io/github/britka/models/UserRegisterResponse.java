
package io.github.britka.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegisterResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("localId")
    @Expose
    private String localId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("providerUserInfo")
    @Expose
    private List<ProviderUserInfo> providerUserInfo;
    @SerializedName("passwordHash")
    @Expose
    private String passwordHash;
    @SerializedName("emailVerified")
    @Expose
    private Boolean emailVerified;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserRegisterResponse() {
    }

    /**
     *
     * @param emailVerified
     * @param providerUserInfo
     * @param kind
     * @param displayName
     * @param localId
     * @param email
     * @param passwordHash
     */
    public UserRegisterResponse(String kind, String localId, String email, String displayName, List<ProviderUserInfo> providerUserInfo, String passwordHash, Boolean emailVerified) {
        super();
        this.kind = kind;
        this.localId = localId;
        this.email = email;
        this.displayName = displayName;
        this.providerUserInfo = providerUserInfo;
        this.passwordHash = passwordHash;
        this.emailVerified = emailVerified;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public UserRegisterResponse withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public UserRegisterResponse withLocalId(String localId) {
        this.localId = localId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRegisterResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserRegisterResponse withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public List<ProviderUserInfo> getProviderUserInfo() {
        return providerUserInfo;
    }

    public void setProviderUserInfo(List<ProviderUserInfo> providerUserInfo) {
        this.providerUserInfo = providerUserInfo;
    }

    public UserRegisterResponse withProviderUserInfo(List<ProviderUserInfo> providerUserInfo) {
        this.providerUserInfo = providerUserInfo;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserRegisterResponse withPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public UserRegisterResponse withEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserRegisterResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("localId");
        sb.append('=');
        sb.append(((this.localId == null)?"<null>":this.localId));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("providerUserInfo");
        sb.append('=');
        sb.append(((this.providerUserInfo == null)?"<null>":this.providerUserInfo));
        sb.append(',');
        sb.append("passwordHash");
        sb.append('=');
        sb.append(((this.passwordHash == null)?"<null>":this.passwordHash));
        sb.append(',');
        sb.append("emailVerified");
        sb.append('=');
        sb.append(((this.emailVerified == null)?"<null>":this.emailVerified));
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
        result = ((result* 31)+((this.emailVerified == null)? 0 :this.emailVerified.hashCode()));
        result = ((result* 31)+((this.providerUserInfo == null)? 0 :this.providerUserInfo.hashCode()));
        result = ((result* 31)+((this.kind == null)? 0 :this.kind.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.passwordHash == null)? 0 :this.passwordHash.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserRegisterResponse) == false) {
            return false;
        }
        UserRegisterResponse rhs = ((UserRegisterResponse) other);
        return ((((((((this.emailVerified == rhs.emailVerified)||((this.emailVerified!= null)&&this.emailVerified.equals(rhs.emailVerified)))&&((this.providerUserInfo == rhs.providerUserInfo)||((this.providerUserInfo!= null)&&this.providerUserInfo.equals(rhs.providerUserInfo))))&&((this.kind == rhs.kind)||((this.kind!= null)&&this.kind.equals(rhs.kind))))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.passwordHash == rhs.passwordHash)||((this.passwordHash!= null)&&this.passwordHash.equals(rhs.passwordHash))));
    }

}
