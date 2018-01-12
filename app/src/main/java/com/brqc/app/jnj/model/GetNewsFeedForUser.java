package com.brqc.app.jnj.model;

/**
 * Created by ajay on 1/8/2018.
 */

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetNewsFeedForUser implements Parcelable {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Msg")
    @Expose
    private String msg;
    @SerializedName("NewsFeed")
    @Expose
    private List<NewsFeed> newsFeed = null;
    public final static Parcelable.Creator<GetNewsFeedForUser> CREATOR = new Creator<GetNewsFeedForUser>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetNewsFeedForUser createFromParcel(Parcel in) {
            return new GetNewsFeedForUser(in);
        }

        public GetNewsFeedForUser[] newArray(int size) {
            return (new GetNewsFeedForUser[size]);
        }

    };

    protected GetNewsFeedForUser(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.msg = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.newsFeed, (NewsFeed.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public GetNewsFeedForUser() {
    }

    /**
     * @param newsFeed
     * @param status
     * @param msg
     */
    public GetNewsFeedForUser(String status, String msg, List<NewsFeed> newsFeed) {
        super();
        this.status = status;
        this.msg = msg;
        this.newsFeed = newsFeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsFeed> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<NewsFeed> newsFeed) {
        this.newsFeed = newsFeed;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(msg);
        dest.writeList(newsFeed);
    }

    public int describeContents() {
        return 0;
    }


    public class HealthAuthority implements Parcelable {

        @SerializedName("HAuthorityId")
        @Expose
        private Long hAuthorityId;
        @SerializedName("HAuthorityValue")
        @Expose
        private String hAuthorityValue;
        public final Parcelable.Creator<HealthAuthority> CREATOR = new Creator<HealthAuthority>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public HealthAuthority createFromParcel(Parcel in) {
                return new HealthAuthority(in);
            }

            public HealthAuthority[] newArray(int size) {
                return (new HealthAuthority[size]);
            }

        };

        protected HealthAuthority(Parcel in) {
            this.hAuthorityId = ((Long) in.readValue((Long.class.getClassLoader())));
            this.hAuthorityValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public HealthAuthority() {
        }

        /**
         * @param hAuthorityId
         * @param hAuthorityValue
         */
        public HealthAuthority(Long hAuthorityId, String hAuthorityValue) {
            super();
            this.hAuthorityId = hAuthorityId;
            this.hAuthorityValue = hAuthorityValue;
        }

        public Long getHAuthorityId() {
            return hAuthorityId;
        }

        public void setHAuthorityId(Long hAuthorityId) {
            this.hAuthorityId = hAuthorityId;
        }

        public String getHAuthorityValue() {
            return hAuthorityValue;
        }

        public void setHAuthorityValue(String hAuthorityValue) {
            this.hAuthorityValue = hAuthorityValue;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(hAuthorityId);
            dest.writeValue(hAuthorityValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class NewsFeed implements Parcelable {

        @SerializedName("NewsItemID")
        @Expose
        private Long newsItemID;
        @SerializedName("NewsItemURL")
        @Expose
        private String newsItemURL;
        @SerializedName("NewsTitle")
        @Expose
        private String newsTitle;
        @SerializedName("Description")
        @Expose
        private String description;
        @SerializedName("PublishDate")
        @Expose
        private String publishDate;
        @SerializedName("Regions")
        @Expose
        private List<Region> regions = null;
        @SerializedName("FunctionalArea")
        @Expose
        private List<FunctionalArea> functionalArea = null;
        @SerializedName("EnforcementAction")
        @Expose
        private List<EnforcementAction> enforcementAction = null;
        @SerializedName("HealthAuthority")
        @Expose
        private List<HealthAuthority> healthAuthority = null;
        @SerializedName("Likes")
        @Expose
        private Long likes;
        @SerializedName("NewsImageURL")
        @Expose
        private String newsImageURL;
        public final Parcelable.Creator<NewsFeed> CREATOR = new Creator<NewsFeed>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public NewsFeed createFromParcel(Parcel in) {
                return new NewsFeed(in);
            }

            public NewsFeed[] newArray(int size) {
                return (new NewsFeed[size]);
            }

        };

        protected NewsFeed(Parcel in) {
            this.newsItemID = ((Long) in.readValue((Long.class.getClassLoader())));
            this.newsItemURL = ((String) in.readValue((String.class.getClassLoader())));
            this.newsTitle = ((String) in.readValue((String.class.getClassLoader())));
            this.description = ((String) in.readValue((String.class.getClassLoader())));
            this.publishDate = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.regions, (Region.class.getClassLoader()));
            in.readList(this.functionalArea, (FunctionalArea.class.getClassLoader()));
            in.readList(this.enforcementAction, (EnforcementAction.class.getClassLoader()));
            in.readList(this.healthAuthority, (HealthAuthority.class.getClassLoader()));
            this.likes = ((Long) in.readValue((Long.class.getClassLoader())));
            this.newsImageURL = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public NewsFeed() {
        }

        /**
         * @param newsImageURL
         * @param description
         * @param likes
         * @param newsItemID
         * @param healthAuthority
         * @param newsItemURL
         * @param regions
         * @param enforcementAction
         * @param publishDate
         * @param newsTitle
         * @param functionalArea
         */
        public NewsFeed(Long newsItemID, String newsItemURL, String newsTitle, String description, String publishDate, List<Region> regions, List<FunctionalArea> functionalArea, List<EnforcementAction> enforcementAction, List<HealthAuthority> healthAuthority, Long likes, String newsImageURL) {
            super();
            this.newsItemID = newsItemID;
            this.newsItemURL = newsItemURL;
            this.newsTitle = newsTitle;
            this.description = description;
            this.publishDate = publishDate;
            this.regions = regions;
            this.functionalArea = functionalArea;
            this.enforcementAction = enforcementAction;
            this.healthAuthority = healthAuthority;
            this.likes = likes;
            this.newsImageURL = newsImageURL;
        }

        public Long getNewsItemID() {
            return newsItemID;
        }

        public void setNewsItemID(Long newsItemID) {
            this.newsItemID = newsItemID;
        }

        public String getNewsItemURL() {
            return newsItemURL;
        }

        public void setNewsItemURL(String newsItemURL) {
            this.newsItemURL = newsItemURL;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public List<Region> getRegions() {
            return regions;
        }

        public void setRegions(List<Region> regions) {
            this.regions = regions;
        }

        public List<FunctionalArea> getFunctionalArea() {
            return functionalArea;
        }

        public void setFunctionalArea(List<FunctionalArea> functionalArea) {
            this.functionalArea = functionalArea;
        }

        public List<EnforcementAction> getEnforcementAction() {
            return enforcementAction;
        }

        public void setEnforcementAction(List<EnforcementAction> enforcementAction) {
            this.enforcementAction = enforcementAction;
        }

        public List<HealthAuthority> getHealthAuthority() {
            return healthAuthority;
        }

        public void setHealthAuthority(List<HealthAuthority> healthAuthority) {
            this.healthAuthority = healthAuthority;
        }

        public Long getLikes() {
            return likes;
        }

        public void setLikes(Long likes) {
            this.likes = likes;
        }

        public String getNewsImageURL() {
            return newsImageURL;
        }

        public void setNewsImageURL(String newsImageURL) {
            this.newsImageURL = newsImageURL;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(newsItemID);
            dest.writeValue(newsItemURL);
            dest.writeValue(newsTitle);
            dest.writeValue(description);
            dest.writeValue(publishDate);
            dest.writeList(regions);
            dest.writeList(functionalArea);
            dest.writeList(enforcementAction);
            dest.writeList(healthAuthority);
            dest.writeValue(likes);
            dest.writeValue(newsImageURL);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class Region implements Parcelable {

        @SerializedName("RegionId")
        @Expose
        private Long regionId;
        @SerializedName("RegionValue")
        @Expose
        private String regionValue;
        public final Parcelable.Creator<Region> CREATOR = new Creator<Region>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Region createFromParcel(Parcel in) {
                return new Region(in);
            }

            public Region[] newArray(int size) {
                return (new Region[size]);
            }

        };

        protected Region(Parcel in) {
            this.regionId = ((Long) in.readValue((Long.class.getClassLoader())));
            this.regionValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public Region() {
        }

        /**
         * @param regionValue
         * @param regionId
         */
        public Region(Long regionId, String regionValue) {
            super();
            this.regionId = regionId;
            this.regionValue = regionValue;
        }

        public Long getRegionId() {
            return regionId;
        }

        public void setRegionId(Long regionId) {
            this.regionId = regionId;
        }

        public String getRegionValue() {
            return regionValue;
        }

        public void setRegionValue(String regionValue) {
            this.regionValue = regionValue;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(regionId);
            dest.writeValue(regionValue);
        }

        public int describeContents() {
            return 0;
        }


    }


    public class EnforcementAction implements Parcelable {

        @SerializedName("EActionId")
        @Expose
        private Long eActionId;
        @SerializedName("EActionValue")
        @Expose
        private String eActionValue;
        public final Parcelable.Creator<EnforcementAction> CREATOR = new Creator<EnforcementAction>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public EnforcementAction createFromParcel(Parcel in) {
                return new EnforcementAction(in);
            }

            public EnforcementAction[] newArray(int size) {
                return (new EnforcementAction[size]);
            }

        };

        protected EnforcementAction(Parcel in) {
            this.eActionId = ((Long) in.readValue((Long.class.getClassLoader())));
            this.eActionValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public EnforcementAction() {
        }

        /**
         * @param eActionId
         * @param eActionValue
         */
        public EnforcementAction(Long eActionId, String eActionValue) {
            super();
            this.eActionId = eActionId;
            this.eActionValue = eActionValue;
        }

        public Long getEActionId() {
            return eActionId;
        }

        public void setEActionId(Long eActionId) {
            this.eActionId = eActionId;
        }

        public String getEActionValue() {
            return eActionValue;
        }

        public void setEActionValue(String eActionValue) {
            this.eActionValue = eActionValue;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(eActionId);
            dest.writeValue(eActionValue);
        }

        public int describeContents() {
            return 0;
        }

    }


    public class FunctionalArea implements Parcelable {

        @SerializedName("FAreaId")
        @Expose
        private Long fAreaId;
        @SerializedName("FAreaValue")
        @Expose
        private String fAreaValue;
        public final Parcelable.Creator<FunctionalArea> CREATOR = new Creator<FunctionalArea>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public FunctionalArea createFromParcel(Parcel in) {
                return new FunctionalArea(in);
            }

            public FunctionalArea[] newArray(int size) {
                return (new FunctionalArea[size]);
            }

        };

        protected FunctionalArea(Parcel in) {
            this.fAreaId = ((Long) in.readValue((Long.class.getClassLoader())));
            this.fAreaValue = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public FunctionalArea() {
        }

        /**
         * @param fAreaId
         * @param fAreaValue
         */
        public FunctionalArea(Long fAreaId, String fAreaValue) {
            super();
            this.fAreaId = fAreaId;
            this.fAreaValue = fAreaValue;
        }

        public Long getFAreaId() {
            return fAreaId;
        }

        public void setFAreaId(Long fAreaId) {
            this.fAreaId = fAreaId;
        }

        public String getFAreaValue() {
            return fAreaValue;
        }

        public void setFAreaValue(String fAreaValue) {
            this.fAreaValue = fAreaValue;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(fAreaId);
            dest.writeValue(fAreaValue);
        }

        public int describeContents() {
            return 0;
        }

    }
}
